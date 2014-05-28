package graphdemo;

import java.util.prefs.Preferences;

public class SettingsManager
{
    public static final int MIN_ANIMATION_DELAY_MS = 0;
    public static final int MAX_ANIMATION_DELAY_MS = 10000;
    public  static final int DEFAULT_ANIMATION_DELAY_MS = 1000;
    private static final ExplorationAlgorithm DEFAULT_EXPLORATION_ALGORITHM = ExplorationAlgorithm.DFS;
    private static final GraphType DEFAULT_GRAPH_TYPE = GraphType.DIRECTED;
    private static final boolean DEFAULT_GRAPH_IS_WEIGTHED = false;
    private static final GraphLayout DEFAULT_GRAPH_LAYOUT = GraphLayout.CIRCLE;
    public static final double MIN_GRAPH_EDGE_PROBABILITY = 0.0;
    public static final double MAX_GRAPH_EDGE_PROBABILITY = 1.0;
    public static final double DEFAULT_GRAPH_EDGE_PROBABILITY = 0.5;
    public static final int MIN_GRAPH_NUMBER_OF_VERTICES = 1;
    public static final int MAX_GRAPH_NUMBER_OF_VERTICES = 100;
    public static final int DEFAULT_GRAPH_NUMBER_OF_VERTICES = 10;
    public static final int MIN_GRAPH_PARALELL_EDGES_LIMIT = 1;
    public static final int MAX_GRAPH_PARALELL_EDGES_LIMIT = 10;
    public static final int DEFAULT_GRAPH_PARALELL_EDGES_LIMIT = 1;
    private static final String KEY_ANIMATION_DELAY_MS = "animation_delay_ms";
    private static final String KEY_EXPLORATION_ALGORITHM = "exploration_algorithm";
    private static final String KEY_GRAPH_TYPE = "graph_type";
    private static final String KEY_GRAPH_IS_WEIGHTED = "graph_is_weighted";
    private static final String KEY_GRAPH_LAYOUT = "graph_layout";
    private static final String KEY_GRAPH_EDGE_PROBABILITY = "graph_edge_probability";
    private static final String KEY_GRAPH_NUMBER_OF_VERTICES = "graph_number_of_vertices";
    private static final String KEY_GRAPH_PARALELL_EDGES_LIMIT = "graph_paralell_edges_limit";
    // Instance needs to be set as the last static member
    private static final SettingsManager instance = new SettingsManager();
    private Preferences preferences;
    private int animationDelayMs;
    private ExplorationAlgorithm explorationAlgorithm;
    private GraphType graphType;
    private boolean graphIsWeighted;
    private GraphLayout graphLayout;
    private double graphEdgeProbability;
    private int graphNumberOfVertices;
    private int graphParalellEdgesLimit;

