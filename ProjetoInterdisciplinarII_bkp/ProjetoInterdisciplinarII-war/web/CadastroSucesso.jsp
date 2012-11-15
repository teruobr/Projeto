<%-- 
    Document   : CadastroSucesso
    Created on : 29/08/2012, 11:17:34
    Author     : Teruo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="Estilo.css" type="text/css">
        <title>Cadastro finalizado com sucesso</title>
    </head>
    <body>
        <%
            String Rg = request.getParameter("txtRg");
            String Sexo = request.getParameter("lstSexo");
            String Estado = request.getParameter("lstEstado");
            String Cidade = request.getParameter("lstCidade");
            String Bairro = request.getParameter("txtBairro");
            String Endereco = request.getParameter("txtEndereco");
            String DDDCel = request.getParameter("txtDDDCel");
            String Cel = request.getParameter("txtCel");
            String DDDTel = request.getParameter("txtDDDTel");
            String Tel = request.getParameter("txtTel");
            String Escolaridade = request.getParameter("lstEscolaridade");
            String Nivel = request.getParameter("lstNivel");
            String Faculdade = request.getParameter("lstFaculdade");
            String Area = request.getParameter("lstArea");
            String Curso = request.getParameter("lstCurso");

            if (Rg != null) {
                session.setAttribute("rg", Rg);
            }
            if (Sexo != null) {
                session.setAttribute("sexo", Sexo);
            }
            if (Estado != null) {
                session.setAttribute("estado", Estado);
            }
            if (Cidade != null) {
                session.setAttribute("cidade", Cidade);
            }
            if (Bairro != null) {
                session.setAttribute("bairro", Bairro);
            }
            if (Endereco != null) {
                session.setAttribute("endereco", Endereco);
            }
            if ((DDDCel != null)) {
                session.setAttribute("dddcelular", DDDCel);
            }
            if ((Cel != null)) {
                session.setAttribute("celular", Cel);
            }
             if ((DDDTel != null)) {
                session.setAttribute("dddtelefone", DDDTel);
            }
            if ((Tel != null)) {
                session.setAttribute("telefone", Tel);
            }
            if (Escolaridade != null) {
                session.setAttribute("escolaridade", Escolaridade);
            }
            if (Nivel != null) {
                session.setAttribute("nivel", Nivel);
            }
            if (Area != null) {
                session.setAttribute("area", Area);
            }
            if (Faculdade != null) {
                session.setAttribute("faculdade", Faculdade);
            }
            if (Curso != null) {
                session.setAttribute("curso", Curso);
            }
        %>
        <jsp:include page="header.jsp"/>
        <div id ="alinhaTexto" >
        <h1>Seu cadastro foi finalizado com sucesso!</h1>
        Seja bem-vindo ao Portal de Vagas PI - II.
        <br>
        <br>
        Para acessar o portal, clique <a href="Login.jsp">aqui</a> e acesse com o seu e-mail e senha cadastrados.
        </div>
    </body>
</html>
