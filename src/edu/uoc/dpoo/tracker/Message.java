package edu.uoc.dpoo.tracker;

import java.util.Date;

public class Message {

    /**
     * This attribute is the Contract number
     */
    private int contractId;

    /**
     * This attribute is the date of creation messafe
     */
    private Date createAt;

    /**
     * This attribute is the read date message
     */
    private Date readAt;

    /**
     * Constructor method
     * @param contractId number
     * @param createAt date creation
     * @param readAt date readed
     */
    public Message(int contractId, Date createAt, Date readAt)
    {
        this.contractId = contractId;
        this.createAt = createAt;
        this.readAt = readAt;
    }

    /**
     * Method to read message
     */
    public void read()
    {
        //TODO
    }

    /**
     * Method to return if message is readed
     * @return boolean
     */
    public boolean isUnreaded()
    {
        //TODO
        return  true;
    }

    /**
     * This method get de Date of creation message
     * @return Date
     */
    public Date getCreateAt() {
        return createAt;
    }

    /**
     * This methods return de readed date
     * @return Date
     */
    public Date getReadAt() {
        return readAt;
    }

    /**
     * This method sets readAt
     * @param readAt
     */
    public void setReadAt(Date readAt) {
        this.readAt = readAt;
    }

    /**
     * This methods get the contractId number
     * @return int
     */
    public int getContractId() {
        return contractId;
    }

    /**
     * This method set contractId number
     * @param contractId
     */
    public void setContractId(int contractId) {
        this.contractId = contractId;
    }
}
