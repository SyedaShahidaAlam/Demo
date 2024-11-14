//package com.example.demo;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.Toast;
//
//import androidx.activity.EdgeToEdge;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.core.graphics.Insets;
//import androidx.core.view.ViewCompat;
//import androidx.core.view.WindowInsetsCompat;
//
//public class Register extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
//        setContentView(R.layout.activity_register);
//
//        EditText Username = findViewById(R.id.username);
//        EditText Email = findViewById(R.id.email);
//        EditText Phone = findViewById(R.id.phone);
//        EditText Password = findViewById(R.id.password);
//        EditText ConfirmPass = findViewById(R.id.confirmpass);
//        Button Register = findViewById(R.id.regBtn);
//        Button Login = findViewById(R.id.loginBtn);
//
//        Register.setOnClickListener(v ->{
//            //Toast.makeText(Register.this, "Register Button Clicked", Toast.LENGTH_SHORT).show();
//            String etUsername = Username.getText().toString();
//            String etEmail = Email.getText().toString();
//            String etPhone = Phone.getText().toString();
//            String etPassword = Password.getText().toString();
//            String etConfirmPass = ConfirmPass.getText().toString();
//
//            if(etPassword.equals(etConfirmPass) && !etPassword.isEmpty() && !etUsername.isEmpty())
//            {
//                Toast.makeText(this, "Well done!", Toast.LENGTH_SHORT).show();
//                //DB connection
//                DatabaseHelper dbHelper = new DatabaseHelper(Register.this);
//                boolean isInserted = dbHelper.insertUser(etUsername,etEmail,etPhone,etPassword);
//
//                if (isInserted){
//                    Toast.makeText(this, "Registration Successful", Toast.LENGTH_SHORT).show();
//                    Intent intent = new Intent(Register.this,MainActivity.class);
//                    startActivity(intent);
//                }else{
//                    Toast.makeText(this, "Registration Failed", Toast.LENGTH_SHORT).show();
//
//                }
//            }
//            else
//            {
//                Toast.makeText(this, "Invalid Password! or Invalid Username!", Toast.LENGTH_SHORT).show();
//            }
//        });
//        Login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(Register.this,MainActivity.class);
//                startActivity(intent);
//            }
//        });
//    }
//}




package com.example.demo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Pattern;

public class Register extends AppCompatActivity {

    // Define regex patterns
    private static final Pattern USERNAME_PATTERN = Pattern.compile("^[a-zA-Z0-9]{4,15}$");
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    private static final Pattern PHONE_PATTERN = Pattern.compile("^\\d{10,12}$");
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%^&+=]).{8,}$");

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

        Register.setOnClickListener(v -> {
            String etUsername = Username.getText().toString();
            String etEmail = Email.getText().toString();
            String etPhone = Phone.getText().toString();
            String etPassword = Password.getText().toString();
            String etConfirmPass = ConfirmPass.getText().toString();

            // Validate input fields using regex
            if (!USERNAME_PATTERN.matcher(etUsername).matches()) {
                Toast.makeText(this, "Invalid Username! Use 4-15 alphanumeric characters.", Toast.LENGTH_SHORT).show();
            } else if (!EMAIL_PATTERN.matcher(etEmail).matches()) {
                Toast.makeText(this, "Invalid Email! Please enter a valid email address.", Toast.LENGTH_SHORT).show();
            } else if (!PHONE_PATTERN.matcher(etPhone).matches()) {
                Toast.makeText(this, "Invalid Phone Number! Use 10-12 digits only.", Toast.LENGTH_SHORT).show();
            } else if (!PASSWORD_PATTERN.matcher(etPassword).matches()) {
                Toast.makeText(this, "Password must be at least 8 characters, contain upper and lower case letters, a number, and a special character.", Toast.LENGTH_LONG).show();
            } else if (!etPassword.equals(etConfirmPass)) {
                Toast.makeText(this, "Passwords do not match!", Toast.LENGTH_SHORT).show();
            } else {
                // All inputs are valid, proceed with database insertion
                DatabaseHelper dbHelper = new DatabaseHelper(Register.this);
                boolean isInserted = dbHelper.insertUser(etUsername, etEmail, etPhone, etPassword);

                if (isInserted) {
                    Toast.makeText(this, "Registration Successful", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Register.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(this, "Registration Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Login.setOnClickListener(v -> {
            Intent intent = new Intent(Register.this, MainActivity.class);
            startActivity(intent);
        });
    }
}




