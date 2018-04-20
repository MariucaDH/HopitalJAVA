/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vue;



import controleur.modèle.Requetes;
import java.awt.Color;
import java.sql.SQLException;
import org.jfree.chart.*;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;

 
public class Graphique extends ApplicationFrame {
   
    private static Requetes req; 
    private static Object[][] liste; 
    private static Object[][] liste1; 
    private static Object[][] liste2; 
    //Constructeur des chart 
   public Graphique(String titre) {
      super(titre); 
      //setContentPane(createDemoPanel());
   }
 
   
   ///GRAPHIQUE 1 : PATIENTS PAR SERVICE 
   
   //Requete 15 : patientsservice(); 
   
   // 1. On rentre les données 
   public static PieDataset donneeschart1( ) throws SQLException, ClassNotFoundException {
       req = new Requetes("local"); 
       liste = req.patientsservice(); 
       
      DefaultPieDataset dataset = new DefaultPieDataset( );
      dataset.setValue("CARDIO", (Number) liste[0][1]);  
      dataset.setValue("CHIRURGIE" , (Number) liste [1][1]);   
      dataset.setValue("REA" , (Number) liste [2][1]);     
      return dataset;         
   }
    
   //2. On crée le camembert 
   public static JFreeChart createChart1(PieDataset dataset) {
      JFreeChart ch = ChartFactory.createPieChart(      
         "Repartition des patients par service",   //titre 
         dataset,          //Donnees   
         true,             //Legendes   
         true, 
         true);
ch.setBackgroundPaint(new Color (204,255,204));

      return ch;
   }
   
   ///GRAPHIQUE 2 : SALAIRE INFIRIMIERES JOUR/NUIT : 
   public static CategoryDataset donneeschart2() throws SQLException, ClassNotFoundException{
       req = new Requetes("local"); 
       liste = req.salaireinf1200(); //Entre 1200 et 1500
       liste1 = req.salaireinf1500(); //Entre 1500 et 1800
       liste2 = req.salaireinf1800(); // Entre 1800 et 2100
       DefaultCategoryDataset dataset = new DefaultCategoryDataset(); 
     
    dataset.addValue((Number)liste [0][1], "Jour", "1200€-1500€"); //8
    dataset.addValue((Number)liste1 [0][1], "Jour", "1500€-1800€"); 
    dataset.addValue((Number)liste2[0][1], "Jour", "1800€-2100€"); 
    dataset.addValue((Number)liste [1][1], "Nuit", "1200€-1500€"); //8
    dataset.addValue((Number)liste1 [1][1], "Nuit", "1500€-1800€"); 
    dataset.addValue((Number)liste2[1][1], "Nuit", "1800€-2100€"); 
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
   public static CategoryDataset donneeschart3() throws SQLException, ClassNotFoundException{
       req = new Requetes ("local"); 
       liste = req.medecinparspe(); 
       DefaultCategoryDataset dataset = new DefaultCategoryDataset(); 
       
       dataset.addValue((Number) liste [0][1], "Nombre de docteurs", "Anesthésiste"); //5
       dataset.addValue((Number) liste [1][1], "Nombre de docteurs", "Cardiologue"); //8 
       dataset.addValue((Number) liste [2][1], "Nombre de docteurs", "Orthopédiste"); //5 
       dataset.addValue((Number) liste [3][1], "Nombre de docteurs", "Pneumologue"); //5 
       dataset.addValue((Number) liste [4][1], "Nombre de docteurs", "Radiologue"); //4
       dataset.addValue((Number) liste [5][1], "Nombre de docteurs", "Traumatologue"); //5
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
    
   
    
   
    

