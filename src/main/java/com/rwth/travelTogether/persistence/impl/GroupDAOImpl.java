/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rwth.travelTogether.persistence.impl;

import com.rwth.travelTogether.persistence.GroupDAO;
import com.rwth.travelTogether.model.Group;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author marco
 */
@Repository
public class GroupDAOImpl implements GroupDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void persist(Group group) {

            Session session = sessionFactory.getCurrentSession();

            //hibernate saves the group into the database for us
            session.persist(group);
    }

    @Override
    public Group get(Long id) {

            Session session = sessionFactory.getCurrentSession();

            //hibernate gets the group for us from the databse
            return (Group) session.get(Group.class, id);
    }

}
