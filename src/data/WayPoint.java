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
     * Creates a String representation of the WayPoint in the following format:
     * Point Type: WAY   Lat: <lat>   Long: <long>  Height: <height>
     *
     * @Return  A string representing the WayPoint
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Point Type: ");
        sb.append(POINT_TYPE);
        sb.append("   Lat: ");
        sb.append(latitude);
        sb.append("   Long: ");
        sb.append(longitude);
        sb.append("   Height: ");
        sb.append(height);
        sb.append("\n");
        return sb.toString();
    }

    /**
     * Determines of two Waypoints are equal. Waypoints are equal if they both have
     * the same lat, long, and height.
     *
     * @return  true if they are equal otherwise false
     */
    public boolean equals(Object obj) {

        if (obj == null) return false;
        if (obj == this) return true;
        if (obj.getClass() == WayPoint.class) {
            WayPoint other = (WayPoint) obj;
            return other.longitude == this.longitude &&
                    other.latitude == this.latitude &&
                    other.height == this.height;
        } else {
            return false;
        }

    }
}
