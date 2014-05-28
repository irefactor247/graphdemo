package graphdemo;

import java.util.UUID;

public class GraphElement
{
    protected final String name;
    protected final UUID uuid;
    
    public GraphElement(String name)
    {
        this.name = name;
        uuid = UUID.randomUUID();
    }
    
    public GraphElement(GraphElement copyFrom)
    {
        name = copyFrom.name;
        uuid = copyFrom.uuid;
    }
    
    @Override
    public String toString()
    {
        return name;
    }
}
