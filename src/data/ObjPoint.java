package data;

abstract public class ObjPoint {

    /**
     * The Height of the ObjPoint
     * @TODO add what measurement for height
     */
    protected double height;

    /**
     * The latitude of the ObjPoint
     */
    private double latitude;

    /**
     * The longitude of the ObjPoint
     */
    private double longitude;

    /**
     * The Point type for the ObjPoint
     */
    private PointType pointType;

    /**
     * Creates a ObjPoint at the given latitude, longitude, and height
     *
     * @param latitude : The ObjPoint's latitude
     * @param longitude : The ObjPoint's longitude
     * @param height : The ObjPoint's height
     */
    public ObjPoint(PointType pt, double latitude, double longitude, double height) {
        this.pointType = pt;
        this.latitude = latitude;
        this.longitude = longitude;
        this.height  = height;
    }

    /**
     * Retrieves the ObjPoint's height
     * @return  the ObjPoint's height
     */
    public double getHeight() {
        return height;
    }

    /**
     * Retrieves the ObjPoints's latitude
     * @return  the ObjPoints's latitude
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * Retrieves the ObjPoints's longitude
     * @return  the ObjPoints's longitude
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * Retrieves the ObjPoints's PointType
     * @return  the ObjPoints's PointType
     */
    public PointType getPointType() {
        return pointType;
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
        sb.append(pointType);
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
     * Determines of two ObjPoints are equal. ObjPoints are equal if they both have
     * the same lat, long, height, and PointType.
     *
     * @param obj   the object to compate against
     * @return  true if they are equal otherwise false
     */
    public boolean equals(Object obj) {

        if (obj == null) return false;
        if (obj == this) return true;
        if (obj.getClass() == WayPoint.class) {
            WayPoint other = (WayPoint) obj;
            return other.getLongitude() == this.longitude &&
                    other.getLatitude() == this.latitude &&
                    other.getHeight() == this.height &&
                    other.getPointType() == this.pointType;
        } else {
            return false;
        }

    }
}
