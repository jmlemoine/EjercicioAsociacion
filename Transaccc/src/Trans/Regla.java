package Trans;

public class Regla{
	
	private String regla;
	private float confianzaMinima;
	
	public Regla () {
		
	}
	
	public Regla (float confianzaMinima, String regla) {
		this.regla = regla;
		this.confianzaMinima = confianzaMinima;
	}
	
	
	public String getRegla() {
		return regla;
	}
	public void setRegla(String regla) {
		this.regla = regla;
	}
		
	
	public float getConfianzaMinima() {
		return confianzaMinima;
	}
	public void setConfianzaMinima(float confianzaMinima) {
		this.confianzaMinima = confianzaMinima;
	}
}


