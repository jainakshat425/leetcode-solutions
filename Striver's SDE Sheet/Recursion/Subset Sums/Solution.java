class Solution{
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        
        ArrayList<Integer> result = new ArrayList<>();

        subsetSum(arr, N, 0, 0, result);
        
        return result;
    }
    
    void subsetSum(ArrayList<Integer> arr, int N, int i, int sum, ArrayList<Integer> result){
        // Add the sum to result if reached to array length
        if( i == N ) {
            result.add( sum );
            return;
        }
        
        // Call subsetSum for the next index, while including current number in the sum
        subsetSum(arr, N, i+1, sum + arr.get(i), result);
        // Call subsetSum for the next index, without including current number in the sum
        subsetSum(arr, N, i+1, sum, result);
    }
}
