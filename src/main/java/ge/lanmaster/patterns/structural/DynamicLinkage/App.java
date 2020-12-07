package ge.lanmaster.patterns.structural.DynamicLinkage;

public class App
{
    public static void main( String[] args )
    {
        System.out.println( "DynamicLinkage Pattern" );
        FoodProcessorEnvironment fpe = new FoodProcessorEnvironment();
        fpe.run("ConcreteFoodProcessorProgram");
    }
}
