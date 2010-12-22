/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rwth.travelTogether.controller;

import com.rwth.travelTogether.persistence.GroupDAO;
import com.rwth.travelTogether.persistence.impl.GroupDAOImpl;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 *
 * @author marco
 */

public class GetGroupAPIController implements Controller{

    @Autowired
    private GroupDAO groupDAO;

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        groupDAO = new GroupDAOImpl();

        String xml = new String();

        try{
            xml = groupDAO.getGroupsAsXML();
        }catch(Error e){
            e.printStackTrace();
        }

        ModelAndView modelAndView = new ModelAndView("groupsXML");
        modelAndView.addObject("groupsAsXML", xml);
        return modelAndView;
    }

}
