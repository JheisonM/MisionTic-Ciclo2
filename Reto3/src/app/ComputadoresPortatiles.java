package app;

public class ComputadoresPortatiles extends Computadores {

    private final Integer PULGADAS_BASE = 20;

    private Integer pulgadas = PULGADAS_BASE;
    private boolean camaraITG = false;

    public ComputadoresPortatiles() {
        super();
    }

    public ComputadoresPortatiles(Double precioBase, Integer peso) {
        super(precioBase, peso);
    }

    public ComputadoresPortatiles(Double precioBase, Integer peso, char consumoW, Integer pulgadas, boolean camaraITG) {
        super(precioBase, peso, consumoW);
        this.pulgadas = pulgadas;
        this.camaraITG = camaraITG;
    }

    public Double calcularPrecio() {
        Double adicion = 0.0;

        if (this.pulgadas > 40) {
            adicion += super.precioBase * 0.3;
        }

        if (camaraITG) {
            adicion += 50;
        }

        super.setTipo(2);

        return super.calcularPrecio() + adicion;
    }
}
