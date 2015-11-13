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

import dao.AcessoBD;
import dao.AutomovelDAO;
import model.*;

/**
 * Servlet implementation class LocarAdicionarAutomovelController
 */
@WebServlet("/LocarAdicionarAutomovelController")
public class LocarAdicionarAutomovelController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private AcessoBD bd = new AcessoBD();
	private Connection conn;
	
		
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LocarAdicionarAutomovelController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request , response);
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		String x = request.getParameter("tNumVei");
		ArrayList<Automovel> lista = (ArrayList<Automovel>) session.getAttribute("listaveiculo");
		try {
			conn = bd.obtemConexao();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		session.setAttribute("locarbuscarv", lista.get(Integer.parseInt(x)));
		session.removeAttribute("listaveiculo");
		RequestDispatcher view = request.getRequestDispatcher("locar.jsp");
		view.forward(request, response);
		
		
	}

}
