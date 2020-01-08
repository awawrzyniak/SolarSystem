import java.util.ArrayList;

public class MethodsCalculate {

    public static ArrayList <WynikiMetod> bisectionMethod(Function function, double xL, double xU, double maxError, int maxIteration)
    {
        ArrayList <WynikiMetod> WynikiMetod = new ArrayList<>();

        double xrOld = 0;
        double xr = 0;

        for (int i = 1; i<=maxIteration; i++)
        {
            xr = (xL+xU)/2;
            double xLF = function.value(xL);
            double xRF = function.value(xr);

            if (xLF * xRF < 0)
              xU = xr;
              else if (xLF * xRF == 0)
              {
                  xU = xr;
                  xL = xr;
              }
              else if (xLF * xRF > 0)
                xL = xr;

              double error = Math.abs(100*((xr - xrOld) / xr));

              WynikiMetod wynik = new WynikiMetod(i,xr,error);
              WynikiMetod.add(wynik);

            if (error > maxError)
                xrOld = xr;
            else
                break;
        }
        return WynikiMetod;
    }

    public static ArrayList <WynikiMetod> regulaFalsiMethod(Function function, double xL, double xU, double maxError, int maxIteration) {
        ArrayList <WynikiMetod> WynikiMetod = new ArrayList<>();

        double xrOld = 0;
        double xr = 0;

        for (int k = 1; k<=maxIteration; k++){

            double xLF = function.value(xL);
            double xUF = function.value(xU);
            xr = xU - ((xUF * (xL-xU))/(xLF-xUF));
            double xRF = function.value(xr);

            if (xLF * xRF < 0)
                xU = xr;
            else if (xLF * xRF == 0){
                xU = xr;
                xL = xr;
            }
            else if (xLF * xRF > 0)
                xL = xr;

            double error = Math.abs(100*((xr - xrOld) / xr));

            WynikiMetod wynik = new WynikiMetod(k,xr,error);
            WynikiMetod.add(wynik);

            if (error>maxError)
                xrOld = xr;
            else
                break;
        }
        return WynikiMetod;
    }

    public static ArrayList <WynikiMetod> fixedPointMethod(Function function, double maxError, int maxIteration, double x)
    {
        ArrayList <WynikiMetod> WynikiMetod = new ArrayList<>();
        double xN = 0;

        for(int k = 1; k <= maxIteration; k++){

            xN = function.value(x) + x;
            double error = Math.abs(100*((xN - x) / xN));

            WynikiMetod wynik = new WynikiMetod(k,xN,error);
            WynikiMetod.add(wynik);

            if (error>maxError)
                x = xN;
            else
                break;
        }
        return WynikiMetod;
}

    public static ArrayList <WynikiMetod> newtonMethod(Function function, double maxError, int maxIteration, double x) {

        ArrayList<WynikiMetod> WynikiMetod = new ArrayList<>();
        double x0 = x;

        for(int k = 1; k <= maxIteration; k++){

            x = x0 - ((function.value(x0))/(-1 * Math.exp(-x0)-1));
            double error = Math.abs(100*((x - x0) / x));

            WynikiMetod wynik = new WynikiMetod(k,x,error);
            WynikiMetod.add(wynik);

            if (error>maxError)
                x0 = x;
            else
                break;
        }
    return WynikiMetod;
    }


}
