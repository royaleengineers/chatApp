package com.example.chatapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class StartActivity extends AppCompatActivity {

    Button login,register;

    FirebaseUser firebaseUser;
    @Override
    protected void onStart(){
        super.onStart();
        firebaseUser= FirebaseAuth.getInstance().getCurrentUser();
        if(firebaseUser !=null){
            Intent intent = new Intent(StartActivity.this,MainActivity.class);
            startActivity(intent);
            finish();
        }
        Toast.makeText(StartActivity.this, "Please login to use the app", Toast.LENGTH_SHORT).show();


    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        login=findViewById(R.id.login);
        register=findViewById(R.id.register);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StartActivity.this,LoginActivity.class));
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                startActivity(new Intent(StartActivity.this,RegisterActivity.class));
            }
        });
    }
}
