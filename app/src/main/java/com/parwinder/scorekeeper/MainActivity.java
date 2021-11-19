package com.parwinder.scorekeeper;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

/**
 * Student name: Parwinder Deep Kaur
 * Student ID: A00237487
 * This is scorekeeper app, that increment and decrement scores by selected value for different teams.
 * The app does not allow scores to be greater than 30 and not less than 0.
 * This app shows some views and there usage.
 *
 * @author Parwinder Deep Kaur
 * @version 1.1
 * @since 27 October, 2021
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView teamAScoreTV, teamBScoreTV, selectedTeamScoreTV;
    private SwitchCompat onOffSC;
    private RadioGroup pointRG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //find the ids of views
        teamAScoreTV = findViewById(R.id.team_a_scoreTV);
        teamBScoreTV = findViewById(R.id.team_b_scoreTV);
        onOffSC = findViewById(R.id.on_offSC);
        pointRG = findViewById(R.id.pointRG);
        Button plusBT = findViewById(R.id.plusBT);
        Button minusBT = findViewById(R.id.minusBT);

        //set click listeners on veiws
        plusBT.setOnClickListener(this);
        minusBT.setOnClickListener(this);
        onOffSC.setOnClickListener(this);

        // set default selected team as team B
        selectedTeamScoreTV = teamBScoreTV;
    }

    /**
     * This is the overridden method of View class.
     * Using switch statement, it finds which view is clicked
     * execute the code accordingly and then break
     */
    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.plusBT:
                increaseScores();
                break;

            case R.id.minusBT:
                decreaseScores();
                break;

            // put the selected team into a variable
            case R.id.on_offSC:
                if (onOffSC.isChecked()) {
                    selectedTeamScoreTV = teamBScoreTV;
                } else {
                    selectedTeamScoreTV = teamAScoreTV;
                }
                break;
        }
    }

    /**
     * this method checks which radio button is selected
     * set text of selectedTeamScoreTV after incrementing by 2,4,6,8 values,
     * before incrementing it checks if the score is less than the max score value(30) to avoid
     * score to be more than 30 as a result
     * selectedTeamScoreTV can be either team A or team B
     */
    @SuppressLint("NonConstantResourceId")
    private void increaseScores() {
        int score = Integer.parseInt(selectedTeamScoreTV.getText().toString()); // parse String to int
        switch (pointRG.getCheckedRadioButtonId()) {
            case R.id.point2RB:
                if (((score + 2) < 30)) // check for max score value
                    selectedTeamScoreTV.setText(String.valueOf(score + 2)); // parse int value to String
                else {
                    setDefaultMaxScore();
                }
                break;


            case R.id.point4RB:
                if (((score + 4) < 30))
                    selectedTeamScoreTV.setText(String.valueOf(score + 4));
                else {
                    setDefaultMaxScore();
                }
                break;

            case R.id.point6RB:
                if (((score + 6) < 30))
                    selectedTeamScoreTV.setText(String.valueOf(score + 6));
                else {
                    setDefaultMaxScore();
                }
                break;

            case R.id.point8RB:
                if (((score + 8) < 30))
                    selectedTeamScoreTV.setText(String.valueOf(score + 8));
                else {
                    setDefaultMaxScore();
                }
        }
    }

    /**
     * This method set the maximum value for score text view, maximum score is 30
     * It also show a toast message to indicate user that maximum score value is reached while incrementing
     */
    private void setDefaultMaxScore() {
        selectedTeamScoreTV.setText(R.string.default_max_score_value);
        Toast.makeText(this, R.string.highest_value_for_scores_reached, Toast.LENGTH_SHORT).show();
    }

    /**
     * this method checks which radio button is selected
     * set text of selectedTeamScoreTV after decrementing by 2,4,6,8 values
     * before decrementing it checks if the score is not less than the decrement value to avoid negative result
     * selectedTeamScoreTV can be either team A or team B
     */
    @SuppressLint("NonConstantResourceId")
    private void decreaseScores() {
        int score = Integer.parseInt(selectedTeamScoreTV.getText().toString()); // parse String into int
        switch (pointRG.getCheckedRadioButtonId()) {
            case R.id.point2RB:
                if (!(score < 2)) // check for min score value
                    selectedTeamScoreTV.setText(String.valueOf(score - 2)); // parse int value to String
                else {
                    setDefaultMinScore();
                }
                break;

            case R.id.point4RB:
                if (!(score < 4))
                    selectedTeamScoreTV.setText(String.valueOf(score - 4));
                else {
                    setDefaultMinScore();
                }
                break;

            case R.id.point6RB:
                if (!(score < 6))
                    selectedTeamScoreTV.setText(String.valueOf(score - 6));
                else {
                    setDefaultMinScore();
                }
                break;

            case R.id.point8RB:
                if (!(score < 8))
                    selectedTeamScoreTV.setText(String.valueOf(score - 8));
                else {
                    setDefaultMinScore();
                }
                break;
        }
    }

    /**
     * This method set the minimum value for score text view, minimum score is 0
     * It also show a toast message to indicate user that minimum score value is reached while decrementing
     */
    private void setDefaultMinScore() {
        selectedTeamScoreTV.setText(R.string.default_min_score_value);
        Toast.makeText(this, R.string.lowest_value_for_scores_reached, Toast.LENGTH_SHORT).show();
    }
}