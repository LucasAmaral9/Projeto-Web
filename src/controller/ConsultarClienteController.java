package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import dao.AcessoBD;
import dao.ClienteDAO;
import java.sql.*;
import model.*;

/**
 * Servlet implementation class ConsultarClienteController
 */
@WebServlet("/ConsultarClienteController")
public class ConsultarClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Cliente cTO = null;
	private Connection conn;
	private ClienteDAO cDAO = new ClienteDAO();
	private int x = 0;
    /**
     * Default constructor. 
     */
    public ConsultarClienteController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request , response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
				
		AcessoBD bd = new AcessoBD();
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String nome = (String) request.getParameter("tNome");
		try{
			conn = bd.obtemConexao();
		}
		catch(Exception e){
			//----ERRO
			RequestDispatcher view = request.getRequestDispatcher("errobanco.jsp");
			view.forward(request , response);
		}
		String r = "";
		try{
			r = "" + (String) session.getAttribute("alterar");
		}
		catch(Exception e){}
		
		if(nome != null){
				
				try{
					cTO = cDAO.procurar2(conn, nome);
					conn.close();
					if(cTO != null){										
						session.setAttribute("cTO",cTO);
						if(r.equals("1")){
							session.removeAttribute("alterar");
							RequestDispatcher view = request.getRequestDispatcher("clientealterarok.jsp");
							view.forward(request, response);
							
						}
						else{
							RequestDispatcher view = request.getRequestDispatcher("clienteconsultarok.jsp");
							view.forward(request, response);
						}
					}
					
					
					else{//EERRROOOO     cTO VAZIO NULL       NAO ENCONTRADO
						x = 1;
						session.setAttribute("erro", x);
						if(r.equals("1")){
							session.removeAttribute("alterar");
							RequestDispatcher view = request.getRequestDispatcher("clientealterar.jsp");
							view.forward(request, response);
						}
						else{
							RequestDispatcher view = request.getRequestDispatcher("clienteconsultar.jsp");
							view.forward(request, response);
						}
					}
				}
				catch(Exception e){
					RequestDispatcher view = request.getRequestDispatcher("errobanco.jsp");
					view.forward(request, response);
				}
			
		}
		//----ERRO
		else{
			//RequestDispatcher view = request.getRequestDispatcher("erroconsultarcliente.jsp");
			//view.forward(request, response);
			
		}
		
		
	}

}
