package com.example.demo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AdminHomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_admin_home);

        Button btnInsertQuestion = findViewById(R.id.btn_insert_question);
        Button btnViewQuestion = findViewById(R.id.btn_view_question);
        Button btnUpdateQuestion = findViewById(R.id.btn_update_question);

        btnInsertQuestion.setOnClickListener(v -> {
            Intent intent = new Intent(AdminHomeActivity.this, InsertQuestionActivity.class);
            startActivity(intent);
        });

        btnViewQuestion.setOnClickListener(v -> {
            Intent intent = new Intent(AdminHomeActivity.this, ViewQuestionActivity.class);
            startActivity(intent);
        });

        btnUpdateQuestion.setOnClickListener(v -> {
            Intent intent = new Intent(AdminHomeActivity.this, UpdateQuestionActivity.class);
            startActivity(intent);
        });
    }
}


