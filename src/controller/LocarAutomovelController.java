package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
 * Servlet implementation class LocarVeiculoController
 */
@WebServlet("/LocarAutomovelController")
public class LocarAutomovelController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy"); 
	private AcessoBD bd = new AcessoBD();
	private Connection conn;
	private AutomovelDAO autoDAO = new AutomovelDAO();
	private ClienteDAO cDAO = new ClienteDAO();
	
	
	
    public LocarAutomovelController() {
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
		
		Automovel aTO = null;
		Cliente cTO = null;
		int pagamento = 0;
		
		try {
			conn = bd.obtemConexao();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Objetos cliente e veiculo
		try{
			aTO = (Automovel) session.getAttribute("locarbuscarv");
			cTO = (Cliente) session.getAttribute("locarbuscarc");
			
		}
		catch(Exception e){}
		
		try{
			pagamento = (Integer) session.getAttribute("pagamento");
		}
		catch(Exception e){}
		if(cTO == null){
		//BUSCAR CLIENTE	
			String cpf = (String) request.getParameter("tCPF");
			
			
			if(cpf != null){
				
				cTO = cDAO.procurar2(conn, cpf);
				
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				session.setAttribute("locarbuscarc", cTO);
				RequestDispatcher view = request.getRequestDispatcher("locar.jsp");
				view.forward(request, response);
				
			}
						
		}
		else if(pagamento == 1){
			session.removeAttribute("listaveiculo");
			String chassi = request.getParameter("tChassiLocar");
			int id = cTO.getID();
			String dataAtual = request.getParameter("tDataAtual");
			String dataDevolucao = request.getParameter("tDataDevolucao");
			String pais = request.getParameter("tPais");
			String estado = request.getParameter("tEstado");
			String cidade = request.getParameter("tCidade");
			String agenciaDevolucao = request.getParameter("tAgenciaDevolucao"); //Nao usando por enqto
			String tipoDeTarifa = request.getParameter("tTarifa");
			String formaDePagamento = (String) request.getParameter("tRadio");
			double valor;
			if(tipoDeTarifa.equals("Livre")){
				valor = Double.parseDouble(request.getParameter("tValor")) * 4;
			}
			else{
				valor = Double.parseDouble(request.getParameter("tValor"));
			}
			String localagencia = aTO.getAgencia();
			try{
				Locacao lTO = new Locacao(chassi,id,(Date) format.parse(request.getParameter("tDataAtual")),(Date) format.parse(request.getParameter("tDataDevolucao")),pais+" "+estado+" "+cidade,tipoDeTarifa,formaDePagamento,valor,localagencia);
				session.setAttribute("objlocacao",lTO);
			}
			catch(Exception e){
				e.printStackTrace();
				RequestDispatcher view = request.getRequestDispatcher("errobanco.jsp");
				view.forward(request, response);
			}
			
			session.removeAttribute("pagamento");
			
			session.setAttribute("tipopagamento","" +(String) request.getParameter("tRadio"));
			RequestDispatcher view = request.getRequestDispatcher("pagamento.jsp");
			view.forward(request, response);
			
		}
		
		else{
			try{
													
				session.removeAttribute("listaveiculo");
				Locacao lTO = (Locacao) session.getAttribute("objlocacao");
				LocacaoDAO lDAO = new LocacaoDAO();
				
				lDAO.incluir(conn, lTO); // Inclui locaçao
				
				autoDAO.atualizaStats("Locado", conn, lTO.getChassi()); //Altera Estado do Veiculo
				lTO = lDAO.procurar(conn,lTO.getChassi());
								
				conn.close();
				session.removeAttribute("locarbuscarv");
				session.removeAttribute("locarbuscarc");
				session.removeAttribute("objlocacao");
				session.setAttribute("numerolocacao", lTO.getID());
				session.setAttribute("locarconfirm", 1);
				RequestDispatcher view = request.getRequestDispatcher("locar.jsp");
				view.forward(request, response);
			}
			catch(Exception e){
				e.printStackTrace();
				RequestDispatcher view = request.getRequestDispatcher("errobanco.jsp");
				view.forward(request, response);
			}
			
		}
		
		
	
	}

}
