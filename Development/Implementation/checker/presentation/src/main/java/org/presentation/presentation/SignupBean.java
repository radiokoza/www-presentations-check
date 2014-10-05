/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.presentation.presentation;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.presentation.presentation.validation.ValidEmail;
import org.presentation.presentation.validation.ValidPassword;

/**
 *
 * @author petrof
 */
@Named
@RequestScoped
public class SignupBean extends CommonBean {
    
    @NotNull
    @ValidEmail
    private String email;
    
    @NotNull
    @ValidPassword
    private String password;
    
    @Size(min=2)
    @NotNull
    private String name;
    
    @Size(min=2)
    @NotNull    
    private String surname;
    
    public String signUp() throws Exception{		
	
	if(persistance.createNewUser(email, password, name, surname) == true) {
	    // todo the login procedure automatically
	    
	    return "/protected/user/index.xhtml?faces-redirect=true";
	} else {
	    this.addMessage(new FacesMessage(this.msg.getString("signUp.fail_message")));
	}
	
	return "";
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getSurname() {
	return surname;
    }

    public void setSurname(String surname) {
	this.surname = surname;
    }
    
    
    
}