class Gauss {
    double[][] valueArray;
    double[] freeArray, result;

    public Gauss(double[][] valueArray, double[] freeArray){                                                                          //constructor
        this.valueArray = valueArray;
        this.freeArray = freeArray;
        this.result = new double[freeArray.length];
        solve();
//        printer();
    }

    void elimination(){                                                                                 //eliminacja zer
        for(int x = 0; x < valueArray.length - 1; x++){
            for(int i = x + 1; i < valueArray.length; i++){
                double temp = valueArray[i][x]/valueArray[x][x];
                freeArray[i] -= freeArray[x]*temp;
                for(int j = x; j < valueArray.length; j++){
                    valueArray[i][j] -= (valueArray[x][j] * temp);
                }
            }
        }
    }
    void solve(){                                                                         //zwraca rozwiązania x, y, z
        elimination();
        for(int i = valueArray.length -1; i > -1; i--){
            for (int j = valueArray.length - 1; j >  i ;j--){                                       // for od odejmownia
                freeArray[i] = freeArray[i] -  valueArray[i][j]*result[j]  ;
            }
            result[i] = freeArray[i]/valueArray[i][i];
        }
    }
    void printer(){
        System.out.println();
        for (int i = 0; i<result.length; i++){
            System.out.println(result[i]);
        }
    }

}