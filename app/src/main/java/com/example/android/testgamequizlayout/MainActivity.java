package com.example.android.testgamequizlayout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Added constant to be able to call intent
    public static final String EXTRA_MESSAGE = "com.example.android.testgamequizlayout.MESSAGE";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    // This method returns the score for the 1st question
    public int rbChessGuess(int score) {
        //Casting the radio button for the 1st question
        RadioButton rbChessGuess = findViewById(R.id.rbChessGuess);
        //Adds one point, only if rbChessGuess is selected
        if (rbChessGuess.isChecked()) {
            score += 1;
        }
        return score;
    }
    //This method checks the answers for the 2nd question, and returns a score for each correct answer
    public int checkBoxQ2(int score) {
        //Casting the check boxes for the 2nd question
        CheckBox q2r1 = findViewById(R.id.checkPictionary);
        CheckBox q2r2 = findViewById(R.id.checkMonopoly);
        CheckBox q2r3 = findViewById(R.id.checkTwister);
        CheckBox q2r4 = findViewById(R.id.checkUNO);
        CheckBox q2r5 = findViewById(R.id.checkCreationary);
        CheckBox q2r6 = findViewById(R.id.checkCLUE);
        // adds one point for each correct answer
        if (!q2r1.isChecked() && q2r2.isChecked() && q2r3.isChecked() && !q2r4.isChecked() && !q2r5.isChecked() && q2r6.isChecked()) {
            score += 1;
        }
        return score;
    }
    // This method returns the score for the 3rd question. Monopoly, 1935
    public int ques3Radio2(int score) {
        //Casting the radio button for the 1st question
        RadioButton ques3Radio2 = findViewById(R.id.ques3Radio2);
        //adds one point, only if ques3Radio2 is selected
        if (ques3Radio2.isChecked()) {
            score += 1;
        }
        return score;
    }
    //This method checks answers for the 4th question, and returns score for each correct answer
    public int checkBoxQ4(int score) {
        //Casting the check boxes for the 4th question
        CheckBox q4r1 = findViewById(R.id.quest4Check1);
        CheckBox q4r2 = findViewById(R.id.quest4Check2);
        CheckBox q4r3 = findViewById(R.id.quest4Check3);
        CheckBox q4r4 = findViewById(R.id.quest4Check4);
        CheckBox q4r5 = findViewById(R.id.quest4Check5);
        CheckBox q4r6 = findViewById(R.id.quest4Check6);
        //Adds one point for each correct answer
        if (!q4r1.isChecked() && q4r2.isChecked() && q4r3.isChecked() && !q4r4.isChecked() && q4r5.isChecked() && !q4r6.isChecked()) {
            score += 1;
        }
        return score;
    }
    // This method returns the score for the 5th question. Jenga, 54
    public int ques5Radio2(int score) {
        //Casting the radio button for the 5th question
        RadioButton ques5Radio2 = findViewById(R.id.ques5Radio2);
        //Adds one point, only if ques5Radio2 is selected
        if (ques5Radio2.isChecked()) {
            score += 1;
        }
        return score;
    }
    // This method is called when the submitBTN is clicked.
    public void sendMessage(View view) {
        EditText playersName = findViewById(R.id.enterName);
        String playerName = playersName.getText().toString();

        RadioButton rbChessGuess = findViewById(R.id.rbChessGuess);
        boolean rbPressedChess = rbChessGuess.isChecked();

        RadioButton ques3Radio2 = findViewById(R.id.ques3Radio2);
        boolean rbMono1935 = ques3Radio2.isChecked();

        CheckBox monopolyCheckBox = findViewById(R.id.checkMonopoly);
        boolean checkedMonopoly = monopolyCheckBox.isChecked();

        CheckBox twisterCheckBox = findViewById(R.id.checkTwister);
        boolean checkedTwister = twisterCheckBox.isChecked();

        CheckBox clueCheckBox = findViewById(R.id.checkCLUE);
        boolean checkedCLUE = clueCheckBox.isChecked();

        CheckBox scrabbleCheckBox2 = findViewById(R.id.quest4Check2);
        boolean checkedKnickknack = scrabbleCheckBox2.isChecked();

        CheckBox scrabbleCheckBox3 = findViewById(R.id.quest4Check3);
        boolean checkedPizzazz = scrabbleCheckBox3.isChecked();

        CheckBox scrabbleCheckBox5 = findViewById(R.id.quest4Check5);
        boolean checkedSense = scrabbleCheckBox5.isChecked();

        RadioButton rbJenga54 = findViewById(R.id.ques5Radio2);
        boolean rbPressedJenga = rbJenga54.isChecked();


        int score = calculateScore(rbPressedJenga, rbMono1935, checkedSense, checkedPizzazz, checkedKnickknack, rbPressedChess, checkedMonopoly, checkedTwister, checkedCLUE);
        String playerMessage = gameSummary(score, playerName);
        displayMessage(playerMessage);

        Intent intent = new Intent(this, DisplayMessageActivity.class);
        TextView endOfGame = findViewById(R.id.gameSummary);
        String message = endOfGame.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    //This string is called to show the game summary on 2nd activity
    private void displayMessage(String message) {
        TextView playerSummaryTextView = findViewById(R.id.gameSummary);
        playerSummaryTextView.setText(message);
    }
    //This method calculates the score
    private int calculateScore(boolean checkedSense, boolean rbPressedJenga, boolean rbMono1935, boolean checkedKnickknack, boolean checkedPizzazz, boolean rbPressedChess, boolean checkedMonopoly, boolean checkedTwister, boolean checkedCLUE) {
        int score = 0;
        if (rbPressedChess) {
            score += 1;
        }
        if (checkedMonopoly) {
            score += 1;
        }
        if (rbMono1935) {
            score += 1;
        }
        if (checkedTwister) {
            score += 1;
        }
        if (checkedCLUE) {
            score += 1;
        }
        if (checkedKnickknack) {
            score += 1;
        }
        if (checkedPizzazz) {
            score += 1;
        }
        if (checkedSense) {
            score += 1;
        }
        if (rbPressedJenga) {
            score += 1;

        } else {
            //Nothing happens; same as effort of user
        }
        return score;
    }
    //Game Summary called when player clicks submit
    private String gameSummary(int score, String playerName) {
        String endOFgame = "Well done " + playerName +  "!" + "\n \n \n \n \nYour final score is: " + score + " out of 9";
        endOFgame += "\n \n \nThe Answer Key is below:";
        endOFgame += "\n \nChess is the best selling game of all time.";
        endOFgame += "\n \nHASBRO publishes: Monopoly, Twister and CLUE.";
        endOFgame += "\n \nMonopoly came out in 1935.";
        endOFgame += "\n \nAccording to the Original Scrabble Dictionary, these 3 (out of 13) words are impossible to play: \nPizzazz, \nKnickknack, \nand Senselessnesses.";
        endOFgame += "\n \nThere are 54 wooden pieces in a Jenga set. \n \n";
        Toast.makeText(this, getString(R.string.merci) + score + " out of 9!", Toast.LENGTH_LONG).show();
        return endOFgame;

    }
    //Click Reset to reset quiz
    public void resetQuiz(View view) {
        finish();
        startActivity(getIntent());
    }
}

