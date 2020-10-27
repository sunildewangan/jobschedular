package com.cad.jobschedular;

import android.os.AsyncTask;

public class MJobExecutor extends AsyncTask<Void,Void,String> {
    @Override
    protected String doInBackground(Void... voids) {
        return "Background long running task finishes";
    }
}
