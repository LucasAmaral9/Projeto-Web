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
 * Servlet implementation class AlterarAutomovelController
 */
@WebServlet("/AlterarAutomovelController")
public class AlterarAutomovelController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private AcessoBD bd = new AcessoBD();
	private Connection conn;
	private AutomovelDAO autoDAO = new AutomovelDAO();
	private int w = 0;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlterarAutomovelController() {
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
		String chassi = "" + String.valueOf(request.getParameter("tChassi"));
		chassi.replaceAll("\\s","");
		try {
			conn = bd.obtemConexao();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Automovel aTO = new Automovel(chassi);
		
		aTO.setModelo( "" + (String) request.getParameter("tModelo") );
		aTO.setPlaca( "" + (String) request.getParameter("tPlaca") );	
		aTO.setFabricante("" + (String) request.getParameter("tFabricante") );	
		aTO.setCidade("" +(String) request.getParameter("tCidade") );	
		aTO.setEstado("" +(String) request.getParameter("tEstado") );	
		aTO.setGrupo( request.getParameter("tGrupo").charAt(0) );	
		aTO.setAcessorio("" +(String) request.getParameter("tAcessorio"));	
		aTO.setKmRodado( Integer.parseInt(request.getParameter("tKmrodado")));	
		aTO.setPreço( Double.parseDouble(request.getParameter("tPreco")));
		aTO.setAgencia("" + (String) request.getParameter("tAgencia")); 
		
		if(aTO != null){
			
			String z = "";
			try{
				z = "" + (String) session.getAttribute("alterar2");
			}
			catch(Exception e){
				z = "";
			}
			if(z.equals("1")){
					session.removeAttribute("alterar2");
					
				    try{
				    	//autoDAO.atualizaCidade("" + request.getParameter("tCidade") , conn, aTO);
				    	//autoDAO.atualizaEstado("" + request.getParameter("tEstado") , conn, aTO);
				    	//autoDAO.atualizaGrupo(request.getParameter("tGrupo").charAt(0) , conn, aTO);
				    	//autoDAO.atualizaAcessorio(2 , conn, aTO);
				    	//autoDAO.atualizaKm(Integer.parseInt(request.getParameter("tKmrodado")) , conn, aTO);
				    	//autoDAO.atualizaPreço(Double.parseDouble(request.getParameter("tPreco")) , conn, aTO);
				    	
				    	autoDAO.atualiza2("", conn, aTO); //Pri parametro na
				    	//conn.commit();
				    	conn.close();
				    	w = 1;
					    session.setAttribute("alterarconfirm", w);
						RequestDispatcher view = request.getRequestDispatcher("automovelalterar.jsp");
						view.forward(request , response);
				    }
				    catch(Exception e){
				    	e.printStackTrace();
				    	RequestDispatcher view = request.getRequestDispatcher("errobanco.jsp");
						view.forward(request , response);
				    }
				    
				    
			}
			else{
				autoDAO.carregarAuto(conn, aTO);
				session.setAttribute("automovel",aTO);
				session.removeAttribute("alterar2");
				session.removeAttribute("alterar");
				RequestDispatcher view = request.getRequestDispatcher("automovelalterarok.jsp");
				view.forward(request,response);
			}
		}
		
		
	}

}
