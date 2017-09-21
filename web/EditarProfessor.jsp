<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar professor <%= request.getParameter("param2") %></title>
    </head>
    <body>

    <h1>Editar professor <%= request.getParameter("param2") %></h1>
    <form action="EditarProfessorServlet" method="post">
        <table>
            <tr>
            <td>ID:</td><td><input type="text" id ="idProf" name="idProf" disabled="true" value="<%= request.getParameter("param1") %>" /></td>
            <td>Nome:</td><td><input type="text" id ="nome" name="nome" value="<%= request.getParameter("param2") %>"/></td>
            <td>Titulacao:</td><td><input type="text" id ="titulacao" name="titulacao" value="<%= request.getParameter("param3") %>" /></td>
            <td>Email:</td><td><input type="text" id ="email" name="email" value="<%= request.getParameter("param4") %>" /></td>
            </tr>
        </table>
        <button type="submit" name="idSalvar" value="${param1}" class="btn-link">Salvar</button>
    </form>
<a href="ListarPessoas"><strong>Ir para lista de pessoas</strong></a>
</body>
</html>
