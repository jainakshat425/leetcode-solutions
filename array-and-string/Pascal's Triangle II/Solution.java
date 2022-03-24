class Solution {
    public List<Integer> getRow(int rowIndex) {
        /* 
        1. Memory efficient Dynamic Programming Approach
        2. Create list of integer to store the result {row}, initalize it with 1.
        3. On calculating each level of Pascal's Triangle, use the same list for calculating and storing/overriding the result.
        4. Iterate from level 1 to the {rowIndex}
            - Iterate from the end of the list till the second element
                - Calculate values for new level, by doing sum of current index {j} element and previous index {j-1} element, and store it on current {j} index.
            - Add 1 to the list after iteration, as each level has an additional 1 at the end.
        */
        
        // Create list of integer to store the result {row}, initalize it with 1.
        // On calculating each level of Pascal's Triangle, use the same list for calculating and storing/overriding the result.
        List<Integer> row = new ArrayList<Integer>();
        row.add( 1 );
        
        // Iterate from level 1 to the {rowIndex}
        for(int i=1; i<=rowIndex; i++) {
            
            // Iterate from the end of the list till the second element
            for(int j=i-1; j>0; j--) {
                
                // Calculate values for new level, by doing sum of current index {j} element and previous index {j-1} element, and store it on current {j} index.
                row.set( j, row.get( j-1 ) + row.get( j ) );
            }
            
            // Add 1 to the list after iteration, as each level has an additional 1 at the end.
            row.add( 1 );
        }
        return row;
    }
}
