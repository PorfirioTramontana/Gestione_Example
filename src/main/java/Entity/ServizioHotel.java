package Entity;

public class ServizioHotel extends Servizi{

	private String nomeHotel;
	private String categoria;
	private String descrizioneHotel;
	
	public ServizioHotel(String idServizio,String a,float prezzo,String b,String c) {
		super(idServizio,prezzo);
		setNomeHotel(a);
		setCategoria(b);
		setDescrizioneHotel(c);
	}

	public String getNomeHotel() {
		return nomeHotel;
	}

	public void setNomeHotel(String nomeHotel) {
		this.nomeHotel = nomeHotel;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getDescrizioneHotel() {
		return descrizioneHotel;
	}

	public void setDescrizioneHotel(String descrizioneHotel) {
		this.descrizioneHotel = descrizioneHotel;
	}
	
	public String toString() {
		return "    "+getIdServizio()+"        "+nomeHotel+"      "+descrizioneHotel+"         "+categoria+"        "+getPrezzo()+" euro";
	}

}
