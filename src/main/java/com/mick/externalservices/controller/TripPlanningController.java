package com.mick.externalservices.controller;

import com.mick.externalservices.dto.*;
import com.mick.externalservices.service.TripPlanningService;
import com.mick.externalservices.utils.AirportCode;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/trip-planning")
@Tag(name = "Trip-planning", description = "Trip Planning Service Providers")
public class TripPlanningController {

    private final TripPlanningService tripPlanningService;

    public TripPlanningController(TripPlanningService tripPlanningService) {
        this.tripPlanningService = tripPlanningService;
    }

    //
    @GetMapping("/accommodations/{airportCode}")
    @Operation(
            description = "Provides the list of available accommodations near the given airport code for the user to plan their trip.",
            summary = " Accommodation Service")
    public List<Accommodation> getDestinationAccommodations(
            @Parameter(description = "Airport code") @PathVariable AirportCode airportCode) {
        return tripPlanningService.getDestinationAccommodations(airportCode.toString());
    }

    //
    @GetMapping("/events/{airportCode}")
    @Operation(
            description = "Provides information about cultural and recreational events, such as shows, exhibitions, and performances, in the designated city linked to the provided airport code, assisting users with trip planning.",
            summary = " events Service")
    public List<Event> getDestinationEvent(
            @Parameter(description = "Airport code") @PathVariable AirportCode airportCode
    ) {
        return tripPlanningService.getDestinationEvent(airportCode.toString());
    }

    //
    @GetMapping("/local-recommendations/{airportCode}")
    @Operation(
            description = "Retrieve local recommendations for restaurants and sightseeing in the city associated with the provided airport code. This API helps users discover popular dining options and tourist attractions, enhancing their travel experience.",
            summary = " local-recommendations Service")
    public LocalRecommendations getLocalRecommendations(
            @Parameter(description = "Airport code") @PathVariable AirportCode airportCode
    ) {
        return tripPlanningService.getLocalRecommendations(airportCode.toString());
    }

    //
    @GetMapping("/transportation/{airportCode}")
    @Operation(
            description = "Access transportation options for the city associated with the provided airport code, including car rentals and public transportation.",
            summary = " transportation Service")
    public Transportation getDestinationTransportation(
            @Parameter(description = "Airport code") @PathVariable AirportCode airportCode
    ) {
        return tripPlanningService.getDestinationTransportation(airportCode.toString());
    }

    //
    @GetMapping("/weather/{airportCode}")
    @Operation(
            description = "Provides the weather information for the specified city associated with the given airport code, helping users in trip planning.",
            summary = " weather Service")
    public Weather getDestinationWeather(
            @Parameter(description = "Airport code") @PathVariable AirportCode airportCode
    ) {
        return tripPlanningService.getDestinationWeather(airportCode.toString());
    }
}
