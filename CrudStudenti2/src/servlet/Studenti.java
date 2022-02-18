package servlet;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DaoStudenti;
import modelli.BeanStudenti;

@WebServlet(value="/stud", name = "Studenti")
public class Studenti extends HttpServlet {
	private static final long serialVersionUID = 1L;
    DaoStudenti daostudenti = new DaoStudenti();
    ResultSet rs;
    RequestDispatcher rd;
    BeanStudenti beanstudente;
    
    public Studenti() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String scelta=request.getParameter("x");
		switch (scelta) {
		case "1":
			rd=request.getRequestDispatcher("/pagine/insstudenti.jsp");
			rd.forward(request, response);
			break;
		case "2":
			request.getServletContext().getRequestDispatcher("/pagine/menustudenti.jsp").forward(request, response);
			break;
		case "3": // lista
			rs=daostudenti.listaStudenti();
			request.setAttribute("listast", rs);
			request.getServletContext().getRequestDispatcher("/pagine/listastudenti.jsp").forward(request, response);
			break;
		case "4": // Modifica
			rs=daostudenti.listaStudenti();
			request.setAttribute("listast", rs);
			rd=request.getRequestDispatcher("/pagine/idmodifica.jsp");
			rd.forward(request, response);
			break;
		}			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String matricola=(String)request.getParameter("matricola");
		String nome = (String) request.getParameter("nome");
		String cognome = (String) request.getParameter("cognome");
		String citta = (String) request.getParameter("citta");
		String dn = (String) request.getParameter("data");
		beanstudente=daostudenti.creaStudente(matricola, nome, cognome, citta, dn);
		//System.out.println(beanstudente.getCitta());
		daostudenti.salvaStudente(beanstudente);
		rd=request.getRequestDispatcher("/pagine/insstudenti.jsp");
		rd.forward(request, response);
		
	}

}
