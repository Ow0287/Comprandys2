package com.example.senasoft.comprandys2.modelo;



import android.graphics.Bitmap;

/**
 * Created by Senasoft on 22/07/2017.
 */

public class Producto {
    private String nombreP,cantidadD,precio;
    private String foto;

    public String getNombreP() {
        return nombreP;
    }

    public void setNombreP(String nombreP) {
        this.nombreP = nombreP;
    }

    public String getCantidadD() {
        return cantidadD;
    }

    public void setCantidadD(String cantidadD) {
        this.cantidadD = cantidadD;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Producto(String nombreP, String cantidadD, String precio, String foto) {

        this.nombreP = nombreP;
        this.cantidadD = cantidadD;
        this.precio = precio;
        this.foto = foto;
    }
}
