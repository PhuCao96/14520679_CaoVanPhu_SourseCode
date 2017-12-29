package com.example.phucao.lab3_1_dialog;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_PERMISSION = 1;
    private static final int REQUEST_PHONECALL_PERMISSION_CODE = 1;
    Button btnContactDialogBT2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkPermissions();

        btnContactDialogBT2 = findViewById(R.id.btnContactDialogBT2);
        btnContactDialogBT2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
                View customDialogView = inflater.inflate(R.layout.custom_dialog, null);

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
                alertDialogBuilder.setView(customDialogView);
                alertDialogBuilder.setCancelable(false);

                final AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();

                ImageButton btnCancelDialogBT2 = customDialogView.findViewById(R.id.btnCancelDialogBT2);
                btnCancelDialogBT2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        alertDialog.cancel();
                    }
                });

                LinearLayout btnSendDialogBT2 = customDialogView.findViewById(R.id.btnSendDialogBT2);
                btnSendDialogBT2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(Intent.ACTION_SEND);
                        intent.setType("plain/text");
                        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"14520727@gm.uit.vn"});
                        startActivity(Intent.createChooser(intent, ""));
                    }
                });

                LinearLayout btnCallDialogBT2 = customDialogView.findViewById(R.id.btnCallDialogBT2);
                btnCallDialogBT2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                            ActivityCompat.requestPermissions(
                                    MainActivity.this,
                                    new String[]{Manifest.permission.CALL_PHONE},
                                    REQUEST_PHONECALL_PERMISSION_CODE
                            );
                        } else {
                            Uri call = Uri.parse("tel:0963254656");
                            Intent intentPhoneCall = new Intent(Intent.ACTION_CALL, call);
                            if (intentPhoneCall.resolveActivity(getPackageManager()) != null) {
                                startActivity(intentPhoneCall);
                            }
                        }

                    }
                });
            }
        });
    }

    private void checkPermissions() {
        String[] permissions = {
                Manifest.permission.CALL_PHONE
        };

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(permissions, REQUEST_PERMISSION);
        }
    }

}