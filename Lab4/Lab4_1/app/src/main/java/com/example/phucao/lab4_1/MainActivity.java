package com.example.phucao.lab4_1;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ProgressBar pbFirst, pbSecond;
    private TextView tvMsgWorking, tvMsgReturned;
    private boolean isRunning;
    private int MAX_SEC;

    private int intTest;
    private Thread bgThread;
    private Handler handler;
    private Button btnStart;

    //AtomicBoolean isrunning=new AtomicBoolean(false);
    //boolean
    //Button btnstart;
    //TextView lblmsg;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pbFirst = (ProgressBar) findViewById(R.id.pb_first);
        pbSecond = (ProgressBar) findViewById(R.id.pb_second);

        tvMsgWorking = (TextView) findViewById(R.id.tv_working);
        tvMsgReturned = (TextView) findViewById(R.id.tv_return);

        btnStart = (Button) findViewById(R.id.btn_start);
        initVariables();

        btnStart.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                isRunning = true;
                pbFirst.setVisibility(View.VISIBLE);
                pbSecond.setVisibility(View.VISIBLE);
                btnStart.setVisibility(View.GONE);
                bgThread.start();
            }
        });
    }

    private void initVariables() {
        isRunning = false;
        MAX_SEC = 20;
        intTest = 1;
        pbFirst.setMax(MAX_SEC);
        pbSecond.setProgress(0);

        pbFirst.setVisibility(View.GONE);
        pbSecond.setProgress(View.GONE);

        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);

                String returnedValue = (String) msg.obj;

                tvMsgReturned.setText("Return by background thread:" + returnedValue + "\n");
                pbFirst.incrementProgressBy(2);

                if (pbFirst.getProgress() == MAX_SEC) {
                    tvMsgReturned.setText("Background thread has been stopped");
                    tvMsgWorking.setText("Done");
                    pbFirst.setVisibility(View.GONE);
                    pbSecond.setVisibility(View.GONE);
                    btnStart.setVisibility(View.GONE);
                    isRunning = false;
                } else {
                    tvMsgWorking.setText("Working " + pbFirst.getProgress());
                }
            }
        };
    }

    private void initBgThread() {
        bgThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < MAX_SEC && isRunning; i++) {
                        Thread.sleep(1000);

                        Random rnd = new Random();
                        String data = "\nThread value: " + (int) rnd.nextInt(101);
                        data += "\nGlobal value seen" + " " + intTest;
                        intTest++;
                        if (isRunning) {
                            Message msg = handler.obtainMessage(1, (String) data);
                            handler.sendMessage(msg);
                        }
                    }
                } catch (Throwable t) {
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        initBgThread();
    }

    @Override
    protected void onStop() {
        super.onStop();
        isRunning = false;
    }
}