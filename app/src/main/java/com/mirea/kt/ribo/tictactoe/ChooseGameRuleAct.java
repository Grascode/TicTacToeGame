package com.mirea.kt.ribo.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ChooseGameRuleAct extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
        Button button3x3 = findViewById(R.id.btn3x3);
        Button button4x4 = findViewById(R.id.btn4x4);
        button3x3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChooseGameRuleAct.this, Game3x3Act.class);
                intent.putExtra("firstName", getIntent().getStringExtra("firstName"));
                intent.putExtra("secondName", getIntent().getStringExtra("secondName"));
                startActivity(intent);
                Log.i("3x3btnClk", "open Game3x3");
            }
        });
        button4x4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChooseGameRuleAct.this, Game4x4Act.class);
                intent.putExtra("firstName", getIntent().getStringExtra("firstName"));
                intent.putExtra("secondName", getIntent().getStringExtra("secondName"));
                startActivity(intent);
                Log.i("3x3btnClk", "open Game4x4");
            }
        });
    }
}
