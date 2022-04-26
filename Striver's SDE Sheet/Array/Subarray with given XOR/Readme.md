https://www.interviewbit.com/problems/subarray-with-given-xor/

<div class="p-html-content p-statement"><div class="p-html-content__container"><p><strong>Problem Description</strong><br></p><div id="problem_description_markdown_content_value" style="background-color: #f9f9f9; padding: 5px 10px; "><p>Given an array of integers <strong>A</strong> and an integer <strong>B</strong>.</p><p></p><p></p>
<p>Find the total number of subarrays having bitwise XOR of all elements equals to B.</p>
<p></p>
<p></p></div><br><br><strong>Problem Constraints</strong><br><div id="problem_constraints_markdown_content_value" style="background-color: #f9f9f9; padding: 5px 10px; "><p>1 &lt;= length of the array &lt;= 10<sup>5</sup></p><p></p>
<p>1 &lt;= A[i], B &lt;= 10<sup>9</sup></p>
<p></p></div><br><br><strong>Input Format</strong><br><div id="input_format_markdown_content_value" style="background-color: #f9f9f9; padding: 5px 10px; "><p>The first argument given is the integer array A.<br>
The second argument given is integer B.</p></div><br><br><strong>Output Format</strong><br><div id="output_format_markdown_content_value" style="background-color: #f9f9f9; padding: 5px 10px; "><p>Return the total number of subarrays having bitwise XOR equals to B.</p></div><br><br><strong>Example Input</strong><br><div id="example_input_markdown_content_value" style="background-color: #f9f9f9; padding: 5px 10px; "><p>Input 1:</p><p></p><p></p>
<pre> A = [4, 2, 2, 6, 4]
 B = 6</pre>
<p>Input 2:</p>
<pre> A = [5, 6, 7, 8, 9]
 B = 5</pre>
<p></p>
<p></p></div><br><br><strong>Example Output</strong><br><div id="example_output_markdown_content_value" style="background-color: #f9f9f9; padding: 5px 10px; "><p>Output 1:</p><p></p><p></p>
<pre> 4</pre>
<p>Output 2:</p>
<pre> 2</pre>
<p></p>
<p></p></div><br><br><strong>Example Explanation</strong><br><div id="example_explanation_markdown_content_value" style="background-color: #f9f9f9; padding: 5px 10px; "><p>Explanation 1:</p><p></p><p></p>
<pre> The subarrays having XOR of their elements as 6 are:
 [4, 2], [4, 2, 2, 6, 4], [2, 2, 6], [6]</pre>
<p>Explanation 2:</p>
<pre> The subarrays having XOR of their elements as 2 are [5] and [5, 6, 7, 8, 9]</pre>
<p></p>
<p></p></div><br><br><p></p>
</div></div>
