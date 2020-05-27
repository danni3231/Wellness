package com.parrotgames.wellness;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class SelectActivity extends AppCompatActivity {

    private TextView nameTextSE;
    private TextView textViewSE;
    private TextView textView1SE;
    private TextView emotionalTextSE;
    private TextView physicalTextSE;
    private Button startTrainingBtn;
    private TextView logOutText;

    private ConstraintLayout bg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);

        nameTextSE = findViewById(R.id.nameTextSE);
        textViewSE = findViewById(R.id.textViewSE);
        textView1SE = findViewById(R.id.textView1SE);
        emotionalTextSE = findViewById(R.id.emotionalTextSE);
        physicalTextSE = findViewById(R.id.physicalTextSE);
        startTrainingBtn = findViewById(R.id.startTrainingBtn);
        logOutText = findViewById(R.id.logOutTextSE);

        bg = findViewById(R.id.bg);

        physicalTextSE.setOnClickListener(
                (v)->{
                    bg.setBackgroundColor(Color.rgb(100,42,128));
                    nameTextSE.setTextColor(Color.WHITE);
                    textViewSE.setTextColor(Color.WHITE);
                    textView1SE.setTextColor(Color.WHITE);
                    emotionalTextSE.setTextColor(Color.WHITE);
                    emotionalTextSE.setTextSize(18);
                    physicalTextSE.setTextColor(Color.WHITE);
                    physicalTextSE.setTextSize(28);
                    logOutText.setTextColor(Color.WHITE);

                    startTrainingBtn.setTextColor(Color.rgb(100,42,128));
                    startTrainingBtn.setBackground(getResources().getDrawable(R.drawable.button_2));
                }
        );

        emotionalTextSE.setOnClickListener(
                (v)->{
                    bg.setBackgroundColor(Color.WHITE);
                    nameTextSE.setTextColor(Color.rgb(100,42,128));
                    textViewSE.setTextColor(Color.rgb(100,42,128));
                    textView1SE.setTextColor(Color.rgb(100,42,128));
                    emotionalTextSE.setTextColor(Color.rgb(100,42,128));
                    emotionalTextSE.setTextSize(28);
                    physicalTextSE.setTextColor(Color.rgb(100,42,128));
                    physicalTextSE.setTextSize(18);
                    logOutText.setTextColor(Color.rgb(100,42,128));

                    startTrainingBtn.setTextColor(Color.WHITE);
                    startTrainingBtn.setBackground(getResources().getDrawable(R.drawable.button_1));
                }
        );
    }
}
