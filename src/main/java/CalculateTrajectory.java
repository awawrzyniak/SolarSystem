import java.util.ArrayList;

public class CalculateTrajectory
{
    public static ArrayList <Trajectory> keplerCalculation(Planet planet, double maxError, Methods method)
    {
        ArrayList<Trajectory> kepler = new ArrayList<>();

        double m [] = new double[365];

        for(int i =0; i<m.length;i++)
            m[i] = (2* Math.PI * (i+1)/m.length);

        for(int i = 0; i<m.length;i++)
        {
            double M = m[i];
            ArrayList <WynikiMetod> wynik = new ArrayList<>();
            switch (method) {
                case Bisection:
                    wynik = MethodsCalculate.bisectionMethod((x) -> M + planet.getEccentricity() * Math.sin(x) - x, 0, 1, maxError, 100);
                case Falsi:
                    wynik = MethodsCalculate.regulaFalsiMethod((x) -> M + planet.getEccentricity() * Math.sin(x) - x, 0, 1, maxError, 100);
                case Newton:
                    wynik = MethodsCalculate.newtonMethod((x) -> M + planet.getEccentricity() * Math.sin(x) - x,maxError,100,0);
                case FixedPoint:
                    wynik = MethodsCalculate.fixedPointMethod((x) -> M + planet.getEccentricity() * Math.sin(x) - x,maxError,100,0);
            }

            double e = wynik.get(wynik.size()-1).getX();
            double x = planet.getDistance() * Math.cos(e-planet.getEccentricity());
            double y = planet.getDistance() * Math.sqrt(1-Math.pow(planet.getEccentricity(),2)) * Math.sin(e);
            kepler.add(new Trajectory(x,y));
        }
        return kepler;
    }
}
