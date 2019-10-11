/**
 * Part of Extra Credit, created racer is extended from Racer class
 * Speed is between 18 and 13, progress is 2.30 * speed *  modifier.
 * Which causes it to go extremely quick on everything but Dirt, Dirt it goes extremely slow.
 * @author Justin Schwarzwald
 *
 */
public class DavidRacer extends Racer
{
    public DavidRacer()
    {
        this.speed = Math.random() * (18.0 - 13.0) + 13.0; // Between 18 and 13
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
        currentProgress += 2.30 * speed *  modifier;
        
    }

    public String toString()
    {
        return "Racer #" + carNumber + " David's Car - " + (int) currentProgress + " units";
    }

}
