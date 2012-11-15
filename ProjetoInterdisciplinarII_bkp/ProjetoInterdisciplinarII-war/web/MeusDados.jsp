<%-- 
    Document   : MeusDados
    Created on : 23/08/2012, 00:21:40
    Author     : Teruo
--%>

<%@page import="bean.Usuario"%>
<%@page import="bean.Usuario_"%>
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
            /*
             * String emailLogin = request.getParameter("emailLogin"); String
             * senhaLogin = (String) request.getParameter("senhaLogin"); String
             * email = (String) session.getAttribute("email"); String senha =
             * (String) session.getAttribute("senha");
             *
             * if (!(emailLogin.equals(email)) || !(senhaLogin.equals(senha))) {
             * response.sendRedirect("UsuarioInexistente.jsp"); }
             *
             *
             * String email = (String) session.getAttribute("email"); String
             * nome = (String) session.getAttribute("nome"); String rg =
             * (String) session.getAttribute("rg"); String sexo = (String)
             * session.getAttribute("sexo"); String estado = (String)
             * session.getAttribute("estado"); String cidade = (String)
             * session.getAttribute("cidade"); String bairro = (String)
             * session.getAttribute("bairro"); String endereco = (String)
             * session.getAttribute("endereco"); String celular = (String)
             * session.getAttribute("celular"); String telefone = (String)
             * session.getAttribute("telefone"); String escolaridade = (String)
             * session.getAttribute("escolaridade"); String nivel = (String)
             * session.getAttribute("nivel"); String area = (String)
             * session.getAttribute("area"); String faculdade = (String)
             * session.getAttribute("faculdade"); String curso = (String) session.getAttribute("curso");
             */

            Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
            String email = usuario.getEmail();
            String nome = usuario.getNome();
            String rg = usuario.getRg();
            String sexo = usuario.getSexo();
            String estado = usuario.getEstado();
            String cidade = usuario.getCidade();
            String bairro = usuario.getBairro();
            String endereco = usuario.getEndereco();
            String DDDcelular = usuario.getDddcelular();
            String celular = usuario.getCelular();
            String DDDtelefone = usuario.getDddtelefone();
            String telefone = usuario.getTelefone();
            String escolaridade = usuario.getEscolaridade();
            String nivel = usuario.getNivel();
            String area = usuario.getArea();
            String faculdade = usuario.getFaculdade();
            String curso = usuario.getCurso();


        %>
        <form>
            <jsp:include page="MenuLogado.jsp"/>
            <div id ="alinhaTexto" >
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
                        RG:
                    </td>
                    <td>
                        <%=rg%>
                    </td>
                </tr>
                <tr>
                    <td>
                        Sexo:
                    </td>
                    <td>
                        <%=sexo%>
                    </td>
                </tr>
                <tr>
                    <td>
                        Estado:
                    </td>
                    <td>
                        <%=estado%>
                    </td>
                </tr>
                <tr>
                    <td>
                        Cidade:
                    </td>
                    <td>
                        <%=cidade%>
                    </td>
                </tr>
                <tr>
                    <td>
                        Bairro:
                    </td>
                    <td>
                        <%=bairro%>
                    </td>
                </tr>
                <tr>
                    <td>
                        Endereço:
                    </td>
                    <td>
                        <%=endereco%>
                    </td>
                </tr>
                <tr>
                    <td>
                        Celular:
                    </td>
                    <td>
                        <%=DDDcelular%><%=" "%><%=celular%>
                    </td>
                </tr>
                <tr>
                    <td>
                        Telefone:
                    </td><td>
                        <%=DDDtelefone%><%=" "%><%=telefone%>
                    </td>
                </tr>
                <tr>
                    <td>
                        Grau de Escolaridade:
                    </td>
                    <td>
                        <%=escolaridade%>
                    </td>
                    <td>
                        Nível de Atuação:
                    </td>
                    <td>
                        <%=nivel%>
                    </td>
                </tr>
                <tr>
                    <td>
                        Faculdade:
                    </td>
                    <td>
                        <%=faculdade%>
                    </td>
                    <td>
                        Área de Atuação:
                    </td>
                    <td>
                        <%=area%>
                    </td>
                </tr>
                <tr>
                    <td>
                        Curso:
                    </td>
                    <td>
                        <%=curso%>
                    </td>
                </tr>
            </table>
            </div>
        </form>
    </body>
</html>
