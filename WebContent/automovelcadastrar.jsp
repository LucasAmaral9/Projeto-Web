<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="./css/main.css" />
<title>Automovel Cadastrar</title>
</head>
<script type="text/javascript">
 
function clearThis(target){
	if(target.value == "<- Erro")
		{
    target.value= "";
		}
}

function ok(){
	alert("Veículo Cadastrado com Sucesso!");
}


function verificaDados()
{
	var x = verificaChassi() + verificaModelo() + verificaPlaca() + verificaFabricante() + verificaCidade()
	+verificaEstado() + verificaRodado(); 
	
	if(x != 0)
			{
				return false; 
			}
		else
			{
			return true;
			}
}
function verificaChassi()
{
	var cha = document.getElementById("cChassi").value;
		if(isNaN(cha.charAt(0))||!isNaN(cha.charAt(1))||!isNaN(cha.charAt(2))
			||!isNaN(cha.charAt(3))||!isNaN(cha.charAt(4))||isNaN(cha.charAt(5))
			||isNaN(cha.charAt(6))||!isNaN(cha.charAt(7))||!isNaN(cha.charAt(8))
		||!isNaN(cha.charAt(9))||isNaN(cha.charAt(10))||isNaN(cha.charAt(11))
    	||isNaN(cha.charAt(12))||isNaN(cha.charAt(13))||isNaN(cha.charAt(14))
        ||isNaN(cha.charAt(15))||isNaN(cha.charAt(16))||cha.length!=17 || cha == "" || cha== "<- Erro")
			{
		document.getElementById("cChassi").value = "<- Erro";
		return 1;
		}
	else
		{
			return 0;
     	}    	
}
function verificaModelo()
{
	var modelo = document.getElementById("cModelo").value;
	var mle = modelo.length; 
	if(modelo == "" || modelo == "<- Erro" || mle < 3)
		{
		document.getElementById("cModelo").value = "<- Erro";
			return 1;
		}
	else
		{
			return 0;
		}
	}
function verificaPlaca()
{
	var placa = document.getElementById("cPlaca").value;
	var plale = placa.length;
	if(placa == "" || placa == "<- Erro" || plale != 8 || !isNaN(placa.charAt(0)) || !isNaN(placa.charAt(1))
			|| !isNaN(placa.charAt(2)) || placa.charAt(3) != "-" || isNaN(placa.charAt(4))
			|| isNaN(placa.charAt(5)) || isNaN(placa.charAt(6)) || isNaN(placa.charAt(7)))
		{
		document.getElementById("cPlaca").value = "<- Erro";
		return 1;
		}
	else
		{
		return 0;
		}	
	}
	
function verificaFabricante()
{
	var fabri = document.getElementById("cFabricante").value;
	var fabrile = fabri.length; 
	var nume = verNumeral(fabri);
	if(fabri == "" || fabri == "<- Erro" || fabrile < 4  || nume != 0)
		{
		document.getElementById("cFabricante").value = "<- Erro";
			return 1;
		}
	else
		{
			return 0;
		}
}
function verificaCidade()
{
	var cida = document.getElementById("cCidade").value;
	var cidale = cida.length; 
	var nume = verNumeral(cida);
	if(cida == "" || cida == "<- Erro" || cidale < 4  || nume != 0)
		{
		document.getElementById("cCidade").value = "<- Erro";
			return 1;
		}
	else
		{
			return 0;
		}
}
function verificaEstado()
{
	var esta = document.getElementById("cEstado").value;
	var estale = esta.length; 
	var nume = verNumeral(esta);
	if(esta == "" || esta == "<- Erro" || estale != 2  || nume != 0)
		{
		document.getElementById("cEstado").value = "<- Erro";
			return 1;
		}
	else
		{
			return 0;
		}
}
function verificaRodado()
{
	var rodado = document.getElementById("cRodado").value;	
	var x = rodado.length;
	var nume = verChar(rodado);

	if(rodado == ""||x > 9 ||rodado == "<- Erro" || nume == 1)
			{

				document.getElementById("cRodado").value = "<- Erro";
				return 1; 
			}
		else
			{
			return 0;
			}	
}
function verificaPreco()
{
	var preco = document.getElementById("cPreco").value;	
	var x = preco.length;
	
	if(preco == ""||x > 4  ||preco == "<- Erro" || isNaN(preco.charAt(0)) || isNaN(preco.charAt(2))
			|| isNaN(preco.charAt(3)) || preco.charAt(1) != ".")
			{

				document.getElementById("cPreco").value = "<- Erro";
				return 1; 
			}
		else
			{
			return 0;
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
			if(x.charAt(i)==' ')
				{}
			else
				{
				b = 1;
				}
			}					
		}
		}
	return b;
}
function verChar(x)
{
	var y = x.length;
	var b = 0;
	for(var i = 0;i<y;i++)
		{
		if(x != "<- Erro")
			{
		if(isNaN(x.charAt(i)))
			{
				b = 1;
			}					
		}
		}
	return b;
}
</script>

