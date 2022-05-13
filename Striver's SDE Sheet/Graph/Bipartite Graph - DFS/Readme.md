https://www.codingninjas.com/codestudio/problems/920551?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0

<div _ngcontent-serverapp-c205="" class="description ng-star-inserted"><h4 id="given-a-graph-check-whether-the-graph-is-bipartite-or-not-your-function-should-return-true-if-the-given-graph-39-s-vertices-can-be-divided-into-two-independent-sets-u-and-v-such-that-every-edge-u-v-either-connects-a-vertex-from-u-to-v-or-a-vertex-from-v-to-u">Given a graph, check whether the graph is bipartite or not. Your function should return true if the given graph's vertices can be divided into two independent sets, ‘U’ and ‘V’ such that every edge (‘u’, ‘v’) either connects a vertex from ‘U’ to ‘V’ or a vertex from ‘V’ to ‘U’.</h4>

<h4 id="you-are-given-a-2d-array-edges-which-contains-0-and-1-where-edges-i-j-1-denotes-a-bi-directional-edge-from-i-to-j">You are given a 2D array ‘edges’ which contains 0 and 1, where ‘edges[i][j]’ = 1 denotes a bi-directional edge from ‘i’ to ‘j’.</h4>

<h5 id="note">Note:</h5>

<pre><code>If edges[i][j] = 1, that implies there is a bi-directional edge between ‘i’ and ‘j’, that means there exists both edges from ‘i’ to ‘j’ and to ‘j’ to ‘i’.
</code></pre>

<h4 id="for-example">For example</h4>

<pre><code>Given:
‘N’ = 3
‘edges’ = [[0, 1, 1], [0, 0, 1], [0,0,0]]. 
</code></pre>

<p><img src="https://files.codingninjas.in/t1-11544.png" alt=""></p>

<h5 id="input-format">Input format:</h5>

<pre><code>The first line of input contains an integer ‘T’ denoting the number of test cases.

The first line of each test case contains two space-separated integers, ‘N,’ where ‘N’ is the number of rows in ‘edges’ and the number of columns in ‘edges’.

The next ‘N’ line of each test case contains ‘N’ space-separated integers which tell if there is an edge between ‘i’ and ‘j’.
</code></pre>

<h5 id="output-format">Output Format :</h5>

<pre><code>For each test case, You are supposed to return a bool value determining whether the graph is bipartite or not.
</code></pre>

<h5 id="note">Note:</h5>

<pre><code>You are not required to print the expected output; it has already been taken care of. Just implement the function.
</code></pre>

<h5 id="constraints">Constraints:</h5>

<pre><code>1 &lt;= ‘T’ &lt;= 10
2 &lt;= ‘N’ &lt;= 300
0 &lt;= ‘edges[i][j]’ &lt;= 1. 

Time Limit: 1sec.
</code></pre>
</div>
