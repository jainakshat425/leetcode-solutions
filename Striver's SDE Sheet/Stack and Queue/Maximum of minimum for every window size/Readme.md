https://www.codingninjas.com/codestudio/problems/max-of-min_982935?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0

<div _ngcontent-serverapp-c214="" class="description ng-star-inserted"><h4 id="you-are-given-an-array-of-n-integers-you-need-to-find-the-maximum-of-minimum-for-every-window-size-the-size-of-the-window-should-vary-from-1-to-n-only">You are given an array of ‘N’ integers, you need to find the maximum of minimum for every window size. The size of the window should vary from 1 to ‘N’ only.</h4>

<h4 id="for-example">For example:</h4>

<pre><code>ARR = [1,2,3,4]
Minimums of window size 1 = min(1), min(2), min(3), min(4) = 1,2,3,4
Maximum among (1,2,3,4)  is 4

Minimums of window size 2 = min(1,2), min(2,3),   min(3,4) = 1,2,3
Maximum among (1,2,3) is 3

Minimums of window size 3 = min(1,2,3), min(2,3,4) = 1,2
Maximum among (1,2) is 2

Minimums of window size 4 = min(1,2,3,4) = 1
Maximum among them is 1
The output array should be [4,3,2,1].
</code></pre>

<h5 id="input-format">Input Format:</h5>

<pre><code>The first line of the input contains an integer ‘T’ denoting the number of test cases.

The first line of each test case contains a single positive integer ‘N’ denoting the number of the elements present in the array.

The second line of each test case contains ‘N’ space-separated integers denoting the elements of the array.
</code></pre>

<h5 id="output-format">Output Format:</h5>

<pre><code>The only line of output of each test case should contain ‘N’ space-separated integer such that he ith integer indicates the maximum of minimums of the windows of size ‘i’.
</code></pre>

<h5 id="constraints">Constraints:</h5>

<pre><code>1 &lt;= T &lt;= 100
1 &lt;= N &lt;= 10 ^ 4 
-10 ^ 9 &lt;= ARR[i] &lt;= 10 ^ 9

Where ‘T’ is the number of test cases, ‘N’ is the size of the array and ‘ARR[i]’ is the size of the array elements.

Time Limit: 1 sec
</code></pre>
</div>
