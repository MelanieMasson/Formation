<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="medical.m2i.model.*" %>
<%@ page import="medical.m2i.dao.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Liste des patients</title>
</head>
<body>
<%@ include file="../fragments/header.jsp" %>
<main class="container">
<h3>Ici on affiche la liste des patients</h3>

<table class="table table-striped">
<thead>
	<th>ID</th>
	<th>Nom</th>
	<th>Prenom</th>
	<th>Date Naissance</th>
	<th>Adresse</th>
	<th>Pays</th>
	<th>Ville</th>
	<th>Action</th>
</thead>
<tbody>
<% ArrayList<Patient> lptpl = new ArrayList<Patient>();
%>

	<%
		lptpl = ( ArrayList ) request.getAttribute("pl"); 
		for(Patient p :  lptpl ) {
			%>
			
			<tr>
				<td><%= p.getId() %></td>
				<td><%= p.getNom() %></td>
				<td><%= p.getPrenom() %></td>
				<td><%= p.getNaissance() %></td>
				<td><%= p.getAdresse() %></td>
				<td><%= p.getPays() %></td>
				<td><%= p.getVille() %></td>
				<td>
					<a class="btn btn-secondary btn-sm" href="editPatient?id=<%= p.getId() %>"><i class="fa fa-pencil-square-o" aria-hidden="true"></i></a>
					<button class="btn btn-danger btn-sm" onclick="supprimer(<%= p.getId() %>)"><i class="fa fa-trash-o" aria-hidden="true"></i></button> 
				</td>
			</tr>
			<%
		}
	%>
</tbody>
</table>

<a href="patient/patientregister.jsp" class="btn btn-primary">Ajouter un patient</a>

</main>
<%@ include file="../fragments/footer.jsp" %>


<script>
	function supprimer(id) {
		if(confirm("Etes-vous sur ?")){
			console.log('deletePatient?id='+id);
			window.location = 'deletePatient?id='+id;
		}
	}
</script>

</body>
</html>