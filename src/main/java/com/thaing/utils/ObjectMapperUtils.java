package com.thaing.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thaing.core.constant.EnvironmentConstant;

public class ObjectMapperUtils {

    private ObjectMapperUtils() {
        throw new IllegalStateException(EnvironmentConstant.UTILITY_CLASS_EXCEPTION);
    }

    public static Gson getGsonInstance() {
        return new GsonBuilder().disableHtmlEscaping().create();
    }

    public static String toJsonString(Object obj) {
        return getGsonInstance().toJson(obj);
    }

    public static <T> T fromJsonString(String sJson, Class<T> t) {
        return getGsonInstance().fromJson(sJson, t);
    }

}
