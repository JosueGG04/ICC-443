package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemCarritoTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void crearItemCarritoInvalido() {
        Producto producto = new Producto("Producto 1", 100.0);
        ItemCarrito item = new ItemCarrito(producto, 2);
        assertNotNull(item);
        assertEquals(producto, item.getProducto());
        assertEquals(2, item.getCantidad());
    }

    @Test
    void setProducto() {
    }

    @Test
    void setCantidad() {
    }
}