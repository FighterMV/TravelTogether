/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rwth.travelTogether.persistence;

import com.rwth.travelTogether.model.Group;
import java.util.List;

/**
 *
 * @author marco
 */
public interface GroupDAO {
        void persist(Group group);

	Group get(Long id);

        String getGroupsAsXML();

        List<Group> getGroups();

        void deleteGroup(long id);
}
