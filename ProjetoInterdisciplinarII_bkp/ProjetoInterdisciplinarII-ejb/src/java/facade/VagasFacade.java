/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import bean.Vagas;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author 31049184
 */
@Stateless
public class VagasFacade extends AbstractFacade<Vagas> {

    @PersistenceContext(unitName = "ProjetoInterdisciplinarII-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VagasFacade() {
        super(Vagas.class);
    }

    public Vagas getConsultaVagaID(long id) {
        try {
            return (Vagas) em.createQuery("SELECT OBJECT(u) FROM Vagas u  WHERE  u.id='" + id +"'").getSingleResult();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public List<Vagas> getConsultaVaga(Vagas vaga) {
        /*
         * System.out.println("SELECT OBJECT(u) FROM Vagas u WHERE UPPER(u.titulo) like
         *  UPPER('%" + vaga.getTitulo() + "%')" + "and u.areaAtuacao='" +
         * vaga.getAreaAtuacao() + "'" +" "and u.nivelAtuacao='" +
         * vaga.getNivelAtuacao() + "'" + "and u.cidade='" + vaga.getCidade() +
         * "'" + "and u.estado='" + vaga.getEstado() + "'" + "and u.idEmpresa="
         * + vaga.getIdEmpresa());
         */
        try {
            if (!vaga.getTitulo().trim().equals("") && !vaga.getAreaAtuacao().trim().equals("Selecione") && !vaga.getNivelAtuacao().trim().equals("Selecione") && !vaga.getCidade().trim().equals("Selecione") && !vaga.getEstado().trim().equals("Selecione") && vaga.getIdEmpresa() != null) {
                return (List<Vagas>) em.createQuery("SELECT OBJECT(u) FROM Vagas u  WHERE  UPPER(u.titulo) like  UPPER('%" + vaga.getTitulo() + "%')"
                        + "and u.areaAtuacao='" + vaga.getAreaAtuacao() + "'"
                        + "and u.nivelAtuacao='" + vaga.getNivelAtuacao() + "'"
                        + "and u.cidade='" + vaga.getCidade() + "'"
                        + "and u.estado='" + vaga.getEstado() + "'"
                        + "and u.idEmpresa=" + vaga.getIdEmpresa()).getResultList();
            } else if (!vaga.getTitulo().trim().equals("") && !vaga.getAreaAtuacao().trim().equals("Selecione") && vaga.getNivelAtuacao().trim().equals("Selecione") && vaga.getCidade().trim().equals("Selecione") && vaga.getEstado().trim().equals("Selecione") && vaga.getIdEmpresa() != null) {
                return (List<Vagas>) em.createQuery("SELECT OBJECT(u) FROM Vagas u  WHERE  UPPER(u.titulo) like UPPER('%" + vaga.getTitulo() + "%')"
                        + "and u.areaAtuacao='" + vaga.getAreaAtuacao() + "'"
                        + "and u.idEmpresa=" + vaga.getIdEmpresa()).getResultList();
            } else if (!vaga.getTitulo().trim().equals("") && vaga.getAreaAtuacao().trim().equals("Selecione") && !vaga.getNivelAtuacao().trim().equals("Selecione") && vaga.getCidade().trim().equals("Selecione") && vaga.getEstado().trim().equals("Selecione") && vaga.getIdEmpresa() != null) {
                return (List<Vagas>) em.createQuery("SELECT OBJECT(u) FROM Vagas u  WHERE  UPPER(u.titulo) like UPPER('%" + vaga.getTitulo() + "%')"
                        + "and u.nivelAtuacao='" + vaga.getNivelAtuacao() + "'"
                        + "and u.idEmpresa=" + vaga.getIdEmpresa()).getResultList();
            } else if (!vaga.getTitulo().trim().equals("") && vaga.getAreaAtuacao().trim().equals("Selecione") && vaga.getNivelAtuacao().trim().equals("Selecione") && !vaga.getCidade().trim().equals("Selecione") && vaga.getEstado().trim().equals("Selecione") && vaga.getIdEmpresa() != null) {
                return (List<Vagas>) em.createQuery("SELECT OBJECT(u) FROM Vagas u  WHERE  UPPER(u.titulo) like UPPER('%" + vaga.getTitulo() + "%')"
                        + "and u.cidade='" + vaga.getCidade() + "'"
                        + "and u.idEmpresa=" + vaga.getIdEmpresa()).getResultList();
            } else if (!vaga.getTitulo().trim().equals("") && vaga.getAreaAtuacao().trim().equals("Selecione") && vaga.getNivelAtuacao().trim().equals("Selecione") && vaga.getCidade().trim().equals("Selecione") && !vaga.getEstado().trim().equals("Selecione") && vaga.getIdEmpresa() != null) {
                return (List<Vagas>) em.createQuery("SELECT OBJECT(u) FROM Vagas u  WHERE  UPPER(u.titulo) like UPPER('%" + vaga.getTitulo() + "%')"
                        + "and u.estado='" + vaga.getEstado() + "'"
                        + "and u.idEmpresa=" + vaga.getIdEmpresa()).getResultList();
            } else if (!vaga.getTitulo().trim().equals("") && !vaga.getAreaAtuacao().trim().equals("Selecione") && !vaga.getNivelAtuacao().trim().equals("Selecione") && vaga.getCidade().trim().equals("Selecione") && vaga.getEstado().trim().equals("Selecione") && vaga.getIdEmpresa() != null) {
                return (List<Vagas>) em.createQuery("SELECT OBJECT(u) FROM Vagas u  WHERE  UPPER(u.titulo) like UPPER('%" + vaga.getTitulo() + "%')"
                        + "and u.areaAtuacao='" + vaga.getAreaAtuacao() + "'"
                        + "and u.nivelAtuacao='" + vaga.getNivelAtuacao() + "'"
                        + "and u.idEmpresa=" + vaga.getIdEmpresa()).getResultList();
            } else if (!vaga.getTitulo().trim().equals("") && !vaga.getAreaAtuacao().trim().equals("Selecione") && !vaga.getNivelAtuacao().trim().equals("Selecione") && !vaga.getCidade().trim().equals("Selecione") && vaga.getEstado().trim().equals("Selecione") && vaga.getIdEmpresa() != null) {
                return (List<Vagas>) em.createQuery("SELECT OBJECT(u) FROM Vagas u  WHERE  UPPER(u.titulo) like UPPER('%" + vaga.getTitulo() + "%')"
                        + "and u.areaAtuacao='" + vaga.getAreaAtuacao() + "'"
                        + "and u.nivelAtuacao='" + vaga.getNivelAtuacao() + "'"
                        + "and u.cidade='" + vaga.getCidade() + "'"
                        + "and u.idEmpresa=" + vaga.getIdEmpresa()).getResultList();
            } else if (!vaga.getTitulo().trim().equals("") && !vaga.getAreaAtuacao().trim().equals("Selecione") && !vaga.getNivelAtuacao().trim().equals("Selecione") && vaga.getCidade().trim().equals("Selecione") && !vaga.getEstado().trim().equals("Selecione") && vaga.getIdEmpresa() != null) {
                return (List<Vagas>) em.createQuery("SELECT OBJECT(u) FROM Vagas u  WHERE  UPPER(u.titulo) like UPPER('%" + vaga.getTitulo() + "%')"
                        + "and u.areaAtuacao='" + vaga.getAreaAtuacao() + "'"
                        + "and u.nivelAtuacao='" + vaga.getNivelAtuacao() + "'"
                        + "and u.estado='" + vaga.getEstado() + "'"
                        + "and u.idEmpresa=" + vaga.getIdEmpresa()).getResultList();
            } else if (!vaga.getTitulo().trim().equals("") && vaga.getAreaAtuacao().trim().equals("Selecione") && vaga.getNivelAtuacao().trim().equals("Selecione") && !vaga.getCidade().trim().equals("Selecione") && !vaga.getEstado().trim().equals("Selecione") && vaga.getIdEmpresa() != null) {
                return (List<Vagas>) em.createQuery("SELECT OBJECT(u) FROM Vagas u  WHERE  UPPER(u.titulo) like UPPER('%" + vaga.getTitulo() + "%')"
                        + "and u.cidade='" + vaga.getCidade() + "'"
                        + "and u.estado='" + vaga.getEstado() + "'"
                        + "and u.idEmpresa=" + vaga.getIdEmpresa()).getResultList();
            } else if (!vaga.getTitulo().trim().equals("") && !vaga.getAreaAtuacao().trim().equals("Selecione") && vaga.getNivelAtuacao().trim().equals("Selecione") && !vaga.getCidade().trim().equals("Selecione") && !vaga.getEstado().trim().equals("Selecione") && vaga.getIdEmpresa() != null) {
                return (List<Vagas>) em.createQuery("SELECT OBJECT(u) FROM Vagas u  WHERE  UPPER(u.titulo) like UPPER('%" + vaga.getTitulo() + "%')"
                        + "and u.cidade='" + vaga.getCidade() + "'"
                        + "and u.estado='" + vaga.getEstado() + "'"
                        + "and u.areaAtuacao='" + vaga.getAreaAtuacao() + "'"
                        + "and u.idEmpresa=" + vaga.getIdEmpresa()).getResultList();
            } else if (!vaga.getTitulo().trim().equals("") && vaga.getAreaAtuacao().trim().equals("Selecione") && !vaga.getNivelAtuacao().trim().equals("Selecione") && !vaga.getCidade().trim().equals("Selecione") && !vaga.getEstado().trim().equals("Selecione") && vaga.getIdEmpresa() != null) {
                return (List<Vagas>) em.createQuery("SELECT OBJECT(u) FROM Vagas u  WHERE  UPPER(u.titulo) like UPPER('%" + vaga.getTitulo() + "%')"
                        + "and u.cidade='" + vaga.getCidade() + "'"
                        + "and u.estado='" + vaga.getEstado() + "'"
                        + "and u.nivelAtuacao='" + vaga.getNivelAtuacao() + "'"
                        + "and u.idEmpresa=" + vaga.getIdEmpresa()).getResultList();
            } else if (!vaga.getTitulo().trim().equals("") && !vaga.getAreaAtuacao().trim().equals("Selecione") && vaga.getNivelAtuacao().trim().equals("Selecione") && !vaga.getCidade().trim().equals("Selecione") && vaga.getEstado().trim().equals("Selecione") && vaga.getIdEmpresa() != null) {
                return (List<Vagas>) em.createQuery("SELECT OBJECT(u) FROM Vagas u  WHERE  UPPER(u.titulo) like UPPER('%" + vaga.getTitulo() + "%')"
                        + "and u.cidade='" + vaga.getCidade() + "'"
                        + "and u.areaAtuacao='" + vaga.getAreaAtuacao() + "'"
                        + "and u.idEmpresa=" + vaga.getIdEmpresa()).getResultList();
            } else if (!vaga.getTitulo().trim().equals("") && vaga.getAreaAtuacao().trim().equals("Selecione") && !vaga.getNivelAtuacao().trim().equals("Selecione") && !vaga.getCidade().trim().equals("Selecione") && vaga.getEstado().trim().equals("Selecione") && vaga.getIdEmpresa() != null) {
                return (List<Vagas>) em.createQuery("SELECT OBJECT(u) FROM Vagas u  WHERE  UPPER(u.titulo) like UPPER('%" + vaga.getTitulo() + "%')"
                        + "and u.cidade='" + vaga.getCidade() + "'"
                        + "and u.nivelAtuacao='" + vaga.getNivelAtuacao() + "'"
                        + "and u.idEmpresa=" + vaga.getIdEmpresa()).getResultList();
            } else if (!vaga.getTitulo().trim().equals("") && !vaga.getAreaAtuacao().trim().equals("Selecione") && vaga.getNivelAtuacao().trim().equals("Selecione") && vaga.getCidade().trim().equals("Selecione") && !vaga.getEstado().trim().equals("Selecione") && vaga.getIdEmpresa() != null) {
                return (List<Vagas>) em.createQuery("SELECT OBJECT(u) FROM Vagas u  WHERE  UPPER(u.titulo) like UPPER('%" + vaga.getTitulo() + "%')"
                        + "and u.estado='" + vaga.getEstado() + "'"
                        + "and u.areaAtuacao='" + vaga.getAreaAtuacao() + "'"
                        + "and u.idEmpresa=" + vaga.getIdEmpresa()).getResultList();
            } else if (!vaga.getTitulo().trim().equals("") && vaga.getAreaAtuacao().trim().equals("Selecione") && !vaga.getNivelAtuacao().trim().equals("Selecione") && vaga.getCidade().trim().equals("Selecione") && !vaga.getEstado().trim().equals("Selecione") && vaga.getIdEmpresa() != null) {
                return (List<Vagas>) em.createQuery("SELECT OBJECT(u) FROM Vagas u  WHERE  UPPER(u.titulo) like UPPER('%" + vaga.getTitulo() + "%')"
                        + "and u.estado='" + vaga.getEstado() + "'"
                        + "and u.nivelAtuacao='" + vaga.getNivelAtuacao() + "'"
                        + "and u.idEmpresa=" + vaga.getIdEmpresa()).getResultList();
            } else if (vaga.getTitulo().trim().equals("") && !vaga.getAreaAtuacao().trim().equals("Selecione") && !vaga.getNivelAtuacao().trim().equals("Selecione") && !vaga.getCidade().trim().equals("Selecione") && !vaga.getEstado().trim().equals("Selecione") && vaga.getIdEmpresa() != null) {
                return (List<Vagas>) em.createQuery("SELECT OBJECT(u) FROM Vagas u  WHERE  u.areaAtuacao='" + vaga.getAreaAtuacao() + "'"
                        + "and u.nivelAtuacao='" + vaga.getNivelAtuacao() + "'"
                        + "and u.cidade='" + vaga.getCidade() + "'"
                        + "and u.estado='" + vaga.getEstado() + "'"
                        + "and u.idEmpresa=" + vaga.getIdEmpresa()).getResultList();
            } else if (vaga.getTitulo().trim().equals("") && vaga.getAreaAtuacao().trim().equals("Selecione") && !vaga.getNivelAtuacao().trim().equals("Selecione") && !vaga.getCidade().trim().equals("Selecione") && !vaga.getEstado().trim().equals("Selecione") && vaga.getIdEmpresa() != null) {
                return (List<Vagas>) em.createQuery("SELECT OBJECT(u) FROM Vagas u  WHERE  u.nivelAtuacao='" + vaga.getNivelAtuacao() + "'"
                        + "and u.cidade='" + vaga.getCidade() + "'"
                        + "and u.estado='" + vaga.getEstado() + "'"
                        + "and u.idEmpresa=" + vaga.getIdEmpresa()).getResultList();
            } else if (vaga.getTitulo().trim().equals("") && vaga.getAreaAtuacao().trim().equals("Selecione") && vaga.getNivelAtuacao().trim().equals("Selecione") && !vaga.getCidade().trim().equals("Selecione") && !vaga.getEstado().trim().equals("Selecione") && vaga.getIdEmpresa() != null) {
                return (List<Vagas>) em.createQuery("SELECT OBJECT(u) FROM Vagas u  WHERE  u.cidade='" + vaga.getCidade() + "'"
                        + "and u.estado='" + vaga.getEstado() + "'"
                        + "and u.idEmpresa=" + vaga.getIdEmpresa()).getResultList();
            } else if (vaga.getTitulo().trim().equals("") && vaga.getAreaAtuacao().trim().equals("Selecione") && vaga.getNivelAtuacao().trim().equals("Selecione") && vaga.getCidade().trim().equals("Selecione") && !vaga.getEstado().trim().equals("Selecione") && vaga.getIdEmpresa() != null) {
                return (List<Vagas>) em.createQuery("SELECT OBJECT(u) FROM Vagas u  WHERE  u.estado='" + vaga.getEstado() + "'"
                        + "and u.idEmpresa=" + vaga.getIdEmpresa()).getResultList();
            } else if (!vaga.getTitulo().trim().equals("") && vaga.getAreaAtuacao().trim().equals("Selecione") && vaga.getNivelAtuacao().trim().equals("Selecione") && vaga.getCidade().trim().equals("Selecione") && vaga.getEstado().trim().equals("Selecione") && vaga.getIdEmpresa() != null) {
                return (List<Vagas>) em.createQuery("SELECT OBJECT(u) FROM Vagas u  WHERE  UPPER(u.titulo) like UPPER('%" + vaga.getTitulo() + "%')"
                        + "and u.idEmpresa=" + vaga.getIdEmpresa()).getResultList();
            } else if (vaga.getTitulo().trim().equals("") && !vaga.getAreaAtuacao().trim().equals("Selecione") && vaga.getNivelAtuacao().trim().equals("Selecione") && vaga.getCidade().trim().equals("Selecione") && vaga.getEstado().trim().equals("Selecione") && vaga.getIdEmpresa() != null) {
                return (List<Vagas>) em.createQuery("SELECT OBJECT(u) FROM Vagas u  WHERE  u.areaAtuacao='" + vaga.getAreaAtuacao() + "'"
                        + "and u.idEmpresa=" + vaga.getIdEmpresa()).getResultList();
            } else if (vaga.getTitulo().trim().equals("") && vaga.getAreaAtuacao().trim().equals("Selecione") && !vaga.getNivelAtuacao().trim().equals("Selecione") && vaga.getCidade().trim().equals("Selecione") && vaga.getEstado().trim().equals("Selecione") && vaga.getIdEmpresa() != null) {
                return (List<Vagas>) em.createQuery("SELECT OBJECT(u) FROM Vagas u  WHERE  u.nivelAtuacao='" + vaga.getNivelAtuacao() + "'"
                        + "and u.idEmpresa=" + vaga.getIdEmpresa()).getResultList();
            } else if (vaga.getTitulo().trim().equals("") && vaga.getAreaAtuacao().trim().equals("Selecione") && vaga.getNivelAtuacao().trim().equals("Selecione") && !vaga.getCidade().trim().equals("Selecione") && vaga.getEstado().trim().equals("Selecione") && vaga.getIdEmpresa() != null) {
                return (List<Vagas>) em.createQuery("SELECT OBJECT(u) FROM Vagas u  WHERE  u.cidade='" + vaga.getCidade() + "'"
                        + "and u.idEmpresa=" + vaga.getIdEmpresa()).getResultList();
            } else if (vaga.getTitulo().trim().equals("") && vaga.getAreaAtuacao().trim().equals("Selecione") && vaga.getNivelAtuacao().trim().equals("Selecione") && vaga.getCidade().trim().equals("Selecione") && !vaga.getEstado().trim().equals("Selecione") && vaga.getIdEmpresa() != null) {
                return (List<Vagas>) em.createQuery("SELECT OBJECT(u) FROM Vagas u  WHERE  u.estado='" + vaga.getEstado() + "'"
                        + "and u.idEmpresa=" + vaga.getIdEmpresa()).getResultList();
            } else if (vaga.getTitulo().trim().equals("") && !vaga.getAreaAtuacao().trim().equals("Selecione") && !vaga.getNivelAtuacao().trim().equals("Selecione") && vaga.getCidade().trim().equals("Selecione") && vaga.getEstado().trim().equals("Selecione") && vaga.getIdEmpresa() != null) {
                return (List<Vagas>) em.createQuery("SELECT OBJECT(u) FROM Vagas u  WHERE  u.nivelAtuacao='" + vaga.getNivelAtuacao() + "'"
                        + "and u.areaAtuacao='" + vaga.getAreaAtuacao() + "'"
                        + "and u.idEmpresa=" + vaga.getIdEmpresa()).getResultList();
            } else if (vaga.getTitulo().trim().equals("") && !vaga.getAreaAtuacao().trim().equals("Selecione") && !vaga.getNivelAtuacao().trim().equals("Selecione") && vaga.getCidade().trim().equals("Selecione") && !vaga.getEstado().trim().equals("Selecione") && vaga.getIdEmpresa() != null) {
                return (List<Vagas>) em.createQuery("SELECT OBJECT(u) FROM Vagas u  WHERE  u.nivelAtuacao='" + vaga.getNivelAtuacao() + "'"
                        + "and u.areaAtuacao='" + vaga.getAreaAtuacao() + "'"
                        + "and u.estado='" + vaga.getEstado() + "'"
                        + "and u.idEmpresa=" + vaga.getIdEmpresa()).getResultList();
            } else if (vaga.getTitulo().trim().equals("") && !vaga.getAreaAtuacao().trim().equals("Selecione") && !vaga.getNivelAtuacao().trim().equals("Selecione") && !vaga.getCidade().trim().equals("Selecione") && vaga.getEstado().trim().equals("Selecione") && vaga.getIdEmpresa() != null) {
                return (List<Vagas>) em.createQuery("SELECT OBJECT(u) FROM Vagas u  WHERE  u.nivelAtuacao='" + vaga.getNivelAtuacao() + "'"
                        + "and u.areaAtuacao='" + vaga.getAreaAtuacao() + "'"
                        + "and u.cidade='" + vaga.getCidade() + "'"
                        + "and u.idEmpresa=" + vaga.getIdEmpresa()).getResultList();
            } else if (vaga.getTitulo().trim().equals("") && !vaga.getAreaAtuacao().trim().equals("Selecione") && vaga.getNivelAtuacao().trim().equals("Selecione") && !vaga.getCidade().trim().equals("Selecione") && vaga.getEstado().trim().equals("Selecione") && vaga.getIdEmpresa() != null) {
                return (List<Vagas>) em.createQuery("SELECT OBJECT(u) FROM Vagas u  WHERE  u.areaAtuacao='" + vaga.getAreaAtuacao() + "'"
                        + "and u.cidade='" + vaga.getCidade() + "'"
                        + "and u.idEmpresa=" + vaga.getIdEmpresa()).getResultList();
            } else if (vaga.getTitulo().trim().equals("") && !vaga.getAreaAtuacao().trim().equals("Selecione") && vaga.getNivelAtuacao().trim().equals("Selecione") && vaga.getCidade().trim().equals("Selecione") && !vaga.getEstado().trim().equals("Selecione") && vaga.getIdEmpresa() != null) {
                return (List<Vagas>) em.createQuery("SELECT OBJECT(u) FROM Vagas u  WHERE  u.areaAtuacao='" + vaga.getAreaAtuacao() + "'"
                        + "and u.estado='" + vaga.getEstado() + "'"
                        + "and u.idEmpresa=" + vaga.getIdEmpresa()).getResultList();
            } else if (vaga.getTitulo().trim().equals("") && vaga.getAreaAtuacao().trim().equals("Selecione") && !vaga.getNivelAtuacao().trim().equals("Selecione") && vaga.getCidade().trim().equals("Selecione") && !vaga.getEstado().trim().equals("Selecione") && vaga.getIdEmpresa() != null) {
                return (List<Vagas>) em.createQuery("SELECT OBJECT(u) FROM Vagas u  WHERE  u.nivelAtuacao='" + vaga.getNivelAtuacao() + "'"
                        + "and u.estado='" + vaga.getEstado() + "'"
                        + "and u.idEmpresa=" + vaga.getIdEmpresa()).getResultList();
            } else if (vaga.getTitulo().trim().equals("") && vaga.getAreaAtuacao().trim().equals("Selecione") && !vaga.getNivelAtuacao().trim().equals("Selecione") && !vaga.getCidade().trim().equals("Selecione") && vaga.getEstado().trim().equals("Selecione") && vaga.getIdEmpresa() != null) {
                return (List<Vagas>) em.createQuery("SELECT OBJECT(u) FROM Vagas u  WHERE  u.nivelAtuacao='" + vaga.getNivelAtuacao() + "'"
                        + "and u.cidade='" + vaga.getCidade() + "'"
                        + "and u.idEmpresa=" + vaga.getIdEmpresa()).getResultList();
            } else if (vaga.getTitulo().trim().equals("") && !vaga.getAreaAtuacao().trim().equals("Selecione") && vaga.getNivelAtuacao().trim().equals("Selecione") && !vaga.getCidade().trim().equals("Selecione") && !vaga.getEstado().trim().equals("Selecione") && vaga.getIdEmpresa() != null) {
                return (List<Vagas>) em.createQuery("SELECT OBJECT(u) FROM Vagas u  WHERE  u.areaAtuacao='" + vaga.getAreaAtuacao() + "'"
                        + "and u.cidade='" + vaga.getCidade() + "'"
                        + "and u.estado='" + vaga.getEstado() + "'"
                        + "and u.idEmpresa=" + vaga.getIdEmpresa()).getResultList();

            } else {
                return (List<Vagas>) em.createQuery("SELECT OBJECT(u) FROM Vagas u  WHERE  u.idEmpresa="+vaga.getIdEmpresa()).getResultList();
                //return null;
            }
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public List<Vagas> getConsultaVagaWeb(Vagas vaga) {
        /*
         * System.out.println("SELECT OBJECT(u) FROM Vagas u WHERE UPPER(u.titulo) like
         *  UPPER('%" + vaga.getTitulo() + "%')" + "and u.areaAtuacao='" +
         * vaga.getAreaAtuacao() + "'" + "and u.nivelAtuacao='" +
         * vaga.getNivelAtuacao() + "'" + "and u.cidade='" + vaga.getCidade() +
         * "'" + "and u.estado='" + vaga.getEstado() + "'" + "and u.idEmpresa="
         * + vaga.getIdEmpresa());
         */
        try {
            if (!vaga.getTitulo().trim().equals("") && !vaga.getAreaAtuacao().trim().equals("Selecione") && !vaga.getNivelAtuacao().trim().equals("Selecione") && !vaga.getCidade().trim().equals("Selecione") && !vaga.getEstado().trim().equals("Selecione")) {
                return (List<Vagas>) em.createQuery("SELECT OBJECT(u) FROM Vagas u  WHERE  UPPER(u.titulo) like  UPPER('%" + vaga.getTitulo() + "%')"
                        + "and u.areaAtuacao='" + vaga.getAreaAtuacao() + "'"
                        + "and u.nivelAtuacao='" + vaga.getNivelAtuacao() + "'"
                        + "and u.cidade='" + vaga.getCidade() + "'"
                        + "and u.estado='" + vaga.getEstado() + "'").getResultList();
            } else if (!vaga.getTitulo().trim().equals("") && !vaga.getAreaAtuacao().trim().equals("Selecione") && vaga.getNivelAtuacao().trim().equals("Selecione") && vaga.getCidade().trim().equals("Selecione") && vaga.getEstado().trim().equals("Selecione")) {
                return (List<Vagas>) em.createQuery("SELECT OBJECT(u) FROM Vagas u  WHERE  UPPER(u.titulo) like UPPER('%" + vaga.getTitulo() + "%')"
                        + "and u.areaAtuacao='" + vaga.getAreaAtuacao() + "'").getResultList();
            } else if (!vaga.getTitulo().trim().equals("") && vaga.getAreaAtuacao().trim().equals("Selecione") && !vaga.getNivelAtuacao().trim().equals("Selecione") && vaga.getCidade().trim().equals("Selecione") && vaga.getEstado().trim().equals("Selecione")) {
                return (List<Vagas>) em.createQuery("SELECT OBJECT(u) FROM Vagas u  WHERE  UPPER(u.titulo) like UPPER('%" + vaga.getTitulo() + "%')"
                        + "and u.nivelAtuacao='" + vaga.getNivelAtuacao() + "'").getResultList();
            } else if (!vaga.getTitulo().trim().equals("") && vaga.getAreaAtuacao().trim().equals("Selecione") && vaga.getNivelAtuacao().trim().equals("Selecione") && !vaga.getCidade().trim().equals("Selecione") && vaga.getEstado().trim().equals("Selecione")) {
                return (List<Vagas>) em.createQuery("SELECT OBJECT(u) FROM Vagas u  WHERE  UPPER(u.titulo) like UPPER('%" + vaga.getTitulo() + "%')"
                        + "and u.cidade='" + vaga.getCidade() + "'").getResultList();
            } else if (!vaga.getTitulo().trim().equals("") && vaga.getAreaAtuacao().trim().equals("Selecione") && vaga.getNivelAtuacao().trim().equals("Selecione") && vaga.getCidade().trim().equals("Selecione") && !vaga.getEstado().trim().equals("Selecione")) {
                return (List<Vagas>) em.createQuery("SELECT OBJECT(u) FROM Vagas u  WHERE  UPPER(u.titulo) like UPPER('%" + vaga.getTitulo() + "%')"
                        + "and u.estado='" + vaga.getEstado() + "'").getResultList();
            } else if (!vaga.getTitulo().trim().equals("") && !vaga.getAreaAtuacao().trim().equals("Selecione") && !vaga.getNivelAtuacao().trim().equals("Selecione") && vaga.getCidade().trim().equals("Selecione") && vaga.getEstado().trim().equals("Selecione")) {
                return (List<Vagas>) em.createQuery("SELECT OBJECT(u) FROM Vagas u  WHERE  UPPER(u.titulo) like UPPER('%" + vaga.getTitulo() + "%')"
                        + "and u.areaAtuacao='" + vaga.getAreaAtuacao() + "'"
                        + "and u.nivelAtuacao='" + vaga.getNivelAtuacao() + "'").getResultList();
            } else if (!vaga.getTitulo().trim().equals("") && !vaga.getAreaAtuacao().trim().equals("Selecione") && !vaga.getNivelAtuacao().trim().equals("Selecione") && !vaga.getCidade().trim().equals("Selecione") && vaga.getEstado().trim().equals("Selecione")) {
                return (List<Vagas>) em.createQuery("SELECT OBJECT(u) FROM Vagas u  WHERE  UPPER(u.titulo) like UPPER('%" + vaga.getTitulo() + "%')"
                        + "and u.areaAtuacao='" + vaga.getAreaAtuacao() + "'"
                        + "and u.nivelAtuacao='" + vaga.getNivelAtuacao() + "'"
                        + "and u.cidade='" + vaga.getCidade() + "'").getResultList();
            } else if (!vaga.getTitulo().trim().equals("") && !vaga.getAreaAtuacao().trim().equals("Selecione") && !vaga.getNivelAtuacao().trim().equals("Selecione") && vaga.getCidade().trim().equals("Selecione") && !vaga.getEstado().trim().equals("Selecione")) {
                return (List<Vagas>) em.createQuery("SELECT OBJECT(u) FROM Vagas u  WHERE  UPPER(u.titulo) like UPPER('%" + vaga.getTitulo() + "%')"
                        + "and u.areaAtuacao='" + vaga.getAreaAtuacao() + "'"
                        + "and u.nivelAtuacao='" + vaga.getNivelAtuacao() + "'"
                        + "and u.estado='" + vaga.getEstado() + "'").getResultList();
            } else if (!vaga.getTitulo().trim().equals("") && vaga.getAreaAtuacao().trim().equals("Selecione") && vaga.getNivelAtuacao().trim().equals("Selecione") && !vaga.getCidade().trim().equals("Selecione") && !vaga.getEstado().trim().equals("Selecione")) {
                return (List<Vagas>) em.createQuery("SELECT OBJECT(u) FROM Vagas u  WHERE  UPPER(u.titulo) like UPPER('%" + vaga.getTitulo() + "%')"
                        + "and u.cidade='" + vaga.getCidade() + "'"
                        + "and u.estado='" + vaga.getEstado() + "'").getResultList();
            } else if (!vaga.getTitulo().trim().equals("") && !vaga.getAreaAtuacao().trim().equals("Selecione") && vaga.getNivelAtuacao().trim().equals("Selecione") && !vaga.getCidade().trim().equals("Selecione") && !vaga.getEstado().trim().equals("Selecione")) {
                return (List<Vagas>) em.createQuery("SELECT OBJECT(u) FROM Vagas u  WHERE  UPPER(u.titulo) like UPPER('%" + vaga.getTitulo() + "%')"
                        + "and u.cidade='" + vaga.getCidade() + "'"
                        + "and u.estado='" + vaga.getEstado() + "'"
                        + "and u.areaAtuacao='" + vaga.getAreaAtuacao() + "'").getResultList();
            } else if (!vaga.getTitulo().trim().equals("") && vaga.getAreaAtuacao().trim().equals("Selecione") && !vaga.getNivelAtuacao().trim().equals("Selecione") && !vaga.getCidade().trim().equals("Selecione") && !vaga.getEstado().trim().equals("Selecione")) {
                return (List<Vagas>) em.createQuery("SELECT OBJECT(u) FROM Vagas u  WHERE  UPPER(u.titulo) like UPPER('%" + vaga.getTitulo() + "%')"
                        + "and u.cidade='" + vaga.getCidade() + "'"
                        + "and u.estado='" + vaga.getEstado() + "'"
                        + "and u.nivelAtuacao='" + vaga.getNivelAtuacao() + "'").getResultList();
            } else if (!vaga.getTitulo().trim().equals("") && !vaga.getAreaAtuacao().trim().equals("Selecione") && vaga.getNivelAtuacao().trim().equals("Selecione") && !vaga.getCidade().trim().equals("Selecione") && vaga.getEstado().trim().equals("Selecione")) {
                return (List<Vagas>) em.createQuery("SELECT OBJECT(u) FROM Vagas u  WHERE  UPPER(u.titulo) like UPPER('%" + vaga.getTitulo() + "%')"
                        + "and u.cidade='" + vaga.getCidade() + "'"
                        + "and u.areaAtuacao='" + vaga.getAreaAtuacao() + "'").getResultList();
            } else if (!vaga.getTitulo().trim().equals("") && vaga.getAreaAtuacao().trim().equals("Selecione") && !vaga.getNivelAtuacao().trim().equals("Selecione") && !vaga.getCidade().trim().equals("Selecione") && vaga.getEstado().trim().equals("Selecione")) {
                return (List<Vagas>) em.createQuery("SELECT OBJECT(u) FROM Vagas u  WHERE  UPPER(u.titulo) like UPPER('%" + vaga.getTitulo() + "%')"
                        + "and u.cidade='" + vaga.getCidade() + "'"
                        + "and u.nivelAtuacao='" + vaga.getNivelAtuacao() + "'").getResultList();
            } else if (!vaga.getTitulo().trim().equals("") && !vaga.getAreaAtuacao().trim().equals("Selecione") && vaga.getNivelAtuacao().trim().equals("Selecione") && vaga.getCidade().trim().equals("Selecione") && !vaga.getEstado().trim().equals("Selecione")) {
                return (List<Vagas>) em.createQuery("SELECT OBJECT(u) FROM Vagas u  WHERE  UPPER(u.titulo) like UPPER('%" + vaga.getTitulo() + "%')"
                        + "and u.estado='" + vaga.getEstado() + "'"
                        + "and u.areaAtuacao='" + vaga.getAreaAtuacao() + "'").getResultList();
            } else if (!vaga.getTitulo().trim().equals("") && vaga.getAreaAtuacao().trim().equals("Selecione") && !vaga.getNivelAtuacao().trim().equals("Selecione") && vaga.getCidade().trim().equals("Selecione") && !vaga.getEstado().trim().equals("Selecione")) {
                return (List<Vagas>) em.createQuery("SELECT OBJECT(u) FROM Vagas u  WHERE  UPPER(u.titulo) like UPPER('%" + vaga.getTitulo() + "%')"
                        + "and u.estado='" + vaga.getEstado() + "'"
                        + "and u.nivelAtuacao='" + vaga.getNivelAtuacao() + "'").getResultList();
            } else if (vaga.getTitulo().trim().equals("") && !vaga.getAreaAtuacao().trim().equals("Selecione") && !vaga.getNivelAtuacao().trim().equals("Selecione") && !vaga.getCidade().trim().equals("Selecione") && !vaga.getEstado().trim().equals("Selecione")) {
                return (List<Vagas>) em.createQuery("SELECT OBJECT(u) FROM Vagas u  WHERE  u.areaAtuacao='" + vaga.getAreaAtuacao() + "'"
                        + "and u.nivelAtuacao='" + vaga.getNivelAtuacao() + "'"
                        + "and u.cidade='" + vaga.getCidade() + "'"
                        + "and u.estado='" + vaga.getEstado() + "'").getResultList();
            } else if (vaga.getTitulo().trim().equals("") && vaga.getAreaAtuacao().trim().equals("Selecione") && !vaga.getNivelAtuacao().trim().equals("Selecione") && !vaga.getCidade().trim().equals("Selecione") && !vaga.getEstado().trim().equals("Selecione")) {
                return (List<Vagas>) em.createQuery("SELECT OBJECT(u) FROM Vagas u  WHERE  u.nivelAtuacao='" + vaga.getNivelAtuacao() + "'"
                        + "and u.cidade='" + vaga.getCidade() + "'"
                        + "and u.estado='" + vaga.getEstado() + "'").getResultList();
            } else if (vaga.getTitulo().trim().equals("") && vaga.getAreaAtuacao().trim().equals("Selecione") && vaga.getNivelAtuacao().trim().equals("Selecione") && !vaga.getCidade().trim().equals("Selecione") && !vaga.getEstado().trim().equals("Selecione")) {
                return (List<Vagas>) em.createQuery("SELECT OBJECT(u) FROM Vagas u  WHERE  u.cidade='" + vaga.getCidade() + "'"
                        + "and u.estado='" + vaga.getEstado() + "'").getResultList();
            } else if (vaga.getTitulo().trim().equals("") && vaga.getAreaAtuacao().trim().equals("Selecione") && vaga.getNivelAtuacao().trim().equals("Selecione") && vaga.getCidade().trim().equals("Selecione") && !vaga.getEstado().trim().equals("Selecione")) {
                return (List<Vagas>) em.createQuery("SELECT OBJECT(u) FROM Vagas u  WHERE  u.estado='" + vaga.getEstado() + "'").getResultList();
            } else if (!vaga.getTitulo().trim().equals("") && vaga.getAreaAtuacao().trim().equals("Selecione") && vaga.getNivelAtuacao().trim().equals("Selecione") && vaga.getCidade().trim().equals("Selecione") && vaga.getEstado().trim().equals("Selecione")) {
                return (List<Vagas>) em.createQuery("SELECT OBJECT(u) FROM Vagas u  WHERE  UPPER(u.titulo) like UPPER('%" + vaga.getTitulo() + "%')").getResultList();
            } else if (vaga.getTitulo().trim().equals("") && !vaga.getAreaAtuacao().trim().equals("Selecione") && vaga.getNivelAtuacao().trim().equals("Selecione") && vaga.getCidade().trim().equals("Selecione") && vaga.getEstado().trim().equals("Selecione")) {
                return (List<Vagas>) em.createQuery("SELECT OBJECT(u) FROM Vagas u  WHERE  u.areaAtuacao='" + vaga.getAreaAtuacao() + "'").getResultList();
            } else if (vaga.getTitulo().trim().equals("") && vaga.getAreaAtuacao().trim().equals("Selecione") && !vaga.getNivelAtuacao().trim().equals("Selecione") && vaga.getCidade().trim().equals("Selecione") && vaga.getEstado().trim().equals("Selecione")) {
                return (List<Vagas>) em.createQuery("SELECT OBJECT(u) FROM Vagas u  WHERE  u.nivelAtuacao='" + vaga.getNivelAtuacao() + "'").getResultList();
            } else if (vaga.getTitulo().trim().equals("") && vaga.getAreaAtuacao().trim().equals("Selecione") && vaga.getNivelAtuacao().trim().equals("Selecione") && !vaga.getCidade().trim().equals("Selecione") && vaga.getEstado().trim().equals("Selecione")) {
                return (List<Vagas>) em.createQuery("SELECT OBJECT(u) FROM Vagas u  WHERE  u.cidade='" + vaga.getCidade() + "'").getResultList();
            } else if (vaga.getTitulo().trim().equals("") && vaga.getAreaAtuacao().trim().equals("Selecione") && vaga.getNivelAtuacao().trim().equals("Selecione") && vaga.getCidade().trim().equals("Selecione") && !vaga.getEstado().trim().equals("Selecione")) {
                return (List<Vagas>) em.createQuery("SELECT OBJECT(u) FROM Vagas u  WHERE  u.estado='" + vaga.getEstado() + "'").getResultList();
            } else if (vaga.getTitulo().trim().equals("") && !vaga.getAreaAtuacao().trim().equals("Selecione") && !vaga.getNivelAtuacao().trim().equals("Selecione") && vaga.getCidade().trim().equals("Selecione") && vaga.getEstado().trim().equals("Selecione")) {
                return (List<Vagas>) em.createQuery("SELECT OBJECT(u) FROM Vagas u  WHERE  u.nivelAtuacao='" + vaga.getNivelAtuacao() + "'"
                        + "and u.areaAtuacao='" + vaga.getAreaAtuacao() + "'").getResultList();
            } else if (vaga.getTitulo().trim().equals("") && !vaga.getAreaAtuacao().trim().equals("Selecione") && !vaga.getNivelAtuacao().trim().equals("Selecione") && vaga.getCidade().trim().equals("Selecione") && !vaga.getEstado().trim().equals("Selecione")) {
                return (List<Vagas>) em.createQuery("SELECT OBJECT(u) FROM Vagas u  WHERE  u.nivelAtuacao='" + vaga.getNivelAtuacao() + "'"
                        + "and u.areaAtuacao='" + vaga.getAreaAtuacao() + "'"
                        + "and u.estado='" + vaga.getEstado() + "'").getResultList();
            } else if (vaga.getTitulo().trim().equals("") && !vaga.getAreaAtuacao().trim().equals("Selecione") && !vaga.getNivelAtuacao().trim().equals("Selecione") && !vaga.getCidade().trim().equals("Selecione") && vaga.getEstado().trim().equals("Selecione")) {
                return (List<Vagas>) em.createQuery("SELECT OBJECT(u) FROM Vagas u  WHERE  u.nivelAtuacao='" + vaga.getNivelAtuacao() + "'"
                        + "and u.areaAtuacao='" + vaga.getAreaAtuacao() + "'"
                        + "and u.cidade='" + vaga.getCidade() + "'").getResultList();
            } else if (vaga.getTitulo().trim().equals("") && !vaga.getAreaAtuacao().trim().equals("Selecione") && vaga.getNivelAtuacao().trim().equals("Selecione") && !vaga.getCidade().trim().equals("Selecione") && vaga.getEstado().trim().equals("Selecione")) {
                return (List<Vagas>) em.createQuery("SELECT OBJECT(u) FROM Vagas u  WHERE  u.areaAtuacao='" + vaga.getAreaAtuacao() + "'"
                        + "and u.cidade='" + vaga.getCidade() + "'").getResultList();
            } else if (vaga.getTitulo().trim().equals("") && !vaga.getAreaAtuacao().trim().equals("Selecione") && vaga.getNivelAtuacao().trim().equals("Selecione") && vaga.getCidade().trim().equals("Selecione") && !vaga.getEstado().trim().equals("Selecione")) {
                return (List<Vagas>) em.createQuery("SELECT OBJECT(u) FROM Vagas u  WHERE  u.areaAtuacao='" + vaga.getAreaAtuacao() + "'"
                        + "and u.estado='" + vaga.getEstado() + "'").getResultList();
            } else if (vaga.getTitulo().trim().equals("") && vaga.getAreaAtuacao().trim().equals("Selecione") && !vaga.getNivelAtuacao().trim().equals("Selecione") && vaga.getCidade().trim().equals("Selecione") && !vaga.getEstado().trim().equals("Selecione")) {
                return (List<Vagas>) em.createQuery("SELECT OBJECT(u) FROM Vagas u  WHERE  u.nivelAtuacao='" + vaga.getNivelAtuacao() + "'"
                        + "and u.estado='" + vaga.getEstado() + "'").getResultList();
            } else if (vaga.getTitulo().trim().equals("") && vaga.getAreaAtuacao().trim().equals("Selecione") && !vaga.getNivelAtuacao().trim().equals("Selecione") && !vaga.getCidade().trim().equals("Selecione") && vaga.getEstado().trim().equals("Selecione")) {
                return (List<Vagas>) em.createQuery("SELECT OBJECT(u) FROM Vagas u  WHERE  u.nivelAtuacao='" + vaga.getNivelAtuacao() + "'"
                        + "and u.cidade='" + vaga.getCidade() + "'").getResultList();
            } else if (vaga.getTitulo().trim().equals("") && !vaga.getAreaAtuacao().trim().equals("Selecione") && vaga.getNivelAtuacao().trim().equals("Selecione") && !vaga.getCidade().trim().equals("Selecione") && !vaga.getEstado().trim().equals("Selecione")) {
                return (List<Vagas>) em.createQuery("SELECT OBJECT(u) FROM Vagas u  WHERE  u.areaAtuacao='" + vaga.getAreaAtuacao() + "'"
                        + "and u.cidade='" + vaga.getCidade() + "'"
                        + "and u.estado='" + vaga.getEstado() + "'").getResultList();

            } else {
                return (List<Vagas>) em.createQuery("SELECT OBJECT(u) FROM Vagas u").getResultList();
                //return null;
            }
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
    public Vagas getTrazerVaga(long vaga) {
       try {
            return (Vagas) em.createQuery("SELECT OBJECT(u) FROM Vagas u  WHERE  u.id='" + vaga +"'").getSingleResult();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
    
    public List<Vagas> getVagasEmpresa(long vaga) {
       try {
            return (List<Vagas>) em.createQuery("SELECT OBJECT(u) FROM Vagas u  WHERE  u.idEmpresa='" + vaga + "'").getResultList();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
