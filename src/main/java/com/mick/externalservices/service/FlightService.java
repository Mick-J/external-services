package com.mick.externalservices.service;

import com.mick.externalservices.dto.Flight;
import com.mick.externalservices.dto.FlightReservationRequest;
import com.mick.externalservices.dto.FlightReservationResponse;
import com.mick.externalservices.utils.CommonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.util.*;

@Service
public class FlightService {

    private static final Logger log = LoggerFactory.getLogger(FlightService.class);

    private static final Map<String, Map<String, List<Flight>>> EXISTING_Flight = new LinkedHashMap<>();
    private static final Map<String, Map<String, List<FlightReservationResponse>>> RESERVATIONS = new HashMap<>();
    private static final LocalDate MOCK_DATE = LocalDate.now();
    private static final Random RANDOM = new Random();
    private static final Map<String, String> AIRPORT_COUNTRIES = new HashMap<>();

    // Pool of airlines to randomly assign
    private static final String[] AIRLINES = {
            "Delta Air Lines", "United Airlines", "Lufthansa", "Air France",
            "South African Airways", "Air Peace", "Air China", "IndiGo", "Qantas"
    };

    static {
        // USA
        AIRPORT_COUNTRIES.put("LAS", "US"); AIRPORT_COUNTRIES.put("ATL", "US");
        AIRPORT_COUNTRIES.put("JFK", "US"); AIRPORT_COUNTRIES.put("SFO", "US");
        // Brazil
        AIRPORT_COUNTRIES.put("GRU", "BR"); AIRPORT_COUNTRIES.put("GIG", "BR");
        AIRPORT_COUNTRIES.put("BSB", "BR"); AIRPORT_COUNTRIES.put("SSA", "BR");
        // France
        AIRPORT_COUNTRIES.put("CDG", "FR"); AIRPORT_COUNTRIES.put("NCE", "FR");
        AIRPORT_COUNTRIES.put("MRS", "FR"); AIRPORT_COUNTRIES.put("BOD", "FR");
        // Germany
        AIRPORT_COUNTRIES.put("FRA", "DE"); AIRPORT_COUNTRIES.put("MUC", "DE");
        AIRPORT_COUNTRIES.put("BER", "DE"); AIRPORT_COUNTRIES.put("DUS", "DE");
        // South Africa
        AIRPORT_COUNTRIES.put("JNB", "ZA"); AIRPORT_COUNTRIES.put("CPT", "ZA");
        AIRPORT_COUNTRIES.put("DUR", "ZA"); AIRPORT_COUNTRIES.put("HLA", "ZA");
        // Nigeria
        AIRPORT_COUNTRIES.put("LOS", "NG"); AIRPORT_COUNTRIES.put("ABV", "NG");
        AIRPORT_COUNTRIES.put("PHC", "NG"); AIRPORT_COUNTRIES.put("ENU", "NG");
        // China
        AIRPORT_COUNTRIES.put("PEK", "CN"); AIRPORT_COUNTRIES.put("PVG", "CN");
        AIRPORT_COUNTRIES.put("CAN", "CN"); AIRPORT_COUNTRIES.put("SZX", "CN");
        // India
        AIRPORT_COUNTRIES.put("DEL", "IN"); AIRPORT_COUNTRIES.put("BOM", "IN");
        AIRPORT_COUNTRIES.put("BLR", "IN"); AIRPORT_COUNTRIES.put("HYD", "IN");
        // Australia
        AIRPORT_COUNTRIES.put("SYD", "AU"); AIRPORT_COUNTRIES.put("MEL", "AU");
        AIRPORT_COUNTRIES.put("BNE", "AU"); AIRPORT_COUNTRIES.put("ADL", "AU");
    }

