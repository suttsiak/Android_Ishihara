package com.example.progolf.basic_model1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class ShowScoreActivity extends AppCompatActivity {

    private TextView txtShowScore;
    private int intMyScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_score);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //Initial Widget
        txtShowScore = (TextView) findViewById(R.id.txtShowScore);

        intMyScore = getIntent().getExtras().getInt("Score");
        txtShowScore.setText(String.valueOf(intMyScore) + "/10");
       /* Bundle bundle = getIntent().getExtras();
         if(bundle != null) {
             intMyScore = bundle.getInt("Score");
             Log.d("MyScore", "===>MyScore:" + intMyScore);
             txtShowScore.setText(String.valueOf(intMyScore) + "/10");
         }
         */
    } // end of OnCreate
       public void ClickExit(View view) {
           finish();
       }
       public void ClickPlay(View view) {
           Intent objIntent = new Intent(ShowScoreActivity.this, MainActivity.class);
           startActivity(objIntent);
           finish();
       }

}       //End of Activity
