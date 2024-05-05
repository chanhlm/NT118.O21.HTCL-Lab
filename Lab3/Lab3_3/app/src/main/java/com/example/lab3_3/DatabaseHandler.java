package com.example.lab3_3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "sinhvienManager";
    private static final String TABLE_SV = "sinhvien";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_LOP = "lop";
    private static final String KEY_DIEMTB = "diemtb";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create_sv_table = String.format("CREATE TABLE %s(%s INTEGER PRIMARY KEY, %s TEXT, %s TEXT, %s FLOAT);",
                TABLE_SV, KEY_ID, KEY_NAME, KEY_LOP, KEY_DIEMTB);
        db.execSQL(create_sv_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SV);
        onCreate(db);
    }

    public void addSV(SinhVien sv) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_ID, sv.getId());
        values.put(KEY_NAME, sv.getNameSV());
        values.put(KEY_LOP, sv.getLopSV());
        values.put(KEY_DIEMTB, sv.getDiemTB());
        db.insert(TABLE_SV, null, values);
        db.close();
    }

    public void updateSV(SinhVien sv) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, sv.getNameSV());
        values.put(KEY_LOP, sv.getLopSV());
        values.put(KEY_DIEMTB, sv.getDiemTB());
        db.update(TABLE_SV, values, KEY_ID + " = ?", new String[]{String.valueOf(sv.getId())});
        db.close();
    }

    public void deleteSV(SinhVien sv) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_SV, KEY_ID + " = ?", new String[]{String.valueOf(sv.getId())});
        db.close();
    }

    public SinhVien getSV(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_SV, null, KEY_ID + " = ?", new String[]{String.valueOf(id)}, null, null, null);
        SinhVien sv = null;
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                int idIndex = cursor.getColumnIndex(KEY_ID);
                int nameIndex = cursor.getColumnIndex(KEY_NAME);
                int lopIndex = cursor.getColumnIndex(KEY_LOP);
                int diemIndex = cursor.getColumnIndex(KEY_DIEMTB);

                sv = new SinhVien(cursor.getInt(idIndex),
                        cursor.getString(nameIndex),
                        cursor.getString(lopIndex),
                        cursor.getFloat(diemIndex));
            }
            cursor.close();
        }
        db.close();
        return sv;
    }

    public List<SinhVien> getAllSV() {
        List<SinhVien> listSV = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_SV, null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    int idIndex = cursor.getColumnIndex(KEY_ID);
                    int nameIndex = cursor.getColumnIndex(KEY_NAME);
                    int lopIndex = cursor.getColumnIndex(KEY_LOP);
                    int diemIndex = cursor.getColumnIndex(KEY_DIEMTB);

                    SinhVien sv = new SinhVien(cursor.getInt(idIndex),
                            cursor.getString(nameIndex),
                            cursor.getString(lopIndex),
                            cursor.getFloat(diemIndex));
                    listSV.add(sv);
                } while (cursor.moveToNext());
            }
            cursor.close();
        }
        db.close();
        return listSV;
    }

}
