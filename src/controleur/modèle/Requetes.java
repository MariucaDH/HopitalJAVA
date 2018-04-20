/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur.modèle;

import controleur.Connexion;
import java.sql.*;

/**
 *
 * @author jbkaloya
 */
public class Requetes {
    
    private boolean is_local = false;
    private boolean is_distant = false;
    private Connexion bdd;
    private Statement stmt;
    private Object[][] liste;
    
    
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
    
    
    public Object[][] usermaaf() throws SQLException{
        
         ResultSet rs;
         liste = new Object[100][10];

 
            rs = stmt.executeQuery("SELECT nom, prenom FROM malade WHERE mutuelle = 'MAAF'");
            int i = 0;
            while ( rs.next() ) {
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                
                Object[] str = new Object[] { prenom, nom};
                
                
                liste[i] = str;
                //System.out.println(prenom);
                i++;
            }
        

        return liste;
    }
    
    
    public Object[][] infirmiernuit() throws SQLException{
        
         ResultSet rs;
         liste = new Object[100][10];

 
            rs = stmt.executeQuery("SELECT employe.nom as n, employe.prenom as p FROM employe,infirmier  WHERE infirmier.rotation = 'NUIT' AND employe.numero = infirmier.numero");
            int i = 0;
            while ( rs.next() ) {
                String nom = rs.getString("n");
                String prenom = rs.getString("p");
                
                Object[] str = new Object[] { prenom, nom};
                
                
                liste[i] = str;
                //System.out.println(prenom);
                i++;
            }
        

        return liste;
    }
    
    public Object[][] services() throws SQLException{
        
         ResultSet rs;
         liste = new Object[100][10];

 
            rs = stmt.executeQuery("SELECT employe.nom as n, employe.prenom as p, service.nom as sn, service.batiment as ba FROM employe, service  WHERE employe.numero = service.directeur ORDER BY  service.nom ASC");
            int i = 0;
            while ( rs.next() ) {
                
                String service = rs.getString("sn");
                String batiment = rs.getString("ba");
                
                String nom = rs.getString("n");
                String prenom = rs.getString("p");
                
                
                Object[] str = new Object[] { service, batiment, prenom, nom};
                
                
                liste[i] = str;
                //System.out.println(prenom);
                i++;
            }
        

        return liste;
    }
    
    
    
    public Object[][] moyennesalaires() throws SQLException{
        
         ResultSet rs;
         liste = new Object[100][10];

 
            rs = stmt.executeQuery("SELECT code_service, AVG(salaire) as s FROM infirmier WHERE GROUP BY code_service");
            int i = 0;
            while ( rs.next() ) {
                String service = rs.getString("code_service");
                String salaire = rs.getString("s");
                
                Object[] str = new Object[] { service, salaire};
                
                
                liste[i] = str;
                //System.out.println(prenom);
                i++;
            }
        

        return liste;
    }
    
    public Object[][] litbatimentA() throws SQLException{
        
         ResultSet rs;
         liste = new Object[100][10];

 
            rs = stmt.executeQuery("SELECT ROUND(AVG(chambre.nb_lits), 0) as lits, service.code as s FROM service, chambre WHERE service.batiment = 'A' AND service.code = chambre.code_service GROUP BY service.code");
            int i = 0;
            while ( rs.next() ) {
                String service = rs.getString("s");
                String lits = rs.getString("lits");
                
                Object[] str = new Object[] { service, lits};
                
                
                liste[i] = str;
                //System.out.println(prenom);
                i++;
              
            }
        

        return liste;
    }
    
    public Object[][] malades3fois() throws SQLException{
        
         ResultSet rs;
         liste = new Object[100][10];

 
            rs = stmt.executeQuery("SELECT ROUND(AVG(chambre.nb_lits), 0) as lits, service.code as s FROM service, chambre WHERE service.batiment = 'A' AND service.code = chambre.code_service GROUP BY service.code");
            int i = 0;
            while ( rs.next() ) {
                String service = rs.getString("s");
                String lits = rs.getString("lits");
                
                Object[] str = new Object[] { service, lits};
                
                
                liste[i] = str;
                //System.out.println(prenom);
                i++;
            }
        

        return liste;
    }
    
    public Object[][] docteursavecpatients() throws SQLException{
        
         ResultSet rs;
         liste = new Object[100][10];

 
            rs = stmt.executeQuery("SELECT DISTINCT employe.prenom, employe.nom FROM soigne, employe WHERE employe.numero = soigne.no_docteur GROUP BY soigne.no_malade");
            int i = 0;
            while ( rs.next() ) {
                String prenom = rs.getString("prenom");
                String nom = rs.getString("nom");
                
                Object[] str = new Object[] { prenom, nom};
                
                
                liste[i] = str;
                //System.out.println(prenom);
                i++;
            }
        

        return liste;
    }
    
