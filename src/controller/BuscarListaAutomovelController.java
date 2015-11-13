package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AutomovelDAO;

import dao.AcessoBD;
import model.*;

/**
 * Servlet implementation class BuscarListaAutomovelController
 */
@WebServlet("/BuscarListaAutomovelController")
public class BuscarListaAutomovelController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private AcessoBD bd = new AcessoBD();
	private Connection conn = null;
	private AutomovelDAO autoDAO = new AutomovelDAO();
	private ArrayList<Automovel> auto;
	
	/**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarListaAutomovelController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		String agencia = (String) request.getParameter("tAgencia");
		String fabricante = "";
		String grupo = "";
		try{
			fabricante = (String) request.getParameter("tFabricante");
		}
		catch(Exception e){fabricante = "";}
		try{
			grupo = (String) request.getParameter("tGrupo");
		}
		catch(Exception e){grupo = "";}
		
		
		
		try {
			conn = bd.obtemConexao();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			RequestDispatcher view = request.getRequestDispatcher("errobanco.jsp");
			view.forward(request, response);
		}
			
		if(!fabricante.equals("")){
			
			if(!grupo.equals("")){
				auto = autoDAO.carregarTodos2(conn, agencia, fabricante, ""+ grupo.charAt(0));
				session.setAttribute("listaveiculo", auto);
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				RequestDispatcher view = request.getRequestDispatcher("locarveiculo.jsp");
				view.forward(request, response);
			}
			else{
				auto = autoDAO.carregarTodos2(conn, agencia, fabricante);
				session.setAttribute("listaveiculo", auto);
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				RequestDispatcher view = request.getRequestDispatcher("locarveiculo.jsp");
				view.forward(request, response);
			}
		}
		else if(!grupo.equals("")){
			auto = autoDAO.carregarTodos3(conn, agencia,"" + grupo.charAt(0));
			session.setAttribute("listaveiculo", auto);
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			RequestDispatcher view = request.getRequestDispatcher("locarveiculo.jsp");
			view.forward(request, response);
		}
		else{
			
			auto = autoDAO.carregarTodos2(conn, agencia);
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			session.setAttribute("listaveiculo", auto);
			RequestDispatcher view = request.getRequestDispatcher("locarveiculo.jsp");
			view.forward(request, response);
		}
		
	}

}
