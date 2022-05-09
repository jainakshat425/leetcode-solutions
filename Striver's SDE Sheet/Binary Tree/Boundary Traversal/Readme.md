https://www.codingninjas.com/codestudio/problems/boundary-traversal_790725?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0

<div _ngcontent-serverapp-c205="" class="description ng-star-inserted"><h4 id="you-have-been-given-a-binary-tree-of-integers-your-task-is-to-print-the-boundary-nodes-of-this-binary-tree-in-anti-clockwise-direction-starting-from-the-root-node">You have been given a binary tree of integers. Your task is to print the boundary nodes of this binary tree in Anti-Clockwise direction starting from the root node.</h4>

<h5 id="note">NOTE:</h5>

<pre><code>The boundary nodes of a binary tree include nodes from the left boundary, right boundary and the leaf nodes without duplicate nodes. However, the values from the nodes may contain duplicates. 
</code></pre>

<h5 id="for-example">For Example:</h5>

<p><img src="https://files.codingninjas.in/boundarytraversal-5149.png" alt="alt text"></p>

<h5 id="input-format">Input Format:</h5>

<pre><code>The first line contains an integer 'T' which denotes the number of test cases or queries to be run. Then the test cases follow.

The only line of each test case contains elements in the level order form. The line consists of values of nodes separated by a single space. In case a node is null, we take -1 on its place.

For example, the input for the tree depicted in the below image will be:
</code></pre>

<p><img src="https://files.codingninjas.in/0000000000004189.png" alt="alt text"></p>

<pre><code>1
2 3
4 -1 5 6
-1 7 -1 -1 -1 -1
-1 -1
</code></pre>

<h4 id="explanation">Explanation :</h4>

<pre><code>Level 1 :
The root node of the tree is 1

Level 2 :
Left child of 1 = 2
Right child of 1 = 3

Level 3 :
Left child of 2 = 4
Right child of 2 = null (-1)
Left child of 3 = 5
Right child of 3 = 6

Level 4 :
Left child of 4 = null (-1)
Right child of 4 = 7
Left child of 5 = null (-1)
Right child of 5 = null (-1)
Left child of 6 = null (-1)
Right child of 6 = null (-1)

Level 5 :
Left child of 7 = null (-1)
Right child of 7 = null (-1)

The first not-null node(of the previous level) is treated as the parent of the first two nodes of the current level. The second not-null node (of the previous level) is treated as the parent node for the next two nodes of the current level and so on.
The input ends when all nodes at the last level are null(-1).
</code></pre>

<h5 id="note">Note :</h5>

<pre><code>The above format was just to provide clarity on how the input is formed for a given tree. 
The sequence will be put together in a single line separated by a single space. Hence, for the above-depicted tree, the input will be given as:

1 2 3 4 -1 5 6 -1 7 -1 -1 -1 -1 -1 -1
</code></pre>

<h5 id="output-format">Output Format:</h5>

<pre><code>For each test case, print the boundary nodes of the given binary tree separated by single spaces.

Print the output of each test case in a separate line.
</code></pre>

<h5 id="note">Note:</h5>

<pre><code>You are not required to print the expected output, it has already been taken care of. Just implement the function.
</code></pre>

<h5 id="constraints">Constraints:</h5>

<pre><code>1 &lt;= T &lt;= 10^2
1 &lt;= N &lt;= 2^12 

Where 'N' is the total number of nodes in the binary tree.

Time Limit: 1 sec
</code></pre>
</div>
