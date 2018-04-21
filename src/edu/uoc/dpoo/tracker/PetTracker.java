package edu.uoc.dpoo.tracker;

import java.util.ArrayList;
import java.util.Date;

public class PetTracker {


    //new line separator
    private final String NL = System.getProperty("line.separator");

    /**
     * This attribute save the pets in the pet tracker
     */
    private ArrayList<Pet> devices;

    /**
     * This attribute save the pets in the pet tracker
     */
    private ArrayList<Contract> contracts;

    private Pet device;

    /**
     * Constructor method
     */
    public PetTracker()
    {
        this.devices = new ArrayList<Pet>();
        this.contracts = new ArrayList<Contract>();
    }

    /**
     * this method check if exist contract
     * @param contractId
     * @return
     */
    private boolean existContract(int contractId)
    {
        for (Contract contract : contracts) {
            if (contract.getContractId() == contractId) {
                return true;
            }
        }

        return false;
    }

    /**
     * Method to create a new position
     * @param serial number serial gps
     * @param lat latitude position of pet
     * @param lon longitude position of pet
     * @param timeStamp position registered
     * @return void
     */
    public void newPosition(int serial, float lat, float lon, Date timeStamp)
    {
        //TODO
    }

    /**
     * Method to add contract
     * @param contractId contract number
     * @param start Date of contract
     * @param end Date of contract
     * @param petName of pet
     * @param allowFriends activate show pet tracker for people
     * @return void
     */
    public void addContract(int contractId, Date start, Date end, String petName, Boolean allowFriends)
    {
        //TODO
        if(!existContract(contractId)){
            Contract myContract = new Contract(contractId, start, end, allowFriends, null);
            this.contracts.add(myContract);
            Pet pet = new Pet(petName, -1, myContract, null);
            this.devices.add(pet);
            this.getContract(contractId).setDevice(pet);
        }
    }

    /**
     * Method to delete contract
     * @param contractId to delete contract
     * @return void
     */
    public void delContract(int contractId)
    {
        //TODO
    }

    /**
     * Method to find fiends of app
     * @param contractId
     * @param maxDistance
     * @return edu.uoc.dpoo.tracker.Pet
     */
    public void findFriends(int contractId, float maxDistance)
    {
        //TODO
    }

    /**
     * Send message method
     * @param contractId contract number
     * @param type message type
     * @return
     */
    public void sendMessage(int contractId, MessageType type)
    {
        //TODO
    }

    /**
     * Method to link device
     * @param contractId contract number
     * @param serial number gps
     * @return
     */
    public void linkDevice(int contractId, int serial)
    {
        //TODO
    }

    /**
     * Create square safe Zone
     * @param type Safe zone
     * @param description zone
     * @param centerLat zone
     * @param centerLon zone
     * @param size zone
     * @return
     */
    public void newSquareSafeZone(SafeZone type, String description, float centerLat, float centerLon, float size)
    {
        //TODO
    }

    /**
     * Create circular safe Zone
     * @param type Safe zone
     * @param description zone
     * @param centerLat zone
     * @param centerLon zone
     * @param size zone
     * @return void
     */
    public void newCircularSafeZone(SafeZone type, String description, float centerLat, float centerLon, float size)
    {
        //TODO
    }

    /**
     * Return edu.uoc.dpoo.tracker.Pet device
     * @param contractId contract number
     * @return edu.uoc.dpoo.tracker.Pet
     */
    public Pet getClientDevice(int contractId)
    {
        Pet petDevice = null;
        for (Pet device: devices) {
            if (device.getContract().getContractId() == contractId){
                petDevice = device;
            }
        }

        return petDevice;
    }

    /**
     * Get edu.uoc.dpoo.tracker.Pet devices
     * @return edu.uoc.dpoo.tracker.Pet
     */
    public void getActiveDevices()
    {
        //TODO
    }

    /**
     * This method return devices
     * @return ArrayList
     */
    public ArrayList<Pet> getDevices()
    {
        return this.devices;
    }

    public Contract getContract(int contractId)
    {
        Contract c = null;
        for (Contract contract: contracts) {
            if (contract.getContractId() == contractId){
                c = contract;
            }
        }

        return c;
    }
}
