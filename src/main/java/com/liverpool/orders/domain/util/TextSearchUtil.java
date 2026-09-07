package com.liverpool.orders.domain.util;

import java.text.Normalizer;

public class TextSearchUtil {

    private TextSearchUtil() {}

    public static String normalize(String input) {
        if (input == null) return "";
        String clean = Normalizer.normalize(input, Normalizer.Form.NFD);
        clean = clean.replaceAll("\\p{M}", ""); // Elimina acentos/diacríticos
        clean = clean.replaceAll("[,.]", "");  // Elimina comas y puntos
        return clean.toLowerCase().trim();
    }

    public static boolean matches(String fieldText, String query) {
        if (fieldText == null || query == null || query.isBlank()) return false;

        String cleanField = normalize(fieldText);
        String cleanQuery = normalize(query);

        // 1. Coincidencia directa o parcial (Type-ahead)
        if (cleanField.contains(cleanQuery)) {
            return true;
        }

        // 2. Tolerancia a errores de ortografía si la búsqueda tiene al menos 3 caracteres
        if (cleanQuery.length() >= 3) {
            for (String word : cleanField.split("\\s+")) {
                if (computeLevenshteinDistance(word, cleanQuery) <= 2) {
                    return true;
                }
            }
        }

        return false;
    }

    private static int computeLevenshteinDistance(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i <= s1.length(); i++) dp[i][0] = i;
        for (int j = 0; j <= s2.length(); j++) dp[0][j] = j;

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                int cost = (s1.charAt(i - 1) == s2.charAt(j - 1)) ? 0 : 1;
                dp[i][j] = Math.min(
                        Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1),
                        dp[i - 1][j - 1] + cost
                );
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
