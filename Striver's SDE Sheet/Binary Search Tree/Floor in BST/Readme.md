https://www.codingninjas.com/codestudio/problems/floor-from-bst_920457?source=youtube&campaign=Striver_Tree_Videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=Striver_Tree_Videos&leftPanelTab=0

<div _ngcontent-serverapp-c205="" class="description ng-star-inserted"><h4 id="you-are-given-a-bst-binary-search-tree-with-n-number-of-nodes-and-a-value-x-your-task-is-to-find-the-greatest-value-node-of-the-bst-which-is-smaller-than-or-equal-to-x">You are given a BST (Binary search tree) with’ N’ number of nodes and a value ‘X’. Your task is to find the greatest value node of the BST  which is smaller than or equal to  ‘X’.</h4>

<h4 id="note-x-is-not-smaller-than-the-smallest-node-of-bst">Note :‘X’ is not smaller than the smallest node of BST .</h4>

<h4 id="for-example">For example:</h4>

<p><img src="https://files.codingninjas.in/bst-11214.png" alt="1"></p>

<pre><code>In the above example, For the given BST  and X = 7, the greatest value node of the BST  which is smaller than or equal to  7 is 6.
</code></pre>

<h5 id="input-format">Input Format:</h5>

<pre><code>The first line of input contains an integer ‘T’, denoting the number of test cases. Then each test case follows.

The first line of each test case contains nodes in level order form (separated by space). If any node does not have a left or right child, take -1 in its place.

The second and the last line of each test case contain integer ‘X’.

For example, the input for the tree depicted in the below image. 
</code></pre>

<p><img src="https://files.codingninjas.in/bst-11214.png" alt="1"></p>

<pre><code>10
5 15
2 6 -1 -1
-1 -1 -1 -1 
</code></pre>

<h5 id="explanation">Explanation :</h5>

<pre><code>Level 1 :
The root node of the tree is 10

Level 2 :
Left child of 10 = 5
Right child of 10 = 15

Level 3 :
Left child of 5 = 2
Right child of 5 = 6
Left child of 15 = null(-1)
Right child of 15 =  null (-1)

Level 4 :
Left child of 2 = null (-1)
Right child of 2 = null (-1)
Left child of 6 = null (-1)
Right child of 6 = null (-1)

The first not-null node(of the previous level) is treated as the parent of the first two nodes of the current level. The second not-null node (of the previous level) is treated as the parent node for the next two nodes of the current level and so on.
The input ends when all nodes at the last level are null(-1).
</code></pre>

<h5 id="note">Note :</h5>

<pre><code>The above format was just to provide clarity on how the input is formed for a given tree. 
The sequence will be put together in a single line separated by a single space. Hence, for the above-depicted tree, the input will be given as:
10 5 15 2 6 -1 -1 -1 -1 -1 -1
</code></pre>

<h5 id="output-format">Output Format:</h5>

<pre><code>For each test case, print a single integer ‘M’, denoting the greatest value node of the BST  which is smaller than or equal to  ‘X’.

The Output of each test case will be printed on a separate line.
</code></pre>

<h5 id="note">Note:</h5>

<pre><code>You do not need to print anything, it has already been taken care of. Just implement the given function.
</code></pre>

<h5 id="constraints">Constraints:</h5>

<pre><code>1 &lt;= T &lt;= 5
1 &lt;= N &lt;= 5 * 10 ^ 3
1 &lt;= nodeVal[i] &lt;= 10 ^ 9

Time Limit: 1 sec.
</code></pre>
</div>
