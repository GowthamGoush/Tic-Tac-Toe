package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

public class Main2Activity extends AppCompatActivity {

    public static final String Player_X_Name = "com.example.tic_tac_toe_PlayerX";
    public static final String Player_O_Name = "com.example.tic_tac_toe_PlayerO";
    String player1_text,player2_text;
    TextInputLayout playerXName,playerOName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        playerXName = findViewById(R.id.playerX);
        playerOName = findViewById(R.id.playerO);

        Button exitApp = findViewById(R.id.exitApp);
        exitApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveTaskToBack(true);
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(0);
            }
        });
    }

    public boolean checkInput1(){
        player1_text = Objects.requireNonNull(playerXName.getEditText()).getText().toString().trim();

        if(player1_text.isEmpty()){
            playerXName.setError("Field cannot be empty");
            return false;
        }
        else if(player1_text.length() > 10){
            playerXName.setError("Cannot exceed the limit");
            return false;
        }
        playerXName.setError(null);
        return true;
    }

    public boolean checkInput2(){
        player2_text = Objects.requireNonNull(playerOName.getEditText()).getText().toString().trim();

        if(player2_text.isEmpty()){
            playerOName.setError("Field cannot be empty");
            return false;
        }
        else if(player2_text.length() > 10){
            playerOName.setError("Cannot exceed the limit");
            return false;
        }
        playerOName.setError(null);
        return true;
    }

    public void btnStart(View v) {

        boolean a, b;
        a = checkInput1();
        b = checkInput2();

        if (a && b) {
            Intent intent2 = new Intent(this, Main3Activity.class);
            intent2.putExtra(Main2Activity.Player_X_Name,player1_text);
            intent2.putExtra(Main2Activity.Player_O_Name,player2_text);
            startActivity(intent2);
        }
    }

}
