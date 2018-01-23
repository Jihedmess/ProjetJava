package Projetmaster;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


/**
 *
 * @author Lenovo
 */
public class Interface1 extends JFrame {
    //declacration des variables pour les utiliser quand je veux
    JTextField tx1;
    JTextField tx2;
    JButton b1;
    JButton b2;
    JButton b3;
    JLabel Lab1; 
    JLabel Lab2;
    ArrayList moy;
    ArrayList seulle50;
     ArrayList list1; 
     ArrayList seulle,seulle11;
      ArrayList list2;
      ArrayList degre;
      String nomxml = "";
      String tableau[]={"Modèle 1", "Modèle 2"," les degrés de similarité"," seuil de similarité (80)% "};
      String matrice[][];
    public Interface1()
    {
        // creer boutton b1 
       b1= new JButton ("parcourir le fichier xml de référence"); 
      
       
       //control click sur boutton b1 appelant la classe controlbutton1
       b1.addActionListener(new controlbutton1()); 
       // creer boutton b2
        b2= new JButton ("parcourir le fichier xml existant ");
        
       // control click sur boutton b2 appelant la classe controlbutton2
       b2.addActionListener(new controlbutton2());
       
       // creer boutton b3
       b3= new JButton ("calculer la similarité fonctionnelle");
       
       // control click sur boutton b3 appelant la classe controlbutton3
       b3.addActionListener(new controlbutton3());
       // creer les zones text tx1 et tx2  et les labels Lab1 et Lab2
       tx1 = new JTextField (30);
       
       Lab1 = new JLabel ("XML 1 (référence) ");
       Lab1.setLabelFor(tx1);
       tx2 = new JTextField (30);
       Lab2 = new JLabel ("XML 2 (existant) ");
       Lab2.setLabelFor(tx2);
       Color color = new Color(100, 255,200);
       GridLayout grid = new GridLayout(2, 3);
       grid.setHgap(5);
       grid.setVgap(5);
       this.setLayout(grid);
       JPanel pan = new JPanel();
       pan.setBackground(color);
       pan.setBorder(new EmptyBorder(250, 150, 50, 20));
       
       pan.setLayout(grid);
       pan.add(b1);
       pan.add(tx1);
       pan.add(Lab1);
       pan.add(b2);
       pan.add(tx2);
       pan.add(Lab2);
       JPanel pan1 = new JPanel();
       pan1.setBackground(color);
       pan.setBorder(new EmptyBorder(250, 150,50,50));
       pan1.add(b3);
       this.setLayout(new BorderLayout());
       
       this.add(pan,BorderLayout.NORTH);
       this.add(pan1,BorderLayout.CENTER);
       this.setSize(1000,600);
       this.setLocation(100,100);
      
       
       //this.pack();//dimiension des objets en centre ( taille de frame egal au somme des tailles des objets 
       this.show();
      
       
    }

   public class controlbutton1 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
           // parcourir le premier ficher file1 
            JFileChooser file1 = new JFileChooser();
            file1.setApproveButtonText("choisir le 1er fichier ");
            file1.showOpenDialog(null);
            // test si le fichier est choisi pour afficher son path (= emplacement)
            if ((file1.showOpenDialog(null)) == JFileChooser.APPROVE_OPTION)
            {
                // getName de dossier permet de donner un URL statique du fichier XML Ã  choisir
            tx1.setText(file1.getSelectedFile().getName());
            }
            
        }
      
      
   }
    public class controlbutton2 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
             // parcourir le deuxiÃ¨me ficher file2 
            JFileChooser file2 = new JFileChooser();
            file2.setApproveButtonText("choisir le 2 ème fichier ");
            file2.showOpenDialog(null);
             
           
            // test si le fichier est choisi pour afficher son path (= emplacement)
            if ((file2.showOpenDialog(null)) == JFileChooser.APPROVE_OPTION)
            {
            tx2.setText(file2.getSelectedFile().getName());
            }
            
            
        }
      
   }
     public class controlbutton3 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
              //declaration variable (= objet) et initialisation instance factory par newinstance()
              // 
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        // documentbulder est une classe et builder instance de doc
        // builder permet d'utiliser une mÃ©thode pour extraire l'url de fichier 
        moy = new ArrayList<Float>(); 
        seulle = new ArrayList();
        seulle11 = new ArrayList();
        list1 = new ArrayList();
        try{
           
             DocumentBuilder build = factory.newDocumentBuilder();
                   
              // extraire le nom de 1er fichier selectionner 
            Document doc =build.parse("C:\\Users\\jihed\\Desktop\\sabraproj\\"+tx1.getText());
           // declaration de la racine des element xml a partir de l'instance  doc (=qui contiennt les xml)
            Element racine;
            racine = doc.getDocumentElement();
            // creer une liste contenant les activitÃ©s dans une list listevents
            NodeList listevents = racine.getElementsByTagName("task"); 
            // boucle sur la liste pour afficher toutes les activitÃ©s (=task) de la liste listevents
           for (int i=0; i<listevents.getLength(); i++)
           {
               
               Element var = (Element) listevents.item(i);
                 // 1 er methode String name = var.getattribute("name");
           //2 eme methode System.out.println(" var.getattribute("name")");
        
              //ystem.out.println(var.getAttribute("name")); 
             list1.add(var.getAttribute("name"));
               
               }
           
            System.out.println("le liste1 est ");
           for (int y=0; y<list1.size();y++)
           {
               System.out.println(list1.get(y));            
           }
               
           
                   
                 
            
        } catch (SAXException ex) {
            // afficher message d'esception ex
             System.out.println(ex.getMessage());
        } catch (IOException ex) {
            // afficher message d'esception ex                
                       System.out.println(ex.getMessage());
        }
        catch (ParserConfigurationException ex) {
            // afficher message d'esception ex
              System.out.println(ex.getMessage());
        }
        
    
