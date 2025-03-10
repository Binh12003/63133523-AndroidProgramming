package com.example.vd1_explicitintents;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SubActivityOne extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sub_one);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    // Hàm đáp ứng sự kiện nhấn lên nút "TRANG CHÚ"
    // Xử lý chuyển màn hình
    public void QuayVe(View v) {
        // Tạo một đối tượng Intent
        // Tham số thứ 2 của hàm tạo này, là tên Activity (màn hình) ta muốn chuyển sang
        Intent iManHinhChinh = new Intent(this, MainActivity.class);
        // Thực hành chuyển
        startActivity(iManHinhChinh);
    }
}