<%@ page import="java.util.*, java.text.*, model.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>


<link rel="stylesheet" href="./css/main.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Locar</title>
</head>


<script type="text/javascript">
function clearThis(target){
	if(target.value == "<- Erro")
		{
    target.value= "";
		}
}

function Pagamento(){
	
	session.setAttribute("pagamento",1)
	return true;
}


function ok(){
	var x = '<%=session.getAttribute("numerolocacao")%>';
	alert("Veiculo Locado com Sucesso!Numero de Locação: " + x);// + session.getAttribute("numerolocacao"));
	
}

function clearCliente(){
	session.invalidate();
	request.getSession().invalidate();
	session.removeAttribute("locarbuscarc")
	
}

function verificaObjeto(){
	
	<%try{
		Automovel veiculo = (Automovel) session.getAttribute("locarbuscarv");
		Cliente cTO = (Cliente) session.getAttribute("locarbuscarc");
		if(cTO == null || veiculo == null){%>
			return false;
		<%}
		session.setAttribute("pagamento",1);
	%>return true;
	<%
	}
	catch(Exception e){%>
		return false;
	<%}
	%>
}

function verificaCPF()
{
		var cpf = document.getElementById("cCpf").value;
		if(cpf == ""||cpf.length!=14||isNaN(cpf.charAt(0))||isNaN(cpf.charAt(1))||
			isNaN(cpf.charAt(2))||cpf.charAt(3)!= "." ||isNaN(cpf.charAt(4))||
			isNaN(cpf.charAt(5))||isNaN(cpf.charAt(6))||cpf.charAt(7)!= "."||
			isNaN(cpf.charAt(8))||isNaN(cpf.charAt(9))||isNaN(cpf.charAt(10))||
			cpf.charAt(11)!= "-"||isNaN(cpf.charAt(12))||isNaN(cpf.charAt(13))
			||cpf == "<- Erro")
			{

				document.getElementById("cCpf").value = "<- Erro";
				return false; 
			}
		else
			{
			return true;
			}	
}

</script>

<body>
	<h1 style="text-align:center">Locação</h1>
	
	<% ////////////////////////////
	//MENSAGEM VEICULO LOCADO COM SUCESSO
	////////////////////////////
	
	int w = 0;
	
	try{
		w = (Integer) session.getAttribute("locarconfirm");
		
	}
	catch(Exception e){}
	
	if(w > 0){
		w = 0;
		session.removeAttribute("locarconfirm"); %>
		<script type="text/javascript"> ok(); </script>
		<%
	}
