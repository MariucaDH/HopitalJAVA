/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vue;



import org.jfree.chart.*;
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
   // CHART 1 : REPARTITION DES PATIENTS PAR SERVICE 
   //CHART 2 : NOMBRE DE DOCTEUR PAR SPECIALITE 
   
   // 1. On rentre les données 
   public static PieDataset donneeschart1( ) {
      DefaultPieDataset dataset = new DefaultPieDataset( );
      dataset.setValue( "CARDIOLOGIE" , new Double( 20 ) );  
      dataset.setValue( "CHIRURGIE" , new Double( 40 ) );   
      dataset.setValue( "REANIMATION" , new Double( 40 ) );     
      return dataset;         
   }
   
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
  return chart;
  }
               
   
   //2. On crée le camembert 
   public static JFreeChart createChart1(PieDataset dataset) {
      JFreeChart ch = ChartFactory.createPieChart(      
         "Repartition des patients par service",   //titre 
         dataset,          //Donnees   
         true,             //Legendes   
         true, 
         false);

      return ch;
   }

   
}
    
   
    
   
    

