package geometry;

public class GeometryHelpers {
    private static double EarthRadiusKm = 6371000;

    // Returns distance between two points on the surface of the Earth using the haversine formula.
    // https://en.wikipedia.org/wiki/Haversine_formula
    // Returned distance is in meters.
    public static double getDistance(double lat1, double lon1, double lat2, double lon2) {

        if (!isValidLatitude(lat1)
                || !isValidLatitude(lat2)
                || !isValidLongitude(lon1)
                || !isValidLongitude(lon2))
            throw new IllegalArgumentException();

        double lat1Radians = Math.toRadians(lat1);
        double lat2Radians = Math.toRadians(lat2);
        double latDiffRadians = Math.toRadians(lat2-lat1);
        double lonDiffRadians = Math.toRadians(lon2-lon1);

        double a = Math.sin(latDiffRadians/2) * Math.sin(latDiffRadians/2) +
                Math.cos(lat1Radians) * Math.cos(lat2Radians) * Math.pow(Math.sin(lonDiffRadians/2), 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));

        double distance = EarthRadiusKm * c;
        return distance;
    }

    private static boolean isValidLatitude(double latitude) {
        return latitude <= 90 && latitude >= -90;
    }

    private static boolean isValidLongitude(double longitude) {
        return longitude <= 180 && longitude >= -180;
    }
}
