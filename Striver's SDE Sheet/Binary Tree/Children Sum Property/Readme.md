https://www.codingninjas.com/codestudio/problems/childrensumproperty_790723?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0

<div _ngcontent-serverapp-c205="" class="description ng-star-inserted"><h4 id="given-a-binary-tree-of-nodes-39-n-39-you-need-to-modify-the-value-of-its-nodes-such-that-the-tree-holds-the-children-sum-property">Given a binary tree of nodes 'N', you need to modify the value of its nodes, such that the tree holds the Children sum property.</h4>

<h4 id="a-binary-tree-is-said-to-follow-the-children-sum-property-if-for-every-node-of-that-tree-the-value-of-that-node-is-equal-to-the-sum-of-the-value-s-of-all-of-its-children-nodes-left-child-and-the-right-child">A binary tree is said to follow the children sum property if, for every node of that tree, the value of that node is equal to the sum of the value(s) of all of its children nodes( left child and the right child).</h4>

<h5 id="note">Note :</h5>

<pre><code> 1. You can only increment the value of the nodes, in other words, the modified value must be at least equal to the original value of that node.
 2. You can not change the structure of the original binary tree.
 3. A binary tree is a tree in which each node has at most two children.      
 4. You can assume the value can be 0 for a NULL node and there can also be an empty tree.
</code></pre>

<h5 id="input-format">Input Format :</h5>

<pre><code>The first line contains a single integer 'T' representing the number of test cases. 

The first and the only line of each test case will contain the values of the nodes of the tree in the level order form ( -1 for NULL node) Refer to the example for further clarification.
Example : 
Consider the binary tree :
</code></pre>

<p><img src="https://files.codingninjas.in/screenshot-from-2020-10-09-12-55-45-5134.png" alt="abcd"></p>

<pre><code>The input of the tree depicted in the image above will be like : 

1
2 3
4 -1 5 6
-1 7 -1 -1 -1 -1
-1 -1

Explanation :
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

<p>##### Note :
    The above format was just to provide clarity on how the input is formed for a given tree. 
    The sequence will be put together in a single line separated by a single space. Hence, for the above-depicted tree, the input will be given as:</p>

<pre><code>1 2 3 4 -1 5 6 -1 7 -1 -1 -1 -1 -1 -1
</code></pre>

<h5 id="output-format">Output Format :</h5>

<pre><code>For each test case, you just need to update the given tree in-place. If the updated tree satisfies all the conditions, the output will be shown as “Valid”, else the output will be “Invalid”.

The output of each test case will be printed in a separate line.
</code></pre>

<h5 id="note">Note :</h5>

<pre><code>You do not need to print anything, it has already been taken care of. Just implement the given function.
</code></pre>

<h5 id="constraints">Constraints :</h5>

<pre><code>1 &lt;= T &lt;= 10^2
0 &lt;= N &lt;= 10^2
1 &lt;= node.Value &lt;= 10^6

Time Limit : 1 sec
</code></pre>
</div>
