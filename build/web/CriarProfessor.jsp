<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Criar uma pessoa</title>
    </head>
    <body>

    <h1>Criar um professor</h1>
    <form id="criarProfessorForm" action="CriarProfessor" method="post">
    <table>
        <tr><td>ID:</td><td><input type="text" id = "id" name="id" disabled="true" /></td></tr>
        <tr><td>Nome:</td><td><input type="text" id = "nome" name="nome" /></td></tr>
        <tr><td>Titulacao:</td><td><input type="text" id = "titulacao" name="titulacao" /></td></tr>
        <tr><td>Email:</td><td><input type="text" id = "email" name="email" /></td></tr>
    </table>
    <input type="submit" id="CriarProfessor" value="CriarProfessor" />
    </form>
<a href="ListarPessoas"><strong>Ir para lista de pessoas</strong></a>
</body>
</html>
