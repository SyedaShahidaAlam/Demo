//package com.example.demo;
//
//import android.content.Context;
//
//public class DatabaseHelper
//{
//
//
//    public DatabaseHelper(Context context) {
//    }
//
//    public boolean checkUserByUsername(String userName, String passWord) {
//    }
//}



package com.example.demo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Test_DB";
    public static final int DATABASE_VERSION = 3;

    public static final String TABLE_REGISTER = "Register";
    public static final String COL_ID = "Id";
    public static final String COL_USERNAME = "Username";
    public static final String COL_EMAIL = "Email";
    public static final String COL_PASSWORD = "Password";
    public static final String COL_MOBILE = "Mobile";

    public static final String TABLE_QUESTIONS = "questions";
    public static final String COL_QUESTION_ID = "id";
    public static final String COL_QUESTION_TEXT = "question_text";
    public static final String COL_OPTION_ONE = "option_one";
    public static final String COL_OPTION_TWO = "option_two";
    public static final String COL_OPTION_THREE = "option_three";
    public static final String COL_OPTION_FOUR = "option_four";
    public static final String COL_CORRECT_ANSWER = "correct_answer";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create Register table
        db.execSQL("CREATE TABLE " + TABLE_REGISTER + " (" +
                COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_USERNAME + " TEXT, " +
                COL_EMAIL + " TEXT, " +
                COL_PASSWORD + " TEXT, " +
                COL_MOBILE + " TEXT)");

        // Create Questions table
        db.execSQL("CREATE TABLE " + TABLE_QUESTIONS + " (" +
                COL_QUESTION_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_QUESTION_TEXT + " TEXT, " +
                COL_OPTION_ONE + " TEXT, " +
                COL_OPTION_TWO + " TEXT, " +
                COL_OPTION_THREE + " TEXT, " +
                COL_OPTION_FOUR + " TEXT, " +
                COL_CORRECT_ANSWER + " TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_REGISTER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUESTIONS);
        onCreate(db);
    }

    public boolean insertUser(String etUsername, String etEmail, String etPhone, String etPassword) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_USERNAME, etUsername);
        contentValues.put(COL_EMAIL, etEmail);
        contentValues.put(COL_MOBILE, etPhone);
        contentValues.put(COL_PASSWORD, etPassword);
        long result = db.insert(TABLE_REGISTER, null, contentValues);
        return result != -1; // returns true if the insertion was successful
    }

    public boolean checkUserByUsername(String userName, String passWord) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_REGISTER + " WHERE " +
                COL_USERNAME + " = ? AND " + COL_PASSWORD + " =?", new String[]{userName, passWord});
        boolean exists = cursor.getCount() > 0;
        cursor.close();
        return exists;
    }

    public void insertQuestion(String questionText, String optionOne, String optionTwo, String optionThree, String optionFour, String correctAnswer) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_QUESTION_TEXT, questionText);
        values.put(COL_OPTION_ONE, optionOne);
        values.put(COL_OPTION_TWO, optionTwo);
        values.put(COL_OPTION_THREE, optionThree);
        values.put(COL_OPTION_FOUR, optionFour);
        values.put(COL_CORRECT_ANSWER, correctAnswer);
        db.insert(TABLE_QUESTIONS, null, values);
        db.close(); // Close the database connection after insertion
    }

    public Cursor getAllQuestions() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_QUESTIONS, null);
    }
}

