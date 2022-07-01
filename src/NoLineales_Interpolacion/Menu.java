package NoLineales_Interpolacion;

import java.io.*;


public class Menu {

    //Metodo Constructor
    public static void main(String args[]) {
        Menu Proyecto = new Menu();
        Proyecto.menu();  //solo se manda a llamar a menu desde aqui, ya que menu llama a los demas metodos posteriromente
    }

    //despliega menu
    public void menu() {
        int a;
        int p = 0;
        do {
            do {
                System.out.println("\n\n\t\t\tMETODOS NUMERICOS\n");
                System.out.println("ECUACIONES NO LINEALES:");
                System.out.println("\t1.-Biseccion\n\t2.-Falsa Posición\n\t3.-Newton-Raphson\n");
                System.out.println("INTERPOLACIÓN:");
                System.out.println("\t4.-Interpolacion Newton\n\t5.-Interpolacion Lagrange");
                a = leeint();
            } while (a < 1 || a > 5);
            switch (a) {
                case 1:
                    Biseccion bis = new Biseccion();
                    p = Fuera();
                    break;
                case 2:
                    FalsaPosicion fpo = new FalsaPosicion();
                    fpo.FalsaPosicion();
                    p = Fuera();
                    break;
                case 3:
                    NewtonRaphson nr=new NewtonRaphson();
                    nr.Resuelve(4, 0.005, 7);
                    nr.calculaRaiz();
                    p = Fuera();
                    break;
                case 4:
                    MetodoInterNewton();
                    p = Fuera();
                    break;
                case 5:
                    MetodoInterLagrange();
                    p = Fuera();
                    break;
                default:
                    System.out.println("Opcion incorrecta");
                    p = 1;
                    break;
            }
        } while (p == 1);
    }

    //(3)Metodo NewRaphson
    public void MetodoNewtonRaphson() {
        double a;
        double tol;
        double b;
        double c;
        System.out.println("\t\t\t\"METODO DE NEWTON-RAPHSON\"");
        System.out.println("Primera Aproximacion: ");
        a = lee();
        System.out.println("Tolerancia: ");
        tol = lee();
        do {
            b = a - (a * a - a - 2) / (2 * a - 1);
            c = Math.abs(a - b);
            a = b;
        } while (c > tol);
        System.out.println("La raiz es: " + b);
    }

    //(4) Interpolacion Newton
    public void MetodoInterNewton() {
        double a[][] = new double[5][2];
        double x, y, fx1x0, fx2x1, fx3x2, fx4x3, fx2x1x0, fx3x2x1, fx4x3x2, fx3x2x1x0, fx4x3x2x1, fx4x3x2x1x0;
        int i;
        System.out.println("\t\t\t\"INTERPOLACION DE DIFERENCIAS DE NEWTON P/ 5 PTOS.\"");
        System.out.println("Valor a interpolar: ");
        x = lee();
        System.out.println("Dame los 5 pares de puntos");
        for (i = 0; i < 5; i++) {
            System.out.println("Dame x " + i);
            a[i][0] = lee();
            System.out.println("Dame f(x) " + i);
            a[i][1] = lee();
        }
        fx1x0 = (a[1][1] - a[0][1]) / (a[1][0] - a[0][0]);
        fx2x1 = (a[2][1] - a[1][1]) / (a[2][0] - a[1][0]);
        fx3x2 = (a[3][1] - a[2][1]) / (a[3][0] - a[2][0]);
        fx4x3 = (a[4][1] - a[3][1]) / (a[4][0] - a[3][0]);
        fx2x1x0 = (fx2x1 - fx1x0) / (a[2][0] - a[0][0]);
        fx3x2x1 = (fx3x2 - fx2x1) / (a[3][0] - a[1][0]);
        fx4x3x2 = (fx4x3 - fx3x2) / (a[4][0] - a[2][0]);
        fx3x2x1x0 = (fx3x2x1 - fx2x1x0) / (a[3][0] - a[0][0]);
        fx4x3x2x1 = (fx4x3x2 - fx3x2x1) / (a[3][0] - a[0][0]);
        fx4x3x2x1x0 = (fx4x3x2x1 - fx3x2x1x0) / (a[4][0] - a[0][0]);
        y = a[0][1] + fx1x0 * (x - a[0][0]) + fx2x1x0 * (x - a[0][0]) * (x - a[1][0]) + fx3x2x1x0 * (x - a[0][0]) * (x - a[1][0]) * (x - a[2][0]) + fx4x3x2x1x0 * (x - a[0][0]) * (x - a[1][0]) * (x - a[2][0]) * (x - a[3][0]);
        System.out.println("f(x) en ese punto es: " + y);
    }
    //(5) Interpolacion Lagrange

