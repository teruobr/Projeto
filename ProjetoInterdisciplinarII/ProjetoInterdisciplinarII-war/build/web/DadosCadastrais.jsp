<%-- 
    Document   : DadosCadastrais
    Created on : 30/08/2012, 11:56:54
    Author     : Teruo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="Estilo.css" type="text/css">
        <title>Cadastro de novo usuário</title>
    </head>
    <body>
        <%
                String nome = request.getParameter("txtNome");
                String email = request.getParameter("txtEmail");
                String senha = request.getParameter("txtSenha");
                if (nome != null) {
                    session.setAttribute("nome", nome);
                }
                if (email != null) {
                    session.setAttribute("email", email);
                }
                if (senha != null) {
                    session.setAttribute("senha", senha);
                }
            }
        %>
        <form action="CadastroSucesso.jsp" >
            <jsp:include page="header.jsp"/>
            <h1>Dados Cadastrais</h1>
            <br>
            Preencha os campos abaixo para finalizar o seu cadastro.
            <table>
                <tr>
                    <td>
                        RG:
                    </td>
                    <td>
                        <input  type="text" name="txtRG"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        Sexo:
                    </td>
                    <td>
                        <select name="lstSexo">
                            <option value="M">Masculino</option>
                            <option value="F">Feminino</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        Estado:
                    </td>
                    <td>
                        <select name="lstEstado">
                            <option value="SP">São Paulo </option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        Cidade:
                    </td>
                    <td>
                        <select name="lstCidade">
                            <option value="Sp">São Paulo</option>
                            <option value="StoA">Santo André</option>
                            <option value="Sbc">São Bernardo do Campo</option>
                            <option value="Sc">São Caetano do Sul</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        Bairro:
                    </td>
                    <td>
                        <input type="text" name="txtBairro"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        Endereço:
                    </td>
                    <td>
                        <input type="text" name="txtEndereco"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        Celular:
                    </td>
                    <td>
                        (<input type="text" name="txtDDDCel" maxlength="2" size="1" />) <input type="text" name="txtCel" maxlength="9" size="7"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        Telefone:
                    </td><td>
                        (<input type="text" name="txtDDDTel" maxlength="2" size="1" />) <input type="text" name="txtTel" maxlength="8" size="7"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        Grau de Escolaridade:
                    </td>
                    <td>
                        <select name="lstEscolaridade">
                            <option value="Tecnico">Técnico</option>
                            <option value="SuperiorInc">Superior Incompleto</option>
                            <option value="SuperiorCom">Superior Completo</option>
                            <option value="Pos">Pós-Graduado</option>
                        </select>
                    </td>
                    <td>
                        Nível de Atuação:
                    </td>
                    <td>
                        <select name="lstNivel">
                            <option value="Tecnico">Técnico</option>
                            <option value="Estagiario">Estagiário</option>
                            <option value="Jr">Júnior</option>
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
                        <select name="lstFaculdade">
                            <option value="Mackenzie">Universidade Mackenzie</option>
                        </select>
                    </td>
                    <td>
                        Área de Atuação:
                    </td>
                    <td>
                        <select name="lstArea">
                            <option value="Suporte">Suporte</option>
                            <option value="Programacao">Programação</option>
                            <option value="Analise">Análise</option>
                            <option value="Projeto">Projetos</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        Curso:
                    </td>
                    <td>
                        <select name="lstCurso">
                            <option value="SI">Sistemas de Informação</option>
                            <option value="CC">Ciências da Computação</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td colspan="2" style="float:right;">
                        <input type="submit" value="Finalizar" />
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>

