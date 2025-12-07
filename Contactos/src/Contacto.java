import java.time.LocalDate;

public class Contacto {
    String nombres; // Atributo que define los nombres de un contacto
String apellidos; // Atributo que define los apellidos de un contacto
LocalDate fechaNacimiento; /* Atributo que define la fecha de
nacimiento de un contacto */
String direccion; // Atributo que define la direccion de un contacto
String telefono; // Atributo que define el telefono de un contacto
String correo;

Contacto(String nombres, String apellidos, LocalDate
fechaNacimiento, String direccion, String telefono, String correo)
{
this.nombres = nombres;
this.apellidos = apellidos;
this.fechaNacimiento = fechaNacimiento;
this.direccion = direccion;
this.telefono = telefono;
this.correo = correo;
}
}