<body>

<% ////////////////////////////
	//MENSAGEM VEÌCULO CADASTRADO
	////////////////////////////
	
	int w = 0;
	
	try{
		w = (Integer) session.getAttribute("veiculocadastrarconfirm");
	}
	catch(Exception e){}
	
	
	if(w > 0){
		w = 0;
		session.removeAttribute("veiculocadastrarconfirm"); %>
		<script type="text/javascript"> ok(); </script>
		<%
	}
%>



<h1 style="text-align:center">Cadastrar Veículo</h1>
<form method="post" action="CadastrarAutomovelController" style="width: 445px; ">
			<fieldset style="width: 417px; ">
			<legend align="left"> <b>Cadastrar Veículo</b></legend>
			<table style="width: 378px">
  <tr>
    <td>Chassi</td>
    <td><input type="text" name="tChassi" id="cChassi" size="30" placeholder = "Ex:9BWCA11JOY4000001" onfocus="clearThis(this)"/></td>
  </tr>
   <tr>
    <td>Modelo</td>
    <td><input type="text" name="tModelo" id="cModelo" size="20" placeholder = "Ex:Fiat Uno" onfocus="clearThis(this)"/></td>
  </tr>
  <tr>
    <td>Placa</td>
    <td><input type="text" name="tPlaca" id="cPlaca" size="20" placeholder = "Ex:ABC-0001" onfocus="clearThis(this)"/></td>
  </tr>
   <tr>
    <td>Fabricante</td>
    <td><input type="text" name="tFabricante" id="cFabricante" size="20" placeholder = "Ex:Fiat" onfocus="clearThis(this)"/></td>
  </tr>
  <tr>
    <td>Cidade</td>
    <td><input type="text" name="tCidade" id="cCidade" size="20" placeholder = "Ex:São Paulo" onfocus="clearThis(this)"/></td>
  </tr>
  <tr>
    <td>Estado</td>
    <td><input type="text" name="tEstado" id="cEstado" size="20" placeholder = "Ex:SP" onfocus="clearThis(this)"/></td>
  </tr>
  <tr>
    <td>KM Rodado</td>
    <td><input type="text" name="tRodado" id="cRodado" size="20" placeholder = "Ex:2000(Max:9)" onfocus="clearThis(this)"/></td>
  </tr>
<tr>    <td>Preço</td>
    <td><input type="text" name="tPreco" id="cPreco" size="20" pattern="\d{1,}.\d{1,2}" title="Apenas Números" placeholder = "Ex:2.00" onfocus="clearThis(this)"/></td>
  </tr>
  <tr>
			<td>Grupo</td>	
		<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<label></label> <select name="tGrupo" size="1" required>
				<option value="" selected></option>
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
					</td>
	</tr>
 <tr>
			<td>Acessórios</td>	
		<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<label></label> <select name="tAcessorio" size="1" >
				<option value="Nenhum" id="AcessorioZ" selected></option>
				<option value="Carrinho de Bebe" id="AcessorioA" >Carrinho de Bebe</option>
					<option value="GPS" id="AcessorioB">GPS</option>
					<option value="Motorista" id="AcessorioC">Motorista</option>
				</select>
			</td>
				</tr>
				
				<tr>
			<td>Agência</td>	
		<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<label></label> <select name="tAgencia" size="1" required>
				<option value=""></option>
				<option value="São Paulo" >São Paulo</option>
				<option value="Rio de Janeiro">Rio de Janeiro</option>
				</select>
			</td>
			</tr>
			
			</table></fieldset>
		<div>
		<input type="submit" value="Enviar" onclick="return verificaDados()"   style="background-color:#4CA4C2;margin-left:30%;margin-right:auto;display:block;margin-top:3%;margin-bottom:0%;float:left">
	    
	</div>
	</form>
</body>
</html>