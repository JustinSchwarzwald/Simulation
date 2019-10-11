/**
 * Class per instructions extended from racer class
 * @author Justin Schwarzwald
 *
 */
public class ToughRacer extends Racer
{
    
    public ToughRacer()
    {
        this.speed = Math.random() * (3.0 - 2.0) + 2.0; // Random speed between 3 and 2
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
        double bonusSpeed;
        bonusSpeed = 5 * (1.0 - modifier);
        currentProgress += speed + bonusSpeed;
        
    }
    
    public String toString()
    {
        return "Racer #" + carNumber + " Tough Car  - " + (int) currentProgress + " units";
    }

}
