/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mydatabaseapp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JRadioButton;
import javax.swing.Timer;

/**
 *
 * @author raman
 */
public class MCQForm extends javax.swing.JFrame {

    int sec;
    
    /**
     * Creates new form MCQForm
     */
    Connection myConnection;
    ResultSet rsGlobal;
    int count,last;
    Statement selectStmt;
    
    
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
        String basicQuery="select ques,opt1,opt2,opt3,opt4 from mcqBackup where quesId="+count;
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
        
        
            String stateQuery="select "+labelUser.getText()+" from mcqBackup where quesId="+count;
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
        buttonLock.setEnabled(false);
    
    }
    
    if(count <= 1)
    {
        nextQuestion.setEnabled(true);
        prevQuestion.setEnabled(false);
        buttonLock.setEnabled(false);
    }
    
    if(count == last)
        {
        nextQuestion.setEnabled(false);
        prevQuestion.setEnabled(true);
        buttonLock.setEnabled(true);
    }
    
    
    }
    
    public void PreviousQuestion() throws SQLException{
        count--;
        String basicQuery="select ques,opt1,opt2,opt3,opt4 from mcqBackup where quesId="+count;
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
        
        String stateQuery="select "+labelUser.getText()+" from mcqBackup where quesId="+count;
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
    
    public MCQForm() throws SQLException {
        initComponents();
        question.setEditable(false);
        MakeGroup();
        count=0;
        last=61;
        quesNo.setText("Q "+count+1+".");
        DataConnection mcqBackup=new DataConnection();
        this.myConnection=mcqBackup.GetConnection();
        //option3.setSelected(true);
        //String query="select ques,opt1,opt2,opt3,opt4,"+labelUser+ " from mcqBackup";
        String query="select * from mcqBackup";
        ExecuteQuery("adsadf");
        //ExecuteQuery("select * from mcqBackup");
    }
    
    public MCQForm(String userName) throws SQLException {
        initComponents();
        optionHidden.setVisible(false);
        question.setEditable(false);
        buttonLock.setEnabled(false);
        //labelUser.setText("Welcome : "+userName);
        labelUser.setText(userName);
        MakeGroup();
        count=0;
        last=61;
        quesNo.setText("Q "+count+1+".");
        DataConnection mcqBackup=new DataConnection();
        this.myConnection=mcqBackup.GetConnection();
        this.selectStmt=myConnection.createStatement();
        //ExecuteQuery("select * from mcqBackup");
        ExecuteQuery("ABCD");
        sec=5400;
        MyTimer();
        this.setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        question = new javax.swing.JTextArea();
        quesNo = new javax.swing.JLabel();
        option1 = new javax.swing.JRadioButton();
        option2 = new javax.swing.JRadioButton();
        option3 = new javax.swing.JRadioButton();
        option4 = new javax.swing.JRadioButton();
        nextQuestion = new javax.swing.JButton();
        prevQuestion = new javax.swing.JButton();
        labelUser = new javax.swing.JLabel();
        optionHidden = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        buttonLock = new javax.swing.JButton();
        buttonLast = new javax.swing.JButton();
        buttonFirst = new javax.swing.JButton();
        labelTimer = new javax.swing.JLabel();
        labelTimeRemaining = new javax.swing.JLabel();
        labelWelcome = new javax.swing.JLabel();
        labelJumpToQuesNo = new javax.swing.JLabel();
        textJumpToQuesNo = new javax.swing.JTextField();
        buttonGo = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        question.setColumns(20);
        question.setRows(5);
        jScrollPane1.setViewportView(question);

        quesNo.setText("Q");

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

        nextQuestion.setText("Next >>");
        nextQuestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextQuestionActionPerformed(evt);
            }
        });

        prevQuestion.setText("<< Previous");
        prevQuestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prevQuestionActionPerformed(evt);
            }
        });

        labelUser.setText("User");

        optionHidden.setText("hidden");

        jLabel1.setText("A");

        jLabel2.setText("B");

        jLabel3.setText("C");

        jLabel4.setText("D");

        buttonLock.setText("Lock ");
        buttonLock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLockActionPerformed(evt);
            }
        });

        buttonLast.setText("Last>>>");
        buttonLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLastActionPerformed(evt);
            }
        });

        buttonFirst.setText("<<<First");
        buttonFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonFirstActionPerformed(evt);
            }
        });

        labelTimer.setText("Timer");

        labelTimeRemaining.setText("Time Remaining : ");

        labelWelcome.setText("Welcome");

        labelJumpToQuesNo.setText("Go to Ques No ");

        buttonGo.setText("Go");
        buttonGo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGoActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jLabel5.setText("Your Notes");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(quesNo, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(buttonFirst)
                                .addGap(18, 18, 18)
                                .addComponent(prevQuestion)
                                .addGap(266, 266, 266)
                                .addComponent(nextQuestion)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buttonLast))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(option1)
                                    .addComponent(option4)
                                    .addComponent(option3)
                                    .addComponent(option2)
                                    .addComponent(optionHidden))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buttonLock, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(199, 199, 199))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 685, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelJumpToQuesNo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textJumpToQuesNo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonGo, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labelTimeRemaining)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelTimer, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(103, 103, 103)
                                .addComponent(labelWelcome)
                                .addGap(18, 18, 18)
                                .addComponent(labelUser, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(85, 85, 85))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelTimer)
                            .addComponent(labelTimeRemaining)
                            .addComponent(labelWelcome)
                            .addComponent(labelUser, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelJumpToQuesNo)
                            .addComponent(textJumpToQuesNo, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonGo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(option1)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(option2)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(option3)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(option4)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(optionHidden)
                .addGap(18, 18, 18)
                .addComponent(buttonFirst)
                .addGap(10, 10, 10))
            .addGroup(layout.createSequentialGroup()
                .addGap(318, 318, 318)
                .addComponent(quesNo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 434, Short.MAX_VALUE)
                .addComponent(buttonLock)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nextQuestion)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(prevQuestion)
                        .addComponent(buttonLast)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nextQuestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextQuestionActionPerformed
        // TODO add your handling code here:
        try{
        NextQuestion();}
        catch(Exception e){
        System.out.println(e);
        }
        
    }//GEN-LAST:event_nextQuestionActionPerformed

    private void prevQuestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prevQuestionActionPerformed
        // TODO add your handling code here:
        try{
            PreviousQuestion();
        }
        catch(Exception e){}
    }//GEN-LAST:event_prevQuestionActionPerformed

    private void option1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_option1ActionPerformed
        // TODO add your handling code here:
        System.out.println("First option clicked");
        
        String query="update mcqBackup set "+labelUser.getText()+"=1 where quesId="+count;
        System.out.println(query);
        
        try{
            //selectStmt=myConnection.createStatement();
            selectStmt.executeUpdate(query);
        }
        catch(Exception e){}
        try{
        CalculateMarks(count);
        }catch(Exception e){}
        
    }//GEN-LAST:event_option1ActionPerformed

    private void option2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_option2ActionPerformed
        // TODO add your handling code here:
        System.out.println("Second option clicked");
        String query="update mcqBackup set "+labelUser.getText()+"=2 where quesId="+count;
        System.out.println(query);
        try{
            //Statement selectStmt=myConnection.createStatement();
            selectStmt.executeUpdate(query);
        }
        catch(Exception e){}
        try{
        CalculateMarks(count);
        }catch(Exception e){}
    }//GEN-LAST:event_option2ActionPerformed

    private void option3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_option3ActionPerformed
        // TODO add your handling code here:
        System.out.println("Third option clicked");
        String query="update mcqBackup set "+labelUser.getText()+"=3 where quesId="+count;
        System.out.println(query);
        try{
            //Statement selectStmt=myConnection.createStatement();
            selectStmt.executeUpdate(query);
        }
        catch(Exception e){}
        try{
        CalculateMarks(count);
        }catch(Exception e){}
    }//GEN-LAST:event_option3ActionPerformed

    private void option4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_option4ActionPerformed
        // TODO add your handling code here:
        System.out.println("Fourth option clicked");
        String query="update mcqBackup set "+labelUser.getText()+"=4 where quesId="+count;
        System.out.println(query);
        try{
            //Statement selectStmt=myConnection.createStatement();
            selectStmt.executeUpdate(query);
        }
        catch(Exception e){}
        try{
        CalculateMarks(count);
        }catch(Exception e){}
    }//GEN-LAST:event_option4ActionPerformed

    private void buttonLockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLockActionPerformed
        // TODO add your handling code here:
        LockIt();
        DisableIt();
        this.setVisible(false);
        new MessageForm().setVisible(true);
        
    }//GEN-LAST:event_buttonLockActionPerformed

    void DisableIt(){
        option1.setEnabled(false);
        option2.setEnabled(false);
        option3.setEnabled(false);
        option4.setEnabled(false);
        prevQuestion.setEnabled(false);
        nextQuestion.setEnabled(false);
        buttonFirst.setEnabled(false);
        buttonLast.setEnabled(false);
        buttonLock.setEnabled(false);
    }
    
    private void buttonLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLastActionPerformed
        // TODO add your handling code here:
        try{
        LastQuestion();
        }catch(Exception e){}
        
    }//GEN-LAST:event_buttonLastActionPerformed

    private void buttonFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonFirstActionPerformed
        // TODO add your handling code here:
        try{
        FirstQuestion();
        }catch(Exception e){}
    }//GEN-LAST:event_buttonFirstActionPerformed

    private void buttonGoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGoActionPerformed
        // TODO add your handling code here:
        int quesNo=Integer.parseInt(textJumpToQuesNo.getText());
        quesNo--;
        count=quesNo;
        try{
        NextQuestion();
        }catch(Exception e){}
    }//GEN-LAST:event_buttonGoActionPerformed

    public void LastQuestion() throws SQLException{
        
        String basicQuery="select ques,opt1,opt2,opt3,opt4 from mcqBackup where quesId="+last;
        count=last;
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
        
        String stateQuery="select "+labelUser.getText()+" from mcqBackup where quesId="+count;
        System.out.println(stateQuery);
        GetState(stateQuery).setSelected(true);
            
        Check();
    }
    
    public void FirstQuestion() throws SQLException{
        
        String basicQuery="select ques,opt1,opt2,opt3,opt4 from mcqBackup where quesId=1";
        count=1;
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
        
        String stateQuery="select "+labelUser.getText()+" from mcqBackup where quesId="+count;
        System.out.println(stateQuery);
        GetState(stateQuery).setSelected(true);
            
        Check();
    }
    
    public void LockIt(){
        String query="update user set lok=1 where username='"+labelUser.getText()+"'";
        System.out.println(query);
        try{
            Statement selectStmt=myConnection.createStatement();
            selectStmt.executeUpdate(query);
        }
        catch(Exception e){}
    }
    
    
    public void CalculateMarks(int count) throws SQLException{
        System.out.println("Entered Calculate Marks");
        String query="select correct,"+labelUser.getText()+",quesId from mcqBackup where quesId="+count;
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
              marksQuery="update mcqBackup set "+labelUser.getText()+"Marks=1 where quesId="+quesId;
              selectStmt.executeUpdate(marksQuery);
            }
            else
            {
                System.out.println("Entered IF");
              marksQuery="update mcqBackup set "+labelUser.getText()+"Marks=0 where quesId="+quesId;
              selectStmt.executeUpdate(marksQuery);
            }
        
        
    
    }
    
    
    //Timer Functions
    public void MyTimer(){
    Timer t = new javax.swing.Timer(1000, new ActionListener() {
          public void actionPerformed(ActionEvent e) {
              //GetTime();
             // int min=2;
    //int sec=min*60;
              if(sec>=0)
              {
              DecreasingCounter();
              DoLock();
              repaint();        
              }
          }
       });
        
        t.start();
    }
    
    public void GetTime(){
        
        Calendar cal = Calendar.getInstance();
    	cal.getTime();
    	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String crTime=sdf.format(cal.getTime());
    	System.out.println(crTime );
        labelTimer.setText(crTime);
        
                
    }
    
    public  void DecreasingCounter(){
    
    //while(sec!=0){
        String timeString=GetRemTimeString(sec);
        labelTimer.setText(timeString);
        System.out.println(timeString);
        sec--;
       // }
    }

    public void DoLock(){
       if(sec==0)
       {
       buttonLock.setEnabled(true);
       buttonLock.doClick();
       }
    }
    
    public String GetRemTimeString(int sec){
    
        String remTimeString="";
        int remSec=sec%60;
        int min=sec/60;
        int remMin=min%60;
        int hours=min/60;
        remTimeString=hours+":"+remMin+":"+remSec;
        return remTimeString;
    }
    
    //Processing Window Event
    @Override
    protected void processWindowEvent(WindowEvent e) {
       // super.processWindowEvent(e); //To change body of generated methods, choose Tools | Templates.
        if(e.getID() == WindowEvent.WINDOW_CLOSING)
        {
            buttonLock.setEnabled(true);
            buttonLock.doClick();
        }
    }
    
    
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
            java.util.logging.Logger.getLogger(MCQForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MCQForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MCQForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MCQForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MCQForm().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(MCQForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonFirst;
    private javax.swing.JButton buttonGo;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton buttonLast;
    private javax.swing.JButton buttonLock;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel labelJumpToQuesNo;
    private javax.swing.JLabel labelTimeRemaining;
    private javax.swing.JLabel labelTimer;
    private javax.swing.JLabel labelUser;
    private javax.swing.JLabel labelWelcome;
    private javax.swing.JButton nextQuestion;
    private javax.swing.JRadioButton option1;
    private javax.swing.JRadioButton option2;
    private javax.swing.JRadioButton option3;
    private javax.swing.JRadioButton option4;
    private javax.swing.JRadioButton optionHidden;
    private javax.swing.JButton prevQuestion;
    private javax.swing.JLabel quesNo;
    private javax.swing.JTextArea question;
    private javax.swing.JTextField textJumpToQuesNo;
    // End of variables declaration//GEN-END:variables
}
