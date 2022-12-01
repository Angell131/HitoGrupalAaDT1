//createNativeQuery
package com.hitogrupalaccesodatos.logica;

import com.hitogrupalaccesodatos.model.Recomendacion;
import com.hitogrupalaccesodatos.model.Usuario;
import jakarta.persistence.*;
import java.util.List;

public class LogicaBD {

    //Crear entityManager
    private EntityManager em;

    //Constructor
    public LogicaBD() {
        super();

        //Creamos el factory
        EntityManagerFactory creador = Persistence.createEntityManagerFactory("pers");
        this.em = creador.createEntityManager();

        //Comprobar creación
        System.out.println("Obtenido");
    }

    //Getter del factory
    public EntityManager getEm() {
        return em;
    }

    //Función (listar recomendaciones)
    public List<Recomendacion> allRecomendacion() {
        String jpql = "select p from Recomendacion p";
        TypedQuery<Recomendacion> query = em.createQuery(jpql, Recomendacion.class);
        return query.getResultList();
    }

    //Función comprobarUser
    public Usuario comprobarUser(String user, String pass) {
        String sql = "SELECT u FROM Usuario u where u.id = ?1 and u.pass = ?2";
        TypedQuery<Usuario> query = em.createQuery(sql, Usuario.class);
        query.setParameter(1, user);
        query.setParameter(2, pass);
        Usuario res;
        try {
            res = query.getSingleResult();
            return res;
        } catch (Exception e) {
            res = null;
            System.out.println("Error");
            return res;
        }
    }

    //Función insertar
    public void Insertar(Usuario user, String juego, String genero, Integer valoracion) {
        Recomendacion res = new Recomendacion();
        res.setId(nuevoId());
        res.setLogin(user);
        res.setJuego(juego);
        res.setGenero(genero);
        res.setValoracion(valoracion);
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(res);
        et.commit();
    }

    //Función seleccionar el id mas alto.
    public int nuevoId() {
        String sql = "SELECT max(r.id) from Recomendacion r";
        TypedQuery<Integer> query = em.createQuery(sql, Integer.class);
        Integer maxId = query.getSingleResult();
        return maxId+1;

    }
}
