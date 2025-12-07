import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.io.*;
/**
* Esta clase denominada VentanaPrincipal define una interfaz gráfica
* que permitirá gestionar el ingreso y salida de huespedes a un hotel.
* @version 1.2/2020
*/
public class VentanaPrincipal extends JFrame implements
ActionListener {
private Container contenedor; // Un contenedor de elementos gráficos
private JMenuBar barraMenu; // Una barra de menu principal
private JMenu menuOpciones; /* Un menu de la barra de menu
principal */
private JMenuItem itemMenu1; // Un item de menu
private JMenuItem itemMenu2; // Un item de menu
private Hotel hotel;
public VentanaPrincipal(Hotel hotel) {
this.hotel = hotel;
inicio();
setTitle("Hotel"); // Establece el titulo de la ventana
setSize(280,380); // Establece el tamaño de la ventana
setLocationRelativeTo(null); /* La ventana se posiciona en el
centro de la pantalla */
// Establece que el boton de cerrar permitirá salir de la aplicacion
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
contenedor.setLayout(null); /* Establece que el contenedor no
tiene un layout */
// Se crea la barra de menus, un menu y dos items de menu
barraMenu = new JMenuBar();
menuOpciones = new JMenu("Menu");
itemMenu1 = new JMenuItem("Consultar habitaciones");
itemMenu2 = new JMenuItem("Salida de huespedes");
menuOpciones.add(itemMenu1); /* Se agrega el item de menu 1
al menu */
menuOpciones.add(itemMenu2); /* Se agrega el item de menu 2
al menu */
barraMenu.add(menuOpciones); /* Se agregan las opciones de
menu al menu */
setJMenuBar(barraMenu); /* Se agrega el menu a la barra de
menus */
/* Agrega al item de menu 1 un ActionListener para que gestione
eventos del item de menu */
itemMenu1.addActionListener(this);
itemMenu2.addActionListener(this);
}
/**
* Metodo que gestiona los eventos generados en la ventana principal
*/
@Override
public void actionPerformed(ActionEvent evento) {
if (evento.getSource() == itemMenu1) { /* Se selecciona el item
de menu 1 */
// Se crea la ventana habitaciones
VentanaHabitaciones ventanaHabitaciones = new
VentanaHabitaciones(hotel);
ventanaHabitaciones.setVisible(true); /* Se visualiza la
ventana habitaciones */
}
if (evento.getSource() == itemMenu2) { /* Se selecciona el item
de menu 2 */
try {
// Se ingresa el numero de habitacion
String numeroHabitacion = JOptionPane.
showInputDialog(null,"Ingrese numero de habitacion","Salida de huespedes",JOptionPane.QUESTION_MESSAGE);
int numero = Integer.valueOf(numeroHabitacion); /* Se
convierte el texto ingresado a int */
if (numero < 1 || numero > 10) {
/* Si el numero es incorrecto, se muestra un mensaje
de error */
JOptionPane.showMessageDialog(this,"El numero de habitacion debe estar entre 1 y 10","Mensaje",JOptionPane.INFORMATION_MESSAGE,null);
} else if (hotel.buscarHabitacionOcupada(numero)) {
// Se busca que la habitacion este ocupada
// Se crea ventana de salida del huesped
VentanaSalida ventanaSalida = new
VentanaSalida(hotel, numero);
ventanaSalida.setVisible(true); /* Se visualiza la
ventana de salida del huesped */
} else {
    JOptionPane.showMessageDialog(this,"La habitacion ingresada no ha sido ocupada","Mensaje",
JOptionPane.INFORMATION_MESSAGE,null);
}
} catch (Exception e) { // Si se presenta algun tipo de error
JOptionPane.showMessageDialog(null,"Campo nulo o error en formato de numero","Error", JOptionPane.ERROR_MESSAGE);
}
}
}
}