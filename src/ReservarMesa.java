import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Clase que representa una mesa en una cafetería.
 */
class Mesa {
    private int numero;
    private int capacidad;
    private boolean ocupada;
    private String nombreReserva;
    private String horaReserva;

    /**
     * Constructor para la clase Mesa.
     *
     * @param numero el número de la mesa.
     * @param capacidad la capacidad de la mesa.
     */

    public Mesa(int numero, int capacidad) {
        this.numero = numero;
        this.capacidad = capacidad;
        this.ocupada = false;
        this.nombreReserva = null;
        this.horaReserva = null;
    }
    /**
     * Obtiene el número de la mesa.
     *
     * @return el número de la mesa.
     */

    public int getNumero() {
        return numero;
    }
    /**
     * Obtiene la capacidad de la mesa.
     *
     * @return la capacidad de la mesa.
     */

    public int getCapacidad() {
        return capacidad;
    }
    /**
     * Verifica si la mesa está ocupada.
     *
     * @return true si la mesa está ocupada, false en caso contrario.
     */

    public boolean estaOcupada() {
        return ocupada;
    }

    /**
     * Ocupa la mesa con una reserva.
     *
     * @param nombre el nombre de la persona que reserva la mesa.
     * @param hora la hora de la reserva en formato HH:MM.
     */
    public void ocupar(String nombre, String hora) {
        ocupada = true;
        nombreReserva = nombre;
        horaReserva = hora;
    }
    /**
     * Libera la mesa de una reserva.
     */

    public void desocupar() {
        ocupada = false;
        nombreReserva = null;
        horaReserva = null;
    }
    /**
     * Obtiene el nombre de la persona que ha reservado la mesa.
     *
     * @return el nombre de la persona que ha reservado la mesa.
     */

    public String getNombreReserva() {
        return nombreReserva;
    }
    /**
     * Obtiene la hora de la reserva.
     *
     * @return la hora de la reserva en formato HH:MM.
     */

    public String getHoraReserva() {
        return horaReserva;
    }
}
/**
 * Clase que representa una cafetería con varias mesas.
 */
class Cafeteria {
    private ArrayList<Mesa> mesas;
    /**
     * Constructor para la clase Cafeteria.
     * Inicializa la lista de mesas con mesas predefinidas.
     */

    public Cafeteria() {
        mesas = new ArrayList<>();
        mesas.add(new Mesa(1, 6));
        mesas.add(new Mesa(2, 3));
        mesas.add(new Mesa(3, 4));
        mesas.add(new Mesa(4, 5));
        mesas.add(new Mesa(5, 2));
        mesas.add(new Mesa(6, 8));
    }
    /**
     * Muestra las mesas disponibles en la cafetería.
     */

    public void mostrarMesasDisponibles() {
        System.out.println("Mesas disponibles:");
        for (Mesa mesa : mesas) {
            if (!mesa.estaOcupada()) {
                System.out.println("Mesa " + mesa.getNumero() + " - Capacidad: " + mesa.getCapacidad() + " personas");
            }
        }
    }
    /**
     * Reserva una mesa en la cafetería.
     *
     * @param numMesa el número de la mesa a reservar.
     * @param numPersonas el número de personas para la reserva.
     * @param nombre el nombre de la persona que realiza la reserva.
     * @param hora la hora de la reserva en formato HH:MM.
     * @return la mesa reservada si la reserva es exitosa, null en caso contrario.
     */

    public Mesa reservarMesa(int numMesa, int numPersonas, String nombre, String hora) {
        if (numMesa < 1 || numMesa > mesas.size()) {
            System.out.println("Mesa inválida. Por favor, elija otra mesa.");
            return null;
        }
        Mesa mesa = mesas.get(numMesa - 1);
        if (!mesa.estaOcupada() && mesa.getCapacidad() >= numPersonas) {
            if (validateTime(hora)) {
                mesa.ocupar(nombre, hora);
                return mesa;
            } else {
                System.out.println("Hora inválida. Por favor, ingrese una hora en formato HH:MM.");
                return null;
            }
        } else {
            System.out.println("Capacidad insuficiente o mesa ocupada. Por favor, elija otra mesa.");
            return null;
        }
    }
    /**
     * Libera una mesa reservada en la cafetería.
     *
     * @param numMesa el número de la mesa a liberar.
     */

    public void liberarMesa(int numMesa) {
        if (numMesa < 1 || numMesa > mesas.size()) {
            System.out.println("Mesa inválida. Por favor, elija otra mesa.");
            return;
        }
        Mesa mesa = mesas.get(numMesa - 1);
        mesa.desocupar();
        System.out.println("¡La mesa " + mesa.getNumero() + " ha sido liberada!");
    }
    /**
     * Valida el formato de la hora.
     *
     * @param time la hora a validar en formato HH:MM.
     * @return true si la hora es válida, false en caso contrario.
     */

    private boolean validateTime(String time) {
        String timeRegex = "([01]?[0-9]|2[0-3]):[0-5][0-9]";
        Pattern pattern = Pattern.compile(timeRegex);
        Matcher matcher = pattern.matcher(time);
        return matcher.matches();
    }
}
/**
 * Clase principal para manejar las reservas de mesas en una cafetería.
 */

public class ReservarMesa {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cafeteria cafeteria = new Cafeteria();

        int opcion;
        do {
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Mostrar mesas disponibles");
            System.out.println("2. Reservar mesa");
            System.out.println("3. Liberar mesa");
            System.out.println("4. Salir");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer del scanner

            switch (opcion) {
                case 1:
                    cafeteria.mostrarMesasDisponibles();
                    break;
                case 2:
                    System.out.print("Ingrese su nombre: ");
                    String nombreCliente = scanner.nextLine();
                    System.out.print("Ingrese la hora de la reserva (HH:MM): ");
                    String horaReserva = scanner.nextLine();
                    System.out.print("Ingrese el número de mesa para la reserva: ");
                    int numMesa = scanner.nextInt();
                    System.out.print("Ingrese la cantidad de personas para la reserva: ");
                    int numPersonas = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el buffer del scanner
                    Mesa mesaReservada = cafeteria.reservarMesa(numMesa, numPersonas, nombreCliente, horaReserva);
                    if (mesaReservada != null) {
                        System.out.println("¡Mesa reservada con éxito para " + nombreCliente + " a las " + horaReserva + "!");
                    }
                    break;
                case 3:
                    System.out.print("Ingrese el número de mesa a liberar: ");
                    int numMesaLiberar = scanner.nextInt();
                    cafeteria.liberarMesa(numMesaLiberar);
                    break;
                case 4:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Inténtelo de nuevo.");
            }
        } while (opcion != 4);
        scanner.close();
    }
}
