/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EcuacionesDiferenciales;

/**
 *
 * @author alcha
 */
public class EulerDerecho {

    public static void main(String[] args) {
        print(euler(1, 2, 2));
        print(euler(1, 2, 1));
        print(euler(1, 2, 0.1));
        print(euler(1, 2, 0.01));
        print(euler(1, 2, 0.001));
        print(euler(1, 2, 0.0001));
        print(euler(1, 2, 0.00001));
    }

    private static void print(double y) {
        System.out.println(String.format("y: %s", y));
    }

    private static double euler(double y, double t, double h) {
        for (double ti = 0; ti < t; ti += h) {
            double yAbl = yAbl(y, ti);
            y += h * yAbl;
        }
        return y;
    }

    private static double yAbl(double y, double t) {
        return Math.sqrt(y + t);
    }
}
