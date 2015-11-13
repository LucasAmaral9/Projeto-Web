<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="./css/main.css" />
<title>Automovel Alterar</title>
</head>
<script language="JavaScript" type="text/JavaScript">

function msg(){
	alert("Veículo não Encontrado!");
}

function ok(){
	alert("Veículo Alterado com Sucesso!");
}

function verificaChassi()
{

	
	var cha = document.getElementById("cChassi").value;
	if(isNaN(cha.charAt(0))||!isNaN(cha.charAt(1))||!isNaN(cha.charAt(2))
			||!isNaN(cha.charAt(3))||!isNaN(cha.charAt(4))||isNaN(cha.charAt(5))
			||isNaN(cha.charAt(6))||!isNaN(cha.charAt(7))||!isNaN(cha.charAt(8))
		||!isNaN(cha.charAt(9))||isNaN(cha.charAt(10))||isNaN(cha.charAt(11))
    	||isNaN(cha.charAt(12))||isNaN(cha.charAt(13))||isNaN(cha.charAt(14))
        ||isNaN(cha.charAt(15))||isNaN(cha.charAt(16))||cha.length!=17)
			{
		//document.getElementById("cChassi").value = "Chassi Inválido";
		var td1 = document.getElementById("td1");
		var text = document.createTextNode("Chassi Invalido");
		td1.textContent= "";
		td1.appendChild(text);
		document.getElementById("cChassi").value = "";
		return false;
		}
	else
		{
			<% session.setAttribute("alterar","1"); 
			session.removeAttribute("excluir");
			%>
			return true;
     	}    	
	
}

</script>

<h1 style="text-align:center">Alterar Veículo</h1>
<body>

<% ////////////////////////////
	//MENSAGEM VEÌCULO NAO ENCONTRADO
	////////////////////////////
	int aTO = 0;
	int w = 0;
	
	try{
		w = (Integer) session.getAttribute("alterarconfirm");
	}
	catch(Exception e){}
	try{
		aTO =  (Integer) session.getAttribute("erro");
	}
	catch(Exception e){
		aTO = 0;
	}
	if(aTO > 0){
		aTO = 0;
		session.setAttribute("erro",0); %> 
		<script type="text/javascript"> msg(); </script>
		<% 
	}
	if(w > 0){
		w = 0;
		session.removeAttribute("alterarconfirm"); %>
		<script type="text/javascript"> ok(); </script>
		<%
	}
%>

<form name ="Consultar" id="Consultar" action="buscara.do" method="post" onsubmit="return verificaChassi()">
<fieldset>
<legend><b>Alterar Veículo</b></legend>


Chassi
<input type="text" name="tChassi" id="cChassi" size="25" maxlength="18" placeholder="Ex:9BWCA11JOY4000001"/> 
<br>
<input type="submit" value="Enviar" />

</fieldset>
</form> 


</body>
</html>