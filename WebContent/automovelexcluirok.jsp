<%@ page import="java.util.*, java.text.*, model.* "%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="./css/main.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Excluir Automóvel</title>
</head>
<script>

function msg(){
	alert("Veículo Excluido com Sucesso!");
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
<h1 style="text-align:center">Excluir Veículo</h1>

<%

Automovel aTO = (Automovel) session.getAttribute("aTO");
session.setAttribute("aTO",aTO);
if(aTO != null){
	
	out.println("<form method=\"post\" name=\"Vexcluir\" action=\"ExcluirAutomovelController\" onsubmit=\"msg()\" style=\"width: 479px;\">" +
    "<fieldset style=\"width: 457px;\">" + 
    "<legend align=\"left\"><b>Excluir Veículo</b></legend><table style=\"width: 432px\">" +
     "<tr><td>Chassi</td>" +
        "<td><input type=\"text\" value=\"" + aTO.getChassi() + "\" size=\"30\" readonly /></td>" +
      "</tr><tr> <td>Modelo</td> <td><input type=\"text\" value=\"" + aTO.getModelo() + "\" size=\"30\" readonly /></td>"+
      "</tr><tr><td>Placa</td> <td><input type=\"text\" value=\""+aTO.getPlaca()+"\" size=\"30\" readonly /></td> </tr><tr>"+
        "<td>Fabricante</td><td><input type=\"text\" value=\""+aTO.getFabricante()+"\" size=\"30\" readonly /></td></tr><tr>"+
       " <td>Cidade</td><td><input type=\"text\" value=\"" + aTO.getCidade() + "\" size=\"30\" readonly /></td> </tr> <tr>"+
        "<td>Estado</td>  <td><input type=\"text\" value=\""+ aTO.getEstado() +"\"  size=\"30\" readonly /></td>"+
      "</tr><tr><td>Grupo</td><td><input type=\"text\" value=\""+aTO.getGrupo()+"\"  size=\"30\" readonly/></td></tr><tr>"+
      "<td>Acessório</td><td><input type=\"text\" value=\""+aTO.getAcessorio()+"\" size=\"30\" readonly /></td></tr><tr><td>Km Rodado</td>"+
       "<td><input type=\"text\" value=\""+aTO.getKmRodado()+"\" size=\"30\" readonly /></td></tr>+<tr><td>Preço</td>"+
       "<td><input type=\"text\" value=\""+aTO.getPreço()+"\" size=\"30\" readonly/></td> </tr>"+
    	 "<tr><td>Agência</td><td><input type=\"text\" value=\""+aTO.getAgencia()+"\" size=\"30\" readonly/></td> </tr>"+
    "</table> </fieldset> <div>"+
    "<input type=\"submit\" value=\"Excluir\" style=\"background-color:#4CA4C2;margin-left:auto;margin-right:auto;display:block;margin-top:3%;margin-bottom:0%\">"+
    "</div></form>");

}


%>


</body>
</html>