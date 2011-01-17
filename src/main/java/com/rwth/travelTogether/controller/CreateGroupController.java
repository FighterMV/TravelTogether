/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rwth.travelTogether.controller;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.rwth.travelTogether.model.Group;
import com.rwth.travelTogether.persistence.GroupDAO;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 *
 * @author marco
 */
@Controller
public class CreateGroupController{
    
    @Autowired
    private GroupDAO groupDAO;

    //We are binding our request into the group instance of Group
    @Transactional
    @RequestMapping(value = "/createGroup", method = RequestMethod.POST)
        public ModelAndView createGroup(@ModelAttribute("group") Group group, BindingResult result) {

        final String currentUser = SecurityContextHolder.getContext().getAuthentication().getName();

        group.setFounder(currentUser);

        Calendar calendar = Calendar.getInstance();
        group.setCreationDate(calendar.getTime());

	groupDAO.persist(group);

        ModelAndView modelAndView = new ModelAndView("groupCreated");
        return modelAndView;
    }
    
}
