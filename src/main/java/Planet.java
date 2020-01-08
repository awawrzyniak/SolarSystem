public class Planet {
    private double distance;
    private double eccentricity;
    private String name;

    public Planet(double distance, double eccentricity, String name)
    {
        this.distance = distance;
        this.eccentricity = eccentricity;
        this.name = name;
    }

    public double getDistance() {
        return distance;
    }

    public double getEccentricity() {
        return eccentricity;
    }

    public String getName() {
        return name;
    }
}
