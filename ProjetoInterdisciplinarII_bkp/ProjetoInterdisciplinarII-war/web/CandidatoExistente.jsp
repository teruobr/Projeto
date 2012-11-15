<%-- 
    Document   : CandidatoExistente
    Created on : 12/10/2012, 21:56:07
    Author     : Felipe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="Estilo.css" type="text/css">
        <title>Candidato Existente</title>
    </head>
    <body>
        <jsp:include page="MenuLogado.jsp"/>
        <div id ="alinhaTexto" >
        <h1>Candidatura negada</h1>
        <br>
        Você já se candidatou nesta vaga ou ocorreu um erro no sistema.
        Escolhe uma outra vaga ou tente novamente  <a href="Home.jsp">clicando aqui</a>.
        </div>
    </body>
</html>
