package vue;

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
import controleur.modèle.Requetes;
import java.awt.Color;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

public class Interface extends JFrame{
    
    public Interface() {
        
    //Titre de l'interface
    this.setTitle("Bienvenue");
    //Taille de l'interface
    this.setSize(1000, 500);
    //On centre l'interface
    this.setLocationRelativeTo(null);
    //Commande qui nous permet de fermer l'interface via la croix rouge
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     
    //Visibilité/Affichage
    this.setVisible(true);
    
    //Instanciation d'un JPanel qui va venir par dessus le JFrame
    JPanel pan = new JPanel();
    
    //Couleur de fond
    pan.setBackground(Color.decode("#F8E5EE"));       
    
    //Signalisation au JFrame que le JPanel sera son "content pane"
    this.setContentPane(pan);               
    this.setVisible(true);
    }
    
    //MAIN
  public static void main(String[] args) throws SQLException, ClassNotFoundException{
      
  
      Requetes r = new Requetes("local");
      System.out.println(r.infirmiernuit());
      System.out.println(r.services());
      
      
}

}

