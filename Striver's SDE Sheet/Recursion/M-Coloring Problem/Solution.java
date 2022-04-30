class solve 
{
    private static boolean isSafeToColor(List<Integer>[] G, int[] color, int i, int newColor) {
        for(Integer adjacent : G[i]) {
            if( color[adjacent] == newColor ) {
                return false;
            }
        }
        return true;
    }
    
    //Function to determine if graph can be coloured with at most M colours such
    //that no two adjacent vertices of graph are coloured with same colour.
    public static boolean graphColoring(List<Integer>[] G, int[] color, int i, int m) 
    {
        // If all the nodes have been colored return true
        if( i == color.length ) {
            return true;
        }
        
        // Try appling color from 1 to m to current vertex i
        for(int newColor=1; newColor<=m; newColor++) {
            
            // Check if no adjacent vertex of i has the same color
            if( isSafeToColor(G, color, i, newColor) ) {
                
                // Apply color to vertex i
                color[i] = newColor;
                
                // Check if it's possible to color other vertices
                if( graphColoring(G, color, i+1, m) ) {
                    return true;
                }
                
                // Clear the color to try a new color
                color[i] = 0;
            }
        }
       
        return false;
    }
}
