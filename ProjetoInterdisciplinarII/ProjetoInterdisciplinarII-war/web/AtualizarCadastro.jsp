
<%--<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN""http://www.w3.org/TR/html4/loose.dtd">
<%@page import="bean.Usuario"%>
<%@page import="bean.Usuario_"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="Estilo.css" type="text/css">
        <title>Cadastro de novo usuário</title>
    </head>
    <body>
        <%

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
        <form action="AtualizaCadastro" >
            <jsp:include page="MenuLogado.jsp"/>
            <h1>Atualizar Dados Cadastrais</h1> 
            <br>
            Preencha os campos abaixo para atualizar o seu cadastro. 
            <table>
                <tr>
                    <td>
                        RG:
                    </td>
                    <td>
                        <input  value="<%=rg%>" type="text" name="txtRg" required="true"/>
                    </td>
                </tr>

                <tr>
                    <td>
                        Estado:
                    </td>
                    <td>
                        <select name="lstEstado" required="true">
                            <option value="">Selecione</option>
                            <option value="SP">São Paulo </option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        Cidade:
                    </td>
                    <td>
                        <select name="lstCidade" required="true">
                            <option value="">Selecione</option>
                            <option value="São Paulo">São Paulo</option>
                            <option value="Santo André">Santo André</option>
                            <option value="São Bernardo do Campo">São Bernardo do Campo</option>
                            <option value="São Caetano do Sul">São Caetano do Sul</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        Bairro:
                    </td>
                    <td>
                        <input value="<%=bairro%>" type="text" name="txtBairro"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        Endereço:
                    </td>
                    <td>
                        <input value="<%=endereco%>" type="text" name="txtEndereco"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        Celular:
                    </td>
                    <td>
                        (<input value="<%=DDDcelular%>" type="text" name="txtDDDCel" maxlength="2" size="1" />) <input value="<%=celular%>" type="text" name="txtCel" maxlength="9" size="7"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        Telefone:
                    </td><td>
                        (<input value="<%=DDDtelefone%>" type="text" name="txtDDDTel" maxlength="2" size="1" />) <input value="<%=telefone%>" type="text" name="txtTel" maxlength="8" size="7"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        Grau de Escolaridade:
                    </td>
                    <td>
                        <select name="lstEscolaridade" required="true">
                            <option value="">Selecione</option>
                            <option value="Tecnico">Técnico</option>
                            <option value="Superior Incompleto">Superior Incompleto</option>
                            <option value="Superior Completo">Superior Completo</option>
                            <option value="Pós-Graduado">Pós-Graduado</option>
                        </select>
                    </td>
                    <td>
                        Nível de Atuação:
                    </td>
                    <td>
                        <select name="lstNivel" required="true">
                            <option value="">Selecione</option>
                            <option value="Técnico">Técnico</option>
                            <option value="Estagiário">Estagiário</option>
                            <option value="Júnior">Júnior</option>
                            <option value="Pleno">Pleno</option>
                            <option value="Senior">Senior</option>
                            <option value="Gerente">Gerente </option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        Faculdade:
                    </td>
                    <td>
                        <select name="lstFaculdade" required="true">
                            <option value="">Selecione</option>
                            <option value="Mackenzie">Universidade Mackenzie</option>
                        </select>
                    </td>
                    <td>
                        Área de Atuação:
                    </td>
                    <td>
                        <select name="lstArea" required="true">
                            <option value="">Selecione</option>
                            <option value="Analise">Analise</option>
                            <option value="Docência e Pesquisa">Docência e Pesquisa</option>
                            <option value="Empresário">Empresário</option>
                            <option value="Gerência">Gerencia</option>
                            <option value="Programação">Programação</option>
                            <option value="Redes">Redes</option>

                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        Curso:
                    </td>
                    <td>
                        <select name="lstCurso" required="true">
                            <option value="">Selecione</option>
                            <option value="SI">Sistemas de Informação</option>
                            <option value="CC">Ciências da Computação</option>
                        </select>
                    </td>
                </tr>
                <tr> </br> </tr>
                <tr>

                    <td>
                        <a href="MeusDados.jsp">
                            <input type="button" value="Voltar"/>
                        </a>
                        <input type="submit" value="Finalizar" />
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>

