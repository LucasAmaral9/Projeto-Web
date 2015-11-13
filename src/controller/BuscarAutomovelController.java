package controller;



import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
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



@WebServlet("/buscara.do")
public class BuscarAutomovelController extends HttpServlet {
	
	private Connection conn = null;
	private AutomovelDAO autod = new AutomovelDAO();
	boolean ver = false;
	int x = 0;
	
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AcessoBD bd = new AcessoBD();
		
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String chassi = (String) request.getParameter("tChassi");
		Automovel auto = new Automovel(chassi);
		
		try {
			conn = bd.obtemConexao();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			RequestDispatcher view = request.getRequestDispatcher("errobanco.jsp");
			view.forward(request, response);
		}
		
		try{
			String r = "";	
			String z = "";
			auto = autod.carregarAuto(conn, auto);
			conn.close();
			try{
				r = "" + (String) session.getAttribute("excluir");
				z = "" + (String) session.getAttribute("alterar");
			}
			catch(Exception e){}
			
			if(auto != null){
				
				session.setAttribute("aTO",auto);
				if(r.equals("1")){
					session.removeAttribute("excluir");
					RequestDispatcher view = request.getRequestDispatcher("automovelexcluirok.jsp");
					view.forward(request, response);
				}
				else if (z.equals("1")){
					session.removeAttribute("alterar");
					RequestDispatcher view = request.getRequestDispatcher("automovelalterarok.jsp");
					view.forward(request, response);
				}
				else{
					session.removeAttribute("excluir");
					session.removeAttribute("alterar");
					RequestDispatcher view = request.getRequestDispatcher("automovelconsultark.jsp");
					view.forward(request, response);
				}
			}
			
			else{// VEICULO NAO ENCONTRADO  NULL     MSG DE ERRO
				x = 1;
				session.setAttribute("erro", x);
				if(r.equals("1")){
					session.removeAttribute("excluir");
					session.removeAttribute("alterar");
					RequestDispatcher view = request.getRequestDispatcher("automovelexcluir.jsp"); 
					view.forward(request, response);
				}
				else if(z.equals("1")){
					session.removeAttribute("alterar");
					session.removeAttribute("excluir");
					RequestDispatcher view = request.getRequestDispatcher("automovelalterar.jsp"); 
					view.forward(request, response);
				}
				else{
					session.removeAttribute("excluir");
					session.removeAttribute("alterar");
					RequestDispatcher view = request.getRequestDispatcher("automovelconsultar.jsp"); 
					view.forward(request, response);
				}
				
			}
		}
		catch(Exception e){
			
			RequestDispatcher view = request.getRequestDispatcher("errobanco.jsp");
			view.forward(request, response);
			
		}
	}
}
