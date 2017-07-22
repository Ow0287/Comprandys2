package com.example.senasoft.comprandys2.controlador;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.senasoft.comprandys2.modelo.BaseProducto;
import com.example.senasoft.comprandys2.modelo.Producto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Senasoft on 22/07/2017.
 */

public class ControladorProducto {
    Context context;
    BaseProducto base;
    SQLiteDatabase sqLiteDatabase;


    public ControladorProducto(Context context) {
        this.context = context;
    }
    public void eliminarProducto(String nombreP){
        String eliminar="delete from productos where nombreP= '"+nombreP+"'   ";
        sqLiteDatabase.execSQL(eliminar);
        sqLiteDatabase.close();

    }
    public void insertarProducto(Producto producto){

        String nombre = producto.getNombreP();
        String cantidadD = producto.getCantidadD();
        String precioP = producto.getPrecio();
        String fotoP=producto.getFoto();
        sqLiteDatabase.execSQL("INSERT INTO productos (nombreP, cantidadD, precio,foto) VALUES('" + nombre +
                "','" + cantidadD+"','" + precioP + "','" + fotoP + "')");
        sqLiteDatabase.close();

        Toast.makeText(context, "Registro Exitoso", Toast.LENGTH_SHORT).show();

    }


    public Producto verProducto(String nombreP) {
        Cursor cursor;
        Producto pro =null;
        String verProd = "select * from productos where nombreP= '" + nombreP + "'   ";
        cursor = sqLiteDatabase.rawQuery(verProd, null);

        if (cursor.moveToFirst()) {


            do {
                 pro = new Producto(cursor.getString(0), cursor.getString(3), cursor.getString(1), cursor.getString(2));

            } while (cursor.moveToNext());


        }
        sqLiteDatabase.close();
        return pro;


    }

    public List<Producto> verTodosProducto() {
        List<Producto> lista;
        lista = new ArrayList<>();
        Cursor cursor;

        String verToProd = "select * from productos   ";
        cursor = sqLiteDatabase.rawQuery(verToProd, null);
        sqLiteDatabase.close();

        if (cursor.moveToFirst()) {


            do {
                Producto pro = new Producto(cursor.getString(0), cursor.getString(2), cursor.getString(1), cursor.getString(3));
                lista.add(pro);
            } while (cursor.moveToNext());


        }


return lista;
    }

}
