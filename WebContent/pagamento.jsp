<%@ page import="java.util.*, java.text.*, model.* "%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="./css/main.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Pagamento</title>
</head>
<body>
	<%
		String x = "";
	try{
		x = (String) session.getAttribute("tipopagamento");
	}
	catch(Exception e){
		x = "";
	}
	
	if(x.equals("credito")){%>
	
		<form method="post" name="formaLoca" action="LocarAutomovelController">
		<fieldset>
		<legend> <b>Pagamento</b></legend>
        <label>Tipo de Cartão:</label><input type="text" name="cPTipo" pattern="[A-Za-z]{4,}" title="" placeholder="" size="26" required/><br>
   	 	
    	<div>
    	<label>Titular:</label><input  type="text" name="cPTitular" pattern="[A-Za-z\s]{2,}" title="Apenas Letras" placeholder="" size="26" required/><br>
    	</div>
    	<div>	
    	<label >Número de Cartão:</label><input type="text" name="cPNumerocartao" pattern="\d{5,}" title="" placeholder="" size="26" required/><br>
   		 </div>
   		 <div>
    	<label>Data de Validade:</label><input type="date" name="cPDatadevalidade" pattern="\d{2}/\d{2}/\d{4}" placeholder="11/11/2011" size="26" required /><br>
    	</div>
   		 <div>	
    	<label >Código de Segurança:</label><input  type="text" name="cPCodigo" pattern="\d{4,}" placeholder="" size="26"  required/>
    	</div>
    	<input type="submit" value="Enviar" style="text-align:center;background-color:#4CA4C2;margin-left:auto;margin-right:auto;display:block;margin-top:3%;margin-bottom:0%">
    	<button action="locar.jsp" name="Voltar" style="text-align:center;background-color:#4CA4C2;margin-left:auto;margin-right:auto;display:block;margin-top:3%;margin-bottom:0%">Voltar</button>
	     </fieldset>
	     </form>
		
	<%}
	else if(x.equals("debito")){%>
	
		<form method="post" name="formaLoca" action="LocarAutomovelController" >
		<fieldset>
		<legend> <b>Pagamento</b></legend>
      	<div>
    	<label >Banco:</label><input type="text" name="dPBanco" pattern="[A-Za-z\s]{4,}" title="Apenas Letras 4+" placeholder="" size="26" required/>
    	</div>
    	<div>
    	<label >Agência:</label><input  type="text" name="dPAgencia" pattern="[A-Za-z]{2,}" title="Apenas Letras 2+" placeholder="" size="26" required/>
    	</div>
    	<div>	
    	<label >Conta:</label><input type="text" name="dPConta" pattern="[A-Za-z]{2,}" title="Apenas Letras 2+" placeholder="" size="26" required/>
    	</div>
    	<div>
    	<label>Titular:</label><input  name="dPTitular" pattern="[A-Za-z]{3,}" title="Apenas Letras 2+" placeholder="" size="26" required />
    	</div>
    	<div>	
    	<label>Telefone:</label><input  type="text" name="dPTelefone" pattern="\d{4,5}-\d{4}" title="Apenas Numeros 8 a 9" placeholder="" size="26"  required/>
    	</div>
    	<input type="submit" value="Enviar" style="text-align:center;background-color:#4CA4C2;margin-left:auto;margin-right:auto;display:block;margin-top:3%;margin-bottom:0%">
    	<button action="locar.jsp" style="text-align:center;background-color:#4CA4C2;margin-left:auto;margin-right:auto;display:block;margin-top:3%;margin-bottom:0%">Voltar</button>
    	
    	</fieldset>
    	</form>
	
		
	<%}
	else{
		
	}
	
	
	%>
</body>
</html>