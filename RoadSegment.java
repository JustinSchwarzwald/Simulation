/**
 * Abstract base class for Road Segments
 * Length generated for segment is between 10 and 50
 * 
 * @author Justin Schwarzwald
 */
public abstract class RoadSegment
{
    protected int length = (int) (Math.random() * (50-10) + 10); // Segment length from 10 to 50
    protected double modifier;
    protected char roadChar;
    
    // Abstract methods for each road segment
    public abstract RoadSegment generateNeighbor();
    public abstract int getLength();
    public abstract double getModifier(); 
    public abstract char getRoadChar(); // Added Method to return Char of the road segment
}
