package edu.uoc.dpoo.tracker;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PetTracker {


    //new line separator
    private final String NL = System.getProperty("line.separator");

    /**
     * This attribute save the pets in the pet tracker
     */
    private List<Pet> devices;

    /**
     * This attribute save the pets in the pet tracker
     */
    private List<Contract> contracts;

    /**
     * This attribute save messages associated to contract
     */
    private List<Message> messages;

    /**
     * Constructor method
     */
    public PetTracker()
    {
        this.devices = new ArrayList<Pet>();
        this.contracts = new ArrayList<Contract>();
        this.messages = new ArrayList<Message>();
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
        Date now = new Date();
        if(!existContract(contractId)){
            Contract contract = new Contract(contractId, start, end, allowFriends, null);
            this.contracts.add(contract);
            Pet pet = new Pet(petName, -1, contract, this);
            this.devices.add(pet);
            contract.setDevice(pet);
            /*
            Message message = new Message(contractId, now, null, null);
            this.messages.add(message);
             */
        }
    }

    /**
     * Method to delete contract
     * @param contractId to delete contract
     * @return void
     */
    public void delContract(int contractId)
    {
        for (int i = 0; i < contracts.size(); i++ ) {
            if (contracts.get(i).getContractId() == contractId){
                //remove the devices
                for (int j = 0; j < devices.size(); j++){
                    if(devices.get(j).getContract() == contracts.get(i)){
                        devices.remove(j);
                    }
                }
                for (int k = 0; k < messages.size(); k++) {
                    if (messages.get(k).getContractId() == contractId){
                        messages.remove(k);
                    }
                }
                contracts.remove(i);
            }
        }
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
     */
    public void sendMessage(int contractId, MessageType type)
    {
        if (getContract(contractId).getContractId() == contractId) {
            Date now = new Date();
            Message message = new Message(contractId, now, null, type);
            this.messages.add(message);
        }

    }

    /**
     * Method to link device
     * @param contractId contract number
     * @param serial number gps
     */
    public void linkDevice(int contractId, int serial)
    {
        getContract(contractId).getPet().setSerial(serial);
    }

    /**
     * Create square safe Zone
     * @param type Safe zone
     * @param description zone
     * @param centerLat zone
     * @param centerLon zone
     * @param size zone
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
    public List<Pet> getDevices()
    {
        return this.devices;
    }

    /**
     * This method get contract from list
     * @param contractId
     * @return contract object
     */
    public Contract getContract(int contractId)
    {
        Contract c = null;
        for (int i = 0; i < contracts.size(); i++) {
            if (contracts.get(i).getContractId() == contractId){
                c = contracts.get(i);
            }
        }

        return c;
    }

    /**
     * This method return list of messages
     * @return List
     */
    public List<Message> getMessages() {
        return messages;
    }
}
