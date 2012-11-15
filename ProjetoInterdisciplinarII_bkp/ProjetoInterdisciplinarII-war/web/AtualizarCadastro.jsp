
<%@page import="bean.Universidade"%>
<%@page import="bean.AreaAtuacao"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@page import="bean.Usuario"%>
<%@page import="bean.Usuario_"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="Estilo.css" type="text/css">
        <title>Atualizar usu&aacute;rio</title>
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

            List<AreaAtuacao> areasAtuacao = (List<AreaAtuacao>) request.getSession().getAttribute("AreasAtuacao");
            List<Universidade> Universidade = (List<Universidade>) request.getSession().getAttribute("Universidade");
        %>
        <form action="AtualizaCadastro" >
            <jsp:include page="MenuLogado.jsp"/>
            <div id ="alinhaTexto" >
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
                                <option value="" "Selecione"<%= ("Selecione".equals(estado)) ? ("selected='Selecione'") : ""%>>Selecione</option>
                                <option value='SP'<%= ("SP".equals(estado)) ? ("selected='São Paulo'") : ""%>>S&atilde;o Paulo</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Cidade:
                        </td>
                        <td>
                            <select name="lstCidade" required="true">
                                <option value="" "Selecione"<%= ("Selecione".equals(cidade)) ? ("selected='Selecione'") : ""%>>Selecione</option>                            
                                <option value='São Paulo'<%= ("São Paulo".equals(cidade)) ? ("selected='São Paulo'") : ""%>>S&atilde;o Paulo</option>                            
                                <option value='Santo André'<%= ("Santo André".equals(cidade)) ? ("selected='Santo André'") : ""%>> Santo Andr&eacute;</option>                            
                                <option value='São Bernardo do Campo'<%= ("São Bernardo do Campo".equals(cidade)) ? ("selected='São Bernardo do Campo'") : ""%>>  S&atilde;o Bernardo do Campo</option>                            
                                <option value='São Caetano do Sul'<%= ("São Caetano do Sul".equals(cidade)) ? ("selected='São Caetano do Sul'") : ""%>> S&atilde;o Caetano do Sul</option>                            

                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Bairro:
                        </td>
                        <td>
                            <input required="true" value="<%=bairro%>" type="text" name="txtBairro"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Endere&ccedil;o:
                        </td>
                        <td>
                            <input required="true" value="<%=endereco%>" type="text" name="txtEndereco"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Celular:
                        </td>
                        <td>
                            (<input required="true" value="<%=DDDcelular%>" type="text" name="txtDDDCel" maxlength="2" size="1" onkeypress="return SomenteNumero(event);"/>) <input required="true" value="<%=celular%>" type="text" name="txtCel" maxlength="9" size="7" onkeypress="return SomenteNumero(event);"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Telefone:
                        </td><td>
                            (<input required="true" value="<%=DDDtelefone%>" type="text" name="txtDDDTel" maxlength="2" size="1" onkeypress="return SomenteNumero(event);"/>) <input required="true" value="<%=telefone%>" type="text" name="txtTel" maxlength="8" size="7" onkeypress="return SomenteNumero(event);"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Grau de Escolaridade:
                        </td>
                        <td>
                            <select name="lstEscolaridade" required="true">
                                <option value="" "Selecione"<%= ("Selecione".equals(escolaridade)) ? ("selected='Selecione'") : ""%>>Selecione</option>
                                <option value="Técnico"<%=("Técnico".equals(escolaridade)) ? ("selected='Técnico'") : ""%>>T&eacute;cnico</option>
                                <option value="Superior Incompleto"<%=("Superior Incompleto".equals(escolaridade)) ? ("selected='Superior Incompleto'") : ""%>>Superior Incompleto</option>
                                <option value="Superior Completo"<%=("Superior Completo".equals(escolaridade)) ? ("selected='Superior Completo'") : ""%>>Superior Completo</option>
                                <option value="Pós-Graduado"<%=("Pós-Graduado".equals(escolaridade)) ? ("selected='Pós-Graduado'") : ""%>>P&oacute;s-Graduado</option>
                            </select>
                        </td>
                        <td>
                            N&iacute;vel de Atua&ccedil;&atilde;o:
                        </td>
                        <td>
                            <select name="lstNivel" required="true">
                                <option value="" "Selecione"<%= ("Selecione".equals(nivel)) ? ("selected='Selecione'") : ""%>>Selecione</option>
                                <option value="Técnico"<%=("Técnico".equals(nivel)) ? ("selected='Técnico'") : ""%>>T&eacute;cnico</option>
                                <option value="Estagiário"<%=("Estagiário".equals(nivel)) ? ("selected='Estagiário'") : ""%>>Estagi&aacute;rio</option>
                                <option value="Júnior"<%=("Júnior".equals(nivel)) ? ("selected='Júnior'") : ""%>>J&uacute;nior</option>
                                <option value="Pleno"<%=("Pleno".equals(nivel)) ? ("selected='Pleno'") : ""%>>Pleno</option>
                                <option value="Senior"<%=("Senior".equals(nivel)) ? ("selected='Senior'") : ""%>>Senior</option>
                                <option value="Gerente"<%=("Gerente".equals(nivel)) ? ("selected='Gerente'") : ""%>>Gerente</option>                            
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Faculdade:
                        </td>
                        <td>
                            <select name="lstFaculdade" required="true">
                                <option value="" "Selecione"<%= ("Selecione".equals(faculdade)) ? ("selected='Selecione'") : ""%>>Selecione</option>
                                <option value="Mackenzie"<%=("Mackenzie".equals(faculdade)) ? ("selected='Mackenzie'") : ""%>>Universidade Mackenzie</option>
                                <option value="PUC"<%=("PUC".equals(faculdade)) ? ("selected='Mackenzie'") : ""%>>PUC</option>
                                <option value="USP"<%=("USP".equals(faculdade)) ? ("selected='USP'") : ""%>>USP</option>
                                <option value="FGV"<%=("FGV".equals(faculdade)) ? ("selected='FGV'") : ""%>>FGV</option>

                                <% if (Universidade != null) {
                                        for (int i = 0; i < Universidade.size(); i++) {
                                %>
                                <option value="<%=Universidade.get(i).getNome()%>"<%=(Universidade.get(i).getNome().equals(faculdade)) ? ("selected='" + Universidade.get(i).getNome() + "'") : ""%>><%=Universidade.get(i).getNome()%></option>                            
                                <%       }
                                    }%>
                            </select>
                        </td>
                        <td>
                            &Aacute;rea de Atua&ccedil;&atilde;o:
                        </td>
                        <td>
                            <select name="lstArea" required="true">
                                <option value="" "Selecione"<%= ("Selecione".equals(area)) ? ("selected='Selecione'") : ""%>>Selecione</option>
                                <option value="Analise"<%=("Analise".equals(area)) ? ("selected='Analise'") : ""%>>Analise</option>
                                <option value="Docência e Pesquisa"<%=("Docência e Pesquisa".equals(area)) ? ("selected='Docência e Pesquisa'") : ""%>>Doc&ecirc;ncia e Pesquisa</option>
                                <option value="Empresário"<%=("Empresário".equals(area)) ? ("selected='Empresário'") : ""%>>Empres&aacute;rio</option>
                                <option value="Gerência"<%=("Gerência".equals(area)) ? ("selected='Gerência'") : ""%>>Ger&ecirc;ncia</option>
                                <option value="Programação"<%=("Programação".equals(area)) ? ("selected='Programação'") : ""%>>Programa&ccedil;&atilde;o</option>
                                <option value="Redes"<%=("Redes".equals(area)) ? ("selected='Redes'") : ""%>>Redes</option>

                                <% if (areasAtuacao != null) {
                                        for (int i = 0; i < areasAtuacao.size(); i++) {
                                            
                                %>
                                <option value="<%=areasAtuacao.get(i).getNome()%>"<%=(areasAtuacao.get(i).getNome().equals(area)) ? ("selected='" + areasAtuacao.get(i).getNome() + "'") : ""%>><%=areasAtuacao.get(i).getNome()%></option>                            
                                <%       }
                                    }%>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Curso:
                        </td>
                        <td>
                            <select name="lstCurso" required="true">
                                <option value="" "Selecione"<%= ("Selecione".equals(curso)) ? ("selected='Selecione'") : ""%>>Selecione</option>
                                <option value="Sistemas de Informação"<%= ("Sistemas de Informação".equals(curso)) ? ("selected='Sistemas de Informação'") : ""%>>Sistemas de Informa&ccedil;&atilde;o</option>
                                <option value="Ciência da Computação"<%= ("Ciência da Computação".equals(curso)) ? ("selected='Ciência da Computação'") : ""%>>Ci&ecirc;ncia da Computa&ccedil;&atilde;o</option>
                                <option value="ADS"<%= ("ADS".equals(curso)) ? ("selected='ADS'") : ""%>>ADS</option>
                            </select>                                                        
                        </td>
                    </tr>
                    <tr> </br> </tr>
                    <tr>

                        <td></br>
                            <a href="MeusDados.jsp">
                                Voltar
                            </a>
                        </td>
                        <td> &nbsp;</td>
                        <td> <input type="submit" value="Finalizar" /> </td>
                    </tr>
                </table>
            </div>
        </form>
    </body>
</html>

