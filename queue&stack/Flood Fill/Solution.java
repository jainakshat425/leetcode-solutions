class Solution {
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        /* 
        1. Call {floodFillRecursive} and pass the color to be painted {image[sr][sc]}.
        2. Return if row index {sr} or column index {sc} is out of bounds.
        3. Return if current color {image[sr][sc]} != color to be pained {color} OR current color is already painted.
        4. Update current color {image[sr][sc]} with {newColor}.
        5. Call {floodFillRecursive} for top, bottom, left and right positions.
        */
        
        // Call {floodFillRecursive} and pass the color to be painted {image[sr][sc]}.
        floodFillRecursive( image, sr, sc, newColor, image[sr][sc]);
        return image;
    }
    
    public void floodFillRecursive(int[][] image, int sr, int sc, int newColor, int color) {
        // Return if row index {sr} or column index {sc} is out of bounds.
        if( sr < 0 || sr >= image.length ) return;
        if( sc < 0 || sc >= image[sr].length ) return;
        
        // Return if current color {image[sr][sc]} != color to be pained {color} OR current color is already painted.
        if( image[sr][sc] != color || image[sr][sc] == newColor ) return;
        
        // Update current color {image[sr][sc]} with {newColor}.
        image[sr][sc] = newColor;
        
        // Call {floodFillRecursive} for top, bottom, left and right positions.
        floodFill( image, sr-1, sc, newColor, color);
        floodFill( image, sr+1, sc, newColor, color);
        floodFill( image, sr, sc-1, newColor, color);
        floodFill( image, sr, sc+1, newColor, color);
    }
}
