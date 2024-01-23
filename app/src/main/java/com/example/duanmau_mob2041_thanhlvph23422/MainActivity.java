package com.example.duanmau_mob2041_thanhlvph23422;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.duanmau_mob2041_thanhlvph23422.dao.SachDAO;
import com.example.duanmau_mob2041_thanhlvph23422.fragment.QLLoaiSachFragment;
import com.example.duanmau_mob2041_thanhlvph23422.fragment.QLPhieuMuonFragment;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {



   DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolBar);
        FrameLayout frameLayout = findViewById(R.id.frameLayout);
        NavigationView navigationView = findViewById(R.id.navigation);
        drawerLayout = findViewById(R.id.drawerlayout);



        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.baseline_menu_24);

       navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
           @Override
           public boolean onNavigationItemSelected(@NonNull MenuItem item) {
               Fragment fragment = new Fragment();
               if(item.getItemId() == R.id.mQLPhieuMuon){
                   fragment = new QLPhieuMuonFragment();
               }else if(item.getItemId() == R.id.mQLLoaiSach){
                   fragment = new QLLoaiSachFragment();
               }
               FragmentManager fragmentManager = getSupportFragmentManager();
               fragmentManager.beginTransaction()
                       .replace(R.id.frameLayout,fragment)
                       .commit();

               drawerLayout.closeDrawer(GravityCompat.START);
               toolbar.setTitle(item.getTitle());
               return false;
           }
       });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            drawerLayout.openDrawer(GravityCompat.START);
        }
        return super.onOptionsItemSelected(item);
    }
}