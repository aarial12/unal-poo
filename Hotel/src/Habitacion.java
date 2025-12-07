
public class Habitacion {
private int numeroHabitacion; /* Atributo que indica el numero de
la habitacion */
private boolean disponible; /* Atributo que indica la disponibilidad
de la habitacion */
private double precioDia;
private Huesped huesped; /* Atributo que indica el huesped que
ocupa la habitacion */
/**
* Constructor de la clase Habitacion
* @param numeroHabitacion Parámetro que define el numero de la
* habitacion
* @param disponible Parámetro que define la disponibilidad de la
* habitacion
* @param precioDia Parámetro que define el precio por dia de la
* habitacion
*/
public Habitacion(int numeroHabitacion, boolean disponible,
double precioDia) {
this.numeroHabitacion = numeroHabitacion;
this.disponible = disponible;
this.precioDia = precioDia;
}
/**
* Metodo que obtiene el numero de habitacion
* @return El numero de habitacion
*/
public int getNumeroHabitacion() {
return numeroHabitacion;
}
/**
* Metodo que obtiene la disponibilidad de la habitacion
* @return La disponibilidad de la habitacion
*/
public boolean getDisponible() {
return disponible;
}
/**
* Metodo que obtiene el precio por dia de la habitacion
* @return El precio por dia de la habitacion
*/
public double getPrecioDia() {
return precioDia;
}

public Huesped getHuesped() {
return huesped;
}
/**
* Metodo que establece el huesped de la habitacion
* @param Parámetro que define el huesped de la habitacion
*/
public void setHuesped(Huesped huesped) {
this.huesped = huesped;
}
/**
* Metodo que establece la disponibilidad de la habitacion
* @param Parámetro que define la disponibilidad de la habitacion
*/
public void setDisponible(boolean disponible) {
this.disponible = disponible;
}

}