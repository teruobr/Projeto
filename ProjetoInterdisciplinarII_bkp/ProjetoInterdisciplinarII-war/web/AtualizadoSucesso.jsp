<%-- 
    Document   : AtualizadoSucesso
    Created on : 21/09/2012, 16:04:41
    Author     : 31010296
--%>

<%--<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN""http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="Estilo.css" type="text/css">
        <title>Cadastro Atualizado com sucesso</title>
    </head>
    <body>
        <jsp:include page="MenuLogado.jsp"/>
        <%
            String rg = request.getParameter("txtRg");
            String sexo = request.getParameter("lstSexo");
            String estado = request.getParameter("lstEstado");
            String cidade = request.getParameter("lstCidade");
            String bairro = request.getParameter("txtBairro");
            String endereco = request.getParameter("txtEndereco");
            String DDDCel = request.getParameter("txtDDDCel");
            String cel = request.getParameter("txtCel");
            String DDDTel = request.getParameter("txtDDDTel");
            String tel = request.getParameter("txtTel");
            String escolaridade = request.getParameter("lstEscolaridade");
            String nivel = request.getParameter("lstNivel");
            String faculdade = request.getParameter("lstFaculdade");
            String area = request.getParameter("lstArea");
            String curso = request.getParameter("lstCurso");

            if (rg != null) {
                session.setAttribute("rg", rg);
            }
            if (sexo != null) {
                session.setAttribute("sexo", sexo);
            }
            if (estado != null) {
                session.setAttribute("estado", estado);
            }
            if (cidade != null) {
                session.setAttribute("cidade", cidade);
            }
            if (bairro != null) {
                session.setAttribute("bairro", bairro);
            }
            if (endereco != null) {
                session.setAttribute("endereco", endereco);
            }
            if ((DDDCel != null) && (cel != null)) {
                session.setAttribute("celular", "(" + DDDCel + ")" + cel);
            }
            if ((DDDTel != null) && (tel != null)) {
                session.setAttribute("telefone", "(" + DDDTel + ")" + tel);
            }
            if (escolaridade != null) {
                session.setAttribute("escolaridade", escolaridade);
            }
            if (nivel != null) {
                session.setAttribute("nivel", nivel);
            }
            if (area != null) {
                session.setAttribute("area", area);
            }
            if (faculdade != null) {
                session.setAttribute("faculdade", faculdade);
            }
            if (curso != null) {
                session.setAttribute("curso", curso);
            }
        %>
        <h1>Seu cadastro foi atualizado com sucesso!</h1>
        Seja bem-vindo ao Portal de Vagas PI - II.
        <br>
        <br>
        Para visualizar os dados, clique <a href="MeusDados.jsp">aqui</a>.
    </body>
</html>
