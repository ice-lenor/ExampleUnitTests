package geometry;

public class Main {
    public static void main(String[] args) {

        double lat1NorthNetherlands = 53.478612, lon1NorthNetherlands = 6.250578;
        double lat2SouthNetherlands = 50.752342, lon2SouthNetherlands = 5.916981;
        double distance = GeometryHelpers.getDistance(
                lat1NorthNetherlands, lon1NorthNetherlands,
                lat2SouthNetherlands, lon2SouthNetherlands);

        System.out.print(String.format("Distance from the north to the south of the Netherlands: %.2f meters", distance, " meters"));
    }
}
