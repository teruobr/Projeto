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
        <h2>Bem vindo <%=usuario.getNome()%> ! O que deseja fazer?  </h2>

        <p><a href="MeusDados.jsp">Meus Dados</a></p>

        <p><a href="AreaAtuacao.jsp">Áreas de Atuação</a></p>

        <p><a href="AtualizarCadastro.jsp">Atualizar Cadastro</a></p>

        <p><a href="Vagas.jsp">Pesquisar Vagas</a></p>

        <p><a href="Sair.jsp">Sair</a></p>

    </body>
</html>
