package edu.uoc.dpoo.tracker;

import java.util.Date;

public class Contract {

    /**
     * This attribute is the contract number
     */
    private int contractId;

    /**
     * This attribute is the contract start date
     */
    private Date start;

    /**
     * This attribute is the contract end date
     */
    private Date end;

    /**
     * This attribute allow if your pet is visible for others
     */
    private boolean allowFriends;

    /**
     * This attribute is the pet associated to contract
     */
    private Pet pet;


    /**
     * Constructor method
     * @param contractId
     * @param start
     * @param end
     * @param allowFriends
     */
    public Contract(int contractId, Date start, Date end, boolean allowFriends, Pet devices)
    {
        this.contractId = contractId;
        this.start = start;
        this.end = end;
        this.allowFriends = allowFriends;
        this.pet = devices;
    }

    /**
     * This method return if the pet is visible in the app
     * @return visibility
     */
    public boolean isActive()
    {
        return allowFriends;
    }

    /**
     * This Method get contract number
     * @return contractId
     */
    public int getContractId() {
        return contractId;
    }

    /**
     * This method set the contractId
     * @param contractId
     */
    public void setContractId(int contractId) { this.contractId = contractId; }

    /**
     * This method get date end contract
     * @return
     */
    public Date getEnd() { return end; }

    /**
     * This method set end contract
     * @param end
     */
    public void setEnd(Date end) { this.end = end; }

    /**
     * This method get start date contract
     * @return date
     */
    public Date getStart() { return start; }

    /**
     * this method set star Contract
     * @param start
     */
    public void setStart(Date start) { this.start = start; }


    /**
     * This method get a Pet
     * @return object
     */
    public Pet getPet()
    {
        return this.pet;
    }

    public boolean getAllowFriends() {
        return allowFriends;
    }

    /**
     * This method set device
     * @param pet
     */
    public void setDevice(Pet pet)
    {
        this.pet = pet;
    }
}
