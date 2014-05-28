package graphdemo;

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
