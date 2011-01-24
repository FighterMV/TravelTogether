/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rwth.travelTogether.controller;

import com.rwth.travelTogether.persistence.GroupDAO;
import com.rwth.travelTogether.model.Group;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.validation.BindingResult;

/**
 *
 * @author marco
 */
@Controller
public class GroupController {

        @Autowired
        GroupDAO groupDAO;

        @Transactional
	@RequestMapping(value = "groups", method = RequestMethod.GET)
	public ModelAndView showGroups() {

            List<Group> allGroups = groupDAO.getGroups();

            ModelAndView modelAndView = new ModelAndView("groups");
            modelAndView.addObject("allGroups", allGroups);

            return modelAndView;

        }

        @Transactional
	@RequestMapping(value = "deleteGroup", method = RequestMethod.POST)
	public ModelAndView deleteGroup(@ModelAttribute("group") Group group, BindingResult result) {

            groupDAO.deleteGroup(group.getId());

            ModelAndView modelAndView = new ModelAndView("groupDeleted");

            return modelAndView;

        }
}
