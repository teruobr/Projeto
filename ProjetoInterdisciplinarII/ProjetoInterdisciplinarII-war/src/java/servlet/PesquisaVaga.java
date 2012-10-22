/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import bean.Vagas;
import interfaces.RVagasRemote;
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
 * @author Felipe
 */
@WebServlet(name = "PesquisaVaga", urlPatterns = {"/PesquisaVaga"})
public class PesquisaVaga extends HttpServlet {
    
    @EJB
    private RVagasRemote rVagas;

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String titulo = request.getParameter("txtTitulo");
            String nivel = request.getParameter("lstNivel");
            String area = request.getParameter("lstArea");
            String estado = request.getParameter("lstEstado");
            String cidade = request.getParameter("lstCidade");



            Vagas busca = new Vagas();
            busca.setTitulo(titulo);
            busca.setAreaAtuacao(area);
            busca.setNivelAtuacao(nivel);
            busca.setEstado(estado);
            busca.setCidade(cidade);
            

            try {
                List<Vagas> listaVagas;
                
                listaVagas = rVagas.consultarWeb(busca);
                
                
                if (listaVagas != null && !listaVagas.isEmpty()) {

                    request.getSession().setAttribute("listaVagas", listaVagas);
                    response.sendRedirect(response.encodeRedirectURL("Vagas.jsp"));
                } else {
                    response.sendRedirect(response.encodeRedirectURL("PesquisaInexistente.jsp"));
                }




            } catch (Exception ex) {

                ex.printStackTrace();
                response.sendRedirect(response.encodeRedirectURL("PesquisaInexistente.jsp"));
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
