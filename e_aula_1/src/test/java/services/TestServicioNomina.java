package services;

import enums.TipoEmpleado;
import models.Empleado;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestServicioNomina {
    private Empleado empleadoFullTime;
    private Empleado empleadoPartTime;
    private Empleado empleadoNulo;
    private final double tarifa = 440;

    @BeforeEach
    void setUp() {
        empleadoFullTime = new Empleado("full", tarifa, TipoEmpleado.FULL_TIME);
        empleadoPartTime = new Empleado("part", tarifa, TipoEmpleado.PART_TIME);
    }


    @Test
    @DisplayName("Cálculo correcto del salario sin horas extra")
    public void testCalcularSalarioSinHorasExtra() {
        int horas = 35;
        assertEquals(tarifa*horas, ServicioNomina.calcularNomina(empleadoFullTime,horas,false));
    }

    @Test
    @DisplayName("Cálculo correcto del salario sin horas extra con bono")
    public void testCalcularSalarioSinHorasExtraConBono() {
        int horas = 38;
        assertEquals(tarifa*horas, ServicioNomina.calcularNomina(empleadoFullTime,horas,false));
    }

    @Test
    @DisplayName("Cálculo correcto del salario con horas extra (solo FULL_TIME)")
    public void testCalcularSalarioConHorasExtraFullTime() {
        int horas = 42;
        assertEquals((tarifa*40) + 1.5*(tarifa*(horas-40)) + 500, ServicioNomina.calcularNomina(empleadoFullTime,horas,false));
    }

    @Test
    @DisplayName("No aplicar horas extra a empleados PART_TIME")
    public void testNoAplicarHorasExtraPartTime() {
        int horas = 44;
        assertEquals((tarifa*horas) + 500, ServicioNomina.calcularNomina(empleadoPartTime,horas,false));
    }

    @Test
    @DisplayName("Lanzar excepción para horas negativas")
    public void testLanzarExcepcionHorasNegativas() {
        int horas = -10;
        Throwable excepcion = assertThrows(IllegalArgumentException.class, () -> {ServicioNomina.calcularNomina(empleadoFullTime,horas,false);});
        assertEquals("Las Horas no pueden ser negativas", excepcion.getMessage());
    }

    @Test
    @DisplayName("Lanzar excepción si el empleado es nulo")
    public void testLanzarExcepcionEmpleadoNulo() {
        Throwable excepcion = assertThrows(IllegalArgumentException.class, () -> {ServicioNomina.calcularNomina(empleadoNulo,10,false);});
        assertEquals("El empleado no puede ser nulo", excepcion.getMessage());
    }

    @Test
    @DisplayName("Validar que el salario no exceda el tope permitido sin autorizacion (sin autorizacion)")
    public void testValidarSalarioTopeSinAutorizacion() {
        int horas = 50;
        Throwable excepcion = assertThrows(Exception.class, () -> {ServicioNomina.calcularNomina(empleadoFullTime,horas,false);});
        assertEquals("El salario no puede ser mayor a 20000 sin autorizacion", excepcion.getMessage());
    }

    @Test
    @DisplayName("Validar que el salario no exceda el tope permitido sin autorizacion (con autorizacion)")
    public void testValidarSalarioTopeConAutorizacion() {
        int horas = 50;
        assertEquals((tarifa*40) + 1.5*(tarifa*(horas-40)) + 500, ServicioNomina.calcularNomina(empleadoFullTime,horas,true));
    }
}