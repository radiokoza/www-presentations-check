package org.presentation.graphgenerator;

import org.presentation.model.graph.TraversalGraph;

/**
 * This class generates displayable form of traversal graph.
 *
 * @author Adam Kugler
 * @version 1.0-SNAPSHOT
 */
public abstract class GraphGenerator {

    /**
     * Generates displayable form of traversal graph from given graph.
     *
     * @param graph Graph that schould be processed
     * @return Graph in displayable form.
     */
    public abstract GraphResult generateGraphResult(TraversalGraph graph);
}
