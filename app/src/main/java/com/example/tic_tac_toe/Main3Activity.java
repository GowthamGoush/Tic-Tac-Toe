package com.example.tic_tac_toe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.muddzdev.styleabletoast.StyleableToast;

import java.util.Random;
import java.util.zip.Inflater;

public class Main3Activity extends AppCompatActivity {

    private String PlayerX="X",PlayerO="O";
    private int turn=0,won=0;
    private int[] ifClicked,clickedX,clickedO;
    Animation animation,animation2;
    ImageView cross_v1,cross_v2,cross_v3,cross_h1,cross_h2,cross_h3,cross_d1,cross_d2;
    ImageView retry;
    MediaPlayer mediaPlayer1,mediaPlayer2,mediaPlayer3;
    String NAME="com.example.tic_tac_toe";
    String name1="Player1",name2="Player2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        retry = findViewById(R.id.retry_btn);

        mediaPlayer1 = MediaPlayer.create(this,R.raw.sound1);
        mediaPlayer2 = MediaPlayer.create(this,R.raw.sound2);
        mediaPlayer3 = MediaPlayer.create(this,R.raw.sound3);

        animation = AnimationUtils.loadAnimation(this,R.anim.slide_anim);
        animation.setDuration(3000);

        animation2 = AnimationUtils.loadAnimation(this,R.anim.slide_anim2);
        animation2.setDuration(3000);

        cross_v1 = findViewById(R.id.cross_center1);
        cross_v2 = findViewById(R.id.cross_ver1);
        cross_v3 = findViewById(R.id.cross_ver2);

        cross_d1 = findViewById(R.id.cross_diag1);
        cross_d2 = findViewById(R.id.cross_diag2);

        cross_h1 = findViewById(R.id.cross_center2);
        cross_h2 = findViewById(R.id.cross_hor1);
        cross_h3 = findViewById(R.id.cross_hor2);

        ImageView Grid = findViewById(R.id.grid);
        Grid.animate().alpha(1.0f).setDuration(2000);

        ifClicked = new int[9];
        clickedX = new int[9];
        clickedO = new int[9];

        for(int i=0;i<9;i++){
            ifClicked[i]=0;
        }

        for(int i=0;i<9;i++){
            clickedX[i]=0;
        }

        for(int i=0;i<9;i++){
            clickedO[i]=0;
        }

        Intent intent3 = getIntent();

        Random random = new Random();
        int num=0;
        num = random.nextInt(2);

