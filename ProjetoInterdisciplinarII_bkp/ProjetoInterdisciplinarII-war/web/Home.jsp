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
        <div id ="alinhaTexto" >
            <h2>Bem vindo <%=usuario.getNome()%> ! O que deseja fazer?  </h2>
            </br>
            <a href="MeusDados.jsp"> <img src="images/dados.jpg" width="60" height="60"/></a> Meus Dados
            </br>
            <a href="AreaAtuacao.jsp"> <img src="images/pensar.jpg" width="60" height="60"/></a>Areas de Atuação
            </br>
            <a href="ConsultaAreaUniversidade"> <img src="images/atualizar.jpg" width="60" height="60"/></a> Atualizar Cadastro
            </br>
            <a href="AtualizaMinhasCandidaturas"> <img src="images/time.jpg" width="60" height="60"/></a> Minhas Candidaturas
            </br>
            <a href="Vagas.jsp"> <img src="images/pesquisar.jpg" width="60" height="60"/></a>Pesquisar Vagas
            </br>
            <a href="ConsultaEmpresas"> <img src="images/mala.jpg" width="60" height="60"/></a>Minhas Experi&ecirc;ncias
            </br>
            <a href="Sair.jsp"> <img src="images/sair.jpg" width="60" height="60"/></a> Sair


        </div>

    </body>
</html>
