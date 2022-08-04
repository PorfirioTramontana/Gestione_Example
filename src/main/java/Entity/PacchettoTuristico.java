package Entity;

public class PacchettoTuristico extends Città{

	private String codice;
	private String descrizione;
	private int numMaxPartecipanti; 
	
	
	public PacchettoTuristico(String a,String b,int c,int x,String y,String z,String w) {
		super(x,y,z,w);
		setCodice(a);
		setDescrizione(b);
		setNumMaxPartecipanti(c);
	}


	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public int getNumMaxPartecipanti() {
		return numMaxPartecipanti;
	}

	public void setNumMaxPartecipanti(int numMaxPartecipanti) {
		this.numMaxPartecipanti = numMaxPartecipanti;
	}

	public String toString() {
		
		return codice+"              "+descrizione+"          "+numMaxPartecipanti+"               "+getNomeCitta()+"     "+getRegione()+"       "+getPaese();
	}


}
