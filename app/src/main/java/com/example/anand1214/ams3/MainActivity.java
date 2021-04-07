package com.example.anand1214.ams3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    RelativeLayout loc, fd, tb, inbox;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        ----------------------Links------------------
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view_db);
        toolbar = findViewById(R.id.db_toolbar);
        auth = FirebaseAuth.getInstance();
//        ---------------------------Tool bar----------------------------
        setSupportActionBar(toolbar);

//        -----------------------Navigation Drawer Menu-----------
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

//        ------------------------ hiding menu item-------------
        Menu me = navigationView.getMenu();
        if(auth.getCurrentUser() == null){
            //Intent n = new Intent(MainActivity.this,Login.class);
            //startActivity(n);
            me.findItem(R.id.menu_logout).setVisible(false);
        }
        else if (auth.getCurrentUser()!= null){
            me.findItem(R.id.menu_login).setVisible(false);
        }
        me.findItem(R.id.menu_rate).setVisible(false);
        me.findItem(R.id.menu_privacy_policy).setVisible(false);

//        ------------------------ making menu item clicable-------------
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.bringToFront();
//---------------------------------------------------------
        loc = findViewById(R.id.location);
        fd = findViewById(R.id.flight1);
        tb = findViewById(R.id.ticket1);
        inbox = findViewById(R.id.inbox1);

        loc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent n = new Intent(MainActivity.this, Location.class);
                startActivity(n);
            }
        });
        fd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent n = new Intent(MainActivity.this, FlightDetails.class);
                startActivity(n);
            }
        });
        tb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent n = new Intent(MainActivity.this, TicketBooking.class);
                startActivity(n);
            }
        });
        inbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent n = new Intent(MainActivity.this, Inbox.class);
                startActivity(n);
            }
        });


    }


    //---------------------- Close drawer on back press --------------
    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    //    ---------------------------
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem Menuitem) {

        switch (Menuitem.getItemId()) {
            case R.id.menu_location:
                Intent n = new Intent(MainActivity.this, Location.class);
                startActivity(n);
                break;
            case R.id.menu_flight:
                n = new Intent(MainActivity.this, FlightDetails.class);
                startActivity(n);
                break;
            case R.id.menu_inbox:
                n = new Intent(MainActivity.this, FlightDetails.class);
                startActivity(n);
                break;
            case R.id.menu_ticket:
                n = new Intent(MainActivity.this, FlightDetails.class);
                startActivity(n);
                break;
            case R.id.menu_login:
                n = new Intent(MainActivity.this,Login.class);
                startActivity(n);
                //Toast.makeText(this, "Login", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_logout:
//                if(auth.getCurrentUser() != null){
                auth.signOut();
//                }
//                else
//                    Toast.makeText(this, "Login null", Toast.LENGTH_SHORT).show();
        }

        drawerLayout.closeDrawer(GravityCompat.START); // it will close the drower after clicking on button

        return false; // returning true will store the selected state of item
    }
//------------------------------------------------------------

}