
package edu.gac.jmila.gustierides;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class landToAir extends AppCompatActivity {
    private Button mLandtoairWebsite;
    private Button mLandtoairCall;

   @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.land_to_air);

        mLandtoairWebsite = (Button)findViewById(R.id.landtoair_website);
        mLandtoairWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uriUrl = Uri.parse("https://www.landtoairexpress.com/");
                Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
                startActivity(launchBrowser);
            }
        });
        mLandtoairCall = (Button)findViewById(R.id.landtoair_call);
        mLandtoairCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri number = Uri.parse("tel:8887369190");
                Intent makeCall = new Intent(Intent.ACTION_DIAL, number);
                startActivity(makeCall);
            }
        });
    }

}
