/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import bean.Empresa;
import bean.Usuario;
import bean.Vagas;
import bean.VagasUsuario;
import interfaces.RVagasUsuario;
import interfaces.RVagasUsuarioRemote;
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
 * @author Felipe
 */
@WebServlet(name = "CandidatarUsuario", urlPatterns = {"/CandidatarUsuario"})
public class CandidatarUsuario extends HttpServlet {

    @EJB
    private RVagasUsuarioRemote rVagasUsuario;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
            Vagas vaga = (Vagas) request.getSession().getAttribute("vaga");
            Empresa empresa = (Empresa) request.getSession().getAttribute("empresa");

            VagasUsuario vagaUsuario = new VagasUsuario();
            vagaUsuario.setIdVaga(vaga.getId());
            vagaUsuario.setIdEmpresa(empresa.getId());
            vagaUsuario.setIdUsuario(usuario.getId());


            try {


                if (this.rVagasUsuario.validaUsuarioVaga(vagaUsuario) != null) {

                    response.sendRedirect(response.encodeRedirectURL("CandidatoExistente.jsp"));
                } else {

                    
                    this.rVagasUsuario.incluir(vagaUsuario);

                    request.getSession().setAttribute("vaga", vaga);
                    request.getSession().setAttribute("empresa", empresa);
                    request.getSession().setAttribute("usuario", usuario);
                    response.sendRedirect(response.encodeRedirectURL("CandidatoSucesso.jsp"));

                }

            } catch (Exception ex) {

                ex.printStackTrace();
                response.sendRedirect(response.encodeRedirectURL("CandidatoExistente.jsp"));
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
