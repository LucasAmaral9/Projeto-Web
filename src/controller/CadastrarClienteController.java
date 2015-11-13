package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
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
import dao.ClienteDAO;
import model.*;

/**
 * Servlet implementation class CadastrarClienteController
 */
@WebServlet("/CadastrarClienteController")
public class CadastrarClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	private SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy"); 
	private ClienteDAO cl = new ClienteDAO();
	private AcessoBD bd = new AcessoBD();
	private Connection conn;
	
	/**
     * @see HttpServlet#HttpServlet()
     */
    public CadastrarClienteController() {
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
		Cliente cTO = new Cliente();
		
				
		try {
			conn = bd.obtemConexao();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		try{
			cTO.setNome("" + request.getParameter("tNome") );    //nomet.getText());
			cTO.setCPF( "" + request.getParameter("tCpf") );  //Integer.parseInt(cpft.getText()));
			cTO.setRG( "" + request.getParameter("tRg") ) ;//rgt.getText()) );
			cTO.setEmail("" + request.getParameter("tEmail") );//mailt.getText());
			cTO.setTel("" + request.getParameter("tTel") ); //telt.getText());
			
			cTO.setDataNasc( (Date) format.parse(request.getParameter("tData")) );//(Date) format.parse ( request.getParameter("tData") ) );
					
			cTO.setSexo( request.getParameter("tGenero").charAt(0) );//sexot.getText().charAt(0));
			cTO.setEstado( "" + request.getParameter("tEstado"));//estadot.getText());
			cTO.setEndereco("" +  request.getParameter("tEndereco") );//endereçot.getText());
			cTO.setNumero( Integer.parseInt (request.getParameter("tNumero") ) );//(numerot.getText()) );
			cTO.setNumHab( Integer.parseInt (request.getParameter("tNumHab") ) );//(habit.getText()) );
			
			cTO.setValidadeC( (Date) format.parse (request.getParameter("tValidadeC") ) );
					
			cl.incluir(conn, cTO);
				
			//conn.commit();
					
			conn.close();
			
			RequestDispatcher view = request.getRequestDispatcher("clientecadastrar.jsp");
			view.forward(request, response);
        
        
		}
		catch(Exception e){
			
			RequestDispatcher view = request.getRequestDispatcher("errobanco.jsp");
			view.forward(request, response);
		}
		
		
	}

}
