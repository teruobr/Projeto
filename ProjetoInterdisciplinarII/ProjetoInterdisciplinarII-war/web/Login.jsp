<%-- 
    Document   : Login
    Created on : 27/08/2012, 21:44:04
    Author     : Teruo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="Estilo.css" type="text/css">
        <script type="text/javascript" src="jquery-1.8.0.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String emailCandidato = (String) session.getAttribute("email");
            String senhaCandidato = (String) session.getAttribute("senha");
            String emailLogin = request.getParameter("email");
            String senhaLogin = request.getParameter("senha");
        %>
        <%! public boolean ValidarLogin(String emailLogin, String emailCandidato, String senhaLogin, String senhaCandidato) {
                if ((emailLogin != emailCandidato) && (senhaLogin != senhaCandidato)) {
                    return false;
                }
                return true;
            }
        %>
        <jsp:include page="header.jsp"/>
        <h1>Login</h1>
        <form action="MeusDados.jsp" method="post" onsubmit="return ValidarLogin(emailLogin, emailCandidato, senhaLogin, senhaCandidato)" >
            <table>
                <tr>
                    <td>
                        E-mail:
                    </td>
                    <td>
                        <input type="text" name="email" required="true"/>
                    </td>
                <tr>
                    <td>
                        Senha:
                    </td>
                    <td>
                        <input type="password" name="senha" required="true"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <a href="Cadastro.jsp">
                            <input type="button" name="btnCadastrar" value="Cadastrar" />
                        </a>
                    </td>
                    <td>
                        <input type="submit" value="Login"/>
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
