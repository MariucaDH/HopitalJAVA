/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vue;



import org.jfree.chart.*;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;

 
public class Graphique extends ApplicationFrame {
   
    //Constructeur des chart 
   public Graphique(String titre) {
      super(titre); 
      //setContentPane(createDemoPanel());
   }
   // CHART 1 : REPARTITION DES PATIENTS PAR SERVICE 
   
   
   // 1. On rentre les données 
   public static PieDataset donneeschart1( ) {
      DefaultPieDataset dataset = new DefaultPieDataset( );
      dataset.setValue( "CAR" , new Double( 20 ) );  
      dataset.setValue( "CHR" , new Double( 40 ) );   
      dataset.setValue( "REA" , new Double( 40 ) );     
      return dataset;         
   }
   
   
   //2. On crée le camembert 
   public static JFreeChart createChart1( PieDataset dataset ) {
      JFreeChart ch = ChartFactory.createPieChart(      
         "Repartition des patients par service",   //titre 
         dataset,          //Donnees   
         true,             //Legendes   
         true, 
         false);

      return ch;
   }

   
}
    
   
    
   
    

