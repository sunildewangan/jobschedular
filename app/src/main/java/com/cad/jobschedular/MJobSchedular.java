package com.cad.jobschedular;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.widget.Toast;

public class MJobSchedular extends JobService {
    MJobExecutor mJobExecutor;
    @Override
    public boolean onStartJob(final JobParameters jobParameters) {
        mJobExecutor = new MJobExecutor(){
            @Override
            protected void onPostExecute(String s) {
                Toast.makeText(getApplicationContext(),s,Toast.LENGTH_SHORT).show();
                jobFinished(jobParameters,false);
            }
        };

        mJobExecutor.execute();
        return true;

    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        mJobExecutor.cancel(true);
        return false;
    }
}
