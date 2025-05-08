package com.secondpartial;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView btn_navigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        loadFragment( new HomeFragment());

        btn_navigation = findViewById(R.id.btn_navigation);
        btn_navigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFrm = null;
                int itemId = item.getItemId();

                if ( itemId == R.id.nav_home) {
                    selectedFrm = new HomeFragment();
                } else if ( itemId == R.id.nav_setting ) {
                    selectedFrm = new SettingsFragment();
                }

                if ( selectedFrm != null ) {
                    loadFragment( selectedFrm );
                    return true;
                }
                return false;
            }
        });

    }

    private void loadFragment(Fragment frm) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main, frm).commit();
    }
}