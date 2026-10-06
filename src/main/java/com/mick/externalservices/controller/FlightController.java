package com.mick.externalservices.controller;

import com.mick.externalservices.dto.Flight;
import com.mick.externalservices.dto.FlightReservationRequest;
import com.mick.externalservices.dto.FlightReservationResponse;
import com.mick.externalservices.service.FlightService;
import com.mick.externalservices.utils.AirportCode;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flight")
@Tag(name = "Search-Reservation-Flight", description = "Flight search reservation service Providers")
public class FlightController {

    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    // GET /flight/search/{departureAirportCode}/{arrivalAirportCode}
    @GetMapping("/search/{departureAirportCode}/{arrivalAirportCode}")
    @Operation(
            description = "Provides the list of available flights for the given search criteria.<br/>" +
                            "This service takes 500ms to respond.",
            summary = " Flights search Service")
    public List<Flight> searchFlight(
            @Parameter(description = "Departure airport Code") @PathVariable AirportCode departureAirportCode,
            @Parameter(description = "Arrival airport Code") @PathVariable AirportCode arrivalAirportCode
    ) {
        return flightService.searchFlight(departureAirportCode.toString(), arrivalAirportCode.toString());
    }

    // POST /flight/reserve
    @Operation(
            description = "To reserve the flight, provide valid arrival airport code and the corresponding flight number.<br/>" +
                    "This service takes 500ms to respond.",
            summary = " Flight reservation Service")
    @PostMapping("/reserve")
    public FlightReservationResponse reserve(
            @Parameter(description = "Flight Reservation Request") @RequestBody FlightReservationRequest request
    ) {
        return flightService.reserveFlight(request);
    }
}
