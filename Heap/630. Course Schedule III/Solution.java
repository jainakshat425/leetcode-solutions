class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a,b) -> a[1] - b[1]);
        // Duration of courses taken, sorted in descending order
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a,b) -> b - a);
        
        int day = 0;
        
        for(int[] course : courses) {
            int duration = course[0];
            int lastDay = course[1];
            
            if( day + duration > lastDay && !maxHeap.isEmpty() && maxHeap.peek() > duration ) 
                day -= maxHeap.poll();
            
            if( day + duration <= lastDay ) {
                maxHeap.offer( duration );
                day += duration;
            } 
        }
        return maxHeap.size();
    }
}
/* 1D DP - TLE and MLE on big test cases
class Solution {
    public int scheduleCourse(int[][] courses) {
        int n = courses.length;
        Arrays.sort(courses, (a,b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        
        int maxDay = courses[n-1][1];
        int[] prev = new int[maxDay+1];
        
        for(int i=n-1; i>=0; i--) {
            int[] curr = new int[maxDay+1];
            for(int day=maxDay; day>=0; day--) {
                int notTake = prev[day];
                int take = 0;
                if( day + courses[i][0] <= courses[i][1] ) 
                    take = 1 + prev[day + courses[i][0]];

                curr[day] = Math.max(take, notTake);
            }
            prev = curr;
        }
        return prev[0];
    }
}
*/
/* Memoization - TLE on https://leetcode.com/submissions/detail/729047590/testcase/
class Solution {
    public int scheduleCourse(int[][] courses) {
        int n = courses.length;
        Arrays.sort(courses, (a,b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        
        int maxDay = courses[n-1][1];
        int[][] dp = new int[n][maxDay+1];
        
        for(int[] state : dp)
            Arrays.fill(state, -1);
        return completeMaxCourses(0, 0, courses, dp);
    }
    
    private int completeMaxCourses(int i, int day, int[][] courses, int[][] dp) {
        if( i == courses.length )
            return 0;
        
        if( dp[i][day] != -1 )
            return dp[i][day];
        
        int notTake = completeMaxCourses(i+1, day, courses, dp);
        int take = 0;
        if( day + courses[i][0] <= courses[i][1] ) 
            take = 1 + completeMaxCourses(i+1, day + courses[i][0], courses, dp);
        
        return dp[i][day] = Math.max(take, notTake);
    }
}
*/
/* Greedy Approach - Fails on [[5,5],[4,6],[2,6]]
class Solution {
    public int scheduleCourse(int[][] courses) {
        // 0 > duration, 1 > lastDay
        Arrays.sort(courses, (a,b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        
        int day = 0;
        int ans = 0;
        
        for(int[] course : courses) {
            if( day + course[0] <= course[1] ) {
                ans++;
                day += course[0];
            }
        }
        return ans;
    }
}
*/
