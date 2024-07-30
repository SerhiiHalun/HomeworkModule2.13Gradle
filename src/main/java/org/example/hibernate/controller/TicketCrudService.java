package org.example.hibernate.controller;


import org.example.entity.Client;
import org.example.entity.Planet;
import org.example.entity.Ticket;
import org.example.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class TicketCrudService {
    private HibernateUtil util = HibernateUtil.getInstance();
    public  void create( Ticket ticket){

        Session session = util.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.merge(ticket);
        transaction.commit();
        session.close();

    }
    public  void updateIdClient(long id, long id_client){
        ClientCrudService clientCrudService = new ClientCrudService();

        Session session = util.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Ticket existing = session.get(Ticket.class,id);
        Client client = clientCrudService.getById(id_client);
        existing.setClient(client);
        session.merge(existing);
        transaction.commit();
        session.close();
    }
    public  Ticket getById(long id){
        Session session = util.getSessionFactory().openSession();
        Ticket ticket = session.get(Ticket.class, id);
        session.close();
        return ticket;
    }
    public List<Ticket> getAll(){
        Session session = util.getSessionFactory().openSession();
        List<Ticket> list = session.createQuery("from Ticket",Ticket.class).list();
        session.close();
        return list;
    }
    public  void deleteById(long id){
        Session session = util.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Ticket ticket = getById(id);
        session.delete(ticket);
        transaction.commit();
        session.close();

    }
}
