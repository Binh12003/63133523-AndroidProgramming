package com.example.onlineexams;

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

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Signup extends AppCompatActivity {

    private FirebaseAuth auth;
    private DatabaseReference database;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_signup);

        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance().getReference();
        progressBar = findViewById(R.id.progressBar);

        EditText first_name = findViewById(R.id.first_name);
        EditText last_name = findViewById(R.id.last_name);
        EditText email = findViewById(R.id.email);
        EditText password = findViewById(R.id.password);
        EditText confirm_password = findViewById(R.id.confirm_password);
        Button signup = findViewById(R.id.signup);
        TextView login = findViewById(R.id.login);

        signup.setOnClickListener(v -> {
            progressBar.setVisibility(View.VISIBLE);

            String firstName = first_name.getText().toString().trim();
            String lastName = last_name.getText().toString().trim();
            String emailStr = email.getText().toString().trim();
            String pass = password.getText().toString().trim();
            String confirmPass = confirm_password.getText().toString().trim();

            if (!pass.equals(confirmPass)) {
                confirm_password.setError("Password doesn't match");
                progressBar.setVisibility(View.GONE);
                return;
            }

            auth.createUserWithEmailAndPassword(emailStr, pass)
                    .addOnCompleteListener(this, task -> {
                        if (task.isSuccessful()) {
                            FirebaseUser user = auth.getCurrentUser();
                            DatabaseReference userRef = database.child("Users").child(user.getUid());
                            userRef.child("FirstName").setValue(firstName);
                            userRef.child("LastName").setValue(lastName);

                            progressBar.setVisibility(View.GONE);
                            Intent i = new Intent(Signup.this, Home.class);
                            i.putExtra("User ID", user.getUid());
                            startActivity(i);
                            finish();
                        } else {
                            progressBar.setVisibility(View.GONE);
                            Toast.makeText(Signup.this, "Sign-up failed: " + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        }
                    });
        });

        login.setOnClickListener(v -> {
            Intent i = new Intent(Signup.this, MainActivity.class);
            startActivity(i);
            finish();
        });
    }
}