package CalculoNumerico;

/*Programa que calcula por el metodo de diferencias divididas centrales, la primera y segunda derivada
de la funcion f(x)=(e^x)/((x^2)-3). Para ello se necesita un valor de x inicial (valor en el cual se 
quiere conocer f'(x) y f''(x)) y tambien un incremento de x (delta x)*/

import java.lang.*;

public class Derivacion2{
	//Atributos de la clase
	double x;
	double deltaX;
	double centradas;
	/*Metodo principal*/
	public static void main (String args[]){
		try{
			Redondear r = new Redondear();//Objeto que alberga un valor dado de tipo double, redondeado a 2 decimales
			Derivacion2 primD = new Derivacion2();//Objeto de la clase Derivacion2 que albergara la primera derivada
			Derivacion2 segD = new Derivacion2();//Objeto de la clase Derivacion2 que albergara la segunda derivada
                        
                        System.out.println("Dame el valor del limite inferior: ");
                        primD.x = Double.parseDouble(args[0]);
			primD.deltaX = Double.parseDouble(args[1]);
			primD.centradas = (primD.funcion(r.redondeo(primD.x+primD.deltaX,2))-primD.funcion(r.redondeo(primD.x-primD.deltaX,2)))/(2*primD.deltaX);
			
                        System.out.println("Dame el valor del limite superior: ");
			segD.centradas = (primD.funcion(r.redondeo(primD.x+primD.deltaX,2))-2*(primD.funcion(primD.x))+primD.funcion(r.redondeo(primD.x-primD.deltaX,2)))/(primD.deltaX*primD.deltaX);
			//Impresion de los resultados obtenidos
			System.out.println("El valor aproximado de f'(x) valuada en x="+primD.x+" por diferencia centrada \nes "+r.redondeo(primD.centradas,6)+"\n");
			System.out.println("El valor aproximado de f''(x) valuada en x="+primD.x+" por diferencia centrada \nes "+r.redondeo(segD.centradas,6));
		}
		catch(ArrayIndexOutOfBoundsException aioobe){
			System.out.println("ERROR!!! Faltan introducir parametros para el calculo de la derivada\n");
			System.out.println("La sintaxis es: java Derivacion valorinicialX incrementoX");
                        
		}
	}
	/*Metodo que calcula el valor de la funcion (f(x)) dado un cierto valor de x*/
	public double funcion (double x){
		double f;
		f=Math.pow(Math.E,x)/((x*x)-3);
		return f;
	}
}