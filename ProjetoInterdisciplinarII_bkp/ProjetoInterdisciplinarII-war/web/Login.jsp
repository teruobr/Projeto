<%-- 
    Document   : Login
    Created on : 27/08/2012, 21:44:04
    Author     : Teruo
--%>

<%@page import="javax.ws.rs.core.Response"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="Estilo.css" type="text/css">
        <script type="text/javascript" src="jquery-1.8.0.js"></script>
        <title>Login</title>
       
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <div id ="alinhaTexto" >
        <h1>Login</h1>
        <form action="ValidarUsuario" name="form" method="post" >
            <table>
                <tr>
                    <td>
                        E-mail:
                    </td>
                    <td>
                        <input type="text" name="emailLogin" required="true"/>
                    </td>
                <tr>
                    <td>
                        Senha:
                    </td>
                    <td>
                        <input type="password" name="senhaLogin" required="true"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <a href="Cadastro.jsp">
                            Cadastre-se já!
                        </a>
                    </td>
                    <td> &nbsp;</td>
                    <td>
                        <input type="submit" value="Login"/>
                    </td>
                </tr>
            </table>
        </form>
        <div id ="alinhaTexto" >
    </body>
</html>
