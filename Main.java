import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Lista de clientes y cajeras
        List<Cliente> clientes = new ArrayList<>();
        List<Cajera> cajeras = new ArrayList<>();

        System.out.println("Bienvenido al simulador de cobro en el supermercado.");
        
        // Solicitar el número de clientes
        System.out.print("Ingrese el número de clientes: ");
        int numeroClientes = scanner.nextInt();
        scanner.nextLine(); // Consumir salto de línea

        // Ingresar datos de cada cliente
        for (int i = 0; i < numeroClientes; i++) {
            System.out.print("Ingrese el nombre del cliente " + (i + 1) + ": ");
            String nombreCliente = scanner.nextLine();

            System.out.print("Ingrese el número de productos para " + nombreCliente + ": ");
            int numeroProductos = scanner.nextInt();
            scanner.nextLine(); // Consumir salto de línea

            List<Producto> productos = new ArrayList<>();
            for (int j = 0; j < numeroProductos; j++) {
                System.out.print("Ingrese el nombre del producto " + (j + 1) + ": ");
                String nombreProducto = scanner.nextLine();

                System.out.print("Ingrese el precio del producto " + nombreProducto + ": ");
                double precioProducto = scanner.nextDouble();

                System.out.print("Ingrese el tiempo de procesamiento (en ms) para " + nombreProducto + ": ");
                int tiempoProcesamiento = scanner.nextInt();
                scanner.nextLine(); // Consumir salto de línea

                productos.add(new Producto(nombreProducto, precioProducto, tiempoProcesamiento));
            }

            clientes.add(new Cliente(nombreCliente, productos));
        }

        // Crear cajeras y asignar clientes
        for (int i = 0; i < clientes.size(); i++) {
            Cajera cajera = new Cajera("Cajera " + (i + 1), clientes.get(i));
            cajeras.add(cajera);
        }

        // Iniciar el proceso de cobro
        System.out.println("\nIniciando el proceso de cobro...\n");
        for (Cajera cajera : cajeras) {
            cajera.start();
        }

        // Esperar a que todas las cajeras terminen
        for (Cajera cajera : cajeras) {
            try {
                cajera.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("\nProceso de cobro completado.");
        scanner.close();
    }
}


