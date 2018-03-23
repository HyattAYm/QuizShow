package com.example.alessandra.quizshow;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alessandra.quizshow.R;

public class MainActivity extends AppCompatActivity {

    int scoreQuiz;
    // Get first answer
    EditText nameField = (EditText) findViewById(R.id.name_field);
    String userString = nameField.getText().toString();
    String correctAnswer = "Friuli";
    boolean isNameFieldTrue = correctAnswer.equals(userString);
    CheckBox furlanCheckBox = (CheckBox) findViewById(R.id.furlan_checkbox);

    //** Calculate score for Edit Entry
    boolean isFurlan = furlanCheckBox.isChecked();

    //**Figure out if the Furlan Checkbox is checked

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    private int calculateEditEntry(boolean isNameFieldTrue) {
        int firstScore = 0;

        if (isNameFieldTrue) {
            firstScore = firstScore + 1;
        }
        return scoreQuiz + firstScore;
    }

    //** Calculate score for Checkbox

    private int calculateScore(boolean addFurlan) {
        int baseScore = 0;

        if (addFurlan) {
            baseScore = baseScore + 1;
        }
        return scoreQuiz + baseScore;

    }

    //** Increase the score of the quiz by 0

    public void addZeroToScore(View v) {
        scoreQuiz = scoreQuiz + 0;
        displayForQuiz(scoreQuiz);

    }

    //** Increase the score of the quiz by 4

    public void addFourToScore(View v) {
        scoreQuiz = scoreQuiz + 4;
        displayForQuiz(scoreQuiz);

    }

    //** Displays the Final Score

    private void displayForQuiz(int scoreQuiz) {
        TextView scoreTextView = (TextView) findViewById(R.id.finalScore);
        scoreTextView.setText("" + scoreQuiz);
    }

    public void findOut(View view) {
        String message = "";

        if (scoreQuiz <= 5) {
            message = "You know nothing about Friuli :sad:";
        } else if (scoreQuiz <= 8) {
            message = "You like Friuli, but not a lover";
        } else if (scoreQuiz <= 15) {
            message = "You are in the right path to love Friuli";
        } else if (scoreQuiz > 16) {
            message = "You are a super Friuli Lover! Congratz!";
        }

        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

}


