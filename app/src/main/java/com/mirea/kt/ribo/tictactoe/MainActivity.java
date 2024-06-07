package com.mirea.kt.ribo.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.DialogFragment;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button startBtn = findViewById(R.id.startBtn);
        ImageButton infoBtn = findViewById(R.id.infoBtn);
        EditText pass = findViewById(R.id.pass);
        EditText log = findViewById(R.id.log);
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, EnterLogin.class));
                Log.i("continueClc", "open enterLogin");
            }
        });
        infoBtn.setOnClickListener(v -> {
            Log.i("buttonTouch", "button touch");
            String g = "RIBO-04-22";
            String login = log.getText().toString();
            String password = pass.getText().toString();
            if (!login.isEmpty() && !password.isEmpty()) {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("lgn", login);
                hashMap.put("pwd", password);
                hashMap.put("g", g);
                HTTPRunnable httpRunnable = new HTTPRunnable("https://android-for-students.ru/coursework/login.php", hashMap);
                Thread th = new Thread(httpRunnable);
                th.start();
                try {
                    th.join();
                    Log.i("postRequest", "post request sent");
                } catch (InterruptedException exception) {
                    throw new RuntimeException(exception);
                } finally {
                    try{
                        JSONObject jsonObject = new JSONObject(httpRunnable.getResponseBody());
                        Log.i("jsonReceived", "student exist");
                        int result = jsonObject.getInt("result_code");
                        if (result == 1) {
                            Log.i("studentIsExist", "student exist");
                            DialogFragment dialog = new TSDialog();
                            Bundle bundle = new Bundle();
                            bundle.putString("title", jsonObject.getString("title"));
                            Log.i("valueAdded", "value added title");
                            bundle.putString("task", jsonObject.getString("task"));
                            Log.i("valueAdded", "value added task");
                            dialog.setArguments(bundle);
                            dialog.show(getSupportFragmentManager(), "dialog");

                        } else if (result == -1) {
                            Toast.makeText(getApplicationContext(), R.string.incorrect_data,
                                    Toast.LENGTH_SHORT).show();
                        }
                    } catch (NullPointerException | JSONException exception) {
                        Toast.makeText(getApplicationContext(), R.string.the_server_is_not_responding,
                                Toast.LENGTH_SHORT).show();
                    }
                }
            } else {
                Toast.makeText(getApplicationContext(), R.string.fill_fields,
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}