/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EcuacionesDiferenciales;

/**
 *
 * @author PC Budgie
 */

public class Euler {
    private double x0, y0, x1, y1, h, actual;

    public Euler (double initialx, double initialy,double stepsize,double finalx1) {  
        x0 = initialx; y0 = initialy; h=stepsize; x1 = finalx1;
    }

    public void setEuler (double initialx, double initialy,double stepsize, 
    double finalx1){
        x0 = initialx;y0 = initialy;h   =stepsize;x1 = finalx1;
    }

    public double getinitialx(){
        return x0;
    }

    public double getinitialy(){
        return y0;
    }

    public double getinitialexact(){
        return (double) (0.9048*Math.exp(0.1*x0*x0));
    }

    double func(double x, double y){
        return (double) (0.2*x*y);
    }

    double funct(double x){
        return (double) (java.lang.Math.exp(0.1*x*x));
    }

    public double getinitialerror(){
        return (double) Math.abs(actual - y0);
    }

    public double getEulerResult(){
        for (double i = x0 + h; i < x1; i += h){
            y0 = y0 + h *(func(x0,y0));
            x0 += h;
            double actual = (0.9048*funct(x0));
            double error = Math.abs(actual - y0);
            System.out.printf("%f\t%f\t%f\t%f\n",x0,y0,actual, error);
        }
        return y0;
    }

}