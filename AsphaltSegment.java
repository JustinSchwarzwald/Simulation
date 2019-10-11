/**
 * Asphalt Segment - 'A' - extends RoadSegment
 * @author Justin Schwarzwald
 *
 */
public class AsphaltSegment extends RoadSegment
{
    
    public AsphaltSegment()
    {
        this.modifier = 1.0;
        this.roadChar = 'A';
    }
    
    /**
     * 60% - AsphaltSegment | 25% - CrumbledSegment | 10% - GravelSegment | 5% - DirtSegment
     */
    @Override
    public RoadSegment generateNeighbor()
    {
        // Generates random number and returns based on percentages above
        double diceRoll = Math.random();

        if (diceRoll < .6)
            return new AsphaltSegment();
        else if (diceRoll < .85)
            return new CrumbledSegment();
        else if (diceRoll < .95)
            return new GravelSegment();
        else
            return new DirtSegment();

    }

    @Override
    public int getLength()
    {
        return length;
    }

    @Override
    public double getModifier()
    {
        return modifier;
    }
    
    public String toString()
    {
        return "Asphalt - " + getLength() + " units";
    }

    @Override
    public char getRoadChar()
    {
        return roadChar;
    }
    

}
