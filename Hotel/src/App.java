public class App {
    public static void main(String[] args) throws Exception {
        VentanaPrincipal miVentanaPrincipal; // Define la ventana principal
Hotel hotel = new Hotel(); // Crea un objeto Hotel
miVentanaPrincipal= new VentanaPrincipal(hotel); /* Crea la
ventana principal */
miVentanaPrincipal.setVisible(true); 
    }
}
