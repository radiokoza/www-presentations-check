package org.presentation.model;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Objects;
import org.w3c.dom.Node;

/**
 * This class represents the URL web address.
 *
 * @author Jindřich Máca
 * @version $Id: $Id
 */
public class LinkURL {

    //Text representaion of the URL web address
    private final String url;

    /**
     * Creates new instance of {@link org.presentation.model.LinkURL}.
     *
     * @param url {@link java.lang.String} representation of the URL web address
     */
    public LinkURL(String url) {
        this.url = normalize(url);
    }

    /**
     * <p>
     * Constructor for LinkURL.</p>
     *
     * @param hrefAttr a {@link org.w3c.dom.Node} object.
     */
    public LinkURL(Node hrefAttr) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Method used for normalization of {@link String} representation of URL
     * address by using {@link URI#normalize() } method.
     *
     * @param url {@link String} representation of URL address
     * @return {@link String} normalized URL address; {@link String} same url
     * address as given, because it is not normalizable
     */
    private String normalize(String url) {
        try {
            return new URI(url).normalize().toString();
        } catch (URISyntaxException ex) {
            return url; //return same url as given, becaused it is not normalizable
        }
    }

    /**
     * Returns the {@link java.lang.String} representation of
     * {@link org.presentation.model.LinkURL}.
     *
     * @return {@link java.lang.String} representaion of the URL web address
     */
    public String getUrl() {
        return url;
    }

    /**
     * Checks if {@link org.presentation.model.LinkURL} starts with http or
     * https protokol clause.
     *
     * @return {@code true} if {@link java.lang.String} representaion of the URL
     * starts with "http://" or "https://" protokol clause; {@code false}
     * otherwise
     */
    public boolean checkURL() {
        if (url.length() > 7) {
            if (url.substring(0, 7).equals("http://") || url.substring(0, 8).equals("https://")) {
                return true;
            }
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return url.hashCode(); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LinkURL other = (LinkURL) obj;
        return Objects.equals(this.url, other.url);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return url;
    }

}
