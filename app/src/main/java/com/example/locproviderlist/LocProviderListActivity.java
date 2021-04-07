package com.example.locproviderlist;

import androidx.appcompat.app.AppCompatActivity;

import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class LocProviderListActivity extends AppCompatActivity {
    TextView mTextView;
    LocationManager LocMgr;
    List<String> LocProviders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = findViewById(R.id.textOutput);
        LocMgr = (LocationManager) getSystemService(LOCATION_SERVICE);

        LocProviders = LocMgr.getAllProviders();

        String s = "";
        for(int i = 0; i < LocProviders.size(); i++){
            s += "Loc. Provider: " + LocProviders.get(i) + "\n"
                    + "Status: " + LocMgr.isProviderEnabled(LocProviders.get(i)) + "\n\n";
        }
        mTextView.setText(s);
    }
}