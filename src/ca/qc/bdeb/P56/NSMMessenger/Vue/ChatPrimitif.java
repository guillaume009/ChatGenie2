/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ca.qc.bdeb.P56.NSMMessenger.Vue;

import ca.qc.bdeb.P56.NSMMessenger.Controleur.NSMMessenger.Observation;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author Marc-Antoine
 */
public class ChatPrimitif extends javax.swing.JFrame{

    
    ChatGUI gui;
    /**
     * Creates new form ChatPrimitif
     */
    public ChatPrimitif(ChatGUI gui) {
        this.gui = gui;
        initComponents();
        ajouterEventTxtBox();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtChat = new javax.swing.JTextField();
        btnEnvoyer = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        lblChat = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnEnvoyer.setText("Envoyer");
        btnEnvoyer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEnvoyerMouseClicked(evt);
            }
        });

        lblChat.setEditable(false);
        lblChat.setColumns(20);
        lblChat.setRows(5);
        jScrollPane2.setViewportView(lblChat);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(117, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane2)
                    .addComponent(txtChat, javax.swing.GroupLayout.DEFAULT_SIZE, 616, Short.MAX_VALUE)
                    .addComponent(btnEnvoyer, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(176, 176, 176))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(txtChat, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEnvoyer, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    
    private void btnEnvoyerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEnvoyerMouseClicked
        gui.aviserObservateurs(Observation.ENVOIMESSAGE, txtChat.getText());
        txtChat.setText("");
    }//GEN-LAST:event_btnEnvoyerMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnvoyer;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea lblChat;
    private javax.swing.JTextField txtChat;
    // End of variables declaration//GEN-END:variables

    
    //todo: ameliorer l'affichage de messages
    public void ajouterMessage(String s)
    {
        lblChat.setText(lblChat.getText() + "\n" + s);
    }
    public void ajouterEventTxtBox(){
        txtChat.addKeyListener(new KeyAdapter() 
    {
        public void keyPressed(KeyEvent evt)
        {
            if(evt.getKeyCode() == KeyEvent.VK_ENTER)
            {
                gui.aviserObservateurs(Observation.ENVOIMESSAGE, txtChat.getText());
                txtChat.setText("");
            }
        }
    });
    }

}
