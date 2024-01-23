package com.example.duanmau_mob2041_thanhlvph23422.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.duanmau_mob2041_thanhlvph23422.database.DbHelper;
import com.example.duanmau_mob2041_thanhlvph23422.model.PhieuMuon;

import java.util.ArrayList;

public class PhieuMuonDAO {
    DbHelper dbHelper;
    public PhieuMuonDAO(Context context){
        dbHelper = new DbHelper(context);
    }
    public ArrayList<PhieuMuon> getDSPhieuMuon(){
        ArrayList<PhieuMuon> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();

        return list;
    }
}
