package co.com.sofka;

public class Calculadora {

    public Calculadora() {
    }

    public static float suma(float numero1, float numero2){
        return numero1 + numero2;
    }

    public static float resta (float numero1, float numero2){
        return numero1-numero2;
    }

    public static float multiplicacion_Auxiliar(float numero1, float numero2, float numero3){
        numero2= resta(numero2,1);
        if (numero2<=0) return numero1;
        numero1=suma(numero1,numero3);
        return multiplicacion_Auxiliar(numero1,numero2,numero3);
    }

    public static float multiplicacion(float numero1, float numero2){
        if(numero2<0){
            numero2=-numero2;
            return -multiplicacion_Auxiliar(numero1,numero2,numero1);
        }
        return multiplicacion_Auxiliar(numero1,numero2,numero1);
    }

    public static float division_Auxiliar(float numero1, float numero2, float numero3){
        numero3= suma(numero3,1);
        float result = multiplicacion(numero2,numero3);
        if(numero1<result)return resta(numero3,1);
        else return division_Auxiliar(numero1,numero2,numero3);
    }

    public static float divicion(float numero1,float numero2){
        if (numero2<0){
            numero2=-numero2;
        }

         return division_Auxiliar(numero1,numero2,0);
    }

    public static void main(String[] args) {
        final float variable1=-28;
        final float variable2=2;
        System.out.println(divicion(variable1,variable2));

}}
