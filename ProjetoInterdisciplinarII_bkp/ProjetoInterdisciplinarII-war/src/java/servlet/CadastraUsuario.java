/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import bean.AreaAtuacao;
import bean.Universidade;
import bean.Usuario;
import interfaces.LUsuarioLocal;
import interfaces.RAreaAtuacaoRemote;
import interfaces.RUniversidadeRemote;
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
 * @author 31049184
 */
@WebServlet(name = "CadastraUsuario", urlPatterns = {"/CadastraUsuario"})
public class CadastraUsuario extends HttpServlet {

    @EJB
    private LUsuarioLocal lUsuario;
    @EJB
    private RAreaAtuacaoRemote rAreaAtuacao;
    @EJB
    private RUniversidadeRemote rUniversidade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String nome = (String) request.getParameter("txtNome");
            String email = (String) request.getParameter("txtEmail");
            String senha = (String) request.getParameter("txtSenha");



            Usuario usuario = new Usuario();
            usuario.setNome(nome);
            usuario.setEmail(email);
            usuario.setSenha(senha);


            try {



                if (this.lUsuario.consultar(usuario) != null) {

                    response.sendRedirect(response.encodeRedirectURL("UsuarioExistente.jsp"));
                } else {

                    //usuario = this.lUsuario.consultar(usuario);
                    this.lUsuario.incluir(usuario);
                    request.getSession().setAttribute("txtNome", usuario.getNome());
                    request.getSession().setAttribute("txtSenha", usuario.getSenha());
                    request.getSession().setAttribute("txtEmail", usuario.getEmail());
                    request.getSession().setAttribute("usuario", usuario);
                    
                    if (this.rAreaAtuacao.consultar() != null) {
                        List<AreaAtuacao> AreasAtuacao = this.rAreaAtuacao.consultar();
                        request.getSession().setAttribute("AreasAtuacao", AreasAtuacao);
                    }
                    if (this.rUniversidade.consultar() != null) {
                        List<Universidade> Universidade = this.rUniversidade.consultar();
                        request.getSession().setAttribute("Universidade", Universidade);
                    }
                    response.sendRedirect(response.encodeRedirectURL("DadosCadastrais.jsp"));
                    
                    

                }

                }  catch (Exception ex) {

                ex.printStackTrace();
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
