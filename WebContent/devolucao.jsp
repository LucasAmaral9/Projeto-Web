<%@ page import="java.util.*, java.text.*,  model.* "%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="./css/main.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Devolução</title>
<script>
function ok(){
	alert("Devolução Realizada com Sucesso");
}

function msg(){
	alert("Número de Locação Não Encontrado!");
}

</script>
</head>
<body>
<h1 style="text-align:center">Devolução</h1>
<% ////////////////////////////
	//MENSAGEM CLIENTE NAO ENCONTRADO
	////////////////////////////
	int c = 0;
	
	try{
		c =  (Integer) session.getAttribute("deverro");
	}
	catch(Exception e){
		c = 0;
	}
	 
	
		if(c > 0){
			c = 0;
			session.setAttribute("deverro",0); %> 
			<script type="text/javascript"> msg(); </script>
		<% 
		}
%>
	
	<% ////////////////////////////
	//MENSAGEM DEVOLVIDO COM SUCESSO
	//////////////////////////// D Factory Model / Devol /
	
	int w = 0;
	
	try{
		w = (Integer) session.getAttribute("devolucaoconfirm");
	}
	catch(Exception e){}
		
	if(w > 0){
		w = 0;
		session.removeAttribute("devolucaoconfirm"); %>
		<script type="text/javascript"> ok(); </script>
		<%
	}
%>


	<%//-------------- INSERT DEVO Num
	Locacao lTO = null;
    try{
    	lTO = (Locacao) session.getAttribute("devolucaoinfo");
    	if(lTO == null){
    		
    %>	
    <form method="post" action="DevolucaoController" align="Left" style="width: 442px; ">
    <fieldset align="" style="width: 414px; height: 119px"> 
    <legend align="left"><b>Devolução</b></legend>
	
    	<div style="text-align:right;">
			Codigo Locação:<input type="text" name="tCodigo" size="25" pattern="\d{1,9}" title="Apenas Números" required style="overflow: auto; white-space: normal; position: relative; text-align: left; margin-right: 5px"/>
		</div>
		<input type="submit" value="Buscar">
	</fieldset>
	</form>
    <%  }
    	else{//-----------------EXIBIR INFO Devolucao
    		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");	
    	%>
    	<form method="post" action="DevolucaoController" onsubmit="" align="center">
    	<fieldset align="center"> 
    	<legend align="left"><b>Devolucao</b></legend>
    	<div style="text-align:left">
    			Codigo Locação: <input type="text" name="tCodigo" value="<%out.println(lTO.getID());%>" size="26" disabled/>
    			<br>
    			Chassi:<input type="text" name="tChassi" value="<%out.println(lTO.getChassi());%>" size="26" disabled/>
    			<br>
				CPF:<input type="text" name="tCPF" value="<%out.println(lTO.getCPF());%>" size="26" disabled/>
				<br>
				Data Devolução: <input type="text" name="tDataDevolucao" value="<%out.println("" + format.format(lTO.getDataDevolucao()));%>" size="26" disabled/>
				<br>
				Agência Devolução: <input type="text" name="tAgenciaDevolucao" value="<%out.println(lTO.getLocalDevolucao());%>" size="26" disabled/>
				<br>
				<!-- Multa: <input type="text" name="tMulta" value="" size="26" disabled/> -->
				
				<input type="text" style="opacity:0.0" name="tID" value="<%out.println(lTO.getID());%>" size="26"/>
				<br>
				<label>Agência Devolução:</label><select name="tAgenciaDevolucao" size="1" required >
					<option value=""></option>
					<option value="São Paulo">São Paulo</option>
					<option value="Rio de Janeiro">Rio de Janeiro</option>
				</select>
				<br>
		</div>
		<input type="submit" name="devo" value="Enviar"><br>
		<input type="submit" value="Limpar" method="post" formaction="DevolucaoLimparController" formnovalidate>
		
	</fieldset>
	</form>
    	
    <%
    	}
    }
    catch(Exception e){}
    %>
</body>
</html>