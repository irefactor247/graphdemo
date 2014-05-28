package graphdemo;

public class Edge extends GraphElement
{
    private final double weight;
    private static final double DEFAULT_WEIGHT = 1.0;
    
    public Edge(String name, double weight)
    {
        super(name);
        this.weight = weight;
    }
    
    public Edge(String name)
    {
        super(name);
        this.weight = DEFAULT_WEIGHT;
    }
    
    public Edge(Edge copyFrom)
    {
        super(copyFrom);
        this.weight = copyFrom.weight;
    }
    
    @Override
    public String toString()
    {
        return this.name + " " + this.weight;
    }
}
