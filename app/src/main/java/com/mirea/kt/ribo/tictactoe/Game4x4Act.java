package com.mirea.kt.ribo.tictactoe;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import java.util.Arrays;
import java.util.Random;

public class Game4x4Act extends AppCompatActivity {

    int counter = 0;
    int activePlayer = 0;
    int whichPlayer;
    boolean gameActive = true;
    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2};
    int[][] winPositions = {new int[]{0, 1, 2, 3}, new int[]{4, 5, 6, 7}, new int[]{8, 9, 10, 11}, new int[]{12, 13, 14, 15}, new int[]{0, 5, 10, 15}, new int[]{0, 4, 8, 12}, new int[]{1, 5, 9, 13}, new int[]{2, 6, 10, 14}, new int[]{3, 7, 11, 15}, new int[]{3, 6, 9, 12}};

    private int randomPlayer() {
        Random random = new Random();
        return random.nextInt(2) + 1;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_game4x4);
        String firstPlayerName = getIntent().getStringExtra("firstName");
        String secondPlayerName = getIntent().getStringExtra("secondName");
        if (this.whichPlayer == 1) {
            ((TextView) findViewById(R.id.whichPlayer)).setText("Ходит игрок: " + firstPlayerName);
            this.whichPlayer = 0;
        } else {
            ((TextView) findViewById(R.id.whichPlayer)).setText("Ходит игрок: " + secondPlayerName);
            this.whichPlayer = 1;
        }
    }

    public void playerTap(View view) {
        Log.i("viewClk", "Player click some view");
        String firstPlayerName = getIntent().getStringExtra("firstName");
        String secondPlayerName = getIntent().getStringExtra("secondName");
        ImageView imageView = (ImageView) view;
        int parseInt = Integer.parseInt(imageView.getTag().toString());
        int[] iArr = this.gameState;
        if (this.gameActive) {


            if (iArr[parseInt] == 2) {
                int i = counter + 1;
                counter = i;
                if (i == 16) {
                    this.gameActive = false;
                }
                iArr[parseInt] = this.activePlayer;
                imageView.setTranslationY(-1000.0f);
                if (this.activePlayer == 0) {
                    imageView.setImageResource(R.drawable.cross_svgrepo_com);
                    Log.i("setImage", "set image cross");
                    this.activePlayer = 1;
                    ((TextView) findViewById(R.id.whichPlayer)).setText("Ходит игрок: " + firstPlayerName);
                    ((TextView) findViewById(R.id.status)).setText("Ход ноликов");
                } else {
                    imageView.setImageResource(R.drawable.circle_svgrepo_com);
                    Log.i("setImage", "set image circle");
                    this.activePlayer = 0;
                    ((TextView) findViewById(R.id.whichPlayer)).setText("Ходит игрок: " + secondPlayerName);
                    ((TextView) findViewById(R.id.status)).setText("Ход крестиков");
                }
                imageView.animate().translationYBy(1000.0f).setDuration(300);
                Log.i("ImageAnimation", "animation");
            }
            boolean z = false;
            for (int[] iArr2 : this.winPositions) {
                int[] iArr3 = this.gameState;
                int i2 = iArr3[iArr2[0]];
                int i3 = iArr3[iArr2[1]];
                int i4 = iArr3[iArr2[2]];
                int i5 = iArr3[iArr2[3]];
                if (i2 == i3 && i4 == i5 && i3 == i4 && i2 != 2) {
                    this.gameActive = false;
                    DialogFragment dialog = new WinnerDialog();
                    Bundle bundle = new Bundle();
                    bundle.putString("winner", this.whichPlayer == 1 ? secondPlayerName : firstPlayerName);
                    Log.i("winner", "win");
                    dialog.setArguments(bundle);
                    dialog.show(getSupportFragmentManager(), "dialog");
                    Log.i("dialog", "show dialog");
                    counter = 0;
                    z = true;
                }
            }
            if (counter % 16 == 0 && !z) {
                counter = 0;
                DialogFragment dialog = new WinnerDialog();
                Bundle bundle = new Bundle();
                bundle.putString("winner", "Ничья");
                Log.i("StrWinner", "put str draw");
                dialog.setArguments(bundle);
                dialog.show(getSupportFragmentManager(), "dialog");
                Log.i("dialog", "show dialog");
            }
            if (iArr[parseInt] != 0 && iArr[parseInt] != 1 && this.gameActive) {
                if (this.whichPlayer == 1) {
                    ((TextView) findViewById(R.id.whichPlayer)).setText("Ходит игрок: " + firstPlayerName);
                    Log.i("move", "First P move");
                    this.whichPlayer = 0;
                } else {
                    ((TextView) findViewById(R.id.whichPlayer)).setText("Ходит игрок: " + secondPlayerName);
                    Log.i("move", "Second P move");
                    this.whichPlayer = 1;
                }
            }
        } else {
            counter = 0;
            Restart(view);
        }
    }

    public void Restart(View view) {
        this.whichPlayer = randomPlayer();
        this.gameActive = true;
        this.activePlayer = 0;
        int i = 0;
        while (true) {
            int[] iArr = this.gameState;
            if (i < iArr.length) {
                iArr[i] = 2;
                i++;
            } else {
                ((ImageView) findViewById(R.id.iv0)).setImageResource(0);
                ((ImageView) findViewById(R.id.iv1)).setImageResource(0);
                ((ImageView) findViewById(R.id.iv2)).setImageResource(0);
                ((ImageView) findViewById(R.id.iv3)).setImageResource(0);
                ((ImageView) findViewById(R.id.iv4)).setImageResource(0);
                ((ImageView) findViewById(R.id.iv5)).setImageResource(0);
                ((ImageView) findViewById(R.id.iv6)).setImageResource(0);
                ((ImageView) findViewById(R.id.iv7)).setImageResource(0);
                ((ImageView) findViewById(R.id.iv8)).setImageResource(0);
                ((ImageView) findViewById(R.id.iv9)).setImageResource(0);
                ((ImageView) findViewById(R.id.iv10)).setImageResource(0);
                ((ImageView) findViewById(R.id.iv11)).setImageResource(0);
                ((ImageView) findViewById(R.id.iv12)).setImageResource(0);
                ((ImageView) findViewById(R.id.iv13)).setImageResource(0);
                ((ImageView) findViewById(R.id.iv14)).setImageResource(0);
                ((ImageView) findViewById(R.id.iv15)).setImageResource(0);
                ((TextView) findViewById(R.id.status)).setText("Крестики начинают");
                String firstPlayerName = getIntent().getStringExtra("firstName");
                String secondPlayerName = getIntent().getStringExtra("secondName");
                if (this.whichPlayer == 1) {
                    ((TextView) findViewById(R.id.whichPlayer)).setText("Ходит игрок: " + firstPlayerName);
                    Log.i("move", "First P move");
                    this.whichPlayer = 0;
                } else {
                    ((TextView) findViewById(R.id.whichPlayer)).setText("Ходит игрок: " + secondPlayerName);
                    Log.i("move", "Second P move");
                    this.whichPlayer = 1;
                }
                return;
            }
        }
    }
}
