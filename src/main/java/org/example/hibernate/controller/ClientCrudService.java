package org.example.hibernate.controller;

import org.example.entity.Client;
import org.example.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ClientCrudService {
    private  HibernateUtil util = HibernateUtil.getInstance();
    public  void create( Client newClient){

        Session session = util.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(newClient);
        transaction.commit();
        session.close();

    }
    public  void updateName(long id,String name){

        Session session = util.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Client existing = session.get(Client.class,id);
        existing.setName(name);
        session.merge(existing);
        transaction.commit();
        session.close();
    }
    public  Client getById(long id){
        Session session = util.getSessionFactory().openSession();
        Client client = session.get(Client.class, id);
        session.close();
        return client;
    }
    public  List<Client> getAll(){
        Session session = util.getSessionFactory().openSession();
        List<Client> list = session.createQuery("from Client",Client.class).list();
        session.close();
        return list;
    }
    public  void deleteById(Client client){
        Session session = util.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(client);
        transaction.commit();
        session.close();

    }



}
