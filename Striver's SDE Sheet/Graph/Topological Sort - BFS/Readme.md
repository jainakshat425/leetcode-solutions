https://www.codingninjas.com/codestudio/problems/982938?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0

<div _ngcontent-serverapp-c205="" class="description ng-star-inserted"><h4 id="a-directed-acyclic-graph-dag-is-a-directed-graph-that-contains-no-cycles">A Directed Acyclic Graph (DAG) is a directed graph that contains no cycles.</h4>

<h4 id="topological-sorting-of-dag-is-a-linear-ordering-of-vertices-such-that-for-every-directed-edge-from-vertex-u-to-vertex-v-vertex-u-comes-before-v-in-the-ordering-topological-sorting-for-a-graph-is-not-possible-if-the-graph-is-not-a-dag">Topological Sorting of  DAG is a linear ordering of vertices such that for every directed edge from vertex ‘u’ to vertex ‘v’, vertex ‘u’ comes before ‘v’ in the ordering. Topological Sorting for a graph is not possible if the graph is not a DAG.</h4>

<h4 id="given-a-dag-consisting-of-v-vertices-and-e-edges-you-need-to-find-out-any-topological-sorting-of-this-dag-return-an-array-of-size-v-representing-the-topological-sort-of-the-vertices-of-the-given-dag">Given a DAG consisting of ‘V’ vertices and ‘E’ edges, you need to find out any topological sorting of this DAG.  Return an array of size ‘V’  representing the topological sort of the vertices of the given DAG.</h4>

<h4 id="for-example-consider-the-dag-shown-in-the-picture">For example,  Consider the DAG shown in the picture.</h4>

<p><img src="https://files.codingninjas.in/eg-6753.png" alt="alt tex"></p>

<h4 id="in-this-graph-there-are-directed-edges-from-0-to-1-and-0-to-3-so-0-should-come-before-1-and-3-also-there-are-directed-edges-from-1-to-2-and-3-to-2-so-1-and-3-should-come-before-2">In this graph, there are directed edges from 0 to 1 and 0 to 3, so 0 should come before 1 and 3. Also, there are directed edges from 1 to 2 and 3 to 2 so 1 and 3 should come before 2.</h4>

<h4 id="so-the-topological-sorting-of-this-dag-is-0-1-3-2">So, The topological sorting of this DAG is  {0 1 3 2}.</h4>

<h4 id="note-that-there-are-multiple-topological-sortings-possible-for-a-dag-for-the-graph-given-above-one-another-topological-sorting-is-0-3-1-2">Note that there are multiple topological sortings possible for a DAG. For the graph given above one another topological sorting is: {0, 3, 1, 2}</h4>

<h5 id="note">Note:</h5>

<pre><code>1. It is guaranteed that the given graph is DAG.
2. There will be no multiple edges and self-loops in the given DAG.
3. There can be multiple correct solutions, you can find any one of them. 
4. Don’t print anything, just return an array representing the topological sort of the vertices of the given DAG.
</code></pre>

<h5 id="input-format">Input format:</h5>

<pre><code>The first line of input contains an integer ‘T’ denoting the number of test cases. The description of  ‘T’ test cases follows.

The first line of each test case contains two space-separated integers ‘V’, ‘E’, representing the number vertices and edges in the graph respectively.

Then ‘E’ lines follow,  each containing 2 space-separated integers ‘u’, ‘v’ representing that there is a directed edge from vertex ‘u’ to vertex ‘v’
</code></pre>

<h5 id="output-format">Output format :</h5>

<pre><code>For each test case, return an array representing the topological sort of the vertices of the given DAG.
</code></pre>

<h4 id="note">Note :</h4>

<pre><code>You do not need to print anything. It has already been taken care of. Just implement the given function.
</code></pre>

<h5 id="constraints">Constraints:</h5>

<pre><code>1 &lt;= T &lt;= 50
1 &lt;= V &lt;= 10^4
0 &lt;= E &lt;= 10^4
0 &lt;= u, v &lt; V 

Where ‘T’ is the total number of test cases, ‘V’ is the number of vertices, ‘E’ is the number of edges, and ‘u’ and ‘v’ both represent the vertex of a given graph.

Time limit: 2 sec
</code></pre>
</div>
