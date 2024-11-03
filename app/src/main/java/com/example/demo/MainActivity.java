package com.example.demo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        EditText Username = findViewById(R.id.username);
        EditText Password = findViewById(R.id.password);
        Button Register = findViewById(R.id.regBtn);
        Button Login = findViewById(R.id.loginBtn);

        Register.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this,Register.class);
            startActivity(intent);
        });
        Login.setOnClickListener(v -> {
            String userName = Username.getText().toString();
            String passWord = Password.getText().toString();
            if (userName.isEmpty() || passWord.isEmpty())
            {
                Toast.makeText(this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
            }else{

                if(userName.equals("admin") && passWord.equals("admin"))
                {
                    Intent intent = new Intent(MainActivity.this,AdminHomeActivity.class);
                    startActivity(intent);
                }
                else{
                    DatabaseHelper dbHelper = new DatabaseHelper(MainActivity.this);
                    boolean result = dbHelper.checkUserByUsername(userName, passWord);
                    if (result){
                        Toast.makeText(this, "Welcome! valid user!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this,QuestionDisplay.class);
                        startActivity(intent);

                    }else{
                        Toast.makeText(this, "Invalid Username and Password!!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}


