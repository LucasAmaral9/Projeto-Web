package dao;


import java.util.*;
import javax.swing.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.*;
import model.*;


public class ClienteDAO extends AcessoBD {
   // atributo
   private PreparedStatement st;
   protected Connection conn;
   private DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
   private java.sql.Date d;   // construtor
   public ClienteDAO() {
      super();
      try{
         conn = obtemConexao();
      }
      catch(Exception a){
         System.out.println("A");
      }
      this.st = null;
   }
   // incluir Cliente na tabela tabCliente
   public void incluir(Connection conn,Cliente cTO) {
      String sql = "";
      
      try {
         java.sql.Date sqlDate = new java.sql.Date(cTO.getDataNasc().getTime());
         java.sql.Date sqlDate2 = new java.sql.Date(cTO.getValidadeC().getTime());
         sql = "INSERT INTO cliente (Nome, CPF, Telefone, Email, DataNascimento, Sexo, RG, ValidadeCarteira, Estado, Endereco, Numero, NumeroHabilitacao) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
         
         st = conn.prepareStatement(sql);
         // substitui as ? por valores
         st.setString(1,"" +  cTO.getNome());
         st.setString(2,"" + cTO.getCPF());
         st.setString(3,"" + cTO.getTel());
		 st.setString(4,"" +  cTO.getEmail());
			
			st.setDate(5,sqlDate); 
			st.setString(6,"" + cTO.getSexo());
			st.setString(7, "" + cTO.getRG());
			st.setDate(8,sqlDate2);
			st.setString(9, "" +  cTO.getEstado());
			st.setString(10, "" +  cTO.getEndereco());
			st.setString(11,"" + cTO.getNumero());
			st.setInt(12, cTO.getNumHab());
			
         
         st.execute();
         //st.close();
      }
      catch(Exception e) {
            System.out.println("Erro no Banco de Dados!\n\nContate seu Administrador do Sistema!");
      }
   }
   // procurar
   public Cliente procurar2(Connection connn ,String CPF) {
      Cliente cTO = null;
      String sql = "";
      ResultSet rs  = null;
      
      try {
         sql = "select * from cliente where CPF = ?";
         this.st = connn.prepareStatement(sql);
         this.st.setString(1, CPF);
         //this.st.setString(2, nome);
         rs = this.st.executeQuery();
         if (rs.next()) {
            cTO = new Cliente();
            cTO.setID(rs.getInt("codigo"));
            cTO.setNome(rs.getString("Nome"));
            cTO.setCPF((rs.getString("CPF")));
            cTO.setTel(rs.getString("Telefone"));
            cTO.setEmail(rs.getString("Email"));
            String a = (formatter.format(rs.getDate("DataNascimento")));
            cTO.setDataNasc(formatter.parse(a));
            cTO.setSexo(rs.getString("Sexo").charAt(0));
            cTO.setRG(rs.getString("RG"));
            cTO.setValidadeC(new Date(rs.getDate("ValidadeCarteira").getTime()));
            cTO.setEstado(rs.getString("Estado"));
            cTO.setEndereco(rs.getString("Endereco"));
            cTO.setNumero(rs.getInt("Numero"));
            cTO.setNumHab(rs.getInt("NumeroHabilitacao"));
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
      return cTO;
   }
   
   public Cliente procurar(Connection connn ,String Nome) {
      Cliente cTO = null;
      String sql = "";
      ResultSet rs  = null;
      try {
         sql = "select * from cliente where Nome = ?";
         this.st = connn.prepareStatement(sql);
         this.st.setString(1, Nome);
         rs = this.st.executeQuery();
         if (rs.next()) {
            cTO = new Cliente();
            cTO.setNome(rs.getString("Nome"));
            cTO.setCPF((rs.getString("CPF")));
            cTO.setTel(rs.getString("Telefone"));
            cTO.setEmail(rs.getString("Email"));
            String a = (formatter.format(rs.getDate("DataNascimento")));
            Date b = formatter.parse(a);
            cTO.setDataNasc(b);
            cTO.setSexo(rs.getString("Sexo").charAt(0));
            cTO.setRG(rs.getString("RG"));
            cTO.setValidadeC(new Date(rs.getDate("ValidadeCarteira").getTime()));
            cTO.setEstado(rs.getString("Estado"));
            cTO.setEndereco(rs.getString("Endereco"));
            cTO.setNumero(rs.getInt("Numero"));
            cTO.setNumHab(rs.getInt("NumeroHabilitacao"));
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
      return cTO;
   }
   
      public void atualizar(Connection connn,String nome,Cliente cTO2){
         
         java.sql.Date sqlDate = new java.sql.Date(cTO2.getDataNasc().getTime());
         java.sql.Date sqlDate2 = new java.sql.Date(cTO2.getValidadeC().getTime());
         
         PreparedStatement stm = null;
         try
         {
                 
            String sqlInsert = "UPDATE cliente "+"SET Nome = ? , CPF = ?, Telefone = ?, Email = ?, DataNascimento = ?, Sexo = ?, RG = ?, ValidadeCarteira = ?, Estado = ?, Endereco = ?, Numero = ?, NumeroHabilitacao = ?" +  " where Nome = ?";
            
            stm = conn.prepareStatement(sqlInsert);
            stm.setString(1, cTO2.getNome());
            stm.setString(2, cTO2.getCPF());
            stm.setString(3, cTO2.getTel());
			   stm.setString(4, cTO2.getEmail());
			   stm.setDate(5,sqlDate); 
			   stm.setString(6,"" + cTO2.getSexo());
			   stm.setString(7, cTO2.getRG());
			   stm.setDate(8,sqlDate2);
			   stm.setString(9, cTO2.getEstado());
			   stm.setString(10, cTO2.getEndereco());
			   stm.setString(11,"" + cTO2.getNumero());
			   stm.setInt(12, cTO2.getNumHab());
            stm.setString(13, nome);
            stm.execute();
         }
         catch(Exception e)
            {
               e.printStackTrace();
               try
               {
                  conn.rollback();
               }
                  catch (SQLException e1)
                  {
                     System.out.print(e1.getStackTrace());
                  }
            }
         finally
         {
            if (stm != null)
            {
               try
               {
                  stm.close();
               }
                  catch (SQLException e1)
                  {
                     System.out.print(e1.getStackTrace());
                  }
            }
         }
      }
      
      public void atualizar2(Connection connn,String cpf,Cliente cTO2){
          
          java.sql.Date sqlDate = new java.sql.Date(cTO2.getDataNasc().getTime());
          java.sql.Date sqlDate2 = new java.sql.Date(cTO2.getValidadeC().getTime());
          
          PreparedStatement stm = null;
          try
          {
                  
             String sqlInsert = "UPDATE cliente "+"SET Nome = ? , CPF = ?, Telefone = ?, Email = ?, DataNascimento = ?, Sexo = ?, RG = ?, ValidadeCarteira = ?, Estado = ?, Endereco = ?, Numero = ?, NumeroHabilitacao = ?" +  " where CPF = ?";
             
             stm = conn.prepareStatement(sqlInsert);
             stm.setString(1, cTO2.getNome());
             stm.setString(2, cTO2.getCPF());
             stm.setString(3, cTO2.getTel());
 			 stm.setString(4, cTO2.getEmail());
 			 stm.setDate(5,sqlDate); 
 			 stm.setString(6,"" + cTO2.getSexo());
 			 stm.setString(7, cTO2.getRG());
 			 stm.setDate(8,sqlDate2);
 			 stm.setString(9, cTO2.getEstado());
 			 stm.setString(10, cTO2.getEndereco());
 			 stm.setString(11,"" + cTO2.getNumero());
 			 stm.setInt(12, cTO2.getNumHab());
             stm.setString(13, cpf);
             stm.execute();
             cTO2 = null;
          }
          catch(Exception e)
             {
                e.printStackTrace();
                try
                {
                   conn.rollback();
                }
                   catch (SQLException e1)
                   {
                      System.out.print(e1.getStackTrace());
                   }
             }
          finally
          {
             if (stm != null)
             {
                try
                {
                   stm.close();
                }
                   catch (SQLException e1)
                   {
                      System.out.print(e1.getStackTrace());
                   }
             }
          }
       }


         
   // alterar
     public void deletar(Connection connn,long CPF) {
      String sql = "";
      try {
         sql = "delete from Cliente where CPF = ?";
         this.st = connn.prepareStatement(sql);
         this.st.setLong(1, CPF);
         this.st.executeUpdate();
         this.st.close();
      }
      catch(Exception e) {
            JOptionPane.showMessageDialog(
                     null,
                    "Erro no Banco de Dados!\n\nContate seu Administrador do Sistema!",
                    "ClienteDAO.deletar(long)",
                    JOptionPane.WARNING_MESSAGE);
      }
   }
   
   public String[][] carregarTodos(Connection connn){
   
      String sqlSelect = "SELECT * FROM cliente order by Nome";  
      PreparedStatement stm = null; 
      ResultSet rs = null;
      String [][] vet = null;
      int i = 0;
      int j = 0; 
         
      try{ 
      
         stm = connn.prepareStatement(sqlSelect); 
         rs = stm.executeQuery();
         
         rs.last();
         int count = rs.getRow();
         rs.beforeFirst();
          
         vet = new String[count][4];                      
         while (rs.next()){ 
         
            vet[i][j++] = rs.getString(2);
            vet[i][j++] = rs.getString(3);
            vet[i][j++] = "" + rs.getString(10);
            vet[i++][j++] = rs.getString(11);
            
                        
            j = 0;
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
      
   return vet;   
   }
   
   public String[][] carregarTodos2(Connection connn){
   
      String sqlSelect = "SELECT * FROM Cliente order by Nome";  
      PreparedStatement stm = null; 
      ResultSet rs = null;
      String [][] vet = null;
      int i = 0;
      int j = 0; 
         
      try{ 
      
         stm = connn.prepareStatement(sqlSelect); 
         rs = stm.executeQuery();
         
         rs.last();
         int count = rs.getRow();
         rs.beforeFirst();
          
         vet = new String[count][4];                      
         while (rs.next()){ 
         
            vet[i][j++] = rs.getString(2);
            vet[i++][j++] = rs.getString(3);
                                    
            j = 0;
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
      
   return vet;   
   }
   
   public Cliente procurar3(Connection conn2, int id) {
	Cliente cTO = null;
    String sql = "";
    ResultSet rs  = null;
    try {
       sql = "select * from cliente where codigo = ?";
       this.st = conn2.prepareStatement(sql);
       this.st.setInt(1, id);
       rs = this.st.executeQuery();
       if (rs.next()) {
          cTO = new Cliente();
          cTO.setNome(rs.getString("Nome"));
          cTO.setCPF((rs.getString("CPF")));
          cTO.setTel(rs.getString("Telefone"));
          cTO.setEmail(rs.getString("Email"));
          String a = (formatter.format(rs.getDate("DataNascimento")));
          Date b = formatter.parse(a);
          cTO.setDataNasc(b);
          cTO.setSexo(rs.getString("Sexo").charAt(0));
          cTO.setRG(rs.getString("RG"));
          cTO.setValidadeC(new Date(rs.getDate("ValidadeCarteira").getTime()));
          cTO.setEstado(rs.getString("Estado"));
          cTO.setEndereco(rs.getString("Endereco"));
          cTO.setNumero(rs.getInt("Numero"));
          cTO.setNumHab(rs.getInt("NumeroHabilitacao"));
       }
       this.st.close();
    }
    catch(Exception e) {
          System.out.println("Erro no Banco de Dados!\n\nContate seu Administrador do Sistema!");
                  
    }
    return cTO;
   }


}


