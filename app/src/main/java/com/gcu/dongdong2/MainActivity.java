package com.gcu.dongdong2;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private FragmentManager fragmentManager;
    private HomeFragment fragment_home;
    private FindFragment fragment_find;
    private AlarmFragment fragment_alarm;
    private SettingFragment fragment_setting;
    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();

        fragment_home = new HomeFragment();
        fragment_find = new FindFragment();
        fragment_alarm = new AlarmFragment();
        fragment_setting = new SettingFragment();

        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment_home).commitNowAllowingStateLoss();

        // 이벤트 리스너 등록
        BottomNavigationView bottomNavigationView = findViewById(R.id.navBar);
        bottomNavigationView.setOnNavigationItemSelectedListener(new MenuClickEventListener());
    }
    class MenuClickEventListener implements BottomNavigationView.OnNavigationItemSelectedListener{
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            fragmentTransaction = fragmentManager.beginTransaction();

            int itemId = item.getItemId();
            if (itemId == R.id.tab_home) {
                fragmentTransaction.replace(R.id.frameLayout, fragment_home).commitNowAllowingStateLoss();
            } else if (itemId == R.id.tab_find) {
                fragmentTransaction.replace(R.id.frameLayout, fragment_find).commitNowAllowingStateLoss();
            } else if (itemId == R.id.tab_alarm) {
                fragmentTransaction.replace(R.id.frameLayout, fragment_alarm).commitNowAllowingStateLoss();
            } else if (itemId == R.id.tab_setting) {
                fragmentTransaction.replace(R.id.frameLayout, fragment_setting).commitNowAllowingStateLoss();
            }

            return true;
        }
    }
}