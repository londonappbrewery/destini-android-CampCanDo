package com.londonappbrewery.destini;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 *
 */
public class MainActivity extends AppCompatActivity {
    TextView sTextView;
    Button bTop;
    Button bBottom;
    int mStoryIndex;
    int mStories;
    int mTopAnswerB;
    int mBottomAnswerB;
    int mBNumber = 0;


    // TODO: Steps 4 & 8 - Declare member variables here:


    //  create story bank

    private StoryAnswers [] mStoryBank = new StoryAnswers []{
            new StoryAnswers(R.string.T1_Story,R.string.T1_Ans1, R.string.T1_Ans2),
            new StoryAnswers(R.string.T2_Story,R.string.T2_Ans1,R.string.T2_Ans2),
            new StoryAnswers(R.string.T3_Story,R.string.T3_Ans1,R.string.T3_Ans2),
            new StoryAnswers(R.string.T4_End,R.string.app_end, R.string.app_end),
            new StoryAnswers(R.string.T5_End,R.string.app_end, R.string.app_end),
            new StoryAnswers(R.string.T6_End,R.string.app_end, R.string.app_end),

    };
//}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        sTextView = (TextView)findViewById(R.id.storyTextView);
        bTop = (Button) findViewById(R.id.buttonTop);
        bBottom = (Button)findViewById(R.id.buttonBottom);

            //get the first story in array and display the story text
            mStories = mStoryBank[mStoryIndex].getStoryID();
            sTextView.setText(mStories);

            //Get the first answer in array and print it on the top button.
            mTopAnswerB = mStoryBank[mStoryIndex].getTopAnswerID();
            bTop.setText(mTopAnswerB);

            // Get the second answer in array and print it on the bottom button.
            mBottomAnswerB = mStoryBank[mStoryIndex].getButtomAnswerID();
            bBottom.setText(mBottomAnswerB);
            //mStoryIndex = mStoryIndex + 1;


            // TODO: Steps 6, 7, & 9 - Set a listener on the top button:;
            //TOP button click listener
            bTop.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //here we tell it what to do following a click action on top button
                   if (mStoryIndex == 0){
                        mStoryIndex = 2;
                        updateQuestionAnswers();

                    }else if (mStoryIndex == 2){
                       mStoryIndex = 5;
                       updateQuestionAnswers();

                    }else if (mStoryIndex == 5){
                        lastStoryActions ();

                    }else if (mStoryIndex == 1){
                       mStoryIndex = 2;
                       updateQuestionAnswers();
                   }

                }
            });

            // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
            //LOWER button click listener
            bBottom.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //here we tell it what to do following a click action on lower button
                    if (mStoryIndex == 0){
                        mStoryIndex = 1;
                        updateQuestionAnswers();

                    }else if (mStoryIndex == 1){
                        mStoryIndex = 3;
                        updateQuestionAnswers();

                    }else if (mStoryIndex == 3){
                        lastStoryActions ();

                    }else if (mStoryIndex == 2) {
                        mStoryIndex = 4;
                        updateQuestionAnswers();

                    }else if (mStoryIndex == 4) {
                        lastStoryActions();
                    }
                }
            });

        }

    //Create a method to increase the mStoryIndex by 1 to move to the next story
    private void updateQuestionAnswers() {
        //Hardcoded mStoryIndex = (mStoryIndex + 1) % 4; - NOT IDEAL change
        // to whatever the number of stories
        //mStoryIndex = (mStoryIndex + 1) % mStoryBank.length;
        //get the NEXT story and display the story text
        mStories = mStoryBank[mStoryIndex].getStoryID();
        sTextView.setText(mStories);

        //Get the NEXT answer for the TOP button and print it on the top button.
        mTopAnswerB = mStoryBank[mStoryIndex].getTopAnswerID();
        bTop.setText(mTopAnswerB);

        // Get the NEXT answer for the BOTTOM button and print it on the bottom button.
        mBottomAnswerB = mStoryBank[mStoryIndex].getButtomAnswerID();
        bBottom.setText(mBottomAnswerB);
    }

    private void lastStoryActions (){
        //Hide the buttons and put up a pop up to close the app
        bTop.setVisibility(View.GONE);
        bBottom.setVisibility(View.GONE);
        //Pop dialog to close the app
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("End of Stories");
        alert.setCancelable(false);
        alert.setMessage("The End");
        alert.setPositiveButton("Close Application", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        alert.show();

    }
   // private void checkButton(int userSelection){

   //    int onTopButton = mStoryBank[mStoryIndex].getTopAnswerID();
   //    if(userSelection == onTopButton){
    //       mBNumber = 1;
     //  }else{
    //       mBNumber = 2;
    //   }
    //}
}
