/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import bean.Usuario;
import interfaces.LUsuarioLocal;
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
@WebServlet(name = "AtualizaCadastro", urlPatterns = {"/AtualizaCadastro"})
public class AtualizaCadastro extends HttpServlet {
    
    @EJB
    private LUsuarioLocal lUsuario;

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            
            String nome = (String) request.getSession().getAttribute("txtNome");
            String email = (String) request.getSession().getAttribute("txtEmail");
            String senha = (String) request.getSession().getAttribute("txtSenha");
            Usuario usuario =  (Usuario) request.getSession().getAttribute("usuario");
            
            String rg = request.getParameter("txtRg");
            String estado = request.getParameter("lstEstado");
            String cidade = request.getParameter("lstCidade");
            String bairro = request.getParameter("txtBairro");
            String endereco = request.getParameter("txtEndereco");
            String DDDcelular = request.getParameter("txtDDDCel");
            String celular = request.getParameter("txtCel");
            String DDDtelefone = request.getParameter("txtDDDTel");
            String telefone = request.getParameter("txtTel");
            String escolaridade = request.getParameter("lstEscolaridade");
            String nivel = request.getParameter("lstNivel");
            String area = request.getParameter("lstArea");
            String faculdade = request.getParameter("lstFaculdade");
            String curso = request.getParameter("lstCurso");
            
            usuario.setRg(rg);
            usuario.setEstado(estado);
            usuario.setCidade(cidade);
            usuario.setBairro(bairro);
            usuario.setEndereco(endereco);
            usuario.setCelular(DDDcelular + celular);
            usuario.setTelefone(DDDtelefone + telefone);
            usuario.setEscolaridade(escolaridade);
            usuario.setNivel(nivel);
            usuario.setArea(area);
            usuario.setFaculdade(faculdade);
            usuario.setCurso(curso);
            
            try {

                this.lUsuario.alterar(usuario);
                response.sendRedirect(response.encodeRedirectURL("AtualizadoSucesso.jsp"));



            } catch (Exception ex) {

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
