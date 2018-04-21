package edu.uoc.dpoo.tracker;

public class CircularSafeZone extends SafeZone {

    /**
     * This attribute is the distance of circular safe zone
     */
    private float radius;

    /**
     * Constructor method
     * @param description child description atribute
     * @param radius of safe zone
     */
    public CircularSafeZone(String description, float radius)
    {
        super(description);
        this.radius = radius;
    }

    /**
     * This method get the radius of zone
     * @return float
     */
    public float getRadius() {
        return radius;
    }

    /**
     * This method set the radius
     * @param radius of safe zone
     */
    public void setRadius(float radius) {
        this.radius = radius;
    }
}
