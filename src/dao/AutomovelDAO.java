package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.*;

import model.*;

   public class AutomovelDAO
   {
      private Connection conn = null;
      private Automovel a;
      
   
      public AutomovelDAO()
      {
         try 
         {
            AcessoBD bd = new AcessoBD();
            conn = bd.obtemConexao();
            conn.setAutoCommit(true);
         }
            catch(Exception e3)
            {
               System.out.println("Erro - Banco de Dados");
            }
      
      
      
      }
      public void incluirAuto(Connection conn,Automovel a)
      {
         String sqlInsert = "INSERT INTO automovel(chassi, modelo, placa, fabricante, cidade, estado, grupo, acessorio, kmr, preço, agencia, stats) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
         PreparedStatement stm = null;
         try
         {
            stm = conn.prepareStatement(sqlInsert);
            stm.setString(1, a.getChassi());
            stm.setString(2, a.getModelo());
            stm.setString(3, a.getPlaca());
            stm.setString(4, a.getFabricante());
            stm.setString(5, a.getCidade());
            stm.setString(6, a.getEstado());
            stm.setString(7, String.valueOf(a.getGrupo()));
            stm.setString(8, a.getAcessorio());
            stm.setInt(9, a.getKmRodado());
            stm.setDouble(10, a.getPreço());
            stm.setString(11,a.getAgencia());
            stm.setString(12, "Disponivel");
         
            stm.execute();
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
      }
   //Excluir
      public void excluirAuto(Connection conn,Automovel a)
      {
         String sqlDelete = "DELETE FROM automovel WHERE chassi = ?";
         PreparedStatement stm = null;
         try
         {
            stm = conn.prepareStatement(sqlDelete);
            stm.setString(1,a.getChassi());
            stm.execute();
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
      }
   //Carregar
      public Automovel carregarAuto(Connection conn,Automovel a)
      {
         String sqlSelect = "SELECT * FROM automovel WHERE automovel.chassi = ?";
         PreparedStatement stm = null;
      
         ResultSet rs = null;
         try
         {
            stm = conn.prepareStatement(sqlSelect);
            stm.setString(1, a.getChassi());
            rs = stm.executeQuery();
            if (rs.next())
            {
               a.setModelo(rs.getString(2));
               a.setPlaca(rs.getString(3));
               a.setFabricante(rs.getString(4));
               a.setCidade(rs.getString(5));
               a.setEstado(rs.getString(6));
               a.setGrupo((rs.getString(7)).charAt(0));
               a.setAcessorio(rs.getString(8));
               a.setKmRodado(rs.getInt(9));
               a.setPreço(rs.getDouble(10));
               a.setAgencia(rs.getString(11));
               a.setStats(rs.getString(12));
                              
            
            }
            else{
            	return null;
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
         return a;
      }
		
		 public void carregarAuto2(Connection conn,Automovel a)
      {
         String sqlSelect = "SELECT * FROM automovel WHERE modelo = ?";
         PreparedStatement stm = null;
      
         ResultSet rs = null;
         try
         {
            stm = conn.prepareStatement(sqlSelect);
            stm.setString(1, a.getModelo());
            rs = stm.executeQuery();
            if (rs.next())
            {
               a.setChassi(rs.getString(1));
               a.setPlaca(rs.getString(3));
               a.setFabricante(rs.getString(4));
               a.setCidade(rs.getString(5));
               a.setEstado(rs.getString(6));
               a.setGrupo((rs.getString(7)).charAt(0));
               a.setAcessorio(rs.getString(8));
               a.setKmRodado(rs.getInt(9));
               a.setPreço(rs.getDouble(10));
            
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
      }
		 
		 public Automovel carregarAuto3(Connection conn,String b)
	      {
	         String sqlSelect = "SELECT * FROM automovel WHERE automovel.chassi = ?";
	         PreparedStatement stm = null;
	      
	         ResultSet rs = null;
	         try
	         {
	            stm = conn.prepareStatement(sqlSelect);
	            stm.setString(1, b);
	            rs = stm.executeQuery();
	            Automovel a = new Automovel();
	            if (rs.next())
	            {
	               a.setChassi(rs.getString(1));
	               a.setModelo(rs.getString(2));
	               a.setPlaca(rs.getString(3));
	               a.setFabricante(rs.getString(4));
	               a.setCidade(rs.getString(5));
	               a.setEstado(rs.getString(6));
	               a.setGrupo((rs.getString(7)).charAt(0));
	               a.setAcessorio(rs.getString(8));
	               a.setKmRodado(rs.getInt(9));
	               a.setPreço(rs.getDouble(10));
	               a.setAgencia(rs.getString(11));
	               a.setStats(rs.getString(12));
	               
	            
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
	         return a;
	      }	 

   //Atualizar---------------------------------------------------------------
      public void atualizaGrupo(char gru,Connection conn,Automovel a)
      {
         PreparedStatement stm = null;
         try
         {
                 
            String sqlInsert = "UPDATE automovel "+
               "SET grupo = ? " + 
               "where chassi = ?";
            
            stm = conn.prepareStatement(sqlInsert);
            stm.setString(1, String.valueOf(gru));
            stm.setString(2, a.getChassi());
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
      public void atualizaAcessorio(int i,Connection conn,Automovel a)
      {
      
         PreparedStatement stm = null;
         try
         {
            String sqlInsert = "UPDATE automovel "+
               "SET acessorio = ? " + 
               "where chassi = ?";
            
            stm = conn.prepareStatement(sqlInsert);
            stm.setInt(1, i);
            stm.setString(2, a.getChassi());   
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
      
      public void atualizaStats(String stat,Connection conn,Automovel a){
    	  PreparedStatement stm = null;
          try
          {
          
             String sqlInsert = "UPDATE automovel "+
                "SET stats = ? " + 
                "where chassi = ?";
                         
             stm = conn.prepareStatement(sqlInsert);
             stm.setString(1,"" +  stat);
             stm.setString(2, a.getChassi());
             stm.execute();
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
      }
      public void atualizaStats(String stat,Connection conn,String chassi){
    	  PreparedStatement stm = null;
          try
          {
          
             String sqlInsert = "UPDATE automovel "+
                "SET stats = ? " + 
                "where chassi = ?";
                
             
             stm = conn.prepareStatement(sqlInsert);
             stm.setString(1, ""+ stat);
             stm.setString(2, ""+ chassi);
             stm.execute();
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
      }
      public void atualizaKm(int i,Connection conn,Automovel a)
      {
         PreparedStatement stm = null;
         try
         {
         
            String sqlInsert = "UPDATE automovel "+
               "SET kmr = ? " + 
               "where chassi = ?";
               
            i = i + a.getKmRodado();
            stm = conn.prepareStatement(sqlInsert);
            stm.setInt(1, i);
            stm.setString(2, a.getChassi());
            stm.execute();
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
      
         
      }
      public void atualizaPreço(double i,Connection conn,Automovel a)
      {
         PreparedStatement stm = null;
         try
         {
         
         
            String sqlInsert = "UPDATE automovel "+
               "SET preço = ? " + 
               "where chassi = ?";
         
            stm = conn.prepareStatement(sqlInsert);
            stm.setDouble(1, i);
            stm.setString(2, a.getChassi());
            stm.execute();
         
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
      }
   
      public void atualizaCidade(String cida,Connection conn,Automovel a)
      {
         PreparedStatement stm = null;
         try
         {
                 
            String sqlInsert = "UPDATE automovel "+
               "SET cidade = ? " + 
               "where chassi = ?";
            
            stm = conn.prepareStatement(sqlInsert);
            stm.setString(1, cida);
            stm.setString(2, a.getChassi());
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
      public void atualizaEstado(String esta,Connection conn,Automovel a)
      {
         PreparedStatement stm = null;
         try
         {
                 
            String sqlInsert = "UPDATE automovel "+
               "SET estado = ? " + 
               "where chassi = ?";
            
            stm = conn.prepareStatement(sqlInsert);
            stm.setString(1, esta);
            stm.setString(2, a.getChassi());
            stm.executeUpdate();
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
      
      public void atualiza2(String esta,Connection conn,Automovel a)
      {
         PreparedStatement stm = null;
         try
         {
        	String sqlInsert = "UPDATE automovel " + "SET modelo = ? ,placa = ? ,fabricante = ? ,cidade = ? ,estado = ? ,grupo = ? ,acessorio = ? ,kmr = ? ,preço = ? ,agencia = ? " + "where chassi = ?";
             
            stm = conn.prepareStatement(sqlInsert);    
                     
            stm.setString(1,"" + a.getModelo());
            stm.setString(2,"" + a.getPlaca());
            stm.setString(3,"" + a.getFabricante());
            stm.setString(4,"" + a.getCidade());
            stm.setString(5,a.getEstado());
            stm.setString(6,"" + a.getGrupo());
            stm.setString(7,"" + a.getAcessorio());
            stm.setInt(8, a.getKmRodado());
            stm.setDouble(9, a.getPreço());
            stm.setString(10,"" + a.getAgencia());
            stm.setString(11, a.getChassi());
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
      public String[][] carregarTodos(Connection conn)
      {
         String sqlSelect = "SELECT * FROM automovel order by fabricante";
         PreparedStatement stm = null;
         int i = 0;
         int j = 0; 
         String vet[][] = null;
      
         ResultSet rs = null;
         try
         {
            stm = conn.prepareStatement(sqlSelect);
            rs = stm.executeQuery();
            int rowcount = 0;
            if (rs.last()) {
               rowcount = rs.getRow();
               rs.beforeFirst(); 
            }
         
            vet = new String[rowcount][3];
            while(rs.next())
            {
               vet[i][j++] = rs.getString(2);
               vet[i][j++] = rs.getString(1);
               vet[i][j++]	= rs.getString(5) +"   /   "+ rs.getString(6);			
               i++;
               j = 0;
                     
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
      //	JOptionPane.showMessageDialog(null,vet.toString());	
         return vet;
      }
      
      public String[][] carregarTodos(Connection conn, char grup)
      {
         String sqlSelect = "SELECT * FROM automovel where grupo = ? and estado = ?";
         PreparedStatement stm = null;
         int i = 0;
         int j = 0; 
         String vet[][] = null;
      
         ResultSet rs = null;
         try
         {
            stm = conn.prepareStatement(sqlSelect);
            stm.setString(1,"" + grup);
            stm.setString(2,"Disponivel");
            rs = stm.executeQuery();
            int rowcount = 0;
            if (rs.last()) {
               rowcount = rs.getRow();
               rs.beforeFirst(); 
            }
         
            vet = new String[rowcount][2];
            while(rs.next())
            {
               vet[i][j++] = rs.getString(2);
               vet[i++][j++] = rs.getString(4);
                              
               j = 0;
                     
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
      //	JOptionPane.showMessageDialog(null,vet.toString());	
         return vet;
      }
	public ArrayList<Automovel> carregarTodos2(Connection conn, String agencia) {
		
		String sqlSelect = "SELECT * FROM automovel where agencia = ? and stats = ?";
        PreparedStatement stm = null;
             
        ResultSet rs = null;
        
        ArrayList<Automovel> aTO = new ArrayList<Automovel>();
        Automovel to;
        try
        {
           stm = conn.prepareStatement(sqlSelect);
           stm.setString(1,agencia);
           stm.setString(2,"Disponivel");
           rs = stm.executeQuery();
           
           
           while(rs.next())
           {
        	  to = new Automovel(); 
              to.setChassi(rs.getString(1));
              to.setModelo(rs.getString(2));
              to.setPlaca(rs.getString(3));
              to.setFabricante(rs.getString(4));
              to.setCidade(rs.getString(5));
              to.setEstado(rs.getString(6));
              to.setGrupo(rs.getString(7).charAt(0));
              to.setAcessorio(rs.getString(8));
              to.setKmRodado(rs.getInt(9));
              to.setPreço(rs.getDouble(10));
              to.setAgencia(rs.getString(11));
              to.setStats(rs.getString(12));
                           
              aTO.add(to);
              to = null;      
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
        
        return aTO;
		
	}
	
public ArrayList<Automovel> carregarTodos2(Connection conn, String agencia, String fabricante) {
		
		String sqlSelect = "SELECT * FROM automovel where agencia = ? and stats = ? and fabricante = ?";
        PreparedStatement stm = null;
             
        ResultSet rs = null;
        
        ArrayList<Automovel> aTO = new ArrayList<Automovel>();
        Automovel to;
        try
        {
           stm = conn.prepareStatement(sqlSelect);
           stm.setString(1,agencia);
           stm.setString(2,"Disponivel");
           stm.setString(3,fabricante);
           rs = stm.executeQuery();
           
           
           while(rs.next())
           {
        	  to = new Automovel();
              to.setChassi(rs.getString(1));
              to.setModelo(rs.getString(2));
              to.setPlaca(rs.getString(3));
              to.setFabricante(rs.getString(4));
              to.setCidade(rs.getString(5));
              to.setEstado(rs.getString(6));
              to.setGrupo(rs.getString(7).charAt(0));
              to.setAcessorio(rs.getString(8));
              to.setKmRodado(rs.getInt(9));
              to.setPreço(rs.getDouble(10));
              to.setAgencia(rs.getString(11));
              to.setStats(rs.getString(12));
                           
              aTO.add(to);
              to = null;      
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
        return aTO;
		
	}

public ArrayList<Automovel> carregarTodos2(Connection conn, String agencia, String fabricante, String grupo) {
	
	String sqlSelect = "SELECT * FROM automovel where agencia = ? and stats = ? and fabricante = ? and grupo = ?";
    PreparedStatement stm = null;
         
    ResultSet rs = null;
    
    ArrayList<Automovel> aTO = new ArrayList<Automovel>();
    Automovel to;
    try
    {
       stm = conn.prepareStatement(sqlSelect);
       stm.setString(1,agencia);
       stm.setString(2,"Disponivel");
       stm.setString(3,fabricante);
       stm.setString(4, grupo);
       rs = stm.executeQuery();
       
       
       while(rs.next())
       {
    	  to = new Automovel();
          to.setChassi(rs.getString(1));
          to.setModelo(rs.getString(2));
          to.setPlaca(rs.getString(3));
          to.setFabricante(rs.getString(4));
          to.setCidade(rs.getString(5));
          to.setEstado(rs.getString(6));
          to.setGrupo(rs.getString(7).charAt(0));
          to.setAcessorio(rs.getString(8));
          to.setKmRodado(rs.getInt(9));
          to.setPreço(rs.getDouble(10));
          to.setAgencia(rs.getString(11));
          to.setStats(rs.getString(12));
                       
          aTO.add(to);
          to = null;      
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
    return aTO;
	
}

public ArrayList<Automovel> carregarTodos3(Connection conn, String agencia, String grupo) {
	
	String sqlSelect = "SELECT * FROM automovel where agencia = ? and stats = ? and grupo = ?";
    PreparedStatement stm = null;
         
    ResultSet rs = null;
    
    ArrayList<Automovel> aTO = new ArrayList<Automovel>();
    Automovel to;
    try
    {
       stm = conn.prepareStatement(sqlSelect);
       stm.setString(1,"" + agencia);
       stm.setString(2,"Disponivel");
       stm.setString(3, grupo);
       rs = stm.executeQuery();
       
       
       while(rs.next())
       {
    	  to = new Automovel();
          to.setChassi(rs.getString(1));
          to.setModelo(rs.getString(2));
          to.setPlaca(rs.getString(3));
          to.setFabricante(rs.getString(4));
          to.setCidade(rs.getString(5));
          to.setEstado(rs.getString(6));
          to.setGrupo(rs.getString(7).charAt(0));
          to.setAcessorio(rs.getString(8));
          to.setKmRodado(rs.getInt(9));
          to.setPreço(rs.getDouble(10));
          to.setAgencia(rs.getString(11));
          to.setStats(rs.getString(12));
                       
          aTO.add(to);
          to = null;      
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
    return aTO;
	
}
public void atualizaAgencia(String z, Connection conn2, String chassi) {
	PreparedStatement stm = null;
    try
    {
            
       String sqlInsert = "UPDATE automovel "+
          "SET agencia = ? " + 
          "where chassi = ?";
       
       stm = conn.prepareStatement(sqlInsert);
       stm.setString(1, z);
       stm.setString(2, chassi);
       stm.executeUpdate();
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

  
   
   
   }
