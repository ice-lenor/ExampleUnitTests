package smartpuffin.com;

public class GeometryHelpers {
    private static double EarthRadius = 6371000;


    public static double getDistance(double latitude1, double longitude1, double latitude2, double longitude2) {

        if (!isValidLatitude(latitude1)
                || !isValidLatitude(latitude2)
                || !isValidLongitude(longitude1)
                || !isValidLongitude(longitude2))
            throw new IllegalArgumentException();

        double latitude1Radians = toRadians(latitude1);
        double latitude2Radians = toRadians(latitude2);
        double latitudeDiffRadians = toRadians(latitude2-latitude1);
        double longitudeDiffRadians = toRadians(longitude2-longitude1);

        double a = Math.sin(latitudeDiffRadians/2) * Math.sin(latitudeDiffRadians/2) +
                Math.cos(latitude1Radians) * Math.cos(latitude2Radians) * Math.sin(longitudeDiffRadians/2) * Math.sin(longitudeDiffRadians/2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));

        double distance = EarthRadius * c;
        return distance;
    }

    private static boolean isValidLatitude(double latitude) {
        return latitude <= 90 && latitude >= -90;
    }

    private static boolean isValidLongitude(double latitude) {
        return latitude <= 180 && latitude >= -180;
    }

    private static double toRadians(double degrees) {
        double radians = degrees * Math.PI / 180;
        return radians;
    }
}
