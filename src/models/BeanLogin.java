package models;

public class BeanLogin {

	private String nickname = "";
	private String contrase�a = "";
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

	public String getContrase�a() {
		return contrase�a;
	}

	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}
	
}
