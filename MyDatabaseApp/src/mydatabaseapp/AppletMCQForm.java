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
public class AppletMCQForm extends javax.swing.JApplet {

    /**
     * Initializes the applet AppletMCQForm
     */
    @Override
    public void init() {
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
            java.util.logging.Logger.getLogger(AppletMCQForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AppletMCQForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AppletMCQForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AppletMCQForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the applet */
        try {
            java.awt.EventQueue.invokeAndWait(new Runnable() {
                public void run() {
                    initComponents();
                    optionHidden.setVisible(false);
        question.setEnabled(false);
        //labelUser.setText("Welcome : "+userName);
        //labelUser.setText(userName);
        labelUser.setText("Hello");
        MakeGroup();
        count=0;
        last=4;
        quesNo.setText("Q "+count+1+".");
        DataConnection mcq=new DataConnection();
        myConnection=mcq.GetConnection();
        try{
        selectStmt=myConnection.createStatement();
        //ExecuteQuery("select * from mcq");
        ExecuteQuery("ABCD");
        }catch(Exception e){}
                    }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
                    
    }

    public void ExecuteQuery(String query) throws SQLException{
    
       //selectStmt=myConnection.createStatement();
       // rsGlobal = selectStmt.executeQuery(query);
        NextQuestion();
    }
    
    
    public javax.swing.JRadioButton GetState(String query) throws SQLException{
        
        //selectStmt=myConnection.createStatement();
        ResultSet  rs = selectStmt.executeQuery(query);
        if(rs.next()){
            if(Integer.parseInt(rs.getString(1))==1)
                return option1;
            if(Integer.parseInt(rs.getString(1))==2)
                return option2;
            if(Integer.parseInt(rs.getString(1))==3)
                return option3;
            if(Integer.parseInt(rs.getString(1))==4)
                return option4;
            if(Integer.parseInt(rs.getString(1))==0)
                return optionHidden;
            
        }
        
        return null;
    }
    
    public void NextQuestion() throws SQLException{
        count++;
        String basicQuery="select ques,opt1,opt2,opt3,opt4 from mcq where quesId="+count;
        ResultSet  rsg = selectStmt.executeQuery(basicQuery);
        quesNo.setText("Q "+count+".");
        if(rsg.next() ){
            question.setText(rsg.getString(1));
            option1.setText(rsg.getString(2));
            option2.setText(rsg.getString(3));
            option3.setText(rsg.getString(4));
            option4.setText(rsg.getString(5));
            buttonGroup1.clearSelection();
            
            }
        
        
            String stateQuery="select "+labelUser.getText()+" from mcq where quesId="+count;
            System.out.println(stateQuery);
            GetState(stateQuery).setSelected(true);
            System.out.println("Next Executed");
        
        Check();
    }
    
    public void Check(){
    if(count>1 && count < last)
    {
        nextQuestion.setEnabled(true);
        prevQuestion.setEnabled(true);
    
    }
    
    if(count <= 1)
    {
        nextQuestion.setEnabled(true);
        prevQuestion.setEnabled(false);
    }
    
    if(count == last)
        {
        nextQuestion.setEnabled(false);
        prevQuestion.setEnabled(true);
    }
    
    
    }
    
    public void PreviousQuestion() throws SQLException{
        count--;
        String basicQuery="select ques,opt1,opt2,opt3,opt4 from mcq where quesId="+count;
        ResultSet  rsg = selectStmt.executeQuery(basicQuery);
        quesNo.setText("Q "+count+".");
        if(rsg.next()){
            question.setText(rsg.getString(1));
            option1.setText(rsg.getString(2));
            option2.setText(rsg.getString(3));
            option3.setText(rsg.getString(4));
            option4.setText(rsg.getString(5));
            buttonGroup1.clearSelection();
            
        }
        
        String stateQuery="select "+labelUser.getText()+" from mcq where quesId="+count;
        System.out.println(stateQuery);
        GetState(stateQuery).setSelected(true);
            
        Check();
    }
    
    void MakeGroup(){
    
    buttonGroup1.add(option1);
    buttonGroup1.add(option2);
    buttonGroup1.add(option3);
    buttonGroup1.add(option4);
    }
    
    /**
     * This method is called from within the init() method to initialize the
     * form. WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        quesNo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        question = new javax.swing.JTextArea();
        option1 = new javax.swing.JRadioButton();
        option2 = new javax.swing.JRadioButton();
        option3 = new javax.swing.JRadioButton();
        option4 = new javax.swing.JRadioButton();
        optionHidden = new javax.swing.JRadioButton();
        nextQuestion = new javax.swing.JButton();
        prevQuestion = new javax.swing.JButton();
        labelUser = new javax.swing.JLabel();

        quesNo.setText("Q");

        question.setColumns(20);
        question.setRows(5);
        jScrollPane1.setViewportView(question);

        option1.setText("option1");
        option1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                option1ActionPerformed(evt);
            }
        });

        option2.setText("option2");
        option2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                option2ActionPerformed(evt);
            }
        });

        option3.setText("option3");
        option3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                option3ActionPerformed(evt);
            }
        });

        option4.setText("option4");
        option4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                option4ActionPerformed(evt);
            }
        });

        optionHidden.setText("hidden");

        nextQuestion.setText("Next>>");

        prevQuestion.setText("<<Prev");

        labelUser.setText("User");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(quesNo)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(option2)
                    .addComponent(option1)
                    .addComponent(option3)
                    .addComponent(option4)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 642, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(prevQuestion)
                            .addComponent(optionHidden))
                        .addGap(511, 511, 511)
                        .addComponent(nextQuestion)))
                .addContainerGap(177, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelUser)
                .addGap(239, 239, 239))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(labelUser)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(quesNo)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(251, 251, 251)
                        .addComponent(nextQuestion))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(option1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(option2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(option3)
                        .addGap(18, 18, 18)
                        .addComponent(option4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(optionHidden)
                        .addGap(39, 39, 39)
                        .addComponent(prevQuestion)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void option1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_option1ActionPerformed
        // TODO add your handling code here:
        System.out.println("First option clicked");
        
        String query="update mcq set "+labelUser.getText()+"=1 where quesId="+count;
        System.out.println(query);
        
        try{
            //selectStmt=myConnection.createStatement();
            selectStmt.executeUpdate(query);
        }
        catch(Exception e){}
        try{
        CalculateMarks();
        }catch(Exception e){}
    }//GEN-LAST:event_option1ActionPerformed

    private void option2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_option2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_option2ActionPerformed

    private void option3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_option3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_option3ActionPerformed

    private void option4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_option4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_option4ActionPerformed

     public void CalculateMarks() throws SQLException{
        System.out.println("Entered Calculate Marks");
        String query="select correct,"+labelUser.getText()+",quesId from mcq";
        ResultSet  rs = selectStmt.executeQuery(query);
        String marksQuery="";
        int correct=0,userEntered=0;
        int quesId=0;
        if(rs.next())
        {
             correct=Integer.parseInt(rs.getString(1));
             userEntered=Integer.parseInt(rs.getString(2));
             quesId=Integer.parseInt(rs.getString(3));
            System.out.println("Correct: "+correct+"  :: userEntered : "+userEntered+"  quesId : "+quesId);
            
            
        }
       
        System.out.println("Ramannnnnnnnnnnnnnn");
        int chk=correct-userEntered;
        System.out.println(chk);
        
            if(chk==0)
            {
                System.out.println("Entered IF");
              marksQuery="update mcq set "+labelUser.getText()+"Marks=1 where quesId="+quesId;
              selectStmt.executeUpdate(marksQuery);
            }
        
        
    
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelUser;
    private javax.swing.JButton nextQuestion;
    private javax.swing.JRadioButton option1;
    private javax.swing.JRadioButton option2;
    private javax.swing.JRadioButton option3;
    private javax.swing.JRadioButton option4;
    private javax.swing.JRadioButton optionHidden;
    private javax.swing.JButton prevQuestion;
    private javax.swing.JLabel quesNo;
    private javax.swing.JTextArea question;
    // End of variables declaration//GEN-END:variables

    Connection myConnection;
    ResultSet rsGlobal;
    int count,last;
    Statement selectStmt;
}
