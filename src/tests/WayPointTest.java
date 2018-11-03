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
     * @TODO    Implement test for toString
     * @TODO    Implement test for equals
     */
}
