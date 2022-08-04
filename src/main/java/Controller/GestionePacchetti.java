package Controller;

import java.util.ArrayList;


import DAO.PacchettoTuristicoDAO;
import DAO.SHotelDAO;
import DAO.SRistorazioneDAO;
import DAO.SVisiteMusealiDAO;
import Entity.Carrello;
import Entity.ClienteRegistrato;
import Entity.PacchettoTuristico;
import Entity.ServizioHotel;
import Entity.ServizioRistorazione;
import Entity.VisitaMuseale;

import java.sql.SQLException;

public class GestionePacchetti {

	private ArrayList<PacchettoTuristico> listaP ;
    private ArrayList<ServizioHotel> listaSH;
    private ArrayList<ServizioRistorazione> listaSR;
    private ArrayList<VisitaMuseale> listaSM;
    private static GestionePacchetti gestione;
    
    
	public GestionePacchetti() {
		listaP=new ArrayList<PacchettoTuristico> ();
		listaSH=new ArrayList<ServizioHotel>();
		listaSR=new ArrayList<ServizioRistorazione>();
		listaSM=new ArrayList<VisitaMuseale> ();
	}
	
	
	
	public static GestionePacchetti getInstance(){
		if (gestione == null)
			gestione = new GestionePacchetti();
		return gestione;
	}
	
	public void registraOperatore() {
		/**
		 * 
		 */
	}
	
	public void registraCliente() {
		/**
		 * 
		 */
	}
	
	public void creaPacchetti() {
		/**
		 * 
		 */
	}
	
	public void assegnaRuoloOperatore() {
		/**
		 * 
		 */
	}
	
	public void visualizzaSottoscrizioneTuristi() {
		/**
		 * 
		 */
	}
	
	public void visualizzaPacchetti() throws SQLException {
		System.out.println();
		System.out.println("ID_PACCHETTO    NOME_PACCHETTO   NUM_MAX_PERSONE       CITTA    REGIONE         PAESE");
		System.out.println();
		String query = "SELECT * FROM PACCHETTOTURISTICO ,CITTA WHERE (PACCHETTOTURISTICO.IDCITTA=CITTA.IDCITTA)";
        PacchettoTuristicoDAO pkg=new PacchettoTuristicoDAO();
        listaP=pkg.getListaPacchetti(query,listaP);
		for(int k=0;k<listaP.size();k++) {
			System.out.println(listaP.get(k).toString());
		}
	}
		
	public void visualizzaServizi(int idCity,int i) throws SQLException {
	
		if(i==0) {
		String query = "SELECT DISTINCT SERVIZIOHOTEL . IDSERVIZIO ,SERVIZIOHOTEL .NOMHOTEL, SERVIZIOHOTEL .CATEGORIA, SERVIZIOHOTEL .DESCRIZIONEHOTEL,SERVIZIOHOTEL . PREZZO  FROM SERVIZIOHOTEL ,"
				+ "OPERATOREREGISTRATO,PACCHETTOTURISTICO  where ( '"+idCity+"' =OPERATOREREGISTRATO.IDCITTA AND OPERATOREREGISTRATO .RUOLO ='Hotel'   AND OPERATOREREGISTRATO .IDOPERATORE =SERVIZIOHOTEL .IDOPERATORE )"
						+ " GROUP BY SERVIZIOHOTEL.IDSERVIZIO";
		 SHotelDAO s=new SHotelDAO();
		
		 System.out.println();
			System.out.println("ID_SERVIZIO    NOME_HOTEL   DESCRIZIONE        CATEGORIA      PREZZO   ");
			System.out.println();
		for(ServizioHotel sh : s.getListaServizi(query,listaSH)) {
			System.out.println(sh.toString());
		}
		}
		
		else if(i==1){
		String query1 ="SELECT SERVIZIORISTORAZIONE.IDSERVIZIO,SERVIZIORISTORAZIONE .TIPOLOGIAPASTO ,SERVIZIORISTORAZIONE .MENU ,SERVIZIORISTORAZIONE .DESCRIZIONEMENU,SERVIZIORISTORAZIONE.PREZZO"
				+ " FROM SERVIZIORISTORAZIONE,OPERATOREREGISTRATO  WHERE (OPERATOREREGISTRATO .IDCITTA ='"+idCity+"' AND "
				+ "OPERATOREREGISTRATO .IDOPERATORE =SERVIZIORISTORAZIONE .IDOPERATORE )";
		
		SRistorazioneDAO r=new SRistorazioneDAO();
		listaSR=r.getListaServizi(query1, listaSR);
		System.out.println();
		System.out.println("I seguenti servizi sono i servizi di ristorazione disponibili nella città associata al pacchetto che hai scelto.");
		System.out.println();
		int l = 0;
		for(int k=0;k<listaSR.size();k++) {
		   if(l==k) { //Eseguo questo blocco per prelevare solo una volta prezzo e il relativo id del servizio di un certo operatore
		    System.out.println();
		    System.out.println("il seguente servizio di ristorazione costa "+listaSR.get(l).getPrezzo()+" euro.Digita '"+listaSR.get(l).getIdServizio()+"' per scegliere :");
		    System.out.println();
		   l+=4;
		   } 
		   
		   System.out.println(listaSR.get(k).toString());
		}
		}
		
		else if(i==2) {
			String query1 ="SELECT VISITAMUSEALE .IDSERVIZIO ,VISITAMUSEALE .PREZZO ,VISITAMUSEALE .NOMEMUSEO ,VISITAMUSEALE .DURATA"
					+ " FROM VISITAMUSEALE ,OPERATOREREGISTRATO,PACCHETTOTURISTICO "
					+ " WHERE (OPERATOREREGISTRATO .IDCITTA ='"+idCity+"'"
					+ " AND OPERATOREREGISTRATO .IDOPERATORE =VISITAMUSEALE .IDOPERATORE )"
					+ "GROUP BY VISITAMUSEALE .IDSERVIZIO";
			
			SVisiteMusealiDAO r=new SVisiteMusealiDAO();
			listaSM=r.getListaServizi(query1, listaSM);
			System.out.println("Questi sono i servizi di visite museali nella città associata al pacchetto che hai scelto.");
			 System.out.println();
				System.out.println("ID_SERVIZIO    NOME_MUSEO     DURATA      PREZZO   ");
				System.out.println();
			
			for(int k=0;k<listaSM.size();k++) {
			  System.out.println(listaSM.get(k).toString());
			}
		}
			
	
	}
	
