/**
 * Class per instructions extended from racer class
 * @author Justin Schwarzwald
 *
 */
public class StreetRacer extends Racer
{
    
    
    public StreetRacer()
    {
        this.speed = Math.random() * (7.0 - 5.5) + 5.5; // Random speed between 7 and 5.5
        this.currentProgress = 0;
        this.carNumber = racerID++;
    }

    @Override
    public int getCarNumber()
    {
        return carNumber;
    }

    @Override
    public double getSpeed()
    {
        return speed;
    }

    @Override
    public double getCurrentProgress()
    {
        return currentProgress;
    }

    @Override
    public void resetProgress()
    {
        currentProgress = 0;
        
    }

    @Override
    public void makeProgress(double modifier)
    {
        currentProgress += (speed*modifier) + 0.5;
    }

    public String toString()
    {
        return "Racer #" + carNumber + " Street Car - " + (int) currentProgress + " units";
    }
  
}
