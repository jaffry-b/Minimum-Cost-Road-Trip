

package Graphing;

import Input.IOStreamMenu;

/**
 *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *  File was heavily modified to work with edge weighted digraphs. 
 */

public class DirectedEdge { 
    private final int v;
    private final int w;
    private double weight;
   
   
    public DirectedEdge(int v, int w, double weight) {
        if (v < 0) throw new IllegalArgumentException("Vertex names must be nonnegative integers");
        if (w < 0) throw new IllegalArgumentException("Vertex names must be nonnegative integers");
        if (Double.isNaN(weight)) throw new IllegalArgumentException("Weight is NaN");
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public int from() {
        return v;
    }
     
    
    public int to() {
        return w;
    }
    
    public double weight() {
        return weight;
    }
    public void setWeight(double newWeight) {
    	this.weight = newWeight;
    }
   
    public String toString() {
        return v + "->" + w + " " + String.format("%5.2f", weight);
    }

  
 
}
