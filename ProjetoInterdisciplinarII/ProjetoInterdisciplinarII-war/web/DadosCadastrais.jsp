<%-- 
    Document   : DadosCadastrais
    Created on : 30/08/2012, 11:56:54
    Author     : Teruo
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="Estilo.css" type="text/css">
        <title>Cadastro de novo usu?rio</title>
        <script language='JavaScript'>
            function SomenteNumero(e){
                var tecla=(window.event)?event.keyCode:e.which;   
                if((tecla>47 && tecla<58)) return true;
                else{
                    if (tecla==8 || tecla==0) return true;
                    else  return false;
                }
            }
        </script>
    </head>
    <body>
        <%
            String nome = (String) request.getAttribute("txtNome");
            String email = (String) request.getAttribute("txtEmail");
            String senha = (String) request.getAttribute("txtSenha");
            if (nome != null) {
                session.setAttribute("nome", nome);
            }
            if (email != null) {
                session.setAttribute("email", email);
            }
            if (senha != null) {
                session.setAttribute("senha", senha);
            }
        %>
        <form action="CadastraCompleto" >
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
                        <input  type="text" name="txtRg" required="true" maxlength="9"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        Sexo:
                    </td>
                    <td>
                        <select name="lstSexo">
                            <option value="Masculino">Masculino</option>
                            <option value="Feminino">Feminino</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        Estado:
                    </td>
                    <td>
                        <select name="lstEstado" required="true">
                            <option value="">Selecione</option>
                            <option value="SP">S&atilde;o Paulo </option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        Cidade:
                    </td>
                    <td>
                        <select name="lstCidade" required="true" >
                            <option value="">Selecione</option>
                            <option value="São Paulo">S&atilde;o Paulo</option>
                            <option value="Santo André">Santo Andr&eacute;</option>
                            <option value="São Bernardo do Campo">S&atilde;o Bernardo do Campo</option>
                            <option value="São Caetano do Sul">S&atilde;o Caetano do Sul</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        Bairro:
                    </td>
                    <td>
                        <input type="text" name="txtBairro" required="true"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        Endere&ccedil;o:
                    </td>
                    <td>
                        <input required="true" type="text" name="txtEndereco" required="true"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        Celular:
                    </td>
                    <td>
                        (<input required="true" type="text" name="txtDDDCel" maxlength="2" size="1" onkeypress="return SomenteNumero(event);" />) <input required="true" type="text" name="txtCel" maxlength="9" size="7" onkeypress="return SomenteNumero(event);"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        Telefone:
                    </td><td>
                        (<input required="true" type="text" name="txtDDDTel" maxlength="2" size="1" onkeypress="return SomenteNumero(event);" />) <input required="true" type="text" name="txtTel" maxlength="8" size="7" onkeypress="return SomenteNumero(event);"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        Grau de Escolaridade:
                    </td>
                    <td>
                        <select name="lstEscolaridade" required="true">
                            <option value="">Selecione</option>
                            <option value="Técnico">T&eacute;cnico</option>
                            <option value="Superior Incompleto">Superior Incompleto</option>
                            <option value="Superior Completo">Superior Completo</option>
                            <option value="Pós-Graduado">P&oacute;s-Graduado</option>
                        </select>
                    </td>
                    <td>
                        N&iacute;vel de Atua&ccedil;&atilde;o:
                    </td>
                    <td>
                        <select name="lstNivel" required="true">
                            <option value="">Selecione</option>
                            <option value="Técnico">T&eacute;cnico</option>
                            <option value="Estagiário">Estagi&aacute;rio</option>
                            <option value="Júnior">J&uacute;nior</option>
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
                            <option value="PUC">PUC</option>
                            <option value="USP">USP</option>
                            <option value="FGV">FGV</option>
                        </select>
                    </td>
                    <td>
                        &Aacute;rea de Atua&ccedil;&atilde;o:
                    </td>
                    <td>
                        <select name="lstArea" required="true">
                            <option value="">Selecione</option>
                            <option value="Analise">Analise</option>
                            <option value="Docência e Pesquisa">Doc&ecirc;ncia e Pesquisa</option>
                            <option value="Empresário">Empres&aacute;rio</option>
                            <option value="Gerência">Ger&ecirc;ncia</option>
                            <option value="Programação">Programa&ccedil;&atilde;o</option>
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
                            <option value="Sistemas de Informação">Sistemas de Informa&ccedil;&atilde;o</option>
                            <option value="Ciência da Computação">Ci&ecirc;ncia da Computa&ccedil;&atilde;o</option>
                            <option value="ADS">ADS</option>
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

