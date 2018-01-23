/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projetmaster;

import java.awt.image.AreaAveragingScaleFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

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
public class parallellegateway {
    ArrayList listefinal1;
    ArrayList arraylistefinal2;
    public ArrayList parallele(String xml){
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
            NodeList listevents = racine.getElementsByTagName("parallelGateway"); 
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
// G1 = {(o,r,v,s),{({o} ,r)({r} ,v)({r} ,s)},{(o,{r})(r,{v, s})}}
    return listtaks;
            
    }
    
    public ArrayList teste (ArrayList array ,ArrayList array2){
    	int h=0;
        
		 int j=0;
		 ArrayList listed = new ArrayList<>();
		 for(int i= 0 ;i<array.size()-1;i++)
		 {
			 
			 String ch = "";
			 if(array.get(i).equals(array2.get(h)))
			 {
				 if(i+2<array.size())
				 {
				 ch="{"+array.get(i).toString().substring(0,1)+",{"+array.get(i+2).toString().substring(0,1)+"}}";
				 listed.add(ch);
                                 
				 ch="{"+array.get(i+1).toString().substring(0,1)+" ,{"+array.get(i+2).toString().substring(0,1)+"}}";
				 listed.add(ch);
                                 
				 i=i+1;
				 }
			 }else
			 if(array.get(i+1).equals(array2.get(h)))
			 {
				 ch = "{"+array.get(i).toString().substring(0,1)+", {"+array2.get(h).toString().substring(0,1)+" , "+array2.get(h+1).toString().substring(0,1)+"}}";
				 listed.add(ch);
                                 
			 }else
				 {
					 ch="{"+array.get(i).toString().substring(0,1)+"  ,{"+array.get(j+i+1).toString().substring(0,1)+"}}";
					 listed.add(ch);
                                        
				 }
			
			
		 }
		
		  

		
	
    	
    	return listed;
    }
    
    public ArrayList testelook (ArrayList array ,ArrayList array2){
    	ArrayList listed = new ArrayList<>();
        
        int h=array2.size()-1;
		
		 for(int i=array.size()-1 ;i>0;i--)
		 {
			 
			 String ch = "";
			 if(array.get(i).equals(array2.get(h)))
			 {
				 if(i-2>0)
				 {
				 ch="{{"+array.get(i-2).toString().substring(0,1)+" },"+array.get(i).toString().substring(0,1)+"}";
				 listed.add(ch);
                                 
				 ch="{{"+array.get(i-2).toString().substring(0,1)+"},"+array.get(i-1).toString().substring(0,1)+"}";
				 listed.add(ch);
                                 
				 i=i-1;
				 }
			 }else
			 if(array.get(i-1).equals(array2.get(h)))
			 {
				 ch = "{{"+array.get(h).toString().substring(0,1)+"},"+array2.get(i).toString().substring(0,1)+"}";
				 listed.add(ch);
                                 
                                 
				 ch = "{{"+array.get(h-1).toString().substring(0,1)+" },"+array2.get(i).toString().substring(0,1)+"}";
				 listed.add(ch);
                                 
				 
			 }else
				 {
					 ch="{{"+array.get(i-1).toString().substring(0,1)+" },"+array.get(i).toString().substring(0,1)+"}";
					 listed.add(ch);
                                         
				 }
			// 
		 }
		
		  
		    		  
    	return listed;
    } 
    
    public ArrayList testelookmot1 (ArrayList array ,ArrayList array2){
ArrayList listed = new ArrayList<>();
        
        int h=array2.size()-1;
		
		 for(int i=array.size()-1 ;i>0;i--)
		 {
			 
			 String ch = "";
			 if(array.get(i).equals(array2.get(h)))
			 {
				 if(i-2>0)
				 {
				 ch= array.get(i-2).toString()+" et "+array.get(i).toString()+" et "+array.get(i-1).toString();
				 listed.add(ch);
				 System.out.println("1/la valeur de ch est :"+ch);
                                 
				 //ch= array.get(i-2).toString()+" "+array.get(i-1).toString();
				 //listed.add(ch);
                                 
				 i=i-1;
				 }
			 }else
			 if(array.get(i-1).equals(array2.get(h)))
			 {
				 ch = array.get(h).toString()+" et "+array2.get(i).toString();
				 listed.add(ch);
				 System.out.println("2/la valeur de ch est :"+ch);               
		                 // arraylistfinal contient les noms de toutes les activités 
                                 
				 ch = array.get(h-1).toString()+" et "+array2.get(i).toString();
				 listed.add(ch);
				 System.out.println("3/la valeur de ch est :"+ch);
				 
			 }else
				 {
					 ch= array.get(i-1).toString()+" et "+array.get(i).toString();
					 listed.add(ch);
					 System.out.println("4/la valeur de ch est :"+ch);
                                         
				 }
			// 
		 }
		
		  
		    		  
    	return listed;
    } 
    
    public ArrayList testelookmot2 (ArrayList array ,ArrayList array2){
    	
        ArrayList arraylistefinal2 = new ArrayList();
        int h=array2.size()-1;
		
		 for(int i=array.size()-1 ;i>0;i--)
		 {
			 
			 String ch = "";
			 if(array.get(i).equals(array2.get(h)))
			 {
				 if(i-2>0)
				 {
				
                                 arraylistefinal2.add(array.get(i-2).toString()+" et "+array.get(i).toString());
				 
                                 arraylistefinal2.add(array.get(i-2).toString()+" et "+array.get(i-1).toString());
				 i=i-1;
				 }
			 }else
			 if(array.get(i-1).equals(array2.get(h)))
			 {
                                 // arraylistfinal contient les noms de toutes les activités 
                                 arraylistefinal2.add(array.get(h).toString()+" et "+array2.get(i).toString());
				 
                                 arraylistefinal2.add(array.get(h-1).toString()+" et "+array2.get(i).toString());
				 
			 }else
				 {
                                         arraylistefinal2.add(array.get(i-1).toString()+" et "+array.get(i).toString());
				 }
			// 
		 }
		
		 for(int f=0 ;f<arraylistefinal2.size();f++)
		 {
			 System.out.println("dfdfdf"+arraylistefinal2.get(f));
		 }
		 
		    		  
    	return arraylistefinal2;
    } 
    
    
}
