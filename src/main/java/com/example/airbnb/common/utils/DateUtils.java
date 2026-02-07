package com.example.airbnb.common.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public final class DateUtils {
    private DateUtils() {
    }

    public static List<LocalDate> getDatesBetween(LocalDate startInclusive, LocalDate endExclusive) {
        List<LocalDate> dates = new ArrayList<>();
        for (LocalDate d = startInclusive; d.isBefore(endExclusive); d = d.plusDays(1)) {
            dates.add(d);
        }
        return dates;
    }

    public static boolean overlaps(LocalDate srart1, LocalDate end1, LocalDate start2, LocalDate end2) {
        return srart1.isBefore(end2) && start2.isBefore(end1);
    }
}