    private SettingsManager()
    {
        try 
        {
            preferences = Preferences.userRoot().node(getClass().getName());
            animationDelayMs = preferences.getInt(KEY_ANIMATION_DELAY_MS, DEFAULT_ANIMATION_DELAY_MS);
            explorationAlgorithm = ExplorationAlgorithm.valueOf(
                preferences.get(KEY_EXPLORATION_ALGORITHM, DEFAULT_EXPLORATION_ALGORITHM.name()));
            graphType = GraphType.valueOf(preferences.get(KEY_GRAPH_TYPE, DEFAULT_GRAPH_TYPE.name()));
            graphIsWeighted = preferences.getBoolean(KEY_GRAPH_IS_WEIGHTED, DEFAULT_GRAPH_IS_WEIGTHED);
            graphLayout = GraphLayout.valueOf(preferences.get(KEY_GRAPH_LAYOUT, DEFAULT_GRAPH_LAYOUT.name()));
            graphEdgeProbability = preferences.getDouble(KEY_GRAPH_EDGE_PROBABILITY, DEFAULT_GRAPH_EDGE_PROBABILITY);
            graphNumberOfVertices = preferences.getInt(KEY_GRAPH_NUMBER_OF_VERTICES, DEFAULT_GRAPH_NUMBER_OF_VERTICES);
            graphParalellEdgesLimit = preferences.getInt(KEY_GRAPH_PARALELL_EDGES_LIMIT, DEFAULT_GRAPH_PARALELL_EDGES_LIMIT);
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
                preferences.putInt(KEY_ANIMATION_DELAY_MS, this.animationDelayMs);
            }
            catch (Exception ex)
            {
                // TODO
            }
        }
    }
    
    public int getAnimationDelayMs()
    {
        return animationDelayMs;
    }
    
    public void setExplorationAlgorithm(ExplorationAlgorithm explorationAlgorithm)
    {
        if (this.explorationAlgorithm != explorationAlgorithm)
        {
            this.explorationAlgorithm = explorationAlgorithm;
    
            try
            {
                preferences.put(KEY_EXPLORATION_ALGORITHM, this.explorationAlgorithm.name());
            }
            catch (Exception ex)
            {
                // TODO
            }
        }
    }
    
    public ExplorationAlgorithm getExplorationAlgorithm()
    {
        return explorationAlgorithm;
    }

    public void setGraphType(GraphType graphType)
    {
        if (this.graphType != graphType)
        {
            this.graphType = graphType;
    
            try
            {
                preferences.put(KEY_GRAPH_TYPE, this.graphType.name());
            }
            catch (Exception ex)
            {
                // TODO
            }
        }
    }

    public GraphType getGraphType()
    {
        return graphType;
    }
    
    public void setGraphIsWeighted(boolean graphIsWeighted)
    {
        if (this.graphIsWeighted != graphIsWeighted)
        {
            this.graphIsWeighted = graphIsWeighted;
    
            try
            {
                preferences.putBoolean(KEY_GRAPH_IS_WEIGHTED, this.graphIsWeighted);
            }
            catch (Exception ex)
            {
                // TODO
            }
        }
    }
    
    public boolean getGraphIsWeighted()
    {
        return graphIsWeighted;
    }
    
    public void setGraphLayout(GraphLayout graphLayout)
    {
        if (this.graphLayout != graphLayout)
        {
            this.graphLayout = graphLayout;
    
            try
            {
                preferences.put(KEY_GRAPH_LAYOUT, this.graphLayout.name());
            }
            catch (Exception ex)
            {
                // TODO
            }
        }
    }
    
    public GraphLayout getGraphLayout()
    {
        return graphLayout;
    }
    
    public void setGraphEdgeProbability(double graphEdgeProbability)
    {
        if (this.graphEdgeProbability != graphEdgeProbability)
        {
            if (this.graphEdgeProbability < MIN_GRAPH_EDGE_PROBABILITY)
            {
                this.graphEdgeProbability = MIN_GRAPH_EDGE_PROBABILITY;
            }
            else if (this.graphEdgeProbability > MAX_GRAPH_EDGE_PROBABILITY)
            {
                this.graphEdgeProbability = MAX_GRAPH_EDGE_PROBABILITY;
            }
            else
            {
                this.graphEdgeProbability = graphEdgeProbability;
            }

            try 
            {
                preferences.putDouble(KEY_GRAPH_EDGE_PROBABILITY, this.graphEdgeProbability);
            }
            catch (Exception ex)
            {
                // TODO
            }
        }
    }
    
    public double getGraphEdgeProbability()
    {
        return graphEdgeProbability;
    }
    
    public void setGraphNumberOfVertices(int graphNumberOfVertices)
    {
        if (this.graphNumberOfVertices != graphNumberOfVertices)
        {
            if (this.graphNumberOfVertices < MIN_GRAPH_NUMBER_OF_VERTICES)
            {
                this.graphNumberOfVertices = MIN_GRAPH_NUMBER_OF_VERTICES;
            }
            else if (this.graphNumberOfVertices > MAX_GRAPH_NUMBER_OF_VERTICES)
            {
                this.graphNumberOfVertices = MAX_GRAPH_NUMBER_OF_VERTICES;
            }
            else
            {
                this.graphNumberOfVertices = graphNumberOfVertices;
            }

            try 
            {
                preferences.putInt(KEY_GRAPH_NUMBER_OF_VERTICES, this.graphNumberOfVertices);
            }
            catch (Exception ex)
            {
                // TODO
            }
        }
    }
    
    public int getGraphNumberOfVertices()
    {
        return graphNumberOfVertices;
    }
    
    public void setGraphParalellEdgesLimit(int graphParalellEdgesLimit)
    {
        if (this.graphParalellEdgesLimit != graphParalellEdgesLimit)
        {
            if (this.graphParalellEdgesLimit < MIN_GRAPH_NUMBER_OF_VERTICES)
            {
                this.graphParalellEdgesLimit = MIN_GRAPH_NUMBER_OF_VERTICES;
            }
            else if (this.graphParalellEdgesLimit > MAX_GRAPH_NUMBER_OF_VERTICES)
            {
                this.graphParalellEdgesLimit = MAX_GRAPH_NUMBER_OF_VERTICES;
            }
            else
            {
                this.graphParalellEdgesLimit = graphParalellEdgesLimit;
            }

            try 
            {
                preferences.putInt(KEY_GRAPH_PARALELL_EDGES_LIMIT, this.graphParalellEdgesLimit);
            }
            catch (Exception ex)
            {
                // TODO
            }
        }
    }
    
    public int getGraphParalellEdgesLimit()
    {
        return graphParalellEdgesLimit;
    }
    
    public final void resetAll()
    {
        setAnimationDelayMs(DEFAULT_ANIMATION_DELAY_MS);
        setExplorationAlgorithm(DEFAULT_EXPLORATION_ALGORITHM);
        setGraphType(DEFAULT_GRAPH_TYPE);
        setGraphIsWeighted(DEFAULT_GRAPH_IS_WEIGTHED);
        setGraphLayout(DEFAULT_GRAPH_LAYOUT);
        setGraphEdgeProbability(DEFAULT_GRAPH_EDGE_PROBABILITY);
        setGraphNumberOfVertices(DEFAULT_GRAPH_NUMBER_OF_VERTICES);
        setGraphParalellEdgesLimit(DEFAULT_GRAPH_PARALELL_EDGES_LIMIT);
    }
}
