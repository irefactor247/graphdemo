package graphdemo;

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
