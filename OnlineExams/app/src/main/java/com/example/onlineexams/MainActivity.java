package com.example.onlineexams;

import android.app.Notification;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth auth;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        EditText email = findViewById(R.id.email);
        EditText password = findViewById(R.id.password);
        Button login = findViewById(R.id.login);
        TextView signup = findViewById(R.id.signup);

        auth = FirebaseAuth.getInstance();
        FirebaseUser user = auth.getCurrentUser();
        progressBar = findViewById(R.id.progressBar);
        if (user != null) {
            Intent i = new Intent(MainActivity.this, Home.class);
            i.putExtra("User ID", user.getUid());
            startActivity(i);
            finish();
        }

        login.setOnClickListener(view -> {
            progressBar.setVisibility(View.VISIBLE);

            String em = email.getText().toString().trim();
            String pass = password.getText().toString().trim();

            auth.signInWithEmailAndPassword(em, pass).addOnCompleteListener(this, task -> {
                if (task.isSuccessful()) {
                    FirebaseUser user1 = auth.getCurrentUser();
                    progressBar.setVisibility(View.GONE);
                    Intent i = new Intent(MainActivity.this, Home.class);
                    i.putExtra("User ID", user1.getUid());
                    startActivity(i);
                    finish();
                } else {
                    progressBar.setVisibility(View.GONE);
                    Toast.makeText(MainActivity.this, "Operation Failed: " + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                }
            });
        });

        signup.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, Signup.class);
            startActivity(i);
            finish();
        });

    }
}