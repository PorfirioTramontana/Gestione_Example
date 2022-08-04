package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Entity.VisitaMuseale;

public class SVisiteMusealiDAO {

	boolean yes=false;
	public VisitaMuseale cercaServizio(String _idserv) throws SQLException {
		
		String query="SELECT * FROM VISITAMUSEALE WHERE IDSERVIZIO='"+_idserv+"'";
		Connection connection = DBManagerProva.getConnection();
		VisitaMuseale t = null;
		try {
			PreparedStatement stmt = connection.prepareStatement(query);
			
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				
				 String idServizio = rs.getString("IDSERVIZIO"); // qui cambia in string poichè ti ho messo tutto in
					String nomeMuseo = rs.getString("NOMEMUSEO");
					float prezzo = rs.getInt("PREZZO");
					String durata=rs.getString("DURATA");

					
					 t = new VisitaMuseale(idServizio, prezzo, nomeMuseo,durata);
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
	

	
	public ArrayList<VisitaMuseale> getListaServizi(String query,ArrayList<VisitaMuseale> listS) throws SQLException {
		
		
		 listS = new ArrayList<VisitaMuseale>();
		 VisitaMuseale s=null;
		Connection connection = DBManagerProva.getConnection();
		
		try {
			PreparedStatement stmt = connection.prepareStatement(query);
            
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				String idServizio = rs.getString("IDSERVIZIO"); // qui cambia in string poichè ti ho messo tutto in
				String nomeMuseo = rs.getString("NOMEMUSEO");
				float prezzo = rs.getInt("PREZZO");
				String durata=rs.getString("DURATA");

				
				 s = new VisitaMuseale(idServizio, prezzo, nomeMuseo,durata);
				
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
