package com.example.phucao.lab4_3;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.crypto.Mac;


public class MainActivity extends AppCompatActivity {

    private Button btnQuickJob, btnSlowJob;
    private TextView tvStatus;
    private SlowTask slowTask;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnQuickJob = (Button) findViewById(R.id.btn_quick_job);
        btnSlowJob = (Button) findViewById(R.id.btn_slow_job);
        tvStatus = (TextView) findViewById(R.id.tv_status);

        slowTask=new SlowTask(MainActivity.this, tvStatus);

        // Handle onClickListenner
        btnQuickJob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                tvStatus.setText(sdf.format(new Date()));
            }
        });
        btnSlowJob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slowTask.execute();
            }
        });
    }
}
class SlowTask extends AsyncTask<String, Long, Void> {
    private ProgressDialog pdWatting;
    private Context context;
    private Long startTime;
    private TextView tvStatus;

    public SlowTask(Context context, TextView tvStatus) {
        this.context = context;
        this.tvStatus = tvStatus;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        pdWatting = new ProgressDialog(context);
        startTime = System.currentTimeMillis();
        tvStatus.setText("Start time: " + startTime);
        pdWatting.setMessage(context.getString(R.string.please_wait));
        pdWatting.show();
    }

    @Override
    protected Void doInBackground(String... strings) {
        try {
            for (Long i = 0L; i < 3L; i++) {
                Thread.sleep(2000);
                publishProgress((Long) i);
            }
        }catch (Exception e) {
            Log.e("SlowJob", e.getMessage());
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Long... value){
        super.onProgressUpdate(value);

        tvStatus.append("\nWorking..." + value[0]);
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        if (pdWatting.isShowing())
            pdWatting.dismiss();
        tvStatus.append("\nEnd Time: " + System.currentTimeMillis());
        tvStatus.append("\nDone!");
    }
}
