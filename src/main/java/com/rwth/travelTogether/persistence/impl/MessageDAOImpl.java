/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rwth.travelTogether.persistence.impl;

import com.rwth.travelTogether.model.Message;

import com.rwth.travelTogether.persistence.MessageDAO;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author marco
 */
@Repository
public class MessageDAOImpl implements MessageDAO{

    @Autowired
    private SessionFactory sessionFactory;

    public static final Logger LOGGER = LoggerFactory.getLogger(MessageDAOImpl.class);

    @Override
    public void persist(Message message){
        LOGGER.trace("call to persist message {}", message);
        Session session = sessionFactory.getCurrentSession();

        //hibernate saves the group into the database for us
        session.persist(message);
    }

    @Override
    public Message getFullMessage(Long id){
        Session session = sessionFactory.getCurrentSession();

        //hibernate gets the message for us from the databse
        return (Message) session.get(Message.class, id);
    }

    @Override
    public List<Message> getMessageHeadersOfUser(String username){
        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("select myAlias from Message myAlias where myAlias.receiver = :username");
        query.setString("username", username);

        return query.list();
    }
}
