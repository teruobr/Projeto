<%-- 
    Document   : Experiencias
    Created on : 31/10/2012, 11:32:12
  
--%>

<%@page import="bean.Experiencias"%>
<%@page import="bean.Empresa"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <script LANGUAGE="JavaScript">
        function textCounter(field, countfield, maxlimit) {
            if (field.value.length > maxlimit)
                field.value = field.value.substring(0, maxlimit);
            else 
                countfield.value = maxlimit - field.value.length;
        }
        
        //valida o CNPJ digitado
        function ValidarCNPJ(){
            var empresa =document.f1.lstEmpresa.value;
            if(empresa == "Selecione" ){
                var cnpj = document.f1.cnpj.value;
                var valida = new Array(6,5,4,3,2,9,8,7,6,5,4,3,2);
                var dig1= new Number;
                var dig2= new Number;
        
                exp = /\.|\-|\//g
                cnpj = cnpj.toString().replace( exp, "" ); 
                var digito = new Number(eval(cnpj.charAt(12)+cnpj.charAt(13)));
                
                for(i = 0; i<valida.length; i++){
                    dig1 += (i>0? (cnpj.charAt(i-1)*valida[i]):0);  
                    dig2 += cnpj.charAt(i)*valida[i];       
                }
                dig1 = (((dig1%11)<2)? 0:(11-(dig1%11)));
                dig2 = (((dig2%11)<2)? 0:(11-(dig2%11)));
        
                if(((dig1*10)+dig2) != digito)  {
                    alert('CNPJ Invalido ou Empresa não informada!');
                    return false;
                }else{
                    var descricao =document.f1.message.value;
                    if (descricao == "" || descricao ==null){
                        alert('Descrição não informada!');
                        return false;
                    }else
                        return true;
                }
          
            }else{
                var descricao =document.f1.message.value;
                if (descricao == "" || descricao == null){
                    alert('Descrição não informada!');
                    return false;
                }else
                    return true;
            }
                
        }


        function txtBoxFormat(strField, sMask, evtKeyPress) {
            var i, nCount, sValue, fldLen, mskLen,bolMask, sCod, nTecla;
   
            if(document.all) { // Internet Explorer
                nTecla = evtKeyPress.keyCode;
            }
            else if(document.layers) { // Nestcape
                nTecla = evtKeyPress.which;
            }
            else if(document.getElementById) { // FireFox
                nTecla = evtKeyPress.which;
            }
   
            if (nTecla != 8) {
   
                sValue = document.getElementById(strField).value;
   
                // Limpa todos os caracteres de formatação que
                // já estiverem no campo.
                sValue = sValue.toString().replace( "-", "" );
                sValue = sValue.toString().replace( "-", "" );
                sValue = sValue.toString().replace( ".", "" );
                sValue = sValue.toString().replace( ".", "" );
                sValue = sValue.toString().replace( "/", "" );
                sValue = sValue.toString().replace( "/", "" );
                sValue = sValue.toString().replace( "(", "" );
                sValue = sValue.toString().replace( "(", "" );
                sValue = sValue.toString().replace( ")", "" );
                sValue = sValue.toString().replace( ")", "" );
                sValue = sValue.toString().replace( " ", "" );
                sValue = sValue.toString().replace( " ", "" );
                sValue = sValue.toString().replace( ":", "" );
                fldLen = sValue.length;
                mskLen = sMask.length;
   
                i = 0;
                nCount = 0;
                sCod = "";
                mskLen = fldLen;
   
                while (i <= mskLen) {
                    bolMask = ((sMask.charAt(i) == "-") || (sMask.charAt(i) == ".") || (sMask.charAt(i) == "/"))
                    bolMask = bolMask || ((sMask.charAt(i) == "(") || (sMask.charAt(i) == ")") || (sMask.charAt(i) == " "))
                    bolMask = bolMask || (sMask.charAt(i) == ":")
   
                    if (bolMask) {
                        sCod += sMask.charAt(i);
                        mskLen++; }
                    else {
                        sCod += sValue.charAt(nCount);
                        nCount++;
                    }
   
                    i++;
                }
   
                //objForm[strField].value = sCod;
                document.getElementById(strField).value = sCod;
   
                if (nTecla != 8) { // backspace
                    if (sMask.charAt(i-1) == "9") { // apenas números...
                        return ((nTecla > 47) && (nTecla < 58)); } // números de 0 a 9
                    else { // qualquer caracter...
                        return true;
                    }
                }
                else {
                    return true;
                }
            }
        }
    </script>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Minhas Experi&ecirc;ncias</title>
    </head>

    <%
        List<Empresa> empresas = (List<Empresa>) request.getSession().getAttribute("Empresa");
        List<Experiencias> ExperienciasUsuario = (List<Experiencias>) request.getSession().getAttribute("listaExp");
    %>
    <body>
        <form action="CadastraExperiencia" method="post" name="f1">
            <jsp:include page="MenuLogado.jsp"/>
            <div id ="alinhaTexto" >
                <h1>Minhas Experi&ecirc;ncias</h1>
                <br>
                Selecione uma Empresa "ou" preencha o CNPJ, juntamente com a descrição de sua experiência profissional.

                <table>

                    <tr>
                        <td>
                            Empresa:
                        </td>
                        <td>
                            <select name="lstEmpresa" >
                                <option value="Selecione" >Selecione</option>                               

                                <% if (empresas != null) {
                                        for (int i = 0; i < empresas.size(); i++) {

                                %>
                                <option value="<%=empresas.get(i).getCnpj()%>"><%=empresas.get(i).getNome()%></option>                            
                                <%       }
                                    }%>
                            </select>
                        </td>
                        <td>CNPJ:</td>
                        <td>
                            <input  type="text"  name="cnpj" id="cnpj" onKeyPress="return txtBoxFormat(this.id, '99.999.999/9999-99',event);" maxlength="18" />
                        </td>
                    </tr>
                    <br>

                    </tr>
                    <tr>
                        <td>Descrição:</td>
                        <td>
                            <font size="1" face="arial, helvetica, sans-serif"> ( Limite de 255 caracteres. )<br>
                            <textarea name=message wrap=physical cols=50 rows=10 onKeyDown="textCounter(this.form.message,this.form.remLen,255);" onKeyUp="textCounter(this.form.message,this.form.remLen,255);"></textarea>

                            <br>
                            Faltam&nbsp;<input readonly type=text name=remLen size=3 maxlength=3 value="255"></font>
                        </td>

                    </tr>

                    <br>
                    <tr>

                        <td>&nbsp;</td>
                        <td colspan="2" style="float:right;">
                            <input type="submit" value="Adicionar" onclick="if(ValidarCNPJ()) return true; else return false;" />
                        </td>
                    </tr>


                </table>
                <br><br>

                <% if (ExperienciasUsuario == null || ExperienciasUsuario.isEmpty()) {%>

                <%} else {
                %>
                <table border ="2p">
                    <tr>
                        <td>
                            Empresa &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        </td>
                        <td>
                            Descri&ccedil;&atilde;o &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        </td>

                        <td>
                            Status &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        </td>


                    </tr>

                    <%
                        
                        if (ExperienciasUsuario != null && !ExperienciasUsuario.isEmpty()) {
                            // for (int i = 0; i < vagasUsuario.size(); i++) {
                            int i = 0;
                            do {
                                String nomeEmpresa = "Empresa não cadastrada";;

                    %>
                    <TR> 
                       <% if (ExperienciasUsuario.get(i).getNome() != null) {
                                    nomeEmpresa = String.valueOf(ExperienciasUsuario.get(i).getNome());
                                } 
         %>
                        <TD><%=nomeEmpresa%></TD>
                        
                        
                        <TD><%=String.valueOf(ExperienciasUsuario.get(i).getDescricaoExperiencia())%></TD>
                        <TD><%=String.valueOf(ExperienciasUsuario.get(i).getStatus())%></TD>

                    </TR> 


                    <%
                                    i++;
                                } while (i < ExperienciasUsuario.size());
                            }
                        }%>

                </table>

            </div>          
        </form>
    </body>
</html>
