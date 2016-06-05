package controllers;

import java.io.IOException;
import models.BeanUser;
import utils.BeanUtilities;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.ResultSet;

/**
 * Servlet implementation class formcontroller
 */
public class formcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public formcontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	   BeanUser user = new BeanUser();
	   BeanUtilities.populateBean(user, request);
	    if (user.isComplete()) {

	    	DAO connector;
	    	ResultSet dynamic_page;
	    	
	    	try {
				connector = new DAO();
				
				dynamic_page = (ResultSet) connector.executeSQL("SELECT nickname FROM users WHERE nickname = '"+ user.getNickname() +"'");
				
				if(!dynamic_page.next()){
					connector.executeUpdate("INSERT INTO users (nickname, mail, nombre, day, month, year, sexo, contraseña) VALUES ('"+user.getNickname()+"', '"+ user.getMail() +"', '"+ user.getNombre() +"', '"+ user.getDay() +"','"+ user.getMonth() +"', '"+ user.getYear() +"' , '"+ user.getSexo() +"', '"+ user.getContraseña() +"')");
					
					RequestDispatcher dispatcher = request.getRequestDispatcher("Registration.html");
				    if (dispatcher != null) dispatcher.forward(request, response);
				} else {
					user.setUserError();
				    request.setAttribute("user",user);
				    RequestDispatcher dispatcher = request.getRequestDispatcher("/form.jsp");
				    if (dispatcher != null) dispatcher.forward(request, response);
				}
	    	}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
	    	
	    } else {
	     
	    request.setAttribute("user",user);
	    RequestDispatcher dispatcher = request.getRequestDispatcher("/form.jsp");
	    if (dispatcher != null) dispatcher.forward(request, response);
	    	
	    }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
