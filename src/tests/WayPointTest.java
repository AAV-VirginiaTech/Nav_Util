package tests;

import data.PointType;
import data.WayPoint;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests the WayPoint class to ensure it operates as intended
 */
class WayPointTest {

    /**
     * The WayPoint used in testing
     */
    private WayPoint wp;

    /**
     * Setting up each test before running it
     */
    @BeforeEach
    void setup() {
        wp =  new WayPoint(78.1321, 34.1231, 345);
    }

    /**
     * Testing the getLatitude method
     */
    @Test
    void testGetLatitude() {
        double lat = wp.getLatitude();
        assertEquals(78.1321, lat);
    }

    /**
     * Testing the getLongitude method
     */
    @Test
    void testGetLongitude() {
        double longi = wp.getLongitude();
        assertEquals(34.1231, longi);
    }

    /**
     * Testing the getHeight method
     */
    @Test
    void testGetHeight() {
        double height = wp.getHeight();
        assertEquals(345, height);
    }

    /**
     * Tests the getPointType method
     */
    @Test
    void testGetPointType() {
        PointType pt = wp.getPointType();
        assertEquals(PointType.valueOf("WAY"), pt);
    }

    /**
     * Tests the toString Method
     */
    @Test
    void testToString() {
        String expected = "Point Type: WAY   Lat: 78.1321   Long: 34.1231   Height: 345.0\n";
        assertEquals(expected, wp.toString());
    }

    /**
     * Tests the equals method
     */
    @Test
    void testEquals() {
        WayPoint other = null;
        assertFalse(wp.equals(other));

        assertTrue(wp.equals(wp));

        assertFalse(wp.equals("Other"));

        other = new WayPoint(78.1211, 34.1231, 345);
        assertFalse(wp.equals(other));

        other = new WayPoint(78.1321, 34.1111, 345);
        assertFalse(wp.equals(other));

        other = new WayPoint(78.1321, 34.1231, 300);
        assertFalse(wp.equals(other));

        other = new WayPoint(78.1321, 34.1231, 345);
        assertTrue(wp.equals(other));
    }
}
