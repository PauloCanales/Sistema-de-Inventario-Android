package com.example.proyectoandroid;

public class Material {
    public String id, nombre, cantidad, tipo;



    public Material() {

    }

    public Material(String id, String nombre, String cantidad, String tipo) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.tipo = tipo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
