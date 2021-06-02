package org.example.core;

public final class StringHelper {

     private StringHelper() {
         // private for utility class
     }

    public static String convertToUpperUnderscore(final String string) {
        return string.replaceAll("-", "_")
                .replaceAll("/", "_")
                .replaceAll(" ", "_").toUpperCase();
    }
}
