package Entity;

public class Servizi {

	private String idServizio;
	private float prezzo;
	
	public Servizi(String idServizio2,float b) {
		setIdServizio(idServizio2);
		setPrezzo(b);
	}

	public String getIdServizio() {
		return idServizio;
	}

	public void setIdServizio(String idServizio2) {
		this.idServizio = idServizio2;
	}

	public float getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}
	
	public String toString() {
		return idServizio+" "+prezzo;
	}

}
