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
            String s = "";
            @Override
            public void onClick(View view) {
                for(int i = 0; i < LocProviders.size(); i++){
                    s += "Loc. Provider: " + LocProviders.get(i) + "\n"
                            + "Status: " + LocMgr.isProviderEnabled(LocProviders.get(i)) + "\n\n";
                }
                mTextView.setText(s);
            }
        });
    }
}