package com.example.testgiuaky;

import android.app.Activity;
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

        Button btnCau1 = findViewById(R.id.btnCau1);
        Button btnCau2 = findViewById(R.id.btnCau2);
        Button btnCau3 = findViewById(R.id.btnCau3);
        Button btnCau4 = findViewById(R.id.btnCau4);

        btnCau1 .setOnClickListener(v -> {
            openActivity(ActivityCau1.class);
        });
        btnCau2.setOnClickListener(v -> {
            openActivity(ActivityCau2.class);
        });
        btnCau3.setOnClickListener(v -> {
            openActivity(ActivityCau3.class);
        });
        btnCau4.setOnClickListener(v -> {
            openActivity(ActivityCau4.class);
        });
    }

    private void openActivity(Class<?> activityClass) {
        Intent intent = new Intent(this, activityClass);
        startActivity(intent);
    }
}