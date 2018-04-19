/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vue;



import java.awt.Color;
import org.jfree.chart.*;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;

 
public class Graphique extends ApplicationFrame {
   
    //Constructeur des chart 
   public Graphique(String titre) {
      super(titre); 
      //setContentPane(createDemoPanel());
   }
 
   
   ///GRAPHIQUE 1 : PATIENTS PAR SERVICE 
   
   //Requete 15 : patientsservice(); 
   
   // 1. On rentre les données 
   public static PieDataset donneeschart1( ) {
      DefaultPieDataset dataset = new DefaultPieDataset( );
      dataset.setValue( "CARDIO" , new Double( 20 ) );  
      dataset.setValue( "CHIRURGIE" , new Double( 40 ) );   
      dataset.setValue( "REA" , new Double( 40 ) );     
      return dataset;         
   }
    
   //2. On crée le camembert 
   public static JFreeChart createChart1(PieDataset dataset) {
      JFreeChart ch = ChartFactory.createPieChart(      
         "Repartition des patients par service",   //titre 
         dataset,          //Donnees   
         true,             //Legendes   
         true, 
         false);
ch.setBackgroundPaint(new Color (204,255,204));

      return ch;
   }
   
   ///GRAPHIQUE 2 : SALAIRE INFIRIMIERES JOUR/NUIT : 
   public static CategoryDataset donneeschart2(){
       
       DefaultCategoryDataset dataset = new DefaultCategoryDataset(); 
     
    dataset.addValue(3, "Jour", "1200€-1500€"); 
    dataset.addValue(5, "Jour", "1500€-1800€"); 
    dataset.addValue(6, "Jour", "1800€-2100€"); 
    dataset.addValue(8, "Nuit", "1200€-1500€"); 
    dataset.addValue(4, "Nuit", "1500€-1800€"); 
    dataset.addValue(5, "Nuit", "1800€-2100€"); 
  return dataset;
  }   
   
     public static JFreeChart createChart2(CategoryDataset dataset) {

   JFreeChart chart = ChartFactory.createBarChart(
  "Repartition du salaire des infirmières en fonction de leur rotation", "Salaire", "Nombre d'infirmières", dataset,
  PlotOrientation.VERTICAL, true, true, false);
   chart.setBackgroundPaint(new Color (204,255,204));
  return chart;
  }
               
   ///GRAPHIQUE 3 : DOcteurs par spécialité 
   public static CategoryDataset donneeschart3(){
       
       DefaultCategoryDataset dataset = new DefaultCategoryDataset(); 
       
       dataset.addValue(2, "Nombre de docteurs", "Cardiologie");
       dataset.addValue(3, "Nombre de docteurs", "Pneumatologie");
       dataset.addValue(5, "Nombre de docteurs", "Traumatologie");
       dataset.addValue(1, "Nombre de docteurs", "Anesthésiste");
       dataset.addValue(4, "Nombre de docteurs", "Orthopédiste");
       return dataset; 
   }
               
   public static JFreeChart createChart3(CategoryDataset dataset)
   {
       JFreeChart chart = ChartFactory.createBarChart("Nombre de docteurs par spécialité", "Spécialités", "Nombre de docteurs", dataset, PlotOrientation.HORIZONTAL, true, true, false);
       chart.setBackgroundPaint(new Color (204,255,204));
       CategoryPlot p = chart.getCategoryPlot(); 
       p.setRangeGridlinePaint(new Color (255,204,204)); 
       
       return chart; 
   }


   
   ///GRAPHIQUE 4 : MUTUELLE DES PATIENTS
   
      public static JFreeChart createChart4(PieDataset dataset) {
      JFreeChart ch = ChartFactory.createPieChart(      
         "Repartition des patients par mutuelle",   //titre 
         dataset,          //Donnees   
         true,             //Legendes   
         true, 
         false);
ch.setBackgroundPaint(new Color (204,255,204));

      return ch;
   }

       
     public static PieDataset donneeschart4( ) {
      DefaultPieDataset dataset = new DefaultPieDataset( );
      dataset.setValue( "MNAM" , new Double( 20 ) );  
      dataset.setValue( "LMDE" , new Double( 40 ) );   
      dataset.setValue( "MNH" , new Double( 40 ) );
      dataset.setValue( "CNAMTS" , new Double( 20 ) );  
      dataset.setValue( "AG2R" , new Double( 40 ) );   
      dataset.setValue( "CCVRP" , new Double( 40 ) ); 
      dataset.setValue( "MGSP" , new Double( 20 ) );  
      dataset.setValue( "MAS" , new Double( 40 ) );   
      dataset.setValue( "MNFTC" , new Double( 40 ) );    
      return dataset;         
   }
   
   
}
    
   
    
   
    

