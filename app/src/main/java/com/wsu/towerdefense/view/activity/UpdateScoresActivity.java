package com.wsu.towerdefense.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.mysql.jdbc.StringUtils;
import com.wsu.towerdefense.Model.Highscores.DBTools;
import com.wsu.towerdefense.R;

import java.util.Timer;
import java.util.TimerTask;

public class UpdateScoresActivity extends Activity {

    private String playerUsername;
    private int playerScore;

    private static volatile boolean showOverlay = true;

    private final int MAX_USERNAME_LENGTH = 25;
    private enum ERROR_TYPE {
        BLANK,
        OVER_CAPACITY
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_update_scores);
        onWindowFocusChanged(true);
        this.playerScore = getIntent().getIntExtra("score", 0);
        TextView scoreDisplayer = findViewById(R.id.txv_score);
        scoreDisplayer.setText(scoreDisplayer.getText() + " " + this.playerScore);
        displayWinOrLoss(true, true);
        Timer overlayTimer = new Timer();
        overlayTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(() -> displayWinOrLoss(false, true));
            }
        }, 5000);
    }

    public void btnSubmitOnClick(View view) {
        EditText textField = findViewById(R.id.plt_username);
        this.playerUsername = textField.getText().toString();
        if (StringUtils.isEmptyOrWhitespaceOnly(this.playerUsername)){
            displayError(ERROR_TYPE.BLANK);
            return;
        }
        else if (this.playerUsername.length() > this.MAX_USERNAME_LENGTH){
            displayError(ERROR_TYPE.OVER_CAPACITY);
            return;
        }
        DBTools dbt = new DBTools();
        dbt.initUsernameAndScore(this.playerUsername, this.playerScore);
        dbt.execute();
        finishAffinity();
        Intent intent = new Intent(UpdateScoresActivity.this, MainActivity.class);
        startActivity(intent);
    }

    public void displayError(ERROR_TYPE error_type){
        findViewById(R.id.img_error_symbol).setBackgroundResource(R.mipmap.error_symbol);
        String errorMessage = "";
        switch (error_type) {
            case BLANK:
                errorMessage = "No username entered";
                break;
            case OVER_CAPACITY:
                errorMessage = "Username too long";
                break;
        }
        ((TextView) findViewById(R.id.txv_error_msg)).setText(errorMessage);
    }

    private void displayWinOrLoss(boolean display, boolean didWin){
        ImageView tint = findViewById(R.id.img_tint);
        Button submitButton = findViewById(R.id.btn_submit);
        tint.setVisibility(display ? View.VISIBLE : View.INVISIBLE);
        submitButton.setVisibility(display ? View.INVISIBLE : View.VISIBLE);
        if (!display){
            findViewById(R.id.gifImageView).setVisibility(View.INVISIBLE);
        }
    }

}



