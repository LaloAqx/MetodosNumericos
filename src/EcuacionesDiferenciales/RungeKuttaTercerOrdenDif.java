/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EcuacionesDiferenciales;

import java.util.Random;

/**
 *
 * @author alcha
 */

public class RungeKuttaTercerOrdenDif{

	public static double redondear(double valor){
		double redondear = 0;
		redondear = Math.rint(valor * 100000000)/100000000;
		return redondear; 
	}

	public static double calcularY(double k1, double k2, double k3,double yn){
		double y = yn + (1.0/6.0)*(k1+(4*k2)+k3);
		return y;
	}

	public static void main(String[] args) {
		int i,
		funcion = (int)(Math.random()*1)+1;

		Random r = new Random();

		double max = 3.0,
		min = 1.0,
		yn = Math.rint((min + r.nextDouble() * (max - min))*10000)/10000,
		h = Math.rint((min + r.nextDouble() * (max - min))*10000)/10000,
		tn = 0.0,
		k1 = 0.0,
		k2 = 0.0,
		k3 = 0.0,
		y = 0.0;

		double resultados[] = new double[2];

		System.out.println("\n\t\tRunge - Kutta de 3er Orden\n");

		switch(funcion){
			case 1:
			System.out.println("Calcula y1 & y2 con los siguientes datos\n\ty'y"+(char)178+" - 2yt - 1 = 0\ty0 = "+yn+"\th = "+h+"\tt0 = "+tn+"\n");
			
			for(i=0;i<2;i++){
				k1 = h * (redondear((2*yn*tn)+1)/redondear(Math.pow(yn,2)));
				k1 = redondear(k1);
				System.out.println("k1 = " +k1);

				k2 = h * ((redondear((2*(yn + k1/2.0)*(tn + h/2.0))+1))/redondear(Math.pow((yn + k1/2.0),2)));
				k2 = redondear(k2);
				System.out.println("k2 = " +k2);

				k3 = h * (redondear((2*(yn-k1+2*k2)*(tn+h)+1)))/redondear(Math.pow(yn-k1+2*k2,2));
				k3 = redondear(k3);
				System.out.println("k3 = " +k3);

				y = calcularY(k1,k2,k3,yn);
				y = redondear(y);
				System.out.println("y"+(i+1)+" = "+y+"\n--------------------");

				resultados[i] = y;

				yn = y;
				tn = tn + h;
			}
			break;

			case 2:
			System.out.println("Calcula y1 & y2 con los siguientes datos\n\ty'[2y-te^(ty)]-[2+ye^(ty)] = 0\ty0 = "+yn+"\th = "+h+"\tt0 = "+tn+"\n");
			
			for(i=0;i<2;i++){
				k1 = h * ((2+(yn*redondear(Math.exp(tn*yn))))/((2*yn)-(tn*redondear(Math.exp(tn*yn)))));
				k1 = redondear(k1);
				System.out.println("k1 = " +k1);

				k2 = h * ((2+((yn+k1/2.0)*redondear(Math.exp((tn+h/2.0)*(yn+k1/2.0)))))/((2*(yn+k1/2.0))-((tn+h/2.0)*redondear(Math.exp((tn+h/2.0)*(yn+k1/2.0))))));
				k2 = redondear(k2);
				System.out.println("k2 = " +k2);

				k3 = h * ((2+((yn-k1+2*k2)*redondear(Math.exp((tn+h)*(yn-k1+2*k2)))))/((2*(yn-k1+2*k2))-((tn+h)*redondear(Math.exp((tn+h)*(yn-k1+2*k2))))));
				k3 = redondear(k3);
				System.out.println("k3 = " +k3);

				y = calcularY(k1,k2,k3,yn);
				y = redondear(y);
				System.out.println("y"+(i+1)+" = "+y+"\n--------------------");

				resultados[i] = y;

				yn = y;
				tn = tn + h;

			}

			break;

			case 3:
			System.out.println("Calcula y1 & y2 con los siguientes datos\n\ty' + y - t"+(char)178+" = 0\ty0 = "+yn+"\th = "+h+"\tt0 = "+tn+"\n");

			for (i=0;i<2;i++){
				k1 = h * (-yn+redondear(Math.pow(tn,2)));
				k1 = redondear(k1);
				System.out.println("k1 = " +k1);

				k2 = h * (-(yn+k1/2.0)+redondear(Math.pow((tn+h/2),2)));
				k2 = redondear(k2);
				System.out.println("k2 = " +k2);

				k3 = h * (-(yn-k1+2*k2)+redondear(Math.pow((tn+h),2)));
				k3 = redondear(k3);
				System.out.println("k3 = " +k3);

				y = calcularY(k1,k2,k3,yn);
				y = redondear(y);
				System.out.println("y"+(i+1)+" = "+y+"\n--------------------");

				resultados[i] = y;

				yn = y;
				tn = tn + h;
			}

			break;
			default:
		}
	}
}