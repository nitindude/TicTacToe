package com.example.nitin.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    int activePlayer = 0;
    // 0 is for cross and 1 is for circle

    int[] gameState = {2,2,2,2,2,2,2,2,2};

    public void imageTapped(View view){


        ImageView myTapped = (ImageView ) view;

        //Log.i("tag is ", "image number is " + myTapped.getTag().toString());
        int tappedImageTag = Integer.parseInt(myTapped.getTag().toString());

        if (gameState[tappedImageTag] == 2){
            gameState[tappedImageTag] = activePlayer;
            if (activePlayer == 0){
                myTapped.setImageResource(R.drawable.imagex);
                myTapped.animate().rotationBy(360).setDuration(500);
                activePlayer = 1;

            }

            else {

                myTapped.setImageResource(R.drawable.imageo);
                myTapped.animate().rotationBy(360).setDuration(500);
                activePlayer = 0;

            }

        }
        else{
            Toast.makeText(MainActivity.this,"Y" +
                    "" +
                    "" +
                    "ou already tapped here", Toast.LENGTH_SHORT).show();
        }



    }
//     change game state back to 2

    public void playAgain (View view){

        for ( int i = 0; i < gameState.length; i++){

            gameState[i] = 2;
        }
//       make active player 0 again
        activePlayer = 0 ;

//        change all image to it's initial stage

        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.lineone);

        for (int i = 0 ; i < linearLayout.getChildCount(); i++){

            ((ImageView) linearLayout.getChildAt(i)).setImageResource(R.drawable.images);

        }

        LinearLayout linearLayoutOne = (LinearLayout) findViewById(R.id.linetwo);

        for (int i = 0 ; i < linearLayoutOne.getChildCount(); i++){

            ((ImageView) linearLayoutOne.getChildAt(i)).setImageResource(R.drawable.images);

        }

        LinearLayout linearLayoutTwo = (LinearLayout) findViewById(R.id.lineThree);

        for (int i = 0 ; i < linearLayoutTwo.getChildCount(); i++){

            ((ImageView) linearLayoutTwo.getChildAt(i)).setImageResource(R.drawable.images);

        }
//        Log.i("msg","Play again tapped");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
