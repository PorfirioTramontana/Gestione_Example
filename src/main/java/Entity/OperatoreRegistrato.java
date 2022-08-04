package Entity;

public class OperatoreRegistrato {
	
	private String nomeSocietà;
	private String partitaIva;
	private String username;
	private String password;
	

	public OperatoreRegistrato(String nomeSocietà,String partitaIva, String username, String password) {
		this.nomeSocietà=nomeSocietà;
		this.partitaIva=partitaIva;
		this.username=username;
		this.password=password;
	}

	public String getNomeSocietà() {
		return nomeSocietà;
	}
	
	public String getPartitaIva() {
		return partitaIva;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setNomeSocietà(String nomeSocietà) {
		this.nomeSocietà=nomeSocietà;
	}
	
	public void setPartitaIva(String partitaIva) {
		this.partitaIva=partitaIva;
	}
	
	public void setUsername(String username) {
		this.username=username;
	}
	
	public void setPassword(String password) {
		this.password=password;
	}


	
}
