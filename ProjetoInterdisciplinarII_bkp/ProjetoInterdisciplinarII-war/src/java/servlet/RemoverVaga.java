/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import bean.Empresa;
import bean.Usuario;
import bean.Vagas;
import bean.VagasUsuario;
import interfaces.RVagasUsuarioRemote;
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
 * @author Administrator
 */
@WebServlet(name = "RemoverVaga", urlPatterns = {"/RemoverVaga"})
public class RemoverVaga extends HttpServlet {
    
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
            List<Vagas> listaVagaUsuario = (List<Vagas>) request.getSession().getAttribute("vagasUsuario");
            
            VagasUsuario vagaUsuario = new VagasUsuario();
            vagaUsuario.setIdVaga(vaga.getId());
            vagaUsuario.setIdEmpresa(empresa.getId());
            vagaUsuario.setIdUsuario(usuario.getId());
            
            
            vagaUsuario = this.rVagasUsuario.validaUsuarioVaga(vagaUsuario);
            if (vagaUsuario != null) {
                rVagasUsuario.excluir(vagaUsuario);
                listaVagaUsuario.remove(vaga);
                request.getSession().setAttribute("vagasUsuario", listaVagaUsuario);
                response.sendRedirect(response.encodeRedirectURL("VagaRemovidaSucesso.jsp"));
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
