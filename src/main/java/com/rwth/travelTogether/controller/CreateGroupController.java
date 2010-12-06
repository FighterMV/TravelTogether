/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rwth.travelTogether.controller;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.rwth.travelTogether.model.Group;
import com.rwth.travelTogether.persistence.GroupDAO;
import com.rwth.travelTogether.persistence.impl.GroupDAOImpl;
import java.io.IOException;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 *
 * @author marco
 */
@org.springframework.stereotype.Controller
@SessionAttributes
public class CreateGroupController{
    
    @Autowired
    private GroupDAO groupDAO;

    //We are binding our request into the group instance of Group
    @Transactional
    @RequestMapping(value = "/createGroup", method = RequestMethod.POST)
        public ModelAndView createGroup(@ModelAttribute("group") Group group, BindingResult result) {

        groupDAO = new GroupDAOImpl();

        group.setFounder("TestFounder");

        Calendar calendar = Calendar.getInstance();
        group.setCreationDate(calendar.getTime());

        try{
            groupDAO.persist(group);
        }catch(Error e){
            e.printStackTrace();
        }

        ModelAndView modelAndView = new ModelAndView("groups");
        return modelAndView;
    }
    
}
