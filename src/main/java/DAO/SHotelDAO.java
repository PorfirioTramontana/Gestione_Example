package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Entity.ServizioHotel;

public class SHotelDAO  {

	
public ArrayList<ServizioHotel> getListaServizi(String query,ArrayList<ServizioHotel> listS) throws SQLException {
		
		
		 listS = new ArrayList<ServizioHotel>();
		 ServizioHotel s=null;
		Connection connection = DBManagerProva.getConnection();
		
		try {
			PreparedStatement stmt = connection.prepareStatement(query);
             
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				String idServizio = rs.getString("IDSERVIZIO"); // qui cambia in string poichè ti ho messo tutto in
				String nomeHotel = rs.getString("NOMHOTEL");
				float prezzo = rs.getInt("PREZZO");
				String descrizioneHotel=rs.getString("DESCRIZIONEHOTEL");
				String categoria=rs.getString("CATEGORIA");

				
				 s = new ServizioHotel(idServizio, nomeHotel, prezzo, categoria,descrizioneHotel);
				
				listS.add(s);
			}
			
		}

		catch (SQLException e) {
			e.printStackTrace();
		}

	DBManagerProva.closeConnection();
		return listS;
		
		
	}

boolean yes=false;
	public ServizioHotel cercaServizio(String _idserv) throws SQLException {
		String query="SELECT * FROM SERVIZIOHOTEL WHERE IDSERVIZIO='"+_idserv+"'";
		Connection connection = DBManagerProva.getConnection();
		ServizioHotel t = null;
		try {
			PreparedStatement stmt = connection.prepareStatement(query);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				 yes=true;
				 String idServizio = rs.getString("IDSERVIZIO"); // qui cambia in string 
					String nomeHotel = rs.getString("NOMHOTEL");
					float prezzo = rs.getInt("PREZZO");
					String descrizioneHotel=rs.getString("DESCRIZIONEHOTEL");
					String categoria=rs.getString("CATEGORIA");

					
					 t = new ServizioHotel(idServizio, nomeHotel, prezzo, categoria,descrizioneHotel);
		
			}
		}

		catch (SQLException e) {
			e.printStackTrace();
		}

		DBManagerProva.closeConnection();
		
		if(yes==true)return t;
		else return null;
	}
	

	
	}

	
	

