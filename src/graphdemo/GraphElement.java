package graphdemo;

import java.util.UUID;

public class GraphElement
{
    protected final String name;
    protected final UUID uuid;
    
    public GraphElement(String name)
    {
        this.name = name;
        this.uuid = UUID.randomUUID();
    }
    
    public GraphElement(GraphElement copyFrom)
    {
        this.name = copyFrom.name;
        this.uuid = copyFrom.uuid;
    }
}
