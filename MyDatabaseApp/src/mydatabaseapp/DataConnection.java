/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mydatabaseapp;

/**
 *
 * @author raman
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public final class DataConnection {
    private Connection myConnection;
    static String ipAddress;

    public void SetIpAddress(){
        BufferedReader br;
        String currLine;
        try{
        br=new BufferedReader(new FileReader("ip.txt"));
        if((currLine=br.readLine())!=null){
            
            System.out.println(currLine);
            ipAddress=currLine.toString();
        }
        br.close();
        }
        catch(Exception e){}
    }
    
    public DataConnection() {
        
        SetIpAddress();
        init();
    }
    public void init(){
    
       try{
        
        Class.forName("com.mysql.jdbc.Driver");
        myConnection=DriverManager.getConnection(
                //"jdbc:mysql://31.10.1.81/dbRaman","raman", "ramansehgal"
                "jdbc:mysql://"+ipAddress+"/dbraman","raman", "ramansehgal"
                );
        }
        //catch(ClassNotFoundException | SQLException e){
       catch(Exception e){
            //System.out.println("Failed to get connection");
           System.out.println(e);
                  
        }
    }
    
    public void ExecuteQuery(String query) throws SQLException{
    
        Statement selectStmt=myConnection.createStatement();
        ResultSet rs = selectStmt.executeQuery(query);
        FetchResults(rs);
    }
    
    public void FetchResults(ResultSet rs) throws SQLException{
        while(rs.next()){
            System.out.println(rs.getString(1)+" : "+rs.getString(2)+" : " +rs.getString(3));
            
        }
    }
    
    public Connection GetConnection(){
    return myConnection;
    }
}
