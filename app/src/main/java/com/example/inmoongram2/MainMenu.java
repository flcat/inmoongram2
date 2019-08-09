package com.example.inmoongram2;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.MenuItem;
import android.widget.TextView;

public class MainMenu extends AppCompatActivity {
    private TextView mTextMessage;
    FragmentTransaction ft;
    Fragment fragment;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            ft = getSupportFragmentManager().beginTransaction();
            fragment = new SimpleFragment();
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    fragment = new MainFragment();
                    return true;
                case R.id.navigation_favorites:
                    mTextMessage.setText(R.string.title_favorites);
                    fragment = new FavoritesFragment();
                    return true;
                case R.id.navigation_search:
                    mTextMessage.setText(R.string.title_search);
                    fragment = new SearchFragment();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        mTextMessage = findViewById(R.id.message);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
