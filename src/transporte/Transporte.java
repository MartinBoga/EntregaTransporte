package transporte;

import apps.Paquete;

public abstract class Transporte {
    protected double VOLUMEN_MAXIMO;
    protected double PESO_MAXIMO;
    protected int MAX_CIUDADES = Integer.MAX_VALUE;
    protected int MAX_PAQUETES = Integer.MAX_VALUE;
    
    protected String destino; // preguntar si es redundante pq se maneja dentro de cada clase transporte

    public Transporte(double volumenMaximo, double pesoMaximo) {
        this.VOLUMEN_MAXIMO = volumenMaximo;
        this.PESO_MAXIMO = pesoMaximo;
    }

    public Transporte(double volumenMaximo, double pesoMaximo, int maxCiudades, int maxPaquetes) {
        this(volumenMaximo, pesoMaximo);
        this.MAX_CIUDADES = maxCiudades;
        this.MAX_PAQUETES = maxPaquetes;
    }

    public abstract boolean puedeTransportar(Paquete paquete);
}