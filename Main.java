import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Crear productos
        Producto p1 = new Producto("Arroz", 5.0, 1000);
        Producto p2 = new Producto("Leche", 3.0, 1200);
        Producto p3 = new Producto("Huevos", 2.5, 800);

        // Crear clientes con sus productos
        Cliente cliente1 = new Cliente("Cliente 1", Arrays.asList(p1, p2, p3));
        Cliente cliente2 = new Cliente("Cliente 2", Arrays.asList(p1, p3));
        Cliente cliente3 = new Cliente("Cliente 3", Arrays.asList(p2, p3));

        // Crear cajeras
        Cajera cajera1 = new Cajera("Cajera 1", cliente1);
        Cajera cajera2 = new Cajera("Cajera 2", cliente2);
        Cajera cajera3 = new Cajera("Cajera 3", cliente3);

        // Iniciar procesos concurrentes
        cajera1.start();
        cajera2.start();
        cajera3.start();

        // Esperar a que terminen todas las cajeras
        try {
            cajera1.join();
            cajera2.join();
            cajera3.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Proceso de cobro completado.");
    }
}

