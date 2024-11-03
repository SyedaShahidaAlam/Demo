package com.example.demo;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class InsertQuestionActivity extends AppCompatActivity {

    private EditText et_QuestionText;
    private EditText et_Option1;
    private EditText et_Option2;
    private EditText et_Option3;
    private EditText et_Option4;
    private EditText et_CorrectAnswer;
    private Button btn_InsertQuestion;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_insert_question);

        et_QuestionText = findViewById(R.id.et_question_text);
        et_Option1 = findViewById(R.id.et_option_one);
        et_Option2 = findViewById(R.id.et_option_two);
        et_Option3 = findViewById(R.id.et_option_three);
        et_Option4 = findViewById(R.id.et_option_four);
        et_CorrectAnswer = findViewById(R.id.et_correct_answer);
        btn_InsertQuestion = findViewById(R.id.btn_insert_question);

        databaseHelper = new DatabaseHelper(this);

        btn_InsertQuestion.setOnClickListener(view -> insertQuestion());
    }

    private void insertQuestion() {
        String questionText = et_QuestionText.getText().toString();
        String optionOne = et_Option1.getText().toString();
        String optionTwo = et_Option2.getText().toString();
        String optionThree = et_Option3.getText().toString();
        String optionFour = et_Option4.getText().toString();
        String correctAnswer = et_CorrectAnswer.getText().toString();

        if (TextUtils.isEmpty(questionText) || TextUtils.isEmpty(optionOne) ||
                TextUtils.isEmpty(optionTwo) || TextUtils.isEmpty(optionThree) ||
                TextUtils.isEmpty(optionFour) || TextUtils.isEmpty(correctAnswer)) {
            Toast.makeText(this, "Please fill up all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            databaseHelper.insertQuestion(questionText, optionOne, optionTwo, optionThree, optionFour, correctAnswer);
            Toast.makeText(this, "Question inserted successfully", Toast.LENGTH_SHORT).show();

            et_QuestionText.setText("");
            et_Option1.setText("");
            et_Option2.setText("");
            et_Option3.setText("");
            et_Option4.setText("");
            et_CorrectAnswer.setText("");
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "Failed to insert question", Toast.LENGTH_SHORT).show();
        }
    }
}


