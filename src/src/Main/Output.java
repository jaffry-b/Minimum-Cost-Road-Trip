package Main;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;

import Graphing.BreadthFirstDirectedPaths;
import Graphing.DepthFirstDirectedPaths;
import Graphing.DijkstraSP;
import Graphing.DirectedEdge;
import Graphing.EdgeWeightedDigraph;
import Graphing.SymbolDigraph;
import Input.IOStreamMenu;
//This is the main file, run this to see everything.
public class Output {
	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
    	SymbolDigraph st = new SymbolDigraph("connectedCities.txt",", ");
    	int start = 0;
    	DijkstraSP sp = new DijkstraSP(st.digraph(), start);
   
    	String menu[][] = IOStreamMenu.ParseMenu();
    	int i = 0;
         
     	EdgeWeightedDigraph newGraph  = new EdgeWeightedDigraph(32);
     	
     	for (DirectedEdge curEdge : sp.pathTo(22)) {
     		if(i%2 == 0) {
     			curEdge.setWeight(Double.parseDouble(menu[1][0]));
	     		DirectedEdge newEdge = new DirectedEdge(curEdge.from(),curEdge.to(),curEdge.weight());
	     		newGraph.addEdge(newEdge);
	     		i++;
     		}else if(i%2 == 1) {
     			curEdge.setWeight(Double.parseDouble(menu[1][1]));
	     		DirectedEdge newEdge = new DirectedEdge(curEdge.from(),curEdge.to(),curEdge.weight());
	     		newGraph.addEdge(newEdge);
	     		i++;
     		}
       	}
     	
     	DijkstraSP sp2 = new DijkstraSP(newGraph,start);
     	PrintWriter writer = new PrintWriter("a2_out.txt", "UTF-8");
     	int counter = 0;
     	writer.println("City                                     MealChoice                          Cost of Meal");
     	writer.println("==========================================================================================");
     	int j =0;
     	String finalNode = "";
     	for (DirectedEdge curEdge : sp2.pathTo(22)) {
     		if(counter>0) {
	     		if(j%2 == 0) {
	     			  writer.println();
			       	 writer.format("%5s%50s%20s",st.nameOf(curEdge.from()),menu[0][0], menu[1][0]  );	
			       	 System.out.println();
					 j++;
	     		} else if(j%2 == 1) {
	     			  writer.println();
	     		        writer.println();
	     			writer.format("%5s%60s%18s",st.nameOf(curEdge.from()),menu[0][1], menu[1][1]  );	
	     			writer.println();
					j++;
	     		}
	     		 finalNode = st.nameOf(curEdge.to());
     		}
     		else {
     			writer.format("%5s%40s%40s",st.nameOf(curEdge.from()),"N/A", "N/A"  );	
     			writer.println();
     		}
     		counter++;
       	}
     	writer.println();
     	writer.format("%5s%55s%18s",finalNode, menu[0][0], menu[1][0]  );
     	writer.println();
     	writer.println();
       writer.println("Boston to Minneapolis " + " total cost is $" + sp2.distTo(22));
        System.out.println();
        //*********************************************************************
        //*********************Writing to a2_out.txt**************************//
        writer.println();
        writer.println();
    	String s = "";
    	String s1 = "";
    	
    	DepthFirstDirectedPaths dfs = new DepthFirstDirectedPaths(st.regdigraph(),st.indexOf("Boston"));
    	Iterator<Integer> b = dfs.pathTo(22).iterator();
    	
    	while(b.hasNext()) {
    		 s = s + st.nameOf(b.next()) + " ";
    	}
    	writer.println("DFS: " + s);
        
    	BreadthFirstDirectedPaths bfs = new BreadthFirstDirectedPaths(st.regdigraph(),st.indexOf("Boston"));
    	Iterator<Integer> a = bfs.pathTo(22).iterator();
    	
    	while(a.hasNext()) {
    		s1 = s1 + st.nameOf(a.next()) + " ";
    	}
    	writer.println("BFS: 	" + s1);
    	writer.close();
    
    }
}
