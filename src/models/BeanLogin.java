package models;

public class BeanLogin {

	private String nickname = "";
	private String contrase�a = "";
	private int admin = 0;
	private int[] error = {0};
	
	/*Setters*/
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}
	
	public void setAdmin(int admin) {
		this.admin = admin;
	}
	
	public void setError(){
		
		//Consultar si login es correcte
		error[0] = 1;
		
	}

	/* Getters */
	public String getNickname() {
		return nickname;
	}
	
	public String getContrase�a() {
		return contrase�a;
	}
	
	public int getAdmin() {
		return admin;
	}
	
	public int[] getError() {
		return error;
	}
	
	/* Logic Functions */
	
	public boolean isComplete() {
	    return(hasValue(getNickname()));
	}
	
	private boolean hasValue(String val) {
		return((val != null) && (!val.equals("")));
	}	
}
