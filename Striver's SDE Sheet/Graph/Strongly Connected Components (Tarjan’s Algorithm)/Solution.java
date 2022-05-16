import java.util.ArrayList;
import java.util.Stack;
import java.util.List;

public class Solution {

    public static List<List<Integer>> stronglyConnectedComponents(int n, int[][] edges) {
		// Topological Sort
		Stack<Integer> stack = topoSort(n, edges);
		// Transposed Graph
		ArrayList<ArrayList<Integer>> adjList = createAdjacencyList(n, edges, true);
		
		List<List<Integer>> ans = new ArrayList(n);
		boolean[] visited = new boolean[n];
		
		while( !stack.isEmpty() ) {
			int i = stack.pop();
			if( !visited[i] ) {
				List<Integer> scc = new ArrayList();
				ans.add( scc );
				dfs(i, adjList, visited, scc);
			}
		}
		return ans;
    }
	
	private static ArrayList<ArrayList<Integer>> createAdjacencyList(int n, int[][] edges, 
															  boolean transpose) {
		ArrayList<ArrayList<Integer>> adjList = new ArrayList(n);
		for(int i=0; i<n; i++)
			adjList.add( new ArrayList() );
		
		for(int[] edge : edges) {
			if( transpose ) 
				adjList.get( edge[1] ).add( edge[0] );
			else 
				adjList.get( edge[0] ).add( edge[1] );
		}
		return adjList;
	}
	
	private static Stack<Integer> topoSort(int n, int[][] edges) {
		ArrayList<ArrayList<Integer>> adjList = createAdjacencyList(n, edges, false);
		boolean[] visited = new boolean[n];
		Stack<Integer> stack = new Stack();
		
		for(int i=0; i<n; i++) {
			if( !visited[i] ) 
				topoSort(i, adjList, visited, stack);
		}
		return stack;
	}
	
	private static void topoSort(int i, ArrayList<ArrayList<Integer>> adjList, boolean[] visited,
						  Stack<Integer> stack) {
		visited[i] = true;
		
		for(int adjV : adjList.get(i)) {
			if( !visited[adjV] )
				topoSort(adjV, adjList, visited, stack);
		}
		stack.push(i);
	}
	
	private static void dfs(int i, ArrayList<ArrayList<Integer>> adjList, boolean[] visited, 
					 List<Integer> scc) {
		visited[i] = true;
		scc.add( i );
		
		for(int adjV : adjList.get(i)) {
			if( !visited[adjV] )
				dfs(adjV, adjList, visited, scc);
		}
	}
}
