/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.presentation.presentation.converter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import org.presentation.model.Domain;

/**
 * JSF converter - converts domain newline-separated list - List of Domain
 * objects
 *
 * @author petrof
 * @version $Id: $Id
 */
@FacesConverter("DomainListConverter")
public class DomainListConverter implements Converter {

    /**
     * {@inheritDoc}
     */
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {

        List<Domain> domains = new ArrayList<>();

        String[] domainNames = value.split("\\r?\\n");

        for (String domainName : domainNames) {
            if (domainName.trim().length() > 0) {
                domains.add(new Domain(domainName.trim()));
            }
        }

        return domains;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {

        StringBuilder sb = new StringBuilder();

        for (Iterator it = ((List) value).iterator(); it.hasNext();) {
            Domain domain = (Domain) it.next();
            sb.append(domain.getDomain());
            if (it.hasNext()) {
                sb.append("\n");
            }
        }

        return sb.toString();
    }

}
