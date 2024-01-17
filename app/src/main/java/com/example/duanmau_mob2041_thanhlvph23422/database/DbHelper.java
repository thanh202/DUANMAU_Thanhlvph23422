package com.example.duanmau_mob2041_thanhlvph23422.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {

    public DbHelper(Context context){
        super(context, "DANGKYMONHOC", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String dbThuThu = "CREATE TABLE THUTHU(matt text primary key, hoten text, matkhau text)";
        db.execSQL(dbThuThu);

        String dbThanhVien = "CREATE TABLE THANHVIEN(matv integer primary key autoincrement, hoten text, namsinh text)";
        db.execSQL(dbThanhVien);

        String dbLoai ="CREATE TABLE LOAISACH(maloai integer primary key autoincrement, tenloai text)";
        db.execSQL(dbLoai);

        String dbSach ="CREATE TABLE SACH(masach integer primary key, tensach text, giathue integer, maloai integer references LOAISACH(maloai))";
        db.execSQL(dbSach);

        String dbPhieuMuon = "CREATE TABLE PHIEUMUON(mapm integer primary key autoincrement, matv integer references THANHVIEN(matv), matt text references THUTHU(matt), masach integer references SACH(masach), ngay text, trasach integer, tenthue integer)";
        db.execSQL(dbPhieuMuon);

        // data
        db.execSQL("INSERT INTO LOAISACH VALUES (1,'thiếu nhi'),(2,'truyện cười'),(3,'Giáo khoa')");
        db.execSQL("INSERT INTO SACH VALUES(1,'hay doi day',2500,1),(2,'thang cuoi',1000,1),(3,'lap trinh android',2000,3)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion){
            db.execSQL("DROP TABLE IF EXISTS THUTHU");
            db.execSQL("DROP TABLE IF EXISTS THANHVIEN");
            db.execSQL("DROP TABLE IF EXISTS LOAISACH");
            db.execSQL("DROP TABLE IF EXISTS SACH");
            db.execSQL("DROP TABLE IF EXISTS PHHIEUMUON");
            onCreate(db);
        }
    }
}
