package edu.gac.jmila.gustierides;


import android.content.Intent;
import android.os.Bundle;



import android.support.v7.app.AppCompatActivity;

import android.view.Menu;
import android.view.View;

import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button mWallPost;
    private Button mSafeRide;
    private Button mGusBus;
    private Button mLandToAir;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage_main);

        mGusBus = (Button) findViewById(R.id.gus_bus);
        mGusBus.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {

                    // Start NewActivity.class
                    Intent myIntent = new Intent(MainActivity.this,
                            gusBus.class);
                    startActivity(myIntent);
                }

        });



        mSafeRide = (Button) findViewById(R.id.safe_ride);

        mSafeRide.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {

                Intent myIntent = new Intent(MainActivity.this,
                        safeRides.class);
                startActivity(myIntent);

            }

        });



        mLandToAir = (Button) findViewById(R.id.land_to_air);

        mLandToAir.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this,
                        landToAir.class);
                startActivity(myIntent);


            }

        });

    }



}
