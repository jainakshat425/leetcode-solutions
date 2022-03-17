class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        /* 
        1. Create a list of list of integers to store elements at each level in the triangle.
        2. Loop from 0 to numOfRows.
            - Add a new empty list for current level.
            - Add 1 to the list if
                - {i = 0} => current level is 0, no level before this.
                - {i = 1} => current level is 1, there is only 1 element at (i-1)th level.
                - {j = 0} => current element is 0, no element at (j-1)th index at level (i-1).
                - {j == i} => current element is last element at this level, no element at (j)th index                              at level (i-1).
            - else, result[i] = result[i-1][j-1] + result[i-1][j];
        */
        
        // Create a list of list of integers to store elements at each level in the triangle.
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        // Loop from 0 to numOfRows.
        for(int i=0; i<numRows; i++) {
            
            // Add a new empty list for current level.
            result.add(new ArrayList<Integer>());
            
            for(int j=0; j<(i+1); j++) {

                /* 
                Add 1 to the list if
                - {i = 0} => current level is 0, no level before this.
                - {i = 1} => current level is 1, there is only 1 element at (i-1)th level.
                - {j = 0} => current element is 0, no element at (j-1)th index at level (i-1).
                - {j == i} => current element is last element at this level, no element at (j)th                                    index at level (i-1).
                */
                if( i == 0 || i == 1 || j == 0 || j == i ) {
                    result.get( i ).add( 1 );
                } else {
                    // result[i] = result[i-1][j-1] + result[i-1][j];
                    result.get( i ).add( result.get(i-1).get(j-1) + result.get(i-1).get(j) );
                }
            }
        }
        return result;
    }
}
