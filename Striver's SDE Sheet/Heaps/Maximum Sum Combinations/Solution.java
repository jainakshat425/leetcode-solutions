public class Solution {
    public int[] solve(int[] A, int[] B, int C) {
        Arrays.sort(A);
        Arrays.sort(B);

        int n = A.length;
        int[] ans = new int[C];

        PriorityQueue<int[]> queue = new PriorityQueue<int[]>((a,b) -> b[2] - a[2]);
        queue.offer( new int[]{n-1, n-1, A[n-1] + B[n-1]} );

        Set<String> visited = new HashSet();
        visited.add( createHash(n-1, n-1) );   

        for(int i=0; i<C; i++) {
            int aInd = queue.peek()[0];
            int bInd = queue.peek()[1];
            ans[i] = queue.peek()[2];
            queue.poll();

            String hash = createHash(aInd-1, bInd);
            if( !visited.contains( hash ) ) {
                queue.offer( new int[]{aInd-1, bInd, A[aInd-1] + B[bInd]} );
                visited.add( hash );
            }

            hash = createHash(aInd, bInd-1);
            if( !visited.contains( hash ) ) {
                queue.offer( new int[]{aInd, bInd-1, A[aInd] + B[bInd-1]} );
                visited.add( hash );
            }
        }
        
        return ans;
    }

    private String createHash(int i, int j) {
        return i + " " + j;
    }
}

