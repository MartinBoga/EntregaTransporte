package apps;

import apps.Paquete;
import transporte.Bicicleta;
import transporte.Automovil;
import transporte.Camion;
import transporte.Transporte;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("MENÚ PRINCIPAL");
            System.out.println("1. Ingresar paquete y seleccionar transporte");
            System.out.println("2. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    // Ingreso de datos del paquete
                    System.out.print("Ingrese el alto (m): ");
                    double alto = scanner.nextDouble();

                    System.out.print("Ingrese el ancho (m): ");
                    double ancho = scanner.nextDouble();

                    System.out.print("Ingrese la profundidad (m): ");
                    double profundo = scanner.nextDouble();

                    System.out.print("Ingrese el peso (kg): ");
                    double peso = scanner.nextDouble();
                    scanner.nextLine(); // limpiar buffer

                    System.out.print("Ingrese el destino: ");
                    String destino = scanner.nextLine();

                    Paquete paquete = new Paquete(alto, ancho, profundo, peso, destino);

                    // Selección del transporte
                    System.out.println("\nSeleccione el medio de transporte:");
                    System.out.println("1. Bicicleta");
                    System.out.println("2. Automóvil");
                    System.out.println("3. Camión");
                    System.out.print("Opción: ");
                    int tipo = scanner.nextInt();
                    scanner.nextLine();

                    Transporte transporteSeleccionado = null;

                    switch (tipo) {
                        case 1:
                            transporteSeleccionado = new Bicicleta();
                            break;
                        case 2:
                            transporteSeleccionado = new Automovil();
                            break;
                        case 3:
                            transporteSeleccionado = new Camion();
                            break;
                        default:
                            System.out.println("Transporte no válido.");
                            continue;
                    }

                    // Validación de transporte
                    if (transporteSeleccionado.puedeTransportar(paquete)) {
                        System.out.println("SI se puede transportar el paquete por este medio.");
                    } else {
                        System.out.println("NO se puede transportar.");
                    }

                    break;

                case 2:
                    continuar = false;
                    System.out.println("Saliendo del sistema.");
                    break;

                default:
                    System.out.println("Opcion no valida.");
            }
        }

        scanner.close();
    }
}
