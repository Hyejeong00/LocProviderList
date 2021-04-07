package com.example.locproviderlist;

import androidx.appcompat.app.AppCompatActivity;

import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class LocProviderListActivity extends AppCompatActivity {
    TextView mTextView;
    LocationManager LocMgr;
    List<String> LocProviders;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = findViewById(R.id.textOutput);
        LocMgr = (LocationManager) getSystemService(LOCATION_SERVICE);

        LocProviders = LocMgr.getAllProviders();

        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = "";
                for(String locpros : LocProviders){
                    s += "Loc. Provider: " + locpros + "\n"
                            + "Status: " + LocMgr.isProviderEnabled(locpros) + "\n\n";
                }
                //Enhanced for loof
                mTextView.setText(s);
            }
        });
    }
}