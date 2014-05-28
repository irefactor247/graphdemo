package graphdemo;

import java.util.prefs.Preferences;

public class SettingsManager
{
    public enum ExplorationAlgorithm
    {
        DFS, BFS, EDGE_DFS, EDGE_BFS;
        
        @Override
        public String toString()
        {
            String friendlyName;
            switch (this)
            {
                default:
                case DFS:
                    friendlyName = "Depth First Search";
                    break;
                    
                case BFS:
                    friendlyName = "Breadth First Search";
                    break;
                    
                case EDGE_DFS:
                    friendlyName = "Edge Depth First Search";
                    break;
                    
                case EDGE_BFS:
                    friendlyName = "Edge Breadth First Search";
                    break;
            }
            return friendlyName;
        }
    }
    
    public enum GraphType
    {
        DIRECTED, UNDIRECTED, MIXED;
        
        @Override
        public String toString()
        {
            String friendlyName;
            switch (this)
            {
                default:
                case DIRECTED:
                    friendlyName = "Directed";
                    break;
                    
                case UNDIRECTED:
                    friendlyName = "Undirected";
                    break;
                    
                case MIXED:
                    friendlyName = "Mixed";
                    break;
            }
            return friendlyName;
        }
    }
    
    public enum GraphLayout
    {
        // TODO check out other layouts which need additional settings
        CIRCLE, FR, ISOM, KK, SPRING;
        
        @Override
        public String toString()
        {
            String friendlyName;
            switch (this)
            {
                default:
                case CIRCLE:
                    friendlyName = "Circle";
                    break;
                    
                case FR:
                    friendlyName = "FR";
                    break;
                    
                case ISOM:
                    friendlyName = "ISOM";
                    break;
                    
                case KK:
                    friendlyName = "KK";
                    break;
                    
                case SPRING:
                    friendlyName = "Spring";
                    break;
            }
            return friendlyName;
        }
    }
    
    public static final int MIN_ANIMATION_DELAY_MS = 0;
    public static final int MAX_ANIMATION_DELAY_MS = 10000;
    public  static final int DEFAULT_ANIMATION_DELAY_MS = 1000;
    private static final ExplorationAlgorithm DEFAULT_EXPLORATION_ALGORITHM = ExplorationAlgorithm.DFS;
    private static final GraphType DEFAULT_GRAPH_TYPE = GraphType.DIRECTED;
    private static final boolean DEFAULT_GRAPH_IS_WEIGTHED = false;
    private static final GraphLayout DEFAULT_GRAPH_LAYOUT = GraphLayout.CIRCLE;
    public static final double MIN_EDGE_PROBABILITY = 0.0;
    public static final double MAX_EDGE_PROBABILITY = 1.0;
    public static final double DEFAULT_EDGE_PROBABILITY = 0.5;
    public static final int MIN_NUMBER_OF_VERTICES = 1;
    public static final int MAX_NUMBER_OF_VERTICES = 1000;
    public static final int DEFAULT_NUMBER_OF_VERTICES = 10;
    private static final String KEY_ANIMATION_DELAY_MS = "animation_delay_ms";
    private static final String KEY_EXPLORATION_ALGORITHM = "exploration_algorithm";
    private static final String KEY_GRAPH_TYPE = "graph_type";
    private static final String KEY_GRAPH_IS_WEIGHTED = "graph_is_weighted";
    private static final String KEY_GRAPH_LAYOUT = "graph_layout";
    private static final String KEY_EDGE_PROBABILITY = "edge_probability";
    private static final String KEY_NUMBER_OF_VERTICES = "number_of_vertices";
    // Instance needs to be set as the last static member
    private static final SettingsManager instance = new SettingsManager();
    private Preferences preferences;
    private int animationDelayMs;
    private ExplorationAlgorithm explorationAlgorithm;
    private GraphType graphType;
    private boolean graphIsWeighted;
    private GraphLayout graphLayout;
    private double edgeProbability;
    private int numberOfVertices;

    private SettingsManager()
    {
        try 
        {
            this.preferences = Preferences.userRoot().node(this.getClass().getName());
            this.animationDelayMs = this.preferences.getInt(
                KEY_ANIMATION_DELAY_MS, DEFAULT_ANIMATION_DELAY_MS);
            this.explorationAlgorithm = ExplorationAlgorithm.valueOf(
                this.preferences.get(KEY_EXPLORATION_ALGORITHM, DEFAULT_EXPLORATION_ALGORITHM.name()));
            this.graphType = GraphType.valueOf(
                this.preferences.get(KEY_GRAPH_TYPE, DEFAULT_GRAPH_TYPE.name()));
            this.graphIsWeighted = this.preferences.getBoolean(
                KEY_GRAPH_IS_WEIGHTED, DEFAULT_GRAPH_IS_WEIGTHED);
            this.graphLayout = GraphLayout.valueOf(
                this.preferences.get(KEY_GRAPH_LAYOUT, DEFAULT_GRAPH_LAYOUT.name()));
            this.edgeProbability = this.preferences.getDouble(
                KEY_EDGE_PROBABILITY, DEFAULT_EDGE_PROBABILITY);
            this.numberOfVertices = this.preferences.getInt(
                KEY_NUMBER_OF_VERTICES, DEFAULT_NUMBER_OF_VERTICES);
        }
        catch (Exception ex)
        {
            resetAll();
        }
    }
    
