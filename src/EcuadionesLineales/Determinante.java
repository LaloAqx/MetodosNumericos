/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package EcuadionesLineales;

/**
 *
 * @author Gaby
 */
public class Determinante {
static void obtenerCofactor(double matriz[][], double temp[][], int p, int q, int n){
    int i = 0, j = 0;
    for(int fila = 0; fila < n; fila++){
        for(int columna = 0; columna < n; columna++){
            if(fila != p && columna != q){
                temp[i][j++] = matriz [fila][columna];
                if(j == n-1){
                    j = 0;
                    i++;
                }
            }
        }
    }
}
static double determinanteMatriz(double matriz[][], int n){
    int determinante = 0;
    if (n ==1){
        return matriz[0][0]; 
    }
    double temp [][] = new double [n][n]; 
    int multiplicar = 1;
    for(int f = 0; f < n; f++){
        obtenerCofactor(matriz, temp, 0, f, n); 
        determinante += multiplicar*matriz[0][f]*determinanteMatriz(temp,n-1);
        multiplicar = -multiplicar;
    }
    return determinante;
}
    
    
}
