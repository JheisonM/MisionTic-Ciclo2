package app;

public class ComputadoresMesa extends Computadores {

    private final Integer ALMACENAMIENTO_BASE = 50;

    private Integer almacenamiento = ALMACENAMIENTO_BASE;

    public ComputadoresMesa() {
        super();
    }

    public ComputadoresMesa(Double precioBase, Integer peso) {
        super(precioBase, peso);
    }

    public ComputadoresMesa(Double precioBase, Integer peso, char consumoW, Integer almacenamiento) {
        super(precioBase, peso, consumoW);
        this.almacenamiento = almacenamiento;
    }

    public Double calcularPrecio() {

        Double adicion = 0.0;

        if (this.almacenamiento > 100) {
            adicion += 50;
        }

        super.setTipo(1);

        return super.calcularPrecio() + adicion;
    }

}
