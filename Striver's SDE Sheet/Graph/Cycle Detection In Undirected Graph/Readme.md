https://www.codingninjas.com/codestudio/problems/1062670?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0

<div _ngcontent-serverapp-c205="" class="description ng-star-inserted"><h4 id="you-have-been-given-an-undirected-graph-with-39-n-39-vertices-and-39-m-39-edges-the-vertices-are-labelled-from-1-to-39-n-39">You have been given an undirected graph with 'N' vertices and 'M' edges. The vertices are labelled from 1 to 'N'.</h4>

<h4 id="your-task-is-to-find-if-the-graph-contains-a-cycle-or-not">Your task is to find if the graph contains a cycle or not.</h4>

<h4 id="a-path-that-starts-from-a-given-vertex-and-ends-at-the-same-vertex-traversing-the-edges-only-once-is-called-a-cycle">A path that starts from a given vertex and ends at the same vertex traversing the edges only once is called a cycle.</h4>

<h4 id="example">Example :</h4>

<pre><code>In the below graph, there exists a cycle between vertex 1, 2 and 3. 
</code></pre>

<p><img src="https://files.codingninjas.in/screenshot-90-6892.png" alt="Example"></p>

<h4 id="note">Note:</h4>

<pre><code>1. There are no parallel edges between two vertices.

2. There are no self-loops(an edge connecting the vertex to itself) in the graph.

3. The graph can be disconnected.
</code></pre>

<h4 id="for-example">For Example :</h4>

<pre><code>Input: N = 3 , Edges =  [[1, 2], [2, 3], [1, 3]].
Output: Yes

Explanation : There are a total of 3 vertices in the graph. There is an edge between vertex 1 and 2, vertex 2 and 3 and vertex 1 and 3. So, there exists a cycle in the graph. 
</code></pre>

<h5 id="input-format">Input Format:</h5>

<pre><code>The first line of input contains an integer 'T' which denotes the number of test cases or queries to be run. Then the test cases follow.

The first line of each test case contains two single space-separated integers ‘N’ and ‘M’ representing the total number of vertices and edges, respectively.

The next ‘M’ lines contain two single space-separated integers representing an edge of the graph.
</code></pre>

<h5 id="output-format">Output Format:</h5>

<pre><code>For each test case, the only line of output will return “Yes” if there exists a cycle in the graph. Else print “No”.
</code></pre>

<h5 id="note">Note:</h5>

<pre><code>You are not required to print the expected output, it has already been taken care of. Just implement the function.
</code></pre>

<h5 id="constraints">Constraints:</h5>

<pre><code>1 &lt;= T &lt;= 10
1 &lt;= N &lt;= 5000
0 &lt;= M &lt;= min(5000, (N * (N - 1)) / 2)
1 &lt;= edges[i][0] &lt;= N 
1 &lt;= edges[i][1] &lt;= N 

Time Limit: 1 sec 
</code></pre>
</div>
