package com.link.logovanje;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Logovanje";
    public static final String TABLE_NAME = "Korisnik";

    public static final String COLUMN_NAME_ID = "ID";
    public static final String COLUMN_NAME_IME = "korisnicko_ime";
    public static final String COLUMN_NAME_SIFRA = "sifra";



    public DBHelper(@Nullable Context context) {
        super(context, DBHelper.DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + "(ID INTEGER PRIMARY KEY, korisnicko_ime TEXT, sifra TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public Boolean insertData(String korisnicko_ime, String sifra) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("korisnicko_ime", korisnicko_ime);
        contentValues.put("sifra", sifra);
        long result = db.insert("Korisnik", null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Boolean checkUsername(String korisnicko_ime) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from Korisnik where korisnicko_ime=?", new String[] {korisnicko_ime});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public Boolean checkuserNamePassword(String korisnicko_ime, String sifra) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from Korisnik where korisnicko_ime=? and sifra=?", new String[] {korisnicko_ime, sifra});
        if (cursor.getCount()>0)
            return true;
        else
            return false;
    }
}









