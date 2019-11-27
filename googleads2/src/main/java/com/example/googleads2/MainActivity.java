package com.example.googleads2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class MainActivity extends AppCompatActivity {

    private InterstitialAd mInterstitial;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button showAdButton=(Button)findViewById(R.id.showbutton);

        showAdButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(mInterstitial.isLoaded()){                //IF Loaded

                    mInterstitial.show();                   // Display
                }

            }
        });

        mInterstitial=new InterstitialAd(this);     // InterstitialAd Object
        mInterstitial.setAdUnitId("ca-app-pub-3940256099942544/1033173712");

        AdRequest request=new AdRequest.Builder()             //Request Ad
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();


        mInterstitial.loadAd(request);      // LOad Ad


    }
}
