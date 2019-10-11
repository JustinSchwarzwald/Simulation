/**
 * Abstract base class for Racers
 * racerID keeps track of each racer by assigning a car number to each new racer and increasing the racerID 
 * 
 * @author Justin Schwarzwald
 */
public abstract class Racer
{
    protected int carNumber; // Will take the racerID to set car number
    protected static int racerID = 1; // First racer will be #1
    protected double speed;
    protected double currentProgress;
    
    // Abstract methods for each Racer
    public abstract int getCarNumber();
    public abstract double getSpeed();
    public abstract double getCurrentProgress();
    public abstract void resetProgress();
    public abstract void makeProgress(double modifier);
    
}
