/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rwth.travelTogether.persistence.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rwth.travelTogether.model.Group;
import com.rwth.travelTogether.parser.XMLParser;
import com.rwth.travelTogether.persistence.GroupDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marco
 */
@Repository
public class GroupDAOImpl implements GroupDAO{

    @Autowired
    private SessionFactory sessionFactory;

	public static final Logger LOGGER = LoggerFactory.getLogger(GroupDAOImpl.class);

    @Override
    public void persist(Group group) {

		LOGGER.trace("call to persist group {}", group);
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

    @Override
    public String getGroupsAsXML(){
        //faking groups atm
        Group group1 = new Group();
        group1.setFounder("TestFounder1");
        group1.setName("TestGroup1");

        Group group2 = new Group();
        group2.setFounder("TestFounder2");
        group2.setName("TestGroup2");

        Group group3 = new Group();
        group3.setFounder("TestFounder3");
        group3.setName("TestGroup3");

        List<Group> groups = new ArrayList<Group>();
        groups.add(group1);
        groups.add(group2);
        groups.add(group3);

        XMLParser xmlParser = new XMLParser();
        return xmlParser.parseGroupsToXML(groups);
    }

}
