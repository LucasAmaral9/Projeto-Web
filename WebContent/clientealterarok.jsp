<%@ page import="java.util.*, java.text.*, model.* "%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="./css/main.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Alterar Cliente</title>
</head>
<style type="text/css">
    .container {
        width: 500px;
        clear: both;
    }
    .container input {
        width: 100%;
        clear: both;
    }
    </style>
    
<script type="text/javascript">

//if (top.location.href == self.location.href)
  // Redirect user to main page, passing current page name:
  //top.location.href = 'principal.jsp?frame=clientecadastrar';
//-->


 
function clearThis(target){
	if(target.value == "<- Erro")
		{
    target.value= "";
		}
}

function verificaDados()
{
	var x = verificaTele() + verificaNome() + verificaMail() + verificaCPF() + verificaRG()
	+verificaValidade() + verificaNumero() + verificaEndereço() + verificaCarteira(); 

	
	if(x != 0)
			{

				return false; 
			}
		else
			{
			return true;
			}
	
	
}
//----------------------------------
function verificaNome()
{
	var nome = document.getElementById("cNome").value;
	var nle = nome.length; 
	var nume = verNumeral(nome);
	if(nome == "" || nome == "<- Erro" || nle < 5  || nume == 1)
		{
		document.getElementById("cNome").value = "<- Erro";
			return 1;
		}
	else
		{
			return 2;
		}
}
//---------------------------------------
function verificaEndereço()
{
	var end = document.getElementById("cEndereco").value;
	var elen = end.length; 
	var nume = verNumeral(end);
	if(end == "" || end == "<- Erro" || elen < 10  || nume == 1)
		{
		document.getElementById("cEndereco").value = "<- Erro";
			return 1;
		}
	else
		{
			return 2;
		}
}
//------------------------------
function verificaCarteira()
{
	var car = document.getElementById("cNumHab").value;	
	var x = car.length;
	var nume = verNumeral(car);

	if(car == ""||x != 9||car == "<- Erro"|| nume == 0)
			{

				document.getElementById("cNumHab").value = "<- Erro";
				return 1; 
			}
		else
			{
			return 2;
			}	
}
//------------------------------
function verificaMail()
{
	var mail = document.getElementById("cEmail").value;
	var mlen = mail.length; 
	var arrob = verMail(mail);

	if(mail == "" || mail == "<- Erro" || mlen < 10 || arrob == 0)
		{
		document.getElementById("cEmail").value = "<- Erro";
			return 1;
		}
	else
		{
			return 2;
		}
}
//--------------------------------
function  verificaTele()
{
	var tel = document.getElementById("cTel").value;

	if(tel == ""||tel.length!=9||isNaN(tel.charAt(0))||isNaN(tel.charAt(1))||
		isNaN(tel.charAt(2))||isNaN(tel.charAt(3))||tel.charAt(4)!="-"||
		isNaN(tel.charAt(5))||isNaN(tel.charAt(6))||isNaN(tel.charAt(7))||
		isNaN(tel.charAt(8))||tel == "<- Erro")
		{

			document.getElementById("cTel").value = "<- Erro";
			return 1; 
		}
	else
		{
		return 2;
		}
}
//------------------------
function verificaNumero()
{
	var nu = document.getElementById("cNumero").value;	
	var x = nu.length;
	if(nu == ""||x > 5||isNaN(nu.charAt(0))||isNaN(nu.charAt(1))||
			isNaN(nu.charAt(2))||isNaN(nu.charAt(4))||
			isNaN(nu.charAt(5))||nu == "<- Erro")
			{

				document.getElementById("cNumero").value = "<- Erro";
				return 1; 
			}
		else
			{
			return 2;
			}	
}
//------------------------------------
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
				return 1; 
			}
		else
			{
			return 2;
			}	
}
//---------------------
function verificaValidade()
{
		var data = document.getElementById("cValidadeC").value;
		if(data == ""||data.length!=10||isNaN(data.charAt(0))||isNaN(data.charAt(1))||
			data.charAt(2)!= "/" ||isNaN(data.charAt(3))||
			isNaN(data.charAt(4))||data.charAt(5)!= "/"||
			isNaN(cpf.charAt(6))||isNaN(cpf.charAt(7))||isNaN(cpf.charAt(8))||
			isNaN(cpf.charAt(9))||data == "<- Erro")
			{

				document.getElementById("cValidadeC").value = "<- Erro";
				return 1; 
			}
		else
			{
			return 2;
			}	
}
//---------------------
function verificaRG()
{
		var rg = document.getElementById("cRg").value;
		if(rg == ""||rg.length!=12||isNaN(rg.charAt(0))||isNaN(rg.charAt(1))||
				rg.charAt(2)!= "." ||isNaN(rg.charAt(3))||
			isNaN(rg.charAt(4))||isNaN(rg.charAt(5))||rg.charAt(6)!= "."||
			isNaN(rg.charAt(7))||isNaN(rg.charAt(8))||isNaN(rg.charAt(9))||
			rg.charAt(10)!= "-"||isNaN(rg.charAt(11))||rg == "<- Erro")
			{

				document.getElementById("cRg").value = "<- Erro";
				return 1; 
			}
		else
			{
			return 2;
			}	
}
//--------------
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
//-----------------------------
function verMail(x)
{
	var y = x.length;
	var b = 0;
	for(var i = 0;i<y;i++)
		{
		if(x != "<- Erro")
			{
		if(x.charAt(i) == "@")//pra procurar arroba
			{
				b = 1;
			}					
		}
		}
	return b;
}


