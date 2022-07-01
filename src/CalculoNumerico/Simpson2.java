package CalculoNumerico;

/*Este programa calcula el valor aproximado de la integral definida de la funcion  f(x)=(e^x)*(x^2) en el intervalo
[0, 3], por el metodo de Simpson de 1/3. Los datos seran introducidos despues de la linea de comandos, en el
momento que el programa pida dichos datos*/


import java.lang.*;

public class Simpson2{
	double limInf = 0;
	double limSup = 3;
	int n;
	double h;
	double integralDef;
	/*Metodo principal main*/
	public static void main(String args[]){
		LeeUnDouble lud = new LeeUnDouble();//Objeto que nos permitira obtener el valor de un numero tecleado por el usuario
		Redondear r = new Redondear();//Objeto que guardara el valor redondeado del resultado, a 5 decimales
		Simpson2 s = new Simpson2(); //Objeto de la clase Simpson2
		//Obteniendo el valor de N
		System.out.println("Dame el valor de N: ");
		lud.leeNumero();
		s.n = (int)lud.num;//Cast
		if((s.n%2)==0){
			//Determinando el valor de H
			s.h = (s.limSup-s.limInf)/s.n;
			//Determinando el valor de la integral definida
			s.integralDef = (s.h/3)*(s.funcion(s.limInf)+(4*s.sumaImpares(s.limInf,s.h,s.n))+(2*s.sumaPares(s.limInf,s.h,s.n))+s.funcion(s.limSup));
			//Se imprime el resultado de la integral definida
			System.out.println("El resultado de la integral definida de la funcion, desde "+s.limInf+" hasta "+s.limSup+"\nes "+r.redondeo(s.integralDef,5));
		}
		else{
			System.out.println("El valor de N debe ser par");
		}
	}
	/*Metodo que permite calcular la suma de los terminos impares de los Yi's, los cuales posteriormente se
	multiplicaran por 4*/
	public double sumaImpares(double inf, double H, double N){
		double suma = 0;
		for(int i=1;i<=(N-1);i=i+2){
			suma = suma+funcion(inf+(H*i));
		}
		return suma;
	}
	/*Metodo que permite calcular la suma de los terminos pares de los Yi's, los cuales posteriormente se
	multiplicaran por 2*/
	public double sumaPares(double inf, double H, double N){
		double suma = 0;
		for(int i=2;i<=(N-2);i=i+2){
			suma = suma+funcion(inf+(H*i));
		}
		return suma;
	}
	/*Metodo que calcula el valor de la funcion descrita para una x dada*/
	public double funcion(double x){
		double fX = (Math.pow(Math.E,x))*(Math.pow(x,2));
		return fX;
	}
}