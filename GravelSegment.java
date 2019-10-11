/**
 * Crumbled Segment - 'G' - extends RoadSegment
 * @author Justin Schwarzwald
 *
 */
public class GravelSegment extends RoadSegment
{    
    public GravelSegment()
    {
        this.modifier =  Math.random() * (.6 - .3) + .3; // Set randomly for each object between .3 and .6;
        this.roadChar = 'G';
    }
    
    /**
     * 50% - GravelSegment | 35% - DirtSegment | 10% - CrumbledSegment | 5% - AsphaltSegment
     */

    @Override
    public RoadSegment generateNeighbor()
    {
        double diceRoll = Math.random();
        
        if (diceRoll < .50)
            return new GravelSegment();
        else if (diceRoll < .85)
            return new DirtSegment();
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
        return "Gravel - " + getLength() + " units";
    }
    
    
    @Override
    public char getRoadChar()
    {
        return roadChar;
    }
    
}