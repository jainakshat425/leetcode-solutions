import java.util.ArrayList;

public class Solution {

    public static boolean isGraphBirpatite(ArrayList < ArrayList < Integer >> edges) {
        int n = edges.size();
        ArrayList < ArrayList < Integer >> adj = createAdjacencyList(n, edges);
        int[] color = new int[n];

        for (int i = 0; i < n; i++) {
            if (color[i] == 0 && !dfs(i, 1, adj, color))
                return false;
        }
        return true;
    }

    private static boolean dfs(int u, int clr, ArrayList < ArrayList < Integer >> adj, int[] color) {
        color[u] = clr;

        for (int v: adj.get(u)) {
            if (color[v] == 0 && !dfs(v, -clr, adj, color))
                return false;
            if (color[u] == color[v])
                return false;
        }
        return true;
    }

    private static ArrayList < ArrayList < Integer >> createAdjacencyList(int n, ArrayList < ArrayList < Integer >> edges) {
        ArrayList < ArrayList < Integer >> adj = new ArrayList();

        for (int i = 0; i < n; i++)
            adj.add(new ArrayList());

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (edges.get(i).get(j) == 1) {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
        return adj;
    }
}
