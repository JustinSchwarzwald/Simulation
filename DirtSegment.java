/**
 * Dirt Segment - 'D' - extends RoadSegment
 * @author Justin Schwarzwald
 *
 */
public class DirtSegment extends RoadSegment
{

    public DirtSegment()
    {
        this.modifier =  Math.random() * .3; // Set randomly for each object between 0 and .3
        this.roadChar = 'D';
    }
    
    /**
     * 60% - DirtSegment | 30% - GravelSegment | 5% - CrumbledSegment | 5% - AsphaltSegment
     */
    @Override
    public RoadSegment generateNeighbor()
    {
        // Generates random number and returns based on percentages above
        double diceRoll = Math.random();
        
        if (diceRoll < .60)
            return new DirtSegment();
        else if (diceRoll < .90)
            return new GravelSegment();
        else if (diceRoll < .95)
            return new CrumbledSegment();
        else
            return new AsphaltSegment();
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
        return "Dirt - " + getLength() + " units";
    }
    
    @Override
    public char getRoadChar()
    {
        return roadChar;
    }
}
