<%-- 
    Document   : teste
    Created on : 04/09/2012, 20:27:08
    Author     : Felipe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
      <form action="CadastraUsuario" name="form" method="post" >
            <table>
                <tr>
                    <td>
                        Nome:
                    </td>
                    <td>
                        <input type="text" name="nome" required="true"/>
                    </td>
               
            </table>
            <input type="submit" value="Login"/>
        </form>
    </body>

</html>
