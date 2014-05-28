package graphdemo;

public class Vertex extends GraphElement
{
    public Vertex(String name)
    {
        super(name);
    }
    
    public Vertex(Vertex copyFrom)
    {
        super(copyFrom);
    }
    
    @Override
    public String toString()
    {
        return this.name;
    }
}
