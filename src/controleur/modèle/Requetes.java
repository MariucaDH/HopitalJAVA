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
    
    //REQUETE 1 :
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
    
<<<<<<< HEAD
    
    
    public void updaterow(String table, String field, String value, String previous){
        
        try{
            
            if(previous != null){
                 stmt.executeUpdate("UPDATE "+ table +"  SET "+field+" = '"+value+"' WHERE "+field+" = '"+previous+"' ");
            }
           
       }catch(SQLException e){
            System.out.println(e.getMessage());
       }

    }
    
    
    public void executeinsert(String req){
        
        try{
            
               stmt.executeUpdate(req);

           
       }catch(SQLException e){
            System.out.println(e.getMessage());
       }

    }
    
    public void deleterow(String table, String field, String previous){

        
        try{
            
             stmt.executeUpdate("DELETE FROM "+table+" WHERE "+field+" = '"+previous+"'");
  
           
       }catch(SQLException e){
            System.out.println(e.getMessage());
       }

    }
    
    
    public Object[][] usermaaf() throws SQLException{
=======
    //REQUETE 2 : 
    public Object[][] infirmiernuit() throws SQLException{
>>>>>>> c2e240fa72172a54e366307bc049d7df4b33cd32
        
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
      public Object[][] infirmierjour() throws SQLException{
        
         ResultSet rs;
         liste = new Object[100][10];

 
            rs = stmt.executeQuery("SELECT employe.nom as n, employe.prenom as p FROM employe,infirmier  WHERE infirmier.rotation = 'JOUR' AND employe.numero = infirmier.numero");
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
    
   ///REQUETE 3 :  Services et leur directeur
    public Object[][] services() throws SQLException{
        
         ResultSet rs;
         liste = new Object[100][10];

 
            rs = stmt.executeQuery("SELECT service.nom as s, service.batiment as b, employe.prenom as p, employe.nom as n FROM service, employe  WHERE service.directeur = employe.numero");
            int i = 0;
            while (rs.next()) {
                
                String batiment = rs.getString("b");
                String service = rs.getString("s");
                
               // String lit = rs.getString("l");
                String nom = rs.getString("n");
                String prenom = rs.getString("p");

                
                Object[] str = new Object[] {service,  batiment, prenom, nom};
                
                
                liste[i] = str;
                //System.out.println(prenom);
                i++;
            }
        

        return liste;
    }
    
    //REQUETE 4 
    public Object[][] infochambre() throws SQLException{
        
         ResultSet rs;
         liste = new Object[100][10];

 
            rs = stmt.executeQuery("SELECT chambre.no_chambre as ch, chambre.code_service as s, chambre.nb_lits as l, employe.nom as n, employe.prenom as p FROM chambre, employe  WHERE employe.numero = chambre.surveillant");
            int i = 0;
            while (rs.next()) {
                
                String chambre = rs.getString("ch");
                String service = rs.getString("s");
                
                String lit = rs.getString("l");
                String nom = rs.getString("n");
                String prenom = rs.getString("p");

                
                Object[] str = new Object[] {chambre, service, lit, prenom, nom};
                
                
                liste[i] = str;
                //System.out.println(prenom);
                i++;
            }
        

        return liste;
    }
    
    
    //R5 
    public Object[][] moyennesalaires() throws SQLException{
        
         ResultSet rs;
         liste = new Object[100][10];

 rs = stmt.executeQuery("SELECT code_service, AVG(salaire) as s FROM infirmier GROUP BY code_service");
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
    
    
    //R6 : 
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
    
   
    
    //// R9 : 
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
    //R10
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
    public Object[][] ratioservices() throws SQLException{ //ratioservices()
        //R8
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
                    
                    if(rs2.getString("nom").equals(nom)){
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

 
            rs = stmt.executeQuery("SELECT employe.nom, employe.prenom, COUNT(soigne.no_malade) AS nbpat FROM employe, soigne WHERE soigne.no_docteur = employe.numero GROUP BY no_docteur ORDER BY nbpat DESC");
            int i = 0;
            while ( rs.next() ) {
                 String nom = rs.getString("nom");

                String prenom = rs.getString("prenom");
                String nbsoigne = rs.getString("nbpat");
                
                Object[] str = new Object[] {prenom, nom, nbsoigne};
                
                
                liste[i] = str;
               
                i++;
            }
        

        return liste;
    }
     
       //R14 : NB patients par service 
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
       
   
        
        
        //R16
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
        
        
        //R17
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
        
        
        //R18
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
        
        ///R12
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
            
         
         public Object[][] salairemaxinf() throws SQLException{ //salairemaxinf
        
         ResultSet rs;
         liste = new Object[100][10];

 
            rs = stmt.executeQuery("SELECT employe.prenom AS p, employe.nom AS n, MAX(infirmier.salaire) AS salmax FROM employe, infirmier WHERE infirmier.numero=employe.numero");
            int i = 0;
            while ( rs.next() ) {
                String prenom = rs.getString("p");
                                String nom = rs.getString("n");

                                                String salaire = rs.getString("salmax");

                
                Object[] str = new Object[] {prenom, nom, salaire};
                
                
                liste[i] = str;
                
                i++;
            }
        return liste;
    }
        public Object[][] fichepatient() throws SQLException{ //fichepatient
        
         ResultSet rs;
         liste = new Object[100][10];

 
            rs = stmt.executeQuery("SELECT malade.prenom AS p, malade.nom AS n, malade.adresse AS a, malade.mutuelle AS m, hospitalisation.no_chambre AS ch FROM hospitalisation, malade WHERE hospitalisation.no_malade = malade.numero");
            int i = 0;
            while ( rs.next() ) {
                String prenom = rs.getString("p");
                                String nom = rs.getString("n");
                                String adresse = rs.getString("a");

                                                String mutuelle = rs.getString("m");
                                                String chambre = rs.getString("ch");

                
                Object[] str = new Object[] {prenom, nom, adresse,mutuelle, chambre};
                
                
                liste[i] = str;
                
                i++;
            }
        return liste;
    }
              public Object[][] infodoc() throws SQLException{ //fichepatient
        
         ResultSet rs;
         liste = new Object[100][10];

 
            rs = stmt.executeQuery("SELECT employe.prenom AS p, employe.nom AS n, docteur.specialite AS spe  FROM employe, docteur WHERE docteur.numero = employe.numero");
            int i = 0;
            while ( rs.next() ) {
                String prenom = rs.getString("p");
                                String nom = rs.getString("n");
                                String spe = rs.getString("spe");


                
                Object[] str = new Object[] {prenom, nom, spe};
                
                
                liste[i] = str;
                
                i++;
            }
        return liste;
              }
        
                 public Object[][] salairesdesinfi() throws SQLException{ //salairedesinfi
        
         ResultSet rs;
         liste = new Object[100][10];

 
            rs = stmt.executeQuery("SELECT employe.prenom AS p, employe.nom AS n, infirmier.salaire AS salmax FROM employe, infirmier WHERE salaire BETWEEN '1200' AND '1500' AND employe.numero = infirmier.numero");
            int i = 0;
            while ( rs.next() ) {
                String prenom = rs.getString("p");
                                String nom = rs.getString("n");

                                                String salaire = rs.getString("salmax");

                
                Object[] str = new Object[] {prenom, nom, salaire};
                
                
                liste[i] = str;
                
                i++;
            }
        return liste;
    }
                 
                  public Object[][] employes() throws SQLException{ //liste des employes R17
        
         ResultSet rs;
         liste = new Object[100][10];

 
            rs = stmt.executeQuery("SELECT prenom AS p, nom AS n, adresse AS a,tel AS t FROM employe ORDER BY nom ASC");
            int i = 0;
            while ( rs.next() ) {
                String prenom = rs.getString("p");
                                String nom = rs.getString("n");
                                String tel = rs.getString("t");
                                String adresse = rs.getString("a");

                
                Object[] str = new Object[] {prenom, nom, tel, adresse};
                
                
                liste[i] = str;
                
                i++;
            }
        return liste;
    }
    
        
}
