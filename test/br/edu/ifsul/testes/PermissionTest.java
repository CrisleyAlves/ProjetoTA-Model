/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import br.edu.ifsul.modelo.Permission;
import br.edu.ifsul.modelo.Person;

/**
 *
 * @author Crisl
 */
public class PermissionTest {
    
    EntityManagerFactory emf;
    EntityManager em;

    public PermissionTest() {
    }

    @Before
    public void setUp() {
        emf = Persistence.createEntityManagerFactory("ProjetoTAPU");
        em = emf.createEntityManager();
    }

    @After
    public void tearDown() {
        em.close();
        emf.close();
    }

    @Test
    public void teste() {
        boolean exception = false;
        try {            
            Permission obj = new Permission();
            Permission obj1 = new Permission();
            obj.setDescription("ADMINISTRADOR DO SISTEMA");
            obj.setName("ADMINISTRADOR");
            obj1.setDescription("USUÁRIO DO SISTEMA");
            obj1.setName("USUARIO");
            em.getTransaction().begin();
            em.persist(obj);
            em.getTransaction().commit();
            em.getTransaction().begin();
            em.persist(obj1);
            em.getTransaction().commit();
        } catch (Exception e) {
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);
    }
}