    public Object[][] docteurssanspatients() throws SQLException{
        
         ResultSet rs;
         liste = new Object[100][10];

 
            rs = stmt.executeQuery("SELECT DISTINCT employe.prenom, employe.nom FROM soigne, employe WHERE employe.numero != soigne.no_docteur GROUP BY soigne.no_malade");
            int i = 0;
            while ( rs.next() ) {
                String prenom = rs.getString("prenom");
                String nom = rs.getString("nom");
                
                Object[] str = new Object[] {prenom, nom};
                
                
                liste[i] = str;
                //System.out.println(prenom);
                i++;
            }
        

        return liste;
    }
    
    
    //Ratio service
    public Object[][] ratioservices() throws SQLException{
        
         ResultSet rs;
         ResultSet rs2;
        liste = new Object[100][10];

 
            rs = stmt.executeQuery("SELECT COUNT(infirmier.numero) as t, service.nom FROM infirmier, service WHERE service.code = infirmier.code_service GROUP BY infirmier.code_service");
            int i = 0;
            while ( rs.next() ) {
                String totalinfirmiers = rs.getString("t");
                String nom = rs.getString("nom");
                String rapport = "";
                
                rs2 = stmt.executeQuery("SELECT COUNT(hospitalisation.no_malade) as m, service.nom FROM hospitalisation, service WHERE service.code = hospitalisation.code_service GROUP BY hospitalisation.code_service");
                while ( rs2.next() ) {
                    
                    if(rs2.getString("nom") == nom){
                        rapport = totalinfirmiers+"/"+rs2.getString("m");
                    }
                    
                }
                
                
                Object[] str = new Object[] {nom, rapport};
                
                
                liste[i] = str;
                //System.out.println(prenom);
                i++;
                
   
            }
        

        return liste;
    }
    
    
     //------------------------------------------------//
    //R14 : Nombre de medecins par spécialité :
    ///->>> POUR LE GRAPHIQUE 3
     public Object[][] medecinparspe() throws SQLException{
        
         ResultSet rs;
         liste = new Object[100][10];

 
            rs = stmt.executeQuery("SELECT specialite, COUNT(DISTINCT numero) AS nbdoc FROM docteur GROUP BY specialite");
            int i = 0;
            while ( rs.next() ) {
                String spe = rs.getString("specialite");
                int nbdoc = rs.getInt("nbdoc");
                
                Object[] str = new Object[] { spe, nbdoc};
                
                
                liste[i] = str;
                
                i++;
            }
        

        return liste;
    }
     
     
     //R11 : NB de PATIENTS guéris par médecin (numero docteur)
     
       public Object[][] nbpatientsgueris() throws SQLException{ //nbpatientsgueris
        
         ResultSet rs;
         liste = new Object[100][10];

 
            rs = stmt.executeQuery("SELECT no_docteur, COUNT( no_malade ) FROM soigne GROUP BY no_docteur");
            int i = 0;
            while ( rs.next() ) {
                String numdoc = rs.getString("Numero du docteur");
                String nbsoigne = rs.getString("Nombre de patients soignés");
                
                Object[] str = new Object[] {numdoc, nbsoigne};
                
                
                liste[i] = str;
               
                i++;
            }
        

        return liste;
    }
     
       //R15 : NB patients par service 
       //GRAPHIQUE 1
        public Object[][] patientsservice() throws SQLException{ //patientsservice
        
         ResultSet rs;
         liste = new Object[100][10];

 
            rs = stmt.executeQuery("SELECT code_service, COUNT(DISTINCT no_malade) AS n FROM hospitalisation GROUP BY code_service");
            int i = 0;
            while ( rs.next() ) {
                String codeservice = rs.getString("code_service");
                int nbmalade = rs.getInt("n");
                
                Object[] str = new Object[] {codeservice, nbmalade};
                
                
                liste[i] = str;
                
                i++;
            }
        

        return liste;
    }
       
   
        
        
        
        public Object[][] salaireinf1200() throws SQLException{ //salaireinf1200
        
         ResultSet rs;
         liste = new Object[100][10];

 
            rs = stmt.executeQuery("SELECT rotation, COUNT(DISTINCT numero) AS nbinf FROM infirmier WHERE salaire BETWEEN '1200' AND '1500' GROUP BY rotation");
            int i = 0;
            while ( rs.next() ) {
                String rot = rs.getString("rotation");
                int nbinf = rs.getInt("nbinf");
                
                Object[] str = new Object[] {rot, nbinf};
                
                
                liste[i] = str;
                
                i++;
            }
        

        return liste;
    }
        public Object[][] salaireinf1500() throws SQLException{ //salaireinf1500
        
         ResultSet rs;
         liste = new Object[100][10];

 
            rs = stmt.executeQuery("SELECT rotation, COUNT(DISTINCT numero) AS nbinf FROM infirmier WHERE salaire BETWEEN '1500' AND '1800' GROUP BY rotation");
            int i = 0;
            while ( rs.next() ) {
                String rot = rs.getString("rotation");
                int nbinf = rs.getInt("nbinf");
                
                Object[] str = new Object[] {rot, nbinf};
                
                
                liste[i] = str;
                
                i++;
            }
        

        return liste;
    }
        public Object[][] salaireinf1800() throws SQLException{ //salaireinf1800
        
         ResultSet rs;
         liste = new Object[100][10];

 
            rs = stmt.executeQuery("SELECT rotation, COUNT(DISTINCT numero) AS nbinf FROM infirmier WHERE salaire BETWEEN '1800' AND '2100' GROUP BY rotation");
            int i = 0;
            while ( rs.next() ) {
                String rot = rs.getString("rotation");
                int nbinf = rs.getInt("nbinf");
                
                Object[] str = new Object[] {rot, nbinf};
                
                
                liste[i] = str;
                
                i++;
            }
        

        return liste;
    }
        
        
          public Object[][] repartitionmutuelles() throws SQLException{ //repartitionmutuelle
        
         ResultSet rs;
         liste = new Object[100][10];

 
            rs = stmt.executeQuery("SELECT mutuelle, COUNT(DISTINCT numero) AS nbadherent FROM malade GROUP BY mutuelle");
            int i = 0;
            while ( rs.next() ) {
                String mutuelle = rs.getString("mutuelle");
                int nbadh = rs.getInt("nbadherent");
                
                Object[] str = new Object[] {mutuelle, nbadh};
                
                
                liste[i] = str;
                
                i++;
            }
        

        return liste;
    }
      
}