    public static SettingsManager instance()
    {
        return instance;
    }
    
    public void setAnimationDelayMs(int animationDelayMs)
    {
        if (this.animationDelayMs != animationDelayMs)
        {
            if (animationDelayMs < MIN_ANIMATION_DELAY_MS)
            {
                this.animationDelayMs = MIN_ANIMATION_DELAY_MS;
            }
            else if (animationDelayMs > MAX_ANIMATION_DELAY_MS)
            {
                this.animationDelayMs = MAX_ANIMATION_DELAY_MS;
            }
            else
            {
                this.animationDelayMs = animationDelayMs;
            }

            try 
            {
                this.preferences.putInt(KEY_ANIMATION_DELAY_MS, this.animationDelayMs);
            }
            catch (Exception ex)
            {
                // TODO
            }
        }
    }
    
    public int getAnimationDelayMs()
    {
        return this.animationDelayMs;
    }
    
    public void setExplorationAlgorithm(ExplorationAlgorithm explorationAlgorithm)
    {
        if (this.explorationAlgorithm != explorationAlgorithm)
        {
            this.explorationAlgorithm = explorationAlgorithm;
    
            try
            {
                this.preferences.put(KEY_EXPLORATION_ALGORITHM, this.explorationAlgorithm.name());
            }
            catch (Exception ex)
            {
                // TODO
            }
        }
    }
    
    public ExplorationAlgorithm getExplorationAlgorithm()
    {
        return this.explorationAlgorithm;
    }

    public void setGraphType(GraphType graph_type)
    {
        if (this.graphType != graph_type)
        {
            this.graphType = graph_type;
    
            try
            {
                this.preferences.put(KEY_GRAPH_TYPE, this.graphType.name());
            }
            catch (Exception ex)
            {
                // TODO
            }
        }
    }

    public GraphType getGraphType()
    {
        return this.graphType;
    }
    
    public void setGraphIsWeighted(boolean graphIsWeighted)
    {
        if (this.graphIsWeighted != graphIsWeighted)
        {
            this.graphIsWeighted = graphIsWeighted;
    
            try
            {
                this.preferences.putBoolean(KEY_GRAPH_IS_WEIGHTED, this.graphIsWeighted);
            }
            catch (Exception ex)
            {
                // TODO
            }
        }
    }
    
    public boolean getGraphIsWeighted()
    {
        return this.graphIsWeighted;
    }
    
    public void setGraphLayout(GraphLayout graphLayout)
    {
        if (this.graphLayout != graphLayout)
        {
            this.graphLayout = graphLayout;
    
            try
            {
                this.preferences.put(KEY_GRAPH_LAYOUT, this.graphLayout.name());
            }
            catch (Exception ex)
            {
                // TODO
            }
        }
    }
    
    public GraphLayout getGraphLayout()
    {
        return this.graphLayout;
    }
    
    public void setEdgeProbability(double edgeProbability)
    {
        if (this.edgeProbability != edgeProbability)
        {
            if (edgeProbability < MIN_EDGE_PROBABILITY)
            {
                this.edgeProbability = MIN_EDGE_PROBABILITY;
            }
            else if (edgeProbability > MAX_EDGE_PROBABILITY)
            {
                this.edgeProbability = MAX_EDGE_PROBABILITY;
            }
            else
            {
                this.edgeProbability = edgeProbability;
            }

            try 
            {
                this.preferences.putDouble(KEY_EDGE_PROBABILITY, this.edgeProbability);
            }
            catch (Exception ex)
            {
                // TODO
            }
        }
    }
    
    public double getEdgeProbability()
    {
        return this.edgeProbability;
    }
    
    public void setNumberOfVertices(int numberOfVertices)
    {
        if (this.numberOfVertices != numberOfVertices)
        {
            if (numberOfVertices < MIN_NUMBER_OF_VERTICES)
            {
                this.numberOfVertices = MIN_NUMBER_OF_VERTICES;
            }
            else if (numberOfVertices > MAX_NUMBER_OF_VERTICES)
            {
                this.numberOfVertices = MAX_NUMBER_OF_VERTICES;
            }
            else
            {
                this.numberOfVertices = numberOfVertices;
            }

            try 
            {
                this.preferences.putInt(KEY_NUMBER_OF_VERTICES, this.numberOfVertices);
            }
            catch (Exception ex)
            {
                // TODO
            }
        }
    }
    
    public int getNumberOfVertices()
    {
        return this.numberOfVertices;
    }
    
    public final void resetAll()
    {
        this.setAnimationDelayMs(DEFAULT_ANIMATION_DELAY_MS);
        this.setExplorationAlgorithm(DEFAULT_EXPLORATION_ALGORITHM);
        this.setGraphType(DEFAULT_GRAPH_TYPE);
        this.setGraphIsWeighted(DEFAULT_GRAPH_IS_WEIGTHED);
        this.setGraphLayout(DEFAULT_GRAPH_LAYOUT);
        this.setEdgeProbability(DEFAULT_EDGE_PROBABILITY);
        this.setNumberOfVertices(DEFAULT_NUMBER_OF_VERTICES);
    }
}
