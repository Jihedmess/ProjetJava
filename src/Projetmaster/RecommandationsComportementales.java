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

public class RecommandationsComportementales extends JFrame implements ActionListener{
    ArrayList listeSimalaite,liste2,listxml2,chart,chart2;
    String tableau[]={"Activités de Modele 1", "Activités de Modele 2 ","Footprint de modele 1 ","Footprint de modele 2","similarité comportementale"};
    String matrice[][];
    String mot1 = "";
    String mot2="";
    String mot3 = "";
    String nomXml ="";
    String nomXml2mod = "";
    String Xml2Modifier = "";
    JButton test;
    JButton parcourirtest;
    JButton exit; 
    JTextField text;
    JLabel conditiontext;
    ArrayList que,que2;
    ArrayList head,head2;
    String G2="",G1="",G3="",G22="",G12="",G32="",G31="",G21="",G11="";
    String nomxml1;
    String model1,model11;
    ArrayList simcoportementale,para1,para2,exor1,exor2,paralele,paralele1;
    ArrayList deffereneceentre2et1,simelarite1;
    ArrayList liste1; 
	public RecommandationsComportementales (ArrayList listeSimalaite,ArrayList liste2,String nomxml1,ArrayList simcoportementale,String model1,String model11, ArrayList para1,ArrayList para2,ArrayList exor1,ArrayList exor2, ArrayList deffereneceentre2et1, ArrayList liste1){
            
            
		JTextArea area = new JTextArea(15,20);
                this.listeSimalaite = listeSimalaite;
                this.nomxml1 = nomxml1;
                this.liste2 = liste2;
            	this.simcoportementale = simcoportementale;
                this.model1 = model1;
                this.model11 = model11;
                this.exor1 = exor1;
                this.exor2 = exor2;
                this.para1 = para1;
                this.para2 = para2;
                this.deffereneceentre2et1 = deffereneceentre2et1;
                this.liste1 = liste1; 
            	String mot222 = "";
                String mot22 = "le comportement du modèle existant est partiellement corecte par rapport le modèle de référence : ";
                
            	 System.out.println("la taille de fichier simcoporttttt est "+simcoportementale.size());
            	 if(simcoportementale.size()>0){
              	   System.out.println("la taille de fichier simcoporttttt est "+simcoportementale.size());
              	   for(int er =0;er<simcoportementale.size();er++){
              		   mot222 = mot222+" "+simcoportementale.get(er);
              	   }
                 }
                   
            	 int val = listeSimalaite.size();
            	 String mot11= "-	Nous recommandons de réordonner toutes les activités de votre modèle 2 (xml2) : \n";
                 String mot111 = "";
                
               if(val == 0){
                   for (int i=0; i< liste2.size(); i++)
                   { 
                       mot111=mot111+" "+liste2.get(i).toString()+"\n"; 
                   
                   }
                   
                   
               
               }
               int valsimcoprt = simcoportementale.size();
               String mot33 = "Nous recommandons de réviser l‟ordre de toutes les activités du BPMo existant :  \n ";
               String mot333 = "";
               if(valsimcoprt == 0){
               for(int so =0; so<liste2.size();so++){
               mot333 = mot333 + " - "+liste2.get(so).toString()+"\n";
               }
               }
               mot1 = mot11 +" "+mot111;
               mot2 = mot22+":\n"+mot222;
               mot3 = mot33 +" "+mot333;
                int p1 = para1.size();
               int p2 = para2.size();
               int e1 = exor1.size();
               int e2 = exor2.size();
               String paralele ="" ;
               String mot4="";
                String aucungateway="";
                String eexor ="" ;
                String difference="";
               System.out.println(model1+" le model de comparaison "+model11);
               if(model1.equals(model11) ){
                mot4= "Le modèle existant est acceptable.\n";
               }else {
             String   mot44 = "Le modèle existant partiellement correcte par rapport au BPMo de référence : \n";
             String mot444 ="";
             for(int go =0;go<simcoportementale.size();go++){
             mot444 = mot444+ "-"+simcoportementale.get(go).toString()+"\n";
             }
             mot4 = mot44+" "+mot444;
              if(p1>0){
               String paralele1 = "Le modèle de référence contient un gateway (Parallele Gateway) entre les activités suivantes";
               String actparalle ="";
               for(int po=0;po<p1;po++){
               actparalle = actparalle+" - "+para1.get(po).toString()+"\n";
               }
               paralele = paralele1 +"\n"+actparalle;
               }
                   if (p1==0 && e1==0) 
               { 
                  
                  String aucungateway1= "Le modèle de référence ne contient aucun gateway. Nous vous recommandons de réviser l‟ordre des activités suivantes :";
                  String aucungateway2=""; 
                  
                  for (int ippp=0; ippp < liste1.size(); ippp++)
             {
                 aucungateway2 = aucungateway2 + "-"+liste1.get(ippp).toString()+"\n";    
             }
              aucungateway = aucungateway1 +"\n"+ aucungateway2; 
               
               }
                    if(e1>0){
               String eexor1 = "Le modèle de référence contient un gateway (XOR Gateway) entre les activités suivantes";
               String actexor ="";
               for(int po=0;po<e1;po++){
               actexor = actexor+" - "+para1.get(po).toString()+"\n";
               }
              eexor = eexor1 +"\n"+actexor;
               }
                      if ( deffereneceentre2et1.size()>0) 
              { 
                  String difference1 = " Nous recommandons de vérifier l‟enchainement des activités qui sont en relation avec les activités suivantes";
               String difference2= ""; 
              for (int ip=0; ip<deffereneceentre2et1.size(); ip++  )
              {
                 difference2 = difference2+"-"+ deffereneceentre2et1.get(ip)+"\n";
                  
              }
              
              difference=difference1 +"\n"+ difference2 ; 
              
              }  
                  
               }
              
             // afficher les activités qui sont dans le gateway parallele AND 
              
              
               // Recommandation dans le cas de aucun gateway et verifier l'ordre des activités suivantes 
              
           
               
               
              
              
              ///////////sabra 
              // afficher les activités qui sont dans le gateway xor 
              
              
               ///////////////////// sabra
                        
              
                      
              
              
              
              
               area.setText(mot4+"\n"+paralele+"\n"+eexor+"\n"+difference+"\n"+aucungateway);
               conditiontext = new JLabel("Si votre modèle est acceptable vous pouvez quitter. Sinon, nous vous conseillons de faire le calcul de similarité comportementale");
               text = new JTextField(30);
		parcourirtest = new JButton("parcourir xml2 à tester");
		parcourirtest.addActionListener(new parcourire());
                test = new JButton("tester la similarité comportementale");
                test.addActionListener(new calculersimularitercomporte());
                exit = new JButton("quitter");
                exit.addActionListener(this);
                JPanel pan = new JPanel();
                JPanel pan8 = new JPanel();
                pan8.setLayout(new BorderLayout());
                pan.setLayout(new FlowLayout());
                pan.add(parcourirtest);
                pan.add(text);
                JPanel pan9 = new JPanel();
                               pan9.add(conditiontext);
                pan8.add(pan,BorderLayout.NORTH);
                pan8.add(pan9,BorderLayout.CENTER);
                
                JPanel pan3 = new JPanel();
                pan3.setLayout(new FlowLayout());
                pan3.add(test);
                pan3.add(exit);
                
                this.setLayout(new BorderLayout());
		this.add(area,BorderLayout.NORTH);
                this.add(pan8,BorderLayout.CENTER);
                this.add(pan3,BorderLayout.SOUTH);
		this.setTitle("Recommandations Comportementales");
		this.setLocation(100,100);
		this.setSize(1000, 800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.show();
                
		
	}
     

    @Override
    public void actionPerformed(ActionEvent e) {
        this.dispose();
        
    }
        
        public class parcourire implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
        	JFileChooser file2 = new JFileChooser();
            file2.setApproveButtonText("choisir le  2 ème fichier ");
            file2.showOpenDialog(null); 
             
           
            // test si le fichier est choisi pour afficher son path (= emplacement)
            if ((file2.showOpenDialog(null)) == JFileChooser.APPROVE_OPTION)
            {
            	text.setText(file2.getSelectedFile().getName());
            }
          
        }
        
        }

      
         public class calculersimularitercomporte implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
				 listxml2 = new ArrayList();
				 try{
                     
		             DocumentBuilder build = factory.newDocumentBuilder();
		                   
		              // extraire le nom de 1er fichier selectionner 
		            Document doc =build.parse("C:\\Users\\jihed\\Desktop\\sabraproj\\"+text.getText());
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
		               System.out.println("les nom dees activites sont :"+listxml2.get(y));            
		           }
		             //////////////// Run teste recommandation fonctionnelle  
		          
		                   
		                 
		            
		        } catch (SAXException ex) {
		            // afficher message d'esception ex
		        	System.out.println("ici l'erreur");
		             System.out.println(ex.getMessage());
		        }catch (IOException ex) {
		        	System.out.println("ici l'erreur");
		            // afficher message d'esception ex                
		                       System.out.println(ex.getMessage());
		        }   catch (ParserConfigurationException ex) {
		        	System.out.println("ici l'erreur");
		                Logger.getLogger(RecommandationFonctionnelle.class.getName()).log(Level.SEVERE, null, ex);
		            }
		         
				////////////////////////////////////////////////////////////////////////////
				System.out.println("le nom de xml 1 de fichier teste est "+nomxml1);
				 similaritercomportementale sil = new similaritercomportementale(liste1, listxml2, nomxml1, text.getText());
        	 
			}}

}
