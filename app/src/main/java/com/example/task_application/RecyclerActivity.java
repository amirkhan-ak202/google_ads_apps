package com.example.task_application;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

public class RecyclerActivity extends AppCompatActivity {
RecyclerView recyclerView;
MyAdapter myAdapter;
InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        intAds();


        String[] list = {"Pakistan","Afghanistan","China","New Zealand","Saudi Arabia","USA","UAE",
        "England","Sri Lanka","Romania"};
        recyclerView = findViewById(R.id.recyclerviews);
        myAdapter = new MyAdapter(list,new Buttonclick(){
                    @Override
                    public void btnClick() {
                        if (mInterstitialAd != null) {
                            mInterstitialAd.show(RecyclerActivity.this);
                            mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                                @Override
                                public void onAdDismissedFullScreenContent() {
                                    super.onAdDismissedFullScreenContent();
                                    mInterstitialAd=null;
                                    Toast.makeText(RecyclerActivity.this, "Ads Closed", Toast.LENGTH_SHORT).show();

                                }
                            });
                        } else {
                            Toast.makeText(RecyclerActivity.this, "Ads not loaded yet", Toast.LENGTH_SHORT).show();

                        }


                    }
                });
        recyclerView.setAdapter(myAdapter);


    }
    void intAds(){
        AdRequest adRequest = new AdRequest.Builder().build();

        InterstitialAd.load(this,"ca-app-pub-3940256099942544/1033173712", adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        // The mInterstitialAd reference will be null until
                        // an ad is loaded.
                        mInterstitialAd = interstitialAd;

                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        // Handle the error

                        mInterstitialAd = null;
                    }
                });
    }
}