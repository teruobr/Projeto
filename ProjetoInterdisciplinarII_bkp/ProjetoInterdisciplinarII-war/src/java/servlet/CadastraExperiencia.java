/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import bean.Empresa;
import bean.Experiencias;
import bean.Usuario;
import interfaces.REmpresaRemote;
import interfaces.RExperienciasRemote;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author U0155712
 */
@WebServlet(name = "CadastraExperiencia", urlPatterns = {"/CadastraExperiencia"})
public class CadastraExperiencia extends HttpServlet {

    @EJB
    private RExperienciasRemote rExperienciasRemote;
    @EJB
    private REmpresaRemote rEmpresas;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
        String CNPJ = (String) request.getParameter("cnpj");
        String descricao = (String) request.getParameter("message").replaceAll("(\n|\r)+", "");
        String empresaCNPJ = request.getParameter("lstEmpresa");

        try {


            try {

                Experiencias exp = new Experiencias();
                exp.setIdUsuario(usuario.getId());
                exp.setDescricaoExperiencia(descricao);
                exp.setStatus("AGUARDANDO APROVAÇÃO");
                if (CNPJ != null) {
                    exp.setCNPJ(CNPJ);
                }
                if (!empresaCNPJ.equals("Selecione")) {
                    exp.setCNPJ(empresaCNPJ);
                }



                Empresa emp = new Empresa();
                emp.setCnpj(exp.getCNPJ());

                if (this.rEmpresas.consultar(emp) != null) {
                    Empresa empresa = this.rEmpresas.consultar(emp);

                    exp.setNome(empresa.getNome());
                }

                this.rExperienciasRemote.incluir(exp);
                response.sendRedirect(response.encodeRedirectURL("ExperienciaSucesso.jsp"));


            } catch (Exception ex) {

                ex.printStackTrace();
                response.sendRedirect(response.encodeRedirectURL("ExperienciaSemSucesso.jsp"));
            }



        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
