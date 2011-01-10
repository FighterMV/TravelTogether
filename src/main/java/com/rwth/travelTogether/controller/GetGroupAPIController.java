/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rwth.travelTogether.controller;

import com.rwth.travelTogether.persistence.GroupDAO;
import com.rwth.travelTogether.persistence.impl.GroupDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author marco
 */
@Controller
public class GetGroupAPIController{

    @Autowired
    private GroupDAO groupDAO;

    @Transactional
    @RequestMapping(value = "groupAPI", method = RequestMethod.GET)
    public ModelAndView groupAPI(){

        String xml = new String();
        
        xml = groupDAO.getGroupsAsXML();

        ModelAndView modelAndView = new ModelAndView("groupsXML");
        modelAndView.addObject("groupsAsXML", xml);
        return modelAndView;
    }

}
