package tests;

import data.PointType;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


/**
 * Testing the PointType enum to ensure it can be addressed correctly
 */
public class PointTypeTest {

    /**
     * Tests the NAV enum type
     */
    @Test
    void testNAVType() {
        PointType nav = PointType.NAV;
        assertEquals(PointType.valueOf("NAV"), nav);
    }

    /**
     * Tests the WAY enum type
     */
    @Test
    void testWAYType() {
        PointType way = PointType.WAY;
        assertEquals(PointType.valueOf("WAY"), way);
    }
}
