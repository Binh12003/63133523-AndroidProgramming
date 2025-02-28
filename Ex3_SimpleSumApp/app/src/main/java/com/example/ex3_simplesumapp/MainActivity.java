package com.example.ex3_simplesumapp;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

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
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    //Đây là bộ lắng nghe và xử lý sự kiện Click trên nút Tính Tổng
    public void XuLyCong(View view) {
        //Tìm, tham chieus đến điều khiển trên tệp XMl, mapping qua java file
        EditText editTextSoA = findViewById(R.id.editA);
        EditText editTextSoB = findViewById(R.id.editB);
        EditText editTextKetQua = findViewById(R.id.editKQ);

        //Lay giá trị cua EditText
        String soA = editTextSoA.getText().toString();
        String soB = editTextSoB.getText().toString();

        //Tinh tong
        int tong = Integer.parseInt(soA) + Integer.parseInt(soB);
        String ketQua = Integer.toString(tong);
        //Hien thi ket qua
        editTextKetQua.setText(tong + "");

    }
}