package com.example.progolf.basic_model1;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Show Decalartion

    private TextView txtQuestion;
    private ImageView imvIshihara;
    private RadioGroup ragAnswer;
    private RadioButton radChoice1,radChoice2,radChoice3,radChoice4;
    private Button  btnAnswer;

    private MyModel objMyModel;
    private int intRadioButton;
    private int intIndex ,MyScore = 0;
    private String StrChoice[];
    private int intUserChoose[];
    private int intAnswerTure[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // widget
        SetWidget();
        //About MyModel
        SetMyModel();
        // btnAnswer event
        SetBtnAnswer();
        // ragGroup event
        SetRadioAnswer();
        // Set choice
        //SetupChoice();
        // setupArraycheck
        setUpArray();




    }       //End OnCreate

    private void setUpArray() {
        intUserChoose = new int[10];    //ทำการสร้าง object array
        intAnswerTure = new int[10];    //ทำการสร้าง object arraytrue

        intAnswerTure[0] = 1;
        intAnswerTure[1] = 2;
        intAnswerTure[2] = 3;
        intAnswerTure[3] = 1;
        intAnswerTure[4] = 2;
        intAnswerTure[5] = 3;
        intAnswerTure[6] = 1;
        intAnswerTure[7] = 2;
        intAnswerTure[8] = 4;
        intAnswerTure[9] = 4;

    }

    private void SetupChoice() {
        radChoice1.setText(StrChoice[0]);
        radChoice2.setText(StrChoice[1]);
        radChoice3.setText(StrChoice[2]);
        radChoice4.setText(StrChoice[3]);
    }

    private void SetMyModel() {
        objMyModel = new MyModel();
        objMyModel.setOnMyModelChangeListener(new MyModel.OnMyModelChangeListener() {
            @Override
            public void onMyModelChangeListener(MyModel myModel) {
                Log.d("PWA5", "YOU Choose ==>" + String.valueOf(myModel.getIntRadio()));

                switch(objMyModel.getIntButton()){
                    case 2: imvIshihara.setImageResource(R.drawable.ishihara_02);
                        StrChoice = getResources().getStringArray(R.array.chk2);
                           break;
                    case 3: imvIshihara.setImageResource(R.drawable.ishihara_03);
                        StrChoice = getResources().getStringArray(R.array.chk3);
                           break;
                    case 4: imvIshihara.setImageResource(R.drawable.ishihara_04);
                        StrChoice = getResources().getStringArray(R.array.chk4);
                           break;
                    case 5: imvIshihara.setImageResource(R.drawable.ishihara_05);
                        StrChoice = getResources().getStringArray(R.array.chk5);
                           break;
                    case 6: imvIshihara.setImageResource(R.drawable.ishihara_06);
                        StrChoice = getResources().getStringArray(R.array.chk6);
                           break;
                    case 7: imvIshihara.setImageResource(R.drawable.ishihara_07);
                        StrChoice = getResources().getStringArray(R.array.chk7);
                           break;
                    case 8: imvIshihara.setImageResource(R.drawable.ishihara_08);
                        StrChoice = getResources().getStringArray(R.array.chk8);
                           break;
                    case 9: imvIshihara.setImageResource(R.drawable.ishihara_09);
                        StrChoice = getResources().getStringArray(R.array.chk9);
                           break;
                    case 10: imvIshihara.setImageResource(R.drawable.ishihara_10);
                        StrChoice = getResources().getStringArray(R.array.chk10);
                           break;


                } //end Switch
            }
        });
    }

    private void SetRadioAnswer() {
        ragAnswer.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                MediaPlayer SoundRadio = MediaPlayer.create(getBaseContext(), R.raw.effect_btn_shut);
                SoundRadio.start();

                  switch(checkedId){
                      case R.id.radioButton:
                          intRadioButton = 1;
                          break;
                      case R.id.radioButton2:
                          intRadioButton = 2;
                          break;
                      case R.id.radioButton3:
                          intRadioButton = 3;
                          break;
                      case R.id.radioButton4:
                          intRadioButton = 4;
                          break;
                      default:
                          intRadioButton = 0;
                          break;

                  } //event
             objMyModel.setIntRadio(intRadioButton);
            }
        });

    }// End SetRadioAnswer

    private void SetBtnAnswer() {
        btnAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer SoundBtn = MediaPlayer.create(getBaseContext(),R.raw.effect_btn_long);
                SoundBtn.start();
                //check Score

                //check Button
                if (intRadioButton == 0) {
                    Toast.makeText(MainActivity.this, "Please Choose Answer !!", Toast.LENGTH_LONG).show();
                } else {
                    checkScore();

                    if (intIndex == 9) {

                         //Show Intent
                        Intent objIntent = new Intent(MainActivity.this,ShowScoreActivity.class);

                        objIntent.putExtra("Score",MyScore);
                        startActivity(objIntent);
                        finish();

                    } else {

                        //Increate intIndex
                        intIndex++;

                        //SetUp Question
                        txtQuestion.setText(String.valueOf(intIndex+1)+". What is this ?");
                        objMyModel.setIntButton(intIndex+1);
                        SetupChoice();
                    }   //if2

                } // if1

            }
        });
    }  //End SetBtnAnswer

    private void checkScore() {

        intUserChoose[intIndex] = intRadioButton;

        if (intUserChoose[intIndex] == intAnswerTure[intIndex]) {
            MyScore++;
            Log.d("MyScore","===>"+MyScore);
        }
    }

    private void SetWidget() {
        txtQuestion = (TextView) findViewById(R.id.textView);
        imvIshihara = (ImageView) findViewById(R.id.imageView);
        ragAnswer = (RadioGroup) findViewById(R.id.radAnswer);
        radChoice1 = (RadioButton) findViewById(R.id.radioButton);
        radChoice2 = (RadioButton) findViewById(R.id.radioButton2);
        radChoice3 = (RadioButton) findViewById(R.id.radioButton3);
        radChoice4 = (RadioButton) findViewById(R.id.radioButton4);
        btnAnswer = (Button) findViewById(R.id.button);
    }


}       //End MainActivity
