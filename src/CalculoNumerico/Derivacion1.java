package CalculoNumerico;

/*Programa que calcula de manera aproximada, por el metodo de diferencias divididas (obtenido del polinomio de 
Taylor) centrales, la segunda derivada de la funcion f(x)=-0.1(x^4)-0.15(x^3)-0.5(x^2)-0.25x +1.2 en el punto x=0.5.
Ademas, obtiene los errores absoluto y relativo con respecto al valor real de f''(0.5)). El programa debe recibir el
valor del incremento de x (delta x) proporcionado por el usuario. Se utilizan diferencias divididas centrales porque
con estas, el resultado es mas aproximado al real*/

import java.lang.*;

public class Derivacion1{
	//Atributos de la clase
	double x = 0.5;
	double deltaX;
	double centradas;
	double errAbs;
	double errRel;
	/*Metodo principal*/
	public static void main (String args[]){
		try{
			Redondear r = new Redondear();//Objeto que alberga un valor dado de tipo double, redondeado a 2 decimales
			Derivacion1 d1 = new Derivacion1();//Objeto de la clase Derivacion1
			d1.deltaX = Double.parseDouble(args[0]);
			//Calculo de la 1� derivada por la diferencia dividida central
			d1.centradas = (d1.funcion(r.redondeo(d1.x+d1.deltaX,2))-2*(d1.funcion(0.5))+d1.funcion(r.redondeo(d1.x-d1.deltaX,2)))/(d1.deltaX*d1.deltaX);
			//Calculo de los errores absoluto y relativo con respecto al valor real de f''(0.5) el cual es -1.75
			d1.errAbs = Math.abs(-1.75-d1.centradas);
			d1.errRel = (d1.errAbs/1.75)*100;
			//Impresion de los resultados obtenidos
			System.out.println("El valor aproximado de f''(x) valuada en x=0.5 por diferencia centrada es\n"+r.redondeo(d1.centradas,6)+" con un error absoluto de "+r.redondeo(d1.errAbs,6)+" y uno relativo de "+r.redondeo(d1.errRel,6)+"%");
		}
		catch(ArrayIndexOutOfBoundsException aioobe){
			System.out.println("ERROR!!! Faltan introducir parametros para el calculo de la derivada\n");
			System.out.println("La sintaxis es: java Derivacion incrementoX");
		}
	}
	/*Metodo que calcula el valor de la funcion (f(x)) dado un cierto valor de x*/
	public double funcion (double x){
		double f;
		f=-0.1*Math.pow(x,4)-0.15*Math.pow(x,3)-0.5*Math.pow(x,2)-0.25*x+1.2;
		return f;
	}
}