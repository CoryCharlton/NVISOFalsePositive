package com.ccswe.nvisofalsepositive;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public final class StringUtils {
    public static final String EMPTY = "";

    private StringUtils() {
        throw new UnsupportedOperationException("Cannot be instantiated");
    }

    public static String capitalize(final CharSequence string) {
        if (string == null) {
            return null;
        }

        return capitalize(string.toString());
    }

    public static String capitalize(final String string) {
        return capitalize(string, ' ');
    }

    public static String capitalize(final String string, final char... delimiters) {
        if (string == null) {
            return null;
        }

        final int delimiterLength = delimiters == null ? -1 : delimiters.length;
        if (isNullOrWhiteSpace(string) || delimiterLength == 0) {
            return string;
        }

        final char[] buffer = string.toCharArray();
        boolean capitalizeNext = true;

        for (int i = 0; i < buffer.length; i++) {
            final char ch = buffer[i];
            if (isDelimiter(ch, delimiters)) {
                capitalizeNext = true;
            } else if (capitalizeNext) {
                buffer[i] = Character.toTitleCase(ch);
                capitalizeNext = false;
            }
        }

        return new String(buffer);
    }

    public static boolean equals(@Nullable String string1, @Nullable String string2) {
        if (isNullOrWhiteSpace(string1) && isNullOrWhiteSpace(string2)) {
            return true;
        } else if (isNullOrWhiteSpace(string1)) {
            return false;
        } else if (isNullOrWhiteSpace(string2)) {
            return false;
        }

        return string1.equals(string2);
    }

    private static boolean isDelimiter(final char character, final char[] delimiters) {
        if (delimiters == null) {
            return Character.isWhitespace(character);
        }
        for (final char delimiter : delimiters) {
            if (character == delimiter) {
                return true;
            }
        }
        return false;
    }

    public static boolean isMatch(@NonNull String string, @Nullable CharSequence filter) {
        if (isNullOrWhiteSpace(filter)) {
            return true;
        }

        return isMatch(string, filter.toString());
    }

    public static boolean isMatch(@NonNull String string, @NonNull String filter) {
        if (isNullOrWhiteSpace(filter)) {
            return true;
        }

        return string.toLowerCase().contains(filter.toLowerCase());
    }

    public static boolean isNullOrWhiteSpace(CharSequence value) {
        return (value == null || isNullOrWhiteSpace(value.toString()));
    }

    public static boolean isNullOrWhiteSpace(String value) {
        if (value == null) {
            return true;
        }

        final int valueLength = value.length();
        for (int i = 0; i < valueLength; i++) {
            if (!Character.isWhitespace(value.charAt(i))) {
                return false;
            }
        }

        return true;
    }
}

