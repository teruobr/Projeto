<%-- 
    Document   : MinhasCandidaturas
    Created on : Oct 19, 2012, 17:42:03 AM
    Author     : Thiago
--%>

<%@page import="java.lang.reflect.Array"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bean.VagasUsuario"%>
<%@page import="bean.Vagas"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="Estilo.css" type="text/css">
        <title>Minhas Candidaturas</title>
    </head>
    <body>
        <jsp:include page="MenuLogado.jsp"/>
        <div id ="alinhaTexto" >


        <%
            List<Vagas> vagasUsuario = (List<Vagas>) request.getSession().getAttribute("vagasUsuario");
        %>

        <% if (vagasUsuario == null || vagasUsuario.isEmpty()) {%>
        <h2>Você não possui candidaturas!</h2>

        <%} else {
        %>
        <h2>Minhas Candidaturas</h2>
        <table border ="2p">
            <tr>
                <td>
                    Titulo &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                </td>
                <td>
                    &Aacute;rea &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                </td>
                <td>
                    N&iacute;vel &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                </td>

                <td>
                    Estado &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                </td>

                <td>
                    Cidade &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                </td>
                <td>
                    Descri&ccedil;&atilde;o &nbsp;&nbsp;
                </td>

            </tr>

            <%

                if (vagasUsuario != null && !vagasUsuario.isEmpty()) {
                    // for (int i = 0; i < vagasUsuario.size(); i++) {
                    int i = 0;
                    do {

            %>
            <TR> 
                <TD><%=String.valueOf(vagasUsuario.get(i).getTitulo())%></TD>
                <TD><%=String.valueOf(vagasUsuario.get(i).getAreaAtuacao())%></TD>
                <TD><%=String.valueOf(vagasUsuario.get(i).getNivelAtuacao())%></TD>
                <TD><%=String.valueOf(vagasUsuario.get(i).getEstado())%></TD>
                <TD><%=String.valueOf(vagasUsuario.get(i).getCidade())%></TD>

                <TD><a href ="DetalheVaga?idVaga=<%=vagasUsuario.get(i).getId()%>&idEmpresa=<%=vagasUsuario.get(i).getIdEmpresa()%>"<%session.setAttribute("vagasUsuario", vagasUsuario);%> > Mais Informações </a></td>
            </TR> 


            <%
                            i++;
                        } while (i < vagasUsuario.size());
                    }
                }%>



        </table>
        </div>
    </body>
</html>


