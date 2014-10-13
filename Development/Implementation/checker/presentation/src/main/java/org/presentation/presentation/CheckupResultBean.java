/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.presentation.presentation;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.MissingResourceException;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.validation.constraints.NotNull;
import org.presentation.model.logging.Message;
import org.presentation.persistence.model.Checkup;
import org.presentation.persistence.model.User;
import org.presentation.presentation.exception.UserAuthorizationException;

/**
 *
 * @author petrof
 */
@Named
@RequestScoped
public class CheckupResultBean extends ProtectedBean {

    @NotNull
    protected int checkupId;
    protected int checkupId2;
    
    protected List<String> messageResourcesAvailable;
    protected String[] messageResourcesAllowed;
    
    protected Checkup checkup;
    

    public int getCheckupId() {
	return checkupId;
    }       
    
    
    public void showResult() throws UserAuthorizationException{
	Checkup c = this.persistance.findCheckup(checkupId);		
	User user;		
	
	this.checkupId2 = checkupId;
	
	this.checkup = c;
	
	if(c == null){
	    this.addMessage(new FacesMessage(msg.getString("common.checkup_not_found")));
	    return;
	}
	
	user = c.getUser();	
	if(user == null || !user.equals(this.getLoggedUser())) {
	    this.addMessage(new FacesMessage(msg.getString("common.checkup_not_yours")));
	    return;
	}
	
	this.messageResourcesAvailable = this.persistance.findCheckupMessageResources(c);
	
	if(this.messageResourcesAllowed != null && this.messageResourcesAllowed.length > 0 && !this.messageResourcesAvailable.containsAll(Arrays.asList(messageResourcesAllowed))) {
	    this.messageResourcesAllowed = null;
	    this.addMessage(new FacesMessage(msg.getString("checkupResult.resource_not_available")));
	    return;	    
	}
    }

    
    public List<Message> getMessages() throws UserAuthorizationException {
	if(this.messageResourcesAllowed == null || this.messageResourcesAllowed.length == 0) {
	    return this.checkup == null ? null : this.persistance.findCheckupMessages(this.checkup);
	} else {
	    return this.checkup == null ? null : this.persistance.findCheckupMessages(this.checkup);
	    // todo - fetch only checkups with desired resources
	    //this.persistance.findCheckupMessagesWithResource(checkup, null)
	}
    }

    public Checkup getCheckup() {
	return checkup;
    }

    public void setCheckupId(int checkupId) {
	this.checkupId = checkupId;
    }        

 
    public Map<String,Object> getMessageResourcesAvailable() {	
	Map<String,Object> resourcesAvailable = new HashMap<>();	    
	
	if(this.messageResourcesAvailable != null) {
	    for(String s : this.messageResourcesAvailable) {
		try {
		    resourcesAvailable.put(msg.getString("common.ch_" + s.toLowerCase()), s);
		}
		catch(MissingResourceException e) {
		    resourcesAvailable.put(s, s);
		}
	    }
	}
	
	return resourcesAvailable;
    }    

    public String[] getMessageResourcesAllowed() {
	return messageResourcesAllowed;
    }

    public void setMessageResourcesAllowed(String[] messageResourcesAllowed) {
	this.messageResourcesAllowed = messageResourcesAllowed;
    }

    public int getCheckupId2() {
	return checkupId2;
    }

    public void setCheckupId2(int checkupId2) {
	this.checkupId2 = checkupId2;
    }
    
    
}
