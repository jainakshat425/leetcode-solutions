import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

// DFS Solution
public class Solution {

    public static String cycleDetection(int[][] edges, int n, int m) {
        List < List < Integer >> adj = createAdjList(edges, n);
        boolean[] vis = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            if (!vis[i] && hasCycleDFS(i, -1, adj, vis))
                return "Yes";
        }
        return "No";
    }

    private static boolean hasCycleDFS(int vertex, int parent,
        List < List < Integer >> adj, boolean[] vis) {
        vis[vertex] = true;

        for (int adjV: adj.get(vertex)) {
            if (!vis[adjV]) {
                if (hasCycleDFS(adjV, vertex, adj, vis))
                    return true;
            } else if (parent != adjV)
                return true;
        }
        return false;
    }
}
// BFS Solution
public class Solution {
    public static String cycleDetection(int[][] edges, int n, int m) {
        List < List < Integer >> adj = createAdjList(edges, n);
        boolean[] vis = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            if (!vis[i]) {

                Queue < Pair > queue = new LinkedList();
                queue.offer(new Pair(i, -1));

                while (!queue.isEmpty()) {
                    int vertex = queue.peek().vertex;
                    int parent = queue.peek().parent;
                    queue.poll();
                    vis[vertex] = true;

                    for (int adjV: adj.get(vertex)) {
                        if (!vis[adjV])
                            queue.offer(new Pair(adjV, vertex));
                        else if (parent != adjV)
                            return "Yes";

                    }
                }
            }
        }
        return "No";
    }

    private static List < List < Integer >> createAdjList(int[][] edges, int n) {
        List < List < Integer >> adj = new ArrayList();

        for (int i = 0; i <= n; i++)
            adj.add(new ArrayList());

        for (int[] edge: edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        return adj;
    }
}
class Pair {
    public int vertex, parent;

    public Pair(int v, int p) {
        vertex = v;
        parent = p;
    }
}
