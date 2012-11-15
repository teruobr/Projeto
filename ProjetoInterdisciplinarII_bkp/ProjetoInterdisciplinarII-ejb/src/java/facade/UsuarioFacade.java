/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import bean.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Felipe
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {

    @PersistenceContext(unitName = "ProjetoInterdisciplinarII-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    
    public Usuario getConsultaUsuarioID(long id) {
        try {
            return (Usuario) em.createQuery("SELECT OBJECT(u) FROM Usuario u  WHERE  u.id='" + id +"' ORDER BY u.nome").getSingleResult();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public Usuario getLogin(String email, String senha) {

        try {
            return (Usuario) em.createQuery("SELECT OBJECT(u) FROM Usuario u  WHERE  u.email='" + email + "' and u.senha ='" + senha + "'").getSingleResult();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public Usuario getEmail(String email) {

        try {
            return (Usuario) em.createQuery("SELECT OBJECT(u) FROM Usuario u  WHERE  u.email='" + email + "'").getSingleResult();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public List<Usuario> getConsultaUsuario(Usuario usuario) {
        try {
            if (!usuario.getArea().trim().equals("Selecione") && !usuario.getNivel().trim().equals("Selecione") && !usuario.getCidade().trim().equals("Selecione") && !usuario.getEstado().trim().equals("Selecione") && !usuario.getEscolaridade().trim().equals("Selecione") && !usuario.getCurso().trim().equals("Selecione")) {
                return (List<Usuario>) em.createQuery("SELECT OBJECT(u) FROM Usuario u  WHERE  u.escolaridade='" + usuario.getEscolaridade() + "'"
                        + "and u.curso='" + usuario.getCurso() + "'"
                        + "and u.area='" + usuario.getArea() + "'"
                        + "and u.nivel='" + usuario.getNivel() + "'"
                        + "and u.cidade='" + usuario.getCidade() + "'"
                        + "and u.estado='" + usuario.getEstado() + "'").getResultList();
            } else if (!usuario.getArea().trim().equals("Selecione") && usuario.getNivel().trim().equals("Selecione") && usuario.getCidade().trim().equals("Selecione") && usuario.getEstado().trim().equals("Selecione") && usuario.getEscolaridade().trim().equals("Selecione") && usuario.getCurso().trim().equals("Selecione")) {
                return (List<Usuario>) em.createQuery("SELECT OBJECT(u) FROM Usuario u  WHERE  u.area='" + usuario.getArea() + "'").getResultList();

            } else if (usuario.getArea().trim().equals("Selecione") && !usuario.getNivel().trim().equals("Selecione") && usuario.getCidade().trim().equals("Selecione") && usuario.getEstado().trim().equals("Selecione") && usuario.getEscolaridade().trim().equals("Selecione") && usuario.getCurso().trim().equals("Selecione")) {
                return (List<Usuario>) em.createQuery("SELECT OBJECT(u) FROM Usuario u  WHERE  u.nivel='" + usuario.getNivel() + "'").getResultList();

            } else if (usuario.getArea().trim().equals("Selecione") && usuario.getNivel().trim().equals("Selecione") && !usuario.getCidade().trim().equals("Selecione") && usuario.getEstado().trim().equals("Selecione") && usuario.getEscolaridade().trim().equals("Selecione") && usuario.getCurso().trim().equals("Selecione")) {
                return (List<Usuario>) em.createQuery("SELECT OBJECT(u) FROM Usuario u  WHERE  u.cidade='" + usuario.getCidade() + "'").getResultList();

            } else if (usuario.getArea().trim().equals("Selecione") && usuario.getNivel().trim().equals("Selecione") && usuario.getCidade().trim().equals("Selecione") && !usuario.getEstado().trim().equals("Selecione") && usuario.getEscolaridade().trim().equals("Selecione") && usuario.getCurso().trim().equals("Selecione")) {
                return (List<Usuario>) em.createQuery("SELECT OBJECT(u) FROM Usuario u  WHERE  u.estado='" + usuario.getEstado() + "'").getResultList();

            } else if (usuario.getArea().trim().equals("Selecione") && usuario.getNivel().trim().equals("Selecione") && usuario.getCidade().trim().equals("Selecione") && usuario.getEstado().trim().equals("Selecione") && !usuario.getEscolaridade().trim().equals("Selecione") && usuario.getCurso().trim().equals("Selecione")) {
                return (List<Usuario>) em.createQuery("SELECT OBJECT(u) FROM Usuario u  WHERE  u.escolaridade='" + usuario.getEscolaridade() + "'").getResultList();

            } else if (usuario.getArea().trim().equals("Selecione") && usuario.getNivel().trim().equals("Selecione") && usuario.getCidade().trim().equals("Selecione") && usuario.getEstado().trim().equals("Selecione") && usuario.getEscolaridade().trim().equals("Selecione") && !usuario.getCurso().trim().equals("Selecione")) {
                return (List<Usuario>) em.createQuery("SELECT OBJECT(u) FROM Usuario u  WHERE  u.curso='" + usuario.getCurso() + "'").getResultList();

            } else if (!usuario.getArea().trim().equals("Selecione") && !usuario.getNivel().trim().equals("Selecione") && usuario.getCidade().trim().equals("Selecione") && usuario.getEstado().trim().equals("Selecione") && usuario.getEscolaridade().trim().equals("Selecione") && usuario.getCurso().trim().equals("Selecione")) {
                return (List<Usuario>) em.createQuery("SELECT OBJECT(u) FROM Usuario u  WHERE  u.area='" + usuario.getArea() + "'"
                        + "and u.nivel='" + usuario.getNivel() + "'").getResultList();

            } else if (!usuario.getArea().trim().equals("Selecione") && usuario.getNivel().trim().equals("Selecione") && !usuario.getCidade().trim().equals("Selecione") && usuario.getEstado().trim().equals("Selecione") && usuario.getEscolaridade().trim().equals("Selecione") && usuario.getCurso().trim().equals("Selecione")) {
                return (List<Usuario>) em.createQuery("SELECT OBJECT(u) FROM Usuario u  WHERE  u.area='" + usuario.getArea() + "'"
                        + "and u.cidade='" + usuario.getCidade() + "'").getResultList();

            } else if (!usuario.getArea().trim().equals("Selecione") && usuario.getNivel().trim().equals("Selecione") && usuario.getCidade().trim().equals("Selecione") && !usuario.getEstado().trim().equals("Selecione") && usuario.getEscolaridade().trim().equals("Selecione") && usuario.getCurso().trim().equals("Selecione")) {
                return (List<Usuario>) em.createQuery("SELECT OBJECT(u) FROM Usuario u  WHERE  u.area='" + usuario.getArea() + "'"
                        + "and u.estado='" + usuario.getEstado() + "'").getResultList();

            } else if (!usuario.getArea().trim().equals("Selecione") && usuario.getNivel().trim().equals("Selecione") && usuario.getCidade().trim().equals("Selecione") && usuario.getEstado().trim().equals("Selecione") && !usuario.getEscolaridade().trim().equals("Selecione") && usuario.getCurso().trim().equals("Selecione")) {
                return (List<Usuario>) em.createQuery("SELECT OBJECT(u) FROM Usuario u  WHERE  u.area='" + usuario.getArea() + "'"
                        + "and u.escolaridade='" + usuario.getEscolaridade() + "'").getResultList();

            } else if (!usuario.getArea().trim().equals("Selecione") && usuario.getNivel().trim().equals("Selecione") && usuario.getCidade().trim().equals("Selecione") && usuario.getEstado().trim().equals("Selecione") && usuario.getEscolaridade().trim().equals("Selecione") && !usuario.getCurso().trim().equals("Selecione")) {
                return (List<Usuario>) em.createQuery("SELECT OBJECT(u) FROM Usuario u  WHERE  u.area='" + usuario.getArea() + "'"
                        + "and u.curso='" + usuario.getCurso() + "'").getResultList();

            } else if (usuario.getArea().trim().equals("Selecione") && !usuario.getNivel().trim().equals("Selecione") && !usuario.getCidade().trim().equals("Selecione") && usuario.getEstado().trim().equals("Selecione") && usuario.getEscolaridade().trim().equals("Selecione") && usuario.getCurso().trim().equals("Selecione")) {
                return (List<Usuario>) em.createQuery("SELECT OBJECT(u) FROM Usuario u  WHERE  u.nivel='" + usuario.getNivel() + "'"
                        + "and u.cidade='" + usuario.getCidade() + "'").getResultList();

            } else if (usuario.getArea().trim().equals("Selecione") && !usuario.getNivel().trim().equals("Selecione") && usuario.getCidade().trim().equals("Selecione") && !usuario.getEstado().trim().equals("Selecione") && usuario.getEscolaridade().trim().equals("Selecione") && usuario.getCurso().trim().equals("Selecione")) {
                return (List<Usuario>) em.createQuery("SELECT OBJECT(u) FROM Usuario u  WHERE  u.nivel='" + usuario.getNivel() + "'"
                        + "and u.estado='" + usuario.getEstado() + "'").getResultList();

            } else if (usuario.getArea().trim().equals("Selecione") && !usuario.getNivel().trim().equals("Selecione") && usuario.getCidade().trim().equals("Selecione") && usuario.getEstado().trim().equals("Selecione") && !usuario.getEscolaridade().trim().equals("Selecione") && usuario.getCurso().trim().equals("Selecione")) {
                return (List<Usuario>) em.createQuery("SELECT OBJECT(u) FROM Usuario u  WHERE  u.nivel='" + usuario.getNivel() + "'"
                        + "and u.escolaridade='" + usuario.getEscolaridade() + "'").getResultList();

            } else if (usuario.getArea().trim().equals("Selecione") && !usuario.getNivel().trim().equals("Selecione") && usuario.getCidade().trim().equals("Selecione") && usuario.getEstado().trim().equals("Selecione") && usuario.getEscolaridade().trim().equals("Selecione") && !usuario.getCurso().trim().equals("Selecione")) {
                return (List<Usuario>) em.createQuery("SELECT OBJECT(u) FROM Usuario u  WHERE  u.nivel='" + usuario.getNivel() + "'"
                        + "and u.curso='" + usuario.getCurso() + "'").getResultList();

            } else if (usuario.getArea().trim().equals("Selecione") && usuario.getNivel().trim().equals("Selecione") && !usuario.getCidade().trim().equals("Selecione") && !usuario.getEstado().trim().equals("Selecione") && usuario.getEscolaridade().trim().equals("Selecione") && usuario.getCurso().trim().equals("Selecione")) {
                return (List<Usuario>) em.createQuery("SELECT OBJECT(u) FROM Usuario u  WHERE  u.cidade='" + usuario.getCidade() + "'"
                        + "and u.estado='" + usuario.getEstado() + "'").getResultList();

            } else if (usuario.getArea().trim().equals("Selecione") && usuario.getNivel().trim().equals("Selecione") && !usuario.getCidade().trim().equals("Selecione") && usuario.getEstado().trim().equals("Selecione") && !usuario.getEscolaridade().trim().equals("Selecione") && usuario.getCurso().trim().equals("Selecione")) {
                return (List<Usuario>) em.createQuery("SELECT OBJECT(u) FROM Usuario u  WHERE  u.cidade='" + usuario.getCidade() + "'"
                        + "and u.escolaridade='" + usuario.getEscolaridade() + "'").getResultList();

            } else if (usuario.getArea().trim().equals("Selecione") && usuario.getNivel().trim().equals("Selecione") && !usuario.getCidade().trim().equals("Selecione") && usuario.getEstado().trim().equals("Selecione") && usuario.getEscolaridade().trim().equals("Selecione") && !usuario.getCurso().trim().equals("Selecione")) {
                return (List<Usuario>) em.createQuery("SELECT OBJECT(u) FROM Usuario u  WHERE  u.cidade='" + usuario.getCidade() + "'"
                        + "and u.curso='" + usuario.getCurso() + "'").getResultList();

            } else if (usuario.getArea().trim().equals("Selecione") && usuario.getNivel().trim().equals("Selecione") && usuario.getCidade().trim().equals("Selecione") && !usuario.getEstado().trim().equals("Selecione") && !usuario.getEscolaridade().trim().equals("Selecione") && usuario.getCurso().trim().equals("Selecione")) {
                return (List<Usuario>) em.createQuery("SELECT OBJECT(u) FROM Usuario u  WHERE  u.estado='" + usuario.getEstado() + "'"
                        + "and u.escolaridade='" + usuario.getEscolaridade() + "'").getResultList();

            } else if (usuario.getArea().trim().equals("Selecione") && usuario.getNivel().trim().equals("Selecione") && usuario.getCidade().trim().equals("Selecione") && !usuario.getEstado().trim().equals("Selecione") && usuario.getEscolaridade().trim().equals("Selecione") && !usuario.getCurso().trim().equals("Selecione")) {
                return (List<Usuario>) em.createQuery("SELECT OBJECT(u) FROM Usuario u  WHERE  u.estado='" + usuario.getEstado() + "'"
                        + "and u.curso='" + usuario.getCurso() + "'").getResultList();

            } else if (usuario.getArea().trim().equals("Selecione") && usuario.getNivel().trim().equals("Selecione") && usuario.getCidade().trim().equals("Selecione") && usuario.getEstado().trim().equals("Selecione") && !usuario.getEscolaridade().trim().equals("Selecione") && !usuario.getCurso().trim().equals("Selecione")) {
                return (List<Usuario>) em.createQuery("SELECT OBJECT(u) FROM Usuario u  WHERE  u.escolaridade='" + usuario.getEscolaridade() + "'"
                        + "and u.curso='" + usuario.getCurso() + "'").getResultList();

            } else if (!usuario.getArea().trim().equals("Selecione") && !usuario.getNivel().trim().equals("Selecione") && !usuario.getCidade().trim().equals("Selecione") && usuario.getEstado().trim().equals("Selecione") && usuario.getEscolaridade().trim().equals("Selecione") && usuario.getCurso().trim().equals("Selecione")) {
                return (List<Usuario>) em.createQuery("SELECT OBJECT(u) FROM Usuario u  WHERE  u.area='" + usuario.getArea() + "'"
                        + "and u.nivel='" + usuario.getNivel() + "'"
                        + "and u.cidade='" + usuario.getCidade() + "'").getResultList();

            } else if (!usuario.getArea().trim().equals("Selecione") && !usuario.getNivel().trim().equals("Selecione") && usuario.getCidade().trim().equals("Selecione") && !usuario.getEstado().trim().equals("Selecione") && usuario.getEscolaridade().trim().equals("Selecione") && usuario.getCurso().trim().equals("Selecione")) {
                return (List<Usuario>) em.createQuery("SELECT OBJECT(u) FROM Usuario u  WHERE  u.area='" + usuario.getArea() + "'"
                        + "and u.nivel='" + usuario.getNivel() + "'"
                        + "and u.estado='" + usuario.getEstado() + "'").getResultList();

            } else if (!usuario.getArea().trim().equals("Selecione") && !usuario.getNivel().trim().equals("Selecione") && usuario.getCidade().trim().equals("Selecione") && usuario.getEstado().trim().equals("Selecione") && !usuario.getEscolaridade().trim().equals("Selecione") && usuario.getCurso().trim().equals("Selecione")) {
                return (List<Usuario>) em.createQuery("SELECT OBJECT(u) FROM Usuario u  WHERE  u.area='" + usuario.getArea() + "'"
                        + "and u.nivel='" + usuario.getNivel() + "'"
                        + "and u.escolaridade='" + usuario.getEscolaridade() + "'").getResultList();
            } else if (!usuario.getArea().trim().equals("Selecione") && !usuario.getNivel().trim().equals("Selecione") && usuario.getCidade().trim().equals("Selecione") && usuario.getEstado().trim().equals("Selecione") && usuario.getEscolaridade().trim().equals("Selecione") && !usuario.getCurso().trim().equals("Selecione")) {
                return (List<Usuario>) em.createQuery("SELECT OBJECT(u) FROM Usuario u  WHERE  u.area='" + usuario.getArea() + "'"
                        + "and u.nivel='" + usuario.getNivel() + "'"
                        + "and u.curso='" + usuario.getCurso() + "'").getResultList();

            } else if (!usuario.getArea().trim().equals("Selecione") && usuario.getNivel().trim().equals("Selecione") && !usuario.getCidade().trim().equals("Selecione") && !usuario.getEstado().trim().equals("Selecione") && usuario.getEscolaridade().trim().equals("Selecione") && usuario.getCurso().trim().equals("Selecione")) {
                return (List<Usuario>) em.createQuery("SELECT OBJECT(u) FROM Usuario u  WHERE  u.area='" + usuario.getArea() + "'"
                        + "and u.cidade='" + usuario.getCidade() + "'"
                        + "and u.estado='" + usuario.getEstado() + "'").getResultList();

            } else if (!usuario.getArea().trim().equals("Selecione") && usuario.getNivel().trim().equals("Selecione") && !usuario.getCidade().trim().equals("Selecione") && usuario.getEstado().trim().equals("Selecione") && !usuario.getEscolaridade().trim().equals("Selecione") && usuario.getCurso().trim().equals("Selecione")) {
                return (List<Usuario>) em.createQuery("SELECT OBJECT(u) FROM Usuario u  WHERE  u.area='" + usuario.getArea() + "'"
                        + "and u.cidade='" + usuario.getCidade() + "'"
                        + "and u.escolaridade='" + usuario.getEscolaridade() + "'").getResultList();

            } else if (!usuario.getArea().trim().equals("Selecione") && usuario.getNivel().trim().equals("Selecione") && !usuario.getCidade().trim().equals("Selecione") && usuario.getEstado().trim().equals("Selecione") && usuario.getEscolaridade().trim().equals("Selecione") && !usuario.getCurso().trim().equals("Selecione")) {
                return (List<Usuario>) em.createQuery("SELECT OBJECT(u) FROM Usuario u  WHERE  u.area='" + usuario.getArea() + "'"
                        + "and u.cidade='" + usuario.getCidade() + "'"
                        + "and u.curso='" + usuario.getCurso() + "'").getResultList();

            } else if (!usuario.getArea().trim().equals("Selecione") && usuario.getNivel().trim().equals("Selecione") && usuario.getCidade().trim().equals("Selecione") && !usuario.getEstado().trim().equals("Selecione") && !usuario.getEscolaridade().trim().equals("Selecione") && usuario.getCurso().trim().equals("Selecione")) {
                return (List<Usuario>) em.createQuery("SELECT OBJECT(u) FROM Usuario u  WHERE  u.area='" + usuario.getArea() + "'"
                        + "and u.estado='" + usuario.getEstado() + "'"
                        + "and u.escolaridade='" + usuario.getEscolaridade() + "'").getResultList();

            } else if (!usuario.getArea().trim().equals("Selecione") && usuario.getNivel().trim().equals("Selecione") && usuario.getCidade().trim().equals("Selecione") && !usuario.getEstado().trim().equals("Selecione") && usuario.getEscolaridade().trim().equals("Selecione") && !usuario.getCurso().trim().equals("Selecione")) {
                return (List<Usuario>) em.createQuery("SELECT OBJECT(u) FROM Usuario u  WHERE  u.area='" + usuario.getArea() + "'"
                        + "and u.estado='" + usuario.getEstado() + "'"
                        + "and u.curso='" + usuario.getCurso() + "'").getResultList();

            } else if (!usuario.getArea().trim().equals("Selecione") && usuario.getNivel().trim().equals("Selecione") && usuario.getCidade().trim().equals("Selecione") && usuario.getEstado().trim().equals("Selecione") && !usuario.getEscolaridade().trim().equals("Selecione") && !usuario.getCurso().trim().equals("Selecione")) {
                return (List<Usuario>) em.createQuery("SELECT OBJECT(u) FROM Usuario u  WHERE  u.area='" + usuario.getArea() + "'"
                        + "and u.escolaridade='" + usuario.getEscolaridade() + "'"
                        + "and u.curso='" + usuario.getCurso() + "'").getResultList();

            } else if (usuario.getArea().trim().equals("Selecione") && !usuario.getNivel().trim().equals("Selecione") && !usuario.getCidade().trim().equals("Selecione") && !usuario.getEstado().trim().equals("Selecione") && usuario.getEscolaridade().trim().equals("Selecione") && usuario.getCurso().trim().equals("Selecione")) {
                return (List<Usuario>) em.createQuery("SELECT OBJECT(u) FROM Usuario u  WHERE  u.nivel='" + usuario.getNivel() + "'"
                        + "and u.cidade='" + usuario.getCidade() + "'"
                        + "and u.estado='" + usuario.getEstado() + "'").getResultList();

            } else if (usuario.getArea().trim().equals("Selecione") && !usuario.getNivel().trim().equals("Selecione") && !usuario.getCidade().trim().equals("Selecione") && usuario.getEstado().trim().equals("Selecione") && !usuario.getEscolaridade().trim().equals("Selecione") && usuario.getCurso().trim().equals("Selecione")) {
                return (List<Usuario>) em.createQuery("SELECT OBJECT(u) FROM Usuario u  WHERE  u.nivel='" + usuario.getNivel() + "'"
                        + "and u.cidade='" + usuario.getCidade() + "'"
                        + "and u.escolaridade='" + usuario.getEscolaridade() + "'").getResultList();

            } else if (usuario.getArea().trim().equals("Selecione") && !usuario.getNivel().trim().equals("Selecione") && !usuario.getCidade().trim().equals("Selecione") && usuario.getEstado().trim().equals("Selecione") && usuario.getEscolaridade().trim().equals("Selecione") && !usuario.getCurso().trim().equals("Selecione")) {
                return (List<Usuario>) em.createQuery("SELECT OBJECT(u) FROM Usuario u  WHERE  u.nivel='" + usuario.getNivel() + "'"
                        + "and u.cidade='" + usuario.getCidade() + "'"
                        + "and u.curso='" + usuario.getCurso() + "'").getResultList();

            } else if (usuario.getArea().trim().equals("Selecione") && !usuario.getNivel().trim().equals("Selecione") && usuario.getCidade().trim().equals("Selecione") && !usuario.getEstado().trim().equals("Selecione") && !usuario.getEscolaridade().trim().equals("Selecione") && usuario.getCurso().trim().equals("Selecione")) {
                return (List<Usuario>) em.createQuery("SELECT OBJECT(u) FROM Usuario u  WHERE  u.nivel='" + usuario.getNivel() + "'"
                        + "and u.estado='" + usuario.getEstado() + "'"
                        + "and u.escolaridade='" + usuario.getEscolaridade() + "'").getResultList();

            } else if (usuario.getArea().trim().equals("Selecione") && !usuario.getNivel().trim().equals("Selecione") && usuario.getCidade().trim().equals("Selecione") && !usuario.getEstado().trim().equals("Selecione") && usuario.getEscolaridade().trim().equals("Selecione") && !usuario.getCurso().trim().equals("Selecione")) {
                return (List<Usuario>) em.createQuery("SELECT OBJECT(u) FROM Usuario u  WHERE  u.nivel='" + usuario.getNivel() + "'"
                        + "and u.curso='" + usuario.getCurso() + "'"
                        + "and u.estado='" + usuario.getEstado() + "'").getResultList();

            } else if (usuario.getArea().trim().equals("Selecione") && !usuario.getNivel().trim().equals("Selecione") && usuario.getCidade().trim().equals("Selecione") && usuario.getEstado().trim().equals("Selecione") && !usuario.getEscolaridade().trim().equals("Selecione") && !usuario.getCurso().trim().equals("Selecione")) {
                return (List<Usuario>) em.createQuery("SELECT OBJECT(u) FROM Usuario u  WHERE  u.nivel='" + usuario.getNivel() + "'"
                        + "and u.curso='" + usuario.getCurso() + "'"
                        + "and u.escolaridade='" + usuario.getEscolaridade() + "'").getResultList();

            } else if (usuario.getArea().trim().equals("Selecione") && usuario.getNivel().trim().equals("Selecione") && !usuario.getCidade().trim().equals("Selecione") && !usuario.getEstado().trim().equals("Selecione") && !usuario.getEscolaridade().trim().equals("Selecione") && usuario.getCurso().trim().equals("Selecione")) {
                return (List<Usuario>) em.createQuery("SELECT OBJECT(u) FROM Usuario u  WHERE  u.cidade='" + usuario.getCidade() + "'"
                        + "and u.estado='" + usuario.getEstado() + "'"
                        + "and u.escolaridade='" + usuario.getEscolaridade() + "'").getResultList();

            } else if (usuario.getArea().trim().equals("Selecione") && usuario.getNivel().trim().equals("Selecione") && !usuario.getCidade().trim().equals("Selecione") && !usuario.getEstado().trim().equals("Selecione") && usuario.getEscolaridade().trim().equals("Selecione") && !usuario.getCurso().trim().equals("Selecione")) {
                return (List<Usuario>) em.createQuery("SELECT OBJECT(u) FROM Usuario u  WHERE  u.cidade='" + usuario.getCidade() + "'"
                        + "and u.estado='" + usuario.getEstado() + "'"
                        + "and u.curso='" + usuario.getCurso() + "'").getResultList();

            } else if (usuario.getArea().trim().equals("Selecione") && usuario.getNivel().trim().equals("Selecione") && !usuario.getCidade().trim().equals("Selecione") && usuario.getEstado().trim().equals("Selecione") && !usuario.getEscolaridade().trim().equals("Selecione") && !usuario.getCurso().trim().equals("Selecione")) {
                return (List<Usuario>) em.createQuery("SELECT OBJECT(u) FROM Usuario u  WHERE  u.cidade='" + usuario.getCidade() + "'"
                        + "and u.escolaridade='" + usuario.getEscolaridade() + "'"
                        + "and u.curso='" + usuario.getCurso() + "'").getResultList();


            } else if (usuario.getArea().trim().equals("Selecione") && usuario.getNivel().trim().equals("Selecione") && usuario.getCidade().trim().equals("Selecione") && !usuario.getEstado().trim().equals("Selecione") && !usuario.getEscolaridade().trim().equals("Selecione") && !usuario.getCurso().trim().equals("Selecione")) {
                return (List<Usuario>) em.createQuery("SELECT OBJECT(u) FROM Usuario u  WHERE  u.estado='" + usuario.getEstado() + "'"
                        + "and u.escolaridade='" + usuario.getEscolaridade() + "'"
                        + "and u.curso='" + usuario.getCurso() + "'").getResultList();

            } else if (!usuario.getArea().trim().equals("Selecione") && !usuario.getNivel().trim().equals("Selecione") && !usuario.getCidade().trim().equals("Selecione") && !usuario.getEstado().trim().equals("Selecione") && usuario.getEscolaridade().trim().equals("Selecione") && usuario.getCurso().trim().equals("Selecione")) {
                return (List<Usuario>) em.createQuery("SELECT OBJECT(u) FROM Usuario u  WHERE  u.area='" + usuario.getArea() + "'"
                        + "and u.nivel='" + usuario.getNivel() + "'"
                        + "and u.cidade='" + usuario.getCidade() + "'"
                        + "and u.estado='" + usuario.getEstado() + "'").getResultList();

            } else if (!usuario.getArea().trim().equals("Selecione") && !usuario.getNivel().trim().equals("Selecione") && !usuario.getCidade().trim().equals("Selecione") && usuario.getEstado().trim().equals("Selecione") && !usuario.getEscolaridade().trim().equals("Selecione") && usuario.getCurso().trim().equals("Selecione")) {
                return (List<Usuario>) em.createQuery("SELECT OBJECT(u) FROM Usuario u  WHERE  u.area='" + usuario.getArea() + "'"
                        + "and u.nivel='" + usuario.getNivel() + "'"
                        + "and u.cidade='" + usuario.getCidade() + "'"
                        + "and u.escolaridade='" + usuario.getEscolaridade() + "'").getResultList();

            } else if (!usuario.getArea().trim().equals("Selecione") && !usuario.getNivel().trim().equals("Selecione") && !usuario.getCidade().trim().equals("Selecione") && usuario.getEstado().trim().equals("Selecione") && usuario.getEscolaridade().trim().equals("Selecione") && !usuario.getCurso().trim().equals("Selecione")) {
                return (List<Usuario>) em.createQuery("SELECT OBJECT(u) FROM Usuario u  WHERE  u.area='" + usuario.getArea() + "'"
                        + "and u.nivel='" + usuario.getNivel() + "'"
                        + "and u.cidade='" + usuario.getCidade() + "'"
                        + "and u.curso='" + usuario.getCurso() + "'").getResultList();

            } else if (!usuario.getArea().trim().equals("Selecione") && !usuario.getNivel().trim().equals("Selecione") && usuario.getCidade().trim().equals("Selecione") && !usuario.getEstado().trim().equals("Selecione") && !usuario.getEscolaridade().trim().equals("Selecione") && usuario.getCurso().trim().equals("Selecione")) {
                return (List<Usuario>) em.createQuery("SELECT OBJECT(u) FROM Usuario u  WHERE  u.area='" + usuario.getArea() + "'"
                        + "and u.nivel='" + usuario.getNivel() + "'"
                        + "and u.estado='" + usuario.getEstado() + "'"
                        + "and u.escolaridade='" + usuario.getEscolaridade() + "'").getResultList();

            } else if (!usuario.getArea().trim().equals("Selecione") && !usuario.getNivel().trim().equals("Selecione") && usuario.getCidade().trim().equals("Selecione") && !usuario.getEstado().trim().equals("Selecione") && usuario.getEscolaridade().trim().equals("Selecione") && !usuario.getCurso().trim().equals("Selecione")) {
                return (List<Usuario>) em.createQuery("SELECT OBJECT(u) FROM Usuario u  WHERE  u.area='" + usuario.getArea() + "'"
                        + "and u.nivel='" + usuario.getNivel() + "'"
                        + "and u.estado='" + usuario.getEstado() + "'"
                        + "and u.curso='" + usuario.getCurso() + "'").getResultList();

            } else if (!usuario.getArea().trim().equals("Selecione") && !usuario.getNivel().trim().equals("Selecione") && usuario.getCidade().trim().equals("Selecione") && usuario.getEstado().trim().equals("Selecione") && !usuario.getEscolaridade().trim().equals("Selecione") && !usuario.getCurso().trim().equals("Selecione")) {
                return (List<Usuario>) em.createQuery("SELECT OBJECT(u) FROM Usuario u  WHERE  u.area='" + usuario.getArea() + "'"
                        + "and u.nivel='" + usuario.getNivel() + "'"
                        + "and u.escolaridade='" + usuario.getEscolaridade() + "'"
                        + "and u.curso='" + usuario.getCurso() + "'").getResultList();

            } else if (!usuario.getArea().trim().equals("Selecione") && usuario.getNivel().trim().equals("Selecione") && !usuario.getCidade().trim().equals("Selecione") && !usuario.getEstado().trim().equals("Selecione") && !usuario.getEscolaridade().trim().equals("Selecione") && usuario.getCurso().trim().equals("Selecione")) {
                return (List<Usuario>) em.createQuery("SELECT OBJECT(u) FROM Usuario u  WHERE  u.area='" + usuario.getArea() + "'"
                        + "and u.cidade='" + usuario.getCidade() + "'"
                        + "and u.estado='" + usuario.getEstado() + "'"
                        + "and u.escolaridade='" + usuario.getEscolaridade() + "'").getResultList();

            } else if (!usuario.getArea().trim().equals("Selecione") && usuario.getNivel().trim().equals("Selecione") && !usuario.getCidade().trim().equals("Selecione") && !usuario.getEstado().trim().equals("Selecione") && usuario.getEscolaridade().trim().equals("Selecione") && !usuario.getCurso().trim().equals("Selecione")) {
                return (List<Usuario>) em.createQuery("SELECT OBJECT(u) FROM Usuario u  WHERE  u.area='" + usuario.getArea() + "'"
                        + "and u.cidade='" + usuario.getCidade() + "'"
                        + "and u.estado='" + usuario.getEstado() + "'"
                        + "and u.curso='" + usuario.getCurso() + "'").getResultList();

            } else if (!usuario.getArea().trim().equals("Selecione") && usuario.getNivel().trim().equals("Selecione") && !usuario.getCidade().trim().equals("Selecione") && usuario.getEstado().trim().equals("Selecione") && !usuario.getEscolaridade().trim().equals("Selecione") && !usuario.getCurso().trim().equals("Selecione")) {
                return (List<Usuario>) em.createQuery("SELECT OBJECT(u) FROM Usuario u  WHERE  u.area='" + usuario.getArea() + "'"
                        + "and u.cidade='" + usuario.getCidade() + "'"
                        + "and u.escolaridade='" + usuario.getEscolaridade() + "'"
                        + "and u.curso='" + usuario.getCurso() + "'").getResultList();

            } else if (!usuario.getArea().trim().equals("Selecione") && usuario.getNivel().trim().equals("Selecione") && usuario.getCidade().trim().equals("Selecione") && !usuario.getEstado().trim().equals("Selecione") && !usuario.getEscolaridade().trim().equals("Selecione") && !usuario.getCurso().trim().equals("Selecione")) {
                return (List<Usuario>) em.createQuery("SELECT OBJECT(u) FROM Usuario u  WHERE  u.area='" + usuario.getArea() + "'"
                        + "and u.estado='" + usuario.getEstado() + "'"
                        + "and u.escolaridade='" + usuario.getEscolaridade() + "'"
                        + "and u.curso='" + usuario.getCurso() + "'").getResultList();

            } else if (usuario.getArea().trim().equals("Selecione") && !usuario.getNivel().trim().equals("Selecione") && !usuario.getCidade().trim().equals("Selecione") && !usuario.getEstado().trim().equals("Selecione") && !usuario.getEscolaridade().trim().equals("Selecione") && usuario.getCurso().trim().equals("Selecione")) {
                return (List<Usuario>) em.createQuery("SELECT OBJECT(u) FROM Usuario u  WHERE  u.nivel='" + usuario.getNivel() + "'"
                        + "and u.estado='" + usuario.getEstado() + "'"
                        + "and u.escolaridade='" + usuario.getEscolaridade() + "'"
                        + "and u.cidade='" + usuario.getCidade() + "'").getResultList();

            } else if (usuario.getArea().trim().equals("Selecione") && !usuario.getNivel().trim().equals("Selecione") && !usuario.getCidade().trim().equals("Selecione") && !usuario.getEstado().trim().equals("Selecione") && usuario.getEscolaridade().trim().equals("Selecione") && !usuario.getCurso().trim().equals("Selecione")) {
                return (List<Usuario>) em.createQuery("SELECT OBJECT(u) FROM Usuario u  WHERE  u.nivel='" + usuario.getNivel() + "'"
                        + "and u.estado='" + usuario.getEstado() + "'"
                        + "and u.curso='" + usuario.getCurso() + "'"
                        + "and u.cidade='" + usuario.getCidade() + "'").getResultList();

            } else if (usuario.getArea().trim().equals("Selecione") && !usuario.getNivel().trim().equals("Selecione") && !usuario.getCidade().trim().equals("Selecione") && usuario.getEstado().trim().equals("Selecione") && !usuario.getEscolaridade().trim().equals("Selecione") && !usuario.getCurso().trim().equals("Selecione")) {
                return (List<Usuario>) em.createQuery("SELECT OBJECT(u) FROM Usuario u  WHERE  u.nivel='" + usuario.getNivel() + "'"
                        + "and u.escolaridade='" + usuario.getEscolaridade() + "'"
                        + "and u.curso='" + usuario.getCurso() + "'"
                        + "and u.cidade='" + usuario.getCidade() + "'").getResultList();

            } else if (usuario.getArea().trim().equals("Selecione") && !usuario.getNivel().trim().equals("Selecione") && usuario.getCidade().trim().equals("Selecione") && !usuario.getEstado().trim().equals("Selecione") && !usuario.getEscolaridade().trim().equals("Selecione") && !usuario.getCurso().trim().equals("Selecione")) {
                return (List<Usuario>) em.createQuery("SELECT OBJECT(u) FROM Usuario u  WHERE  u.nivel='" + usuario.getNivel() + "'"
                        + "and u.escolaridade='" + usuario.getEscolaridade() + "'"
                        + "and u.curso='" + usuario.getCurso() + "'"
                        + "and u.estado='" + usuario.getEstado() + "'").getResultList();

            } else if (!usuario.getArea().trim().equals("Selecione") && !usuario.getNivel().trim().equals("Selecione") && !usuario.getCidade().trim().equals("Selecione") && !usuario.getEstado().trim().equals("Selecione") && !usuario.getEscolaridade().trim().equals("Selecione") && usuario.getCurso().trim().equals("Selecione")) {
                return (List<Usuario>) em.createQuery("SELECT OBJECT(u) FROM Usuario u  WHERE  u.area='" + usuario.getArea() + "'"
                        + "and u.escolaridade='" + usuario.getEscolaridade() + "'"
                        + "and u.cidade='" + usuario.getCidade() + "'"
                        + "and u.estado='" + usuario.getEstado() + "'"
                        + "and u.nivel='" + usuario.getNivel() + "'").getResultList();

            } else if (!usuario.getArea().trim().equals("Selecione") && !usuario.getNivel().trim().equals("Selecione") && !usuario.getCidade().trim().equals("Selecione") && !usuario.getEstado().trim().equals("Selecione") && usuario.getEscolaridade().trim().equals("Selecione") && !usuario.getCurso().trim().equals("Selecione")) {
                return (List<Usuario>) em.createQuery("SELECT OBJECT(u) FROM Usuario u  WHERE  u.area='" + usuario.getArea() + "'"
                        + "and u.curso='" + usuario.getCurso() + "'"
                        + "and u.cidade='" + usuario.getCidade() + "'"
                        + "and u.estado='" + usuario.getEstado() + "'"
                        + "and u.nivel='" + usuario.getNivel() + "'").getResultList();

            } else if (!usuario.getArea().trim().equals("Selecione") && !usuario.getNivel().trim().equals("Selecione") && !usuario.getCidade().trim().equals("Selecione") && usuario.getEstado().trim().equals("Selecione") && !usuario.getEscolaridade().trim().equals("Selecione") && !usuario.getCurso().trim().equals("Selecione")) {
                return (List<Usuario>) em.createQuery("SELECT OBJECT(u) FROM Usuario u  WHERE  u.area='" + usuario.getArea() + "'"
                        + "and u.curso='" + usuario.getCurso() + "'"
                        + "and u.cidade='" + usuario.getCidade() + "'"
                        + "and u.escolaridade='" + usuario.getEscolaridade() + "'"
                        + "and u.nivel='" + usuario.getNivel() + "'").getResultList();

            } else if (!usuario.getArea().trim().equals("Selecione") && !usuario.getNivel().trim().equals("Selecione") && usuario.getCidade().trim().equals("Selecione") && !usuario.getEstado().trim().equals("Selecione") && !usuario.getEscolaridade().trim().equals("Selecione") && !usuario.getCurso().trim().equals("Selecione")) {
                return (List<Usuario>) em.createQuery("SELECT OBJECT(u) FROM Usuario u  WHERE  u.area='" + usuario.getArea() + "'"
                        + "and u.curso='" + usuario.getCurso() + "'"
                        + "and u.estado='" + usuario.getEstado() + "'"
                        + "and u.escolaridade='" + usuario.getEscolaridade() + "'"
                        + "and u.nivel='" + usuario.getNivel() + "'").getResultList();

            } else if (!usuario.getArea().trim().equals("Selecione") && usuario.getNivel().trim().equals("Selecione") && !usuario.getCidade().trim().equals("Selecione") && !usuario.getEstado().trim().equals("Selecione") && !usuario.getEscolaridade().trim().equals("Selecione") && !usuario.getCurso().trim().equals("Selecione")) {
                return (List<Usuario>) em.createQuery("SELECT OBJECT(u) FROM Usuario u  WHERE  u.area='" + usuario.getArea() + "'"
                        + "and u.curso='" + usuario.getCurso() + "'"
                        + "and u.estado='" + usuario.getEstado() + "'"
                        + "and u.escolaridade='" + usuario.getEscolaridade() + "'"
                        + "and u.cidade='" + usuario.getCidade() + "'").getResultList();

            } else if (usuario.getArea().trim().equals("Selecione") && !usuario.getNivel().trim().equals("Selecione") && !usuario.getCidade().trim().equals("Selecione") && !usuario.getEstado().trim().equals("Selecione") && !usuario.getEscolaridade().trim().equals("Selecione") && !usuario.getCurso().trim().equals("Selecione")) {
                return (List<Usuario>) em.createQuery("SELECT OBJECT(u) FROM Usuario u  WHERE  u.nivel='" + usuario.getNivel() + "'"
                        + "and u.curso='" + usuario.getCurso() + "'"
                        + "and u.estado='" + usuario.getEstado() + "'"
                        + "and u.escolaridade='" + usuario.getEscolaridade() + "'"
                        + "and u.cidade='" + usuario.getCidade() + "'").getResultList();
            } else {
                return (List<Usuario>) em.createQuery("SELECT OBJECT(u) FROM Usuario u").getResultList();
                //return null;
            }
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }

    }

    /*
     * / public List<Temp> candidatoList() { return (List<Temp>)
     * em.createQuery("SELECT NEW entidade.Temp(c.areaatuacao, count(c.id)) FROM
     * Candidato c GROUP BY c.areaatuacao").getResultList(); }
     */
}
