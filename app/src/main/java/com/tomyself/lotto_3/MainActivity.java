package com.tomyself.lotto_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private AdView mAdView;
    Integer num=1;
    Integer result=0;
    private BackPressCloseHandler backPressCloseHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.getSupportActionBar().hide();

        backPressCloseHandler  = new BackPressCloseHandler(this);

        Random random = new Random();

        Button buttonUp;
        Button buttonDown;
        Button buttonPick;
        Button buttonReset;
        Button buttonHelp;
        Button buttonLotto;
        TextView textSet;
        TextView textinfo;
        TextView textResult;

        buttonUp = findViewById(R.id.btn_up);
        buttonDown = findViewById(R.id.btn_down);

        buttonPick = findViewById(R.id.btn_pick);
        buttonReset = findViewById(R.id.btn_reset);

        buttonHelp = findViewById(R.id.btn_help);
        buttonLotto = findViewById(R.id.btn_lotto);

        textSet = findViewById(R.id.text_set);
        textResult = findViewById(R.id.text_result);
        textinfo = findViewById(R.id.info_text);


        buttonUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(num==999) num=1;
                else num++;
                textSet.setText(num.toString());
                textinfo.setText("1부터 "+num.toString()+"까지 중에 뽑힙니다.");
            }
        });

        buttonDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(num==1) num=999;
                else num--;
                textSet.setText(num.toString());
                textinfo.setText("1부터 "+num.toString()+"까지 중에 뽑힙니다.");
            }
        });

        buttonPick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result=random.nextInt(num)+1;
                textResult.setText(result.toString());
            }
        });

        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num=1;
                textSet.setText(num.toString());
                textResult.setText("");
                textinfo.setText("1부터 "+num.toString()+"까지 중에 뽑힙니다.");
            }
        });

        buttonLotto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LottoActivity.class);
                startActivity(intent);
            }
        });

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }

    @Override
    public void onBackPressed() {
        backPressCloseHandler.onBackPressed();
    }
}