	public void aggiungiServizi() {
		/**
		 * 
		 */
	}
	
	
      public void acquista(Carrello carrello,ClienteRegistrato cliente ) throws SQLException {
    	  if(carrello.pagamento(cliente)) {
    		  System.out.println();
    		  System.out.println("STAMP CARRELLO:");
    		  System.out.println();  
    		        for(int i=0;i<carrello.getVetP().size();i++) {
    				     System.out.println( carrello.getVetP().get(i).getDescrizione()+"  "+  carrello.getVetP().get(i).getNumMaxPartecipanti()+"  "+  carrello.getVetP().get(i).getNomeCitta()+"  "+carrello.getVetP().get(i).getPaese());
    			            }
    		    if((carrello.getVetS()!=null)) {
    		        for(int i=0;i<carrello.getVetS().size();i++) {
				         System.out.println(carrello.getVetS().get(i).getNomeHotel()+"  "+carrello.getVetS().get(i).getCategoria()+"  "+carrello.getVetS().get(i).getDescrizioneHotel()+"  "+carrello.getVetS().get(i).getPrezzo()+" euro");
			                }
    		        }
    		    if((carrello.getVetS1()!=null)) {
    		         for(int i=0;i<carrello.getVetS1().size();i++) {
    			         System.out.println("Hai scelto il servizio di ristorazione "+carrello.getVetS1().get(i).getMenu()+" che costa "+carrello.getVetS1().get(i).getPrezzo()+" euro");
  		                	}
    		        }
    		    if((carrello.getVetS2()!=null)) {
    		         for(int i=0;i<carrello.getVetS2().size();i++) {
    			         System.out.println(carrello.getVetS2().get(i).getNomeMuseo()+"  "+carrello.getVetS2().get(i).getDurata()+"  "+carrello.getVetS2().get(i).getPrezzo()+" euro");
    		                }
    		       }
    	  }else {
      		System.out.println(" Pagamento Respinto");
      	}
      }
		
      public void cercaCitta() {
  		/**
  		 * 
  		 */
  	}
      
      public ArrayList<PacchettoTuristico> getListaP(){
    	  return listaP;
      }
      public ArrayList<ServizioHotel> getListaSH(){
    	  return listaSH;
      }
      public ArrayList<ServizioRistorazione> getListaSR(){
    	  return listaSR;
      }
      public ArrayList<VisitaMuseale> getListaSM(){
    	  return listaSM;
      }
		
	}
   

	




