package model;

import java.io.Serializable;


public class Automovel implements Serializable {

	private String agencia;
	   private String chassi;//17 char
	   private String modelo;
	   private String placa;// abc-1234
	   private String fabricante;//tipo fiat
	   private String cidade;
	   private String estado;//SP
	   private char grupo;// a b c etc
	   private String acessorio;//n�mero do acess�rio
	   private int kmr;//Km Rodado
	   private double pre�o;
	   private String stats;
	   
	   
	   public Automovel(String chassi){setChassi(chassi);}
		
		public Automovel(String modelo,String chassi){
			setChassi(chassi);
			setModelo(modelo);
		}
	 
	   public Automovel(String chassi,String modelo,String placa,String fabricante,String cidade,String estado,char grupo,String acessorio,int kmr,double pre�o)
	   {
	      setChassi(chassi);
	      setModelo(modelo);
	      setPlaca(placa);
	      setFabricante(fabricante);
	      setCidade(cidade);
	      setEstado(estado);
	      setGrupo(grupo);
	      setAcessorio(acessorio);
	      setKmRodado(kmr);
	      setPre�o(pre�o);
	   }
	   public Automovel() {
		// TODO Auto-generated constructor stub
	}

	//setters-------------------------------------------------------------------
	   public void setChassi(String chassi){this.chassi = chassi;}
	   public void setModelo(String modelo){this.modelo = modelo;}
	   public void setPlaca(String placa){this.placa = placa;}
	   public void setFabricante(String fabricante){this.fabricante = fabricante;}
	   public void setCidade(String cidade){this.cidade = cidade;}
	   public void setEstado(String estado){this.estado = estado;}
	   public void setGrupo(char grupo){this.grupo = grupo;}
	   public void setAcessorio(String acessorio){this.acessorio = acessorio;}
	   public void setKmRodado(int kmr){this.kmr = kmr;}
	   public void setPre�o(double pre�o){this.pre�o = pre�o;}
	   public void setAgencia(String agencia){this.agencia = agencia;}
	   
	   
	   //Getters-----------------------------------------------------------
	   public String getStats(){
		   return stats;
	   }
	   public String getAgencia(){
		   return agencia;
	   }
	   public String getChassi(){
	      return chassi;}
	   public String getModelo(){
	      return modelo;}
	   public String getPlaca(){
	      return placa;}
	   public String getFabricante(){
	      return fabricante;}
	   public String getCidade(){
	      return cidade;}
	   public String getEstado(){
	      return estado;}
	   public char getGrupo(){
	      return grupo;}
	   public String getAcessorio(){
	      return acessorio;}
	   public int getKmRodado(){
	      return kmr;}
	   public double getPre�o(){
	      return pre�o;}

	public void setStats(String string) {
		this.stats = string;
		
	}
	 
}
