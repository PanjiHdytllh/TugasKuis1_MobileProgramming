package com.example.tugassqlitedatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class MyDatabase extends SQLiteOpenHelper {
    private static int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "db_Laptop";
    private static final String tb_laptop = "tb_laptop";
    private static final String tb_laptop_id = "id";
    private static final String tb_laptop_nama = "nama";
    private static final String tb_laptop_merk = "merk";
    private static final String tb_laptop_harga = "harga";
    private static final String CREATE_TABLE_LAPTOP = "CREATE TABLE " +
            tb_laptop + "("
            + tb_laptop_id + " INTEGER PRIMARY KEY ,"
            + tb_laptop_nama + " TEXT,"
            + tb_laptop_merk + " TEXT,"
            + tb_laptop_harga + " TEXT " + ")";

    public MyDatabase (Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_LAPTOP);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void CreateLaptop (Laptop mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_laptop_id, mdNotif.get_id());
        values.put(tb_laptop_nama, mdNotif.get_nama());
        values.put(tb_laptop_merk, mdNotif.get_merk());
        values.put(tb_laptop_harga, mdNotif.get_harga());
        db.insert(tb_laptop, null, values);
        db.close();
    }

    public List<Laptop> ReadLaptop() {
        List<Laptop> judulModelList = new ArrayList<Laptop>();
        String selectQuery = "SELECT * FROM " + tb_laptop;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Laptop mdKontak = new Laptop();
                mdKontak.set_id(cursor.getString(0));
                mdKontak.set_nama(cursor.getString(1));
                mdKontak.set_merk(cursor.getString(2));
                mdKontak.set_harga(cursor.getString(3));
                judulModelList.add(mdKontak);
            } while (cursor.moveToNext());
        }
        db.close();
        return judulModelList;
    }
    public int UpdateLaptop (Laptop mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_laptop_nama, mdNotif.get_nama());
        values.put(tb_laptop_merk, mdNotif.get_merk());
        values.put(tb_laptop_harga, mdNotif.get_harga());
        return db.update(tb_laptop, values, tb_laptop_id + " = ?",
                new String[] { String.valueOf(mdNotif.get_id())});
    }
    public void DeleteLaptop (Laptop mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tb_laptop, tb_laptop_id+ " = ?",
                new String[]{String.valueOf(mdNotif.get_id())});
        db.close();
    }
}
