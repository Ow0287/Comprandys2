package com.example.senasoft.comprandys2.controlador;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.senasoft.comprandys2.modelo.Producto;

import java.util.List;

/**
 * Created by Senasoft on 22/07/2017.
 */

public class AdapterProducto extends BaseAdapter {
    List<Producto> list;
    Context context;

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

        return null;
    }
}
