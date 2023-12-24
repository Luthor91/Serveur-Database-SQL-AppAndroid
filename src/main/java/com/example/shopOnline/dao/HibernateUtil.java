package com.example.shopOnline.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
    private static StandardServiceRegistry registry;
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                    .configure() // configurer via hibernate.cfg.xml
                    .build();
            return new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExceptionInInitializerError("Erreur lors de la création de la SessionFactory : " + e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static boolean create(Object o){
        Transaction transaction=null;
        try(Session session=getSessionFactory().openSession()) {
            transaction=session.beginTransaction();
            session.persist(o);
            transaction.commit();
            return true;
        } catch (Exception ex){
            ex.printStackTrace();
            if(transaction!=null) {
                transaction.rollback();
            }
        }
        return false;
    }

    public static boolean delete(Object o){
        Transaction transaction=null;
        try(Session session=getSessionFactory().openSession()) {
            transaction=session.beginTransaction();
            session.remove(o);
            transaction.commit();
            return true;
        }catch (Exception ex){
            ex.printStackTrace();
            if(transaction!=null) {
                transaction.rollback();
            }

        }
        return false;
    }

    public static Object update(Object o){
        Transaction transaction=null;
        try(Session session=getSessionFactory().openSession()) {
            transaction=session.beginTransaction();
            session.merge(o); // Utilisez update au lieu de merge
            transaction.commit();
            return true;
        } catch (Exception ex){
            ex.printStackTrace();
            if(transaction!=null) {
                transaction.rollback();
            }
        }
        return false;
    }


    public static Object getByID(Object id,Class c){
        try(Session session=getSessionFactory().openSession()) {
            return session.find(c,id);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    public static boolean removeByID(Object id,Class c){
        Transaction transaction=null;
        try(Session session=getSessionFactory().openSession()) {
            transaction=session.beginTransaction();
            Object o=getByID(id,c);
            session.remove(o);
            transaction.commit();
            return true;
        }catch (Exception ex){
            ex.printStackTrace();
            if(transaction!=null) {
                transaction.rollback();
            }

        }
        return false;
    }
    public static void shutdown() {
        if (registry != null) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}