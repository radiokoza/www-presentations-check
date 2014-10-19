package org.presentation.validatorcss.impl;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import org.presentation.model.ContentType;
import org.presentation.model.LinkURL;
import org.presentation.model.PageContent;
import org.presentation.model.logging.ErrorMsg;
import org.presentation.model.logging.InfoMsg;
import org.presentation.model.logging.MessageLogger;
import org.presentation.model.logging.MessageLoggerContainer;
import org.presentation.model.logging.MsgLocation;
import org.presentation.model.logging.WarningMsg;
import org.presentation.singlepagecontroller.SinglePageControllerService;
import org.w3._2003._05.soap_envelope.Envelope;
import org.w3._2005._07.css_validator.CSSValidationResponse;
import org.w3._2005._07.css_validator.ErrorList;
import org.w3._2005._07.css_validator.Result;
import org.w3._2005._07.css_validator.ValidationErrors;
import org.w3._2005._07.css_validator.ValidationWarnings;
import org.w3._2005._07.css_validator.Warning;
import org.w3._2005._07.css_validator.WarningList;

/**
 * CSS validator service.
 *
 * @author Jindřich Máca
 */
@Dependent
public class CSSValidatorImpl implements SinglePageControllerService {

    /**
     * Package friendly constant for option interface.
     */
    static final String SERVICE_NAME = "CSS validator";
    /**
     * Constant representing W3C url of validation service for CSS.
     */
    private static final String VALIDATION_SERVICE = "http://jigsaw.w3.org/css-validator/validator";

    /**
     * Inject logger.
     */
    @Inject
    @SuppressWarnings("NonConstantLogger")
    private Logger LOG;
    /**
     * Message logger for this resource.
     */
    private MessageLogger logger;

    /**
     * Returns input stream with SOAP respons of CSS W3C validation service.
     *
     * @param urlToValidate URL which will be validated
     * @return Input stream wich SOAP respons of CSS W3C validation service.
     * @throws MalformedURLException If an unknown protocol is specified
     * @throws IOException If request fails in any way
     */
    private InputStream getSOAPInputStream(String urlToValidate) throws MalformedURLException, IOException {
        URL url = new URL(VALIDATION_SERVICE + "?output=soap12&uri=" + urlToValidate);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        return connection.getInputStream();
    }

    /**
     * Process prepared SOAP response for specific URL to relevant messages for
     * user.
     *
     * @param cvr Prepared SOAP response
     * @param url URL releated to validation
     */
    private void processCVR(CSSValidationResponse cvr, LinkURL url) {
        if (!cvr.isValidity()) {
            Result res = cvr.getResult();
            ValidationWarnings warningLists = res.getWarnings();
            for (WarningList warningList : warningLists.getWarninglist()) {
                for (Warning warning : warningList.getWarning()) {
                    if (warning.getMessage() != null) {
                        WarningMsg msg = new WarningMsg();
                        msg.setPage(url);
                        msg.setMessage(warning.getMessage().trim());
                        msg.setMsgLocation(new MsgLocation(warning.getLine(), 0)); //CSS validation do not return column
                        logger.addMessage(msg);
                    }
                }
            }
            LOG.log(Level.INFO, "Logged {0} CSS warnings in file: {1}", new Object[]{res.getWarnings().getWarningcount(), url.getUrl()});
            ValidationErrors errorLists = res.getErrors();
            for (ErrorList errorList : errorLists.getErrorlist()) {
                for (org.w3._2005._07.css_validator.Error error : errorList.getError()) {
                    if (error.getMessage() != null) {
                        ErrorMsg msg = new ErrorMsg();
                        msg.setPage(url);
                        msg.setMessage(error.getMessage().trim());
                        msg.setMsgLocation(new MsgLocation(error.getLine(), 0)); //CSS validation do not return column
                        logger.addMessage(msg);
                    }
                }
            }
            LOG.log(Level.INFO, "Logged {0} CSS errors in file: {1}", new Object[]{res.getErrors().getErrorcount(), url.getUrl()});
            WarningMsg msg = new WarningMsg();
            msg.setPage(url);
            msg.setMessage("CSS file contains " + res.getWarnings().getWarningcount() + " warnings and " + res.getErrors().getErrorcount() + " errors.");
            logger.addMessage(msg);
        } else {
            InfoMsg msg = new InfoMsg();
            msg.setPage(url);
            msg.setMessage("Validation of CSS file contains no warning or errors.");
            logger.addMessage(msg);
            LOG.log(Level.INFO, "Validation of CSS file {0} contains no warning or errors.", url.getUrl());
        }
    }

    @Override
    public void checkPage(ContentType contentType, LinkURL url, PageContent text) {
        LOG.log(Level.INFO, "Checking validity of css {0}", url.getUrl());
        try {
            InputStream stream = getSOAPInputStream(url.getUrl());
            JAXBContext context = JAXBContext.newInstance("org.w3._2003._05.soap_envelope:org.w3._2005._07.css_validator", this.getClass().getClassLoader());
            Unmarshaller un = context.createUnmarshaller();
            Envelope envelope = (Envelope) ((JAXBElement<?>) un.unmarshal(stream)).getValue();
            for (Object i : envelope.getBody().getAny()) {
                i = ((JAXBElement<?>) i).getValue();
                if (i instanceof CSSValidationResponse) {
                    CSSValidationResponse cvr = (CSSValidationResponse) i;
                    processCVR(cvr, url);
                    return;//done successfully
                }
            }
        } catch (IOException ex) {
            LOG.log(Level.WARNING, "{0}", ex.getMessage());
        } catch (JAXBException ex) {
            LOG.log(Level.SEVERE, "unable to initialize JAXB parser", ex);
        }

    }

    @Override
    public void offerMsgLoggerContainer(MessageLoggerContainer messageLoggerContainer) {
        logger = messageLoggerContainer.createLogger("CSS Validator");
    }

    @Override
    public String getID() {
        return SERVICE_NAME;
    }

    @Override
    public void stopChecking() {
        //nothing to do - body should be empty
    }

    @Override
    public boolean isApplicable(ContentType contentType) {
        return contentType.isCss();
    }

}
