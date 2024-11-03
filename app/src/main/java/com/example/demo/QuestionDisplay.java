package com.example.demo;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class QuestionDisplay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_question_display);


    }
}





//package com.example.demo;
//
//import android.database.Cursor;
//import android.os.Bundle;
//import android.widget.ListView;
//import androidx.appcompat.app.AppCompatActivity;
//
//public class QuestionDisplay extends AppCompatActivity {
//
//    private ListView listView;
//    private DatabaseHelper dbHelper;
//    private QuestionAdapter adapter;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_question_display);
//
//        // Initialize the ListView
//        listView = findViewById(R.id.list_view_questions);
//
//        // Initialize the DatabaseHelper
//        dbHelper = new DatabaseHelper(this);
//
//        // Fetch the data from the database
//        Cursor cursor = dbHelper.getAllQuestions();
//
//        // Initialize the QuestionAdapter with the cursor
//        adapter = new QuestionAdapter(this, cursor, 0);
//
//        // Set the adapter to the ListView
//        listView.setAdapter(adapter);
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        // Close the cursor to avoid memory leaks
//        if (adapter != null && adapter.getCursor() != null) {
//            adapter.getCursor().close();
//        }
//    }
//}



