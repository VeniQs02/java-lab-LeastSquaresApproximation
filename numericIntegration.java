
import static java.lang.Math.pow;

public class numericIntegration {
    double a, b, h, result;
    int power;

    numericIntegration(double a, double b, int n, int power){
        this.a = a;
        this.b = b;
        this.h = (b-a)/n;
        this.power = power;

        calc_sum();
//        System.out.println(result);
    }
    void calc_sum(){
        result = h * ((calc(a)/2) + calcIterating() + (calc(b)/2));
    }
    double calcIterating(){
        double resultCalc = 0;

        for(double i = a+h; i < b; i += h){
            resultCalc += calc(i);
        }

        return resultCalc;
    }
    double calc(double x){
        return pow(x, power) * pow((4*pow(x, 2)) + 3, 0.5);
    }
}
