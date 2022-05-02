https://www.interviewbit.com/problems/nearest-smaller-element/

<div class="p-html-content p-statement"><div class="p-html-content__container"><p>Given an array, find the <strong>nearest</strong> smaller element G[i] for every element A[i] in the array such that the element has an <strong>index smaller than i</strong>.</p>

<p>More formally,</p>

<div class="highlighter-rouge"><pre class="highlight"><code>    G[i] for an element A[i] = an element A[j] such that 
    j is maximum possible AND 
    j &lt; i AND
    A[j] &lt; A[i]
</code></pre>
</div>

<p>Elements for which no smaller element exist, consider next smaller element as -1.</p>

<p><strong>Input Format</strong></p>

<div class="highlighter-rouge"><pre class="highlight"><code>The only argument given is integer array A.
</code></pre>
</div>

<p><strong>Output Format</strong></p>

<div class="highlighter-rouge"><pre class="highlight"><code>Return the integar array G such that G[i] contains nearest smaller number than A[i].If no such element occurs G[i] should be -1.
</code></pre>
</div>

<p><strong>For Example</strong></p>

<div class="highlighter-rouge"><pre class="highlight"><code>Input 1:
    A = [4, 5, 2, 10, 8]
Output 1:
    G = [-1, 4, -1, 2, 2]
Explaination 1:
    index 1: No element less than 4 in left of 4, G[1] = -1
    index 2: A[1] is only element less than A[2], G[2] = A[1]
    index 3: No element less than 2 in left of 2, G[3] = -1
    index 4: A[3] is nearest element which is less than A[4], G[4] = A[3]
    index 4: A[3] is nearest element which is less than A[5], G[5] = A[3]
    
Input 2:
    A = [3, 2, 1]
Output 2:
    [-1, -1, -1]
Explaination 2:
    index 1: No element less than 3 in left of 3, G[1] = -1
    index 2: No element less than 2 in left of 2, G[2] = -1
    index 3: No element less than 1 in left of 1, G[3] = -1
</code></pre>
</div>

</div></div>
