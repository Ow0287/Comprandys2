package com.example.senasoft.comprandys2.vista;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.senasoft.comprandys2.R;
import com.example.senasoft.comprandys2.controlador.AdapterProducto;
import com.example.senasoft.comprandys2.controlador.ControladorProducto;
import com.example.senasoft.comprandys2.modelo.BaseProducto;
import com.example.senasoft.comprandys2.modelo.Producto;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Registro extends AppCompatActivity {
    AdapterProducto adapter;
    EditText nombre, cantidad, precio;
    List<Producto> list;
    BaseProducto base;
    SQLiteDatabase sqLiteDatabase;
    Context context;
    ControladorProducto controladorProducto;
    ArrayList<String> text;
    ImageView imageView,imgV;
    Bitmap bitmap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        nombre = (EditText) findViewById(R.id.edt_nombre_producto);
        cantidad = (EditText) findViewById(R.id.edt_cantidad);
        precio = (EditText) findViewById(R.id.edt_precio);

        imageView = (ImageView) findViewById(R.id.img_camara);
        imgV= (ImageView) findViewById(R.id.imgV);
        base=new BaseProducto(this,"productos",null,1);
        sqLiteDatabase=base.getWritableDatabase();
        list=new ArrayList<>();
        adapter=new AdapterProducto(list,this);
        controladorProducto=new ControladorProducto(this);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

            if (requestCode==1 && resultCode== Activity.RESULT_OK);{
            Bitmap foto=(Bitmap)data.getExtras().get("data");
bitmap = foto;

            imgV.setImageBitmap(foto);

        }



        super.onActivityResult(requestCode, resultCode, data);
    }




    public void irFoto(View v){
        Intent i =new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(i,1);


    }

    public void registrarProdu(View v){
        int i = 0;


        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
        byte[] b = baos.toByteArray();
        String fotoPro = Base64.encodeToString(b, Base64.DEFAULT);

        Producto producto=new Producto(nombre.getText().toString(),cantidad.getText().toString(),precio.getText().toString(),fotoPro);
        controladorProducto.insertarProducto(producto);
        sqLiteDatabase.close();



    }

}
