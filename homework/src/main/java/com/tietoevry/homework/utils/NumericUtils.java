package com.tietoevry.homework.utils;

import java.math.BigDecimal;

public class NumericUtils {

    public static boolean isPositive(Integer value) {
        return value > 0;
    }

    public static boolean isPositive(BigDecimal value) {
        return value.compareTo(BigDecimal.ZERO) > 0;
    }

}