package com.example.asus.androidorderfood.view;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.asus.androidorderfood.R;

public class SlashSreenActivity extends AppCompatActivity {
    TextView txtPhienban;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_flashsreen);
        txtPhienban = (TextView) findViewById(R.id.txtPhienban);
        try{
            PackageInfo packageInfo = getPackageManager().getPackageInfo(getPackageName(),0);
            txtPhienban.setText(getString(R.string.phienban) + " " + packageInfo.versionName);
            //Chuyeen bay
            Handler handler=new Handler();
            //tao thoi gian chuyển
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent iDangNhap=new Intent(SlashSreenActivity.this,DangNhapActivity.class);
                    startActivity(iDangNhap);

                }
            },2000);


        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

    }
}
