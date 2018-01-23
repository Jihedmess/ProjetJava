package Projetmaster;

import java.util.ArrayList;
import java.util.Vector;

public class similaritercomportementale {
	public ArrayList liste1 , liste2;
	ArrayList chart ,chart2 ,simelarite1;
	String G1="",G2="",G3="";
	String G11="",G21="",G31="";
	String tableau[]={"Activités de Modele 1", "Activités de Modele 2 ","Footprint de modele 1 ","Footprint de modele 2","similarité comportementale"};
    String matrice[][];
    String nomXml,nomxml2;
    ArrayList paralele,paralele1;
    ArrayList fichiermotcompletehead,fichiermotcompletehead1,fichiermotcompleteback,fichiermotcompleteback1;
    /*
     * ArrayList fichiermotcompletehead = new ArrayList<>();
        ArrayList fichiermotcompletehead1 = new ArrayList<>();
       
        ArrayList fichiermotcompleteback = new ArrayList<>();
        ArrayList fichiermotcompleteback1 = new ArrayList<>();
       
     */
	public similaritercomportementale(ArrayList liste1 ,ArrayList liste2,String nomXml,String nomxml2){
		this.liste1 = liste1;
                this.nomXml = nomXml;
                this.nomxml2 = nomxml2;
		this.liste2 = liste2;
		simelarite1 = new ArrayList();
		for(int vno =0;vno<liste1.size();vno++){
			for(int vno1=0;vno1<liste2.size();vno1++){
				
					if(liste1.get(vno).toString().equals(liste2.get(vno1).toString())){
						simelarite1.add(liste1.get(vno).toString());
					
					}
					
			}
		}
		for(int xco = 0;xco<simelarite1.size();xco++){
			System.out.println(simelarite1.get(xco).toString());
		}
		ArrayList head1;
                ArrayList que1;
		ArrayList head;
		ArrayList que;
               System.out.println("le nom de xml1 est teste de footttttttttttttttt"+nomXml + "et  "+nomxml2);
               // liste des activitésqui sont en parrallele
                paralele = new parallellegateway().parallele(nomXml);
                paralele1 = new parallellegateway().parallele(nomxml2);
                // exor1 et exor2 liste des activité en parallel( en exor) et xor
                ArrayList exor1 = new xorgateway().exorgateway(nomXml);
                ArrayList exor2 = new xorgateway().exorgateway(nomxml2);
                if(exor1.size()>0){
                 que = new parallellegateway().teste(liste1, exor1);
                 head = new parallellegateway().testelook(liste1,exor1 );
                 for(int bo=head.size()-1;bo >=0;bo--){
			G2 = G2+head.get(bo).toString();
		}
                
                }else if(paralele.size()>0){
               	 
                	
               	
               	 que = new parallellegateway().teste(liste1, paralele);
                    head = new parallellegateway().testelook(liste1,paralele );
                    for(int bo=head.size()-1;bo >=0;bo--){
   			G2 = G2+head.get(bo).toString();
   		}
                  }else{
                	  que= footprint.lookhead(liste1);
             		 head= footprint.lookback(liste1);
                              for(int bo=0;bo <head.size();bo++){
             			G2 = G2+head.get(bo).toString();
             		}
                	  
                  }
                /////////////////////////
                     
                 if(exor2.size()>0){
               que1 = new parallellegateway().teste(liste2,exor2);
               head1 = new parallellegateway().testelook(liste2,exor2);
             for(int bo1=head1.size()-1;bo1>=0;bo1--){
			G21 = G21+head1.get(bo1).toString();
		}
                 
                 }else if(paralele1.size()>0){

                     que1 = new parallellegateway().teste(liste2,paralele1);
                     head1 = new parallellegateway().testelook(liste2,paralele1);
                   for(int bo1=head1.size()-1;bo1>=0;bo1--){
      			G21 = G21+head1.get(bo1).toString();
      		}
                     
                     }       
               else {
            	   que1   = footprint.lookhead(liste2);
            	   head1 = footprint.lookback(liste2);
                           
                           for(int bo1=0;bo1<head1.size();bo1++){
           			G21 = G21+head1.get(bo1).toString();
           		}
                           }
              
		
	               
               
		chart = new ArrayList();
		for(int ko=0;ko<liste1.size();ko++){
			//System.out.println(liste1.get(ko).toString().substring(0,1)+"llllllllllllllllljhkjhkjhkjddddddddddddddddd");
			chart.add(liste1.get(ko).toString().substring(0,1));
		}
		for(int no=0;no<chart.size();no++){
			//System.out.println(chart.get(no).toString()+"kljkjlkjlkjlkjlkjljljmmmmmmmmmmmm");
			if(no<chart.size()-1){
			G1=G1+chart.get(no).toString()+",";
			}else {
				G1=G1+chart.get(no).toString();
			}
		}
		
		for(int co=0;co<que.size();co++){
			G3 = G3+que.get(co).toString();
		}
		/////////////////////////////////////////////////////
		////////////////////////////////////////////
		/////////////////////
		chart2 = new ArrayList();
		for(int ko1=0;ko1<liste2.size();ko1++){
			//System.out.println(liste1.get(ko).toString().substring(0,1)+"llllllllllllllllljhkjhkjhkjddddddddddddddddd");
			chart2.add(liste2.get(ko1).toString().substring(0,1));
		}
		for(int no1=0;no1<chart2.size();no1++){
			//System.out.println(chart.get(no).toString()+"kljkjlkjlkjlkjlkjljljmmmmmmmmmmmm");
			if(no1<chart2.size()-1){
			G11=G11+chart2.get(no1).toString()+",";
			}else {
				G11=G11+chart2.get(no1).toString();
			}
		}
		
		for(int co1=0;co1<que1.size();co1++){
			G31 = G31+que1.get(co1).toString();
		}
		//System.out.println("{"+G1+"}");
		//System.out.println(G2+"kolllllllllllllllllllllllll");
		//System.out.println(G3+"mlkmlqkmlqkmlkm");
		String model1 = "G1 = {{"+G1+"},"+"{"+G2+"},"+"{"+G3+"}}";
		String model11 = "G2 = {{"+G11+"},"+"{"+G21+"},"+"{"+G31+"}}";
                String modelle1 = "{{"+G1+"},"+"{"+G2+"},"+"{"+G3+"}}";
                String modelle2 = "{{"+G11+"},"+"{"+G21+"},"+"{"+G31+"}}";
		System.out.println(model1);
		
        ArrayList simcoportementale = new ArrayList<>();
        ArrayList fichiermotcompletehead = new ArrayList<>();
        ArrayList fichiermotcompletehead1 = new ArrayList<>();
        ArrayList fichiermotcompleteback = new ArrayList<>();
        ArrayList fichiermotcompleteback1 = new ArrayList<>();
        ///////////////////////////////////////////////////
        ArrayList deffereneceentre2et1 = new ArrayList<>();
        ArrayList fichiermotcompleteheadtest = new ArrayList<>();
        ArrayList fichiermotcompletehead1test = new ArrayList<>();
        ArrayList fichiermotcompletebacktest = new ArrayList<>();
        ArrayList fichiermotcompleteback1test = new ArrayList<>();
             
         /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        
        
        if(paralele.size()>0 ){
    	  fichiermotcompletehead = new parallellegateway().testelookmot1(liste1, paralele) ;
    	  fichiermotcompleteheadtest = new parallellegateway().testelookmot1(liste1, paralele) ;
    	   for(int du =0;du<fichiermotcompletehead.size();du++){
    	   	      System.out.println("fichiermotcompletehead"+fichiermotcompletehead.get(du));
    	   }
    	   
    	   
    	   }else if (exor1.size()>0){
    		   fichiermotcompletehead = new parallellegateway().testelookmot1(liste1, exor1);
    		   fichiermotcompleteheadtest = new parallellegateway().testelookmot1(liste1, exor1) ;
    		   
        	   }else {
        		   fichiermotcompletehead = new footprint().lookheadmotcomplete(liste1);
        		   fichiermotcompleteheadtest = new footprint().lookheadmotcomplete(liste1);
        	   }
       if(paralele1.size()>0){
    	   fichiermotcompletehead1= new parallellegateway().testelookmot1(liste2, paralele1);
    	   fichiermotcompletehead1test= new parallellegateway().testelookmot1(liste2, paralele1);
    	   
       }else if(exor2.size()>0){
    	   fichiermotcompletehead1 = new parallellegateway().testelookmot1(liste2, exor2);
    	   fichiermotcompletehead1test = new parallellegateway().testelookmot1(liste2, exor2);
       }else {
    	   
    	   fichiermotcompletehead1 = new footprint().lookheadmotcomplete(liste2);
    	   fichiermotcompletehead1test = new footprint().lookheadmotcomplete(liste2);
       }
    		   
    	   
       
       for(int tu = 0;tu<fichiermotcompletehead1.size();tu++){
    	   for(int eu=0;eu<fichiermotcompletehead.size();eu++){
    		   
    		   if(fichiermotcompletehead1.get(tu).toString().equals(fichiermotcompletehead.get(eu).toString())){
    			   simcoportementale.add(fichiermotcompletehead1.get(tu).toString());
    		   }
    	   }
    	   
       }
       ///////////////////////////////////////////////////////////////////
       ///////////////////////////////////////////////////////////////////
       ///////////////////////////////////////////////////////////////////
       
       if(paralele.size()>0 ){
	      	  fichiermotcompleteback = new parallellegateway().testelookmot2(liste1, paralele) ;
	      	fichiermotcompletebacktest = new parallellegateway().testelookmot2(liste1, paralele) ;
	      	   for(int du =0;du<fichiermotcompletehead.size();du++){
	      	   	      System.out.println("fichiermotcompletehead"+fichiermotcompletehead.get(du));
	      	   	 for(int tb=0;tb<fichiermotcompleteback.size();tb++){
	          		   System.out.println("les valeur de fichiermotcompleteback sont :"+fichiermotcompleteback.get(tb));}
	      	   
	      	   }
	      	   
	      	   
	      	   }else if (exor1.size()>0){
	      		   fichiermotcompleteback = new parallellegateway().testelookmot2(liste1, exor1);
	      		 fichiermotcompletebacktest = new parallellegateway().testelookmot2(liste1, exor1);
	      		 for(int tb=0;tb<fichiermotcompleteback.size();tb++){
	          		   System.out.println("les valeur de fichiermotcompleteback sont :"+fichiermotcompleteback.get(tb));}
	      		   
	          	   }else {
	          		   fichiermotcompleteback = new footprint().lookheadmotcomplete(liste1);
	          		 fichiermotcompletebacktest = new footprint().lookheadmotcomplete(liste1);
	          		   for(int tb=0;tb<fichiermotcompleteback.size();tb++){
	          		   System.out.println("les valeur de fichiermotcompleteback sont :"+fichiermotcompleteback.get(tb));
	          	   }}
	         if(paralele1.size()>0){
	      	   fichiermotcompleteback1= new parallellegateway().testelookmot2(liste2, paralele1);
	      	 fichiermotcompleteback1test= new parallellegateway().testelookmot2(liste2, paralele1);
	      	 for(int tb=0;tb<fichiermotcompleteback1.size();tb++){
       		   System.out.println("les valeur de fichiermotcompleteback111 sont :"+fichiermotcompleteback1.get(tb));}
   	   
	         }else if(exor2.size()>0){
	      	   fichiermotcompleteback1 = new parallellegateway().testelookmot2(liste2, exor2);
	      	 fichiermotcompleteback1test = new parallellegateway().testelookmot2(liste2, exor2);
	      	 for(int tb=0;tb<fichiermotcompleteback1.size();tb++){
       		   System.out.println("les valeur de fichiermotcompleteback111 sont :"+fichiermotcompleteback1.get(tb));}
   	   
	         }else {
	      	   
	      	   fichiermotcompleteback1 = new footprint().lookbackmotcomplete(liste2);
	      	 fichiermotcompleteback1test = new footprint().lookbackmotcomplete(liste2);
	      	 for(int tb=0;tb<fichiermotcompleteback1.size();tb++){
       		   System.out.println("les valeur de fichiermotcompleteback111 sont :"+fichiermotcompleteback1.get(tb));}
   	   
	         }
	      		   
	      	   
	         
	         for(int tu = 0;tu<fichiermotcompleteback1.size();tu++){
	      	   for(int eu=0;eu<fichiermotcompleteback.size();eu++){
	      		   
	      		   if(fichiermotcompleteback1.get(tu).toString().equals(fichiermotcompleteback.get(eu).toString())){
	      			   simcoportementale.add(fichiermotcompleteback1.get(tu).toString());
	      		   }
	      	   }
	      	   
	         }
	         for(int ji =0;ji<simcoportementale.size();ji++){
	         System.out.println("simulariter comportementale finalle :"+simcoportementale.get(ji).toString());
	         }
	             
	           
	            
       
       
           // ArrayList simcoporte = new parallellegateway().caluculersimcomportpara();
           /* int g = parallehead.size();
            int l1 = parallefoot.size();
            if(g>l1){
        for( g=0;g<parallehead.size();g++){
        for( l1=0;l1<parallefoot.size();l1++){
        if(parallehead.get(g).toString().equals(parallefoot.get(l1).toString())){
        
        simcoporte.add(parallehead.get(g).toString());
                
        }
        }
        }}else{
            for( l1=0;l1<parallehead.size();l1++){
        for( g=0;g<parallefoot.size();g++){
        if(parallehead.get(g).toString().equals(parallefoot.get(l1).toString())){
        
        simcoporte.add(parallehead.get(g).toString());
                
        }
        }
        }
            }*/
           // comparaison entre footprint 1 g1 et footprint g2 pour détérminer la différence partiel (utilie pr la recommandation)
	        
           //remove list back 1 et back2les parties similaires pour garder la différents parties
           fichiermotcompleteback1test.removeAll(fichiermotcompletebacktest);
            //remove list ahead 1 et 2 les parties similaires pour garder la différents parties
	         fichiermotcompletehead1test.removeAll(fichiermotcompleteheadtest);
	         fichiermotcompleteback1test.addAll(fichiermotcompletehead1test);
                 // concatenation entre list back2-1 et ahead 2-1 pour les afficher dans la recommandation de similarité partielle
	         deffereneceentre2et1.addAll(fichiermotcompleteback1test);
	         System.out.println("le defference entre le liste 2 et liste 1---------------");
	         for(int ip=0;ip<deffereneceentre2et1.size();ip++){
	        	 System.out.println(deffereneceentre2et1.get(ip).toString());
	         }
	         System.out.println("le defference entre le liste 2 et liste 1---------------");
	         
          
                                int taille1 = liste1.size();
				int taille2 = liste2.size();
				int taille3 = simcoportementale.size();
		        
				 if(taille1 > taille2 && taille1>taille3){
		        	   matrice = new String[taille1][5];   
		           }else if(taille3 > taille2 && taille3>taille1){
		        	   matrice = new String[taille3][5];
				}else {
					 matrice = new String[taille2][5];
				}           
// x est la colonne 
            int x=0;
                for ( int w=0; w<liste1.size(); w++)
                {
                     matrice[w][x]= liste1.get(w).toString(); }
                x++;
                for ( int l=0; l<liste2.size(); l++)
                {
                     matrice[l][x]= liste2.get(l).toString(); }
                x++;
                
               
                    matrice[0][x]= model1;
               
                x++;
                
                	matrice[0][x]=model11;
                
                x++;
                if(simcoportementale.size()>0){
	               for(int b =0;b<simcoportementale.size();b++){
	                	matrice[b][x]=simcoportementale.get(b).toString();
	                }}else{
	                	matrice[0][x]="pas de similarité";
	                }
               /*
                *  ArrayList fichiermotcompletehead = new ArrayList<>();
        ArrayList fichiermotcompletehead1 = new ArrayList<>();
       
        ArrayList fichiermotcompleteback = new ArrayList<>();
        ArrayList fichiermotcompleteback1 = new ArrayList<>();
               */
             tableaufoot tab = new tableaufoot(tableau, matrice,simelarite1,liste2, nomXml, simcoportementale, modelle1, modelle2,paralele,paralele1,exor1,exor2, deffereneceentre2et1, liste1) ; 
            
		

		
	}

}