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
                String nome = request.getParameter("txtNome");
                String email = request.getParameter("txtEmail");
                String ddd = request.getParameter("txtDDD");
                String cel = request.getParameter("txtCel");
                if (nome != null) {
                    session.setAttribute("nome", nome);
                }
            }
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
                <tr>
                    <td>
                        Celular:
                    </td>
                    <td>
                        ( <%=ddd%> ) <%=cel%>
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
