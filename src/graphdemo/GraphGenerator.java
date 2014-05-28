package graphdemo;

import edu.uci.ics.jung.graph.DirectedSparseMultigraph;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseMultigraph;
import edu.uci.ics.jung.graph.UndirectedSparseMultigraph;
import edu.uci.ics.jung.graph.util.EdgeType;
import java.util.Random;

public class GraphGenerator
{
    static public Graph<Vertex, Edge> newGraph()
    {
        Graph<Vertex, Edge> graph;
        switch(SettingsManager.instance().getGraphType())
        {
            default:
            case DIRECTED:
                graph = new DirectedSparseMultigraph<>();
                break;
                
            case UNDIRECTED:
                graph = new UndirectedSparseMultigraph<>();
                break;
                
            case MIXED:
                graph = new SparseMultigraph<>();
                break;
        }
        for (int i = 0; i < SettingsManager.instance().getNumberOfVertices(); ++i)
        {
            Character c = new Character((char)('A' + i));
            graph.addVertex(new Vertex(c.toString()));
        }
        Random random = new Random(System.nanoTime());
        int edgeCouter = 0;
        for (Vertex start: graph.getVertices())
        {
            for (Vertex stop: graph.getVertices())
            {
                if (random.nextDouble() < SettingsManager.instance().getEdgeProbability())
                {
                    Integer i = new Integer(edgeCouter);
                    EdgeType edgeType;
                    
                    switch(SettingsManager.instance().getGraphType())
                    {
                        default:
                        case DIRECTED:
                            edgeType = EdgeType.DIRECTED;
                            break;
                        
                        case UNDIRECTED:
                            edgeType = EdgeType.UNDIRECTED;
                            break;

                        case MIXED:
                            if (random.nextBoolean())
                            {
                                edgeType = EdgeType.DIRECTED;
                            }
                            else
                            {
                                edgeType = EdgeType.UNDIRECTED;
                            }
                            break;
                    }
                    graph.addEdge(new Edge(i.toString()), start, stop, edgeType);
                }
            }
        }
        return graph;
    }
}
