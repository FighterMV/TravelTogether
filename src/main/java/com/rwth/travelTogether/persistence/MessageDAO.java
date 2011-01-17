/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rwth.travelTogether.persistence;

import com.rwth.travelTogether.model.Message;
import java.util.List;

/**
 *
 * @author marco
 */
public interface MessageDAO {

    void persist(Message message);

    Message getFullMessage(Long id);

    List<Message> getMessageHeadersOfUser(String username);

}
