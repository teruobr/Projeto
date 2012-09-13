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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 31049184
 */
public class CadastraUsuario extends HttpServlet {
    @EJB
    private LUsuarioLocal lUsuario;

     
    protected void  processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String nome = (String) request.getParameter("nome");
       
            /*/    String nome = (String) getsession.getAttribute("nome");
            String rg = (String) session.getAttribute("rg");
            String sexo = (String) session.getAttribute("sexo");
            String estado = (String) session.getAttribute("estado");
            String cidade = (String) session.getAttribute("cidade");
            String bairro = (String) session.getAttribute("bairro");
            String endereco = (String) session.getAttribute("endereco");
            String celular = (String) session.getAttribute("celular");
            String telefone = (String) session.getAttribute("telefone");
            String escolaridade = (String) session.getAttribute("escolaridade");
            String nivel = (String) session.getAttribute("nivel");
            String area = (String) session.getAttribute("area");
            String faculdade = (String) session.getAttribute("faculdade");
            String curso = (String) session.getAttribute("curso");*/
           
            Usuario usuario = new Usuario ();
            usuario.setNome(nome);
            usuario.setCidade("felipe");
            usuario.setCurso("felipeteste");
            usuario.setCelular("1213485");
            lUsuario.incluir(usuario);
           
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CadastraUsuario</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CadastraUsuario at " + nome + "</h1>");
            out.println("</body>");
            out.println("</html>");
            
           
           
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
