public class Solution {
    public int books(int[] A, int B) {

        if( A.length < B ) return -1;

        /* Assign low with the minimum sum possible which is the 
        maximum number of the array and assign high the maximum 
        sum possible which is sum of all the numbers */
        int low = arrayMax(A), high = arraySum(A);

        int ans = 0;

        while( low <= high ) {

            // Let's say mid is the maximum book allocated to a student
            int mid = low + (high-low)/2;

            /* Check if allocation of books is possible to B students, 
            considering {mid} as the maximum books allocated to a 
            student */
            if( isAllocationPossible(A, B, mid) ) {
                
                ans = mid;

                /* To check if the maximum can be reduced by moving 
                high before mid */
                high = mid-1;
            } else {
                /* Not possible to allocate the books to B students by
                allocating maximum {mid} pages to a student, hence maximum
                should be in upper bound */
                low = mid+1;
            }
        }
        return ans;
    }

    private boolean isAllocationPossible(int[] A, int B, int barrier) {
        // Start with allocating 0 pages to the first student
        int student = 1, currAllocatedpages = 0;

        // Allocate books to students
        for(int pages : A) {
            /* If pages in current book exceeds the barrier or more 
            number of students are required to allocate the books,
            then this maximum barrier is not valid, return false. */
            if( pages > barrier || student > B ) {
                return false;
            }

            /* If allocating page to same student result in more
            pages than barrier, allocate the pages to next student 
            instead. */
            if( currAllocatedpages + pages > barrier ) {
                student++;
                currAllocatedpages = 0;
            } 
            currAllocatedpages += pages;
        }

        /* Return if the pages can be allocated to B students without exceeding barrier */
        return student <= B;
    }
    private int arrayMax(int[] A) {
        int max = 0;
        for(int num : A) {
            max = Math.max( max, num );
        }
        return max;
    }
    private int arraySum(int[] A) {
        int sum = 0;
        for(int num : A) {
            sum += num;
        }
        return sum;
    }
}