    public List<Flight> searchFlight(String departureAirportCode, String arrivalAirportCode) {
        CommonUtils.sleep(Duration.ofMillis(500));
        List<Flight> flightList = new ArrayList<>();

        if (isNotValidRoute(departureAirportCode, arrivalAirportCode)) {
            return flightList;
        }
        //
        var record = EXISTING_Flight.get(departureAirportCode);
        if (record == null) {
            flightList = generateFlights(departureAirportCode, arrivalAirportCode);
            EXISTING_Flight.computeIfAbsent(departureAirportCode, k-> new HashMap<>())
                    .put(arrivalAirportCode, flightList);
            return flightList;
        }
        flightList = record.get(arrivalAirportCode);

        if (flightList != null) {
           return EXISTING_Flight.get(departureAirportCode).get(arrivalAirportCode);
        }

        flightList = generateFlights(departureAirportCode, arrivalAirportCode);
        EXISTING_Flight.put(departureAirportCode, new HashMap<>())
                .put(arrivalAirportCode, flightList);
        return flightList;
    }

    public FlightReservationResponse reserveFlight(FlightReservationRequest request) {

        List<Flight> flights = searchFlight(request.departure(), request.arrival());
        if (flights.isEmpty()) {
           throw new IllegalArgumentException("No flights found for "
                   + request.departure() + " to " + request.arrival());
        }

        Flight flight = flights
                .stream()
//                .filter(f -> f.flightNumber().equalsIgnoreCase(request.flightNumber()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(
                        "Flight not found: " + request.departure() + " -> " + request.arrival()
                                + ", " + request.tripDate())
                );

        FlightReservationResponse reservation = new FlightReservationResponse(
                UUID.randomUUID(),
                request.departure(),
                request.arrival(),
                flight.flightNumber(),
                request.tripDate(),
                flight.price()
        );

        RESERVATIONS
                .computeIfAbsent(request.departure(), ignored -> new LinkedHashMap<>())
                .computeIfAbsent(request.arrival(), ignored -> new ArrayList<>())
                .add(reservation);

        return reservation;
    }
    /* **********************************************************************
        HELPERS
    **********************************************************************  */
    private boolean isNotValidRoute(String departureAirportCode, String arrivalAirportCode) {
        String dep = CommonUtils.normalize(departureAirportCode);
        String arr = CommonUtils.normalize(arrivalAirportCode);
        return dep.equals(arr);
    }
    public List<Flight> generateFlights(String departureAirportCode, String arrivalAirportCode) {
        List<Flight> flights = new ArrayList<>();

        //
        String dep = CommonUtils.normalize(departureAirportCode);
        String arr = CommonUtils.normalize(arrivalAirportCode);

        // Validate codes exist in our setup
        if (!AIRPORT_COUNTRIES.containsKey(dep) || !AIRPORT_COUNTRIES.containsKey(arr) || dep.equals(arr)) {
            return flights;
        }

        boolean isDomestic = AIRPORT_COUNTRIES.get(dep).equals(AIRPORT_COUNTRIES.get(arr));

        // Determine realistic flight duration boundaries (in minutes)
        int minDuration;
        int maxDuration;
        int minPrice;
        int maxPrice;

        if (isDomestic) {
            minDuration = 60;   // 1 hour
            maxDuration = 360;  // 6 hours (handling large countries like US, China, Australia)
            minPrice = 50;
            maxPrice = 400;
        } else {
            minDuration = 480;  // 8 hours
            maxDuration = 1080; // 18 hours (long-haul/transcontinental)
            minPrice = 500;
            maxPrice = 2500;
        }

        // Generate between 2 to 5 random flights
        int flightCount = RANDOM.nextInt(4) + 2;

        for (int i = 0; i < flightCount; i++) {
            String flightNumber = dep.substring(0, 2) + (RANDOM.nextInt(9000) + 1000);
            String airline = AIRLINES[RANDOM.nextInt(AIRLINES.length)];
            int price = RANDOM.nextInt((maxPrice - minPrice) + 1) + minPrice;
            int duration = RANDOM.nextInt((maxDuration - minDuration) + 1) + minDuration;

            flights.add(new Flight(flightNumber, airline, price, MOCK_DATE, duration));
        }

        return flights;
    }
}
