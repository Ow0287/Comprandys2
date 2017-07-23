package com.example.senasoft.comprandys2.vista;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.senasoft.comprandys2.R;
import com.example.senasoft.comprandys2.controlador.AdapterProducto;
import com.example.senasoft.comprandys2.controlador.ControladorProducto;
import com.example.senasoft.comprandys2.modelo.BaseProducto;
import com.example.senasoft.comprandys2.modelo.Producto;

import java.util.ArrayList;
import java.util.List;

public class Lista extends AppCompatActivity {
    ControladorProducto controladorProducto;
    List<Producto> lista;
    ListView listV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        controladorProducto=new ControladorProducto(this);
        lista=new ArrayList<>();
        listV=(ListView)findViewById(R.id.lista);

        lista=controladorProducto.verTodosProducto();
        AdapterProducto adapterProducto=new AdapterProducto(lista,this);

        listV.setAdapter(adapterProducto);


        Log.e("tramañolista", String.valueOf(lista.size()));



    }














}



