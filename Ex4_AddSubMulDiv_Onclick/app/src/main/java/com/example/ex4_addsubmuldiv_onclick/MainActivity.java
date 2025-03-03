package com.example.ex4_addsubmuldiv_onclick;

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
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    // Xử lý cộng
    public void XuLyCong(View v) {
        // code xử lý cộng
        // b1. lấy dl 2 số
        // b1.1. Tìm EditText số 1 và 2
        // b1.2. Lấy dl từ 2 đkiển đó
        String so1 = edtSo1.getText().toString();
        String so2 = edtSo2.getText().toString();
        // b1.3. Chuyển dl từ chuỗi sang số
        float fSo1 = Float.parseFloat(so1);
        float fSo2 = Float.parseFloat(so2);
        // b2. Tính toán
        float ketQua = fSo1 + fSo2;
        // b3. Hiện thị kết quả
        // b3.1. Chuyển kết quả sang chuỗi
        String ketQuaChuoi = String.valueOf(ketQua);
        // b3.2. gắn kết quả lên đk
        edtKetQua.setText(ketQuaChuoi);

    }

    // Xử lý trừ
    public void XuLyTru(View v) {
        // code xử lý trừ
        // b1. lấy dl 2 số
        // b1.1. Tìm EditText số 1 và 2
        // b1.2. Lấy dl từ 2 đkiển đó
        String so1 = edtSo1.getText().toString();
        String so2 = edtSo2.getText().toString();
        // b1.3. Chuyển dl từ chuỗi sang số
        float fSo1 = Float.parseFloat(so1);
        float fSo2 = Float.parseFloat(so2);
        // b2. Tính toán
        float ketQua = fSo1 - fSo2;
        // b3. Hiện thị kết quả
        // b3.1. Chuyển kết quả sang chuỗi
        String ketQuaChuoi = String.valueOf(ketQua);
        // b3.2. gắn kết quả lên đk
        edtKetQua.setText(ketQuaChuoi);

    }

    // Xử lý nhân
    public void XuLyNhan(View v) {
        // code xử lý nhân
        // b1. lấy dl 2 số
        // b1.1. Tìm EditText số 1 và 2
        // b1.2. Lấy dl từ 2 đkiển đó
        String so1 = edtSo1.getText().toString();
        String so2 = edtSo2.getText().toString();
        // b1.3. Chuyển dl từ chuỗi sang số
        float fSo1 = Float.parseFloat(so1);
        float fSo2 = Float.parseFloat(so2);
        // b2. Tính toán
        float ketQua = fSo1 * fSo2;
        // b3. Hiện thị kết quả
        // b3.1. Chuyển kết quả sang chuỗi
        String ketQuaChuoi = String.valueOf(ketQua);
        // b3.2. gắn kết quả lên đk
        edtKetQua.setText(ketQuaChuoi);

    }

    // Xử lý chia
     public void XuLyChia(View v) {
        // code xử lý chia
        // b1. lấy dl 2 số
        // b1.1. Tìm EditText số 1 và 2
        // b1.2. Lấy dl từ 2 đkiển đó
        String so1 = edtSo1.getText().toString();
        String so2 = edtSo2.getText().toString();
        // b1.3. Chuyển dl từ chuỗi sang số
        float fSo1 = Float.parseFloat(so1);
        float fSo2 = Float.parseFloat(so2);
        // b2. Tính toán
        float ketQua = fSo1 / fSo2;
        // b3. Hiện thị kết quả
        // b3.1. Chuyển kết quả sang chuỗi
        String ketQuaChuoi = String.valueOf(ketQua);
        // b3.2. gắn kết quả lên đk
        edtKetQua.setText(ketQuaChuoi);

    }
}