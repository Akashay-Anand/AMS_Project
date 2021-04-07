package com.example.anand1214.ams3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.provider.Settings;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class Location extends AppCompatActivity {

    TextView output;
    Button Go;
    String x,y ;
    String[] ListData = { "Select","Gate1","Gate2","Parking1","Parking2","Washroom1","Washroom2" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        getSupportActionBar().setTitle("Location");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        output = (TextView) findViewById(R.id.anstext);
        Go = (Button) findViewById(R.id.btngo);

        Spinner spinner1 = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,ListData);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);

        Spinner spinner2 = (Spinner) findViewById(R.id.spinner3);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,ListData );
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);

        Go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            x = spinner1.getSelectedItem().toString();
            y = spinner2.getSelectedItem().toString();

            result(x,y);
                Toast.makeText(Location.this,x + y, Toast.LENGTH_SHORT).show();
            }
        });

    }

    //back button
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    } //..

    public void result(String a, String b){

        if(a=="Select" && b != "Select"){
            output.setText("You doesn't selected your current location!! \n select it in first drop down list");
        }
        else if(b=="Select" && a != "Select"){
            output.setText("You doesn't selected your Destination !! \n select it in second drop down list");
        }
        else if (a=="Select" && b=="Select"){
            output.setText("Select your location and your destination first.");
        }
        else if(a==b && a!="Select" && b!="Select"){
            output.setText("You Selected same in both Drop-down");
        }

        else if (a=="Gate1"&& b=="Gate2")
            output.setText("*Path from gate 1 to gate 2");
        else if (a=="Gate1"&& b=="Parking1")
            output.setText("*Path from gate 1 to Parking 1");
        else if (a=="Gate1"&& b=="Parking2")
            output.setText("*Path from gate 1 to Parking2");
        else if (a=="Gate1"&& b=="Washroom1")
            output.setText("*Path from gate 1 to Washroom1");
        else if (a=="Gate1"&& b=="Washroom2")
            output.setText("*Path from gate 1 to Washroom2");
        else if (a=="Gate2"&& b=="Gate1")
            output.setText("*Path from gate 2 to gate 1");
        else if (a=="Gate2"&& b=="Parking1")
            output.setText("*Path from gate 2 to Parking1");
        else if (a=="Gate2"&& b=="Parking2")
            output.setText("*Path from gate 2 to Parking2");
        else if (a=="Gate2"&& b=="Washroom1")
            output.setText("*Path from gate 2 to Washroom1");
        else if (a=="Gate2"&& b=="Washroom2")
            output.setText("*Path from gate 2 to Washroom2");
        else if (a=="Parking1" && b=="Parking2")
            output.setText("*Path From Parking 1 to Parking 2 ");
        else if (a=="Parking1" && b=="Gate1")
            output.setText("*Path From Parking 1 to Gate 1");
        else if (a=="Parking1" && b=="Gate2")
            output.setText("*Path From Parking 1 to Gate 2 ");
        else if (a=="Parking1" && b=="Washroom1")
            output.setText("*Path From Parking 1 to Washroom 1");
        else if (a=="Parking1" && b=="Washroom2")
            output.setText("*Path From Parking 1 to Washroom2");
        else if (a=="Parking2" && b=="Parking1")
            output.setText("*Path From Parking 2 to Parking 1 ");
        else if (a=="Parking2" && b=="Gate1")
            output.setText("*Path From Parking 2 to Gate 1");
        else if (a=="Parking2" && b=="Gate2")
            output.setText("*Path From Parking 2 to Gate 2 ");
        else if (a=="Parking2" && b=="Washroom1")
            output.setText("*Path From Parking 2 to Washroom 1");
        else if (a=="Parking2" && b=="Washroom2")
            output.setText("*Path From Parking 2 to Washroom2");
        else if (a=="Washroom1" && b=="Washroom2")
            output.setText("*Path from Washroom 1 to Washroom2 ");
        else if (a=="Washroom1" && b=="Gate1")
            output.setText("*Path from Washroom 1 to GAte1");
        else if (a=="Washroom1" && b=="Gate2")
            output.setText("*Path from Washroom 1 to Gate2");
        else if (a=="Washroom1" && b=="Parking1")
            output.setText("*Path from Washroom 1 to Parking1");
        else if (a=="Washroom1" && b=="Parking2")
            output.setText("*Path from Washroom 1 to Parking2");
        else if (a=="Washroom2" && b=="Washroom1")
            output.setText("*Path from Washroom 2 to Washroom 1 ");
        else if (a=="Washroom2" && b=="Gate1")
            output.setText("*Path from Washroom 2 to GAte1");
        else if (a=="Washroom2" && b=="Gate2")
            output.setText("*Path from Washroom 2 to GAte2");
        else if (a=="Washroom2" && b=="Parking1")
            output.setText("*Path from Washroom 2 to Parking1");
        else if (a=="Washroom2" && b=="Parking2")
            output.setText("*Path from Washroom 2 to Parking2");



      //  "Select","Gate1","Gate2","Parking1","Parking2","Washroom1","Washroom2"
    }

}