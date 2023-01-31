package com.example.marisehat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;

import com.example.marisehat.fragments.BMIFrag;
import com.example.marisehat.fragments.HomeFrag;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

public class HomeSreen extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar mytoolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_home_sreen);

        ///---------- Navigation Drawer set up ----------////
        drawerLayout = findViewById(R.id.drawlayout);
        navigationView = findViewById(R.id.nav_view);
        mytoolbar = findViewById(R.id.myToolBar);

        setSupportActionBar(mytoolbar);

        navigationView.bringToFront(); // biar keliatan mana yg di pencet

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, mytoolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.nav_home:
                        replaceFragment(new HomeFrag());
                        break;
                    case R.id.nav_bmi:
                        replaceFragment(new BMIFrag());
                        break;
                    case R.id.nav_keluar:
                        finish();
                        System.exit(0);
                        break;
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });

        //set mana yg udah ke chekced di menu nav
        navigationView.setCheckedItem(R.id.nav_home);

        ///-------------------------////

        // Bottom Navigation
        BottomNavigationView bottomNav = findViewById(R.id.bottomNav);
        // clicked bottom nav item
        bottomNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.homeItem:
                        replaceFragment(new HomeFrag());
                        break;
                    case R.id.weightItem:
                        replaceFragment(new BMIFrag());
                        break;
                }
                return true;
            }
        });

    }


    // method dari nav drawer
    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    // REPLACE FRAGMENT METHOD
    private void replaceFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainerView, fragment)
                .commit();
    }
}