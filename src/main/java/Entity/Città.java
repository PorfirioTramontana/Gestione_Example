package Entity;

public class Città {

	private int idCitta;
	private String nomeCitta;
	private String regione;
	private String paese;
	
	public Città(int id,String a,String b,String c) {
		setIdCitta(id);
		setNomeCitta(a);
		setRegione(b);
		setPaese(c);
	}

	

	public String getNomeCitta() {
		return nomeCitta;
	}

	public void setNomeCitta(String nomeCitta) {
		this.nomeCitta = nomeCitta;
	}

	public String getRegione() {
		return regione;
	}

	public void setRegione(String regione) {
		this.regione = regione;
	}

	public String getPaese() {
		return paese;
	}

	public void setPaese(String paese) {
		this.paese = paese;
	}

	public int getIdCitta() {
		return idCitta;
	}

	public void setIdCitta(int idCitta) {
		this.idCitta = idCitta;
	}

}
