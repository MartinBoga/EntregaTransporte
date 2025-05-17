package apps;

public class Paquete {
    private double alto;
    private double ancho;
    private double profundo;
    private double peso;
    private String destino;

    public Paquete(double alto, double ancho, double profundo, double peso, String destino) {
        this.alto = alto;
        this.ancho = ancho;
        this.profundo = profundo;
        this.peso = peso;
        this.destino = destino;
    }

    public double calcularVolumen() {
        return this.alto * this.ancho * this.profundo;
	}
    
    public double getAlto() {
        return alto;
    }

    public void setAlto(double alto) {
        this.alto = alto;
    }

    public double getAncho() {
        return ancho;
    }

    public void setAncho(double ancho) {
        this.ancho = ancho;
    }

    public double getProfundo() {
        return profundo;
    }

    public void setProfundo(double profundo) {
        this.profundo = profundo;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }
}
