public class Cajera extends Thread {
    private String nombre;
    private Cliente cliente;

    public Cajera(String nombre, Cliente cliente) {
        this.nombre = nombre;
        this.cliente = cliente;
    }

    @Override
    public void run() {
        System.out.println("Cajera " + nombre + " comienza a atender al cliente " + cliente.getNombre());
        long inicio = System.currentTimeMillis();

        for (Producto producto : cliente.getProductos()) {
            System.out.println("Procesando producto: " + producto.getNombre() + " | Precio: " + producto.getPrecio());
            try {
                Thread.sleep(producto.getTiempoProcesamiento()); // Simula el tiempo de procesamiento
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        long fin = System.currentTimeMillis();
        System.out.println("Cajera " + nombre + " ha terminado con el cliente " + cliente.getNombre() + 
            " en " + (fin - inicio) + " ms.");
    }
}

