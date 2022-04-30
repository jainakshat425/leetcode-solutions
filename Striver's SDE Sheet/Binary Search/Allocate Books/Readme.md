https://www.interviewbit.com/problems/allocate-books/

<div class="p-html-content p-statement"><div class="p-html-content__container"><p>Given an array of integers <strong>A</strong> of size <strong>N</strong> and an integer <strong>B</strong>.</p>

<p>College library has <strong>N</strong> bags,the <strong>ith</strong> book has <strong>A[i]</strong> number of pages.</p>

<p>You have to allocate books to <strong>B</strong> number of students so that maximum number of pages alloted to a student is minimum.</p>

<div class="highlighter-rouge"><pre class="highlight"><code>A book will be allocated to exactly one student.
Each student has to be allocated at least one book.
Allotment should be in contiguous order, for example: A student cannot be allocated book 1 and book 3, skipping book 2.
</code></pre>
</div>

<p>Calculate and return that minimum possible number.</p>

<p><strong>NOTE:</strong> Return -1 if a valid assignment is not possible.</p>

<p><br><br>
<strong>Input Format</strong></p>

<div class="highlighter-rouge"><pre class="highlight"><code>The first argument given is the integer array A.
The second argument given is the integer B.
</code></pre>
</div>

<p><strong>Output Format</strong></p>

<div class="highlighter-rouge"><pre class="highlight"><code>Return that minimum possible number
</code></pre>
</div>

<p><strong>Constraints</strong></p>

<div class="highlighter-rouge"><pre class="highlight"><code>1 &lt;= N &lt;= 10^5
1 &lt;= A[i] &lt;= 10^5
</code></pre>
</div>

<p><strong>For Example</strong></p>

<div class="highlighter-rouge"><pre class="highlight"><code>Input 1:
    A = [12, 34, 67, 90]
    B = 2
Output 1:
    113
Explanation 1:
    There are 2 number of students. Books can be distributed in following fashion : 
        1) [12] and [34, 67, 90]
        Max number of pages is allocated to student 2 with 34 + 67 + 90 = 191 pages
        2) [12, 34] and [67, 90]
        Max number of pages is allocated to student 2 with 67 + 90 = 157 pages 
        3) [12, 34, 67] and [90]
        Max number of pages is allocated to student 1 with 12 + 34 + 67 = 113 pages

        Of the 3 cases, Option 3 has the minimum pages = 113.

Input 2:
    A = [5, 17, 100, 11]
    B = 4
Output 2:
    100
</code></pre>
</div>

</div></div>
