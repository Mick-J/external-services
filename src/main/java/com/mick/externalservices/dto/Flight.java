package com.mick.externalservices.dto;

import java.time.LocalDate;

public record Flight(String flightNumber,
                     String airline,
                     int price,
                     LocalDate tripDate,
                     int flightDurationInMinutes) {
}
