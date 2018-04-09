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
import javax.swing.JFrame;

public class Interface extends JFrame{
    
    public Interface() {
    this.setTitle("Hopital");
    this.setSize(1000, 500);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);             
    this.setVisible(true);
    }
    
  public static void main(String[] args){
      
   Interface f = new Interface();
    /*   JFrame fenetre = new JFrame();
                
    fenetre.setTitle("Hopital");

    //Taille
    fenetre.setSize(800, 500);
    //Centre
    fenetre.setLocationRelativeTo(null);
    //On fait en sorte que le clic sur la croix rouge nous fasse quitter la fenetre
    fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //Visibilité    
    fenetre.setVisible(true);
    
  } */ 

}

}

