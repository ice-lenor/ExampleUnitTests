package smartpuffin.com;

import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import static org.junit.jupiter.api.Assertions.*;

public class GeometryHelpersTest {

    @Test
    public void distanceIs0() {
        double distance = GeometryHelpers.getDistance(0,0,0,0);
        assertEquals(0, distance);
    }

}