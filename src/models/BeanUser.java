package models;

public class BeanUser {

	private String nickname = "";
	private String mail = "";
	private String mail_again = "";
	private String nombre = "";
	private String nacimiento = "";
	private String contrase�a = "";
	private String contrase�a_again = "";	
	private String day = "";
	private String month = "";
	private String year = "";
	private String sexo = "";
	private int admin = 0;
	private int[] error = {0,0}; 
	
	
	/*Setters*/
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public void setMail(String mail){
		this.mail = mail;
	}
	
	public void setMail_again(String mail_again) {
		this.mail_again = mail_again;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setNacimiento(String nacimiento) {
		this.nacimiento = nacimiento;
	}
	
	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}
	
	public void setContrase�a_again(String contrase�a_again) {
		this.contrase�a_again = contrase�a_again;
	}
	
	public void setDay(String day) {
		this.day = day;
	}
	
	public void setMonth(String month) {
		this.month = month;
	}
	
	public void setYear(String year) {
		this.year = year;
	}
	
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public void setAdmin(int admin) {
		this.admin = admin;
	}
	
	public void setError(){
		
		//Consultar si existeix un usuari igual a la BD
		error[0] = 1;
		
	}
	
	/* Getters */
	public String getNickname() {
		return nickname;
	}
	
	public String getMail() {
		return mail;
	}
	
	public String getMail_again() {
		return mail_again;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getNacimiento() {
		return nacimiento;
	}
	
	public String getContrase�a() {
		return contrase�a;
	}
	
	public String getContrase�a_again() {
		return contrase�a_again;
	}
	
	public String getDay() {
		return day;
	}
	
	public String getMonth() {
		return month;
	}
	
	public String getYear() {
		return year;
	}	

	public String getSexo() {
		return sexo;
	}
	
	public int getAdmin() {
		return admin;
	}
	
	public int[] getError() {
		return error;
	}
	
	/* Logic Functions */	
	
	public boolean isComplete() {
		
		if(getYear().equals("0") || getMonth().equals("0") || getYear().equals("0")){
			error[1] = 1;
			return false;
		}
		
	    return(hasValue(getNickname()) &&
	           hasValue(getMail()) && hasValue(getNombre()) &&
	           hasValue(getContrase�a()) && hasValue(getDay()) &&
	           hasValue(getMonth()) && hasValue(getYear()));
	}
	
	private boolean hasValue(String val) {
		return((val != null) && (!val.equals("")));
	}
}
