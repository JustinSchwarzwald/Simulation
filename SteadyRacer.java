/**
 * Class per instructions extended from racer class
 * @author Justin Schwarzwald
 *
 */
public class SteadyRacer extends Racer
{
    public SteadyRacer()
    {
        this.speed = Math.random() * (4.0 - 3.0) + 3.0; // Random number between 4 and 3
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
        currentProgress += speed;
        
    }

    public String toString()
    {
        return "Racer #" + carNumber + " Steady Car - " + (int) currentProgress + " units";
    }

}