</script>
<body>
<h1 style="text-align:center">Alterar Cliente</h1>
<%
DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

Cliente cTO = (Cliente) session.getAttribute("cTO");
if(cTO != null){

	out.println("<form method=\"post\" action=\"AlterarClienteController\" onsubmit=\"return verificaDados()\" style=\"width: 479px;\">" +
    "<fieldset style=\"width: 457px; \">" + 
    "<legend align=\"center\"> <b>Alterar Cliente</b></legend>" +
    "<table style=\"width: 432px\">" +
     " <tr>" +
      "<td>Nome</td>" +
        "<td><input type=\"text\" name=\"tNome\" value=\"" + cTO.getNome() + "\" size=\"30\" required /></td>"+
      "</tr> <tr> <td>CPF</td> <td><input type=\"text\" name=\"tCpf\" value=\"" + cTO.getCPF() + "\" size=\"30\" readonly /></td>"+
      "</tr> <tr><td>RG</td> <td><input type=\"text\" name=\"tRg\" value="+cTO.getRG()+" size=\"30\" required /></td> </tr><tr>"+
        "<td>E-Mail</td><td><input type=\"text\" name=\"tEmail\" value="+cTO.getEmail()+" size=\"30\" required /></td></tr><tr>"+
       " <td>Telefone</td><td><input type=\"text\" name=\"tTel\" value="+cTO.getTel()+" size=\"30\" required /></td> </tr> <tr>"+
        "<td>Data de Nascimento</td>  <td><input type=\"text\" name=\"tData\" value="+ formatter.format(cTO.getDataNasc()) +"  size=\"30\" required /></td>"+
      "</tr><tr><td>Gênero</td><td><input type=\"text\" name=\"tGenero\" value="+cTO.getSexo()+"  size=\"30\" required/></td></tr><tr>"+
      "<td>Estado</td><td><input type=\"text\" name=\"tEstado\" value="+cTO.getEstado()+" size=\"30\" required /></td></tr><tr><td>Endereço</td>"+
       "<td><input type=\"text\" name=\"tEndereco\" value=\""+cTO.getEndereco()+"\" size=\"30\" required /></td></tr>+<tr><td>Número</td>"+
       "<td><input type=\"text\" name=\"tNumero\" value="+cTO.getNumero()+" size=\"30\" required/></td> </tr><tr><td>Número de Habilitação </td>"+
       "<td><input type=\"text\" name=\"tNumHab\" value="+cTO.getNumHab() +" size=\"30\" required /></td></tr><tr><td>Validade da Carteira </td>"+
        "<td><input type=\"text\" name=\"tValidadeC\" value="+ formatter.format(cTO.getValidadeC())+" size=\"30\" required /></td></tr></table>"+
    "</fieldset> <div>"+
    "<input type=\"submit\" value=\"Alterar\" style=\"background-color:#4CA4C2;margin-left:auto;margin-right:auto;display:block;margin-top:3%;margin-bottom:0%\">"+
    "</div> </form>");

}

	
%>

</body>
</html>