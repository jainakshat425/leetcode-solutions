/*
	This is signature of helper function 'knows'.
	You should not implement it, or speculate about its implementation.

	boolean knows(int A, int B); 
	Function 'knows(A, B)' will returns "true" if the person having
	id 'A' know the person having id 'B' in the party, "false" otherwise.
	Use it as Runner.knows(A, B);
*/
public class Solution {
	
	public static int findCelebrity(int n) {
        // Indegree of a person denotes the number of persons knows him
		int[] indegree = new int[n];
		// Outdegree of a person denotes the number of persons he knows 
	    int[] outdegree = new int[n];
		
		for(int A=0; A<n; A++) {
			for(int B=0; B<n; B++) {
				
				if( A == B ) continue;
				
				if( Runner.knows(A, B) ) {
					indegree[B]++;
					outdegree[A]++;
				}
			}
		}
		
		for(int A=0; A<n; A++) {
			if( indegree[A] == n-1 && outdegree[A] == 0 ) {
				return A;
			}
		}
		return -1;
    }
	/*
	public static int findCelebrity(int n) {
        
		for(int A=0; A<n; A++) {
			boolean isCelebrity = true;
			for(int B=0; B<n; B++) {
				
				if( A == B ) continue;
				
				// If A knows B or B doesn't know A, then A is not a celerbrity
				if( Runner.knows(A, B) || !Runner.knows(B, A) ) {
					isCelebrity = false;
					break;
				}
			}
			
			if( isCelebrity ) {
				return A;
			}
		}
		
		return -1;
    }*/
}
