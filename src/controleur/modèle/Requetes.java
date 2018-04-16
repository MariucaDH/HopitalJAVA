/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur.modèle;

/**
 *
 * @author jbkaloya
 */
public class Requetes {
    
    private boolean is_local = false;
    private boolean is_distant = false;
    
    
    public Requetes(){
        this.is_distant = true; // par defaut on utilise la connexion MYSQL distante
    }
    
    public Requetes(String type){
        if(type == "local"){
            this.is_local = true;
        } else if(type == "ece") {
            this.is_distant = true;
        }
    }
    
    
    
    
}
