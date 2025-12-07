import java.time.*;
import java.util.*;
/**
* Esta clase denominada Huesped define un huesped del hotel que
* ocupará una determinada habitacion por ciertos dias.
* @version 1.2/2020
*/
public class Huesped {
private String nombres; /* Atributo que identifica los nombres del
huesped */
private String apellidos; /* Atributo que identifica los apellidos del
huesped */
/* Atributo que identifica el numero de documento de identidad del
huesped */
private int documentoIdentidad;

private Huesped huesped; 

private Date fechaIngreso; /* Atributo que identifica la fecha de
ingreso del huesped */
private Date fechaSalida; /* Atributo que identifica la fecha de salida
del huesped */
/**
* Constructor de la clase Huesped
* @param nombres Parámetro que define los nombres del huesped
* @param apellidos Parámetro que define los apellidos del huesped
* @param documentoIdentidad Parámetro que define el numero de
* documento de identidad del huesped
*/
public Huesped(String nombres, String apellidos, int
documentoIdentidad) {
this.nombres = nombres;
this.apellidos = apellidos;
this.documentoIdentidad = documentoIdentidad;
}
/**
* Metodo que establece la fecha de salida del huesped
* @param La fecha de salida del huesped
*/
public void setFechaSalida(Date fecha) {
fechaSalida = fecha;
}
/**
* Metodo que establece la fecha de ingreso del huesped
* @param La fecha de ingreso del huesped
*/
public void setFechaIngreso(Date fecha) {
fechaIngreso = fecha;
}
/**
* Metodo que obtiene la fecha de ingreso del huesped
* @return La fecha de ingreso del huesped
*/
public Date getFechaIngreso() {
return fechaIngreso;
}

public int obtenerDiasAlojamiento() {
/* Resta la fecha de ingreso de la fecha de salida utilizando el
metodo getTime */
int dias = (int) ((fechaSalida.getTime() - fechaIngreso.
getTime())/86400000);
return dias;
}
}
