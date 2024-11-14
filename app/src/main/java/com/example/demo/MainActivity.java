//package com.example.demo;
//
//import android.content.Intent;
//import android.os.Bundle;
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
//public class MainActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
//        setContentView(R.layout.activity_main);
//
//        EditText Username = findViewById(R.id.username);
//        EditText Password = findViewById(R.id.password);
//        Button Register = findViewById(R.id.regBtn);
//        Button Login = findViewById(R.id.loginBtn);
//
//        Register.setOnClickListener(v -> {
//            Intent intent = new Intent(MainActivity.this,Register.class);
//            startActivity(intent);
//        });
//        Login.setOnClickListener(v -> {
//            String userName = Username.getText().toString();
//            String passWord = Password.getText().toString();
//            if (userName.isEmpty() || passWord.isEmpty())
//            {
//                Toast.makeText(this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
//            }else{
//
//                if(userName.equals("admin") && passWord.equals("admin"))
//                {
//                    Intent intent = new Intent(MainActivity.this,AdminHomeActivity.class);
//                    startActivity(intent);
//                }
//                else{
//                    DatabaseHelper dbHelper = new DatabaseHelper(MainActivity.this);
//                    boolean result = dbHelper.checkUserByUsername(userName, passWord);
//                    if (result){
//                        Toast.makeText(this, "Welcome! valid user!", Toast.LENGTH_SHORT).show();
//                        Intent intent = new Intent(MainActivity.this,QuestionDisplay.class);
//                        startActivity(intent);
//
//                    }else{
//                        Toast.makeText(this, "Invalid Username and Password!!", Toast.LENGTH_SHORT).show();
//                    }
//                }
//            }
//        });
//    }
//}
//
//




package com.example.demo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    // Define regex patterns
    private static final Pattern USERNAME_PATTERN = Pattern.compile("^[a-zA-Z0-9]{4,15}$");
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%^&+=]).{8,}$");

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
            Intent intent = new Intent(MainActivity.this, Register.class);
            startActivity(intent);
        });

        Login.setOnClickListener(v -> {
            String userName = Username.getText().toString();
            String passWord = Password.getText().toString();

            // Validate Username and Password with regex
            if (userName.isEmpty() || passWord.isEmpty()) {
                Toast.makeText(this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
            } else if (!USERNAME_PATTERN.matcher(userName).matches()) {
                Toast.makeText(this, "Invalid Username! Use 4-15 alphanumeric characters.", Toast.LENGTH_SHORT).show();
            } else if (!PASSWORD_PATTERN.matcher(passWord).matches()) {
                Toast.makeText(this, "Password must be at least 8 characters, contain upper and lower case letters, a number, and a special character.", Toast.LENGTH_LONG).show();
            } else {
                // Proceed with authentication check
                if (userName.equals("admin") && passWord.equals("admin")) {
                    Intent intent = new Intent(MainActivity.this, AdminHomeActivity.class);
                    startActivity(intent);
                } else {
                    DatabaseHelper dbHelper = new DatabaseHelper(MainActivity.this);
                    boolean result = dbHelper.checkUserByUsername(userName, passWord);
                    if (result) {
                        Toast.makeText(this, "Welcome! Valid user!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this, QuestionDisplay.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(this, "Invalid Username and Password!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}


