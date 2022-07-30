/*
 * Ekaterina Kuznetsova
 * CPSC 5002, Seattle University
 * This is free and unencumbered software released into the public domain.
 */
package Kuznetsova_Lab2;
import java.util.Random; //needed for random object

/**
 * The Loaded Die class create is a simulation of a loaded die; the creator
 * of the class instance(object) chooses the loaded number and by how much
 * it is prioritized; the creator of the object can access and modify these
 * values as well.
 *
 * @author Ekaterina Kuznetsova
 * @version 1.0
 */
public class LoadedDie {
    //declare fields:
    //set sides (constant)
    private final int SIDES;
    //declare value - number after roll
    private int value;
    //declare loaded number variable
    private int loadedNum;
    //declare variable for prioritizing
    private int loadPerHundred;

    /**
     * The constructor performs an initial roll of the die.
     * @param loadedNumber        which number should come up more often
     * @param moreTimesPerHundred how many times per 100 rolls to come up with
     *                            the loaded number(instead of uniform random)
     */
    public LoadedDie(int loadedNumber, int moreTimesPerHundred) {
        //number to prioritize
        loadedNum = loadedNumber;
        //how much to prioritize by
        loadPerHundred = moreTimesPerHundred;
        //number of sides
        SIDES = 6;
        //call roll method
        roll();
    }

    /**
     * The roll method simulates the rolling of the die.
     * It will typically set this die's value to a random value
     * with uniform distribution between 1 and 6. Occasionally,
     * it will a priori return the favored value (with frequency
     * determined by the moreTimesPerHundred argument that was passed
     * to the constructor).
     */
    public void roll() {
        //create Random object
        Random rand = new Random();

        //get random number from 0 to 99 - the 'draw'
        int draw = rand.nextInt(100);

        //if the draw is less than the loadPerHundred (moreTimesPerHundred)
        //then it will return the loaded value
        if (draw < loadPerHundred) {
            value = loadedNum;
        } else
            //otherwise it returns a random value from 1 to # of sides
            value = rand.nextInt(SIDES) + 1;
    }

    /**
     * getter/accessor for value variable
     *
     * @return int  value getter/accessor
     */
    public int getValue()
    {
        return value;
    }

    /**
     * getter/accessor for value variable
     *
     * @return int  value getter/accessor
     */
    public int getLoadedNum()
    {
        return loadedNum;
    }

    /**
     * setter/modifier in case object creator wants to
     * change the loaded value
     *
     * @param num  integer for loaded number value
     */
    public void setLoadedNum(int num) {
        loadedNum = num;
    }

    /**
     * setter/modifier in case object creator wants to change the
     * prioritizing amount
     *
     * @param priority  integer value to prioritize by
     */
    public void setLoadPerHundred(int priority) {
        loadPerHundred = priority;
    }

}