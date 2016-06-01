package models;

public class BeanLogin {

	private String nickname = "";
	private String contraseña = "";
	private int[] error = {0};
	
	public int[] getError() {
		return error;
	}
	
	public boolean isComplete() {
	    return(hasValue(getNickname()));
	}
	
	private boolean hasValue(String val) {
		return((val != null) && (!val.equals("")));
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	
}
