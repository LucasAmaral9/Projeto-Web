package model;

import java.io.Serializable;

public class Login implements Serializable {

	private String usuario;
	   private String senha;
	   private int permis;

	   public Login(){
	   
	      this("","",0);
	   }
	   
	   public Login(String usuario,String senha,int permi){
	   
	      addUsuario(usuario);
	      addSenha(senha);
	      addPermi(permi);
	   
	   }
	   
	   public void addUsuario(String usu){
	   
	      usuario = usu;
	   
	   }
	   
	   public void addSenha(String sen){
	   
	      senha = sen;
	   }
	   
	   public void addPermi(int perm){
	   
	   
	      permis = perm;
	   }
	   
	   public String getUsuario(){
	    
	      return usuario;
	   }


	   public String getSenha(){
	    
	      return senha;
	   }
	   
	   public int getPermis(){
	    
	      return permis;
	   }
}
