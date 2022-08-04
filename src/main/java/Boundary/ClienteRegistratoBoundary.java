package Boundary;

import java.sql.SQLException;
import java.util.Scanner;

import Controller.GestionePacchetti;
import DAO.ClienteDAO;
import Entity.Carrello;
import Entity.ClienteRegistrato;

public class ClienteRegistratoBoundary {

	private ClienteRegistrato cliente;
	private GestionePacchetti gestione;
	private ClienteDAO dao;
	private Scanner sc;
	
	public ClienteRegistratoBoundary() throws SQLException {
			 login();
			
	         visualizzaPacchetti();
	    	
	    	gestione = GestionePacchetti.getInstance();
	}

	
	
	public boolean login() throws SQLException {
    	sc = new Scanner(System.in);
    	boolean accessoNegato;
    	
    	
    	do{ 
    		System.out.print("Inserire username: ");
    	    String username = sc.nextLine();
    	    System.out.print("Inserire password: ");
    	    String password = sc.nextLine();
    	    dao = new ClienteDAO();
    	   if(dao.login(username, password)) {
    		  accessoNegato=false;
    	   }
    	   else { 
    		   System.out.println("Accesso negato!.username e/o password errato.riprova");
    		   accessoNegato=true;
    	   }
    	}while(accessoNegato) ;
    	return true;
    }
	
	
	
	
	public void visualizzaPacchetti() throws SQLException {
		System.out.println();
		System.out.println("VISUALIZZAZIONE PACCHETTI:");
		gestione=new GestionePacchetti();
		//visualizza la lista pacchetti
		gestione.visualizzaPacchetti();
		
		System.out.println("SCEGLI IL TUO PACCHETTO:");
		sc = new Scanner(System.in);
		String codice;
		boolean errore=false;
     do {
		System.out.println("inserire codice del pacchetto per procedere (carattere x per uscire)");
		 codice=sc.nextLine();
		for(int j=0;j<gestione.getListaP().size();j++) {
			if(gestione.getListaP().get(j).getCodice().equals(codice) || codice.equals("x"))  {
				errore=true;
				}
			}
		if(!errore)System.out.println("codice errato!riprova=");
     }while(errore!=true);
		Carrello c=new Carrello();
		
		
		int i=0;
		/*
		 * aggiungo il pacchetto scelto al carrello e prelevo la città riferita per far scegliere al cliente i
		 * servizi associati a quella città.
		*/
		if(!(codice.equals("x"))){//se salto la scelta del pacchetto,non vengono visualizzati nessun servizio
		int cityPacchettoScelto=c.addPacchetto(codice);
		
		//quando i=0 visualizzo i servizi hotel disponibili nella città del pacchetto scelto e lo aggiungo al carrello
		System.out.println();
		System.out.println("SCEGLI IL SERVIZIO HOTEL CHE DESIDERI:");
		System.out.println("Digita idServizio per scegliere oppure 'x' per saltare:");
		gestione.visualizzaServizi(cityPacchettoScelto,i);
		System.out.println();
		System.out.println("Selezionare il servizio (carattere x per saltare)");
		String idService1=sc.nextLine();
		if(!(idService1.equals("x"))) {
		    c.addServizi(idService1,i);
		}
		else c.addServizi(null,i);
		i=1;
		
		
		//quando i=1 visualizzo i servizi di ristorazione disponibili nella città del pacchetto scelto e lo aggiungo
		//al carrello
		gestione.visualizzaServizi(cityPacchettoScelto,i);
		System.out.println();
		System.out.println("SCEGLI IL SERVIZIO DI RISTORAZIONE CHE DESIDERI:");
		System.out.println("Digita idServizio per scegliere oppure 'x' per saltare:");
		String idService2=sc.nextLine(); 
		if(!(idService2.equals("x"))) {
		  c.addServizi(idService2,i);
		}
		else c.addServizi(null,i);//se il cliente ha saltato la scelta,devo passare il valor nullo come idservizio
		i=2;
		
		//quando i=1 visualizzo i servizi di ristorazione disponibili nella città del pacchetto scelto e lo aggiungo
		//al carrello
		gestione.visualizzaServizi(cityPacchettoScelto,i);
		System.out.println();
		System.out.println("SCEGLI IL SERVIZIO MUSEALE CHE DESIDERI:");
		System.out.println("Digita idServizio per scegliere oppure 'x' per saltare:");
		String idService3=sc.nextLine(); 
		if(!(idService3.equals("x"))) {
				c.addServizi(idService3,i);
				String moreIdService3 = "y";
				int contaIngressi=1;//conto il numero di volte che il cliente ha richiesto le visite guidate in più.
				                    //ed è uguale a 1 perchè è stata già richiesta una visita guidata in un museo.
				while(moreIdService3.equals("y") && gestione.getListaSM().size()!=contaIngressi){
					
					do{ 
						System.out.println("Vuoi scegliere un'altra guida turistica? se sì digita 'y' , 'n' per saltare.");
						moreIdService3=sc.nextLine();
						if(moreIdService3.equals("y") || moreIdService3.equals("n")) {
					
					     if(moreIdService3.equals("y")) {
						        System.out.println("Inserisci qui la tua scelta=");
						        idService3=sc.nextLine(); 
					             c.addServizi(idService3, i);
					             contaIngressi++;
					            				         }
					}else System.out.println("carattere non valido");
						}while(!(moreIdService3.equals("y") || moreIdService3.equals("n")));
				}
			
		}
		else c.addServizi(null,i);
		
		if(idService1.equals("x") && idService2.equals("x") && idService3.equals("x")){
			System.out.println("Per acquistare il pacchetto è neccessario scegliere almeno un servizio offerto.");
		}
		else gestione.acquista(c,cliente);
		}
		else System.out.println("Pacchetto non selezionato.");
		
		
		
	}

	

	

}
