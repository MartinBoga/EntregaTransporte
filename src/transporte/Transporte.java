package transporte;

import apps.Paquete;

public abstract class Transporte {
	protected String destino; // preguntar profe si es redundante? pq se maneja dentro de cada clase de transporte
	
    public abstract boolean puedeTransportar(Paquete paquete);
}