    public void MetodoInterLagrange() {
        int n, i;
        double x, y;
        double a[][] = new double[4][2];
        System.out.println("\t\t\"METODO DE INTERPOLACION LAGRANGE  2-4 PTOS.\"");
        do {
            System.out.println("Dame el numero de puntos");
            n = leeint();
        } while (n < 2 || n > 4);
        System.out.println("Dame los  pares de puntos");
        for (i = 0; i < n; i++) {
            System.out.println("Dame x " + i);
            a[i][0] = lee();
            System.out.println("Dame f(x) " + i);
            a[i][1] = lee();
        }
        System.out.println("Dame el valor a interpolar ");
        x = lee();
        switch (n) {
            case 2:
                y = (((((x - a[1][0]) * a[0][1]) / (a[0][0] - a[1][0])) + (((x - a[0][0]) * a[1][1]) / (a[1][0] - a[0][0]))));
                System.out.println("f(x) en ese punto es: " + y);
                break;
            case 3:
                y = ((x - a[1][0]) * (x - a[2][0]) * a[0][1]) / ((a[0][0] - a[1][0]) * (a[0][0] - a[2][0])) + ((x - a[0][0]) * (x - a[2][0]) * a[1][1]) / ((a[1][0] - a[0][0]) * (a[1][0] - a[2][0])) + ((x - a[1][0]) * ((x - a[0][0]) * a[2][1]) / ((a[2][0] - a[0][0]) * (a[2][0] - a[1][0])));
                System.out.println("f(x) en ese punto es: " + y);
                break;
            case 4:
                y = ((x - a[1][0]) * (x - a[3][0]) * (x - a[2][0]) * a[0][1]) / ((a[0][0] - a[1][0]) * (a[0][0] - a[2][0]) * (a[0][0] - a[3][0])) + ((x - a[0][0]) * (x - a[2][0]) * (x - a[3][0]) * a[1][1]) / ((a[1][0] - a[0][0]) * (a[1][0] - a[2][0]) * (a[1][0] - a[3][0])) + ((x - a[0][0]) * (x - a[1][0]) * ((x - a[3][0]) * a[2][1]) / ((a[2][0] - a[0][0]) * (a[2][0] - a[1][0]) * (a[2][0] - a[3][0])) + ((x - a[0][0]) * (x - a[1][0]) * ((x - a[2][0]) * a[3][1]) / ((a[3][0] - a[0][0]) * (a[3][0] - a[1][0]) * (a[3][0] - a[2][0]))));
                System.out.println("f(x) en ese punto es: " + y);
                break;
            default:
                System.out.println("INVALIDO");
                break;
        }
    }

    //para leer desde teclado
    public double lee() {
        double num;
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            String sdato;
            sdato = br.readLine();
            num = Double.parseDouble(sdato);
        } catch (IOException ioe) {
            num = 0.0;
        }
        return num;
    }
    //para  leer un entero

    public int leeint() {
        int num;
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            String sdato;
            sdato = br.readLine();
            num = Integer.parseInt(sdato);
        } catch (IOException ioe) {
            num = 0;
        }
        return num;
    }

    //para salir del programa
    public int Fuera() {
        int sal;
        System.out.println("\n\n\nSI DESEAS OTRO METODO PRESIONA [1]");
        sal = leeint();
        return sal;
    }

    

}
