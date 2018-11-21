package smartpuffin.com;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GeometryHelpersTest {

    private double Precision = 0.001; // We are comparing calculated distance using 1mm precision

    //
    // Base cases: normal distances in different points of the planet
    //

    @Test
    void distanceNetherlandsNorthToSouth() {
        double distance = GeometryHelpers.getDistance(53.478612, 6.250578, 50.752342,  5.916981);
        assertEquals(304001.0210, distance, Precision);
    }

    @Test
    void distanceAustraliaWestToEast() {
        double distance = GeometryHelpers.getDistance(-23.939607, 113.585605, -28.293166, 153.718989);
        assertEquals(4018083.0398, distance, Precision);
    }
    
    @Test
    void distanceFromCapetownToJohannesburg() {
        double distance = GeometryHelpers.getDistance(-33.926510, 18.364603,-26.208450, 28.040572);
        assertEquals(1265065.6094, distance, Precision);
    }

    @Test
    void distanceIsTheSameIfMeasuredInBothDirections() {
        // testing that distance is the same in whatever direction we measure
        double distanceDirection1 = GeometryHelpers.getDistance(-33.926510, 18.364603,-26.208450, 28.040572);
        double distanceDirection2 = GeometryHelpers.getDistance(-26.208450, 28.040572, -33.926510, 18.364603);
        assertEquals(1265065.6094, distanceDirection1, Precision);
        assertEquals(1265065.6094, distanceDirection2, Precision);
    }
    

    //
    // Corner cases
    //

    // Distance around 180th meridian - read more about this problem here:
    // https://smartpuffin.com/little-geo-stories-a-tale-of-180th-meridia
    @Test
    void distanceAround180thMeridianFiji() {
        double distance = GeometryHelpers.getDistance(-17.947826, 177.221232, -16.603513, -179.779055);
        assertEquals(356489.0131, distance, Precision);
    }
    @Test
    void distanceAround0thMeridianLondon() {
        double distance = GeometryHelpers.getDistance(51.512722, -0.288552, 51.516100, 0.068025);
        assertEquals(24677.4562, distance, Precision);
    }

    // How about poles? Let's have a couple of distances in the Arctic and Antarctica.


    // How about from one pole to another?

    // How about max distance on the planet?

    // How about a really small distance?

    // If both points are absolutely the same, are we getting 0 m distance?

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
