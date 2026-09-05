package com.liverpool.orders.application.util;

import java.text.Normalizer;

public class StringUtils {

    public static String normalizeText(String text) {
        if (text == null) return "";
        String normalized = Normalizer.normalize(text, Normalizer.Form.NFD);
        return normalized.replaceAll("\\p{M}", "").toLowerCase().trim();
    }
}
