package edu.uoc.dpoo.tracker;

import java.util.Date;

public class Message {

    /**
     * This attribute is the Contract number
     */
    private int contractId;

    /**
     * This attribute is the date of creation message
     */
    private Date createAt;

    /**
     * This attribute is the read date message
     */
    private Date readAt;

    private MessageType type;

    /**
     * Constructor method
     * @param contractId number
     * @param createAt date creation
     * @param readAt date readed
     */
    public Message(int contractId, Date createAt, Date readAt, MessageType type)
    {
        this.contractId = contractId;
        this.createAt = createAt;
        this.readAt = readAt;
        this.type = type;
    }

    /**
     * Method to read message
     */
    public void read()
    {
       Date now = new Date();
       this.readAt = now;
    }

    /**
     * Method to return if message is readed
     * @return boolean
     */
    public boolean isUnreaded()
    {
        if (this.readAt == null) {
            return true;
        }

        return false;
    }

    /**
     * This method get de Date of creation message
     * @return Date
     */
    public Date getCreatedAt() {
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

    /**
     * This method return
     * @return
     */
    public MessageType getType(){
        return type;
    }

}
