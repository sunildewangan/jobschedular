package com.cad.jobschedular;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final int JOB_ID = 100;
    private JobScheduler jobScheduler;
    private JobInfo jobInfo;
    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ComponentName componentName = new ComponentName(this, MJobSchedular.class);
        JobInfo.Builder builder = new JobInfo.Builder(JOB_ID,componentName);
        builder.setPeriodic(5000);
        builder.setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY);
        builder.setPersisted(true);

        jobInfo = builder.build();

        jobScheduler = (JobScheduler) getBaseContext().getSystemService(JOB_SCHEDULER_SERVICE);
    }

    public void startJob(View view) {
        jobScheduler.schedule(jobInfo);
        Toast.makeText(getBaseContext(), "Job Scheduled",Toast.LENGTH_SHORT).show();
    }

    public void stopJob(View view) {
        jobScheduler.cancel(JOB_ID);
        Toast.makeText(getBaseContext(), "Job Canceled",Toast.LENGTH_SHORT).show();
    }
}