package com.example.todolist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;


import java.util.HashMap;
import java.util.Map;


public class LoginActivity extends AppCompatActivity {
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
    }

    public void signin(String email) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("email", email);

        startActivity(intent);
        finish();

    }

    public void print(String info) {
        Toast toast = Toast.makeText(this, info, Toast.LENGTH_LONG);
        toast.show();
    }

    public void signup(View view) {
        TextInputEditText emailbox = (TextInputEditText) findViewById(R.id.textEmail);
        TextInputEditText pass = (TextInputEditText) findViewById(R.id.textPass);
        Map<String, Object> user = new HashMap<>();
        user.put("email", emailbox.getText().toString());
        user.put("password", pass.getText().toString());
        if (emailbox.getText().toString().equals("") || pass.getText().toString().equals("")) {
            print("Username or Password is empty");
        } else {
            db.collection("user").document(emailbox.getText().toString()).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                    if (task.isSuccessful()) {
                        DocumentSnapshot document = task.getResult();
                        if (!emailbox.getText().toString().equals(document.getString("email"))) {
                            db.collection("user").document(emailbox.getText().toString()).set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    signin(emailbox.getText().toString());
                                }
                            });
                        } else {
                            print("Username not available");
                        }
                    } else {
                        print("An error has occurred");
                    }
                }
            });
        }
    }

    public void login(View view) {
        TextInputEditText user = (TextInputEditText) findViewById(R.id.textEmail);
        TextInputEditText pass = (TextInputEditText) findViewById(R.id.textPass);
        if (user.getText().toString().equals("") || pass.getText().toString().equals("")) {
            print("Username or Password is empty");
        } else {
            db.collection("user").document(user.getText().toString()).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                    if (task.isSuccessful()) {
                        DocumentSnapshot document = task.getResult();
                        if (pass.getText().toString().equals(document.getString("password"))) {
                            signin(user.getText().toString());
                        } else {
                            print("Username or Password is wrong");
                        }
                    } else {
                        print("An error has occurred");
                    }
                }
            });
        }
    }
}

