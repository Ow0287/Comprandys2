package com.example.senasoft.comprandys2.modelo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Senasoft on 22/07/2017.
 */

public class BaseProducto extends SQLiteOpenHelper {
    String createTable = "CREATE TABLE productos (nombreP TEXT, cantidadD TEXT, precio TEXT ,foto TEXT)";
    public BaseProducto(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(createTable);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS productos");
        sqLiteDatabase.execSQL(createTable);

    }
}
