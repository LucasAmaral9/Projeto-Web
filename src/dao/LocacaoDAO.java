package dao;

import javax.swing.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.*;
import model.*;


public class LocacaoDAO{
   // atributo
   private PreparedStatement st;
   protected Connection conn;
   private DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
   private java.sql.Date d;
      
   public LocacaoDAO() {
      
      
      try{
			AcessoBD bd = new AcessoBD();
         conn = bd.obtemConexao();
         conn.setAutoCommit(false);
         
      }
      catch(Exception a){
         System.out.println("Erro");
      }
      this.st = null;
   }
   
   public void incluir(Connection conn,Locacao lTO) {
      String sql = "";
      st = null;
      try {
         java.sql.Date sqlDate = new java.sql.Date(lTO.getDataLocacao().getTime());
         java.sql.Date sqlDate2 = new java.sql.Date(lTO.getDataDevolucao().getTime());
         sql = "INSERT INTO Locacao (VeiculoChassi, ClienteID, datalocacao, datadevolucao, localdevolucao, tipoTarifa, formaPagamento, Valor, locallocacao, devolvido) values (?,?,?,?,?,?,?,?,?,?)";
         
         this.st = conn.prepareStatement(sql);
         
         this.st.setString(1, lTO.getChassi());
         this.st.setInt(2, lTO.getClienteID());
         this.st.setDate(3, sqlDate);
			this.st.setDate(4, sqlDate2);
         this.st.setString(5,lTO.getLocalDevolucao()); 
			this.st.setString(6,"" + lTO.getTipoTarifa());
			this.st.setString(7,lTO.getPagamento());
			this.st.setDouble(8,lTO.getValor());
         this.st.setString(9,lTO.getLocalLocacao());
         this.st.setBoolean(10, false);
			      
         this.st.execute();//up
         this.st.close();
         
         

      }
      catch(Exception e) {
            System.out.println("Erro ao Incluir no Banco de Dados!");
      }
   }
   // procurar
   public Locacao procurar(Connection connn,String chassi) {
      Locacao lTO = null;
      String sql = "";
      ResultSet rs  = null;
      try {
         sql = "select * from Locacao where VeiculoChassi = ? and devolvido = ?";
         this.st = connn.prepareStatement(sql);
         this.st.setString(1, chassi);
         this.st.setBoolean(2, false);
         rs = this.st.executeQuery();
         
         if (rs.next()) {
            lTO = new Locacao();
            lTO.setID(rs.getInt("id"));
            lTO.setChassi(rs.getString("VeiculoChassi"));
            lTO.setClienteID(rs.getInt("ClienteID"));
            lTO.setDataLocacao((rs.getDate("datalocacao")));
            lTO.setDataDevolucao(rs.getDate("datadevolucao"));
            //lTO.setLocalLocacao(rs.getString("locallocacao"));
            lTO.setLocalDevolucao(rs.getString("localdevolucao"));
            lTO.setTipoTarifa(rs.getString("TipoTarifa"));
            lTO.setPagamento(rs.getString("formaPagamento"));
            lTO.setValor(rs.getInt("Valor"));
            
            
         }
         this.st.close();
      }
      catch(Exception e) {
            JOptionPane.showMessageDialog(
                     null,
                    "Erro no Banco de Dados!\n\nContate seu Administrador do Sistema!",
                    "ClienteDAO.procurar(long)",
                    JOptionPane.WARNING_MESSAGE);
      }
      return lTO;
   }
   
      
   public String carregarTodos(Connection conn){
   
      String sqlSelect = "SELECT * FROM Locacao where datalocacao = ? order by id";  
      PreparedStatement stm = null; 
      ResultSet rs = null;
      AutomovelDAO autoDAO = new AutomovelDAO();
      String [][] vet = null;
      Automovel vTO = null;
      String text = "";//bn.getString("locacaoDAO.locdiaria") + "\n";
      int i = 0;
      int j = 0; 
         
      try{ 
                  
         stm = conn.prepareStatement(sqlSelect); 
         java.sql.Date d = new java.sql.Date(System.currentTimeMillis());
         stm.setDate(1, d);
         
         rs = stm.executeQuery();
         
                                                 
         while (rs.next()){ 
         
            text +="\n\nID Locação: " + rs.getString(1);
            text +="\nCPF Cliente: " + rs.getString(3);
            text +="\nData Locação: " + rs.getString(4);
            text +="\nData Devolução: " + rs.getString(5);
            text +="\nLocal Devolução: " + rs.getString(6);
            text +="\nTipo Tarifa: " + rs.getString(7);
            text +="\nForma Pagamento: " + rs.getString(8);
            text +="\nValor: " + rs.getString(9);                        
            vTO = new Automovel(rs.getString(2));
            autoDAO.carregarAuto(conn,vTO);
            text +="\nModelo: " + vTO.getModelo();
            text +="\nFabricante: " + vTO.getFabricante() + "\n";  
         }
      }
      catch (Exception e){ 
      
         e.printStackTrace(); 
         try{ 
         
            conn.rollback(); 
         } 
         catch (SQLException e1){ 
         
            System.out.print(e1.getStackTrace()); 
         } 
      } 
      finally{ 
      
         if(stm != null){ 
            try{ 
               stm.close(); 
            } 
            
            catch(SQLException e1){ 
            
               System.out.print(e1.getStackTrace()); 
            
            } 
         
         } 
      
      } 
      
   return text;   
   }

public Locacao procurar(Connection connn,int x) {
	 
	      Locacao lTO = null;
	      String sql = "";
	      ResultSet rs  = null;
	      try {
	         sql = "select * from Locacao where id = ? and devolvido = ?";
	         this.st = connn.prepareStatement(sql);
	         this.st.setInt(1, x);
	         this.st.setBoolean(2, false);
	         rs = this.st.executeQuery();
	         
	         if (rs.next()) {
	            
	        	lTO = new Locacao();
	            lTO.setID(rs.getInt("id"));
	            lTO.setChassi(rs.getString("VeiculoChassi"));
	            lTO.setClienteID(rs.getInt("ClienteID"));
	            lTO.setDataLocacao((rs.getDate("datalocacao")));
	            lTO.setDataDevolucao(rs.getDate("datadevolucao"));
	            lTO.setLocalLocacao(rs.getString("locallocacao"));
	            lTO.setLocalDevolucao(rs.getString("localdevolucao"));
	            lTO.setTipoTarifa(rs.getString("TipoTarifa"));
	            lTO.setPagamento(rs.getString("formaPagamento"));
	            lTO.setValor(rs.getInt("Valor"));
	            
	            
	         }
	         this.st.close();
	      }
	      catch(Exception e) {
	            System.out.println("Erro no Banco de Dados!\n\nContate seu Administrador do Sistema!");
	                    
	      }
	      return lTO;
	   }

public void Devolver(Connection conn2, int id) {
	String sql = "";
    st = null;
    
    try{
    	
    	sql = "UPDATE Locacao "+"SET devolvido = ? " +"where id = ?";
    	this.st = conn2.prepareStatement(sql);
    	this.st.setBoolean(1, true);
    	this.st.setInt(2, id);
    	this.st.execute();
    	
    }
    catch (Exception e){ 
        
        e.printStackTrace(); 
        try{ 
        
           conn.rollback(); 
        } 
        catch (SQLException e1){ 
        
           System.out.print(e1.getStackTrace()); 
        } 
     } 
     finally{ 
     
        if(st != null){ 
           try{ 
              st.close(); 
           } 
           
           catch(SQLException e1){ 
           
              System.out.print(e1.getStackTrace()); 
           
           } 
        
        } 
     
     }
	
}
	
}