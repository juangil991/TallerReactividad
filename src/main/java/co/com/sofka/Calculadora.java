package co.com.sofka;

public class Calculadora {

    public Calculadora() {
    }

    public static int suma(int numero1, int numero2){
        return numero1 + numero2;
    }

    public static int resta (int numero1, int numero2){
        return numero1-numero2;
    }

    public static int multiplicacion_Auxiliar(int numero1, int numero2, int numero3){
        numero2= resta(numero2,1);
        if (numero2<=0) return numero1;
        numero1=suma(numero1,numero3);
        return multiplicacion_Auxiliar(numero1,numero2,numero3);
    }

    public static int multiplicacion(int numero1, int numero2){
        if(numero2<0){
            numero2=-numero2;
            return -multiplicacion_Auxiliar(numero1,numero2,numero1);
        }
        return multiplicacion_Auxiliar(numero1,numero2,numero1);
    }

    public static int division_Auxiliar(int numero1, int numero2, int numero3){
        int result = multiplicacion(numero2,numero3);
        if(numero1>0 && numero1<result || numero1<0 && numero1>result)return suma(numero3,-1);
        numero3= resta(numero3,-1);
        return division_Auxiliar(numero1,numero2,numero3);
    }

    public static int divicion(int numero1,int numero2){
        if(numero1<0&&numero2>0){
            numero1=-numero1;
            return -division_Auxiliar(numero1,numero2,1);
        }
        else if(numero2<0&&numero1>0){
            numero2=-numero2;
            return -division_Auxiliar(numero1,numero2,1);
        }

        return division_Auxiliar(numero1, numero2, 1);

    }

    public static void main(String[] args) {
        final int variable1=30;
        final int variable2=10;
        System.out.println(suma(variable1,variable2));
        System.out.println(resta(variable1,variable2));
        System.out.println(multiplicacion(variable1,variable2));
        System.out.println(divicion(variable1,variable2));
        System.out.println(variable1);
        System.out.println(variable2);
    }
}
