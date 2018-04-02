

package Graphing;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

import Input.IOStreamMenu;

/**
 *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *  File was heavily modified to work with edge weighted digraphs. 
 */
public class SymbolDigraph {
    private ST<String, Integer> st;  // string -> index
    private String[] keys;           // index  -> string
    private EdgeWeightedDigraph graph;           // the underlying digraph
    private Digraph regdigraph;

 
     
    public SymbolDigraph(String filename, String delimiter) throws FileNotFoundException {
        st = new ST<String, Integer>();

        // First pass builds the index by reading strings to associate
        // distinct strings with an index	
        Scanner in0 = new Scanner(new File(filename));
        while (in0.hasNext()) {
        	String[] a = in0.nextLine().split(delimiter);
            for (int i = 0; i < a.length; i++) {
                if (!st.contains(a[i]))
                    st.put(a[i], st.size());
            }
        }
        in0.close();
        // inverted index to get string keys in an aray
        keys = new String[st.size()];
        for (String name : st.keys()) {
            keys[st.get(name)] = name;
        }

        // second pass builds the digraph by connecting first vertex on each
        // line to all others
        graph = new EdgeWeightedDigraph(st.size());
        regdigraph = new Digraph(st.size());
        Scanner in  = new Scanner (new File(filename));
        
        while (in.hasNext()) {
            String[] a = in.nextLine().split(delimiter);
            int v = st.get(a[0]);
            for (int i = 1; i < a.length; i++) {
                int w = st.get(a[i]);
                	regdigraph.addEdge(v, w);
                	DirectedEdge e = new DirectedEdge(v,w,1.0);
                	graph.addEdge(e);
                }
            }
        
        in.close();
    }

  
    public boolean contains(String s) {
        return st.contains(s);
    }


    @Deprecated
    public int index(String s) {
        return st.get(s);
    }

    
    public int indexOf(String s) {
        return st.get(s);
    }

    public String nameOf(int v) {
        validateVertex(v);
        return keys[v];
    }


    public EdgeWeightedDigraph digraph() {
        return graph;
    }
   public Digraph regdigraph() {
	   return regdigraph;
   }

    // throw an IllegalArgumentException unless {@code 0 <= v < V}
    private void validateVertex(int v) {
         int V = graph.V();
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    }


  
	

}
    

