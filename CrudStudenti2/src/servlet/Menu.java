package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DaoLogin;

@WebServlet(value="/menu",name="Menu")
public class Menu extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RequestDispatcher rd;
    DaoLogin login = new DaoLogin();
    public Menu() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String utente=request.getParameter("utente");
		String password=request.getParameter("pw");
		Boolean trovato=login.verificaLogin(utente, password);
		if(trovato==true) {
			
			rd= request.getRequestDispatcher("/pagine/menustudenti.jsp");
			rd.forward(request, response);
		}else { // fallito
			request.setAttribute("errore", "Utente o Password Errati !!!!!!");
			rd=request.getRequestDispatcher("/index.jsp");
			rd.forward(request, response);
		}
		
	}

}
