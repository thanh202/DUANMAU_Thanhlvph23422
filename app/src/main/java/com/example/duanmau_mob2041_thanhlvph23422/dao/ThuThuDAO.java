package com.example.duanmau_mob2041_thanhlvph23422.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.duanmau_mob2041_thanhlvph23422.database.DbHelper;

public class ThuThuDAO {
    DbHelper dbHelper;
    public ThuThuDAO(Context context){
        dbHelper = new DbHelper(context);
    }

    //dang nhap
    public boolean checkDangNhap(String matt, String matkhau){
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM THUTHU WHERE matt = ? AND matkhau = ?",new String[]{matt,matkhau});
        if (cursor.getCount() != 0){
            return true;
        }else {
            return false;
        }
    }
}