//declaration variable (= objet) et initialisation instance factory par newinstance()**(DocumentBuilderFactory factory) ici on ne va la declarÃ©e car une seulefois en public est accessible
    
        // documentbulder est une classe et builder instance de doc
        // builder permet d'utiliser une mÃ©thode pour extraire l'url de fichier 
           
            
            seulle50 = new ArrayList<>();
            list2 = new ArrayList();
                try{
           
             DocumentBuilder build = factory.newDocumentBuilder();
                   
              // extraire le nom de 2Ã©me fichier selectionner
            Document doc =build.parse("C:\\Users\\jihed\\Desktop\\sabraproj\\"+tx2.getText());
           // declaration de la racine des element xml a partir de l'instance  doc (=qui contiennt les xml)
            Element racine;
            racine = doc.getDocumentElement();
            // creer une liste contenant les activitÃ©s dans une list listevents
            NodeList listevents = racine.getElementsByTagName("task"); 
            // boucle sur la liste pour afficher toutes les activitÃ©s (=task) de la liste listevents
           for (int i=0; i<listevents.getLength(); i++)
           {
               
               Element var = (Element) listevents.item(i);
                 // 1 er methode String name = var.getattribute("name");
           //2 eme methode System.out.println(" var.getattribute("name")");
        
              //ystem.out.println(var.getAttribute("name")); 
               list2.add(var.getAttribute("name"));
               
               }
           
                    System.out.println("la liste2 est");
           for ( int z=0 ; z< list2.size(); z++)
           {
               System.out.println(list2.get(z));
               
           }
           
                   
            
            
        } catch (SAXException ex) {
            // afficher message d'esception ex
             System.out.println(ex.getMessage());
        } catch (IOException ex) {
            // afficher message d'esception ex                
                       System.out.println(ex.getMessage());
        }
        catch (ParserConfigurationException ex) {
            // afficher message d'esception ex
              System.out.println(ex.getMessage());
        }
       
                   // calcul degrÃ© similaritÃ© 
                degre = new ArrayList();
            
            for (int l1=0; l1< list1.size(); l1++)
            {
                for ( int l2=0; l2< list2.size(); l2++)
                {
        String word1= list1.get(l1).toString();
        String word2=list2.get(l2).toString();     
             	int len1 = word1.length();
	int len2 = word2.length();  
      
        // len1+1, len2+1, because finally return dp[len1][len2]
	int[][] dp = new int [len1 + 1][len2 + 1];

	for (int i = 0; i <= len1; i++) {
		dp[i][0] = i;
	}
 
	for (int j = 0; j <= len2; j++) {
		dp[0][j] = j;
	}
 
	//iterate though, and check last char
	for (int i = 0; i < len1; i++) {
		char c1 = word1.charAt(i);
		for (int j = 0; j < len2; j++) {
			char c2 = word2.charAt(j);
 
			//if last two chars equal
			if (c1 == c2) {
				//update dp value for +1 length
				dp[i + 1][j + 1] = dp[i][j];
                                 
			} else {
				int replace = dp[i][j] + 1;
				int insert = dp[i][j + 1] + 1;
				int delete = dp[i + 1][j] + 1;
 
				int min = replace > insert ? insert : replace;
				min = delete > min ? min : delete;
				dp[i + 1][j + 1] = min;
                               
			}
		}
	}   
        float EDString = dp[len1][len2]; 
// noms de deux chaines 
        System.out.print (" la premiere activité est  "); 
        System.out.println(word1+" ");
        System.out.print (" la deuxieme activité est  "); 
        System.out.println(word2+" ");
          // la longueur des deux chaines                                                              
        System.out.print (" Longueur de la premiére activité est égal  "); 
        System.out.println(len1+" ");
        System.out.print (" Longueur de la deuxième activité est égal  "); 
        System.out.println(len2+" "); 
       
        //edit distance graph
        System.out.print (" Edit Distance String est égal   "); 
        System.out.println(dp[len1][len2]+" ");
        // calcul de la similaritÃ© entre les deux chaines
           if (len1>len2) {System.out.print (" Edit Distance Similarity est égal  "); 
        System.out.println(1- EDString /len1+" ");
        if(Math.round(((1- EDString /len1)*100))>=80){
        seulle.add("Edit Distance  entre "+word1+" et "+word2+" "+Math.round(((1- EDString /len1)*100))+"%");
        }
        if(Math.round(((1- EDString /len1)*100))>=80 && Math.round(((1- EDString /len1)*100))<100 ){
        	moy.add((1- EDString /len1)*100);
        	
        	seulle11.add("changer le nom de l'activite "+word2+" par "+word1+" "+Math.round(((1- EDString /len1)*100))+"%");
        }
        if(Math.round(((1- EDString /len1)*100))>=50 && Math.round(((1- EDString /len1)*100))<80 ){
        	
        	seulle50.add("changer le nom ce l'acitivite "+word2+"par "+word1+" "+Math.round(((1- EDString /len1)*100))+"%");
        	
        }
        degre.add("Edit Distance  entre "+word1+" et "+word2+" "+Math.round(((1- EDString /len1)*100))+"%");
           }
        else  {System.out.print (" Edit Distance Similarity est egal à "); 
        System.out.println(1- EDString/len2+" ");
        if(Math.round(((1- EDString /len2)*100))>=80){
        	seulle.add("Edit Distance  entre "+word1+" et "+word2+" "+Math.round(((1- EDString /len2)*100))+"%");
        }
        if(Math.round(((1- EDString /len2)*100))>=80 && Math.round(((1- EDString /len2)*100))<100 ){
        	moy.add((1- EDString /len2)*100);
        
                seulle11.add("changer le nom de l'acitivite "+word2+" par "+word1+" "+Math.round(((1- EDString /len2)*100))+"%");
        }
        if(Math.round(((1- EDString /len2)*100))>=50 && Math.round(((1- EDString /len2)*100))<80 ){
        	
        	seulle50.add("changer le  nom de l'activite "+word2+" par "+word1+" "+Math.round(((1- EDString /len2)*100))+"%");
        }
        
        degre.add("Edit Distance  entre "+word1+" et "+word2+" "+Math.round(((1- EDString /len2)*100))+"%");
           }
                }
            }
        
           System.out.println("sabsabraaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
            System.out.println("Testeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeseullle5000000000000000000");
            for(int p=0;p<seulle50.size();p++){
                System.out.println(seulle50.get(p).toString());
            }
            
            //teste de methode xorge
           
            
       // crÃ©ation colonne 1 et colonne 2 
            float somm = 0;
        int s = seulle.size();    
       int mat = degre.size();
        int taille1 = list1.size();
        int taille2 = list2.size();
            System.out.println("taille1 ="+taille1+" taille2 = "+taille2);
            matrice = new String[mat][5];
            // x est la colonne 
            int x=0;
                for ( int w=0; w<taille1; w++)
                {
                     matrice[w][x]= list1.get(w).toString(); }
                x++;
                for ( int l=0; l<taille2; l++)
                {
                     matrice[l][x]= list2.get(l).toString(); }
                x++;
                
                for ( int j= 0; j< degre.size(); j++)
                {
                    matrice[j][x]= degre.get(j).toString();
                }
                x++;
                for(int b =0;b<seulle.size();b++){
                	matrice[b][x]=seulle.get(b).toString();
                }
                x++;
                for(int bn =0; bn<moy.size();bn++){
                	somm = somm +(Float) moy.get(bn);
                	
                }
              
            int seulleval = seulle.size();
            
           // run tableau
            nomxml = tx1.getText();
            System.out.println("le nom de fichier xml ggggg"+nomxml);
       tableau tabb = new tableau (tableau,matrice,list1,list2,seulleval,moy,seulle50,seulle11,nomxml);
       tabb.show();
             
    

        
     
   }
    

     }}
      

   
   


 
    
    
    

