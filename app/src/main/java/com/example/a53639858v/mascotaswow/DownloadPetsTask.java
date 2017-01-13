package com.example.a53639858v.mascotaswow;

import android.os.AsyncTask;
import android.util.Log;


public class DownloadPetsTask extends AsyncTask<Void , Void , String> {

    public AsyncResponse delegate;

    @Override
    protected String doInBackground(Void ... voids) {

        PetsAPI api = new PetsAPI();
        String result = api.getPets();

        Log.i("Mascotas" , result);

        return result;
    }


    @Override
    protected void onPostExecute(String result) {

        Log.i(null, "Mascotas onpostexecute " + result);

        delegate.processFinish(result);
    }
}
