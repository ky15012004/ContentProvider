package com.example.baitap6;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.SeekBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private  static final  int REQUEST_CONTACTS_ASK_PERMISSION = 1001;
    private  static final  int REQUEST_SMS_ASK_PERMISSION = 1002;

    Button btn1,btn2;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        addControl();
        addEvent();
        }

    private void addEvent() {
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                XuLyMoManHinhDanhBa();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                XuLyMoManHinhTinNhan();
            }
        });
    }

    private void XuLyMoManHinhDanhBa() {
        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{
                    "" + "android.permission.READ_CONTACTS"}, REQUEST_CONTACTS_ASK_PERMISSION);
        }
        else {
            Intent intent = new Intent(MainActivity.this, DanhBa.class);
            intent.setClassName("com.example.baitap6", "com.example.baitap6.DanhBa");
            startActivity(intent);
        }
    }

    private void XuLyMoManHinhTinNhan() {
        if(ContextCompat.checkSelfPermission(
                this, Manifest.permission.READ_SMS)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{""
                    +"android.permission.READ_SMS"},REQUEST_SMS_ASK_PERMISSION);
        }else {
            Intent intent = new Intent(MainActivity.this,Doctinnhan.class);
            intent.setClassName("com.example.baitap6", "com.example.baitap6.Doctinnhan");
            startActivity(intent);
        }

    }

    private void addControl() {
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
    }
};
