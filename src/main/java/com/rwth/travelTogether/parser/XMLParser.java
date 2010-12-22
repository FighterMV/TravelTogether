/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rwth.travelTogether.parser;

import com.rwth.travelTogether.model.Group;
import java.util.List;

/**
 *
 * @author marco
 */
public class XMLParser {

    public XMLParser(){

    }

    public String parseGroupsToXML(List<Group> groups){

        String xml = new String();

        xml += "<?xml version='1.0'>";

        for(Group group : groups){
            xml += "<group>";
            xml += "<name>";
            xml += group.getName();
            xml += "</name>";
            xml += "<founder>";
            xml += group.getFounder();
            xml += "</founder>";
            xml += "</group>";
        }

        return xml;
    }

}
