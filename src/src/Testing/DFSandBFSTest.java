
package Testing;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

import Graphing.BreadthFirstDirectedPaths;
import Graphing.DepthFirstDirectedPaths;
import Graphing.SymbolDigraph;

/**
 * @author Bilal Jaffry
 *
 */
public class DFSandBFSTest {

	

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		SymbolDigraph testDiGraph = new SymbolDigraph("connectedCities.txt",", ");
		DepthFirstDirectedPaths dfs = new DepthFirstDirectedPaths(testDiGraph.regdigraph(),testDiGraph.indexOf("Boston"));
		BreadthFirstDirectedPaths bfs = new BreadthFirstDirectedPaths(testDiGraph.regdigraph(),0);
		
	}

	/**
	 * 
	 * @throws FileNotFoundException 
	 */
	@Test
	public void testSymbolDigraph() throws FileNotFoundException {
		SymbolDigraph testDiGraph = new SymbolDigraph("connectedCities.txt",", ");
		DepthFirstDirectedPaths dfs = new DepthFirstDirectedPaths(testDiGraph.regdigraph(),testDiGraph.indexOf("Boston"));
		BreadthFirstDirectedPaths bfs = new BreadthFirstDirectedPaths(testDiGraph.regdigraph(),testDiGraph.indexOf("Boston"));
		
		
		bfs.pathTo(testDiGraph.indexOf("Minneapolis"));
		dfs.pathTo(testDiGraph.indexOf("Minneapolis"));
		for(int i : dfs.pathTo(testDiGraph.indexOf("Minneapolis"))) {
			assertTrue(dfs.hasPathTo(testDiGraph.indexOf(testDiGraph.nameOf(i))));
			DepthFirstDirectedPaths dfs2 = new DepthFirstDirectedPaths(testDiGraph.regdigraph(),testDiGraph.indexOf(testDiGraph.nameOf(i)));
			assertTrue(dfs2.hasPathTo(testDiGraph.indexOf(testDiGraph.nameOf(i))));
		}
		
		for(int i : bfs.pathTo(testDiGraph.indexOf("Minneapolis"))) {
			assertTrue(bfs.hasPathTo(testDiGraph.indexOf(testDiGraph.nameOf(i))));
			BreadthFirstDirectedPaths bfs2 = new BreadthFirstDirectedPaths(testDiGraph.regdigraph(),testDiGraph.indexOf(testDiGraph.nameOf(i)));
			assertTrue	(bfs2.hasPathTo(testDiGraph.indexOf(testDiGraph.nameOf(i))));
		}
		
	}


}
