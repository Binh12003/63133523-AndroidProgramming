package com.example.thigk2truonganhbinh;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class ActivityCN3 extends AppCompatActivity {
    ArrayList<String> dsCM;
    ListView ListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cn3);

        ListView lvCM = findViewById(R.id.lvCM);

        dsCM = new ArrayList<String>();
        dsCM.add("Tiến về Sài Gòn");
        dsCM.add("Giải phóng Miền nam");
        dsCM.add("Đất nước trọn niềm vui");
        dsCM.add("Bài ca thống nhất");
        dsCM.add("Mùa xun trên thành phố HCM");

        ArrayAdapter<String>adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dsCM);
        ListView.setAdapter(adapter);

        ListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String song = dsCM.get(position);
                Toast.makeText(ActivityCN3.this, "Bạn chọn bài hát", Toast.LENGTH_SHORT).show();
            }
        });
    }
}