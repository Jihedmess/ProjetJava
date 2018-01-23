package Projetmaster;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.TableColumn;

public class tableaufoot extends JFrame {
    
    String titre[];
    String objet[][];
 ArrayList listeSimilarite,liste2;    
 String nomxml1;
 ArrayList simconporte;
 String model1,model11;
    ArrayList para1,para2,exor1,exor2;
    ArrayList deffereneceentre2et1;
    ArrayList liste1; 
   // creer un constructeur de la classe tableau
   public tableaufoot(String titre[], String objet[][],ArrayList listeSimilarite,ArrayList liste2,String nomxml1, ArrayList simconporte,String model1,String model11,ArrayList para1,ArrayList para2,ArrayList exor1,ArrayList exor2, ArrayList deffereneceentre2et1, ArrayList liste1) {
  // parametrer tailleet titre du frame
   	JPanel pan = new JPanel();
   	ArrayList simcoportementale = new ArrayList<>();
   	pan.setLayout(new BorderLayout());
        this.exor1 = exor1;
        this.exor2 = exor2;
        this.para1 = para1;
        this.para2 = para2;
   	this.nomxml1 = nomxml1;
   	this.simconporte = simconporte;
        this.model1 = model1;
        this.model11 = model11;
        this.deffereneceentre2et1 = deffereneceentre2et1;
        this.liste1 = liste1;
    /*for(int tu = 0;tu<fichiermotcompleteback1.size();tu++){
 	   for(int eu=0;eu<fichiermotcompleteback.size();eu++){
 		   
 		   if(fichiermotcompleteback1.get(tu).toString().equals(fichiermotcompleteback.get(eu).toString())){
 			   simcoportementale.add(fichiermotcompleteback1.get(tu).toString());
 		   }
 	   }
 	   
    }
    

    for(int tu = 0;tu<fichiermotcompletehead1.size();tu++){
 	   for(int eu=0;eu<fichiermotcompletehead.size();eu++){
 		   
 		   if(fichiermotcompletehead1.get(tu).toString().equals(fichiermotcompletehead.get(eu).toString())){
 			   simcoportementale.add(fichiermotcompletehead1.get(tu).toString());
 		   }
 	   }
 	   
    }*/
   	
   this.setSize(120,300);
   this.setTitle("Calcul de similarité comportementale entre BPMo existant et BPMo de référence");
   this.listeSimilarite = listeSimilarite;
   this.liste2 = liste2;
  
   JButton button = new JButton("Recommandations Comportementales");
   button.addActionListener(new TesterSimulariterComportementalle());
  /* button.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	RecommandationsComportementales conseille = new RecommandationsComportementales(listeSimilarite,liste2,nomxml1);
        }
});*/
   //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); => on ecrit ca si la fenetre d'exécution ne se ferme pas qu'on je click sur le croix rouge
   // affichage de run en plein ecran
   this.setLocationRelativeTo(null);
   this.titre = titre;
   this.objet= objet; 
    // creer instance tableau de classe Jtable
       JTable table = new JTable(objet, titre);
      
       TableColumn columm = null;
       for(int i=0;i<5;i++){
    	   columm = table.getColumnModel().getColumn(i);
    	   if(i==0 || i==1||i==4){
    		   columm.setPreferredWidth(20);
    	   }
       }
       JScrollPane tablecontaner = new JScrollPane(table);
      
       
       pan.add(tablecontaner,BorderLayout.CENTER);
       pan.add(button, BorderLayout.SOUTH);
       // this.getContentPane().add(new JButton("CENTER"), BorderLayout.CENTER);
   //ajou1ter tableau au frame
      // this.getContentPane().add(new JScrollPane(table));
       this.add(pan);
      this.pack();
       this.show();
}
  public class TesterSimulariterComportementalle implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		RecommandationsComportementales conseille = new RecommandationsComportementales(listeSimilarite,liste2,nomxml1,simconporte, model1, model11,para1,para2,exor1,exor2, deffereneceentre2et1, liste1);
	}
	  
  }

}
