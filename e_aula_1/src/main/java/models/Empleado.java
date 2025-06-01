package models;

import enums.TipoEmpleado;

public class Empleado {
    private String nombre;
    private double tarifa;
    private TipoEmpleado tipoEmpleado;

    public Empleado(String nombre, double tarifa, TipoEmpleado tipoEmpleado) {
        this.nombre = nombre;
        this.tarifa = tarifa;
        this.tipoEmpleado = tipoEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getTarifa() {
        return tarifa;
    }

    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }

    public TipoEmpleado getTipoEmpleado() {
        return tipoEmpleado;
    }

    public void setTipoEmpleado(TipoEmpleado tipoEmpleado) {
        this.tipoEmpleado = tipoEmpleado;
    }
}
