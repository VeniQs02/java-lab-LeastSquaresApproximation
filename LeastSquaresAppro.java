import static java.lang.Math.pow;
import static java.lang.Math.round;

public class LeastSquaresAppro {
    double a, b, x, p, result;
    int n;
    double[][] valueMat;
    double[] freeMat, gaussResults;

    LeastSquaresAppro(double a, double b, double x, int n){
        this.a = a;
        this.b = b;
        this.x = x;
        this.p = 1;
        this.n = n;
        valueMat = new double[n+1][n+1];
        freeMat = new double[n+1];
        LeastSquaresFill();
        Gauss gau = new Gauss(valueMat, freeMat);
        gaussResults = gau.result;
        LeastSquaresCalcW(x);

    }
    void LeastSquaresFill(){
        for(int i=0; i<n+1; i++){
            numericIntegration num = new numericIntegration(a, b, 500, i);
            freeMat[i] = num.result;
            freeMat[i] = round(freeMat[i] * 100.0)/100.0;
            for(int j=0; j<n+1; j++){
                valueMat[i][j] = ((p * pow(b, i+j+1))/(i+j+1)) - ((p * pow(a, i+j+1))/(i+j+1));
                valueMat[i][j] = round(valueMat[i][j]*100.0)/100.0;
                System.out.print(valueMat[i][j] + " ");
            }
            System.out.println("| "+ freeMat[i]);
        }
    }
    void LeastSquaresCalcW(double x){
        result = 0;
        for(int i = 0; i<gaussResults.length; i++){
            result += gaussResults[i]*pow(x, i);
        }
        System.out.println("\nW("+x+"): "+result);
    }


}

// ((4x^2) + 3)^(1/2)
// 7. √(4𝑥^2 + 3) a = -1, b = 1, x = 0.25
