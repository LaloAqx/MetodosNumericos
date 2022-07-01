package CalculoNumerico;

/*Este programa calcula el valor aproximado de la integral definida de la funcion  f(x)=(e^x)*(x^2) en el intervalo
[0, 3], por el metodo de Simpson de 3/8. Los datos seran introducidos despues de la linea de comandos, en el
momento que el programa pida dichos datos*/


import java.lang.*;

public class Simpson3{
	double limInf = 0;
	double limSup = 3;
	int n;
	double h;
	double integralDef;
	/*Metodo principal main*/
	public static void main(String args[]){
		LeeUnDouble lud = new LeeUnDouble();//Objeto que nos permitira obtener el valor de un numero tecleado por el usuario
		Redondear r = new Redondear();//Objeto que guardara el valor redondeado del resultado, a 5 decimales
		Simpson3 s = new Simpson3(); //Objeto de la clase Simpson3
		//Obteniendo el valor de N
		System.out.println("Dame el valor de N: ");
		lud.leeNumero();
		s.n = (int)lud.num;//Cast
		if((s.n%3)==0){
			//Determinando el valor de H
			s.h = (s.limSup-s.limInf)/s.n;
			//Determinando el valor de la integral definida
			s.integralDef = ((3*s.h)/8)*(s.funcion(s.limInf)+(2*s.sumaMult3(s.limInf,s.h,s.n))+(3*s.sumaNoMult3(s.limInf,s.h,s.n))+s.funcion(s.limSup));
			//Se imprime el resultado de la integral definida
			System.out.println("El resultado de la integral definida de la funcion, desde "+s.limInf+" hasta "+s.limSup+"\nes "+r.redondeo(s.integralDef,5));
		}
		else{
			System.out.println("El valor de N debe ser un multiplo de 3");
		}
	}
	/*Metodo que permite calcular la suma de los Yi's que son multiplos de 3, los cuales posteriormente se
	multiplicaran por 2*/
	public double sumaMult3(double inf, double H, double N){
		double suma = 0;
		for(int i=3;i<=(N-1);i=i+3){
			suma = suma+funcion(inf+(H*i));
		}
		return suma;
	}
	/*Metodo que permite calcular la suma de los Yi's que no son multiplos de 3, los cuales posteriormente se
	multiplicaran por 3*/
	public double sumaNoMult3(double inf, double H, double N){
		double suma = 0;
		for(int i=1;i<=(N-1);i++){
			if((i%3)!=0){//Si "i" no es multiplo de 3 (o bien si el residuo de dividir "i" entre 3 no es 0)
				suma = suma+funcion(inf+(H*i));
			}
			else{
				continue;
			}
		}
		return suma;
	}
	/*Metodo que calcula el valor de la funcion descrita para una x dada*/
	public double funcion(double x){
		double fX = (Math.pow(Math.E,x))*(Math.pow(x,2));
		return fX;
	}
}