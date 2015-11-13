<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Consultar Cliente</title>
<link rel="stylesheet" href="./css/main.css" />
</head>
<script>
function clearThis(target){
	if(target.value == "<- Erro")
		{
    target.value= "";
		}
}

function msg(){
	alert("Cliente não Encontrado!");
}

	
function verificaCPF()
{
		var cpf = document.getElementById("cNome").value;
		if(cpf == ""||cpf.length!=14||isNaN(cpf.charAt(0))||isNaN(cpf.charAt(1))||
			isNaN(cpf.charAt(2))||cpf.charAt(3)!= "." ||isNaN(cpf.charAt(4))||
			isNaN(cpf.charAt(5))||isNaN(cpf.charAt(6))||cpf.charAt(7)!= "."||
			isNaN(cpf.charAt(8))||isNaN(cpf.charAt(9))||isNaN(cpf.charAt(10))||
			cpf.charAt(11)!= "-"||isNaN(cpf.charAt(12))||isNaN(cpf.charAt(13))
			||cpf == "<- Erro")
			{

				document.getElementById("cNome").value = "<- Erro";
				return false; 
			}
		else
			{
			<%session.removeAttribute("alterar"); %>
			return true;
			}	
}


function verNumeral(x)
{
	var y = x.length;
	var b = 0;
	for(var i = 0;i<y;i++)
		{
		if(x != "<- Erro")
			{
		if(!isNaN(x.charAt(i)))
			{
				b = 1;
			}					
		}
		}
	return b;
}


</script>


<% ////////////////////////////
	//MENSAGEM CLIENTE NAO ENCONTRADO
	////////////////////////////
	int cTO = 0;
	
	try{
		cTO =  (Integer) session.getAttribute("erro");
	}
	catch(Exception e){
		cTO = 0;
	}
	 
	
		if(cTO > 0){
			cTO = 0;
			session.setAttribute("erro",0); %> 
			<script type="text/javascript"> msg(); </script>
		<% 
		}
%>

<body>

	<h2 style="text-align:center">Consultar Cliente</h2>
	<form method="post" action="ConsultarClienteController" onsubmit="return verificaCPF()">
			
		<fieldset>
		<legend><b>Consultar Cliente</b></legend>
			<div>CPF
			<input type="text" name="tNome" id="cNome" size="21" maxlength="14" onfocus="clearThis(this)" required />
			</div>
			<br>
			<input type="submit" value="Enviar">
			</fieldset>
		</form>
</body>
</html>