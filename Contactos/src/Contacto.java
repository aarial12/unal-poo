import java.time.LocalDate;

public class Contacto {
    String nombres; // Atributo que define los nombres de un contacto
String apellidos; // Atributo que define los apellidos de un contacto
LocalDate fechaNacimiento; /* Atributo que define la fecha de
nacimiento de un contacto */
String dirección; // Atributo que define la dirección de un contacto
String teléfono; // Atributo que define el teléfono de un contacto
String correo;

Contacto(String nombres, String apellidos, LocalDate
fechaNacimiento, String dirección, String teléfono, String correo)
{
this.nombres = nombres;
this.apellidos = apellidos;
this.fechaNacimiento = fechaNacimiento;
this.dirección = dirección;
this.teléfono = teléfono;
this.correo = correo;
}
}
