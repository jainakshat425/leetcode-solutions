import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class Solution {
    public static ArrayList < Integer > topologicalSort(ArrayList < ArrayList < Integer >> edges, int v, int e) {
        ArrayList < ArrayList < Integer >> adj = createAdjacencyList(v, edges);
        int[] indegree = calculateIndegree(v, adj);
        Queue < Integer > queue = new LinkedList();
        ArrayList < Integer > ans = new ArrayList < Integer > ();

        for (int i = 0; i < v; i++) {
            if (indegree[i] == 0)
                queue.offer(i);
        }

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            ans.add(vertex);

            for (int adjV: adj.get(vertex)) {
                --indegree[adjV];
                if (indegree[adjV] == 0)
                    queue.offer(adjV);
            }
        }
        return ans;
    }

    private static ArrayList < ArrayList < Integer >> createAdjacencyList(int v, ArrayList < ArrayList < Integer >> edges) {
        ArrayList < ArrayList < Integer >> adj = new ArrayList();

        for (int i = 0; i < v; i++)
            adj.add(new ArrayList());

        for (ArrayList < Integer > edge: edges)
            adj.get(edge.get(0)).add(edge.get(1));

        return adj;
    }

    private static int[] calculateIndegree(int v, ArrayList < ArrayList < Integer >> adj) {
        int[] indegree = new int[v];

        for (ArrayList < Integer > adjacents: adj) {
            for (int adjV: adjacents)
                indegree[adjV]++;
        }
        return indegree;
    }
}
