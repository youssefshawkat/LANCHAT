/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.awt.BorderLayout;
import static java.awt.Color.darkGray;
import javax.swing.JFrame;

/**
 *
 * @author music
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here\
        JFrame frame = new JFrame("iRide");
        frame.getContentPane().setBackground(darkGray);
        frame.setLayout(new BorderLayout());
        Register client = new Register();
        frame.add(client);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
