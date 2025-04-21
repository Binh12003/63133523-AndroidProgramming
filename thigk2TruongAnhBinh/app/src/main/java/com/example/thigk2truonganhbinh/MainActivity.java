package com.example.thigk2truonganhbinh;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Button btn2 = findViewById(R.id.btn2);
        Button btn3 = findViewById(R.id.btn3);
        Button btn4 = findViewById(R.id.btn4);
        Button btnMe = findViewById(R.id.btnMe);

        btn2.setOnClickListener(v -> {
            openActivity(ActivityCN2.class);
        });
        btn3.setOnClickListener(v -> {
            openActivity(ActivityCN3.class);
        });
//        btn4.setOnClickListener(v -> {
//            openActivity(ActivityCN4.class);
//        });
        btnMe.setOnClickListener(v -> {
            openActivity(ActivityAboutMe.class);
        });
    }

    private void openActivity(Class<?> activityClass) {
        Intent intent = new Intent(this, activityClass);
        startActivity(intent);
    }
}