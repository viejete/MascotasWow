package com.example.a53639858v.mascotaswow;

import android.net.Uri;

import java.io.IOException;

public class PetsAPI {

    private final String BASE_URL = "https://us.api.battle.net/wow/pet/?locale=en_US&apikey=";
    private final String API_KEY = "52pptr4xv6upvcr7gt2bt89gh44txyhp";

    String getPets() {

        Uri builtUri = Uri.parse(BASE_URL)
                .buildUpon()
                .appendPath(API_KEY)
                .build();

        String url = builtUri.toString();

        try {

            String JsonResponse = HttpUtils.get(url);
            return JsonResponse;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}



