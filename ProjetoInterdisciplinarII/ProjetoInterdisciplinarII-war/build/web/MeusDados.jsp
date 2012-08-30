<%-- 
    Document   : MeusDados
    Created on : 23/08/2012, 00:21:40
    Author     : Teruo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="Estilo.css" type="text/css">
        <title>Meus dados</title>
    </head>
    <body>
        <%
            String nome = (String) session.getAttribute("nome");
            String email = (String) session.getAttribute("email");
            String rg = (String) session.getAttribute("rg");
            String sexo = (String) session.getAttribute("sexo");
            String estado = (String) session.getAttribute("estado");
            String cidade = (String) session.getAttribute("cidade");
            String bairro = (String) session.getAttribute("bairro");
            String endereco = (String) session.getAttribute("endereco");
            String celular = (String) session.getAttribute("celular");
            String telefone = (String) session.getAttribute("telefone");
            String escolaridade = (String) session.getAttribute("escolaridade");
            String nivel = (String) session.getAttribute("nivel");
            String area = (String) session.getAttribute("area");
            String faculdade = (String) session.getAttribute("faculdade");
            String curso = (String) session.getAttribute("curso");
        %>
        <form>
            <jsp:include page="header.jsp"/>
            <h1>Meus Dados</h1>
            <br>
            Veja abaixo os seus dados.
            <table>
                <tr>
                    <td>
                        Nome:
                    </td>
                    <td>
                        <%=nome%>
                    </td>
                </tr>
                <tr>
                    <td>
                        E-mail:
                    </td>
                    <td>
                        <%=email%>
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
