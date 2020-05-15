package com.example.android.cra2ycourtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.android.cra2ycourtcounter.R;

public class MainActivity extends AppCompatActivity {
int scoreA = 0,scoreB=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void PlusOneA(View view) {
        scoreA += 1;
        DisplayForTeamA(scoreA);
    }

    public void PlusTwoA(View view) {
        scoreA += 2;
        DisplayForTeamA(scoreA);
    }

    public void PlusThreeA(View view) {
        scoreA += 3;
        DisplayForTeamA(scoreA);
    }

    public void PlusOneB(View view) {
        scoreB += 1;
        DisplayForTeamB(scoreB);
    }

    public void PlusTwoB(View view) {
        scoreB += 2;
        DisplayForTeamB(scoreB);
    }

    public void PlusThreeB(View view) {
        scoreB += 3;
        DisplayForTeamB(scoreB);
    }

    public void DisplayForTeamA(int n) {
        TextView t = (TextView) findViewById(R.id.team_a_score);
        t.setText(String.valueOf(n));
    }

    public void DisplayForTeamB(int n) {
        TextView te = (TextView) findViewById(R.id.team_b_score);
        te.setText(String.valueOf(n));
    }

    public void reset(View v) {
        scoreA = 0;
        scoreB = 0;
        DisplayForTeamA(scoreA);
        DisplayForTeamB(scoreB);
    }
}
