/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur.modèle;

import controleur.Connexion;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author jbkaloya
 */
public class Requetes {
    
    private boolean is_local = false;
    private boolean is_distant = false;
    private Connexion bdd;
    private Statement stmt;
    
    
    public Requetes(){
        this.is_distant = true; // par defaut on utilise la connexion MYSQL distante
    }
    
    public Requetes(String type) throws SQLException, ClassNotFoundException{
        if(type == "local"){
            this.is_local = true;
            this.bdd = new Connexion("hospital", "root", "azerty");
        } else if(type == "ece") {
            this.is_distant = true;
            this.bdd = new Connexion("jk151987", "RTlbuabe00//", "jk151987-rw", "ss1eCbfw");
        }
        this.stmt = this.bdd.getstatement();
    }
    
    
    public ArrayList usermaaf() throws SQLException{
        
         ResultSet rs;
         ArrayList<String[]> liste;
         liste = new ArrayList<>();

 
            rs = stmt.executeQuery("SELECT nom, prenom FROM malade WHERE mutuelle = 'MAAF'");
            while ( rs.next() ) {
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                
                String[] str = new String[4];
                str[0] = prenom;
                str[1] = nom;
                
                liste.add(str);
                System.out.println(prenom);
            }
        

        return liste;
    }
    
    
    public ArrayList infirmiernuit() throws SQLException{
        
         ResultSet rs;
         ArrayList<String[]> liste;
         liste = new ArrayList<>();

 
            rs = stmt.executeQuery("SELECT employe.nom as n, employe.prenom as p FROM employe,infirmier  WHERE infirmier.rotation = 'NUIT' AND employe.numero = infirmier.numero");
            while ( rs.next() ) {
                String nom = rs.getString("n");
                String prenom = rs.getString("p");
                
                String[] str = new String[4];
                str[0] = prenom;
                str[1] = nom;
                
                liste.add(str);
                System.out.println(prenom);
            }
        

        return liste;
    }
    
    public ArrayList services() throws SQLException{
        
         ResultSet rs;
         ArrayList<String[]> liste;
         liste = new ArrayList<>();

 
            rs = stmt.executeQuery("SELECT employe.nom as n, employe.prenom as p, service.nom as sn, service.batiment as ba FROM employe, service  WHERE employe.numero = service.directeur ORDER BY  service.nom ASC");
            while ( rs.next() ) {
                
                String service = rs.getString("sn");
                String batiment = rs.getString("ba");
                
                String nom = rs.getString("n");
                String prenom = rs.getString("p");
                
                String[] str = new String[4];
                str[0] = service;
                str[1] = batiment;
                str[2] = prenom;
                str[3] = nom;
                
                liste.add(str);
                System.out.println(str[2]);
            }
        

        return liste;
    }
    
    
    
    
}
