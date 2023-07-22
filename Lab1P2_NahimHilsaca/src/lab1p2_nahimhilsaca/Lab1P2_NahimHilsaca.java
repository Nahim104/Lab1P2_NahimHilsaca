/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab1p2_nahimhilsaca;

import java.util.Scanner;

/**
 *
 * @author nahim
 */
public class Lab1P2_NahimHilsaca {

    /**
     * @param args the command line arguments
     */
    static Scanner leer = new Scanner(System.in);

    public static void main(String[] args) {

        int opcion = 0;

        while (opcion != 3) {
            System.out.println("1. Metodo Newton-Raphson");
            System.out.println("2. Series de Taylor");
            System.out.println("3. Salir");
            opcion = leer.nextInt();

            switch (opcion) {

                case 1:
                    
                    System.out.println("Ingrese el primer coeficiente: ");
                    int coef1 = leer.nextInt();
                    System.out.println("Ingrese el segundo coeficiente: ");
                    int coef2= leer.nextInt();
                    System.out.println("Ingrese el tercer coeficiente: ");
                    int coef3= leer.nextInt();
                    
                    int vertice= -coef2/(2*coef1);
                    
                    while(coef1 ==0){
                        System.out.println("El primer coeficiente no puede ser 0");
                         System.out.println("Ingrese el primer coeficiente: ");
                         coef1 = leer.nextInt();
                    }//fIN DEL WHILE
                   
                    
                    
                    break;

                case 2:
                        
                    double resp_seno = 0;
                    double resp_coseno = 0;
                    double resp_tangente=0;
                    System.out.println("Ingrese x: ");
                     int integer = leer.nextInt();
                    System.out.println("Ingrese el limite: ");
                     int lim = leer.nextInt();
                    
                  
                     while (lim < 0) {
                        System.out.println("Su limite no puede ser menor a cero");
                        System.out.println("Ingrese el limite: ");
                        lim = leer.nextInt();
                    }
                    System.out.println("El seno es: " + seno(-integer, lim, 0, resp_seno));//n es cero ya que n inicia desde 0 hasta limite
                    System.out.println("El coseno es"
                            + coseno(-integer, lim, 0, resp_coseno));
                   while(integer<90){
                   
                       System.out.println("La tengente no puede tener grados menor a 90");
                       System.out.println("Ingrese x:");
                       integer=leer.nextInt();
                   }
                    System.out.println("La tengente es:"
                            + tan(-integer,lim,0,resp_tangente));
                      
                    break;

                case 3:
                    System.out.println("Gracias por usar el programa!");
                    break;

                default:
                    System.out.println("Ingrese de las opciones dadas");
                    break;

            }//Fin del switch

        }//Fin del while
    }//Fin del metodo main

    public static double seno(int x, int limite, int n, double resultado_final) {

        if (n == limite+1) {

            return resultado_final;// mi caso base es n, o sea el contador
        } else {
            int expresion_denominador = 2 * n + 1;
            double numerador = Math.pow(-1, n);
            double denominador = factorial(expresion_denominador);
            double multiplicacion = Math.pow(x, expresion_denominador);

            resultado_final = (numerador / denominador) * multiplicacion;
            return resultado_final + seno(x, limite, n + 1, resultado_final);//n va aumentando hasta que sea igual al limite   
        }
    }//Fin del metodo

    public static int factorial(int factorial) {

        for (int i = factorial - 1; i > 1; i--) {

            factorial *= i;
        }
        return factorial;
    }//Fin del metodo

    public static double coseno(int x, int limite, int n, double resultado_final) {

        if (n == limite+1) {

            return resultado_final;// mi caso base es resultado_final
        } else {
            int expresion_denominador = 2 * n;
            double numerador = Math.pow(-1, n);
            double denominador = factorial(expresion_denominador);
            double multiplicacion = Math.pow(x, expresion_denominador);

            resultado_final = (numerador / denominador) * multiplicacion;
            return resultado_final + coseno(x, limite, n + 1, resultado_final);//n va aumentando hasta que sea igual al limite   
        }
    }//Fin del metodo
    public static double tan(int x, int limite, int n, double resultado_final) {

        if (n == limite+1) {

            return resultado_final;// mi caso base es resultado_final
        } else {
            int expresion_denominador = 2 * n-1;
            double numerador = Math.pow(-4, n)*Math.pow(2,n)*(1-(Math.pow(4, n)));
            double denominador = factorial(expresion_denominador);
            double multiplicacion = Math.pow(x, expresion_denominador);

            resultado_final = (numerador / denominador) * multiplicacion;
            return resultado_final + tan(x, limite, n + 1, resultado_final);//n va aumentando hasta que sea igual al limite   
        }
    }
    public static int Newton_Raphson(int a, int b, int c,double x, int iteraciones){
    if(iteraciones==0){
        return (int) x;
    }else{
        double funcion_normal = formula_normal(a, b, c, c);
        double formula_derivada= formula_normal(a, b, c, c);
        double raiz= x-(funcion_normal/formula_derivada);
     
    return Newton_Raphson(a, b, c, raiz, iteraciones-1);// cada recursividad hace una iteracion yendose a la reversa
    }
    
    
    
}
    
    public static double formula_normal(int a, int b, int c, int x){
    
    return a*x*x+b*x+c;
    }
    public static double formula_derivda(int a, int b, int c, int x){
    
    return 2*a*x+b;
    }
    
    
    
}//Fin de la clase
