/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.presentation.graphgenerator.impl;

import org.presentation.graphgenerator.GraphResult;
import org.presentation.utils.Property;

/**
 * This class represents traversal graph tree by using HTML tags as nested
 * unordered lists.
 *
 * @author Adam Kugler
 * @version 1.0-SNAPSHOT
 */
public class TraversalGraphTree extends GraphResult {

    private final String tagTree;

    /**
     * <p>
     * Constructor for TraversalGraphTree.</p>
     *
     * @param tagTree Tag tree created by graph text generator
     */
    public TraversalGraphTree(String tagTree) {
        this.tagTree = tagTree;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getResultAsCode() {
        return tagTree;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getResultId() {
        return Property.getInstance().getStringPropery("TraversalTreeGraph");
    }

}
