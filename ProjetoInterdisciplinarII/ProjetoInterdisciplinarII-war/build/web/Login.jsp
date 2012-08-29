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
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <h1>Login</h1>
        <form action="MeusDados.jsp" >
            <table>
                <tr>
                    <td>
                        E-mail:
                    </td>
                    <td>
                        <input type="text" name="txtEmail"/>
                    </td>
                <tr>
                    <td>
                        Senha:
                    </td>
                    <td>
                        <input type="password" name="txtSenha" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <a href="Cadastro.jsp">
                            <input type="button" name="btnCadastrar" value="Cadastrar" />
                        </a>
                    </td>
                    <td>
                        <input type="submit" value="Login" />
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
