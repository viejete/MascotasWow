package com.example.a53639858v.mascotaswow;

import android.net.Uri;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

public class PetsAPI {

    private final String BASE_URL = "https://us.api.battle.net/wow/pet/?locale=en_US&apikey=52pptr4xv6upvcr7gt2bt89gh44txyhp";
    private final String API_KEY = "52pptr4xv6upvcr7gt2bt89gh44txyhp";

    String getPets() {

        Uri builtUri = Uri.parse(BASE_URL)
                .buildUpon()
                .build();

        String url = builtUri.toString();

        try {

            String jsonResponse = HttpUtils.get(url);
            Log.i("Que esta pasando" , jsonResponse);
            return jsonResponse;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public ArrayList<Pet> pasarPets(String responsePets){
        // Meter todo en los arrays
        ArrayList<Pet> pets = new ArrayList<>();

        try {
            JSONObject data = new JSONObject(responsePets);
            JSONArray jsonPets = data.getJSONArray("pets");
            for (int i = 0; i < jsonPets.length(); i++) {
                JSONObject jsonPet = jsonPets.getJSONObject(i);
                JSONObject jsonStats = jsonPet.getJSONObject("stats");

                Pet pet = new Pet();
                Stats stat = new Stats();
                pet.setCanBattle(jsonPet.getBoolean("canBattle"));
                pet.setName(jsonPet.getString("name"));
                pet.setId(jsonPet.getInt("creatureId"));
                pet.setFamily(jsonPet.getString("family"));
                pet.setIcon(jsonPet.getString("icon"));
                pet.setStrongAgainst(jsonPet.getJSONArray("strongAgainst").getString(0));
                pet.setTypeId(jsonPet.getInt("typeId"));
                pet.setWeakAgainst(jsonPet.getJSONArray("weakAgainst").getString(0));

                // Stats:
                stat.setSpeciesId(jsonStats.getInt("speciesId"));
                stat.setBreedId(jsonStats.getInt("breedId"));
                stat.setPetQualityId(jsonStats.getInt("petQualityId"));
                stat.setLevel(jsonStats.getInt("level"));
                stat.setHealth(jsonStats.getInt("health"));
                stat.setPower(jsonStats.getInt("power"));
                stat.setSpeed(jsonStats.getInt("speed"));

                pet.setStats(stat);

                pets.add(pet);
            }
        } catch (JSONException e) {
            Log.i("Error con el JSON" , e.getMessage());
        }

        return pets;
    }


}



