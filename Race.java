import java.util.Scanner;
/**
 * 
 * Loops race program until exit (choice -1). User can select size of race track (choice 1).
 * User can select to have race track of random size (choice 2).
 * Program creates 8 racers randomly and a track based on probability, then simulates a race
 * and prints out the winner.
 * 
 * @author Justin Schwarzwald
 *
 */
public class Race
{
    public Race()
    {
        // Initializing variables for race class
        int userChoice = 0; // 1 for setting track array size manually, 2 for random size, -1 to quit
        int raceSize = 0; // How big track will be for option one
        int winnerIndex = -1; // Index if a winner was found, -1 if no winner yet
        boolean continueProgram = true; // Loop race until -1 is entered

        // Declaring arrays to be used
        Racer[] racersArray; // Array that holds the 8 racers
        int[] segmentTracker; // Parallel array that holds what segment of track racer is on
        RoadSegment[] userSelectedRaceTrack; // Array that holds each road segment, user choice 1
        RoadSegment[] randomRaceTrack; // Array that holds each road segment, user choice 2
        
        Scanner userInput = new Scanner(System.in);

        System.out.println("Welcome to the Racer Dirby!");
        
        // Start Race Loop until user selects -1
        while (continueProgram)
        {
            System.out.println("Would you like to:");
            showOptions(); // Prints menu

            // Loops until user selects a 1, 2, or -1
            do
            {
                try
                {
                    userChoice = userInput.nextInt();
                    if (userChoice != 1 && userChoice != 2 && userChoice != -1)
                    {
                        System.out.println("Please enter a number from the following choices");
                        showOptions();
                    }
                }
                // Runs if user doesn't enter a number
                catch (Exception e)
                {
                    System.out.println("Please enter a number from the following choices");
                    showOptions();
                }

                userInput.nextLine();

            } while (userChoice != 1 && userChoice != 2 && userChoice != -1);

            // Runs if user selects 1 for manual length of track
            if (userChoice == 1)
            {
                System.out.println("Please enter a length for the race.");

                // Loops until user selects a number greater than 0
                do
                {
                    try
                    {
                        raceSize = userInput.nextInt();
                        if (raceSize < 1)
                        {
                            System.out.println("Please enter a number greater than 0, for the length of the race");
                        }
                    }
                    // Runs if user doesn't enter a number
                    catch (Exception e)
                    {
                        System.out.println("Please enter a number greater than 0, for the length of the race");
                    }

                    userInput.nextLine();
                } while (!(raceSize > 0));

                // Creates race track with size user entered
                userSelectedRaceTrack = new RoadSegment[raceSize];
                // Generates all road segments(elements) for the race track
                generateTrackElements(userSelectedRaceTrack);
                // Prints out track with length of each segment
                OutputTrack(userSelectedRaceTrack);

                System.out.println("\n");

                // Creates racer array
                racersArray = new Racer[8];
                // Generates all racers randomly into the racersArray
                generateRacerElements(racersArray);

                // Creates parallel array for tracking racer progress on track
                segmentTracker = new int[racersArray.length];

                // Calls method to simulate the race, and returns the winning car number
                winnerIndex = runRace(racersArray, userSelectedRaceTrack, segmentTracker);

                // Prints winner
                System.out.println("Winner of the race: Racer #" + winnerIndex);

                System.out.println("\n\nNEXT RACE\n");
            }

            // Runs if user selects choice 2, random length of track
            if (userChoice == 2)
            {
                // Creates race track with random size between 10 to 50
                randomRaceTrack = new RoadSegment[(int) (Math.random() * ((50 - 10) + 1)) + 10];
                // Generates all road segments(elements) for the race track
                generateTrackElements(randomRaceTrack);
                // Prints out track with length of each segment
                OutputTrack(randomRaceTrack);

                System.out.println("\n");

                // Creates racer array
                racersArray = new Racer[8];
                // Generates all racers randomly into the racersArray
                generateRacerElements(racersArray);

                // Generates all road segments(elements) for the race track
                segmentTracker = new int[racersArray.length];

                // Calls method to simulate the race, and returns the winning car number
                winnerIndex = runRace(racersArray, randomRaceTrack, segmentTracker);

                // Prints winner
                System.out.print("Winner of the race: Racer #" + winnerIndex);

                System.out.println("\n\nNEXT RACE\n");
            }

            // Runs if user chooses -1
            if (userChoice == -1)
            {
                System.out.println("Program has ended");
                // Sets program to end
                continueProgram = false;
            }

            // Resets all variables and arrays for loop case
            userChoice = 0;
            raceSize = 0;
            winnerIndex = -1;

            segmentTracker = null;
            racersArray = null;
            userSelectedRaceTrack = null;
            randomRaceTrack = null;
            Racer.racerID = 1;

        } // End of race loop
        
        userInput.close(); // Closes scanner
    } // End of race

    
    
/////////////////////////////////Private Methods\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    /**
     * Prints out user menu options for race
     */
    private void showOptions()
    {
        System.out.println("1  - Determine the length of the race");
        System.out.println("2  - Run a random race");
        System.out.println("-1 - Exit");
    }
    
