package services;

import enums.TipoEmpleado;
import models.Empleado;

public class ServicioNomina {


    /**
     * funcion que calcula la nomina de un empleado segun las horas trabajadas
     * @param empleado
     * @param horas
     * @param autorizacion
     * @return
     */
    static double calcularNomina(Empleado empleado, int horas, boolean autorizacion) {
        // lanzar excepcion en caso de empleado nulo
        if(empleado == null) {
            throw new IllegalArgumentException("El empleado no puede ser nulo");
        }
        // lanzar excepcion en caso de horas negativas
        if(horas < 0){
            throw new IllegalArgumentException("Las Horas no pueden ser negativas");
        }
        //nomina base para 40 horas o menos
        double nomina = empleado.getTarifa() * (Math.min(horas, 40));

        //horas extras para empleados full time o part time
        if(empleado.getTipoEmpleado() == TipoEmpleado.FULL_TIME){
            nomina += horas > 40 ? ((horas - 40) * empleado.getTarifa())*1.5 : 0;
        } else{
            nomina += horas > 40 ? ((horas - 40) * empleado.getTarifa()) : 0;
        }

        //bono de puntualidad
        nomina += horas > 38 ? 500 : 0;

        // comprobar autorizacion para nominas superiores a 20000
        if(nomina > 20000 && !autorizacion){
            throw new IllegalArgumentException("El salario no puede ser mayor a 20000 sin autorizacion");
        }

        return nomina;
    }
}