package com.example.duanmau_mob2041_thanhlvph23422;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.duanmau_mob2041_thanhlvph23422.dao.SachDAO;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SachDAO dao = new SachDAO(this);
        dao.getDSDauSach();
    }
}