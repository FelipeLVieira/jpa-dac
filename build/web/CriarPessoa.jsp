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

    <h1>Criar uma pessoa</h1>
    <form id="criarPessoasForm" action="CriarPessoa" method="post">
    <table>
        <tr><td>ID:</td><td><input type="text" id = "id" name="id" /></td></tr>
        <tr><td>Nome</td><td><input type="text" id = "nome" name="nome" /></td></tr>
    </table>
    <input type="submit" id="CriarPessoa" value="CriarPessoa" />
    </form>
<a href="ListarPessoas"><strong>Ir para lista de pessoas</strong></a>
</body>
</html>
