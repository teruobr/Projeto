<%-- 
    Document   : Sair
    Created on : 31/08/2012, 10:56:14
    Author     : Teruo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="Estilo.css" type="text/css">
        <title>Usuário não logado</title>
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
