package org.example;

import java.util.ArrayList;
import java.util.Objects;

public class Carrito {
    private final ArrayList<ItemCarrito> items;

    public Carrito() {
        this.items = new ArrayList<>();
    }

    public boolean agregarModificarItem(ItemCarrito item) {
        if(item == null) {
            throw new IllegalArgumentException("El item no puede ser nulo y debe tener un producto válido y una cantidad mayor a 0.");
        }

        if (this.items.contains(item)) {
            for (ItemCarrito existingItem : items) {
                if (existingItem.getProducto().getNombre().equals(item.getProducto().getNombre())) {
                    existingItem.setCantidad(existingItem.getCantidad() + item.getCantidad());
                    return true;
                }
            }
        } else {
            items.add(item);
            return true;
        }

        return false;
    }

    public boolean eliminarItem(ItemCarrito item) {
        if(item == null || item.getProducto() == null) {
            throw new IllegalArgumentException("El item no puede ser nulo y debe tener un producto válido.");
        }

        for (ItemCarrito existingItem : items) {
            if (existingItem.getProducto().getNombre().equals(item.getProducto().getNombre())) {
                items.remove(existingItem);
                return true;
            }
        }

        return false;
    }

    public double calcularTotal() {
        double total = 0.0;
        for (ItemCarrito item : items) {
            total += item.getProducto().getPrecio() * item.getCantidad();
        }
        return total;
    }

    public ArrayList<ItemCarrito> getItems() {
        return items;
    }
}
