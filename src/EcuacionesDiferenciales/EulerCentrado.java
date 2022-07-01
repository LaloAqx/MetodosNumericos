/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EcuacionesDiferenciales;

import java.text.DecimalFormat;

/**
 *
 * @author alcha
 */
public class EulerCentrado {
    public static void main(String[] Leonhard)
    {

        DecimalFormat df = new DecimalFormat("#.0000");
        
        double k = 0;
        double h = (1.0/3.0);
        double t_0 = 0;
        double x_0 = .3;
        double x_f = 10;
        double[] t_k;
        t_k = new double[ (int)( ( x_f - x_0 ) / h ) + 1 ] ;
        double[] x_k;
        x_k = new double[ (int)( ( x_f - x_0 ) / h ) + 1 ] ;

        int i;

        System.out.println( "k\t       t_k\t       x_k" );
        

        for ( i = 0; k < (int)( ( x_f - x_0 ) / h ) + 1; i++ )
        {
            if ( i == 0 )
            {
                t_k[i] = t_0;
                x_k[i] = x_0;
            }
            else if ( i > 0 )
            {
                t_k[i] += i*h;
                x_k[i] = x_k[i-1] + h*( Math.exp(t_k[i-1]))*(Math.sin(x_k[i-1])   );

            }

            System.out.println( k + "      " + df.format(t_k[i])   + "      " +  df.format( x_k[i])  );
        }
    }
}
