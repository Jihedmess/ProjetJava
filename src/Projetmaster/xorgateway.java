/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projetmaster;

import java.io.IOException;
import java.util.ArrayList;
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
public class xorgateway {
    
    public ArrayList exorgateway(String xml){
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        // documentbulder est une classe et builder instance de doc
        // builder permet d'utiliser une méthode pour extraire l'url de fichier 
    ArrayList    moy = new ArrayList<Float>(); 
    ArrayList    seulle = new ArrayList();
    ArrayList    list1 = new ArrayList();
    ArrayList outgoing = new ArrayList<>();
    ArrayList listtaks = new ArrayList<>();
        try{
           
             DocumentBuilder build = factory.newDocumentBuilder();
                   
              // extraire le nom de 1er fichier selectionner 
            Document doc =build.parse("C:\\Users\\jihed\\Desktop\\sabraproj\\"+xml);
           // declaration de la racine des element xml a partir de l'instance  doc (=qui contiennt les xml)
            Element racine;
            racine = doc.getDocumentElement();
            // creer une liste contenant les activités dans une list listevents
            NodeList listevents = racine.getElementsByTagName("exclusiveGateway"); 
            // boucle sur la liste pour afficher toutes les activités (=task) de la liste listevents
           for (int i=0; i<listevents.getLength()-1; i++)
           {
               
               Element var = (Element) listevents.item(i);
               NodeList child = var.getElementsByTagName("outgoing");
               for(int w=0;w<child.getLength();w++){
            	  outgoing.add(child.item(w).getTextContent());
               }
               
               }
           
               
          NodeList listetask = racine.getElementsByTagName("task");
          for(int a=0;a<listetask.getLength();a++){
        	  Element b = (Element) listetask.item(a);
        	  NodeList chk = b.getElementsByTagName("incoming");
        	  for(int qs =0;qs<chk.getLength();qs++){
        		  for(int yu=0;yu<outgoing.size();yu++){
        			  if(chk.item(qs).getTextContent().equals(outgoing.get(yu).toString())){
        				  listtaks.add(b.getAttribute("name"));
        			  }
        		  }
        	  }
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
        for(int tu =0;tu<listtaks.size();tu++){
        	System.out.println(listtaks.get(tu));
        }

        return listtaks;
    }
    
}
