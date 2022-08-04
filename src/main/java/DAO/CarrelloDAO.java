package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import Entity.Carrello;

public class CarrelloDAO {

	String descrizioneP = null;
	int numPersone = 0;
	String citta = null;
	String paese = null;
	String nomeHotel=null;
	String categoriaHotel=null;
	String descrizioneHotel=null;
	float prezzoHotel=0;
	float prezzoRistorazione=0;
	String pasto=null;
	String museo=null;
	Date d = new Date();
	@SuppressWarnings("deprecation")
	String data=d.getDate()+"/"+d.getMonth()+"/"+d.getYear()+"  "+d.getHours()+":"+d.getMinutes();

	
	public void salvaCarrello(Carrello c) throws SQLException {
		
		
		Connection connection = DBManagerProva.getConnection();
		PreparedStatement stmt;
		
		try {
			
		for(int i=0;i<c.getVetP().size();i++) {
			 descrizioneP=c.getVetP().get(i).getDescrizione();
			 numPersone=c.getVetP().get(i).getNumMaxPartecipanti();
			 citta=c.getVetP().get(i).getNomeCitta();
			 paese=c.getVetP().get(i).getPaese();
		}
		
		
		if(!(c.getVetS()==null)) {
			
			 
			  for(int i=0;i<c.getVetS().size();i++) {
				  nomeHotel=c.getVetS().get(i).getNomeHotel();
				  categoriaHotel=c.getVetS().get(i).getCategoria();
				  descrizioneHotel=c.getVetS().get(i).getDescrizioneHotel();
				  prezzoHotel=c.getVetS().get(i).getPrezzo();
			  }
			
		
		}
		
		
		if(!(c.getVetS1()==null)) {
			
			for(int i=0;i<c.getVetS1().size();i++) {
				prezzoRistorazione=c.getVetS1().get(i).getPrezzo();
			}
			
			pasto="I dettagli verranno stampati separatamente";
		
		
		}

		if(!(c.getVetS2()==null)) {
			
				museo="I dettagli(incluso i prezzi)verranno stampati separatamente";
		
	
		}
		 String query="INSERT INTO Carrello(data,descrizionePacchetto , numMaxPartecipanti,citta,paese,nomeHotel,"
		 		+ "categoriaHotel,descrizioneHotel,PrezzoHotel,servizioRistorazione,prezzoRistorazione,visitaMuseale)"
		 		+ "VALUES('"+data+"','"+descrizioneP+"',"+numPersone+",'"+citta+"','"+paese+"','"+nomeHotel+"',"
		 				+ "'"+categoriaHotel+"','"+descrizioneHotel+"',"+prezzoHotel+",'"+pasto+"',"
		 						+ ""+prezzoRistorazione+",'"+museo+"')";
		
		 stmt = connection.prepareStatement(query);
		 stmt.executeUpdate(); 
		}

		catch (SQLException e) {
			e.printStackTrace();
		}

		DBManagerProva.closeConnection();
		
	
		
	}

}
