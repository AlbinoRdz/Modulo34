package com.ebac.modulo35.model;

import com.ebac.modulo35.dto.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.function.Predicate;

public class UsuarioModel {

    private final EntityManager entityManager;

    public UsuarioModel(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void guardar(Usuario usuario) {
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.persist(usuario);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
    }

    public void actualizar(Usuario usuario) {
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.merge(usuario);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
    }

    public Usuario obtenerPorId(int id) {
        return entityManager.find(Usuario.class, id);
    }

    public void eliminar(Usuario usuario) {
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.remove(usuario);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
    }

    public List<Usuario> obtenerUsuarios() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Usuario> cq = cb.createQuery(Usuario.class);

        Root<Usuario> rootEntry = cq.from(Usuario.class);
        CriteriaQuery<Usuario> select = cq.select(rootEntry);

        TypedQuery<Usuario> query = entityManager.createQuery(select);
        return query.getResultList();
    }

    /*public List<Usuario> obtenerUsuarios() {
        String sqlQuery = "SELECT * FROM usuarios";

        return entityManager.createNativeQuery(sqlQuery, Usuario.class)
                .getResultList();
    }*/
}
