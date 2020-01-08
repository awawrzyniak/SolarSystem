public class WynikiMetod
{
    private int iteraacja;
    private double x;
    private double bladA;

    public WynikiMetod(int iteraacja, double x, double bladA) {
        this.iteraacja = iteraacja;
        this.x = x;
        this.bladA = bladA;
    }

    public int getIteraacja() {
        return iteraacja;
    }

    public double getX() {
        return x;
    }


    public double getBladA() {
        return bladA;
    }


    @Override
    public String toString() {
        return "WynikiMetod{" +
                "iteraacja=" + iteraacja +
                ", x=" + x +
                ", bladA=" + bladA +
                '}';
    }
}
