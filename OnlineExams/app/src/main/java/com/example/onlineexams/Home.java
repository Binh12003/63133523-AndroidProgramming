package com.example.onlineexams;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Home extends AppCompatActivity {

    private String userUID;
    private ProgressBar progressBar;
    private DatabaseReference database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);

        database = FirebaseDatabase.getInstance().getReference();
        FirebaseAuth auth = FirebaseAuth.getInstance();

        TextView name = findViewById(R.id.name);
        TextView totalQuestions = findViewById(R.id.total_questions);
        TextView totalPoints = findViewById(R.id.total_points);
        Button startQuiz = findViewById(R.id.startQuiz);
        Button createQuiz = findViewById(R.id.createQuiz);
        RelativeLayout solvedQuizzes = findViewById(R.id.solvedQuizzes);
        RelativeLayout yourQuizzes = findViewById(R.id.your_quizzes);
        EditText quizTitle = findViewById(R.id.quiz_title);
        EditText startQuizId = findViewById(R.id.start_quiz_id);
        ImageView signout = findViewById(R.id.signout);
        progressBar = findViewById(R.id.progressBar);

        progressBar.setVisibility(View.VISIBLE);

        // Lấy userUID từ Intent
        Bundle b = getIntent().getExtras();
        if (b != null) {
            userUID = b.getString("User ID");
            Log.d("Home", "Received User UID: " + userUID);
        } else {
            Log.e("Home", "No extras found in Intent");
            Toast.makeText(this, "Lỗi: Không tìm thấy ID người dùng", Toast.LENGTH_LONG).show();
            progressBar.setVisibility(View.GONE);
            finish();
            return;
        }

        if (userUID == null || userUID.isEmpty()) {
            Log.e("Home", "User UID is null or empty");
            Toast.makeText(this, "Lỗi: ID người dùng không hợp lệ", Toast.LENGTH_SHORT).show();
            progressBar.setVisibility(View.GONE);
            finish();
            return;
        }

        // Truy vấn node Users/{userUID}
        DatabaseReference userRef = database.child("Users").child(userUID);
        userRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String firstName = dataSnapshot.child("FirstName").getValue(String.class);
                Log.d("Firebase", "FirstName: " + firstName);

                if (firstName == null) {
                    Log.e("Home", "FirstName not found for UID: " + userUID);
                    Toast.makeText(Home.this, "Lỗi: Không tìm thấy dữ liệu người dùng", Toast.LENGTH_LONG).show();
                    progressBar.setVisibility(View.GONE);
                    finish();
                    return;
                }

                // Lấy TotalPoints
                String totalPointsStr = dataSnapshot.child("TotalPoints").getValue(String.class);
                Log.d("Firebase", "TotalPoints raw: " + totalPointsStr);
                int points = 0;
                if (totalPointsStr != null && !totalPointsStr.isEmpty()) {
                    try {
                        points = Integer.parseInt(totalPointsStr);
                    } catch (NumberFormatException e) {
                        Log.e("Home", "Invalid TotalPoints format: " + totalPointsStr);
                    }
                }
                totalPoints.setText(String.format("%03d", points));

                // Lấy TotalQuestions
                String totalQuestionsStr = dataSnapshot.child("TotalQuestions").getValue(String.class);
                Log.d("Firebase", "TotalQuestions raw: " + totalQuestionsStr);
                int questions = 0;
                if (totalQuestionsStr != null && !totalQuestionsStr.isEmpty()) {
                    try {
                        questions = Integer.parseInt(totalQuestionsStr);
                    } catch (NumberFormatException e) {
                        Log.e("Home", "Invalid TotalQuestions format: " + totalQuestionsStr);
                    }
                }
                totalQuestions.setText(String.format("%03d", questions));

                name.setText("Chào mừng " + firstName + "!");
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("Home", "Firebase error: " + error.getMessage());
                Toast.makeText(Home.this, "Lỗi kết nối: " + error.getMessage(), Toast.LENGTH_LONG).show();
                progressBar.setVisibility(View.GONE);
                finish();
            }
        });

        signout.setOnClickListener(view -> {
            auth.signOut();
            Intent i = new Intent(Home.this, MainActivity.class);
            startActivity(i);
            finish();
        });

        createQuiz.setOnClickListener(v -> {
            String title = quizTitle.getText().toString().trim();
            if (title.isEmpty()) {
                Toast.makeText(this, "Tiêu đề quiz không được để trống", Toast.LENGTH_SHORT).show();
                return;
            }
            Intent i = new Intent(Home.this, ExamEditor.class);
            i.putExtra("Quiz Title", title);
            quizTitle.setText("");
            startActivity(i);
        });

        startQuiz.setOnClickListener(v -> {
            String quizId = startQuizId.getText().toString().trim();
            if (quizId.isEmpty()) {
                Toast.makeText(this, "ID quiz không được để trống", Toast.LENGTH_SHORT).show();
                return;
            }
            Intent i = new Intent(Home.this, Exam.class);
            i.putExtra("Quiz ID", quizId);
            startQuizId.setText("");
            startActivity(i);
        });

        solvedQuizzes.setOnClickListener(v -> {
            Intent i = new Intent(Home.this, ListQuizzes.class);
            i.putExtra("Operation", "List Solved Quizzes");
            startActivity(i);
        });

        yourQuizzes.setOnClickListener(v -> {
            Intent i = new Intent(Home.this, ListQuizzes.class);
            i.putExtra("Operation", "List Created Quizzes");
            startActivity(i);
        });
    }
}