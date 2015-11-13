package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import dao.*;
import model.*;

/**
 * Servlet implementation class DevolucaoController
 */
@WebServlet("/DevolucaoController")
public class DevolucaoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy"); 
	private AcessoBD bd = new AcessoBD();
	private Connection conn;
	private AutomovelDAO autoDAO = new AutomovelDAO();
	private LocacaoDAO lDAO = new LocacaoDAO();
	private ClienteDAO cDAO = new ClienteDAO();
	
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DevolucaoController() {
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
		Locacao lTO = null;
				
		try {
			conn = bd.obtemConexao();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		try{
			lTO = (Locacao) session.getAttribute("devolucaoinfo");
		}
		catch(Exception e){
			lTO = null;
		}
		if(lTO == null){
		
			int x = Integer.parseInt(request.getParameter("tCodigo"));
			try{
				lTO = lDAO.procurar(conn,x);
				
				Cliente cTO = cDAO.procurar3(conn, lTO.getClienteID());
				lTO.setCPF(cTO.getCPF());
				
				conn.close();
				session.setAttribute("devolucaoinfo", lTO);
				RequestDispatcher view = request.getRequestDispatcher("devolucao.jsp");
				view.forward(request, response);
			}
			
			catch(Exception e){
				session.setAttribute("deverro", 1);
				RequestDispatcher view = request.getRequestDispatcher("devolucao.jsp");
				view.forward(request, response);
			}
		}
		else{
			
			try{
				lDAO.Devolver(conn,lTO.getID());
				String z = (String) request.getParameter("tAgenciaDevolucao");
				autoDAO.atualizaStats("Disponivel", conn, lTO.getChassi());
				autoDAO.atualizaAgencia(z,conn,lTO.getChassi());
				session.removeAttribute("devolucaoinfo");
				session.setAttribute("devolucaoconfirm",1);
				conn.close();
				RequestDispatcher view = request.getRequestDispatcher("devolucao.jsp");
				view.forward(request, response);
			}
			
			catch(Exception e){
				
				RequestDispatcher view = request.getRequestDispatcher("errobanco.jsp");
				view.forward(request, response);
			}
			
		}
		
	}

}
