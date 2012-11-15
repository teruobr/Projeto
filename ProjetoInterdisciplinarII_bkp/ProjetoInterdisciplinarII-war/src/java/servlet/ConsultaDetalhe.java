/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import bean.Empresa;
import bean.Usuario;
import bean.Vagas;
import interfaces.REmpresaRemote;
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
@WebServlet(name = "ConsultaDetalhe", urlPatterns = {"/ConsultaDetalhe"})
public class ConsultaDetalhe extends HttpServlet {

    @EJB
    private REmpresaRemote rEmpresa;
    @EJB
    private RVagasRemote rVagas;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
        //Vagas vaga = (Vagas) request.getSession().getAttribute("vaga");
        long idEmpresa = Long.parseLong(request.getParameter("idEmpresa"));
        long idVaga = Long.parseLong(request.getParameter("idVaga"));
        List<Vagas> listaVagas = (List<Vagas>) request.getSession().getAttribute("listaVagas");
                
        
        try {
            Empresa company = new Empresa();
            company.setId(idEmpresa);
            
            Vagas vagaSelecionada = new Vagas();
            vagaSelecionada.setId(idVaga);
            
            
            try {
                Empresa empresa;
                Vagas vaga;
                
                System.out.print("Vaga:" + idVaga);
                System.out.print("Empresa:" + idEmpresa);
                System.out.print("Usuario:" + usuario.getId());
                
                empresa = rEmpresa.consultarID(company);
                vaga = rVagas.consultarID(vagaSelecionada);
                            
                
                if (empresa != null && vaga !=null) {

                    request.getSession().setAttribute("usuario", usuario);
                    request.getSession().setAttribute("empresa", empresa);
                    request.getSession().setAttribute("vaga", vaga);
                    request.getSession().setAttribute("listaVagas", null);
                    response.sendRedirect(response.encodeRedirectURL("VerDetalhe.jsp"));
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
