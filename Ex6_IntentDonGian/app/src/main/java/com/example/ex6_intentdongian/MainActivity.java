package com.example.ex6_intentdongian;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button nutMH2, nutMH3;
    void TimDieuKhien(){
        // Tìm điều khển nút bấm
        nutMH2 = (Button) findViewById(R.id.btnMH2);
        nutMH3 = (Button) findViewById(R.id.btnMH3);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        TimDieuKhien();
        // Gắn bộ lắng nghe
        nutMH2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Xử lý chuyển màn hình
                // B1. Tạo một Intent 2 tham số: 1) Màn hình chính 2) Màn hình 2.class
                Intent intentMH2 = new Intent(MainActivity.this, MH2Activity.class);
                

            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

}