package org.example.hibernate.controller;

import org.example.entity.Planet;
import org.example.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PlanetCrudService {
    private  HibernateUtil util = HibernateUtil.getInstance();
    public  void create( Planet planet){

        Session session = util.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.merge(planet);
        transaction.commit();
        session.close();

    }
    public  void updateNamePlanet(String id,String name){

        Session session = util.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Planet existing = session.get(Planet.class,id);
        existing.setName(name);
        session.merge(existing);
        transaction.commit();
        session.close();
    }
    public  Planet getById(String id){
        Session session = util.getSessionFactory().openSession();
        Planet planet = session.get(Planet.class, id);
        session.close();
        return planet;
    }
    public  List<Planet> getAll(){
        Session session = util.getSessionFactory().openSession();
        List<Planet> list = session.createQuery("from Planet",Planet.class).list();
        session.close();
        return list;
    }
    public  void deleteById(Planet planet){
        Session session = util.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(planet);
        transaction.commit();
        session.close();

    }
}