%>
	
      <%
      Automovel veiculo = null;
      Cliente cTO = null;
      	try{ 
      	
      		
      		veiculo = null;
      		try{
      			veiculo = (Automovel) session.getAttribute("locarbuscarv");
      		}
      		catch(Exception e){
      			
      		}
      	

      	
      		if(veiculo != null){
      	//ABAIXO ------------ INFO VEICULO ----------
      %>
      		<form method="post" action="LocarRemoverAutomovelController" align="left">
     		<fieldset align="left" style="width: 360px; "> 
     		<legend align="left"> <b>Veículo</b></legend>
      		 <div style="text-align:right">
				Chassi:<input type="text" name="tChassi2" value="<%out.println("" + veiculo.getChassi());%>" size ="28"  disabled/><br>
				Fabricante:<input type="text" name="tFabricante2" value="<%out.println("" + veiculo.getFabricante());%>" size ="28"  disabled/><br>
				Modelo:<input type="text" name="tModelo2" value="<%out.println("" + veiculo.getModelo());%>" size ="28" align="left" disabled/><br>
				Acessorio:<input type="text" name="tAcessorio2" value="<%out.println("" + veiculo.getAcessorio());%>" size ="28" align="left" disabled/><br>
				Preço:<input type="text" name="tValor2" value="<%out.println("R$" + veiculo.getPreço());%>" size ="28" align="left" disabled/>
			</div>
			<input type="submit" value="Limpar" style="text-align:center;background-color:#4CA4C2;margin-left:auto;margin-right:auto;display:block;margin-top:3%;margin-bottom:0%">
			</div>
		</fieldset>
		</form>
			
      <%//session.removeAttribute("locarbuscav");
      	}
      	else{
      		//session.setAttribute("locarbuscav","buscaveiculo");
       %>
       	<form method="post" action="BuscarListaAutomovelController" align="left">
     	<fieldset align="left" > 
     	<legend align="left"> <b>Veículo</b></legend>
       
      <div style="text-align:right">
				<label align="left">Agência:</label> <select name="tAgencia" size="1" required>
					<option value=""></option>
					<option value="São Paulo">São Paulo</option>
					<option value="Rio de Janeiro">Rio de Janeiro</option>
				</select><br>
				
				<label style="text-align:right; width: 353px" >Fabricante:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;<select name="tFabricante" size="1">
					<option value=""></option>
					<option value="Fiat">Fiat</option>
					<option value="Dodge">Dodge</option>
				</select></label> <br>
				
				<label align="left">Grupo:</label> <select name="tGrupo" size="1">
					<option value=""></option>
					<option value="A" id="GrupoA">A - Econômico</option>
					<option value="C" id="GrupoB">C - Econômico com Ar</option>
					<option value="F" id="GrupoC">F - Intermediario</option>
					<option value="G" id="GrupoD">G - Intermediário Wagon</option>
					<option value="H" id="GrupoE">H - Executivo</option>
					<option value="M" id="GrupoF">M - Intermediario Wagon</option>
					<option value="K" id="GrupoG">K - Executivo de Luxo</option>
					<option value="N" id="GrupoH">N - Pick-up</option>
					<option value="P" id="GrupoI">P - 4x4 Especial</option>
					<option value="R" id="GrupoJ">R - Minivan</option>
					<option value="U" id="GrupoL">U - Furgão</option>
					<option value="Y" id="GrupoM">Y - Blindado</option>
				</select>
				<input type="submit" value="Buscar" style="background-color:#4CA4C2;margin-left:auto;margin-right:auto;display:block;margin-top:3%;margin-bottom:0%">
			</div>
	</fieldset>
	</form>
    <%}}
    catch(Exception e){}//TERMINO CATCH%>
    
    
    
    <%//-------------- INSERT CLIENT CPF
    try{
    	cTO = (Cliente) session.getAttribute("locarbuscarc");
    	if(cTO == null){
    		//session.setAttribute("locarbuscac","buscacliente");
    %>	
    <form method="post" action="LocarAutomovelController" onsubmit="verificaCPF()" align="Left">
    <fieldset align="Left"> 
    <legend align="left"><b>Cliente</b></legend>
	
    	<div>
				CPF:<input type="text" name="tCPF" size="26" maxlength="14" pattern="\d{3}\.\d{3}\.\d{3}-\d{2}" title="875.247.021-08" placeholder ="Ex:875.247.021-08" onfocus="clearThis(this)" required/>
				<input type="submit" value="Buscar" style="background-color:#4CA4C2;margin-left:auto;margin-right:auto;display:block;margin-top:3%;margin-bottom:0%">
			</div>
	</fieldset>
	</form>
    <%  }
    	else{//-----------------EXIBIR INFO CLIENTE
    		//session.removeAttribute("locarbuscac");
    	%>
    	<form method="post" action="LimparDadosController" onsubmit="clearCliente()" align="Left">
    	<fieldset align="Left"> 
    	<legend align="left"><b>Cliente</b></legend>
    	<div>
    			Nome:<input type="text" name="tNome" value="<%out.println("" + cTO.getNome());%>" size="26" disabled/>
    			<br>
				CPF:&nbsp;&nbsp;&nbsp;<input type="text" name="tCPF" value="<%out.println("" + cTO.getCPF());%>" size="26" disabled/><br>
				
				<input type="submit" name="tLimparcliente" value="Limpar" style="text-align:center;background-color:#4CA4C2;margin-left:auto;margin-right:auto;display:block;margin-top:3%;margin-bottom:0%">
				
		</div>
	</fieldset>
	</form>
    	
    <%
    	}
    }//Fecha try
    catch(Exception e){}
    %>
    
    
    <%/**---------------------------------------
    ------------INFORMAÇÂO LOCAÇÂO----------------
    --------------------------------------------*/
    %>
    <%
    try{
			cTO = (Cliente) session.getAttribute("locarbuscarc");
		}
    catch(Exception e){}
      		try{
      			veiculo = (Automovel) session.getAttribute("locarbuscarv");
      		}
      		catch(Exception e){}%>
    <form method="post" action="LocarAutomovelController" onSubmit="verificaObjeto()" style="width: 418px; ">
    <fieldset align="left" style="width: 378px;text-align:left;float:center"> 
    <legend> <b>Informações</b>
    </legend>
    	<input type="text" style="opacity:0.0" size="1" name="tValor" value="<%try{out.println(veiculo.getPreço());}catch(Exception e){}%>" required/>
    <div>
    	<label>Pais:</label><input  type="text" name="tPais" pattern="[A-Za-z]{4,}" title="Apenas Letras" placeholder="" size="26" required/>
    
    	<label>Estado:</label><input  type="text" name="tEstado" pattern="[A-Za-z]{2,}" title="Apenas Letras" placeholder="" size="26" required/>
    	
    	<label>Cidade:</label><input  type="text" name="tCidade" pattern="[A-Za-z]{2,}" title="Apenas Letras" placeholder="" size="26" required/>
    </div>
    <div>
    	<label>Data Atual:</label><input type="date" name="tDataAtual" pattern="\d{2}/\d{2}/\d{4}" placeholder="11/11/2011" size="26" required/>
    	
    	<label>Data de Devolução:</label><input type="date" name="tDataDevolucao" pattern="\d{2}/\d{2}/\d{4}" placeholder="11/11/2011" size="26" required/>
    </div>
    <div>
    
    	<label>Agência Devolução:</label><select name="tAgenciaDevolucao" size="1" required >
					<option value=""></option>
					<option value="São Paulo">São Paulo</option>
					<option value="Rio de Janeiro">Rio de Janeiro</option>
		</select>
    </div>
    <div>
       	<label>Tarifa:</label><select name="tTarifa" size="1" required>
					<option value=""></option>
					<option value="Controlado">Controlado</option>
					<option value="Livre">Livre</option>
		</select>
    </div>
    <br>
    <div style="">Credito<input type="radio" name="tRadio" id="credito" value="credito" checked="checked"><br> 
    Débito<input type="radio" name="tRadio" id="debito" value="debito"></div>
    
    <input type="text" style="opacity:0.0" name="tChassiLocar" size="1" value="<%try{out.println(veiculo.getChassi());}catch(Exception e){}%>">
    <input type="text" style="opacity:0.0" name="tCPF" value="<%try{out.println(cTO.getCPF());}catch(Exception e){out.println("");}%>" required/>
    <input type="submit" value="Locar" style="text-align:center;background-color:#4CA4C2;margin-left:auto;margin-right:auto;display:block;margin-top:3%;margin-bottom:0%">
    <!--<button class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModalCredito"  value="Locar" > -->
    </fieldset>
    </form>
 &nbsp;


</script>
</body>
</html>