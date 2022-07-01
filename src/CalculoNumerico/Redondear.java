/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CalculoNumerico;

/**
 *
 * @author PC Budgie
 */

import java.math.*;
import java.math.BigDecimal;

/**
 *
 * @author PC Budgie
 */
public class Redondear {

    public double redondeo(double resultado, int redondeo) {
        BigDecimal bd = new BigDecimal(Double.toString(resultado)).setScale(redondeo, BigDecimal.ROUND_HALF_UP) ;
return bd.doubleValue();
    }
}
