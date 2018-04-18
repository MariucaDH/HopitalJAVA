/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;


import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
/**
 *
 * @author Sosoww
 */
public class Chart extends ApplicationFrame{
    
     private static Statement stmt;
    public static ArrayList patientsgueris () throws SQLException 
    {
       
        ResultSet rs;
        
         ArrayList<ArrayList> liste;
         liste = new ArrayList<>();

 
            rs = stmt.executeQuery("SELECT code_service, COUNT( no_malade ) FROM hospitalisation NATURAL JOIN malade GROUP BY code_service") ;
            while ( rs.next() ) {
                int code_service = rs.getInt("Code Service");
                int no_malade = rs.getInt("Nb malade");
                
                ArrayList str;
                str = new ArrayList<>();
                str.add(code_service); //String
                str.add(no_malade); //int
                
                liste.add(str);
              
            }
      
        return liste;
    }
    
      public static JPanel panel() throws SQLException {
      JFreeChart chart = createChart(createDataset( ) );  
      return new ChartPanel( chart ); 
   }
      
    public Chart( String title ) throws SQLException {
      super(title); 
      setContentPane(panel());
   }
   
   private static PieDataset createDataset( ) throws SQLException {
       
     
           
      DefaultPieDataset dataset = new DefaultPieDataset( );
      for (int i=0; i<patientsgueris().size(); i++)
      {
          
          dataset.setValue( "CAR", 10);
          dataset.setValue( "REA", 60);
          dataset.setValue("CHG", 30);
      }
      return dataset;         
   }
   
   private static JFreeChart createChart( PieDataset dataset ) {
      JFreeChart chart = ChartFactory.createPieChart(      
         "Repartition des patients par spécialité",   // chart title 
         dataset,          // data    
         true,             // include legend   
         true, 
         false);

      return chart;
   }
   
 

   public static void main( String[ ] args ) throws SQLException {
      Chart demo = new Chart( "Repartition des patients" );  
      demo.setSize( 560 , 367 );    
     // RefineryUtilities.centerFrameOnScreen( demo );    
      demo.setVisible( true ); 
   }
}
    
   
    
   
    

