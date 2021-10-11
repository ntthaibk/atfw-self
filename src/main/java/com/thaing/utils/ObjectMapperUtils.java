package com.thaing.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thaing.core.constant.EnvironmentConstant;
import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Paths;

public class ObjectMapperUtils {

    private ObjectMapperUtils() {
        throw new IllegalStateException(EnvironmentConstant.UTILITY_CLASS_EXCEPTION);
    }

    public static Gson getGsonInstance() {
        return new GsonBuilder().disableHtmlEscaping().excludeFieldsWithoutExposeAnnotation().create();
    }

    public static String toJsonString(Object obj) {
        return getGsonInstance().toJson(obj);
    }

    public static <T> T fromJsonString(String sJson, Class<T> t) {
        return getGsonInstance().fromJson(sJson, t);
    }

    public static <T> T fromJsonFile(String fileName, Class<T> t) {
        return getGsonInstance().fromJson(readJsonFileFromData(fileName), t);
    }

    @SneakyThrows
    public static BufferedReader readFile(String fileName, String folderPath, String fileExtension) {
        File file = new File(Paths.get(System.getProperty("user.dir"), folderPath, String.format("%s.%s", fileName, fileExtension)).toString());
        return new BufferedReader(new FileReader(file));
    }

    /*
    Quick way to adapt to the test
     */
    public static BufferedReader readJsonFileFromData(String fileName) {
        return readFile(fileName, "src/test/java/com/thaing/testdata", "json");
    }
}
