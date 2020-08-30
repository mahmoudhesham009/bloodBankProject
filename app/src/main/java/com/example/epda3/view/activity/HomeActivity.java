package com.example.epda3.view.activity;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.epda3.R;
import com.example.epda3.data.local.Helper;
import com.example.epda3.view.fragmen.homeCycle.HomeFragment;
import com.example.epda3.view.fragmen.homeCycle.MoreFragment;
import com.example.epda3.view.fragmen.homeCycle.NotoficationFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class HomeActivity extends AppCompatActivity {

    Fragment selectiedFragment =new HomeFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Helper.replaceFragment(getSupportFragmentManager(),R.id.nav_host_fragment,selectiedFragment);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.navigation_home:
                        selectiedFragment=new HomeFragment();
                        break;

                    case R.id.navigation_dashboard:
                        selectiedFragment=new NotoficationFragment();
                        break;

                    case R.id.navigation_notifications :
                        selectiedFragment=new MoreFragment();
                        break;
                }

                Helper.replaceFragment(getSupportFragmentManager(),R.id.nav_host_fragment,selectiedFragment);
                return true;
            }
        });
    }

}