    /**
     * Creates string of racers and their progress
     * @param trackArray - which is an array of RoadSegments
     * @return String of racers and their progress
     */
    private String OutputTrack(RoadSegment[] trackArray)
    {
        String outputReturn = "Track:\n"; // First adds Track: new line to the return string
        
        // Adds first segment char, and first segments length to string
        outputReturn += (trackArray[0].getRoadChar() + ":" + trackArray[0].getLength());
        
        // Starting from second element to last adds segment type and length
        for (int i = 1; i < trackArray.length; i++)
            outputReturn += (" - " + trackArray[i].getRoadChar() + ":" + trackArray[i].getLength());
        
        // Adds new line
        outputReturn += ("\n");
        
        // Returns all elements and there lengths that were added into variable outputReturn above
        return outputReturn;
    }
    
    /**
     * Generates all elements for RoadSegment Array by assigning the first element randomly,
     * Then assigning each element after based on probability of the segment before it using generateNeighbor.
     * @param trackArray - which is an array of RoadSegments
     */
    private void generateTrackElements(RoadSegment[] trackArray)
    {
        double randomNum = Math.random();
        
        // Assigning element one of RoadSegment array randomly
        if (randomNum < .25)
            trackArray[0] = new AsphaltSegment();
        else if (randomNum < .50)
            trackArray[0] = new CrumbledSegment();
        else if (randomNum < .75)
            trackArray[0] = new DirtSegment();            
        else 
            trackArray[0] = new GravelSegment(); 
        
        // After first element loops through all other elements and assigns based on segment before its generateNeighbor method
        for (int i = 1; i < trackArray.length; i++)
        {
            trackArray[i] = trackArray[i - 1].generateNeighbor();

        }
    }

    /**
     * Generates all elements for a Racer array, assigns all elements randomly
     * @param racerArray - which is an array of racers
     */
    private void generateRacerElements(Racer[] racerArray)
    {
        double randomNum;
        
        // Runs through entire array assigning each element a new racer randomly
        for (int i = 0; i < racerArray.length; i++)
        {
            randomNum = Math.random();
            
            if (randomNum < 1.0 / 6.0)
                racerArray[i] = new SteadyRacer();
            else if (randomNum < 1.0 / 6.0 * 2.0)
                racerArray[i] = new StreetRacer();
            else if (randomNum < 1.0 / 6.0 * 3.0)
                racerArray[i] = new DavidRacer();
            else if (randomNum < (1.0 / 6.0 * 4.0))
                racerArray[i] = new RandoRacer();
            else if (randomNum < (1.0 / 6.0 * 5.0))
                racerArray[i] = new YoshiRacer();
            else
                racerArray[i] = new ToughRacer();
        }
    }

    /**
     * Prints on each line: The racer, car number, how far they are on there current segment
     * and what segment the racer is on + how long the current segment is. 
     * @param racerArray - which is an array of racers
     * @param trackArray - which is an array of roadsegments
     * @param segmentTrackerArray - which is a parallel array of the racers to track racers placement on track
     */
    public void updateOnTrack(Racer[] racerArray, RoadSegment[] trackArray, int[] segmentTrackerArray)
    {
        String updateOnTrack = "";
        
        // Runs through each element of racer array, grabs the toString of each element, 
        // the segmentTracker element and adds one as array starts at 0, and the toString of trackArray element
        for (int i = 0; i < racerArray.length; i++)
        {
            updateOnTrack += racerArray[i] + " into Segment #" + (1 + segmentTrackerArray[i])  + " " + trackArray[segmentTrackerArray[i]] + " long\n";
        }
        System.out.println(updateOnTrack);
    }
    
    /**
     * Prints out the divider with loop count
     * @param loopCount - number of time racers have updated
     */
    private void outPutDivider(int loopCount)
    {
        System.out.println("###############################################################################");
        System.out.println("\nUpdate #" + loopCount);
        System.out.println("-------------------------------------------------------------------------------");
    }
    
