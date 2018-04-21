package edu.uoc.dpoo.tracker;

public  abstract class SafeZone {

    private String description;

    /**
     * Constructhor method
     * @param description of safe zone
     */
    public SafeZone(String description)
    {
        this.description = description;
    }

    /**
     * This method return true if zone y safety, otherwise false
     * @param c cooordinate
     * @return boolean
     */
    public boolean contains(Coordinate c)
    {
        return true;
    }

    /**
     * This method get the description zone
     * @return string
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method set description of safezone
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
