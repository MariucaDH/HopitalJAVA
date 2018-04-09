/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mariuca
 */

//On utilise JFrame pour notre interface graphique
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Interface extends JFrame{
    
    public Interface() {
    this.setTitle("Hopital");
    this.setSize(1000, 500);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);             
    this.setVisible(true);
    
    //Instanciation d'un JPanel qui va venir par dessus le JFrame
    JPanel pan = new JPanel();
    //Définition de sa couleur de fond
    pan.setBackground(Color.decode("#F8E5EE"));       
    
    //Signalisation au JFrame que notre JPanel sera son "content pane"
    this.setContentPane(pan);               
    this.setVisible(true);
    }
    
    
  public static void main(String[] args){
      
   Interface f = new Interface();

}

}

