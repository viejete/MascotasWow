package com.example.a53639858v.mascotaswow;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;


public class DownloadPetsTask extends AsyncTask<Context, Void , String> {

    public AsyncResponse delegate;

    @Override
    protected String doInBackground(Context ... contexts) {

        PetsAPI api = new PetsAPI();
        return api.getPets();
    }


    @Override
    protected void onPostExecute(String result) {

        Log.i(null, "Mascotas onpostexecute " + result);

        delegate.processFinish(result);
    }
}
