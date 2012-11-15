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
import java.util.List;
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
@WebServlet(name = "ConsultaEmpresas", urlPatterns = {"/ConsultaEmpresas"})
public class ConsultaEmpresas extends HttpServlet {

     @EJB
     private REmpresaRemote rEmpresas;
     @EJB
     private RExperienciasRemote rExperiencias;
     
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
        try {
           if (usuario != null) {
                    
                     if (this.rEmpresas.consultarTodas() != null) {
                        List<Empresa> Empresa = this.rEmpresas.consultarTodas();
                        request.getSession().setAttribute("Empresa", Empresa);
                     }
                     
                      Experiencias exp = new Experiencias();
                      exp.setIdUsuario(usuario.getId());
                      if (this.rExperiencias.consultar(exp) != null) {
                        List<Experiencias> listaExp = this.rExperiencias.consultar(exp);
                        request.getSession().setAttribute("listaExp", listaExp);
                     }
                     
                    response.sendRedirect(response.encodeRedirectURL("Experiencias.jsp"));
                } else {
                    response.sendRedirect(response.encodeRedirectURL("UsuarioInexistente.jsp"));
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
