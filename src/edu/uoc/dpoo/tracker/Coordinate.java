package edu.uoc.dpoo.tracker;

import java.util.Date;

public class Coordinate {

    /**
     * This attribute is for generate coordinate
     */
    private float latitude;

    /**
     * This attribute is for generate coordinate
     */
    private float longitude;

    /**
     * This attribute is the time coordinate generated
     */
    private Date timeStamp;

    /**
     * Constructor method
     * @param latitude coordinate
     * @param longitude coordinate
     * @param timeStamp register coordinate
     */
    public Coordinate(float latitude, float longitude, Date timeStamp)
    {
        this.latitude = latitude;
        this.latitude = longitude;
        this.timeStamp = timeStamp;
    }

    /**
     *
     * @param c Coordinate
     * @return distance from other coordinate
     */
    public float distanceTo(Coordinate c) {
        return 0;
    }

    /**
     * This method get latitude coordinate
     * @return float
     */
    public float getLatitude() { return latitude; }

    /**
     * This method set latitude
     * @param latitude
     */
    public void setLatitude(float latitude) { this.latitude = latitude; }

    /**
     * This method get longitude coordinate
     * @return float
     */
    public float getLongitude() { return longitude; }

    /**
     * This method sets longitude
     * @param longitude
     */
    public void setLongitude(float longitude) { this.longitude = longitude; }

    /**
     * This method get time the coordinate create
     * @return date
     */
    public Date getTimeStamp() { return timeStamp; }

    /**
     * This method sets time
     * @param timeStamp
     */
    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }
}
