package kontrollschicht;

import java.util.HashMap;
import entityClass.Sachbearbeiter;

public class chooseUsrK {
	
	private HashMap<String,Sachbearbeiter> anzeige = new HashMap<String,Sachbearbeiter>();
	
	private Sachbearbeiter choosenUser;
	
	
	
	public String[] getPossibleUserNames(){
		
		return Sachbearbeiter.getAllNames();
	}
	
	
	
	public void chooseUser(String selection) throws Exception{
		Sachbearbeiter s = Sachbearbeiter.get(selection);
		
		if(s == null)
			throw new Exception("Der Eingegebene Benutzer existiert nicht");
		
		choosenUser = s;
	}
	
	
	public String getChoosenUserName() {
		return choosenUser == null ? null :choosenUser.toString();//returns null if no user hase been choosen yet
	}

}
