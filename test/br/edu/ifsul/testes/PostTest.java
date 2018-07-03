/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import br.edu.ifsul.modelo.Permission;
import br.edu.ifsul.modelo.Person;
import br.edu.ifsul.modelo.Post;

/**
 *
 * @author Crisl
 */
public class PostTest {
    
    EntityManagerFactory emf;
    EntityManager em;

    public PostTest() {
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
            Person obj = new Person();
            obj = em.find(Person.class, 1);
            
            Post post = new Post();
            
            post.setContent("Conteúdo");
            post.setPerson(obj);
            post.setTitle("Título");
            
            em.getTransaction().begin();
            em.persist(post);
            em.getTransaction().commit();
        } catch (Exception e) {
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);
    }
}
