package com.mariiapasichna;

import com.mariiapasichna.api.ImageApi;
import com.mariiapasichna.model.Image;
import okhttp3.Response;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

public class Main {

    //public static final String URL = "http://localhost:" + System.getProperty("config") + "/Lesson_25_mariiapasichna/database/";
    public static final String URL = "http://164.68.101.149:12345/Lesson_25_mariiapasichna/database/";

    public static final String PATH_INPUT = "/Users/user/IdeaProjects/Lesson_25_Base64ClientApi/Image.jpg";

    public static void main(String[] args) {
        ImageApi imageApi = ImageApi.getInstance();
        printResponse(imageApi.createImage(new Image("Post", encodeFileToString())));
        printResponse(imageApi.getListImages());
    }

    private static String encodeFileToString() {
        try {
            byte[] fileContent = FileUtils.readFileToByteArray(new File(PATH_INPUT));
            return Base64.getEncoder().encodeToString(fileContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void printResponse(Response response) {
        try {
            System.out.println("Response code: " + response.code() + ". Response body: " + response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}