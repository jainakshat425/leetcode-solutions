import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static int kruskalMST(int n, int m, ArrayList < ArrayList < Integer >> graph) {
        // Since nodes are starting from 1, use n+1
        DisjointSet dset = new DisjointSet(n + 1);
        Collections.sort(graph, (arr1, arr2) - > arr1.get(2) - arr2.get(2));
        int sum = 0;

        for (ArrayList < Integer > edge: graph) {
            int u = edge.get(0);
            int v = edge.get(1);
            int w = edge.get(2);
            // Already connected directly/indirectly
            if (dset.find(u) == dset.find(v))
                continue;
            // Include the edge in MST
            sum += w;
            // Connect the nodes
            dset.union(u, v);
            // break if all the nodes have been connected
            if (--n == 0)
                break;
        }
        return sum;
    }
}
class DisjointSet {
    private int[] parent;
    private int[] rank;

    public DisjointSet(int n) {
        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++)
            parent[i] = i;
    }

    public int find(int node) {
        if (parent[node] == node)
            return node;
        return find(parent[node]);
    }

    public void union(int node1, int node2) {
        int par1 = find(node1);
        int par2 = find(node2);

        if (rank[par1] > rank[par2])
            parent[par2] = par1;
        else if (rank[par2] > rank[par1])
            parent[par1] = par2;
        else {
            parent[par2] = par1;
            ++rank[par1];
        }
    }
}
