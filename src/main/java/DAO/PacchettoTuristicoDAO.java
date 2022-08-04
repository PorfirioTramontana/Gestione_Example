package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Entity.PacchettoTuristico;

public  class PacchettoTuristicoDAO {

	


	public PacchettoTuristicoDAO() throws SQLException {
		super();
		// TODO Auto-generated constructor stub
	}


    
    boolean yes=false;
	public PacchettoTuristico cercaPacchetto(String _codice) throws SQLException {
		String query="SELECT * FROM PACCHETTOTURISTICO,CITTA where PACCHETTOTURISTICO.codice='"+_codice+"' AND (PACCHETTOTURISTICO.IDCITTA=CITTA.IDCITTA)";
		Connection connection = DBManagerProva.getConnection();
		PacchettoTuristico t = null;
		try {
			PreparedStatement stmt = connection.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				String codice = rs.getString("CODICE"); // qui cambia in string 
				String descrizione = rs.getString("DESCRIZIONE");
				int numMaxPartecipanti = rs.getInt("NUMMAXPARTECIPANTI");
				int idCitta=rs.getInt("IDCITTA");
				String nomeCitta=rs.getString("NOMECITTA");
				String regione=rs.getString("REGIONE");
				String paese=rs.getString("PAESE");
				
				yes=true;
				 t = new PacchettoTuristico(codice, descrizione, numMaxPartecipanti,idCitta,nomeCitta,regione,paese);
		
			}
		}

		catch (SQLException e) {
			e.printStackTrace();
		}

		DBManagerProva.closeConnection();
		
		if(yes)return t;
		else return null;
	}
	
	public ArrayList<PacchettoTuristico> getListaPacchetti(String query,ArrayList<PacchettoTuristico> list) throws SQLException {
		
		 list = new ArrayList<PacchettoTuristico>();

		Connection connection = DBManagerProva.getConnection();

		try {
			PreparedStatement stmt = connection.prepareStatement(query);
             
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				String codice = rs.getString("CODICE"); // qui cambia in string 
				String descrizione = rs.getString("DESCRIZIONE");
				int numMaxPartecipanti = rs.getInt("NUMMAXPARTECIPANTI");
				int idCitta=rs.getInt("IDCITTA");
				String nomeCitta=rs.getString("NOMECITTA");
				String regione=rs.getString("REGIONE");
				String paese=rs.getString("PAESE");

				
				PacchettoTuristico t = new PacchettoTuristico(codice, descrizione, numMaxPartecipanti,idCitta,nomeCitta,regione,paese);
				
				list.add(t);

			}
		}

		catch (SQLException e) {
			e.printStackTrace();
		}

		DBManagerProva.closeConnection();
		return list;
		
		
	}

	
}
