package com.tomyself.lotto_3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.Random;

public class LottoActivity extends AppCompatActivity {
    private AdView mAdView;
    Integer result=0;
    private BackPressCloseHandler backPressCloseHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lotto);
        this.getSupportActionBar().hide();

        backPressCloseHandler  = new BackPressCloseHandler(this);

        Random random = new Random();

        Button btn_number;
        Button btn_pick;
        Button btn_reset;

        TextView lotto_1 = findViewById(R.id.lotto_1);
        TextView lotto_2 = findViewById(R.id.lotto_2);
        TextView lotto_3 = findViewById(R.id.lotto_3);
        TextView lotto_4 = findViewById(R.id.lotto_4);
        TextView lotto_5 = findViewById(R.id.lotto_5);
        TextView lotto_6 = findViewById(R.id.lotto_6);
        TextView lotto_bonus = findViewById(R.id.lotto_bonus);
        TextView lotto_plus = findViewById(R.id.lotto_plus);

        btn_number = findViewById(R.id.btn_number);
        btn_pick = findViewById(R.id.btn_pick_lotto);
        btn_reset = findViewById(R.id.btn_reset);



        btn_pick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result=random.nextInt(45)+1;
                lotto_1.setText(result.toString());

                result=random.nextInt(45)+1;
                lotto_2.setText(result.toString());

                result=random.nextInt(45)+1;
                lotto_3.setText(result.toString());

                result=random.nextInt(45+1);
                lotto_4.setText(result.toString());

                result=random.nextInt(45)+1;
                lotto_5.setText(result.toString());

                result=random.nextInt(45)+1;
                lotto_6.setText(result.toString());

                result=random.nextInt(45)+1;
                lotto_bonus.setText(result.toString());

                lotto_plus.setText("+");
            }
        });

        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lotto_1.setText("");
                lotto_2.setText("");
                lotto_3.setText("");
                lotto_4.setText("");
                lotto_5.setText("");
                lotto_6.setText("");
                lotto_bonus.setText("");
                lotto_plus.setText("");
            }
        });

        btn_number.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
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
