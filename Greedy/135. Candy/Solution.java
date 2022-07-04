class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        int ans = 0;
        
        candies[0] = 1;

        for(int i=1; i<n; i++)
            candies[i] = ratings[i] > ratings[i-1] ? candies[i-1] + 1 : 1;
        
        for(int i=n-2; i>=0; i--) {
            if( ratings[i] > ratings[i+1] )
                candies[i] = Math.max(candies[i], candies[i+1] + 1);
            
            ans += candies[i];
        }
        ans += candies[n-1];
        return ans;
    }
}
// class Solution {
//     public int candy(int[] ratings) {
//         int n = ratings.length;
//         PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b) -> Integer.compare(a[0], b[0]));   
//         int[] candies = new int[n];
//         int ans = 0;

//         for(int i=0; i<n; i++)
//             pq.offer(new int[]{ ratings[i], i });
        
//         while( !pq.isEmpty() ) {
//             int curRating = pq.peek()[0];
//             int curInd = pq.peek()[1];
//             pq.poll();
            
//             int prev = curInd == 0 || ratings[curInd-1] >= ratings[curInd] ? 0 : candies[curInd-1];
//             int next = curInd == n-1 || ratings[curInd+1] >= ratings[curInd] ? 0 : candies[curInd+1];
            
//             candies[curInd] = Math.max(prev, next) + 1;
//             ans += candies[curInd];
//         }
//         return ans;
//     }
// }
