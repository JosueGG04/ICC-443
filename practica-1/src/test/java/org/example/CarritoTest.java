package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarritoTest {
    Carrito carrito, carritoConItem;


    @BeforeEach
    void setUp() {
        carrito = new Carrito();
        Producto producto = new Producto("Producto 1", 100.0);
        ItemCarrito item = new ItemCarrito(producto, 2);
        carritoConItem = new Carrito();
        carritoConItem.agregarModificarItem(item);
    }

    @Test
    void agregarItem() {

    }

    @Test
    void ModificarItem() {

    }

    @Test
    void eliminarItem() {
    }

    @Test
    void calcularTotal() {
    }
}