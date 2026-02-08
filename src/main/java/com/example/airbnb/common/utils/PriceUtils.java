package com.example.airbnb.common.utils;

import java.math.BigDecimal;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PriceUtils {

    public static BigDecimal sum(BigDecimal a, BigDecimal b) {
        return a.add(b);
    }

    public static BigDecimal multiply(BigDecimal amount, int nights) {
        return amount.multiply(BigDecimal.valueOf(nights));
    }
}
