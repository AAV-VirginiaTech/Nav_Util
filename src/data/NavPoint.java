package data;

public class NavPoint extends ObjPoint {

    public NavPoint(double latitude, double longitude, double height) {
        super(PointType.NAV, latitude, longitude, height);
    }

    public void setHeight(double height) {
        this.height = height;
    }

}
