/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

/**
 *
 * @author Mariuca
 */
public class Ajout extends JFrame{
    
    public Ajout (){
         //Titre de l'interface
    this.setTitle("Mise à jour des données de la BDD : Ajout");
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
}
