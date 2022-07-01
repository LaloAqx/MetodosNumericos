/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CalculoNumerico;

/**
 *
 * @author PC Budgie
 */
import java.io.*;

public class LeeUnDouble{
    double num;
    public void leeNumero(){
        try{
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            String sdato;
            sdato = br.readLine();
            num = Double.parseDouble(sdato);
        }
        catch(IOException ioe){
        }
    }
}
