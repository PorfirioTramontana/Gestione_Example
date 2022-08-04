package Entity;

public class ServizioRistorazione extends Servizi {

	protected String tipPasto;//verrà implementata come tipo TipologiaPasto
	private String menu;
	private String descrizioneMenu;
	
	public ServizioRistorazione(String a,String tipPasto,String menu,String descrizioneMenu,float b) {
		super(a,b);
		this.tipPasto=tipPasto;
		this.menu=menu;
		this.descrizioneMenu=descrizioneMenu;
	}

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	public String getDescrizioneMenu() {
		return descrizioneMenu;
	}

	public void setDescrizioneMenu(String descrizioneMenu) {
		this.descrizioneMenu = descrizioneMenu;
	}
	
	public String toString() {
		return "   "+tipPasto+"       "+menu+"       "+descrizioneMenu;
	}

}
