package org.example;

import java.util.ArrayList;

public class Carrito {
    private int id;
    private ArrayList<ItemCarrito> items;

    public Carrito(int id) {
        if(id <= 0) {
            throw new IllegalArgumentException("El ID del carrito debe ser mayor que 0.");
        }

        this.id = id;
        this.items = new ArrayList<>();
    }

    public boolean agregarModificarItem(ItemCarrito item) {
        if(item == null) {
            throw new IllegalArgumentException("El item no puede ser nulo y debe tener un producto válido y una cantidad mayor a 0.");
        }

        if (this.items.contains(item)) {
            for (ItemCarrito existingItem : items) {
                if (existingItem.getProducto().getId() == item.getProducto().getId()) {
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
            if (existingItem.getProducto().getId() == item.getProducto().getId()) {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<ItemCarrito> getItems() {
        return items;
    }

    public void setItems(ArrayList<ItemCarrito> items) {
        this.items = items;
    }
}
