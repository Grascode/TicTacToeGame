package com.mirea.kt.ribo.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class EnterLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_login);
        Button buttonContinue = findViewById(R.id.continueButton);
        EditText etFirstName = findViewById(R.id.etFirstName);
        EditText etSecondName = findViewById(R.id.etSecondName);
        buttonContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strFirstName = etFirstName.getText().toString();
                String strSecondName = etSecondName.getText().toString();
                if (!strFirstName.isEmpty() && !strSecondName.isEmpty()) {
                    Log.i("Names", strFirstName + ", " + strSecondName);
                    Intent intent = new Intent(EnterLogin.this, ChooseGameRuleAct.class);
                    intent.putExtra("firstName", strFirstName);
                    intent.putExtra("secondName", strSecondName);
                    startActivity(intent);
                    Log.i("namesExist", "open choose game activity");
                }else {
                    Toast.makeText(getApplicationContext(), R.string.fill_fields,
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}