package Entity;

public class VisitaMuseale extends Servizi{

	private String nomeMuseo;
	private String durata;
	
	public VisitaMuseale(String idServizio,float prezzo,String a,String b) {
		super(idServizio,prezzo);
		setNomeMuseo(a);
		setDurata(b);
	}
	public String getNomeMuseo() {
		return nomeMuseo;
	}
	public void setNomeMuseo(String nomeMuseo) {
		this.nomeMuseo = nomeMuseo;
	}
	public String getDurata() {
		return durata;
	}
	public void setDurata(String b) {
		this.durata = b;
	}
	
	public String toString() {
		return "     "+getIdServizio()+"          "+nomeMuseo+"      "+durata+"       "+getPrezzo()+" euro";
	}

}
