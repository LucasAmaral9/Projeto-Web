<%@ page import="java.util.*, java.text.*,model.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="./css/main.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Alterar Veículo</title>
</head>
<script type="text/javascript">
 
function clearThis(target){
	if(target.value == "<- Erro")
		{
    target.value= "";
		}
}
function verificaDados()
{
	var x = verificaChassi() + verificaModelo() + verificaPlaca() + verificaFabricante() + verificaCidade()
	+verificaEstado() + verificaRodado() + verificaPreco(); 
	<% session.removeAttribute("alterar"); %>
	
	if(x != 0)
			{
				return false; 
			}
		else
			{
			<% session.setAttribute("alterar2","1"); %>
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
<body>
<h1 style="text-align:center">Alterar Automóvel</h1>

<%

Automovel aTO = (Automovel) session.getAttribute("aTO");
if(aTO != null){
%>
	<form method="post" action="AlterarAutomovelController" style="width: 479px;">
     <fieldset align="center" style="width: 457px; "> 
     <legend align="left"> <b>Alterar Automóvel</b></legend><table style="width: 432px">
      <tr>
      <td>Chassi</td> 
       <td><input style="" type="text" name="tChassi2" value="<%out.println(aTO.getChassi());%>" size="30" disabled /></td>
      </tr>
       <tr> <td>Modelo</td> <td><input type="text" name="tModelo" value="<%out.println(aTO.getModelo());%>" size="30" required /></td>
      </tr> <tr><td>Placa</td> <td><input type="text" name="tPlaca" value="<%out.println(aTO.getPlaca());%>" size="30" required /></td> </tr><tr>
       <td>Fabricante</td><td><input type="text" name="tFabricante" value="<%out.println(aTO.getFabricante());%>" size="30" required  /></td></tr><tr>
        <td>Cidade</td><td><input type="text" name="tCidade" value="<%out.println(aTO.getCidade());%>" size="30" required  /></td> </tr> <tr>
        <td>Estado</td><td><input type="text" name="tEstado" value="<%out.println(aTO.getEstado());%>"  size="30" required  /></td>
     	
     	<tr>
			<td>Grupo&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>	
		<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<label></label> <select name="tGrupo" size="1" required>
				<option value="<%out.println(aTO.getGrupo());%>" selected><%out.println(aTO.getGrupo());%></option>
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
	
	<tr><td>Acessórios&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>	
		<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<label></label> <select name="tAcessorio" size="1" >
				<option value="<%out.println(aTO.getAcessorio());%>" id="AcessorioZ" selected><%out.println(aTO.getAcessorio());%></option>
				<option value="Carrinho de Bebe" id="AcessorioA" >Carrinho de Bebe</option>
					<option value="GPS" id="AcessorioB">GPS</option>
					<option value="Motorista" id="AcessorioC">Motorista</option>
				</select>
			</td>
	</tr>
	<tr><td>Km Rodado</td><td><input type="text" name="tKmrodado" value="<%out.println(aTO.getKmRodado());%>" size="30" required  /></td></tr>
	
	<tr><td>Preço</td><td><input type="text" name="tPreco" value="<%out.println(aTO.getPreço());%>" size="30" required /></td> </tr>
       
       	<tr><td>Agência&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>	
		<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<label></label> <select name="tAgencia" size="1" required>
				<option value="<%out.println(aTO.getAgencia());%>"><%out.println(aTO.getAgencia());%></option>
				<option value="São Paulo" >São Paulo</option>
				<option value="Rio de Janeiro">Rio de Janeiro</option>
				</select>
			</td>
		</tr>
       </table>
    <div>
    <input type="submit" value="Alterar" onclick="return verificaDados()" style="background-color:#4CA4C2;margin-left:auto;margin-right:auto;display:block;margin-top:3%;margin-bottom:0%">
    </div>
     <input style="opacity:0.0" type="text" name="tChassi" value="<%out.println("" + aTO.getChassi());%>" size="30" /> 
    </fieldset>
    </form>  
        
<%
}
%>
	


</body>
</html>