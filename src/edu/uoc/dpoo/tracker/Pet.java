package edu.uoc.dpoo.tracker;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pet {

    /**
     * This attribute is the name of pet
     */
    private String name;

    /**
     * This number is the serial number of GPS
     */
    private int serial;

    /**
     * This attribute is a contract object
     */
    private Contract contract;

    /**
     * This attribute is PetTracker object
     */
    private PetTracker tracker;

    /**
     * This attribute is historic list of coordinates
     */
    private ArrayList<Coordinate> historic;


    /**
     * constructor method
     * @param name of pet
     * @param serial GPS
     */
    public Pet(String name, int serial, Contract myContract, PetTracker tracker)
    {
        this.name = name;
        this.serial = serial;
        this.contract = myContract;
        this.tracker = tracker;
        this.historic = new ArrayList<Coordinate>();
    }

    /**
     * Method to config the new position of pet
     * @param c coordinate
     */
    public void newPosition(Coordinate c)
    {
        //TODO
    }

    /**
     * This method return true if is safety zone
     * @return boolean
     */
    public boolean inSafeZone()
    {
        //TODO
        return false;
    }

    /**
     * this method return the pet track in interval time
     * @param start date of pet
     * @param end date of pet
     */
    public void getTrack(Date start, Date end)
    {
        //TODO
    }

    /**
     * This method get de distance in interval date
     * @param start distance
     * @param end distance
     * @return float
     */
    public float getDistance(Date start, Date end)
    {
        //TODO
        return 0;
    }

    /**
     * get elapsed time
     * @return int
     */
    public int elapsedTime()
    {
        //TODO
        return 0;
    }

    /**
     * This method return unread messages
     * @return Message
     */
    public Message getUnreadMessages()
    {
        //TODO
        return null;
    }

    /**
     * This method return device number
     * @return serialDevice
     */
    public int getSerial() {
        return serial;
    }

    /**
     * This method set serial number
     * @param serial
     */
    public void setSerial(int serial) {
        this.serial = serial;
    }

    /**
     * This method return pet name
     * @return string
     */
    public String getName() {
        return name;
    }

    /**
     * This method sets pet name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method return a contract
     * @return Contract object
     */
    public Contract getContract()
    {
        return contract;
    }

    /**
     * this method sets contact objetc
     * @param contract
     */
    public void setContract(Contract contract)
    {
        this.contract = contract;
    }

    /**
     * This method return historic List
     * @return ArrayList
     */
    public ArrayList<Coordinate> getHistoric()
    {
        return historic;
    }

    public PetTracker getTracker()
    {
        return tracker;
    }
}
