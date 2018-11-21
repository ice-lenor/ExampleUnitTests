package smartpuffin.com;

import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import static org.junit.jupiter.api.Assertions.*;

class GeometryHelpersTest {

    @Test
    void distanceBetweenTheSamePoints_0_0_Is0() {
        double distance = GeometryHelpers.getDistance(0,0,0,0);
        assertEquals(0, distance);
    }

    @Test
    void distanceBetweenTheSamePoints_90_180_Is0() {
        double distance = GeometryHelpers.getDistance(90,180,90,180);
        assertEquals(0, distance);
    }

    @Test
    void distanceBetweenTheSamePoints_Minus90_180_Is0() {
        double distance = GeometryHelpers.getDistance(-90,180,-90,180);
        assertEquals(0, distance);
    }

    @Test
    void distanceBetweenTheSamePoints_90_Minus180_Is0() {
        double distance = GeometryHelpers.getDistance(90,-180,90,-180);
        assertEquals(0, distance);
    }

    @Test
    void distanceBetweenTheSamePoints_Minus90_Minus180_Is0() {
        double distance = GeometryHelpers.getDistance(-90,-180,-90,-180);
        assertEquals(0, distance);
    }


    //
    // Negative cases
    //

    @Test
    void invalidLatitude1TooMuch() {
        assertThrows(IllegalArgumentException.class, () -> {
            GeometryHelpers.getDistance(666,0,0,0);
        });
    }

    @Test
    void invalidLatitude1TooLittle() {
        assertThrows(IllegalArgumentException.class, () -> {
            GeometryHelpers.getDistance(-666,0,0,0);
        });
    }

    @Test
    void invalidLatitude2TooMuch() {
        assertThrows(IllegalArgumentException.class, () -> {
            GeometryHelpers.getDistance(0,0,666,0);
        });
    }

    @Test
    void invalidLatitude2TooLittle() {
        assertThrows(IllegalArgumentException.class, () -> {
            GeometryHelpers.getDistance(0,0,-666,0);
        });
    }

    @Test
    void invalidLongitude1TooMuch() {
        assertThrows(IllegalArgumentException.class, () -> {
            GeometryHelpers.getDistance(0,666,0,0);
        });
    }

    @Test
    void invalidLongitude1TooLittle() {
        assertThrows(IllegalArgumentException.class, () -> {
            GeometryHelpers.getDistance(0,-666,0,0);
        });
    }

    @Test
    void invalidLongitude2TooMuch() {
        assertThrows(IllegalArgumentException.class, () -> {
            GeometryHelpers.getDistance(0,0,0,666);
        });
    }

    @Test
    void invalidLongitude2TooLittle() {
        assertThrows(IllegalArgumentException.class, () -> {
            GeometryHelpers.getDistance(0,0,0, -666);
        });
    }

}
