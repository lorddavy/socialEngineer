package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.ResultSet;

import models.BeanLogin;
import utils.BeanUtilities;

/**
 * Servlet implementation class logincontroller
 */
public class logincontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public logincontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		BeanLogin login = new BeanLogin();
	    BeanUtilities.populateBean(login, request);
	    if (login.isComplete()) {
	    	DAO connector;
	    	ResultSet dynamic_page;
	    	try {
				connector = new DAO();

				dynamic_page = (ResultSet) connector.executeSQL("SELECT nickname, mail, sexo FROM users WHERE nickname = '"+ login.getNickname() + "' AND contraseña='"+ login.getContraseña() + "'");
				
				if(dynamic_page.next()){
					
					
					
			    	HttpSession session = request.getSession();
			    	session.setAttribute("nickname", dynamic_page.getString("nickname"));
			    	session.setAttribute("mail", dynamic_page.getString("mail"));
			    	session.setAttribute("sexo", dynamic_page.getInt("sexo"));
				    System.out.println("Se ha hecho el login."+session.toString());
				    System.out.println("User:"+session.getAttribute("nickname"));
			    	RequestDispatcher dispatcher = request.getRequestDispatcher("loginOk.jsp");
				    if (dispatcher != null) dispatcher.forward(request, response);
				}
				else{
					login.setLoginError();
					request.setAttribute("login",login);
				    RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
				    if (dispatcher != null) dispatcher.forward(request, response);
				}
	    	}catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			}	
	    } else {
	     
	    request.setAttribute("login",login);
	    RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
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
