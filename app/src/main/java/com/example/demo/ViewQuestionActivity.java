package com.example.demo;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class ViewQuestionActivity extends AppCompatActivity {

    private ListView listViewQuestions;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_view_question);

        listViewQuestions = findViewById(R.id.list_view_questions);
        Button buttonUpdate = findViewById(R.id.button_update);
        Button buttonDelete = findViewById(R.id.button_delete);
        databaseHelper = new DatabaseHelper(this);

        displayQuestions();

        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                handleUpdate();
            }
        });

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleDelete();
            }
        });
    }

    protected void onResume() {
        super.onResume();
        displayQuestions(); // Refresh displayed questions on resume
    }

    private void displayQuestions() {
        Cursor cursor = databaseHelper.getAllQuestions();
        QuestionAdapter adapter = new QuestionAdapter(this, cursor, 0);
        listViewQuestions.setAdapter(adapter);
    }

    private void handleUpdate() {
        Intent intent = new Intent(ViewQuestionActivity.this, UpdateQuestionActivity.class);
        startActivity(intent);
    }

    private void handleDelete() {
        Intent intent = new Intent(ViewQuestionActivity.this, DeleteQuestionActivity.class);
        startActivity(intent);
        Toast.makeText(this, "Delete button clicked", Toast.LENGTH_SHORT).show();
    }
}










