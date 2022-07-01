package NoLineales_Interpolacion;

/**
 *
 * @author laloa
 */
public class NewtonRaphson {

    double x0, tol; // la variable x0 será el valor inicial, tol será la tolerancia del error
    int noite; //noite es el número de iteraciones a realizar

    //Se crea el método Resuelve donde tiene como parámetros el valor inicial(x1), la tolerancia y el número de iteraciones
    //Se utiliza para obtener los valores que se usarán como iniciales
    public void Resuelve(double x1, double tolerancia, int iteraciones) {
        x0 = x1;
        tol = tolerancia;
        noite = iteraciones;
    }
    //El método funcion servirá para valuar a la función original

    public double funcion(double x) {
        //Esta es la función a evaluar f(x)=-x^2+1.8x.2.5 donde y es el valor del resultado de evaluar la función
        double y = ((-x * x) + 1.8 * x + 2.5);
        return y;//Se retorna el valor de evaluar en la función
    }
    //El método función servirá para evaluar en la derivada el valor de x

    public double derivada(double x) {
        double z = (-2 * x + 1.8);
        return z; //Se retorna el resultado al evaluar
    }
    //El método calculaRaiz es donde se va obteniendo el valor de la raíz en cada iteración

    public void calculaRaiz() {
        double x = x0;
        double anterior = 0; //Se iguala a 0 porque al realizar el primer error se utiliza 0 como primer valor anterior
        int n = 0; //n es el número de iteraciones y se inicializa en 0
        while (((Math.abs(x - anterior)) / x) * 100 > tol) { //Se realiza la condición de porcentaje de error y mientras el porcentaje sea mayor a la tolerancia se realiza lo siguiente
            n = n + 1; //Cada vez se va incrementando el número de iteraciones
            anterior = x; //el valor anterior se va renovando por el último valor x utilizado en el proceso
            if (n > noite) //Si el número de iteraciones es mayor del que se puso en el parámetro se termina el proceso
            {
                break;
            }
            double y = funcion(x); //Se evalúa el valor de x en la función
            double fdx = derivada(x); //Se evalúa en la derivada el valor de x
            x = anterior - (y / fdx); //Se realiza la ecuación para obtener la raíz

        }
        System.out.println("La raiz es = " + x); //Se imprime el valor de la raíz
        System.out.println("El resultado fue en: " + n + " iteraciones."); //Se imprime el número de iteraciones en el que se logró
        System.out.println("Porcentaje de error = " + tol + "%"); //Se muestra el porcentaje de error deseado

    }
}
