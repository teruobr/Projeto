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
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 31010296
 */
@WebServlet(name = "DetalheVaga", urlPatterns = {"/DetalheVaga"})
public class DetalheVaga extends HttpServlet {

    @EJB
    private REmpresaRemote rEmpresa;
    @EJB
    private RVagasRemote rVagas;
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            
            
            Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
            //Vagas vaga = (Vagas) request.getSession().getAttribute("vaga");
            long idEmpresa = Long.parseLong(request.getParameter("idEmpresa"));
            long idVaga = Long.parseLong(request.getParameter("idVaga"));
            //List<Vagas> vagasUsuario = (List<Vagas>) request.getSession().getAttribute("vagasUsuario");
        
        
            Empresa company = new Empresa();
            company.setId(idEmpresa);
            
            Vagas vagaSelecionada = new Vagas();
            vagaSelecionada.setId(idVaga);
            
            company = rEmpresa.consultarID(company);
            vagaSelecionada = rVagas.consultarID(vagaSelecionada);
            
            if (company != null && vagaSelecionada !=null) {

                    request.getSession().setAttribute("usuario", usuario);
                    request.getSession().setAttribute("empresa", company);
                    request.getSession().setAttribute("vaga", vagaSelecionada);
                    //request.getSession().setAttribute("listaVagas", listaVagas);
                    response.sendRedirect(response.encodeRedirectURL("VagaUsuario.jsp"));
                } else {
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
