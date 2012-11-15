<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="Estilo.css" type="text/css">
        <title>Usuário Existente</title>
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <div id ="alinhaTexto" >
        <h1>Cadastro negado</h1>
        <br>
        Email já existe.
        Tente novamente  <a href="Cadastro.jsp">clicando aqui</a>.
        </div>
    </body>
</html>
