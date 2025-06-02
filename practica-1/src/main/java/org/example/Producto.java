package org.example;

public class Producto {
    private String nombre;
    private double precio;

    public Producto(String nombre, double precio) {
        if(nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre del producto no puede ser nulo o vacío.");
        }
        if(precio <= 0) {
            throw new IllegalArgumentException("El precio del producto no puede ser negativo o zero.");
        }
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {

        return nombre;
    }

    public void setNombre(String nombre) {
        if(nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre del producto no puede ser nulo o vacío.");
        }
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        if(precio <= 0) {
            throw new IllegalArgumentException("El precio del producto no puede ser negativo o zero.");
        }
        this.precio = precio;
    }
}
