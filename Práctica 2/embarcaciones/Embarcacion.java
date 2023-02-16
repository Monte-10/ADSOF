package embarcaciones;

public abstract class Embarcacion {
	public static final double COSTE_BASE = 5.0;
	private String nombre;
	private int    capacidad;
	private double dimensiones;

	public Embarcacion (String nombre, int capacidad, double dimensiones) {
		this.nombre = nombre;
		this.capacidad = capacidad;
		this.dimensiones = dimensiones;	
	}

	@Override public String toString() {		
		return this.nombre + ", capacidad: " + this.capacidad+ ", dimensiones " +this.dimensiones;
	}

	public double getCoste() {
		return Embarcacion.COSTE_BASE+this.dimensiones+this.capacidad;
	}
}

