package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import Entity.ServizioRistorazione;

public class SRistorazioneDAO {

	boolean yes=false;
	public ServizioRistorazione cercaServizio(String _idserv) throws SQLException {
		String query="SELECT * FROM SERVIZIORISTORAZIONE WHERE IDSERVIZIO='"+_idserv+"'";
		Connection connection = DBManagerProva.getConnection();
		ServizioRistorazione t = null;
		try {
			PreparedStatement stmt = connection.prepareStatement(query); 
			
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				 String idServizio = rs.getString("IDSERVIZIO"); // qui cambia in string 
					String tipPasto = rs.getString("TIPOLOGIAPASTO");
					float prezzo = rs.getInt("PREZZO");
					String descrizioneMenu=rs.getString("DESCRIZIONEMENU");
					String menu=rs.getString("MENU");

					
					 t = new ServizioRistorazione(idServizio, tipPasto, menu, descrizioneMenu,prezzo);
				yes=true;
				
		
			}
		}

		catch (SQLException e) {
			e.printStackTrace();
		}

		DBManagerProva.closeConnection();
		
		if(yes)return t;
		else return null;
	}
	
	
	
	public ArrayList<ServizioRistorazione> getListaServizi(String query,ArrayList<ServizioRistorazione> listS) throws SQLException {
		
		
		 listS = new ArrayList<ServizioRistorazione>();
		 ServizioRistorazione s=null;
		Connection connection = DBManagerProva.getConnection();
		
		try {
			PreparedStatement stmt = connection.prepareStatement(query);
            
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				String idServizio = rs.getString("IDSERVIZIO"); // qui cambia in string
				String tipPasto = rs.getString("TIPOLOGIAPASTO");
				float prezzo = rs.getInt("PREZZO");
				String descrizioneMenu=rs.getString("DESCRIZIONEMENU");
				String menu=rs.getString("MENU");

				
				 s = new ServizioRistorazione(idServizio, tipPasto, menu, descrizioneMenu,prezzo);
				
				listS.add(s);
			}
			
		}

		catch (SQLException e) {
			e.printStackTrace();
		}

	DBManagerProva.closeConnection();
		return listS;
		
		
	}
}
