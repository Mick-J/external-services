package com.mick.externalservices.dto;

import java.time.LocalDate;

public record FlightReservationRequest(String departure,
                                       String arrival,
                                       LocalDate tripDate) {
}
