package Entity;


public class ClienteRegistrato {

	private String nome;
	private String cognome;
	private String username;
	private String password;
	private String email;
	
	
	public ClienteRegistrato(String nome,String cognome,String username,String password,String email) {
		setNome(nome);
		setCognome(cognome);
		setUsername(username);
		setPassword(password);
		setEmail(email);
	}

	

	public ClienteRegistrato() {
		// TODO Auto-generated constructor stub
	}



	public boolean Pagamento() {
    	return true; 
    }
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome=nome;
	}
	
	public String getCognome() {
		return cognome;
	}
	
	public void setCognome(String cognome) {
		this.cognome=cognome;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username=username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password=password;
	}

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email=email;
	}
	
	 public String toString() {
	    	return nome + " " + cognome + " " + email + " " 
	    			+ username + " " + password + " ";
	    }
}
