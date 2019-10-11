/**
 * 
 * Crumbled Segment - 'C' - extends RoadSegment
 * @author Justin Schwarzwald
 *
 */
public class CrumbledSegment extends RoadSegment
{

    public CrumbledSegment()
    {
        this.modifier =  Math.random() * (.8 - .6) + .6; // Set randomly for each object between .8 and .6
        this.roadChar = 'C';
    }
    
    /**
     * 40% - CrumbledSegment | 25% - AslphaltSegment | 25% - GravelSegment | 10% - DirtSegment
     */
    @Override
    public RoadSegment generateNeighbor()
    {
        // Generates random number and returns based on percentages above
        double diceRoll = Math.random();
        
        if (diceRoll < .40)
            return new AsphaltSegment();
        else if (diceRoll < .65)
            return new CrumbledSegment();
        else if (diceRoll < .90)
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
        return "Crumbled - " + getLength() + " units";
    }
    
    @Override
    public char getRoadChar()
    {
        return roadChar;
    }
}
