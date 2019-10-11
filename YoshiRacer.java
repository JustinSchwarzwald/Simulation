/**
 * Part of Extra Credit, created racer is extended from Racer class
 * Speed is determined by multiplying base speed (between 9 and 5) by the modifier divided by 2 plus 3
 * @author Justin Schwarzwald
 */
public class YoshiRacer extends Racer
{

    public YoshiRacer()
    {
        this.speed = Math.random() * (9.0 - 5.0) + 5.0; // Random number between 9 and 5
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
        currentProgress += speed *  modifier/2 + 3;
        
    }

    public String toString()
    {
        return "Racer #" + carNumber + " Yoshi Car - " + (int) currentProgress + " units";
    }

}
