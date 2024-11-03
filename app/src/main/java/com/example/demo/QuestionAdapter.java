package com.example.demo;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class QuestionAdapter  extends CursorAdapter{
    public QuestionAdapter(Context context, Cursor cursor, int i) {
        super(context, cursor, i);

    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        return inflater.inflate(R.layout.list_view_question, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView questionTextView = view.findViewById(R.id.text_view_question);
        TextView option1TextView = view.findViewById(R.id.text_view_option1);
        TextView option2TextView = view.findViewById(R.id.text_view_option2);
        TextView option3TextView = view.findViewById(R.id.text_view_option3);
        TextView option4TextView = view.findViewById(R.id.text_view_option4);

        String question = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COL_QUESTION_TEXT));
        String option1 = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COL_OPTION_ONE));
        String option2 = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COL_OPTION_TWO));
        String option3 = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COL_OPTION_THREE));
        String option4 = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COL_OPTION_FOUR));

        questionTextView.setText(question);
        option1TextView.setText(option1);
        option2TextView.setText(option2);
        option3TextView.setText(option3);
        option4TextView.setText(option4);
    }
}






