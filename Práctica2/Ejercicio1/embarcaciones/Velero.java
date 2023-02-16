package embarcaciones;

public class Velero extends Embarcacion {
	private int numMastil;
	private double longMastil;
	
	public Velero (String nombre, int capacidad, double dimensiones, 
								  double longMastil, int numMastil) {
		super(nombre, capacidad, dimensiones);
		this.longMastil = longMastil;
		this.numMastil = numMastil;
	}
		
	@Override 
	public String toString() {
		return "Velero: "+super.toString() + numMastil + " mastiles, de " + longMastil;
	}
	
	@Override 
	public double getCoste() {
		return super.getCoste()+ (this.numMastil*this.longMastil);
	}
}