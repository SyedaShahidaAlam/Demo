package com.example.demo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);

        EditText Username = findViewById(R.id.username);
        EditText Email = findViewById(R.id.email);
        EditText Phone = findViewById(R.id.phone);
        EditText Password = findViewById(R.id.password);
        EditText ConfirmPass = findViewById(R.id.confirmpass);
        Button Register = findViewById(R.id.regBtn);
        Button Login = findViewById(R.id.loginBtn);

        Register.setOnClickListener(v ->{
            //Toast.makeText(Register.this, "Register Button Clicked", Toast.LENGTH_SHORT).show();
            String etUsername = Username.getText().toString();
            String etEmail = Email.getText().toString();
            String etPhone = Phone.getText().toString();
            String etPassword = Password.getText().toString();
            String etConfirmPass = ConfirmPass.getText().toString();

            if(etPassword.equals(etConfirmPass) && !etPassword.isEmpty() && !etUsername.isEmpty())
            {
                Toast.makeText(this, "Well done!", Toast.LENGTH_SHORT).show();
                //DB connection
                DatabaseHelper dbHelper = new DatabaseHelper(Register.this);
                boolean isInserted = dbHelper.insertUser(etUsername,etEmail,etPhone,etPassword);

                if (isInserted){
                    Toast.makeText(this, "Registration Successful", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Register.this,MainActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(this, "Registration Failed", Toast.LENGTH_SHORT).show();

                }
            }
            else
            {
                Toast.makeText(this, "Invalid Password! or Invalid Username!", Toast.LENGTH_SHORT).show();
            }
        });
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Register.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}