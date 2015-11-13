<%@ page import="java.util.*, java.text.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE HTML>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="cssmenu/styles.css">
<title>Menu Principal</title>
<script>
//------------------------------------
//---------BLOQUEANDO BACKSPACE-------
//------------------------------------
document.onkeydown = function(e) {stopDefaultBackspaceBehaviour(e);}
document.onkeypress = function(e) {stopDefaultBackspaceBehaviour(e);}

function stopDefaultBackspaceBehaviour(event) {
    var event = event || window.event;
    if (event.keyCode == 8) {
        var elements = "HTML, BODY, TABLE, TBODY, TR, TD, DIV";
        var d = event.srcElement || event.target;
        var regex = new RegExp(d.tagName.toUpperCase());
        if (d.contentEditable != 'true') { //it's not REALLY true, checking the boolean value (!== true) always passes, so we can use != 'true' rather than !== true/
            if (regex.test(elements)) {
                event.preventDefault ? event.preventDefault() : event.returnValue = false;
            }
        }
    }
}



</script>

<style type="text/css">



body {
	margin: 0;
	padding: 0;
	color: #000;
	background-color: #EFEFEF;
	font-family: Verdana, Arial, Helvetica, sans-serif;
	font-size: 100%;
	line-height: 0px;
}


ul, ol, dl { 
	padding: 0;
	margin: 0;
}
h1, h2, h3, h4, h5, h6, p {
	height: 20px;
	margin: 0;
	padding: 0px;
	font-weight: bold;
}
a img {
	border: none;
}


a:link {
	color: #42413C;
	text-decoration: underline; 
}
a:visited {
	color: #6E6C64;
	text-decoration: underline;
}
a:hover, a:active, a:focus { 
	text-decoration: none;
}

.container {
	width: 960px;
	background: #FFFFFF;
	margin: 0 auto; 
}

.header {
	background-color: #C5C5C5;
}

.sidebar1 {
	float: left;
	width: 190px;
	background-color: #DDD;
	padding: 10px;
	height: 600px;
	padding-right: 10px;
	border-right: 10px;
}
.content {
	width: 600px;
	float: left;
	height: 600px;
	padding-top: 0px;
	padding-right: 0;
	padding-bottom: 10px;
	padding-left: 0;
}
.sidebar2 {
	float: right;
	width: auto;
	background-color: #DDD;
	height: 620px;
	padding-top: 0px;
	padding-right: 0px;
	padding-bottom: 0px;
	padding-left: 0px;
}


.content ul, .content ol { 
	padding: 0 15px 15px 40px; 
}


ul.nav {
	list-style: none; 
	margin-bottom: 15px; 
	border-top-style: none;
	border-top-color: #666;
}
ul.nav li {
	border-bottom: 1px solid #666; 
}
ul.nav a, ul.nav a:visited { 
	padding: 5px 5px 5px 15px;
	display: block; 
	width: 160px;  
	text-decoration: none;
	background: #C6D580;
}
ul.nav a:hover, ul.nav a:active, ul.nav a:focus { 
	background: #ADB96E;
	color: #FFF;
}


.footer {
	padding: 0px;
	position: relative;
	clear: both; 
	background-color: #C5C5C5;
}


.fltrt {  
	float: right;
	margin-left: 8px;
}
.fltlft { 
	float: left;
	margin-right: 8px;
}
.clearfloat { 
	clear:both;
	height:0;
	font-size: 1px;
	line-height: 0px;
}
.container .sidebar2 p strong {
	font-size: 90%;
}
.container .footer table tr td {
	font-weight: bold;
}
-->
</style></head>

<body>
<% String s = "0";
	try{
		s = "" + (String) session.getAttribute("logado");
	}
	catch(Exception e){
		s = "0";
	}
if(s.equals("0")){
	
%>
<jsp:forward page="index.html"> 
<jsp:param name="FailReason" value="Wrong Password"/> 
</jsp:forward>
<%
}
 %>  
<div class="container">
  <div class="header" style="color:blue" contenteditable="false"><!-- end .header -->
     <table width="957" height="14" border="0">
      <tr>
        <td width="205"><img src="img/javamod.png" alt="" style="width: 195px; "></td>
        <td width="468">&nbsp;</td>
        <td width="272"></td>
      </tr>
    </table>
  </div>
  <div class="sidebar1" style="width: 200px; ">
  	 
    <div id='cssmenu' align="center">
    <ul>
    <li><a href='blank.html' target="frame1"><span>Pagina Principal</span></a></li>
    <li class='active has-sub'><a href='#'><span>Cliente</span></a>
      <ul>
         <li class='has-sub'><a href='clientecadastrar.jsp' target="frame1"><span>Cadastrar</span></a>
         </li>
         <li class='has-sub'><a href='clienteconsultar.jsp' target="frame1"><span>Consultar</span></a>
         </li>
         <li class='has-sub'><a href='clientealterar.jsp' target="frame1"><span>Alterar</span></a>
         </li>
      </ul>
   </li>
   <li class='active has-sub'><a href='#'><span>Automóvel</span></a>
      <ul>
         <li class='has-sub'><a href='automovelcadastrar.jsp' target="frame1"><span>Cadastrar</span></a>
         </li>
         <li class='has-sub'><a href='automovelconsultar.jsp' target="frame1"><span>Consultar</span></a>
         </li>
         <li class='has-sub'><a href='automovelexcluir.jsp' target="frame1"><span>Excluir</span></a>
         </li>
         <li class='has-sub'><a href='automovelalterar.jsp' target="frame1"><span>Alterar</span></a>
         </li>
      </ul>
   </li>
   <li class='last'><a href='locar.jsp' target="frame1"><span>Locação</span></a></li>
   <li class='last'><a href='devolucao.jsp' target="frame1"><span>Devolução</span></a></li>
   <li class='last'><a href='sobre.html' target="frame1"><span>Sobre</span></a></li>
   <li class='last'><a href='index.html' onClick=<%session.invalidate();%>><span>Sair</span></a></li>
   
    </ul>
    </div>
    <p>&nbsp;</p>
    </div>
  
  
  
  <div class="content">
    <!--  <h1 align="center">&nbsp;</h1> -->
    <!--  <h1 align="center">&nbsp;</h1> -->
    <!-- <h1 align="center">&nbsp;</h1> -->
    <h1 align="center">
    <% 
	String frame_src = "";//"clientecadastrar.jsp";
	String[] allowed_srcs = {"page1","page2","clientecadastrar","logo"};
	String targeted_frame = request.getParameter("frame");
	if(Arrays.asList(allowed_srcs).contains(targeted_frame))
    	frame_src = targeted_frame + ".jsp";
%>
<iframe name="frame1" src="<%= frame_src %>" width="736px" height="616px"></iframe></h1>
    
    <!-- end .content --></div>
  
  <!-- end .container --></div>
</body>
</html>
