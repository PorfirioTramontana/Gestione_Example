package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import Entity.ClienteRegistrato;

public class ClienteDAO  {
	

	//effettua il login del cliente utilizzando username e password
	boolean controllo=false;
	public boolean login(String username, String password) throws SQLException {
		
		Connection connection=DBManagerProva.getConnection();
		
	
		try {
			PreparedStatement  stmt = connection.prepareStatement("SELECT * FROM clienti WHERE username ='"+username+ "' AND password ='"+password+"'");
			
			ResultSet rs = stmt.executeQuery();
//se vengono inseriti i dati sbagliati, la query non ha valori per entrare nel ciclo
			while (rs.next()) {
				String id = rs.getString("USERNAME"); // qui cambia in string poichè ti ho messo tutto in
				String pass = rs.getString("PASSWORD");
				
				controllo=true;
				ClienteRegistrato t=new ClienteRegistrato(null, null, null, id, pass);
		
			}
		}

		catch (SQLException e) {
			e.printStackTrace();
		}

		DBManagerProva.closeConnection();
		
	if(controllo)return true;
	else
		return false;
	}


}
