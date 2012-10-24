<%-- 
    Document   : Home
    Created on : 12/10/2012, 16:13:59
    Author     : Felipe
--%>

<%@page import="bean.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="Estilo.css" type="text/css">
        <title>Home Page</title>
    </head>

    <%

        Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");

    %>

    <body>
        <jsp:include page="MenuLogado.jsp"/>
        <h2>Bem vindo <%=usuario.getNome()%> ! O que deseja fazer?  </h2>
        

    </body>
</html>
