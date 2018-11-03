package data;

public class WayPoint {

    /**
     * The Height of the waypoint
     * @TODO add what measurement for height
     */
    private double height;

    /**
     * The latitude of the waypoint
     */
    private double latitude;

    /**
     * The longitude of the waypoint
     */
    private double longitude;

    /**
     * The Point type for the waypoint
     */
    private final PointType POINT_TYPE = PointType.WAY;


    /**
     * Creates a waypoint at the given latitude, longitude, and height
     *
     * @param latitude : The waypoint's latitude
     * @param longitude : The waypoint's longitude
     * @param height : The waypoint's height
     */
    public WayPoint(double latitude, double longitude, double height) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.height  = height;
    }

    /**
     * Retrieves the waypoint's height
     * @return  the waypoint's height
     */
    public double getHeight() {
        return height;
    }

    /**
     * Retrieves the waypoint's latitude
     * @return  the waypoint's latitude
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * Retrieves the waypoint's longitude
     * @return  the waypoint's longitude
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * Retrieves the waypoint's PointType
     * @return  the waypoint's PointType
     */
    public PointType getPointType() {
        return POINT_TYPE;
    }

    /**
     * @TODO    Implement the toString Method
     * @TODO    Implement the Equals Method
     */
}
