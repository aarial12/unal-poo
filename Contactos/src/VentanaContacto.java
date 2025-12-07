import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.ListView;
import java.time.LocalDate;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class VentanaContacto extends Application {
// Etiquetas
Label nombres = new Label("Nombres:");
Label apellidos = new Label("Apellidos:");
Label fechaNacimiento = new Label("Fecha nacimiento:");
Label direccion = new Label("Direccion");
Label correo = new Label("Correo");
Label telefono = new Label("Telefono");
// Campos de texto
TextField campoNombres = new TextField();
TextField campoApellidos = new TextField();
DatePicker campoFechaNacimiento = new DatePicker();
// Componente gráfico calendario
TextField campoDireccion = new TextField();
TextField campoCorreo = new TextField();
TextField campoTelefono = new TextField();
ListView lista = new ListView();
agregar.setOnAction(e -> mostrarDatos());
// Establece un CSS para el GridPane
grid.setStyle("-fx-padding: 10;"
+ "-fx-border-style: solid inside;"
+ "-fx-border-width: 2;"
+ "-fx-border-insets: 5;"
+ "-fx-border-radius: 5;"
+ "-fx-border-color: green;");
Scene scene = new Scene(grid, 600, 300); /* Crea una escena
con el tamaño definido */
stage.setScene(scene); // Establece para el escenario una escena
stage.setTitle("Detalles del contacto"); /* Establece el titulo del
escenario */
stage.sizeToScene();
stage.show(); // Muestra el escenario (ventana)
}
/**
* Metodo que captura los datos ingresados de un contacto, crea un
* contacto, lo añade a la lista de contactos y a la lista gráfica
*/
private void mostrarDatos() {
// Captura los datos ingresados
String a = campoNombres.getText();
String b = campoApellidos.getText();
LocalDate c = campoFechaNacimiento.getValue();
String d = campoDireccion.getText();
String e = campoTelefono.getText();
String f = campoCorreo.getText();
// Evalua que los campos no esten vacios
if (a.equals("") || b.equals("") || d.equals("") ||
e.equals("") || f.equals("")) {
// Si los campos están vacios, se genera una alerta
Alert mensaje = new Alert(Alert.AlertType.INFORMATION);
mensaje.setTitle("Mensaje");
mensaje.setHeaderText("Error en ingreso de datos");
mensaje.setContentText("No se permiten campos vacios");
mensaje.showAndWait();
} else {
    Contacto contacto = new Contacto(a,b,c,d,e,f); /*Crea un
contaco */
ListaContactos listaContactos = new ListaContactos(); /* Crea
la lista de contactos */
listaContactos.agregarContacto(contacto); /* Añade el
contacto a la lista */
String data = a + "-" + b + "-" + c + "-" + d + "-" + e + "-" + f;
lista.getItems().add(data); /* Añade el contacto a la lista
gráfica */
/* Todos los campos quedan vacios para ingresar un nuevo
contacto */
campoNombres.setText("");
campoApellidos.setText("");
campoFechaNacimiento.setValue(null);
campoDireccion.setText("");
campoTelefono.setText("");
campoCorreo.setText("");
        }
    }
}