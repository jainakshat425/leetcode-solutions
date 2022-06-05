https://www.interviewbit.com/problems/maximum-sum-combinations/

<div class="p-html-content p-statement"><div class="p-html-content__container"><p><strong>Problem Description</strong><br></p><div id="problem_description_markdown_content_value" style="background-color: #f9f9f9; padding: 5px 10px; "><p>Given two equally sized 1-D arrays <strong>A, B</strong> containing <strong>N</strong> integers each.</p><p></p><p></p><p></p><p></p><p></p><p></p>
<p>A <strong>sum combination</strong> is made by adding one element from array <strong>A</strong> and another element of array <strong>B</strong>.</p>
<p>Return the <strong>maximum C valid sum combinations</strong> from all the possible sum combinations.</p>
<p></p>
<p></p>
<p></p>
<p></p>
<p></p>
<p></p></div><br><br><strong>Problem Constraints</strong><br><div id="problem_constraints_markdown_content_value" style="background-color: #f9f9f9; padding: 5px 10px; "><p> 1 &lt;= N &lt;= 10<sup>5</sup></p><p></p><p></p><p></p><p></p><p></p><p></p>
<p> 1 &lt;= A[i] &lt;= 10<sup>3</sup></p>
<p> 1 &lt;= C &lt;= N</p>
<p></p>
<p></p>
<p></p>
<p></p>
<p></p>
<p></p></div><br><br><strong>Input Format</strong><br><div id="input_format_markdown_content_value" style="background-color: #f9f9f9; padding: 5px 10px; "><p>First argument is an one-dimensional integer array <strong>A</strong> of size <strong>N</strong>.</p><p></p><p></p><p></p><p></p><p></p><p></p>
<p>Second argument is an one-dimensional integer array <strong>B</strong> of size <strong>N</strong>.</p>
<p>Third argument is an integer <strong>C</strong>.</p>
<p></p>
<p></p>
<p></p>
<p></p>
<p></p>
<p></p></div><br><br><strong>Output Format</strong><br><div id="output_format_markdown_content_value" style="background-color: #f9f9f9; padding: 5px 10px; "><p>Return a one-dimensional integer array of size <strong>C</strong> denoting the top C maximum sum combinations.</p><p></p><p></p><p></p><p></p><p></p><p></p>
<p><strong>NOTE:</strong></p>
<p>The returned array must be sorted in non-increasing order.</p>
<p></p>
<p></p>
<p></p>
<p></p>
<p></p>
<p></p></div><br><br><strong>Example Input</strong><br><div id="example_input_markdown_content_value" style="background-color: #f9f9f9; padding: 5px 10px; "><p>Input 1:</p><p></p><p></p><p></p><p></p><p></p><p></p>
<pre> A = [3, 2]
 B = [1, 4]
 C = 2
</pre>
<p>Input 2:</p>
<pre> A = [1, 4, 2, 3]
 B = [2, 5, 1, 6]
 C = 4
</pre>
<p></p>
<p></p>
<p></p>
<p></p>
<p></p>
<p></p></div><br><br><strong>Example Output</strong><br><div id="example_output_markdown_content_value" style="background-color: #f9f9f9; padding: 5px 10px; "><p>Output 1:</p><p></p><p></p><p></p><p></p><p></p><p></p>
<pre> [7, 6]
</pre>
<p>Output 1:</p>
<pre> [10, 9, 9, 8]
</pre>
<p></p>
<p></p>
<p></p>
<p></p>
<p></p>
<p></p></div><br><br><strong>Example Explanation</strong><br><div id="example_explanation_markdown_content_value" style="background-color: #f9f9f9; padding: 5px 10px; "><p>Explanation 1:</p><p></p><p></p><p></p><p></p><p></p><p></p>
<pre> 7     (A : 3) + (B : 4)
 6     (A : 2) + (B : 4)
</pre>
<p>Explanation 2:</p>
<pre> 10   (A : 4) + (B : 6)
 9   (A : 4) + (B : 5)
 9   (A : 3) + (B : 6)
 8   (A : 3) + (B : 5)
</pre>
<p></p>
<p></p>
<p></p>
<p></p>
<p></p>
<p></p></div><br><br><p></p>
</div></div>
