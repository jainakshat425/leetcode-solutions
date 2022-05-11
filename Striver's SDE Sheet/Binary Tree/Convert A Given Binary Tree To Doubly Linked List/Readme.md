https://www.codingninjas.com/codestudio/problems/893106?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0

<div _ngcontent-serverapp-c205="" class="description ng-star-inserted"><h4 id="given-a-binary-tree-convert-this-binary-tree-to-a-doubly-linked-list">Given a Binary Tree, convert this binary tree to a Doubly Linked List.</h4>

<h4 id="a-binary-tree-bt-is-a-data-structure-in-which-each-node-has-at-most-two-children">A Binary Tree (BT) is a data structure in which each node has at most two children.</h4>

<h4 id="a-doubly-linked-list-contains-a-previous-pointer-along-with-the-next-pointer-and-data">A Doubly Linked List contains a previous pointer, along with the next pointer and data.</h4>

<h4 id="the-order-of-nodes-in-doubly-linked-list-must-be-the-same-as-inorder-of-the-given-binary-tree">The order of nodes in Doubly Linked List must be the same as Inorder of the given Binary Tree.</h4>

<h4 id="the-doubly-linked-list-should-be-returned-by-taking-the-next-pointer-as-right-and-the-previous-pointer-as-left">The doubly linked list should be returned by taking the next pointer as right and the previous pointer as left.</h4>

<h4 id="you-need-to-return-the-head-of-the-doubly-linked-list">You need to return the head of the Doubly Linked List.</h4>

<h4 id="for-the-given-binary-tree">For the given binary tree :</h4>

<p><img src="https://files.codingninjas.in/graph-6530.png" alt="alt txt"></p>

<pre><code>You need to return the head to the doubly linked list.
The doubly linked list would be: 1 2 3 4 5 and can be represented as:
</code></pre>

<p><img src="https://files.codingninjas.in/graph-1-6531.png" alt="alt txt"></p>

<h5 id="input-format">Input Format :</h5>

<pre><code>The first line contains an Integer 'T' which denotes the number of test cases or queries to be run. Then the test cases follow.

The first line of input contains the elements of the tree in the level order form separated by a single space.
If any node does not have a left or right child, take -1 in its place. Refer to the example below.

Example :

Elements are in the level order form. The input consists of values of nodes separated by a single space in a single line. In case a node is null, we take -1 in its place.

For example, the input for the tree depicted in the below image would be :
</code></pre>

<p><img src="https://files.codingninjas.in/graph-1-6520.png" alt="alt txt"></p>

<pre><code>1
2 3
4 -1 5 6
-1 7 -1 -1 -1 -1
-1 -1

Explanation  :
Level 1 :
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

The first not-null node (of the previous level) is treated as the parent of the first two nodes of the current level. The second not-null node (of the previous level) is treated as the parent node for the next two nodes of the current level and so on.

The input ends when all nodes at the last level are null (-1).
</code></pre>

<h5 id="note">Note :</h5>

<pre><code>The above format was just to provide clarity on how the input is formed for a given tree. 

The sequence will be put together in a single line separated by a single space. Hence, for the above-depicted tree, the input will be given as:

1 2 3 4 -1 5 6 -1 7 -1 -1 -1 -1 -1 -1
</code></pre>

<h5 id="output-format">Output Format :</h5>

<pre><code>For each test case, you need to return the head of the Doubly Linked List.

The output of each test case should be printed in a separate line.
</code></pre>

<h5 id="constraints">Constraints :</h5>

<pre><code>1 &lt;= T &lt;= 100
0 &lt;= N &lt;= 3000
-10 ^ 6 &lt;= data &lt;= 10 ^ 6 and data != -1

where 'N' is the number of nodes in the tree, 'T' represents the number of test cases and "data" denotes data contained in the node of the binary tree.

Duplicate elements can be in the right subtree or left subtree.

Time Limit: 1 sec.
</code></pre>

<h4 id="note">Note :</h4>

<pre><code>You are not required to print the expected output, and it has already been taken care of. Just implement the function.
</code></pre>
</div>
