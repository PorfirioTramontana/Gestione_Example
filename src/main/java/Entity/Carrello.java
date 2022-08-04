package Entity;

import java.sql.SQLException;
import java.util.ArrayList;

import DAO.CarrelloDAO;
import DAO.PacchettoTuristicoDAO;
import DAO.SHotelDAO;
import DAO.SRistorazioneDAO;
import DAO.SVisiteMusealiDAO;

public class Carrello {

	private String data;
	private ArrayList<PacchettoTuristico> vetP; //ArrayList per gli oggetti di tipo PacchettoTuristico
	private ArrayList<ServizioHotel> vetS; //ArrayList per gli oggetti di tipo ServizioHotel
	private ArrayList<ServizioRistorazione> vetS1; //ArrayList per gli oggetti di tipo ServizioRistorazione
	private ArrayList<VisitaMuseale> vetS2; //ArrayList per gli oggetti di tipo VisitaMuseale
	private PacchettoTuristicoDAO pacchetto;
	private SHotelDAO shotel;
	private SRistorazioneDAO sris;
	private SVisiteMusealiDAO smuse;
	float prezzo=0;
	private CarrelloDAO daoCarrello;

	public Carrello() {
		vetP=new ArrayList<PacchettoTuristico> ();
		vetS=new ArrayList<ServizioHotel>();
		vetS1=new ArrayList<ServizioRistorazione>();
		vetS2=new ArrayList<VisitaMuseale>();
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
	public int addPacchetto(String codice) throws SQLException {
		pacchetto=new PacchettoTuristicoDAO();
	    vetP.add(pacchetto.cercaPacchetto(codice));
		 int idCit=0;
		 for(PacchettoTuristico e : vetP) {
			 idCit =e.getIdCitta() ;
			}
		 return idCit;
		 
	}
	
	
	
	public boolean addServizi(String idserv,int q) throws SQLException {
		
		
		if(q==0) {
			shotel=new SHotelDAO();//chiama il costruttore per inizializzazione
		   if(idserv==null) { 
				 vetS=null;
			 }
		   else {
			   
		         vetS.add(shotel.cercaServizio(idserv));
		        for(ServizioHotel p : vetS) { 
			        prezzo=prezzo+p.getPrezzo();
			           }
		         }
		}
		else if(q==1){
			sris=new SRistorazioneDAO();
		 if(idserv==null) { 
			 vetS1=null;
		 }
		 else {
			 vetS1.add(sris.cercaServizio(idserv));
		  
		  for(ServizioRistorazione t : vetS1) {
			prezzo=prezzo+t.getPrezzo();
			 
			}
		 }
		}
		
		else if(q==2){
			smuse=new SVisiteMusealiDAO();
			if(idserv==null) {
				vetS2=null;
			}
			else {
				float pz = 0;
			vetS2.add(smuse.cercaServizio(idserv));
			
			for(int i=0;i<vetS2.size();i++){
				pz=vetS2.get(i).getPrezzo();
				}
			prezzo=prezzo+pz;
			}
			}
		 return true;
		 
	}
	
	
	
	public void calcolaTotale() {
		float intermediazione=(prezzo*10)/100;
		System.out.println("Fine ordine.");
		System.out.println("Prezzo totale "+(prezzo+intermediazione)+" euro");
		System.out.println();
		
	}
	
	
	
	public boolean pagamento(ClienteRegistrato c) throws SQLException {
        calcolaTotale();
        c=new ClienteRegistrato();
        if( c.Pagamento() ) {
        	daoCarrello=new CarrelloDAO();
        	daoCarrello.salvaCarrello(this);
        	return true;
        }else {
        	return false;
        }
    }
    
	
	
public ArrayList<PacchettoTuristico> getVetP(){
	return vetP;
}
public ArrayList<ServizioHotel> getVetS(){
	return vetS;
}
public ArrayList<ServizioRistorazione> getVetS1(){
	return vetS1;
}
public ArrayList<VisitaMuseale> getVetS2(){
	return vetS2;
}


}
