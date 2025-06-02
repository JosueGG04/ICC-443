package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductoTest {
    Producto productoNormal;

    @BeforeEach
    void setUp() {
        productoNormal = new Producto("Producto 1", 100.0);
    }

    @DisplayName("Crear producto con elementos invalidos")
    @Test
    void crearProductoInvalido() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Producto( "Producto Invalido", -50.0);
        });

        String expectedMessage = "El precio del producto no puede ser negativo o zero.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));

        Exception exception2 = assertThrows(IllegalArgumentException.class, () -> {
            new Producto(null, 100.0);
        });
        String expectedMessage2 = "El nombre del producto no puede ser nulo o vacío.";
        String actualMessage2 = exception2.getMessage();
        assertTrue(actualMessage2.contains(expectedMessage2));
    }


    @Test
    void setNombre() {
        Throwable excepcion = assertThrows(IllegalArgumentException.class, () -> {productoNormal.setNombre(null);});
        assertEquals("El nombre del producto no puede ser nulo o vacío.", excepcion.getMessage());
    }

    @Test
    void setPrecio() {
        Throwable excepcion = assertThrows(IllegalArgumentException.class, () -> {productoNormal.setPrecio(0.0);});
        assertEquals("El precio del producto no puede ser negativo o zero.", excepcion.getMessage());
    }
}