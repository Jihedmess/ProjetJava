package Projetmaster;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;

public class footprint {

	
public static ArrayList lookhead (ArrayList array){
    
        int x = array.size()-1;
	String g = "";
	ArrayList list  =  new ArrayList();
	int i =0;
	while ((i+1) < array.size()){
		String val = "("+"{"+array.get(i).toString().substring(0,1)+"} ,"+array.get(i+1).toString().substring(0,1)+")";
		list.add(val);
		g= g+val;
	i++;	
	}
	//list.add("({"+array.get(x).toString().substring(0,1)+"})");
	//list.add(g);
	return list;
}

public static ArrayList lookheadmotcomplete (ArrayList array){
    
    int x = array.size()-1;
String g = "";
ArrayList list  =  new ArrayList();
int i =0;
while ((i+1) < array.size()){
	String val = array.get(i).toString()+" et "+array.get(i+1).toString();
	list.add(val);
	g= g+val;
i++;	
}
//list.add("({"+array.get(x).toString().substring(0,1)+"})");
//list.add(g);
return list;
}
public static ArrayList lookback (ArrayList array){
	int x = array.size()-1;
	String g= "";
	ArrayList list  =  new ArrayList();
	int i =0;
	while ((i+1) < array.size()){
		String val = "("+array.get(i).toString().substring(0,1)+ ","+"{"+array.get(i+1).toString().substring(0,1)+"})";
		list.add(val);
		g = g+val;
	i++;	
	}
	//list.add(g);
	
	return list;
}
public static ArrayList lookbackmotcomplete (ArrayList array){
	int x = array.size()-1;
	String g= "";
	ArrayList list  =  new ArrayList();
	int i =0;
	while ((i+1) < array.size()){
		String val = array.get(i).toString()+ " et "+array.get(i+1).toString();
		list.add(val);
		g = g+val;
	i++;	
	}
	//list.add(g);
	
	return list;
}

}
