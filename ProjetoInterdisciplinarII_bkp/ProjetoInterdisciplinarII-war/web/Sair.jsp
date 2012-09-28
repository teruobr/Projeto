<%-- 
    Document   : Sair
    Created on : 31/08/2012, 10:56:14
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
        <title>Usuário logado</title>
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <%
            session.invalidate();
        %>
        <h1>LogOut efetuado com sucesso</h1>
        <br>
        Você saiu do nosso sistema. Volte logo!
    </body>
</html>
