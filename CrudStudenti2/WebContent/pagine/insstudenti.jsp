<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FORM INSERIMENTO STUDENTI</title>
<link rel="stylesheet" href="css/formstu.css" type="text/css" />
<link rel="stylesheet" href="css/menustu.css" type="text/css" />
<script type="text/javascript" src="JQueryLib/jquery-1.7.1.min.js"></script>
</head>
<script type="text/javascript">
	$(document).ready(function() {
		$("#forminsstu").submit(function() {
			var matr = document.getElementById("matricola").value;
			var cognome = document.getElementById("cognome").value;
			if (matr == "" || cognome == "") {
				alert("Inserire Matricola e Cognome !!!!!")
				return false;
			}
		});

		$("#matricola").keypress(function(tasto) {
			var tastopremuto = tasto.keyCode;
			if ((tastopremuto >= 47 && tastopremuto <= 57)) {
				return true;
			} else {
				return false;
			}
		});
	});
</script>
<body>
	<div id="titins">INSERIMENTO NUOVO STUDENTE</div>

	<%@ include file="/pagine/menustu.jsp"%>

	<form id="forminsstu" action="stud" method="post">
		<table cellspacing="16">
			<tr>
				<td class="labelstu">Matricola</td>
				<td><input class="insstu" type="text" name="matricola"
					id="matricola"></td>
			</tr>
			<tr>
				<td class="labelstu">Nome</td>
				<td><input class="insstu" type="text" name="nome" id="nome"></td>
			</tr>
			<tr>
				<td class="labelstu">Cognome</td>
				<td><input class="insstu" type="text" name="cognome"
					id="cognome"></td>
			</tr>
			<tr>
				<td class="labelstu">Citta</td>
				<td><input class="insstu" type="text" name="citta" id="citta"></td>
			</tr>
			<tr>
				<td class="labelstu">Data di Nascita</td>
				<td><input class="insstu" type="date" name="data" id="data"></td>
			</tr>
		</table>
		<div id="pulsante">
			<input id="confinsstu" type="submit" value="Conferma">
		</div>
	</form>
</body>
</html>