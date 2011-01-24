/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rwth.travelTogether.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 *
 * @author marco
 */
@Controller
public class ProfileController {

	@RequestMapping("/profile")
	public ModelAndView openProfile() {

        final String currentUser = SecurityContextHolder.getContext().getAuthentication().getName();

        ModelAndView modelAndView = new ModelAndView("profile");
        modelAndView.addObject("currentUser", currentUser);

        return modelAndView;

    }
}
