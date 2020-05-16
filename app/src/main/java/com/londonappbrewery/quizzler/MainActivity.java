package com.londonappbrewery.quizzler;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
int PROGRESS_BAR_INCREMENT=8;
int scoreInc;
    // TODO: Declare constants here


    // TODO: Declare member variables here:
    Button trueButton,falseButton;
    int index,question;
    TextView txtQuestion;
    TextView score;
    ProgressBar mProgressBar;
    // TODO: Uncomment to create question bank
    private TrueFalse[] mQuestionBank = new TrueFalse[] {
            new TrueFalse(R.string.question_1, true),
            new TrueFalse(R.string.question_2, true),
            new TrueFalse(R.string.question_3, true),
            new TrueFalse(R.string.question_4, true),
            new TrueFalse(R.string.question_5, true),
            new TrueFalse(R.string.question_6, false),
            new TrueFalse(R.string.question_7, true),
            new TrueFalse(R.string.question_8, false),
            new TrueFalse(R.string.question_9, true),
            new TrueFalse(R.string.question_10,true),
            new TrueFalse(R.string.question_11,false),
            new TrueFalse(R.string.question_12,false),
            new TrueFalse(R.string.question_13,true)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        trueButton=(Button)findViewById(R.id.true_button);
        falseButton=(Button)findViewById(R.id.false_button);
        txtQuestion=(TextView)findViewById(R.id.question_text_view);
        mProgressBar=(ProgressBar)findViewById(R.id.progress_bar);
        score=(TextView)findViewById(R.id.score);

          question=mQuestionBank[index].getQuestionId();
          txtQuestion.setText(question);



        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {

              checkAns(true);
                update();
            }
        });
       falseButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view)
           {


               checkAns(false);
               update();
           }


       });


    }
  public void update()
  {
      index=(index+1) % mQuestionBank.length;
      if(index==0)
      {
          AlertDialog.Builder alertDialog= new AlertDialog.Builder(this);
          alertDialog.setTitle("Game Over");
          alertDialog.setCancelable(false);
          alertDialog.setMessage("Your Score "+scoreInc+" Points!");
          alertDialog.setPositiveButton("Close Application", new DialogInterface.OnClickListener() {
              @Override
              public void onClick(DialogInterface dialogInterface, int i)
              {
                finish();
              }
          });
         alertDialog.show();
      }

      question=mQuestionBank[index].getQuestionId();
      txtQuestion.setText(question);
      mProgressBar.incrementProgressBy(PROGRESS_BAR_INCREMENT);
      score.setText("Score "+scoreInc+"/"+mQuestionBank.length);
  }
   public  void checkAns(boolean userSelection)
   {
    boolean correctAns=mQuestionBank[index].isAns();
    if(userSelection==correctAns) {
        Toast.makeText(this, R.string.correct_toast, Toast.LENGTH_SHORT).show();
             scoreInc++;

    }
    else
        Toast.makeText(this, R.string.incorrect_toast, Toast.LENGTH_SHORT).show();
   }
}
