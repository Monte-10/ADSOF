package embarcaciones;

public class EmbarcacionMotor extends Embarcacion {
	public static final double COSTE_MOTOR = 20.0;
	private int numMotores;
	private TipoMotor tipoMotor;
	
	public EmbarcacionMotor (String nombre, int capacidad, double dimensiones, 
								  int numMotores, TipoMotor motor) {
		super(nombre, capacidad, dimensiones);
		this.numMotores = numMotores;
		this.tipoMotor = motor;
	}
		
	@Override 
	public String toString() {
		return "Barco a motor: "+super.toString()+ ", motores: " + this.numMotores + ", tipo: " + this.tipoMotor;
	}
	
	@Override 
	public double getCoste() {
		return super.getCoste()+EmbarcacionMotor.COSTE_MOTOR*this.numMotores*this.tipoMotor.factorMotor();
	}
}

