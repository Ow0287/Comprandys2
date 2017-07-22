package com.example.senasoft.comprandys2.vista;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.senasoft.comprandys2.R;
import com.example.senasoft.comprandys2.controlador.AdapterProducto;
import com.example.senasoft.comprandys2.modelo.Producto;

import java.util.ArrayList;

public class Registro extends AppCompatActivity {
    EditText nombre,cantidad,precio;
    AdapterProducto adListView;

    ArrayList<String> text;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
    }

}
