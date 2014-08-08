/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mydatabaseapp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author raman
 */
public class CreateUser extends javax.swing.JFrame {

    /**
     * Creates new form CreateUser
     * 
     */
    
    Connection myConnection;
    ResultSet rs;
    
    public CreateUser() {
        initComponents();
        DataConnection crteUser=new DataConnection();
        this.myConnection=crteUser.GetConnection();
        
    }

    public void MakeUser() throws SQLException{
    
        Statement selectStmt=myConnection.createStatement();
        String query="insert into user values ('"+ textUName.getText()+"','"+textPassWd.getText()+"',0)";
        System.out.println(query);
        //rs = selectStmt.executeQuery(query);
        if(selectStmt.executeUpdate(query)!=0)
        {
        System.out.println("User created Successfully");
        }
        
    }
    
    public void DoUserAccounting() throws SQLException{
    
        Statement selectStmt=myConnection.createStatement();
        String userMarks=textUName.getText()+"Marks";
        String query="alter table mcqBackup add column ("+ textUName.getText()+" int,"+userMarks+" int)";
        System.out.println(query);
        //rs = selectStmt.executeQuery(query);
        String initializeQuery="update mcqBackup set "+textUName.getText()+"=0";
        if(selectStmt.executeUpdate(query)!=0)
        {
        System.out.println("User entered in mcqBackup Successfully");
        }
        
        
        if(selectStmt.executeUpdate(initializeQuery)!=0)
        {
        System.out.println("User initialized Successfully");
        }
        
        initializeQuery="update mcqBackup set "+userMarks+"=10";
        if(selectStmt.executeUpdate(initializeQuery)!=0)
        {
        System.out.println("User initialized Successfully");
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        uName = new javax.swing.JLabel();
        passWd = new javax.swing.JLabel();
        textUName = new javax.swing.JTextField();
        submit = new javax.swing.JButton();
        textPassWd = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        labelUserCreation = new javax.swing.JLabel();
        labelNewUser = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        uName.setText("UserName");

        passWd.setText("Password");

        submit.setText("Submit");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });

        textPassWd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textPassWdActionPerformed(evt);
            }
        });

        labelNewUser.setText("Create New User");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(uName)
                            .addComponent(passWd))
                        .addGap(61, 61, 61)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(submit)
                                .addComponent(textPassWd, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                                .addComponent(textUName))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addComponent(labelNewUser)))
                .addContainerGap(207, Short.MAX_VALUE))
            .addComponent(labelUserCreation, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelNewUser)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(uName)
                    .addComponent(textUName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passWd)
                    .addComponent(textPassWd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(submit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelUserCreation, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textPassWdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textPassWdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textPassWdActionPerformed

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        // TODO add your handling code here:
        try{
        MakeUser();
        DoUserAccounting();
        //this.setVisible(false);
        labelUserCreation.setText("User Successfully created. Please close the Window");
        textUName.setText("");
        textPassWd.setText("");
        }
        catch(Exception e){}
    }//GEN-LAST:event_submitActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CreateUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel labelNewUser;
    private javax.swing.JLabel labelUserCreation;
    private javax.swing.JLabel passWd;
    private javax.swing.JButton submit;
    private javax.swing.JPasswordField textPassWd;
    private javax.swing.JTextField textUName;
    private javax.swing.JLabel uName;
    // End of variables declaration//GEN-END:variables
}
