package Trans;

public class Conjunto {

	private String conjunto;
	private int tamanio;
	
	public Conjunto() {
		
	}
	
	public Conjunto(int tamanio, String conjunto) {
		this.tamanio = tamanio;
		this.conjunto = conjunto;
	}
	
	
	public String getConjunto() {
		return conjunto;
	}
	public void setConjunto(String conjunto) {
		this.conjunto = conjunto;
	}
	public int getTamanio() {
		return tamanio;
	}
	public void setTamanio(int tamanio) {
		this.tamanio = tamanio;
	}
	
	
}
