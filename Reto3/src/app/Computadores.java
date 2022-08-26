
package app;

public class Computadores {
    
private final char CONSUMO_W = 'F';
private final double PRECIO_BASE = 100.0;
private final int PESO_BASE = 5;

protected Double precioBase = PRECIO_BASE;
protected Integer peso = PESO_BASE;
protected char consumoW = CONSUMO_W;

private int tipo = 0;


    public Computadores() {
    }

    public Computadores(Double precioBase, Integer peso) {
        this.precioBase = precioBase;
        this.peso = peso;
    }

    public Computadores(Double precioBase, Integer peso, char consumoW) {
        this.precioBase = precioBase;
        this.peso = peso;
        this.consumoW = consumoW;
    }

    public Double calcularPrecio() {
        
        Double adicion = 0.0;
        
        switch (this.consumoW) {
            case 'A':
                adicion += 100;
                break;
            case 'B':
                adicion += 80;
                break;
            case 'C':
                adicion += 60;
                break;
            case 'D':
                adicion += 50;
                break;
            case 'E':
                adicion += 30;
                break;
            case 'F':
                adicion += 10;
                break;
            default:
                break;
        }

        if (this.peso >= 80) 
            adicion += 100;
        else if (this.peso >= 50) 
            adicion += 80;
        else if (this.peso >= 20) 
            adicion += 50;
        else if (this.peso >= 0) 
            adicion += 10;
       
        
        return this.precioBase + adicion;
    }

    public int getTipo() {
        return tipo;
    }

    protected void setTipo(int tipo) {
        this.tipo = tipo;
    }
    

 
}