package com.example.senasoft.comprandys2.controlador;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.senasoft.comprandys2.R;
import com.example.senasoft.comprandys2.modelo.Producto;


import java.util.List;

/**
 * Created by Senasoft on 22/07/2017.
 */

public class AdapterProducto extends BaseAdapter {
    List<Producto> list;
    Context context;
    TextView nombre,cantidad,precio;
    ImageView imageView;

    public AdapterProducto(List<Producto> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override

    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return list.size();
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View v=view;
        if (v==null) {
            LayoutInflater inlater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            inlater.inflate(R.layout.plantilla_lista_producto, viewGroup, false);

        }
        nombre=(EditText) v.findViewById(R.id.txv_nombre);
        cantidad=(EditText)v.findViewById(R.id.txv_cantidad);
        precio=(EditText)v.findViewById(R.id.txv_precio);
        imageView=(ImageView)v.findViewById(R.id.img_foto);

        byte[] fot= android.util.Base64.decode(this.list.get(i).getFoto(), android.util.Base64.DEFAULT);
        Bitmap bitmap= BitmapFactory.decodeByteArray(fot,0,fot.length);

        imageView.setImageBitmap(bitmap);
        nombre.setText(this.list.get(i).getNombreP());
        cantidad.setText(this.list.get(i).getCantidadD());
        precio.setText(this.list.get(i).getPrecio());


        return v;
    }

}
