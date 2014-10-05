package org.presentation.webcrawler.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import org.presentation.model.ContentType;
import org.presentation.model.Header;
import org.presentation.model.LinkURL;
import org.presentation.model.PageContent;

/**
 * Default implementation of PageReciever
 *
 * @author Jindřich Máca
 * @version 1.0
 */
@Dependent
public class PageReceiver {

    @Inject
    @SuppressWarnings("NonConstantLogger")
    private Logger LOG;

    private static final String GET = "GET";
    private static final String HEAD = "HEAD";
    private static final String HTTP = "http";
    private static final String HTTPS = "htpps";

    public ReceiverResponse checkPage(LinkURL linkURL, List<Header> addHeaders) throws MalformedURLException, IOException {
        LOG.log(Level.INFO, "Starting checkPage(HEAD) on {0}", linkURL.getUrl());
        return connectToPage(linkURL, addHeaders, HEAD, false);
    }

    public ReceiverResponse getPage(LinkURL linkURL, List<Header> addHeaders) throws MalformedURLException, IOException {
        LOG.log(Level.INFO, "Starting getPage(GET) on {0}", linkURL.getUrl());
        return connectToPage(linkURL, addHeaders, GET, true);
    }

    private ReceiverResponse connectToPage(LinkURL linkURL, List<Header> addHeaders, String method, Boolean getContent) throws IOException {
        ReceiverResponse response = new ReceiverResponse();
        URL url = new URL(linkURL.getUrl());
        HttpURLConnection connection;
        switch (url.getProtocol().toLowerCase()) {
            case HTTP: {
                connection = (HttpURLConnection) url.openConnection();
                LOG.info("Created HTTP connection.");
                break;
            }
            case HTTPS: {
                connection = (HttpsURLConnection) url.openConnection();
                LOG.info("Created HTTPS connection.");
                break;
            }
            default: {
                LOG.log(Level.WARNING, "Protocol {0} is not supported.", url.getProtocol());
                throw new IOException("Protocol " + url.getProtocol() + " is not supported.");
            }
        }
        connection.setRequestMethod(method);
        connection.setUseCaches(false);
        for (Header addHeader : addHeaders) {
            connection.setRequestProperty(addHeader.getKey(), addHeader.getValue());
        }
        connection.connect();
        LOG.info("Request sent.");

        response.setStateCode(connection.getResponseCode());
        LOG.log(Level.INFO, "Response code is {0}", connection.getResponseCode());
        switch (connection.getResponseCode()) {
            case 200: {
                String contentType = connection.getHeaderField("Content-Type");
                String[] split;
                split = contentType.split(";\\s*(charset=)?");
                response.setContentType(new ContentType(split[0]));
                LOG.log(Level.INFO, "Content-Type is {0}", split[0]);

                if (getContent && method.equals(GET)) {
                    String coding;
                    if (split.length == 2) {
                        coding = split[1];
                    } else {
                        coding = "UTF-8";
                    }
                    LOG.log(Level.INFO, "Coding is {0}", coding);
                    response.setSourceCode(new PageContent(recievePageContent(new BufferedReader(new InputStreamReader(connection.getInputStream(), coding)))));
                }
                break;
            }
            case 301: {
                String location = connection.getHeaderField("Location");
                if (!(location.isEmpty() || location.equals(linkURL.getUrl()))) {
                    LOG.log(Level.INFO, "Redirect 301 to {0}", location);
                    response = connectToPage(new LinkURL(location), addHeaders, method, getContent);
                }
                break;
            }
            case 302: {
                String location = connection.getHeaderField("Location");
                if (!(location.isEmpty() || location.equals(linkURL.getUrl()))) {
                    LOG.log(Level.INFO, "Redirect 302 to {0}", location);
                    response = connectToPage(new LinkURL(location), addHeaders, method, getContent);
                }
                break;
            }
            case 405: {
                if (method.equals(HEAD)) {
                    LOG.info("Server refused HEAD, trying GET.");
                    response = connectToPage(linkURL, addHeaders, GET, false);
                }
                break;
            }
        }

        if (response.getContentType().getContentType() == null) {
            response.setContentType(new ContentType(""));
        }

        if (response.getSourceCode().getContent() == null) {
            response.setSourceCode(new PageContent(""));
        }

        LOG.log(Level.INFO, "Finished request on {0}", linkURL.getUrl());
        return response;
    }

    private String recievePageContent(BufferedReader in) throws IOException {
        String inputLine;
        StringBuilder response = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        LOG.info("Content successfuly loaded.");
        return response.toString();
    }

}