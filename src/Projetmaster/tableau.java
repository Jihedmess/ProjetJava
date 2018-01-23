package Projetmaster;




 import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;



public class tableau extends JFrame implements ActionListener {
    
 
    ArrayList liste1, liste2,obj1,obj2 ;
     String titre[];
     String objet[][];
    int seulleval;
    ArrayList  seulle;
    ArrayList moyenne;
     ArrayList seulle50;
     String nomXml;
     
    // creer un constructeur de la classe tableau
    public tableau(String titre[], String objet[][] ,ArrayList lis1,ArrayList lis2,int seulleval,ArrayList moyenne,ArrayList seulle50,ArrayList seulle,String nomXml) {
   // parametrer tailleet titre du frame
    	JPanel pan = new JPanel();
    	pan.setLayout(new BorderLayout());
        // taille fenetre interface
    this.setSize(1000,700);
    this.seulle = seulle;
    this.setTitle("Calcul similarité fonctionnelle entre BPMo de référence et BMPo existant");
    this.nomXml = nomXml;
    //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); => on ecrit ca si la fenetre d'exécution ne se ferme pas qu'on je click sur le croix rouge
    // affichage de run en plein ecran
    this.setLocationRelativeTo(null);
    this.titre = titre;
    this.objet= objet; 
    this.liste1 = lis1;
    this.liste2 = lis2;
    this.moyenne = moyenne;
    this.seulle50 = seulle50;
    this.seulleval = seulleval;
    obj1 = new ArrayList();
    for(int i =0;i<liste1.size();i++){
    	obj1.add(liste1.get(i).toString());
    }
    obj2 = new ArrayList();
    for(int i =0;i<liste2.size();i++){
    	obj2.add(lis2.get(i).toString());
    }
    
     // creer instance tableau de classe Jtable
        JTable table = new JTable(objet, titre);
        TableColumn columm = null;
        for(int i=0;i<4;i++){
     	   columm = table.getColumnModel().getColumn(i);
     	   if(i==0 || i==1||i==4){
     		   columm.setPreferredWidth(20);
     	   }
        }
        JScrollPane tablecontaner = new JScrollPane(table);
        JButton RecommandationFo = new JButton("Recommandation Fonctionelle");
        RecommandationFo.addActionListener(new buttonRecpommandation() );
        pan.add(tablecontaner,BorderLayout.NORTH);
        pan.add(RecommandationFo,BorderLayout.SOUTH);
                // this.getContentPane().add(new JButton("CENTER"), BorderLayout.CENTER);
    //ajou1ter tableau au frame
       // this.getContentPane().add(new JScrollPane(table));
        this.add(pan);
        
}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(seulleval == 0){
			JOptionPane.showMessageDialog(this, 
			         "Pas de seulle ",
			         " Alerte ",
			         JOptionPane.WARNING_MESSAGE);
		}else
		{similaritercomportementale sil = new similaritercomportementale(obj1, obj2,nomXml,null);}
		
	}
public class buttonRecpommandation implements ActionListener{
	

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("le nom de fichier est "+nomXml);
		RecommandationFonctionnelle r = new RecommandationFonctionnelle(liste1, liste2, moyenne, seulle50,seulle,nomXml);
		
	}
}   
   
}
   
    

