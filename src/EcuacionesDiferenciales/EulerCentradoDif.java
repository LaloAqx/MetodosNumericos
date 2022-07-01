
package EcuacionesDiferenciales;


import java.util.Scanner;

public class EulerCentradoDif {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Euler myEuler = new Euler(1.0,1.0,0.1,1.5);
        System.out.println( "x\t    explicit\tactual\t  error\t    " );

        System.out.printf("%f\t%f\t%f\t%f\n", myEuler.getinitialx(), 
        myEuler.getinitialy(),myEuler.getinitialexact(),
        myEuler.getinitialerror());

        System.out.printf("El valor aproximado es: %f\n\n", 
        myEuler.getEulerResult ());

        System.out.println("introduce otro valor inicial de x: ");
        double initialx = input.nextDouble();

        System.out.println("introduce otro valor inicial de y: ");
        double initialy = input.nextDouble();

        System.out.println("introduzca otro valor de tamaño de paso de h: ");
        double stepsize = input.nextDouble();

        System.out.println("introducir otro límite superior de x: ");
        double finalx1 = input.nextDouble();

        myEuler.setEuler(initialx,initialy,stepsize,finalx1);
        System.out.println( "x\t    explicito\tactual\t  error\t    " );

        System.out.printf("%f\t%f\t%f\t%f\n", myEuler.getinitialx(), 

        myEuler.getinitialy(),myEuler.getinitialexact(),
        myEuler.getinitialerror());

        System.out.printf("el valor aproximado es %f\n\n", 
        myEuler.getEulerResult ());

    }
}