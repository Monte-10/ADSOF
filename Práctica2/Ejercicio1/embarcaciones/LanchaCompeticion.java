package embarcaciones;

public class LanchaCompeticion extends EmbarcacionMotor {

    private boolean esCatamaran;

    public LanchaCompeticion(String nombre, Boolean esCatamaran){

        super(nombre, 1, 49, 1, TipoMotor.GASOLINA);
        this.esCatamaran = esCatamaran;
    }

    @Override 
	public String toString() {
		return super.toString() + ", de competición " + (esCatamaran ? "(catamaran)" : "");
    }
	
	public double getCoste() {
		return 200 + (esCatamaran ? 50 : 0);
	}
	
}