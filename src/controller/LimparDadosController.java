package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LimparDados
 */
@WebServlet("/LimparDadosController")
public class LimparDadosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LimparDadosController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request , response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String x = "";
		try{
			x = "" + (String) request.getParameter("tLimparcliente");
		}
		catch(Exception e){
			x = "" + (String) request.getParameter("tLimparveiculo");
		}
		
		if(x.equals("Limpar Cliente")){
			session.removeAttribute("locarbuscarc");
			RequestDispatcher view = request.getRequestDispatcher("locar.jsp");
			view.forward(request, response);
		}
		
		else if(x.equals("Limpar Veiculo")){
			session.removeAttribute("locarbuscarv");
			RequestDispatcher view = request.getRequestDispatcher("locar.jsp");
			view.forward(request, response);
		}
		else{}
	}

}
