package com.example.dell.connect4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int activePlayer = 0;
    boolean gameActive = true;
    int[] state = {2,2,2,2,2,2,2,2,2,};
    int[][] winningmoves = {{0,1,2}, {3,4,5}, {6,7,8}, {0,3,6}, {1,4,7}, {2,5,8}, {0,4,8}, {2,4,6}};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void dive(View view) {

        ImageView img = (ImageView)view;
        int tg = Integer.parseInt(img.getTag().toString());
        if(state[tg] == 2 && gameActive) {
            state[tg] = activePlayer;
            img.setTranslationY(-1000f);
            if (activePlayer == 0) {
                img.setImageResource(R.drawable.yellow);
                activePlayer = 1;
            } else {
                img.setImageResource(R.drawable.red);
                activePlayer = 0;
            }
            img.animate().translationYBy(1000f);

        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 3; j++) {
                if (state[winningmoves[i][0]] == state[winningmoves[i][1]] && state[winningmoves[i][1]] == state[winningmoves[i][2]] &&
                        state[winningmoves[i][0]] != 2){
String winner = "Red";
gameActive = false;
if(activePlayer == 1)
    winner = "Yellow";
                    TextView txt = (TextView)findViewById(R.id.textView);
                    txt.setText(winner + " has won ");
                    LinearLayout lin = (LinearLayout)findViewById(R.id.ll);
                    lin.setVisibility(view.VISIBLE);
                }else{
                    boolean gameover = true;
                    for(int val : state){
                        if (val == 2) gameover = false;

                    }if (gameover == true){
                        TextView txt = (TextView)findViewById(R.id.textView);
                        txt.setText(" Its a draw ");
                        LinearLayout lin = (LinearLayout)findViewById(R.id.ll);
                        lin.setVisibility(view.VISIBLE);
                    }

                }
            }
        }

        }
    }

    public void resetgame(View view) {
gameActive = true;
        LinearLayout lin = (LinearLayout)findViewById(R.id.ll);
        lin.setVisibility(view.INVISIBLE);

for (int i = 0; i < state.length; i++){
    state[i] = 2;
}
        GridLayout grid = (GridLayout)findViewById(R.id.gd);

for(int i = 0; i < grid.getChildCount(); i++){
    ((ImageView)grid.getChildAt(i)).setImageResource(0);
}


    }
}
