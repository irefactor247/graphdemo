package graphdemo;

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
