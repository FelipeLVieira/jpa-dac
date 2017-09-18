<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de pessoas</title>
    </head>
    <body>

    <h1>Lista de pessoas atualmente no banco</h1>
    
<table id="listaProfessores" border="3">
<tr >
    <th bgcolor=>ID</th>
    <th bgcolor=>Nome</th>
    <th bgcolor=>Email</th>
    <th bgcolor=>Titulacao</th>
</tr>
<c:forEach var="professor" begin="0" items="${requestScope.listaProfessores}">
<tr>
    <td>${professor.id}&nbsp;&nbsp;</td> 
    <td>${professor.nome}&nbsp;&nbsp;</td>
    <td>${professor.email}&nbsp;&nbsp;</td>
    <td>${professor.titulacao}&nbsp;&nbsp;</td>
</tr> 
<a href="EditarProfessor.jsp??param1=${professor.id}" ><strong>Editar</strong></a>
</c:forEach>
</table>
<br>
<br>
<table id="listaAlunos" border="3">
<tr >
    <th bgcolor=>ID</th>
    <th bgcolor=>Nome</th>
    <th bgcolor=>Email</th>
    <th bgcolor=>Matricula</th>
</tr>
<c:forEach var="aluno" begin="0" items="${requestScope.listaAlunos}">
<tr>
    <td>${aluno.id}&nbsp;&nbsp;</td> 
    <td>${aluno.nome}&nbsp;&nbsp;</td>
    <td>${aluno.email}&nbsp;&nbsp;</td>
    <td>${aluno.matricula}&nbsp;&nbsp;</td>
</tr>
<a href="EditarAluno.jsp??param1=${aluno.id}"><strong>Editar</strong></a>
</c:forEach>
</table>
<br>
<br>
<a href="CriarProfessor.jsp"><strong>Adicionar um professor</strong></a>
<br>
<a href="CriarAluno.jsp"><strong>Adicionar um aluno</strong></a>
</body>
</html>
