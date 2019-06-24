package com.ccswe.nvisofalsepositive;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.io.Serializable;
import java.util.Date;

public final class BundleUtils {

    private BundleUtils() {
        throw new UnsupportedOperationException("Cannot be instantiated");
    }

    public static boolean getBoolean(@Nullable Bundle bundle, @NonNull String key, boolean defaultValue) {
        return (bundle == null) ? defaultValue : bundle.getBoolean(key, defaultValue);
    }

    public static Bundle getBundle(@Nullable Bundle bundle, @NonNull String key) {
        return (bundle == null) ? null : bundle.getBundle(key);
    }

    @Nullable
    public static Date getDate(@Nullable Bundle bundle, @NonNull String key) {
        return getDate(bundle, key, null);
    }

    @Nullable
    public static Date getDate(@Nullable Bundle bundle, @NonNull String key, @Nullable Date defaultValue) {
        if (bundle == null) {
            return defaultValue;
        }

        final long milliseconds = bundle.getLong(key, -1);
        return (milliseconds > 0) ? new Date(milliseconds) : defaultValue;
    }

    public static int getInt(@Nullable Bundle bundle, @NonNull String key) {
        return getInt(bundle, key, 0);
    }

    public static int getInt(@Nullable Bundle bundle, @NonNull String key, int defaultValue) {
        return (bundle == null) ? defaultValue : bundle.getInt(key, defaultValue);
    }

    @SuppressWarnings("unchecked")
    public static <T extends Serializable> T  getSerializable(@Nullable Bundle bundle, @NonNull String key) {
        return (bundle == null) ? null : (T) bundle.getSerializable(key);
    }

    public static String getString(@Nullable Bundle bundle, @NonNull String key) {
        return getString(bundle, key, null);
    }

    public static String getString(@Nullable Bundle bundle, @NonNull String key, @Nullable String defaultValue) {
        return (bundle == null) ? defaultValue : bundle.getString(key, defaultValue);
    }

    public static void putDate(@NonNull Bundle bundle, @NonNull String key, Date value) {
        bundle.putLong(key, value != null ? value.getTime() : -1);
    }

    public static void putString(@NonNull Bundle bundle, @NonNull String key, String value) {
        bundle.putString(key, value);
    }
}


