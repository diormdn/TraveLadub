package com.example.dioramadhan.traveladub;

import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import com.example.dioramadhan.traveladub.util.BottomNavigationViewHelper;

public class MainActivity extends AppCompatActivity {

   private BottomNavigationView btmNavigation;
   private ViewPager mPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        mPager = findViewById(R.id.viewPager);
        mPager.setAdapter(new MainPagerAdapter(getSupportFragmentManager()));
        BottomNavigationViewHelper.disableShiftMode(btmNavigation);


    }

    public void initView(){
        btmNavigation = findViewById(R.id.bottomNavigationView);
        btmNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.navigation_beranda:
                        getSupportActionBar().setTitle("Daftar Tempat Wisata");
                        mPager.setCurrentItem(0);
                        break;
                }

                return false;
            }
        });

        }



    }

