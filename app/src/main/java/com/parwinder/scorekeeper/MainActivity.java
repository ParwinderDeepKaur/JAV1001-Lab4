package com.parwinder.scorekeeper;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

/**
 * Student name: Parwinder Deep Kaur
 * Student ID: A00237487
 * This is scorekeeper app, that increment and decrement scores by selected value for different teams.
 * This app shows some views and there usage.
 *
 * @author Parwinder Deep Kaur
 * @version 1.0
 * @since 19 October, 2021
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
     * selectedTeamScoreTV can be either team A or team B
     */
    private void increaseScores() {
        int score = Integer.parseInt(selectedTeamScoreTV.getText().toString()); // parse String to int
        if (pointRG.getCheckedRadioButtonId() == R.id.point2RB) {
            selectedTeamScoreTV.setText(String.valueOf(score + 2));
        } else if (pointRG.getCheckedRadioButtonId() == R.id.point4RB) {
            selectedTeamScoreTV.setText(String.valueOf(score + 4));
        } else if (pointRG.getCheckedRadioButtonId() == R.id.point6RB) {
            selectedTeamScoreTV.setText(String.valueOf(score + 6));
        } else if (pointRG.getCheckedRadioButtonId() == R.id.point8RB) {
            selectedTeamScoreTV.setText(String.valueOf(score + 8));
        }
    }

    /**
     * this method checks which radio button is selected
     * set text of selectedTeamScoreTV after decrementing by 2,4,6,8 values
     * before decrementing it checks if the score is not less than the decrement value to avoid negative values
     * selectedTeamScoreTV can be either team A or team B
     */
    private void decreaseScores() {
        int score = Integer.parseInt(selectedTeamScoreTV.getText().toString()); // parse String into int
        if (pointRG.getCheckedRadioButtonId() == R.id.point2RB) {
            if (!(score < 2))
                selectedTeamScoreTV.setText(String.valueOf(score - 2));
            else selectedTeamScoreTV.setText(String.valueOf(0));
        } else if (pointRG.getCheckedRadioButtonId() == R.id.point4RB) {
            if (!(score < 4))
                selectedTeamScoreTV.setText(String.valueOf(score - 4));
            else selectedTeamScoreTV.setText(String.valueOf(0));
        } else if (pointRG.getCheckedRadioButtonId() == R.id.point6RB) {
            if (!(score < 6))
                selectedTeamScoreTV.setText(String.valueOf(score - 6));
            else selectedTeamScoreTV.setText(String.valueOf(0));
        } else if (pointRG.getCheckedRadioButtonId() == R.id.point8RB) {
            if (!(score < 8))
                selectedTeamScoreTV.setText(String.valueOf(score - 8));
            else selectedTeamScoreTV.setText(String.valueOf(0));
        }
    }
}