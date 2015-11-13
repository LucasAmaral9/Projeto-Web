<%@ page import="java.util.*, java.text.*, model.* "%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="./css/main.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Consultar Cliente</title>
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
<h1 style="text-align:center">Consultar Cliente</h1>
<%
DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

Cliente cTO = (Cliente) session.getAttribute("cTO");
if(cTO != null){

	out.println("<form method=\"post\" action=\"clienteconsultar.jsp\" style=\"width: 445px; \">" +
    "<fieldset style=\"width: 417px; \">" + 
    "<legend align=\"left\"> <b>Consultar Cliente</b></legend>" +
    "<table style=\"width: 378px\">" +
     " <tr>" +
      "<td>Nome</td>" +
        "<td><input type=\"text\" value=\"" + cTO.getNome() + "\" size=\"30\" readonly /></td>"+
      "</tr> <tr> <td>CPF</td> <td><input type=\"text\" value=" + cTO.getCPF() + " size=\"30\" readonly /></td>"+
      "</tr> <tr><td>RG</td> <td><input type=\"text\" value="+cTO.getRG()+" size=\"30\" readonly /></td> </tr><tr>"+
        "<td>E-Mail</td><td><input type=\"text\" value="+cTO.getEmail()+" size=\"30\" readonly /></td></tr><tr>"+
       " <td>Telefone</td><td><input type=\"text\" value="+cTO.getTel()+" size=\"30\" readonly /></td> </tr> <tr>"+
        "<td>Data de Nascimento</td>  <td><input type=\"text\" value="+ formatter.format(cTO.getDataNasc()) +"  size=\"30\" readonly /></td>"+
      "</tr><tr><td>Gênero</td><td><input type=\"text\" value="+cTO.getSexo()+"  size=\"30\" readonly/></td></tr><tr>"+
      "<td>Estado</td><td><input type=\"text\" value="+cTO.getEstado()+" size=\"30\" readonly /></td></tr><tr><td>Endereço</td>"+
       "<td><input type=\"text\" value=\""+cTO.getEndereco()+"\" size=\"30\" readonly /></td></tr>+<tr><td>Número</td>"+
       "<td><input type=\"text\" value="+cTO.getNumero()+" size=\"30\" readonly/></td> </tr><tr><td>Número de Habilitação </td>"+
       "<td><input type=\"text\" value="+cTO.getNumHab() +" size=\"30\" readonly /></td></tr><tr><td>Validade da Carteira </td>"+
        "<td><input type=\"text\" value="+ formatter.format(cTO.getValidadeC())+" size=\"30\" readonly /></td></tr></table>"+
    "</fieldset> <div>"+
    "<input type=\"submit\" value=\"Voltar\" style=\"background-color:#4CA4C2;margin-left:auto;margin-right:auto;display:block;margin-top:3%;margin-bottom:0%\">"+
    "</div> </form>");

}

	
%>

</body>
</html>