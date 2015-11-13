package model;


import java.io.Serializable;
import java.util.Date;

public class Locacao implements Serializable {
	
	 private String clienteCPF,localdevolucao,locallocacao,tipotarifa,formapagamento,chassiVeiculo,agencia;
     private int id,hora,clienteid;
     private double valor;
     private Date datalocacao,datadevolucao;
     
  
     public Locacao(){
     
     this("",0,null,null,"","","");
     
     }
  
     public Locacao (String chassi,int id,Date dataloc,Date datadev,String localdev,String tipotarif,String pagamento ){
     
        setChassi(chassi);
        //setCPF(cpf);
  		 setClienteID(id);      
		 setDataLocacao(dataloc);
        setDataDevolucao(datadev);
        setLocalDevolucao(localdev);
        setTipoTarifa(tipotarif);
        setPagamento(pagamento);
     }
  
     public Locacao(String chassi, int id2, Date parse, Date parse2, String string, String tipoDeTarifa,
			String formaDePagamento, double valor2, String localagencia) {
   	  setChassi(chassi);
         //setCPF(cpf);
   		 setClienteID(id2);      
		 setDataLocacao(parse);
         setDataDevolucao(parse2);
         setLocalDevolucao(string);
         setTipoTarifa(tipoDeTarifa);
         setPagamento(formaDePagamento);
         setValor(valor2);
         setLocalLocacao(localagencia);
	}

	
	public void setID(int d){
        id = d;
     }
     public void setChassi(String n){
     
        chassiVeiculo = n;
     }
		
		public void setClienteID(int id){
			clienteid = id;
  	}
     
     public void setLocalLocacao(String x){
        locallocacao = x;
     }
   
	   public void setCPF(String cpf){
     
        clienteCPF = cpf;
     }
  
     public void setDataLocacao(Date t){
     
        datalocacao = t;
     }
  
     public void setDataDevolucao(Date m){
     
        datadevolucao = m;
     }
  
     public void setLocalDevolucao(String data){
     
        localdevolucao = data;
     }
  
     public void setTipoTarifa(String s){
     
        tipotarifa = s;
     }
  
     public void setPagamento(String r){
     
        formapagamento = r;
     }
     
     public void setValor(double r){
        valor = r;
     }
     
  
     public int getID(){
        return id;
        }   
     public String getChassi(){
        return chassiVeiculo;}
  
		public int getClienteID(){
			return clienteid;}
     public String getCPF(){ 
        return clienteCPF; }
  
     public Date getDataLocacao(){ 
        return datalocacao; }
  
     public Date getDataDevolucao(){ 
        return datadevolucao; }
  
     public String getLocalDevolucao(){ 
        return localdevolucao; }
  
     public String getTipoTarifa(){ 
        return tipotarifa; }
        
     public String getLocalLocacao(){
        return locallocacao;}
        
     public String getPagamento(){ 
        return formapagamento; }
    
     public double getValor(){
        return valor; }
	

}
