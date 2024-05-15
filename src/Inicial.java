//import java.util.ArrayList;
//import java.util.Scanner;
//
//class Mesa {
//    private int numero;
//    private int capacidad;
//    private boolean ocupada;
//
//    public Mesa(int numero, int capacidad) {
//        this.numero = numero;
//        this.capacidad = capacidad;
//        this.ocupada = false;
//    }
//
//    public int getNumero() {
//        return numero;
//    }
//
//    public int getCapacidad() {
//        return capacidad;
//    }
//
//    public boolean estaOcupada() {
//        return ocupada;
//    }
//
//    public void ocupar() {
//        ocupada = true;
//    }
//
//    public void desocupar() {
//        ocupada = false;
//    }
//}
//
//class Cafeteria {
//    private ArrayList<Mesa> mesas;
//
//    public Cafeteria(int numMesas) {
//        mesas = new ArrayList<>();
//        for (int i = 1; i <= numMesas; i++) {
//            mesas.add(new Mesa(i, 4)); // Supongamos que todas las mesas tienen capacidad para 4 personas
//        }
//    }
//
//    public void mostrarMesasDisponibles() {
//        System.out.println("Mesas disponibles:");
//        for (Mesa mesa : mesas) {
//            if (!mesa.estaOcupada()) {
//                System.out.println("Mesa " + mesa.getNumero() + " - Capacidad: " + mesa.getCapacidad() + " personas");
//            }
//        }
//    }
//
//    public Mesa reservarMesa(int numPersonas) {
//        for (Mesa mesa : mesas) {
//            if (!mesa.estaOcupada() && mesa.getCapacidad() >= numPersonas) {
//                mesa.ocupar();
//                return mesa;
//            }
//        }
//        return null; // No hay mesas disponibles para la cantidad de personas solicitadas
//    }
//
//    public void liberarMesa(Mesa mesa) {
//        mesa.desocupar();
//        System.out.println("¡La mesa " + mesa.getNumero() + " ha sido liberada!");
//    }
//}
//
//public class ReservarMesa {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        Cafeteria cafeteria = new Cafeteria(10); // Crear una cafetería con 10 mesas
//
//        int opcion;
//        do {
//            System.out.println("\nSeleccione una opción:");
//            System.out.println("1. Mostrar mesas disponibles");
//            System.out.println("2. Reservar mesa");
//            System.out.println("3. Liberar mesa");
//            System.out.println("4. Salir");
//            opcion = scanner.nextInt();
//            scanner.nextLine(); // Limpiar el buffer del scanner
//
//            switch (opcion) {
//                case 1:
//                    cafeteria.mostrarMesasDisponibles();
//                    break;
//                case 2:
//                    System.out.print("Ingrese la cantidad de personas para la reserva: ");
//                    int numPersonas = scanner.nextInt();
//                    scanner.nextLine(); // Limpiar el buffer del scanner
//                    Mesa mesaReservada = cafeteria.reservarMesa(numPersonas);
//                    if (mesaReservada != null) {
//                        System.out.println("¡Mesa reservada con éxito!");
//                    } else {
//                        System.out.println("Lo siento, no hay mesas disponibles para esa cantidad de personas.");
//                    }
//                    break;
//                case 3:
//                    System.out.print("Ingrese el número de mesa a liberar: ");
//                    int numMesa = scanner.nextInt();
//                    scanner.nextLine(); // Limpiar el buffer del scanner
//                    cafeteria.liberarMesa(new Mesa(numMesa, 0));
//                    break;
//                case 4:
//                    System.out.println("¡Hasta luego!");
//                    break;
//                default:
//                    System.out.println("Opción inválida. Inténtelo de nuevo.");
//            }
//        } while (opcion != 4);
//        scanner.close();
//    }
//}