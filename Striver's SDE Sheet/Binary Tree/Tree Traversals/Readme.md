https://www.codingninjas.com/codestudio/problems/981269?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0

<div _ngcontent-serverapp-c204="" class="description ng-star-inserted"><h4 id="you-have-been-given-a-binary-tree-of-39-n-39-nodes-where-the-nodes-have-integer-values-your-task-is-to-find-the-ln-order-pre-order-and-post-order-traversals-of-the-given-binary-tree">You have been given a Binary Tree of 'N' nodes, where the nodes have integer values. Your task is to find the ln-Order, Pre-Order, and Post-Order traversals of the given binary tree.</h4>

<h5 id="for-example">For example :</h5>

<pre><code>For the given binary tree:
</code></pre>

<p><img src="https://files.codingninjas.in/tt1-6639.jpg" alt="Binary - Tree1"></p>

<pre><code>The Inorder traversal will be [5, 3, 2, 1, 7, 4, 6].
The Preorder traversal will be [1, 3, 5, 2, 4, 7, 6].
The Postorder traversal will be [5, 2, 3, 7, 6, 4, 1].
</code></pre>

<h5 id="input-format">Input Format :</h5>

<pre><code>The first line contains an integer 'T' which denotes the number of test cases. 

The first line of each test case contains elements of the tree in the level order form. The line consists of values of nodes separated by a single space. In case a node is null, we take -1 in its place.
</code></pre>

<h5 id="example">Example :</h5>

<pre><code>The input for the tree is depicted in the below image: 
</code></pre>

<p><img src="https://files.codingninjas.in/tt2-6640.jpg" alt="BT - 2"></p>

<pre><code>1 3 8 5 2 7 -1 -1 -1 -1 -1 -1 -1
</code></pre>

<h4 id="explanation">Explanation :</h4>

<pre><code>Level 1 :
The root node of the tree is 1

Level 2 :
Left child of 1 = 3
Right child of 1 = 8

Level 3 :
Left child of 3 = 5
Right child of 3 = 2
Left child of 8 =7
Right child of 8 =  null (-1)


Level 4 :
Left child of 5 = null (-1)
Right child of 5 = null (-1)
Left child of 2 = null (-1)
Right child of 2 = null (-1)
Left child of 7 = null (-1)
Right child of 7 = null (-1)

1
3 8
5 2 7 -1
-1 -1 -1 -1 -1 -1
</code></pre>

<h5 id="note">Note :</h5>

<pre><code>1. The first not-null node(of the previous level) is treated as the parent of the first two nodes of the current level. The second not-null node (of the previous level) is treated as the parent node for the next two nodes of the current level and so on.

2. The input ends when all nodes at the last level are null(-1).

3. The above format was just to provide clarity on how the input is formed for a given tree. The sequence will be put together in a single line separated by a single space. Hence, for the above-depicted tree, the input will be given as:

1 3 8 5 2 7 -1 -1 -1 -1 -1 -1 -1
</code></pre>

<h5 id="output-format">Output Format :</h5>

<pre><code>For each test case, return a vector/list of vector/list containing all three traversals (In-Order, Pre-Order, and Post-Order) in each vector/list in the same order.

The first line of output of each test case prints 'N' single space-separated integers denoting the node's values in In-Order traversal.

The second line of output of each test case prints 'N' single space-separated integers denoting the node's values in Pre-Order traversal.

The third and the last line of output of each test case prints 'N' single space-separated integers denoting the node's values in Post-Order traversal.
</code></pre>

<h5 id="note">Note :</h5>

<pre><code>You don't need to print anything, it has already been taken care of. Just implement the given function.
</code></pre>

<h5 id="constraints">Constraints :</h5>

<pre><code>1 &lt;= T &lt;= 100
0 &lt;= N &lt;= 3000
0 &lt;= data &lt;= 10^9   

Where 'data' denotes the node value of the binary tree nodes.

Time limit: 1 sec
</code></pre>
</div>
