package Projetmaster;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class RecommandationFonctionnelle extends JFrame {
         String mot2=" ";
         String mot1 = " ";
         String mot3="";
         String mot4="";
         String nomXml;
         String nomxml2;
         String mot444="";
         String mot222="";
         String mot111 = "";
	ArrayList liste1 ,liste2,moyenne,seulle50,seulle,listxml22;
        JTextField textparcourir;
        ArrayList moy,seulle11,degre;
        ArrayList listxml2; 
        String tableau[]={"Modèle 1", "Modèle 2","degré de similarité","seulle"};
      String matrice[][];
      JLabel conditiontexte;
	public RecommandationFonctionnelle(ArrayList liste1,ArrayList liste2,ArrayList moyenne,ArrayList seulle50,ArrayList seulle,String nomXml){
		this.liste1 = liste1;
		this.liste2 = liste2;
		this.moyenne = moyenne;
                this.nomXml= nomXml;
                
                // seuil entre 50% et 80%
		this.seulle50 = seulle50;
                this.seulle = seulle;
		JButton button = new JButton("Parcourir à nouveau le modèle existant (xml2 modifié)");
                JButton button2 = new JButton(" tester la similarité fonctionnelle");
                button2.addActionListener(new testerfonctionnelle());
                button.addActionListener( new Controlparcourir());
		textparcourir = new JTextField(30);
                
                JLabel label = new JLabel("xml2 existant ");
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		panel.add(button);
		panel.add(textparcourir);
		panel.add(label);
		JPanel pan = new JPanel();
		pan.setLayout(new FlowLayout());
		// defference et defference 2 pour verifier l'existance des activité dans modele 1 et modele 2
                // methode existance1 
                // appel methode exostance1
		ArrayList defference = Existance1(liste1, liste2);
		ArrayList defference2 = Existance1(liste2, liste1);
		JTextArea area = new JTextArea(20 , 15);
                              
                System.out.println("Recommandation Fonctionnelle testeeeeeeeeeeeeeeeeee");
                System.out.println("sabraaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
                
		if(defference.size()>0){
                    // liste des activités a ajouter
                    // concaténation des noms des ativités supplementaire ou non exsitants 
			String mot11 = "Nous recommandons d ajouter les activités suivantes :";
                        
			for(int i =0; i<defference.size();i++){
				
				mot111 = mot111+"-"+defference.get(i).toString()+"\n";
			}
                        mot1 = mot11+" "+mot111;
		}
                
               
                if(defference2.size()>0){
                    String mot22= "Nous recommandons d’éliminer les activités suivantes :";
                    
                    
			// liste twila des activités a éliminier
                    for(int j=0;j <defference2.size();j++){
                        mot222= mot222+"-"+defference2.get(j).toString()+"\n";
				
			}
                    mot2= mot22+" "+mot222;
                }    
                if(seulle50.size()>0){
                    String mot33 = "Nous recommandons de renommer ces activités si elles seront jugées par l‟utilisateur comme étant les mêmes: \n";
                    String mot333="";
                    for(int w=0;w<seulle50.size();w++){
                    mot333 = mot333+""+seulle50.get(w).toString()+"\n";
                }
                mot3 = mot33+" "+mot333;
                }else{
                mot3 ="";
                }
              if(seulle.size()>0){
                // 4 eme recommandation
                String mot44="Nous recommandons de renommer ces activités par un seul nom : \n"; 
                
                for (int l=0; l<seulle.size(); l++){
                    mot444=mot444+"-"+seulle.get(l).toString()+"\n";
				
                }
                // bech 
                mot4= mot44+" "+mot444;
              }else {
              mot4 = "";
              
              } 
              //23me ok
              if(mot111.equals("")&& mot222.equals("") && mot444.equals("")){
              area.setText("votre BPMo existant est acceptable au niveau des activités");
              
              }else
              {
                  area.setText(mot1 + "\n" +mot2 + "\n" +mot3 + "\n" +mot4);
              }
              //23mel runok
                  
                		pan.add(area);
                conditiontexte = new JLabel(" nous vous conseillons de faire le calcul de similarité comportementale uniquement quand la similarité fonctionnelle est acceptable ");
                JPanel pantext = new JPanel();
                pantext.add(conditiontexte);
                JPanel pancontainer = new JPanel();
                pancontainer.setLayout(new BorderLayout());
                pancontainer.add(panel,BorderLayout.NORTH);
                pancontainer.add(pantext,BorderLayout.CENTER);
                // Créer boutton pour calculer la sim comportementale
		JButton btt = new JButton("Calculer la similarité comportementale");
                // créer actionlistener pour que le boutton btt va vers l'interface de tableau des footprints comportementale
                btt.addActionListener(new controlbtt());
		JPanel pannn = new JPanel();
		pannn.setLayout(new FlowLayout());
		pannn.add(btt);
                pannn.add(button2);
		this.setLayout(new BorderLayout());
		this.add(pan,BorderLayout.NORTH);
		this.add(pancontainer, BorderLayout.CENTER);
		this.add(pannn, BorderLayout.SOUTH);

		
		this.setTitle("Recommandations Fonctionnelles");
		this.setLocation(100,100);
		this.setSize(1000, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.show();
	}
        // methode existence1 qui renvoit comme resultat list ( type arraylist) 
	
	public ArrayList  Existance1 (ArrayList liste1 ,ArrayList liste2){
		ArrayList defference = new ArrayList<>();
		for (int i =0 ;i<liste1.size();i++){
			String mot = liste1.get(i).toString();
			
			
				boolean verif = liste2.contains(mot);
				if(verif){
					System.out.println("le mot"+mot+" est dans le deux liste");
				}else {
					defference.add(mot);
				
			}		}
		
		return defference;
	}
        public class Controlparcourir implements ActionListener
        {

        @Override
        public void actionPerformed(ActionEvent e) {
             // parcourir le deuxiÃ¨me ficher file2 
            JFileChooser file2 = new JFileChooser();
            file2.setApproveButtonText("choisir le  2 ème fichier ");
            file2.showOpenDialog(null); 
             
           
            // test si le fichier est choisi pour afficher son path (= emplacement)
            if ((file2.showOpenDialog(null)) == JFileChooser.APPROVE_OPTION)
            {
            textparcourir.setText(file2.getSelectedFile().getName());
            }
        }
            
        }
        public class testerfonctionnelle implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        listxml22 = new ArrayList();
          listxml2 = new ArrayList();
          
          degre = new ArrayList();
          moy = new ArrayList();
          seulle = new ArrayList();
          seulle11 = new ArrayList();
          seulle50 = new ArrayList();
            try{
                                                                                                       
             DocumentBuilder build = factory.newDocumentBuilder();
                   
              // extraire le nom de 1er fichier selectionner 
            Document doc =build.parse("C:\\Users\\jihed\\Desktop\\sabraproj\\"+textparcourir.getText());
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
        
           //system.out.println(var.getAttribute("name")); 
            listxml22.add(var.getAttribute("name"));
               System.out.println(var.getAttribute("name")); 
               }
           
            System.out.println("le liste2 est ");
           for (int y=0; y<listxml2.size();y++)
           {
               System.out.println(listxml2.get(y));            
           }
             //////////////// Run teste recommandation fonctionnelle  
          
                   
                 
            
        } catch (SAXException ex) {
            // afficher message d'esception ex
             System.out.println(ex.getMessage());
        }catch (IOException ex) {
            // afficher message d'esception ex                
                       System.out.println(ex.getMessage());
        }   catch (ParserConfigurationException ex) {
                Logger.getLogger(RecommandationFonctionnelle.class.getName()).log(Level.SEVERE, null, ex);
            }
        
            
            //// parcour fichier et teste avec xml1
               for (int l1=0; l1< liste1.size(); l1++)
            {
                for ( int l2=0; l2< listxml22.size(); l2++)
                {
        String word1= liste1.get(l1).toString();
        String word2=listxml22.get(l2).toString();     
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
        
                seulle11.add("changer le nom ce l'acitivite "+word1+" par "+word2+" "+Math.round(((1- EDString /len2)*100))+"%");
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
        int taille1 = liste1.size();
        int taille2 = listxml22.size();
            System.out.println("taille1 ="+taille1+" taille2 = "+taille2);
            matrice = new String[mat][5];
            // x est la colonne 
            int x=0;
                for ( int w=0; w<taille1; w++)
                {
                     matrice[w][x]= liste1.get(w).toString(); }
                x++;
                for ( int l=0; l<taille2; l++)
                {
                     matrice[l][x]= listxml22.get(l).toString(); }
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
       tableau tabb = new tableau (tableau,matrice,liste1,listxml22,seulleval,moy,seulle50,seulle11,nomXml);
       tabb.show();
            
            
            
            
        
        }
        }
        public class controlbtt implements ActionListener
        {

        @Override
        public void actionPerformed(ActionEvent e) {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            
        listxml2 = new ArrayList(); 
             try{
                                                                                                       
             DocumentBuilder build = factory.newDocumentBuilder();
                   
              // extraire le nom de 1er fichier selectionner 
            Document doc =build.parse("C:\\Users\\jihed\\Desktop\\sabraproj\\"+textparcourir.getText());
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
        
           //system.out.println(var.getAttribute("name")); 
            listxml2.add(var.getAttribute("name"));
               System.out.println(var.getAttribute("name")); 
               }
           
            System.out.println("le liste2 est ");
           for (int y=0; y<listxml2.size();y++)
           {
               System.out.println(listxml2.get(y));            
           }
             //////////////// Run teste recommandation fonctionnelle  
           System.out.println("Run test recommandation fonctionelle");
           System.out.println("******************************************************");
           for(int i=0;i<listxml2.size();i++){
           System.out.println("kkkkk "+listxml2.get(i).toString());
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
             // 
             nomxml2 = textparcourir.getText();
             System.out.println("les des activites sont kkkkkkkkkkkkkkkkkkkkk"+nomXml+"et "+nomxml2);
             similaritercomportementale sim = new similaritercomportementale(liste1, listxml2,nomXml,nomxml2);
        
    }
            
        }
}
