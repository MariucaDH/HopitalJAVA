/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;


import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Sosoww
 */
public class Chart {
    
    private Statement stmt;
    public ArrayList patientsgueris () throws SQLException 
    {
        
        ResultSet rs;
        
         ArrayList<String[]> liste;
         liste = new ArrayList<>();

 
            rs = stmt.executeQuery("SELECT code_service, COUNT( no_malade ) FROM hospitalisation NATURAL JOIN malade GROUP BY code_service") ;
            while ( rs.next() ) {
                String code_service = rs.getString("Code Service");
                String no_malade = rs.getString("Numéro malade");
                
                String[] str = new String[4];
                str[0] = code_service;
                str[1] = no_malade;
                
                liste.add(str);
                System.out.println(no_malade);
            }
        

        return liste;
    }
    
    //private JFreeChart
    
}
