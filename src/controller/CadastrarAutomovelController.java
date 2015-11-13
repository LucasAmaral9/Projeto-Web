package controller;

import java.io.IOException;
import java.sql.Connection;
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
 * Servlet implementation class CadastrarAutomovelController
 */
@WebServlet("/CadastrarAutomovelController")
public class CadastrarAutomovelController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private Connection conn;
	private AutomovelDAO dao = new AutomovelDAO(); 
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastrarAutomovelController() {
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
		
		AcessoBD bd = new AcessoBD();
		
		int confirm = 0;
		
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		String a = "" + request.getParameter("tChassi");
        String b = "" + request.getParameter("tModelo");
        String c = "" + request.getParameter("tPlaca");
        String d = "" + request.getParameter("tFabricante");
        String es = "" + request.getParameter("tCidade");
        String f = "" + request.getParameter("tEstado");
        int i = Integer.parseInt(request.getParameter("tRodado")); 
        double j = Double.parseDouble(request.getParameter("tPreco"));
        char g = request.getParameter("tGrupo").charAt(0);
        String ace = "" + request.getParameter("tAcessorio");
        String agencia = "" + request.getParameter("tAgencia");
        
        try
        {
        	
           conn = bd.obtemConexao();
           Automovel au = new Automovel(a,b,c,d,es,f,g,ace,i,j);
           au.setAgencia("" + agencia);
           dao.incluirAuto(conn,au);
           conn.close();          
           confirm = 1;
           session.setAttribute("veiculocadastrarconfirm",confirm);
           RequestDispatcher view = request.getRequestDispatcher("automovelcadastrar.jsp");
		   
		   view.forward(request , response);
           
        
        }
        catch(Exception e)
        {
        
        	confirm = 0;
            
            RequestDispatcher view = request.getRequestDispatcher("errobanco.jsp");
            view.forward(request , response);
        }

	}

}
