package app;

public class PrecioTotal {

    private Double totalComputadores = 0.0;
    private Double totalComputadoresPortatiles = 0.0;
    private Double totalComputadoresMesa = 0.0;
    private Computadores[] listaComputadores;

    PrecioTotal(Computadores[] pComputadores) {
        this.listaComputadores = pComputadores;
    }

    public void mostrarTotales() {

        for (int i = 0; i < this.listaComputadores.length; i++) {

            totalComputadores += this.listaComputadores[i].calcularPrecio();

            if (this.listaComputadores[i].getTipo() == 1) {
                totalComputadoresMesa += this.listaComputadores[i].calcularPrecio();
            }

            if (this.listaComputadores[i].getTipo() == 2) {
                totalComputadoresPortatiles += this.listaComputadores[i].calcularPrecio();
            }

        }

        System.out.println("La suma del precio de los computadores es de " + totalComputadores);
        System.out.println("La suma del precio de los computadores de mesa es de " + totalComputadoresMesa);
        System.out.print("La suma del precio de los computadores portátiles es de " + totalComputadoresPortatiles);
    }
}
