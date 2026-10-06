package com.mick.externalservices.dto;

import java.time.LocalDate;

public record Event(String name,
                    String description,
                    LocalDate tripDate) {
}
