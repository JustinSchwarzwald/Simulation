/**
 * Part of Extra Credit, created racer is extended from Racer class
 * Speed is set to 0, progress is made by randomly generating a number 0 to 28 (teleportation?... maybe).
 * @author Justin Schwarzwald
 *
 */
public class RandoRacer extends Racer
{
    public RandoRacer()
    {
    this.speed = 0;
    this.currentProgress = 0; // Randomly makes progress from 0 to 28 per makeProgress method
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
        currentProgress += Math.random() * 28.0;
    }

    public String toString()
    {
        return "Racer #" + carNumber + " Rando Car - " + (int) currentProgress + " units";
    }
}
