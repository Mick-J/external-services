package com.mick.externalservices.utils;

import java.time.Duration;
import java.util.Locale;
import java.util.Objects;

public class CommonUtils {
    public static void sleep(Duration duration) {
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static String normalize(String airportCode) {
        Objects.requireNonNull(airportCode, "airportCode must not be null");
        return airportCode.trim().toUpperCase(Locale.ROOT);
    }
}
