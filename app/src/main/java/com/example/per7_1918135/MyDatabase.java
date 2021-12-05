package com.example.per7_1918135;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class MyDatabase extends SQLiteOpenHelper {
    private static int DATABASE_VERSION = 1;
    private static String DATABASE_NAME = "db_penjualan";
    private static final String tb_penjualan = "tb_penjualan";
    private static final String tb_penjualan_id = "id";
    private static final String tb_penjualan_namaroko= "namaroko";
    private static final String tb_penjualan_jenisroko = "jenisroko";
    private static final String tb_penjualan_harga = "harga";
    private static final String CREATE_TABLE_PENJUALAN = "CREATE TABLE " +
            tb_penjualan + "("
            + tb_penjualan_id + " INTEGER PRIMARY KEY ,"
            + tb_penjualan_namaroko + " TEXT,"
            + tb_penjualan_jenisroko + " TEXT,"
            + tb_penjualan_harga + " TEXT " + ")";
    public MyDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_PENJUALAN);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int
            newVersion) {
    }

    public void CreatePenjualanRoko(PenjualanRoko mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_penjualan_id, mdNotif.get_id());
        values.put(tb_penjualan_namaroko, mdNotif.get_namaroko());
        values.put(tb_penjualan_jenisroko, mdNotif.get_jenisroko());
        values.put(tb_penjualan_harga, mdNotif.get_harga());
        db.insert(tb_penjualan, null, values);
        db.close();
    }

    public List<PenjualanRoko> ReadPenjualanRoko() {
        List<PenjualanRoko> judulModelList = new ArrayList<PenjualanRoko>();
        String selectQuery = "SELECT * FROM " + tb_penjualan;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                PenjualanRoko mdKontak = new PenjualanRoko();
                mdKontak.set_id(cursor.getString(0));
                mdKontak.set_namaroko(cursor.getString(1));
                mdKontak.set_jenisroko(cursor.getString(2));
                mdKontak.set_harga(cursor.getString(3));
                judulModelList.add(mdKontak);
            } while (cursor.moveToNext());
        }
        db.close();
        return judulModelList;
    }

    public int UpdatePenjualanRoko(PenjualanRoko mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_penjualan_namaroko, mdNotif.get_namaroko());
        values.put(tb_penjualan_jenisroko, mdNotif.get_jenisroko());
        values.put(tb_penjualan_harga, mdNotif.get_harga());
        return db.update(tb_penjualan, values, tb_penjualan_id + " = ?",
                new String[]{
                        String.valueOf(mdNotif.get_id())});
    }

    public void DeletePenjualanRoko(PenjualanRoko mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tb_penjualan, tb_penjualan_id + " = ?", new String[]{String.valueOf(mdNotif.get_id())});
        db.close();
    }
}
