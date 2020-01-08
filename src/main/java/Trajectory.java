
public class Trajectory {
    private double x;
    private double y;

    public Trajectory(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "x=" + x +
                ", y=" + y + '\n';
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

}
