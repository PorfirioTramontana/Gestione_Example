package Entity;

public class ServizioTrasporto extends Servizi{

	private Città partenza;
	private Città arrivo;
	
	public ServizioTrasporto(String idServizio,float prezzo,Città a,Città b) {
		super(idServizio,prezzo);
		setPartenza(a);
		setArrivo(b);
	}

	public Città getPartenza() {
		return partenza;
	}

	public void setPartenza(Città partenza) {
		this.partenza = partenza;
	}

	public Città getArrivo() {
		return arrivo;
	}

	public void setArrivo(Città arrivo) {
		this.arrivo = arrivo;
	}

}
