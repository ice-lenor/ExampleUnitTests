package geometry;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GeometryHelpersTest1 {
    @Test
    void distanceNetherlandsNorthToSouth() {

        double lat1 = 53.478612, lon1 = 6.250578, lat2 = 50.752342, lon2 = 5.916981;

        double expectedDistance = 304001.02104608883; // meters

        double resultDistance = GeometryHelpers.getDistance(lat1, lon1, lat2, lon2);

        assertEquals(expectedDistance, resultDistance);
    }
}
