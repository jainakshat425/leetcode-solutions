https://www.codingninjas.com/codestudio/problems/2099908?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0

<div _ngcontent-serverapp-c204="" class="description ng-star-inserted"><h4 id="implement-a-queue-data-structure-specifically-to-store-integer-data-using-a-singly-linked-list-or-an-array">Implement a Queue Data Structure specifically to store integer data using a Singly Linked List or an array.</h4>

<h4 id="you-need-to-implement-the-following-public-functions">You need to implement the following public functions :</h4>

<pre><code>1. Constructor: It initializes the data members as required.

2. enqueue(data): This function should take one argument of type integer. It enqueues the element into the queue.

3. dequeue(): It dequeues/removes the element from the front of the queue and in turn, returns the element being dequeued or removed. In case the queue is empty, it returns -1.

4. front(): It returns the element being kept at the front of the queue. In case the queue is empty, it returns -1.

5. isEmpty(): It returns a boolean value indicating whether the queue is empty or not.
</code></pre>

<h5 id="operations-performed-on-the-queue">Operations Performed on the Queue :</h5>

<pre><code>Query-1(Denoted by an integer 1): Enqueues integer data to the queue.

Query-2(Denoted by an integer 2): Dequeues the data kept at the front of the queue and returns it to the caller, return -1 if no element is present in the queue.

Query-3(Denoted by an integer 3): Fetches and returns the data being kept at the front of the queue but doesn't remove it, unlike the dequeue function, return -1 if no element is present in the queue.

Query-4(Denoted by an integer 4): Returns a boolean value denoting whether the queue is empty or not.
</code></pre>

<h5 id="input-format">Input Format :</h5>

<pre><code>The first line contains an integer ‘t’ denoting the number of test cases.

For each test case, the first line contains an integer 'q' which denotes the number of queries to be run against each operation on the queue. 

Every 'q' lines represent an operation that needs to be performed.

For the enQueue operation, the input line will contain two integers separated by a single space, representing the type of the operation in the integer and the integer data being enqueued into the queue.

For the rest of the operations on the queue, the input line will contain only one integer value, representing the query being performed on the queue.
</code></pre>

<h5 id="output-format">Output Format :</h5>

<pre><code>For Query-1, print the data being enqueued in the queue.
For Query-2, print the data being dequeued from the queue.
For Query-3, print the data kept on the front of the queue.
For Query-4, print 'true' or 'false'(without quotes).

Output for every query will be printed in a separate line.
</code></pre>

<h5 id="note">Note :</h5>

<pre><code>You are not required to print anything explicitly. It has already been taken care of. Just implement the functions.
</code></pre>

<h5 id="constraints">Constraints :</h5>

<pre><code>1 &lt;= t &lt;= 5
1 &lt;= q &lt;= 5000
1 &lt;= x &lt;= 4
1 &lt;= data &lt;= 2^31 - 1

Time Limit: 1 sec
</code></pre>
</div>
