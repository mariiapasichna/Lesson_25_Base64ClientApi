package com.mariiapasichna.api;

import com.google.gson.Gson;
import com.mariiapasichna.Main;
import com.mariiapasichna.model.Image;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;

public class ImageApi {
    private static ImageApi instance;
    private MediaType mediaType = MediaType.parse("application/json");
    private Gson gson = new Gson();
    private String url = Main.URL;

    public static synchronized ImageApi getInstance() {
        if (instance == null) {
            instance = new ImageApi();
        }
        return instance;
    }

    private ImageApi() {
    }

    private Response getResponse(String method, RequestBody body, String url) {
        try {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(url)
                    .method(method, body)
                    .build();
            return client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Response createImage(Image image) {
        RequestBody body = RequestBody.create(gson.toJson(image), mediaType);
        return getResponse("POST", body, url);
    }

    public Response getListImages() {
        return getResponse("GET", null, url);
    }
}