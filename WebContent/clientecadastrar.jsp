<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cliente</title>
<link rel="stylesheet" href="./css/main.css" />
</head>
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
	var x = verificaTele() + verificaMail() + verificaCPF() + verificaRG()
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
	<h2>Cadastrar Cliente</h2>
	<form method="post" action="CadastrarClienteController" onsubmit="return verificaDados()">
	
		
		<fieldset><legend>Cadastrar Cliente</legend>
			<div>
			Nome <input type="text" name="tNome" id="cNome" size="22" pattern="[A-Za-z\s]{2,}" placeholder = "Ex:Joaquim Machado" onfocus="clearThis(this)"/>
			</div>
			<div>
			CPF <input type="text" name="tCpf" id="cCpf" maxlength="14" size="22" placeholder = "Ex:875.247.021-08" onfocus="clearThis(this)"/>
			</div>
			<div>
			RG <input type="text" name="tRg" id="cRg" size="22" maxlength="12" placeholder = "Ex:41.875.789-6" onfocus="clearThis(this)"/>
			</div>
			<div>
			Email <input type="text" name="tEmail" id="cEmail" size="22" placeholder = "Ex:exemplo@usjt.br" onfocus="clearThis(this)"/>
			</div>
			<div>
			Telefone <input type="text" name="tTel" id="cTel" size="22" placeholder = "Ex:0000-0000" onfocus="clearThis(this)"/>
			</div>
			<div>
			Data<input type="text" name="tData" id="cData" size="22" placeholder = "Ex:12/12/1990" onfocus="clearThis(this)"/>
			</div>
			
			<div>
				<label>Gênero</label> <select name="tGenero" size="1" required>
					<option value=""></option>
					<option value="Masculino" id="cMas" selected>Masculino</option>
					<option value="Feminino" id="cFem" >Feminino</option>
				</select>
			</div>
			<div>
				<label>Estado:</label> <select name="tEstado" size="1" required>
					<option value=""></option>
					<option value="São Paulo" id="cSP" selected>São Paulo</option>
					<option value="Rio de Janeiro" id="cRJ">Rio de Janeiro</option>
				</select>
			</div>
			<div>
			Endereço <input type="text" name="tEndereco" id="cEndereco" size="22" onfocus="clearThis(this)" />
			<br>
			 Nº <input type="text" name="tNumero" id="cNumero" size="5" onfocus="clearThis(this)"/>
			</div>
			<div>
			Número de Habilitação <input type="text" name="tNumHab" id="cNumHab" placeholder = "Ex:586954387" size="22" onfocus="clearThis(this)"/>
			</div>
			<div>
			Validade Carteira <input type="text" name="tValidadeC" id="cValidadeC" size="22" placeholder = "Ex:21/12/2000" onfocus="clearThis(this)"/>
			</div>
			<input type="submit" value="Enviar">
		</fieldset>
		
	</form>
</body>
</html>

