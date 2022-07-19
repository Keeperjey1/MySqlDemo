package de.jey.mysqldemo;

import android.content.Context;
import android.os.AsyncTask;

public class BackgroundWorker extends AsyncTask<String, Void, Void> {
    Context context;
    BackgroundWorker(Context ctx) {
        context = ctx;
    }
    @Override
    protected Void doInBackground(String... voids) {
        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(Void unused) {
        super.onPostExecute(unused);
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}
