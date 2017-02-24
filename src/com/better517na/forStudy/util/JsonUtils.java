package com.better517na.forStudy.util;

import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 
 * @author xuanwei
 *
 */
public final class JsonUtils {

    /**
     * Gson.
     */
    private static Gson gson = new GsonBuilder().serializeNulls().setDateFormat("yyyy-MM-dd").create();

    private JsonUtils() {
    }

    /**
     * TODO toJson.
     */
    public static String toJson(Object obj) {
        return gson.toJson(obj);
    }

    /**
     * TODO toObject.
     */
    public static <T> T toObject(String json, Class<T> classOfT) {
        return gson.fromJson(json, classOfT);
    }

    /**
     * TODO toObject.
     */
    public static <T> T toObject(String json, Type type) {
        return gson.fromJson(json, type);
    }
}
