/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rwth.travelTogether.controller;

import com.rwth.travelTogether.model.Message;
import com.rwth.travelTogether.persistence.MessageDAO;
import java.util.Calendar;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
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
public class MessageController {

    @Autowired
    MessageDAO messageDAO;

    @Transactional
    @RequestMapping(value = "/messageHeaders", method = RequestMethod.GET)
    public ModelAndView showMessageHeaders() {

        final String currentUser = SecurityContextHolder.getContext().getAuthentication().getName();

        List<Message> allMessages = messageDAO.getMessageHeadersOfUser(currentUser);

        ModelAndView modelAndView = new ModelAndView("messageHeaders");
        modelAndView.addObject("allMessages", allMessages);

        return modelAndView;

    }

    @RequestMapping("/writeMessageForm")
    public ModelAndView openWriteMessageForm() {

        ModelAndView modelAndView = new ModelAndView("writeMessageForm");

        return modelAndView;

    }

    @Transactional
    @RequestMapping(value = "/sendMessage", method = RequestMethod.POST)
        public ModelAndView createGroup(@ModelAttribute("message") Message message, BindingResult result) {

        final String currentUser = SecurityContextHolder.getContext().getAuthentication().getName();

        Calendar calendar = Calendar.getInstance();
        message.setCreationDate(calendar.getTime());

        final String sender = SecurityContextHolder.getContext().getAuthentication().getName();
        message.setSender(sender);

	messageDAO.persist(message);

        ModelAndView modelAndView = new ModelAndView("messageSent");
        return modelAndView;
    }

}
