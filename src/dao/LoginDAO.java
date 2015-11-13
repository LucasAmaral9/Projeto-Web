package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import javax.swing.*;
import model.*;


public class LoginDAO  {
	
	private Connection conn = null;
    private Login a;
    
    public LoginDAO () {
    	
    	try 
        {
           AcessoBD bd = new AcessoBD();
           conn = bd.obtemConexao();
           conn.setAutoCommit(true);
        }
        catch(Exception e3)
    	{
              JOptionPane.showMessageDialog(null,"Erro - Acesso ao Banco de Dados");
        }
     
    }
    
    public boolean AutenticarLogin(String usuario, String senha){
    	
    	String sqlSelect = "SELECT * FROM usuarios WHERE idUsuarios = ? and senha = ?";
        PreparedStatement stm = null;
        
        ResultSet rs = null;
        try
        {
           stm = conn.prepareStatement(sqlSelect);
           stm.setString(1,usuario);
           stm.setString(2,senha);
           rs = stm.executeQuery();
           if (rs.next())
           {
        	  a = new Login(rs.getString(1),rs.getString(2),1);
        	  if(a.getUsuario().equals(usuario) && a.getSenha().equals(senha)){
        		  
        		  return true;
        	  }
                         
           }
           
        }
        
             
         catch (Exception e)
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
     

    	return false;
    }

}
