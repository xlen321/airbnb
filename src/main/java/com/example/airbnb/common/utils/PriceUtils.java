package com.example.airbnb.common.utils;

import java.math.BigDecimal;

public class PriceUtils {
    private PriceUtils() {
    }

    public static BigDecimal sum(BigDecimal a, BigDecimal b) {
        return a.add(b);
    }

    public static BigDecimal multiply(BigDecimal amount, int nights) {
        return amount.multiply(BigDecimal.valueOf(nights));
    }
}
