/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import bean.*;
import interfaces.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "ValidarUsuario", urlPatterns = {"/ValidarUsuario"})
public class ValidarUsuario extends HttpServlet {

    @EJB
    private LUsuarioLocal lUsuario;
    @EJB
    private RVagasUsuarioRemote rVagasUsuario;
    @EJB
    private RVagasRemote rVagas;
    @EJB
    private RAreaAtuacaoRemote rAreaAtuacao;
    @EJB
    private RUniversidadeRemote rUniversidade;
    @EJB
    private REmpresaRemote rEmpresas;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {

            String email = (String) request.getParameter("emailLogin");
            String senha = (String) request.getParameter("senhaLogin");



            Usuario usuario = new Usuario();
            usuario.setEmail(email);
            usuario.setSenha(senha);


            try {
                usuario = this.lUsuario.pegarDados(usuario);

                List<VagasUsuario> vagasUsuario;
                VagasUsuario vagasUser = new VagasUsuario();
                vagasUser.setIdUsuario(usuario.getId());

                vagasUsuario = rVagasUsuario.buscarVagasUsuario(vagasUser);
                List<Vagas> listaVagaUsuario = new ArrayList<Vagas>();
                if (vagasUsuario != null && !vagasUsuario.isEmpty()) {
                    Vagas vaga = new Vagas();
                    for (int i = 0; i < vagasUsuario.size(); i++) {
                        vaga = rVagas.trazVaga(vagasUsuario.get(i).getIdVaga());
                        listaVagaUsuario.add(vaga);
                    }
                }

                if (usuario != null) {
                    request.getSession().setAttribute("usuario", usuario);
                    request.getSession().setAttribute("vagasUsuario", listaVagaUsuario);

                    List<AreaAtuacao> areasAtuacao = this.rAreaAtuacao.consultar();
                    if (areasAtuacao != null) {
                        request.getSession().setAttribute("AreasAtuacao", areasAtuacao);
                    }

                    List<Universidade> universidade = this.rUniversidade.consultar();
                    if (universidade != null) {
                        request.getSession().setAttribute("Universidade", universidade);
                    }

                    List<Empresa> empresa = this.rEmpresas.consultarTodas();
                    if (empresa != null) {
                        request.getSession().setAttribute("Empresa", empresa);
                    }
                    response.sendRedirect(response.encodeRedirectURL("Home.jsp"));
                } else {
                    response.sendRedirect(response.encodeRedirectURL("UsuarioInexistente.jsp"));
                }

            } catch (Exception ex) {

                Logger.getLogger(ValidarUsuario.class.getName()).log(Level.SEVERE, null, ex);
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
