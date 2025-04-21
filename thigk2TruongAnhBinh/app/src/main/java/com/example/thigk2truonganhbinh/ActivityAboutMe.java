package com.example.thigk2truonganhbinh;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ActivityAboutMe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_about_me);


        TextView txtInfo = findViewById(R.id.txtInfo);
        txtInfo.setText("MSSV: 63133523 \n Đề thi số 2 \n lớp 63-HTTT ");
    }
}