<%-- 
    Document   : UsuarioInexistente
    Created on : 31/08/2012, 11:15:55
    Author     : Teruo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="Estilo.css" type="text/css">
        <title>Usuário inexistente</title>
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <div id ="alinhaTexto" >
        <h1>Acesso negado</h1>
        <br>
        Os dados de login estão incorretos.
        Tente novamente, ou <a href="Cadastro.jsp">clique aqui</a> para criar um novo usuário.
        </div>
    </body>
</html>
