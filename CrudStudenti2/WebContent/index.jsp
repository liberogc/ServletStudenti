<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
   <link rel="stylesheet" href="css/login.css" type="text/css"/>
   <script type="text/javascript" src="JQueryLib/jquery-1.7.1.min.js"></script>
   <meta charset="ISO-8859-1">
   <title>LOGIN STUDENTE</title>
	<%
		String errore = (String)request.getAttribute("errore");
	%>
	<link rel="stylesheet" href="css/login.css" type="text/css"/>
</head>

<script  type="text/javascript">
	$(document).ready(function() 
	{		
		$("#formlogin").submit(function() 
			{	
				var nome=document.getElementById("utente").value;
				var passwor=document.getElementById("pw").value;
				if(nome=="" ){
					alert("Inseire un utente");
					return false;
				}else{
					return true;
				}	
			});				
	}); 		
</script>	

 
<body>

	<div id="titolo">AREA RISERVATA - Gestione Studenti</div>
	
	<form action="menu" method="post" id="formlogin">
		<table border="0" cellspacing="6">	
			<tr>
				<td class="login" >UTENTE</td>
				<td><input class="inlogin" type="text" id="utente" name="utente"></td>
			</tr>
			<tr>
				<td class="login" >PASSWORD</td>
				<td><input class="inlogin" type="password" id="pw" name="pw"></td>
			<tr>
		</table>
		<div id="errore">
		<%				
	   	if(errore!=null)
	   	{				 
		%>
 			<%= errore%>
 		<%
		}
 		%>
 </div>		
		<div id="divsub"><input id="sub" type="submit" value="Login"></div>
	</form>
</body>
</html>