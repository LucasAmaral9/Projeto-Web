package model;


import java.io.Serializable;
import java.util.Date;

import dao.ClienteDAO;


public class Cliente implements Serializable {
	
	
	
	private String CPF,nome, telefone, email, estado, endereco;
    private String RG;
	  private int numero, numeroHab,id;
    private char sexo;
    private Date validadeC,dataNasc;
 
    public Cliente(){
    
    this("","","","",null,'0',"",null,"","",0,0);
    
    }
 
    public Cliente (String nome,String cpf,String telefone,String email,Date dataNas,char sexo,String rg,Date validadeCarteira, String estado, String end, int num, int numHab){
    
       setNome(nome);
       setCPF(cpf);
       setTel(telefone);
       setEmail(email);
       setDataNasc(dataNas);
       setSexo(sexo);
       setRG(rg);
       setValidadeC(validadeCarteira);
       setEstado(estado);
       setEndereco(end);
       setNumero(num);
       setNumHab(numHab);
    }
 
    public void setID(int i){
       id = i;
    }
    public void setNome(String n){
    
       nome = n;
    }
 
    public void setCPF(String cpf2){
    
       CPF = cpf2;
    }
 
    public void setTel(String t){
    
       telefone = t;
    }
 
    public void setEmail(String m){
    
       email = m;
    }
 
    public void setDataNasc(Date data){
    
       dataNasc = data;
    }
 
    public void setSexo(char s){
    
       sexo = s;
    }
 
    public void setRG(String string){
    
       RG = string;
    }
 
    public void setValidadeC(Date v){
    
       validadeC = v;
    }
 
    public void setEndereco(String end){
    
       endereco = end;
    }
 
    public void setEstado(String est){
    
       estado = est;
    }
 
    public void setNumero(int n){
    
       numero = n;
    }
 
    public void setNumHab(int n){
    
       numeroHab = n;
    }
    
    public int getID(){
       return id;  }
 
    public String getNome(){
       return nome;}
 
    public String getCPF(){ 
       return CPF; }
 
    public String getTel(){ 
       return telefone; }
 
    public String getEmail(){ 
       return email; }
 
    public Date getDataNasc(){ 
       return dataNasc; }
 
    public char getSexo(){ 
       return sexo; }
 
    public String getRG(){ 
       return RG; }
 
    public Date getValidadeC(){ 
       return validadeC; }
 
    public String getEndereco(){ 
       return endereco; }
 
    public String getEstado(){ 
       return estado; }
 
    public int getNumero(){ 
       return numero; }
 
    public int getNumHab(){ 
       return numeroHab; }
  
    public String toString(){
       String text = "";
    
       text = "                Cliente     \n" + 
       "\nNome: " + getNome() + 
       "\nCPF: " + getCPF() + 
       "\nTelefone: " + getTel() + 
       "\nEmail: " + getEmail() + 
       "\nSexo: " + getSexo() + 
       "\nRG: " + getRG();
       
       return text;
    }

	
}
