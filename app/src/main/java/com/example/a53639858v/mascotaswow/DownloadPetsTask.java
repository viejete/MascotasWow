package com.example.a53639858v.mascotaswow;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.util.Log;


public class DownloadPetsTask extends AsyncTask<Context, Void , String> {

    public AsyncResponse delegate;

    @Override
    protected String doInBackground(Context ... contexts) {


        //Log.i("que pasee -> " , preferences.toString());


        PetsAPI api = new PetsAPI();
        String result = api.getPets();

        //Log.i("Mascotas" , result);

        return result;
    }


    @Override
    protected void onPostExecute(String result) {

        Log.i(null, "Mascotas onpostexecute " + result);

        delegate.processFinish(result);
    }
}