        SharedPreferences sharedPreferences = getSharedPreferences(NAME,MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        if(num==1) {
            PlayerX = intent3.getStringExtra(Main2Activity.Player_X_Name);
            PlayerO = intent3.getStringExtra(Main2Activity.Player_O_Name);
        }
        else {
            PlayerO = intent3.getStringExtra(Main2Activity.Player_X_Name);
            PlayerX = intent3.getStringExtra(Main2Activity.Player_O_Name);
        }

        if(PlayerX == null && PlayerO == null){
            SharedPreferences sharedPreferences2 = getSharedPreferences(NAME,MODE_PRIVATE);
            PlayerX = sharedPreferences2.getString(name1,null);
            PlayerO = sharedPreferences2.getString(name2,null);
        }

        editor.putString(name1,PlayerX);
        editor.putString(name2,PlayerO);
        editor.apply();

        TextView textPlayerX,textPlayerO;

        textPlayerX = findViewById(R.id.text_playerX);
        textPlayerO = findViewById(R.id.text_playerO);

        textPlayerX.setText("X  :  "+PlayerX);
        textPlayerO.setText("O  :  "+PlayerO);

        final TextView left1,left2,left3,center1,center2,center3,right1,right2,right3;

        left1 = findViewById(R.id.left1);
        left2 = findViewById(R.id.left2);
        left3 = findViewById(R.id.left3);

        left1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(turn==0 && ifClicked[0]==0){
                    left1.setText("X");
                    turn = 1;
                    ifClicked[0]=1;
                    clickedX[0]=1;
                    Checker();
                }
                else if(turn==1 && ifClicked[0]==0){
                    left1.setText("O");
                    turn = 0;
                    ifClicked[0]=1;
                    clickedO[0]=1;
                    Checker();
                }

            }
        });

        left2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(turn==0 && ifClicked[1]==0){
                    left2.setText("X");
                    turn = 1;
                    ifClicked[1]=1;
                    clickedX[1]=1;
                    Checker();
                }
                else if(turn==1 && ifClicked[1]==0){
                    left2.setText("O");
                    turn = 0;
                    ifClicked[1]=1;
                    clickedO[1]=1;
                    Checker();
                }
            }
        });

        left3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(turn==0 && ifClicked[2]==0){
                    left3.setText("X");
                    turn = 1;
                    ifClicked[2]=1;
                    clickedX[2]=1;
                    Checker();
                }
                else if(turn==1 && ifClicked[2]==0){
                    left3.setText("O");
                    turn = 0;
                    ifClicked[2]=1;
                    clickedO[2]=1;
                    Checker();
                }
            }
        });

        center1 = findViewById(R.id.center1);
        center2 = findViewById(R.id.center2);
        center3 = findViewById(R.id.center3);

        center1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(turn==0 && ifClicked[3]==0){
                    center1.setText("X");
                    turn = 1;
                    ifClicked[3]=1;
                    clickedX[3]=1;
                    Checker();
                }
                else if(turn==1 && ifClicked[3]==0){
                    center1.setText("O");
                    turn = 0;
                    ifClicked[3]=1;
                    clickedO[3]=1;
                    Checker();
                }
            }
        });

        center2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(turn==0 && ifClicked[4]==0){
                    center2.setText("X");
                    turn = 1;
                    ifClicked[4]=1;
                    clickedX[4]=1;
                    Checker();
                }
                else if(turn==1 && ifClicked[4]==0){
                    center2.setText("O");
                    turn = 0;
                    ifClicked[4]=1;
                    clickedO[4]=1;
                    Checker();
                }
            }
        });

        center3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(turn==0 && ifClicked[5]==0){
                    center3.setText("X");
                    turn = 1;
                    ifClicked[5]=1;
                    clickedX[5]=1;
                    Checker();
                }
                else if(turn==1 && ifClicked[5]==0){
                    center3.setText("O");
                    turn = 0;
                    ifClicked[5]=1;
                    clickedO[5]=1;
                    Checker();
                }
            }
        });

        right1 = findViewById(R.id.right1);
        right2 = findViewById(R.id.right2);
        right3 = findViewById(R.id.right3);

        right1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(turn==0 && ifClicked[6]==0){
                    right1.setText("X");
                    turn = 1;
                    ifClicked[6]=1;
                    clickedX[6]=1;
                    Checker();
                }
                else if(turn==1 && ifClicked[6]==0){
                    right1.setText("O");
                    turn = 0;
                    ifClicked[6]=1;
                    clickedO[6]=1;
                    Checker();
                }
            }
        });

        right2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(turn==0 && ifClicked[7]==0){
                    right2.setText("X");
                    turn = 1;
                    ifClicked[7]=1;
                    clickedX[7]=1;
                    Checker();
                }
                else if(turn==1 && ifClicked[7]==0){
                    right2.setText("O");
                    turn = 0;
                    ifClicked[7]=1;
                    clickedO[7]=1;
                    Checker();
                }
            }
        });

        right3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(turn==0 && ifClicked[8]==0){
                    right3.setText("X");
                    turn = 1;
                    ifClicked[8]=1;
                    clickedX[8]=1;
                    Checker();
                }
                else if(turn==1 && ifClicked[8]==0){
                    right3.setText("O");
                    turn = 0;
                    ifClicked[8]=1;
                    clickedO[8]=1;
                    Checker();
                }
            }
        });

    }

    public void retryGame(View v){
        Intent intent5 = new Intent(this,Main3Activity.class);
        startActivity(intent5);
    }

    public void Checker() {
        if (ifClicked[0] == 1 && ifClicked[1] == 1 && ifClicked[2] == 1) {
            if (clickedX[0] == 1 && clickedX[1] == 1 && clickedX[2] == 1) {
                turn = 3;
                cross_v2.setAlpha(1.0f);
                cross_v2.startAnimation(animation);
                customToaster();
                won=1;
            } else if (clickedO[0] == 1 && clickedO[1] == 1 && clickedO[2] == 1) {
                turn = 4;
                cross_v2.setAlpha(1.0f);
                cross_v2.startAnimation(animation);
                customToaster();
                won=1;
            }
        }
        if (ifClicked[3] == 1 && ifClicked[4] == 1 && ifClicked[5] == 1) {
            if (clickedX[3] == 1 && clickedX[4] == 1 && clickedX[5] == 1) {
                turn = 3;
                cross_v1.setAlpha(1.0f);
                cross_v1.startAnimation(animation);
                customToaster();
                won=1;
            } else if (clickedO[3] == 1 && clickedO[4] == 1 && clickedO[5] == 1) {
                turn = 4;
                cross_v1.setAlpha(1.0f);
                cross_v1.startAnimation(animation);
                customToaster();
                won=1;
            }
        }
        if (ifClicked[6] == 1 && ifClicked[7] == 1 && ifClicked[8] == 1) {
            if (clickedX[6] == 1 && clickedX[7] == 1 && clickedX[8] == 1) {
                turn = 3;
                cross_v3.setAlpha(1.0f);
                cross_v3.startAnimation(animation);
                customToaster();
                won=1;
            } else if (clickedO[6] == 1 && clickedO[7] == 1 && clickedO[8] == 1) {
                turn = 4;
                cross_v3.setAlpha(1.0f);
                cross_v3.startAnimation(animation);
                customToaster();
                won=1;
            }
        }
        if (ifClicked[0] == 1 && ifClicked[3] == 1 && ifClicked[6] == 1) {
            if (clickedX[0] == 1 && clickedX[3] == 1 && clickedX[6] == 1) {
                turn = 3;
                cross_h2.setAlpha(1.0f);
                cross_h2.startAnimation(animation2);
                customToaster();
                won=1;
            } else if (clickedO[0] == 1 && clickedO[3] == 1 && clickedO[6] == 1) {
                turn = 4;
                cross_h2.setAlpha(1.0f);
                cross_h2.startAnimation(animation2);
                customToaster();
                won=1;
            }
        }
        if (ifClicked[1] == 1 && ifClicked[4] == 1 && ifClicked[7] == 1) {
            if (clickedX[1] == 1 && clickedX[4] == 1 && clickedX[7] == 1) {
                turn = 3;
                cross_h1.setAlpha(1.0f);
                cross_h1.startAnimation(animation2);
                customToaster();
                won=1;
            } else if (clickedO[1] == 1 && clickedO[4] == 1 && clickedO[7] == 1) {
                turn = 4;
                cross_h1.setAlpha(1.0f);
                cross_h1.startAnimation(animation2);
                customToaster();
                won=1;
            }
        }
        if (ifClicked[2] == 1 && ifClicked[5] == 1 && ifClicked[8] == 1) {
            if (clickedX[2] == 1 && clickedX[5] == 1 && clickedX[8] == 1) {
                turn = 3;
                cross_h1.setAlpha(1.0f);
                cross_h3.startAnimation(animation2);
                customToaster();
                won=1;
            } else if (clickedO[2] == 1 && clickedO[5] == 1 && clickedO[8] == 1) {
                turn = 4;
                cross_h1.setAlpha(1.0f);
                cross_h3.startAnimation(animation2);
                customToaster();
                won=1;
            }
        }
        if (ifClicked[0] == 1 && ifClicked[4] == 1 && ifClicked[8] == 1) {
            if (clickedX[0] == 1 && clickedX[4] == 1 && clickedX[8] == 1) {
                turn = 3;
                cross_d2.setAlpha(1.0f);
                cross_d2.startAnimation(animation);
                customToaster();
                won=1;
            } else if (clickedO[0] == 1 && clickedO[4] == 1 && clickedO[8] == 1) {
                turn = 4;
                cross_d2.setAlpha(1.0f);
                cross_d2.startAnimation(animation);
                customToaster();
                won=1;
            }
        }
        if (ifClicked[2] == 1 && ifClicked[4] == 1 && ifClicked[6] == 1) {
            if (clickedX[2] == 1 && clickedX[4] == 1 && clickedX[6] == 1) {
                turn = 3;
                cross_d1.setAlpha(1.0f);
                cross_d1.startAnimation(animation);
                customToaster();
                won=1;
            } else if (clickedO[2] == 1 && clickedO[4] == 1 && clickedO[6] == 1) {
                turn = 4;
                cross_d1.setAlpha(1.0f);
                cross_d1.startAnimation(animation);
                customToaster();
                won=1;
            }
        }
        if (ifClicked[0] == 1 && ifClicked[1] == 1 && ifClicked[2] == 1 && ifClicked[3] == 1 && ifClicked[4] == 1 && ifClicked[5] == 1 && ifClicked[6] == 1 && ifClicked[7] == 1 && ifClicked[8] == 1 && won==0) {
            mediaPlayer3.start();
            StyleableToast.makeText(this, "Draw !", R.style.CustomToast).show();
            retry.setAlpha(1.0f);
            retry.animate().rotation(-360).setDuration(2000);
            turn = 5;
        }
    }

    public void customToaster(){
       if(turn==3){
           CountDownTimer countDownTimer = new CountDownTimer(3000,1000) {
               @Override
               public void onTick(long millisUntilFinished) {

               }

               @Override
               public void onFinish() {
                   mediaPlayer1.start();
                   StyleableToast.makeText(Main3Activity.this,"X Wins !",R.style.CustomToast).show();
                   retry.setAlpha(1.0f);
                   retry.animate().rotation(-360).setDuration(2000);
               }
           }.start();
       }
       else if(turn==4){
           CountDownTimer countDownTimer = new CountDownTimer(3000,1000) {
               @Override
               public void onTick(long millisUntilFinished) {

               }

               @Override
               public void onFinish() {
                   mediaPlayer2.start();
                   StyleableToast.makeText(Main3Activity.this,"O Wins !",R.style.CustomToast).show();
                   retry.setAlpha(1.0f);
                   retry.animate().rotation(-360).setDuration(2000);
               }
           }.start();
       }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_bar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.exit_game){
            Intent intent4 = new Intent(this,Main2Activity.class);
            startActivity(intent4);
        }
        return super.onOptionsItemSelected(item);
    }
}
