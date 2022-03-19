package client;




/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.intellijthemes.FlatArcIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.*;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.*;
import javax.swing.text.DefaultCaret;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

import static java.awt.Color.*;

/**
 *
 * @author music
 */
public class ChatUI extends javax.swing.JFrame {

    /**
     * Creates new form ChatUI
     */
    public ChatUI() {

        this.setLayout(new BorderLayout());
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
        this.setTitle("SECRET ROOM");



    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();


        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        jTextArea1.setEnabled(false);
        if(mode == 1) {
            jTextArea1.setDisabledTextColor(black);

        } else{

            jTextArea1.setDisabledTextColor(white);

        }


        jButton1.setText("Send");
        jButton1.setToolTipText("");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    jButton1ActionPerformed(evt);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        this.addWindowFocusListener(new WindowAdapter() {

            //To check window gained focus
            public void windowGainedFocus(WindowEvent e) {
                //set flag
                isWindowActive = true;
            }

            //To check window lost focus
            public void windowLostFocus(WindowEvent e) {
                //set flag
                isWindowActive = false;
            }
        });


        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                try {
                    jTextField1KeyPressed(evt);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });


        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Bookman Old Style", 1, 16)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) throws IOException {//GEN-FIRST:event_jButton1ActionPerformed

        String msg = jTextField1.getText();
        if(!Objects.equals(msg, "")) {
            jTextField1.setText("");
            ChatUI.jTextArea1.append(Client.username +" :"+ msg + "\n");
            Client.sendMessage(msg);
        }



    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) throws IOException {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String msg = jTextField1.getText();
            if(!Objects.equals(msg, "")) {
                jTextField1.setText("");
                ChatUI.jTextArea1.append(Client.username +" :" + msg + "\n");
                Client.sendMessage(msg);
            }
        }
        }





    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws Exception {
           
       

        UIManager.setLookAndFeel(new FlatArcDarkContrastIJTheme());

        String[] options = {"DARK MODE", "LIGHT MODE"};

        mode = JOptionPane.showOptionDialog(null, "Please Select Your Favorite Mode:",
                "Mode",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options,-1);
        if(mode == -1){

            System.exit(0);
        }

        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                if(mode == 0){


                    try {
                        UIManager.setLookAndFeel(new FlatNightOwlContrastIJTheme());
                    } catch (Exception e){
                        e.printStackTrace();

                    }

                } else {


                    try {
                        UIManager.setLookAndFeel(new FlatLightOwlIJTheme());
                    } catch (Exception e) {
                        e.printStackTrace();

                    }
                }


                chat =
                new ChatUI();
                chat.setVisible(true);
            }
        });
        if(mode == 0){


            try {
                UIManager.setLookAndFeel(new FlatNightOwlContrastIJTheme());
            } catch (Exception e){
                e.printStackTrace();

            }

        } else {


            try {
                UIManager.setLookAndFeel(new FlatLightOwlIJTheme());
            } catch (Exception e) {
                e.printStackTrace();

            }
        }
   


        String name =  (String) JOptionPane.showInputDialog(null, "Please Enter Your Name: ", "CHAT", JOptionPane.INFORMATION_MESSAGE, null, null, "");
        if(name == null){

            System.exit(0);
        }
        Client.username = name;
         Client.host = (String) JOptionPane.showInputDialog(null, "Please Enter The IP Address Of Your Friend: ", "CHAT", JOptionPane.INFORMATION_MESSAGE, null, null, "");
        if(Client.host == null){

            System.exit(0);
        }




       Client.listenForMessage();

    }




    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static Integer mode = 0;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTextArea jTextArea1;
    public static javax.swing.JTextField jTextField1;
    public static boolean isWindowActive;
    public static ChatUI chat;

    // End of variables declaration//GEN-END:variables
}
