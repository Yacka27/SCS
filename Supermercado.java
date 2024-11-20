import java.util.List;

public class Supermercado {
    private List<Cliente> clientes;

    public Supermercado(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public void procesarCobro() {
        // Para cada cliente, crear un hilo de cajera y ejecutarlo
        for (Cliente cliente : clientes) {
            Cajera cajera = new Cajera(null, cliente);
            cajera.start();
        }
    }
}