    /**
     * Simulates race by checking if a racer has won the race, if not calls each racer to make progress
     * Once a racer his found to one it returns the car number who wins
     * @param racerArray - which is an array of racers
     * @param trackArray - which is an array of roadsegments
     * @param segmentTrackerArray - which is a parallel array of the racers to track racers placement on track
     * @return - int car number of the winner
     */
    private int runRace(Racer[] racerArray, RoadSegment[] trackArray, int[] segmentTrackerArray)
    {
        boolean noWinner = true; // Sets loop condition
        int loopCounter = 0; // increases each loop until winner is found
        
        // Creates string of all track elements with there lengths, and saves it to variable so method is not needed to be called multiple times 
        String trackInfo = "" + OutputTrack(trackArray); 
        
        while (noWinner)
        {
            loopCounter++; 
            
            // Runs check for winner method if winner is found returns the car number, if not returns -1
            int checkForWinner = randomWinnerCheck(racerArray, trackArray, segmentTrackerArray);
            
            // Returns winner if found by method
            if (checkForWinner > -1)
                return  checkForWinner; 
            
            // If no winner was found calls make progress to each racer
            for (int i = 0; i < racerArray.length; i++)
            {
                racerArray[i].makeProgress(trackArray[segmentTrackerArray[i]].getModifier());
            }
            
            // Sorts Racers from first place to last by calling method
            sortRacers(racerArray, segmentTrackerArray);
            
            // Outputs the divider with loop number
            outPutDivider(loopCounter);          
            
            // Prints track info and, all racers 
            System.out.println(trackInfo);
            updateOnTrack(racerArray, trackArray, segmentTrackerArray);
            
            
        }        
        
        return -1;
    }
    
    /**
     * Extra Credit
     * Sorts racer array in order of who is in lead comes first in array.
     * Sorts by segment and if tied checks the progress of car.
     * Changes both racerArray and segmentTracker together, to maintain parallelism
     * @param racerArray - which is an array of racers
     * @param segmentTrackerArray - which is a parallel array of the racers to track racers placement on track
     */
    private void sortRacers(Racer[] racerArray, int[] segmentTrackerArray)
    {
        // Temp variables to rearrange array
        Racer tempRacer = null;
        int tempSegment = 0;

        // Uses bubble sort to sort array by segment
        for (int i = 0; i < racerArray.length - 1; i++)
        {
            for (int j = 0; j < racerArray.length - i - 1; j++)
            {
                // Swaps if elements of array if they are in wrong order
                if (segmentTrackerArray[j] < segmentTrackerArray[j + 1])
                {
                    // Swaps array elements in racer Array and segement tracker to maintain parallelism
                    tempSegment = segmentTrackerArray[j + 1];
                    tempRacer = racerArray[j + 1];

                    segmentTrackerArray[j + 1] = segmentTrackerArray[j];
                    racerArray[j + 1] = racerArray[j];

                    segmentTrackerArray[j] = tempSegment;
                    racerArray[j] = tempRacer;

                }
                // If both segment elements are equal then check by progress
                else if (segmentTrackerArray[j] == segmentTrackerArray[j + 1])
                {
                    if (racerArray[j].currentProgress < racerArray[j + 1].currentProgress)
                    {
                        // Swaps array elements in racer Array and segement tracker to maintain parallelism
                        tempSegment = segmentTrackerArray[j + 1];
                        tempRacer = racerArray[j + 1];

                        segmentTrackerArray[j + 1] = segmentTrackerArray[j];
                        racerArray[j + 1] = racerArray[j];

                        segmentTrackerArray[j] = tempSegment;
                        racerArray[j] = tempRacer;
                    }
                }
            }
        }
    }
       
    /**
     * Check to see if a racer has won the race     //Extra Credit
     * Checks in random order if multiple racers have both crossed the finish line
     * Returns winner of race, or -1 if no racers have won yet
     * @param racerArray - which is an array of racers
     * @param trackArray - which is an array of roadsegments
     * @param segmentTrackerArray - which is a parallel array of the racers to track racers placement on track
     * @return int - returns the car number of winner, or -1 if no winner has happened
     */
    private int randomWinnerCheck(Racer[] racerArray, RoadSegment[] trackArray, int[] segmentTrackerArray)
    {
        // Initializing variables
        int numberOfWinners = 0;
        int randomGen;
        
        // Loops through all racers
        for (int i = 0; i < racerArray.length; i++)
        {
            // Check if racer's progress is over the segments length
            if (racerArray[i].getCurrentProgress() >= trackArray[segmentTrackerArray[i]].length)
            {
                // If over then the racers progress is reset to 0 and the segment tracker is increased by one
                racerArray[i].resetProgress();
                segmentTrackerArray[i]++;
            }
            // Checks to see if there are any winners and adds to how many there are
            if (segmentTrackerArray[i] >= trackArray.length)
            {
                numberOfWinners++;
            }
        }
        
        // If any winners are found
        if (numberOfWinners > 0)
        {
            // Generates a random number between 0 and (the number of winners - 1) to get the index number of the winner.
            randomGen = (int) (Math.random() * numberOfWinners);
            
            // Sorts the racers and returns the car number of the randomly generated car winner
            sortRacers(racerArray, segmentTrackerArray);
            return racerArray[randomGen].carNumber;
        }

        return -1; // Returns -1 if no winner is found
    }
}



