package edu.uoc.dpoo.tracker;

public class SquareSafeZone extends SafeZone {

    private float size;

    /**
     * Constructor method
     * @param description child
     * @param size of square
     */
    public SquareSafeZone(String description, float size)
    {
        super(description);
        this.size = size;
    }

    /**
     * This method gets size of square safe zone
     * @return float
     */
    public float getSize() {
        return size;
    }

    /**
     * This method sets the size of safe zone
     * @param size square zone
     */
    public void setSize(float size) {
        this.size = size;
    }
}
