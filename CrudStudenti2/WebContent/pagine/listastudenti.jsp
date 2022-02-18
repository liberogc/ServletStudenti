<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>LISTA STUDENTI</title>
	<link rel="stylesheet" href="css/listastudenti.css" type="text/css"/>
	<link rel="stylesheet" href="css/menustu.css" type="text/css"/>
	<% ResultSet lista=(ResultSet)request.getAttribute("listast"); %>
</head>
<body>
	<div id="titlista">LISTA STUDENTI IN ARCHIVIO</div>
	
	<%@ include file="/pagine/menustu.jsp" %>
	
	<table id="tablista" border="0" cellspacing="20">
	<tr class="intesta">
			<td>
				MATRICOLA
			</td>
			<td>
				NOME
			</td>
			<td>
				COGNOME
			</td>
			<td>
				CITTA
			</td>
			<td>
				DATA DI NASCITA
			</td>
		</tr>
		<% while(lista.next()) { %>
		<!-- converti data split -->
		<% String data=lista.getString("dn"); 
		String[] ldata=data.split("-");
		data=ldata[2]+"/"+ldata[1]+"/"+ldata[0];
		%>
		<tr class="lista" align="center">
			<td><%=lista.getInt("matricola") %></td>
			<td><%=lista.getString("nome") %></td>
			<td><%=lista.getString("cognome") %></td>
			<td><%=lista.getString("citta") %></td>
			<td><%=data %></td>
		</tr>
		<%}%>
	</table>
</body>
</html>