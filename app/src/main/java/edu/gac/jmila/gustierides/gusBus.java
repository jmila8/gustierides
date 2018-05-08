
package edu.gac.jmila.gustierides;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class gusBus extends AppCompatActivity{
    private Button mGusbusCall;
    private Button mGusBusWebsite;
   @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gus_bus_activity);

       mGusbusCall = (Button)findViewById(R.id.gusBus_call);
       mGusbusCall.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Uri number = Uri.parse("tel:8888804696");
               Intent makeCall = new Intent(Intent.ACTION_DIAL, number);
               startActivity(makeCall);
           }
       });

       mGusBusWebsite = (Button)findViewById(R.id.landtoair_website);
       mGusBusWebsite.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Uri uriUrl = Uri.parse("http://www.saintpetermn.gov/transit");
               Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
               startActivity(launchBrowser);
           }
       });
    }
}
