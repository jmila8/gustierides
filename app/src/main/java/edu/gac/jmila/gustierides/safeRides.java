
package edu.gac.jmila.gustierides;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class safeRides extends AppCompatActivity{
    private Button mSafeRidesCall;
   @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.safe_ride_activity);

       mSafeRidesCall = (Button)findViewById(R.id.landtoair_call);
       mSafeRidesCall.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Uri number = Uri.parse("tel:5079337000");
               Intent makeCall = new Intent(Intent.ACTION_DIAL, number);
               startActivity(makeCall);
           }
       });
    }

}
