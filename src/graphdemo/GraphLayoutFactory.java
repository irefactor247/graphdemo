package graphdemo;

import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.algorithms.layout.DAGLayout;
import edu.uci.ics.jung.algorithms.layout.FRLayout;
import edu.uci.ics.jung.algorithms.layout.ISOMLayout;
import edu.uci.ics.jung.algorithms.layout.KKLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.algorithms.layout.SpringLayout;
import edu.uci.ics.jung.algorithms.layout.StaticLayout;
import edu.uci.ics.jung.graph.Graph;

public class GraphLayoutFactory
{
    private static final GraphLayoutFactory instance = new GraphLayoutFactory();
    
    public static GraphLayoutFactory instance()
    {
        return instance;
    }
    
    public Layout<Vertex, Edge> newLayout(Graph<Vertex, Edge> graph)
    {
        Layout<Vertex, Edge> layout;
        switch (SettingsManager.instance().getGraphLayout())
        {
            default:
            case CIRCLE:
                layout = new CircleLayout<>(graph);
                break;
                
            case FR:
                layout = new FRLayout<>(graph);
                break;

            case ISOM:
                layout = new ISOMLayout<>(graph);
                break;

            case KK:
                layout = new KKLayout<>(graph);
                break;

            case SPRING:
                layout = new SpringLayout<>(graph);
                break;
        }
        
        return layout;
    }
}
