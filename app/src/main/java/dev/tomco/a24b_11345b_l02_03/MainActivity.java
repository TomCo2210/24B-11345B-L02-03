package dev.tomco.a24b_11345b_l02_03;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;

import dev.tomco.a24b_11345b_l02_03.Logic.GameManager;

public class MainActivity extends AppCompatActivity {

    private MaterialTextView main_LBL_score;
    private MaterialButton main_BTN_yes;
    private MaterialButton main_BTN_no;

    private MaterialTextView main_LBL_countryName;
    private AppCompatImageView main_IMG_flag;
    private AppCompatImageView[] main_IMG_hearts;
    private GameManager gameManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });

        findViews();
        gameManager = new GameManager(main_IMG_hearts.length);
        initViews();
    }

    private void initViews() {
        main_LBL_score.setText(String.valueOf(gameManager.getScore()));
        main_BTN_yes.setOnClickListener(v -> answerClicked(true));
        main_BTN_no.setOnClickListener(v -> answerClicked(false));
        refreshUI();
    }

    private void answerClicked(boolean answer) {
        gameManager.checkAnswer(answer);
        refreshUI();
    }

    private void refreshUI() {
        //Lost:
        if (gameManager.isGameLost()){
            Log.d("Game Status:", "GAME OVER! " + gameManager.getScore());
            changeActivity("😭\nGAME OVER!", gameManager.getScore());
        }
        //Win:
        else if (gameManager.isGameEnded()){
            Log.d("Game Status:", "YOU WON! " + gameManager.getScore());
            changeActivity("🥳\nYOU WON!", gameManager.getScore());
        }
        //GAME ON!
        else{
            main_LBL_score.setText(String.valueOf(gameManager.getScore()));
            main_LBL_countryName.setText(String.valueOf(gameManager.getCurrentCountry().getName()));
            main_IMG_flag.setImageResource(gameManager.getCurrentCountry().getFlagImage());
            if (gameManager.getWrongAnswers() != 0){
                main_IMG_hearts[main_IMG_hearts.length - gameManager.getWrongAnswers()]
                        .setVisibility(View.INVISIBLE);
            }

        }

    }

    private void changeActivity(String status, int score) {
        Intent intent = new Intent(this, ScoreActivity.class);
        intent.putExtra(ScoreActivity.KEY_STATUS, status);
        intent.putExtra(ScoreActivity.KEY_SCORE, score);
        startActivity(intent);
        finish();
    }


    private void findViews() {
        main_LBL_score = findViewById(R.id.main_LBL_score);
        main_BTN_yes = findViewById(R.id.main_BTN_yes);
        main_BTN_no = findViewById(R.id.main_BTN_no);
        main_LBL_countryName = findViewById(R.id.main_LBL_countryName);
        main_IMG_flag = findViewById(R.id.main_IMG_flag);
        main_IMG_hearts = new AppCompatImageView[]{
                findViewById(R.id.main_IMG_heart1),
                findViewById(R.id.main_IMG_heart2),
                findViewById(R.id.main_IMG_heart3)
        };
    }
}