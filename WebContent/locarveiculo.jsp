<%@ page import="java.util.*, java.text.*, model.* "%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="./css/main.css" />
<title>Escolher Veículo</title>
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
<body>

<%

ArrayList<Automovel> lista = (ArrayList<Automovel>) session.getAttribute("listaveiculo");
int counter = 0;

for(Automovel aTO : lista){ //if(Automovel autoTO : lista)

	
	out.println("<form method=\"post\" action=\"LocarAdicionarAutomovelController\" style=\"width: 445px; \"> " +
    " <fieldset style=\"width: 417px; \"> " + 
    " <legend align=\"left\"> <b>Automóvel</b></legend> <table style=\"width: 378px\"> " +
     " <tr> " +
      " <td>Chassi</td> " +
        "<td><input type=\"text\" name=\"tChassi\" value=\"" + aTO.getChassi() + "\" size=\"30\" readonly /></td>" +
        "<input style=\"opacity:0.0\" type=\"text\" name=\"tNumVei\" value=\"" + counter++ + "\" size=\"1\" />" +
      "</tr> <tr> <td>Modelo</td> <td><input type=\"text\" name=\"tModelo\" value=\"" + aTO.getModelo() + "\" size=\"30\" readonly /></td>"+
      "</tr> <tr><td>Placa</td> <td><input type=\"text\" name=\"tPlaca\" value=\""+aTO.getPlaca()+"\" size=\"30\" readonly /></td> </tr><tr>"+
        "<td>Fabricante</td><td><input type=\"text\" name=\"tFabricante\" value=\""+aTO.getFabricante()+"\" size=\"30\" readonly /></td></tr><tr>"+
       " <td>Cidade</td><td><input type=\"text\" name=\"tCidade\" value=\"" +aTO.getCidade()+ "\" size=\"30\" readonly /></td> </tr> <tr>"+
        "<td>Estado</td>  <td><input type=\"text\" name=\"tEstado\" value=\""+ aTO.getEstado() +"\"  size=\"30\" readonly /></td>"+
      "</tr><tr><td>Grupo</td><td><input type=\"text\" name=\"tGrupo\" value=\""+aTO.getGrupo()+"\"  size=\"30\" readonly/></td></tr><tr>"+
      "<td>Acessório</td><td><input type=\"text\" name=\"tAcessorio\" value=\""+aTO.getAcessorio()+"\" size=\"30\" readonly /></td></tr><tr><td>Km Rodado</td>"+
       "<td><input type=\"text\" name=\"tKmrodado\" value=\""+aTO.getKmRodado()+"\" size=\"30\" readonly /></td></tr>+<tr><td>Preço</td>"+
       "<td><input type=\"text\" name=\"tPreco\" value=\""+aTO.getPreço()+"\" size=\"30\" readonly/></td> </tr>"+
       "<tr><td>Agência</td><td><input type=\"text\" name=\"tAgencia\" value=\""+aTO.getAgencia()+"\" size=\"30\" readonly/></td> </tr>" + 
    "</table> </fieldset> <div>"+
    "<input type=\"submit\" value=\"Selecionar\" style=\"background-color:#4CA4C2;margin-left:auto;margin-right:auto;display:block;margin-top:3%;margin-bottom:0%\">"+
    "</div> </form>");

}
		

%>
<br>
<FORM><button Type="button" method="post" formaction="locar.jsp" VALUE="Voltar" style="background-color:#4CA4C2;margin-left:auto;margin-right:auto;display:block;margin-top:3%;margin-bottom:0%">Voltar</button></FORM> 
</body>
</html>