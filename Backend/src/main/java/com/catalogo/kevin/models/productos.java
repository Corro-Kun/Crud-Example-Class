package com.catalogo.kevin.models;

public class productos {
    private int idproducto;
    private String nombre;
    private int cantidad;

    public productos(){

    }

    public productos(int idproducto, String nombre, int cantidad){
        this.idproducto = idproducto;
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public int getIdproducto(){
        return idproducto;
    }

    public void setIdproducto(int idproducto){
        this.idproducto = idproducto;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public int getCantidad(){
        return cantidad;
    }

    public void setCantidad(int cantidad){
        this.cantidad = cantidad;
    }
}
