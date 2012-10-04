<%-- 
    Document   : UsuarioInexistente
    Created on : 31/08/2012, 11:15:55
    Author     : Teruo
--%>

<%--<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN""http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="Estilo.css" type="text/css">
        <title>Usuário inexistente</title>
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <h1>Acesso negado</h1>
        <br>
        Os dados de login estão incorretos.
        Tente novamente, ou <a href="Cadastro.jsp">clique aqui</a> para criar um novo usuário.
    </body>
</html>
