/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.presentation.cssredundancychecker.model;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.presentation.model.LinkURL;
import org.presentation.parser.HTMLCode;

/**
 *
 * @author petrof
 */
public class CRCHtmlCode {

    @Inject
    @SuppressWarnings("NonConstantLogger")
    private Logger LOG;
    
    protected List<LinkURL> stylesheetFilesRequired;
    protected HTMLCode htmlCode;

    public CRCHtmlCode(HTMLCode htmlCode) {
	this.htmlCode = htmlCode;	
	this.stylesheetFilesRequired = new ArrayList<>();
	this.loadStylesheetsRequiredFromDocument();
    }
    
    public HTMLCode getHtmlCode() {
	return htmlCode;
    }        

    public List<LinkURL> getStylesheetFilesRequired() {
	return stylesheetFilesRequired;
    }
        
    /**
     * This method retrieves required stylesheet URLs from the document.
     * The URLs are retrieved from &lt;link&gt; tags.
     */
    private void loadStylesheetsRequiredFromDocument() {
	Elements links = this.htmlCode.getParsedHTML().select("link[href]");
	for (Element link : links) {
            String type = link.attr("type");
	    String rel = link.attr("rel");
	    if((type != null && (type.toLowerCase().equals("text/css"))) || (rel != null && (rel.toLowerCase().equals("stylesheet")))) {
		String cssHref = link.attr("abs:href");
		if(cssHref != null) {
		    LinkURL stylesheetResource = new LinkURL(cssHref.split("#")[0]);
		    if(LOG != null) LOG.log(Level.INFO, "CSSRC - found CSS: {0}", stylesheetResource.getUrl());	    		
		    if (stylesheetResource.checkURL()) {
			this.stylesheetFilesRequired.add(stylesheetResource);
		    }
		}
	    }
        }
    }
    
}
