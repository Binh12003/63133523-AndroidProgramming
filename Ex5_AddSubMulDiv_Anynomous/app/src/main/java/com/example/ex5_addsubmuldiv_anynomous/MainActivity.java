package com.example.ex5_addsubmuldiv_anynomous;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    // Khai báo các đối tượng gắn với ddkhien tương ứng ở đây
    EditText edtSo1;
    EditText edtSo2;
    EditText edtKetQua;
    Button nutCong,nutTru,nutNhan,nutChia;
    void TimDieuKien() {
        EditText edtSo1 = findViewById(R.id.edtSo1);
        EditText edtSo2 = findViewById(R.id.edtSo2);
        EditText edtKetQua = findViewById(R.id.edtKetQua);
        nutCong = findViewById(R.id.btnCong);
        nutTru = findViewById(R.id.btnTru);
        nutNhan = findViewById(R.id.btnNhan);
        nutChia = findViewById(R.id.btnChia);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        TimDieuKien();
        //gắn bộ lắng nghe sự kiện và code xử lý cho từng nút
        View.OnClickListener boLangNgheCong = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Xử lý cộng ở đây
                XULYCONG();
            }
        };
        nutCong.setOnClickListener(boLangNgheCong);
        nutTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Xử lý trừ ở đây
                XULYTRU();
            }
        });
        nutNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Xử lý nhân ở đây
                XULYNHAN();
            }
        });
        nutChia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Xử lý chia ở đây
                XULYCHIA();
            }
        });
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    // Xử lý cộng
    public void XULYCONG() {
        String so1 = edtSo1.getText().toString();
        String so2 = edtSo2.getText().toString();
        float fSo1 = Float.parseFloat(so1);
        float fSo2 = Float.parseFloat(so2);
        float tong = fSo1 + fSo2;
        String ketQuaChuoi = String.valueOf(tong);
        edtKetQua.setText(ketQuaChuoi);

    }

    // Xử lý trừ
    public void XULYTRU() {
        String so1 = edtSo1.getText().toString();
        String so2 = edtSo2.getText().toString();
        float fSo1 = Float.parseFloat(so1);
        float fSo2 = Float.parseFloat(so2);
        float tong = fSo1 - fSo2;
        String ketQuaChuoi = String.valueOf(tong);
        edtKetQua.setText(ketQuaChuoi);

    }

    // Xử lý nhân
    public void XULYNHAN() {
        String so1 = edtSo1.getText().toString();
        String so2 = edtSo2.getText().toString();
        float fSo1 = Float.parseFloat(so1);
        float fSo2 = Float.parseFloat(so2);
        float tong = fSo1 * fSo2;
        String ketQuaChuoi = String.valueOf(tong);
        edtKetQua.setText(ketQuaChuoi);

    }

    // Xử lý chia
    public void XULYCHIA() {
        String so1 = edtSo1.getText().toString();
        String so2 = edtSo2.getText().toString();
        float fSo1 = Float.parseFloat(so1);
        float fSo2 = Float.parseFloat(so2);
        float tong = fSo1 / fSo2;
        String ketQuaChuoi = String.valueOf(tong);
        edtKetQua.setText(ketQuaChuoi);

    }
}