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

/**
 *
 * @author Crisl
 */
public class PersonTest {
    
    EntityManagerFactory emf;
    EntityManager em;

    public PersonTest() {
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
            Permission p = new Permission();
            p = em.find(Permission.class, "ADMINISTRADOR");
            obj = em.find(Person.class, 1);            
            obj.getPermissions().add(p);
            em.getTransaction().begin();
            em.merge(obj);
            em.getTransaction().commit();
        } catch (Exception e) {
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);
    }
}
