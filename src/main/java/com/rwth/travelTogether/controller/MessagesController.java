/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rwth.travelTogether.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author marco
 */
@Controller
public class MessagesController {

	@RequestMapping("messages")
	public ModelAndView showMessages() {

        ModelAndView modelAndView = new ModelAndView("messages");

        return modelAndView;

    }
}
