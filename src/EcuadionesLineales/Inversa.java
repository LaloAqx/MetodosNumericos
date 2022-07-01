package EcuadionesLineales;

import javax.swing.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.util.StringTokenizer;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.util.StringTokenizer;
import java.awt.event.*;

public class Inversa extends JFrame implements ActionListener {

    private int X = 3, Y = 3;
    private JTextField[][] textfield1 = new JTextField[100][100];
    private JTextField TamanyoX;
    private JLabel intro, total, lm, Matrizinversa;
    private JLabel[][] MI = new JLabel[100][100];
    private JButton boton4;
    private JPanel contentPane;
    private JComboBox dimension, combo1;

    public Inversa() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 300);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setBounds(0, 0, 400, 300);

        lm = new JLabel("CALCULO DE LA INVERSA");

        lm.setFont(new Font("Serif", Font.PLAIN, 30));
        lm.setForeground(Color.RED);
        lm.setBounds(140, 10, 500, 70);
        add(lm);

        total = new JLabel("");
        total.setBounds(100, 240, 60, 30);
        add(total);

        boton4 = new JButton("M. Inversa");
        boton4.setBounds(500, 240, 125, 30);
        add(boton4);

        boton4.addActionListener(this);

        for (int i = 0; i < 100; i++) {

            MI[i][i] = new JLabel();
            MI[i][i].setText("");
            MI[i][i].setBounds(i, i, 60, 30);
            add(MI[i][i]);
            MI[i][i].setVisible(false);

            Matrizinversa = new JLabel();
            Matrizinversa.setBounds(i, i, i, i);
            Matrizinversa.setVisible(false);

        }

        //colocando textfield
        int x = 0, y = 0, A, B = 40;
        for (x = 0; x < 3; x++) {
            System.out.println("for x");
            A = 80;
            for (y = 0; y < 3; y++) {
                System.out.println("for y");
                System.out.println("1");
                textfield1[x][y] = new JTextField("");
                System.out.println("2");
                textfield1[x][y].setBounds(B, A, 30, 20);
                System.out.println("3");
                add(textfield1[x][y]);
                A = A + 40;

            }
            B = B + 40;
        }

    }

    public void actionPerformed(ActionEvent e) {

        //Matriz inversa 3x3
        if (e.getSource() == boton4) {//

            for (int gh = 0; gh <= 100; gh++) {
                for (int gh2 = 0; gh2 <= 100; gh2++) {
                    try {
                        MI[gh][gh2].setVisible(false);
                        Matrizinversa.setVisible(false);
                    } catch (Exception ee) {
                    }
                }
            }
            /*
                                     !a00 a10 a20! l2a00 l2a10
                                     !a01 a11 a21! l2a01 l2a11
                                     !a02 a12 a22! l2a02 l2a12
             */
            double Total = 0;
            double a00 = Double.parseDouble(textfield1[0][0].getText());
            double a01 = Double.parseDouble(textfield1[0][1].getText());
            double a02 = Double.parseDouble(textfield1[0][2].getText());
            double a10 = Double.parseDouble(textfield1[1][0].getText());
            double a11 = Double.parseDouble(textfield1[1][1].getText());
            double a12 = Double.parseDouble(textfield1[1][2].getText());
            double a20 = Double.parseDouble(textfield1[2][0].getText());
            double a21 = Double.parseDouble(textfield1[2][1].getText());
            double a22 = Double.parseDouble(textfield1[2][2].getText());

            double l2a00 = Double.parseDouble(textfield1[0][0].getText());
            double l2a10 = Double.parseDouble(textfield1[1][0].getText());
            double l2a02 = Double.parseDouble(textfield1[0][2].getText());
            double l2a01 = Double.parseDouble(textfield1[0][1].getText());
            double l2a12 = Double.parseDouble(textfield1[1][2].getText());
            double l2a21 = Double.parseDouble(textfield1[2][1].getText());

            Total = a00 * a11 * a22 + a10 * a21 * l2a02 + a20 * l2a01 * l2a12;

            Total = Total + (a02 * a11 * a20) * -1 + (a12 * a21 * l2a00) * -1 + (a22 * l2a01 * l2a10) * -1;

            double[][] c = new double[X][X];
            //,c01,c02,c10,c11,c12,c20,c21,c22;

            if (Total != 0) {
                c[0][0] = a11 * a22 - a21 * a12;
                c[1][0] = (a10 * a22 - a20 * a12) * -1;
                c[2][0] = a10 * a21 - a20 * a11;
                c[0][1] = (a01 * a22 - a21 * a02) * -1;
                c[1][1] = a00 * a22 - a20 * a02;
                c[2][1] = (a00 * a21 - a20 * a01) * -1;
                c[0][2] = a01 * a12 - a11 * a02;
                c[1][2] = (a00 * a12 - a10 * a02) * -1;
                c[2][2] = a00 * a11 - a10 * a01;
                int lx = 160, ly = 180;
                //String a = TamanyoX.getText();

                X = 3;//Integer.parseInt(a);

                for (int i = 0; i < 3; i++) {
                    ly = 180;
                    for (int i2 = 0; i2 < 3; i2++) {
                        MI[i][i2] = new JLabel();
                        MI[i][i2].setBounds(i, i2, 100, 30);
                        MI[i][i2].setVisible(false);
                        add(MI[i][i2]);

                        Matrizinversa = new JLabel("lol");
                        Matrizinversa.setText("Resultado:");
                        Matrizinversa.setBounds(220, 120, 70, 30);
                        Matrizinversa.setVisible(false);
                        add(Matrizinversa);
                    }
                }

                for (int i = 0; i < 3; i++) {
                    ly = 180;
                    for (int i2 = 0; i2 < 3; i2++) {

                        Matrizinversa.setText("Resultado:");
                        Matrizinversa.setBounds(220, 150, 70, 30);
                        Matrizinversa.setVisible(true);
                        add(Matrizinversa);

                        MI[i][i2].setText(String.valueOf(c[i][i2] / Total));//+"/"+String.valueOf(Total));
                        MI[i][i2].setBounds(lx, ly, 100, 30);
                        MI[i][i2].setVisible(true);
                        add(MI[i][i2]);
                        ly = ly + 100;
                        MI[i][i2].setVisible(true);
                    }
                    lx = lx + 120;

                }

            } else {
                total.setText("Error det. da 0");
                add(total);

            }

        }

    }

    public static void main(String[] ar) {
        Inversa formulario = new Inversa();
        formulario.setBounds(0, 0, 650, 500);
        formulario.setVisible(true);
    }
}
