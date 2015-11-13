package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AcessoBD;
import dao.AutomovelDAO;
import model.*;
/**
 * Servlet implementation class ExcluirAutomovelController
 */
@WebServlet("/ExcluirAutomovelController")
public class ExcluirAutomovelController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	Connection conn = null;
	AcessoBD bd = new AcessoBD();
	AutomovelDAO autoDAO = new AutomovelDAO();
	double confirm;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExcluirAutomovelController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request , response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		//String chassi = (String) request.getParameter("tChassi");
		confirm = 1;
		Automovel aTO = (Automovel) session.getAttribute("aTO");
		
		try {
			conn = bd.obtemConexao();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			
		}
		try{
			
			if(aTO != null){
								
				autoDAO.excluirAuto(conn, aTO);
				conn.commit();
				conn.close();
				confirm = 2;
				session.removeAttribute("tChassi");
				session.removeAttribute("aTO");
				session.removeAttribute("excluir");
				
			}
			
			
			session.setAttribute("Confirm",confirm);
			RequestDispatcher view = request.getRequestDispatcher("automovelexcluir.jsp");
			view.forward(request,response);
			
		}
		catch(Exception e){
			
			session.setAttribute("Confirm",confirm);
			RequestDispatcher view = request.getRequestDispatcher("automovelexcluir.jsp");
			view.forward(request,response);
		}
	}

}
