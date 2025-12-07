import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class VentanaIngreso extends JFrame implements ActionListener
{
private Container contenedor; // Un contenedor de elementos gráficos
private JLabel habitacion; /* Etiqueta para identificar la habitacion
seleccionada */
private JButton aceptar, cancelar; /* Botones para aceptar o cancelar
el ingreso del huesped */
private JLabel nombre, apellidos, documentoIdentidad; /* Etiquetas
para los campos de texto */
private JLabel huesped; // Etiqueta para identificar el huesped
// Campos de texto para ingresar datos del huesped
private JTextField campoNombre, campoApellidos,
campoDocumentoIdentidad;
private JLabel fechaIngreso; // Etiqueta de la fecha de ingreso
private JTextField campoFechaIngreso; /* Campo de texto de la
fecha de ingreso */
private int numeroHabitacionReservada; /* Numero de la habitacion
reservada */
private Hotel hotel; // Objeto Hotel
private Date fechaInicial; /* Fecha de inicio del alojamiento del
huesped */
private Habitacion habitacionReservada; // Habitacion reservada
/**
* Constructor de la clase VentanaIngreso
* @param hotel Parámetro que define el hotel con habitaciones y
* huespedes
* @param numeroHabitacionReservada Parámetro que define el
* numero de la habitacion reservada
*/
public VentanaIngreso(Hotel hotel, int numeroHabitacionReservada)
{
this.hotel = hotel;
this.numeroHabitacionReservada = numeroHabitacionReservada;
inicio();
setTitle("Ingreso"); // Establece el titulo de la ventana
setSize(290,250);
setLocationRelativeTo(null); /* La ventana se posiciona en el
centro de la pantalla */
setResizable(false); /* Establece que el tamaño de la ventana no
puede cambiar */
}
/**
* Metodo que crea la ventana con sus diferentes componentes
* gráficos
*/
private void inicio() {
contenedor = getContentPane(); /* Obtiene el panel de
contenidos de la ventana */
// Establece que el contenedor tendrá un GridBagLayout
contenedor.setLayout(new GridBagLayout());
GridBagConstraints c = new GridBagConstraints(); /* Define las
restricciones del layout */
c.fill = GridBagConstraints.HORIZONTAL; /* El layout es
horizontal */
c.insets = new Insets(3,3,3,3); /* Define los bordes del
contenedor */
// Establece la etiqueta del numero de la habitacion reservada
habitacion = new JLabel();
habitacion.setText("Habitacion: " +
numeroHabitacionReservada);
/* Localizacion de la etiqueta del numero de la habitacion en el
layout (0,0) */
c.gridx = 0;
c.gridy = 0;
contenedor.add(habitacion, c); /* Se agrega la etiqueta al
contenedor de la ventana */
// Establece la etiqueta y campo de texto de la fecha de ingreso
fechaIngreso = new JLabel();
fechaIngreso.setText("Fecha (aaaa-mm-dd):");
// Localizacion de la etiqueta fecha de ingreso en el layout (0,1)
c.gridx = 0;
c.gridy = 1;
/* Se agrega la etiqueta de fecha de ingreso al contenedor de la
ventana */
contenedor.add(fechaIngreso, c);
campoFechaIngreso = new JTextField();
c.gridx = 1;
c.gridy = 1;
/* Se agrega el campo de texto fecha de ingreso al contenedor de
la ventana */
contenedor.add(campoFechaIngreso, c);
// Establece la etiqueta del huesped
huesped = new JLabel();
huesped.setText("Huesped");
// Localizacion de la etiqueta huesped en el layout (0,2)
c.gridx = 0;
c.gridy = 2;
contenedor.add(huesped, c); /* Se agrega la etiqueta huesped al
contenedor de la ventana */
// Establece la etiqueta y el campo de texto nombre del huesped
nombre = new JLabel();
nombre.setText("Nombre: ");
// Localizacion de la etiqueta nombre en el layout (0,3)
c.gridx = 0;
c.gridy = 3;
contenedor.add(nombre, c); /* Se agrega la etiqueta nombre al
contenedor de la ventana */
campoNombre = new JTextField();
// Localizacion del campo de texto nombre en el layout
c.gridx = 1;
c.gridy = 3;
// Se agrega el campo de texto nombre al contenedor de la ventana
contenedor.add(campoNombre, c);
// Establece la etiqueta y el campo de texto apellidos del huesped
apellidos = new JLabel();
apellidos.setText("Apellidos: ");
// Localizacion de la etiqueta apellidos en el layout (0,4)
contenedor.add(apellidos, c); /* Se agrega la etiqueta apellidos al
contenedor de la ventana */
campoApellidos = new JTextField();
// Localizacion del campo de texto apellidos en el layout (1,4)
c.gridx = 0;
c.gridy = 4;
c.gridx = 1;
c.gridy = 4;
// Se agrega el campo de texto apellidos al contenedor de la ventana
contenedor.add(campoApellidos, c);
/* Establece la etiqueta y el campo de texto documento de
identidad del huesped */
documentoIdentidad = new JLabel();
documentoIdentidad.setText("Doc. Identidad: ");
/* Localizacion de la etiqueta documento de identidad en el
layout (0,5) */
c.gridx = 0;
c.gridy = 5;
/* Se agrega la etiqueta documento de identidad al contenedor
de la ventana */
contenedor.add(documentoIdentidad, c);
campoDocumentoIdentidad = new JTextField();
/* Localizacion del campo de texto documento de identidad en
el layout (1,5) */
c.gridx = 1;
c.gridy = 5;
/* Se agrega el campo de texto documento de identidad al
contenedor de la ventana */
contenedor.add(campoDocumentoIdentidad, c);
// Establece el boton aceptar y cancelar de la ventana
aceptar = new JButton("Aceptar");
// Localizacion del boton aceptar en el layout (0,6)
c.gridx = 0;
c.gridy = 6;
contenedor.add(aceptar, c); /* Se agrega el boton aceptar al
contenedor de la ventana */
/* Agrega al boton un ActionListener para que gestione eventos
del boton */
aceptar.addActionListener(this);
cancelar = new JButton("Cancelar");
// Localizacion del boton cancelar en el layout (1,6)
c.gridx = 1;
c.gridy = 6;
contenedor.add(cancelar, c);
cancelar.addActionListener(this);
}
/**
* Metodo que gestiona los eventos generados en la ventana de
* ingreso de huespedes
* @throws ParseException Excepcion generada cuando la fecha no
* está en el formato solicitado
* @throws Exception Excepcion generada cuando hay un campo nulo
* o error en formato de numero
*/
@Override
public void actionPerformed(ActionEvent evento) {
if (evento.getSource() == aceptar) { // Se pulsa el boton Aceptar
int posicion = -1;
for (int i = 0; i < hotel.listaHabitaciones.size(); i++) { /* Se
recorre el vector de habitaciones */
// Se obtiene un elemento del vector
Habitacion habitacion = (Habitacion) hotel.
listaHabitaciones.elementAt(i);
if (habitacion.getNumeroHabitacion() == this.
numeroHabitacionReservada) {
// Si la habitacion está reservada
try {
posicion = i;
// Obtiene la fecha de ingreso tecleada
String fechaIngresada = campoFechaIngreso.
getText();
// Establece formato de fecha
SimpleDateFormat formatoFecha = new
SimpleDateFormat("yyyy-MM-dd");
// Convierte la fecha de ingreso al formato
Date fecha = formatoFecha.parse(fechaIngresada);
//Crea un objeto huesped
Huesped huesped = new Huesped(nombre.
getText(), apellidos.getText(),
Integer.parseInt(campoDocumentoIdentidad.
getText()));
huesped.setFechaIngreso(fecha); /* Establece fecha
de ingreso del huesped */
habitacion.setHuesped(huesped); /* Establece el
huesped para la habitacion */
habitacion.setDisponible(false); /* Coloca la
habitacion como no disponible */
habitacionReservada = habitacion;
/* Coloca la habitacion como ocupada en la lista
de habitaciones */
hotel.listaHabitaciones.set(posicion, habitacion);
JOptionPane.showMessageDialog(this,"El huesped ha sido registrado","Mensaje", JOptionPane.INFORMATION_MESSAGE,null);
setVisible(false); /* La ventana de ingreso no está
visible */
break;
} catch (ParseException e) { /* Si la fecha no está en el
formato indicado */
JOptionPane.showMessageDialog(this,"La fecha no está en el formato solicitado", "Mensaje", JOptionPane.ERROR_MESSAGE);
} catch (Exception e) { /* Si ocurre un error por datos
ingresados nulos o no numericos */
JOptionPane.showMessageDialog(this,"Campo nulo o error en formato de numero", "Error", JOptionPane.ERROR_MESSAGE);
}
}
}
}
if (evento.getSource() == cancelar) { /* Si se pulsa el boton
cancelar */
setVisible(false); // La ventana de ingreso no está visible
}
}
}