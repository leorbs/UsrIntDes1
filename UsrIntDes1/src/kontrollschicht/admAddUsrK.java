package kontrollschicht;

import entityClass.Sachbearbeiter;

public class admAddUsrK {
	

	
	private String name;
	private String passwort;
	private boolean adminMode = false;
	
	
	public void enterName(String name){

		this.name = name;	
	}
	
	
	public void enterPassword(String pw){
		
		this.passwort = pw;
	}
	
	
	public void cooseAdmin(String chooseAdmin){
		
		if(chooseAdmin.equalsIgnoreCase("y"))
			adminMode = true;
		else
			adminMode = false;
	}
	
	
	public boolean applyAddUser() throws Exception{
		
		try {
		
			
			if(SachbearbeiterS.getInstance().EKexists(name))
				throw new Exception("Der benutzer mit dem eingegebenen Benutzernamen existiert schon");
			
			if(stringChecks.checkName(name) == false)
				throw new Exception("Der eingegebene Benutzername kann nicht benutzt werden");
			
			if(stringChecks.checkPassword(passwort) == false)
				throw new Exception("Das eingegebene Passwort kann nicht benutzt werden");
			
		
		} catch (Exception e) {
			name = null;
			passwort = null;
			adminMode = false;
			//TODO: tidy more up?
			throw e; //but do not handle the exeption
		}
		
		
		new Sachbearbeiter(name,adminMode,passwort); //creates the new sachbearbeiter
		
		
		
		return true; //everything worked
			
	}
	

}
