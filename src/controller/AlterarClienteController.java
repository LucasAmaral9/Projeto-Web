package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import dao.ClienteDAO;
import dao.AcessoBD;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;
import java.text.*;
import model.*;

/**
 * Servlet implementation class AlterarClienteController
 */
@WebServlet("/AlterarClienteController")
public class AlterarClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	
	private ClienteDAO cDAO = new ClienteDAO();
	private Connection conn;
	private SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    /**
     * Default constructor. 
     */
    public AlterarClienteController() {
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
		String cpf = (String) request.getParameter("tCpf");
		
		Cliente cTO = new Cliente();
				
		try {
			conn = bd.obtemConexao();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			RequestDispatcher view = request.getRequestDispatcher("errobanco.jsp");
			view.forward(request , response);
		}
				
		try{
			
			cTO.setNome("" + request.getParameter("tNome") );    //nomet.getText());
			cTO.setCPF( request.getParameter("tCpf") ) ;  //Integer.parseInt(cpft.getText()));
			cTO.setRG( request.getParameter("tRg") );//rgt.getText()) );
			cTO.setEmail("" + request.getParameter("tEmail") );//mailt.getText());
			cTO.setTel("" + request.getParameter("tTel") ); //telt.getText());
			cTO.setDataNasc( (Date) format.parse ( request.getParameter("tData") ) );//( nast.getText() ) );
			cTO.setSexo( request.getParameter("tGenero").charAt(0) );//sexot.getText().charAt(0));
			cTO.setEstado( request.getParameter("tEstado"));//estadot.getText());
			cTO.setEndereco( request.getParameter("tEndereco") );//endereçot.getText());
			cTO.setNumero( Integer.parseInt (request.getParameter("tNumero") ) );//(numerot.getText()) );
			cTO.setNumHab( Integer.parseInt (request.getParameter("tNumHab") ) );//(habit.getText()) );
			cTO.setValidadeC( (Date) format.parse (request.getParameter("tValidadeC") ) );//(valit.getText()) );
			cDAO.atualizar2(conn,("" + cpf), cTO);
			//conn.commit();
			//cTO = null;
			conn.close();
			
			session.setAttribute("calterarconfirm", 1);
			RequestDispatcher view = request.getRequestDispatcher("clientealterar.jsp");
			view.forward(request, response);
        
        
		}
		catch(Exception e){
			RequestDispatcher view = request.getRequestDispatcher("errobanco.jsp");
			view.forward(request, response);
		}
		
	}

}
