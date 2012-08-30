package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class DadosCadastrais_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.Vector _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"Estilo.css\" type=\"text/css\">\n");
      out.write("        <title>Cadastro de novo usuário</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <form action=\"CadastroSucesso.jsp\" method=\"post\">\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, false);
      out.write("\n");
      out.write("            <h1>Dados Cadastrais</h1>\n");
      out.write("            <br>\n");
      out.write("            Preencha os campos abaixo para finalizar o seu cadastro.\n");
      out.write("            <table>\n");
      out.write("                <tr>\n");
      out.write("                    <td>\n");
      out.write("                        RG:\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        <input  type=\"text\" name=\"txtRG\"/>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>\n");
      out.write("                        Sexo:\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        <select name=\"lstSexo\">\n");
      out.write("                            <option value=\"M\">Masculino</option>\n");
      out.write("                            <option value=\"F\">Feminino</option>\n");
      out.write("                        </select>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>\n");
      out.write("                        Estado:\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        <select name=\"lstEstado\">\n");
      out.write("                            <option value=\"SP\">São Paulo </option>\n");
      out.write("                        </select>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>\n");
      out.write("                        Cidade:\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        <select name=\"lstCidade\">\n");
      out.write("                            <option value=\"Sp\">São Paulo</option>\n");
      out.write("                            <option value=\"StoA\">Santo André</option>\n");
      out.write("                            <option value=\"Sbc\">São Bernardo do Campo</option>\n");
      out.write("                            <option value=\"Sc\">São Caetano do Sul</option>\n");
      out.write("                        </select>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>\n");
      out.write("                        Bairro:\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        <input type=\"text\" name=\"txtBairro\"/>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>\n");
      out.write("                        Endereço:\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        <input type=\"text\" name=\"txtEndereco\"/>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>\n");
      out.write("                        Celular:\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        (<input type=\"text\" name=\"txtDDDCel\" maxlength=\"2\" width=\"5px\"/>) <input type=\"text\" name=\"txtCel\" maxlength=\"9\"/>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>\n");
      out.write("                        Telefone:\n");
      out.write("                    </td><td>\n");
      out.write("                        (<input type=\"text\" name=\"txtDDDTel\" maxlength=\"2\" size=\"5px\" />) <input type=\"text\" name=\"txtTel\" maxlength=\"8\"/>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>\n");
      out.write("                        Grau de Escolaridade:\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        <select name=\"lstEscolaridade\">\n");
      out.write("                            <option value=\"Tecnico\">Técnico</option>\n");
      out.write("                            <option value=\"SuperiorInc\">Superior Incompleto</option>\n");
      out.write("                            <option value=\"SuperiorCom\">Superior Completo</option>\n");
      out.write("                            <option value=\"Pos\">Pós-Graduado</option>\n");
      out.write("                        </select>\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        Nível de Atuação:\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        <select name=\"lstNivel\">\n");
      out.write("                            <option value=\"Tecnico\">Técnico</option>\n");
      out.write("                            <option value=\"Estagiario\">Estagiário</option>\n");
      out.write("                            <option value=\"Jr\">Júnior</option>\n");
      out.write("                            <option value=\"Pleno\">Pleno</option>\n");
      out.write("                            <option value=\"Senior\">Senior</option>\n");
      out.write("                            <option value=\"Gerente\">Gerente </option>\n");
      out.write("                        </select>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>\n");
      out.write("                        Faculdade:\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        <select name=\"lstFaculdade\">\n");
      out.write("                            <option value=\"Mackenzie\">Universidade Mackenzie</option>\n");
      out.write("                        </select>\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        Área de Atuação:\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        <select name=\"lstArea\">\n");
      out.write("                            <option value=\"Suporte\">Suporte</option>\n");
      out.write("                            <option value=\"Programacao\">Programação</option>\n");
      out.write("                            <option value=\"Analise\">Análise</option>\n");
      out.write("                            <option value=\"Projeto\">Projetos</option>\n");
      out.write("                        </select>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>\n");
      out.write("                        Curso:\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        <select name=\"lstCurso\">\n");
      out.write("                            <option value=\"SI\">Sistemas de Informação</option>\n");
      out.write("                            <option value=\"CC\">Ciências da Computação</option>\n");
      out.write("                        </select>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td colspan=\"2\">\n");
      out.write("                        <input type=\"submit\" value=\"Finalizar\"/>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("            </table>\n");
      out.write("\n");
      out.write("        </form>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
