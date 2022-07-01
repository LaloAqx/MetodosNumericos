/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EcuacionesDiferenciales;

import java.io.*;

/**
 *
 * @author alcha
 */
public class EulerIzquierdo {

    float func(float x, float y) {
        return (x + y + x * y);
    }

    void euler(float x0, float y, float h, float x) {
        float temp = -0;

        while (x0 < x) {
            temp = y;
            y = y + h * func(x0, y);
            x0 = x0 + h;
        }

        System.out.println("Solución aproximada en x = " + x + " es " + y);
    }

    // Programa de conductor.
    public static void main(String args[]) throws IOException {
        EulerIzquierdo obj = new EulerIzquierdo();
        float x0 = 0;
        float y0 = 1;
        float h = 0.025f;

        float x = 0.1f;

        obj.euler(x0, y0, h, x);
    }
}
