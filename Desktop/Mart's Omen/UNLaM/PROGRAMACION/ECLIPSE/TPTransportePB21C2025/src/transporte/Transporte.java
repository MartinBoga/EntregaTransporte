package transporte;

import apps.Paquete;

public abstract class Transporte {
	protected String destino;
	
    public abstract boolean puedeTransportar(Paquete paquete);
}
