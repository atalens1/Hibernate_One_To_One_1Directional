package com.iticbcn.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.JDBCConnectionException;

import com.iticbcn.hibernate.Model.Despatx;
import com.iticbcn.hibernate.Model.Empleats;

import jakarta.validation.ConstraintViolationException;

public class Main {
    public static void main(String[] args) {

        try (SessionFactory sesion = HibernateUtil.getSessionFactory()) {
            try (Session session = sesion.openSession()) {

                session.beginTransaction();

                try {
                    Despatx d1 = new Despatx(1004, "Dunder Mifflin Scranton");
                    Empleats e1 = new Empleats("Pam Beesly", d1);
                    
                    session.persist(e1);
                    
                    session.getTransaction().commit(); 

                } catch (ConstraintViolationException cve) {
                    System.err.println("Error de restricció de base de dades: " + cve.getMessage());
                    cve.printStackTrace();
                    throw cve; 

                } catch (JDBCConnectionException jce) {
                    System.err.println("Error de conexió a la base de dades: " + jce.getMessage());
                    jce.printStackTrace();
                    throw jce;

                } catch (HibernateException hbe) {
                    System.err.println("Error d'Hibernate: " + hbe.getMessage());
                    hbe.printStackTrace();
                    throw hbe;

                } catch (Exception e) { 
                    System.err.println("Error inesperado: " + e.getMessage());
                    e.printStackTrace();
                    throw e;

                } finally { 
                    if (session.getTransaction().isActive()) {
                        session.getTransaction().rollback();
                        System.err.println("No s'ha persistit l'objecte");
                    }
                }

            } catch (HibernateException hbe) {
                System.err.println("Error amb la sessió: "+hbe.getMessage());
                hbe.printStackTrace();
                throw hbe;     
            }
        } catch (HibernateException hbe) {
            System.err.println("Error inicialitzant Hibernate: "+hbe.getMessage());
            hbe.printStackTrace();
            throw hbe;
        } 
    }
}
