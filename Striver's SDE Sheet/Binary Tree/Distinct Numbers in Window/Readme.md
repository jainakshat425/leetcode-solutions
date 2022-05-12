https://www.interviewbit.com/problems/distinct-numbers-in-window/
<div class="p-html-content p-statement"><div class="p-html-content__container"><p><strong>Problem Description</strong><br></p><div id="problem_description_markdown_content_value" style="background-color: #f9f9f9; padding: 5px 10px; "><p>You are given an array of <strong>N</strong> integers, <strong>A<sub>1</sub>, A<sub>2</sub> ,..., A<sub>N</sub></strong> and an integer <strong>B</strong>. Return the of count of distinct numbers in all windows of size <strong>B</strong>.
</p><p></p><p></p><p></p>
<p>Formally, return an array of size <strong>N-B+1</strong> where <strong>i'th</strong> element in this array contains number of distinct elements in sequence <strong>A<sub>i</sub>, A<sub>i+1</sub> ,..., A<sub>i+B-1</sub>.</strong></p>
<p><strong>NOTE: </strong> if <strong>B</strong> &gt; <strong>N</strong>, return an empty array.</p>
<p></p>
<p></p>
<p></p></div><br><br><strong>Input Format</strong><br><div id="input_format_markdown_content_value" style="background-color: #f9f9f9; padding: 5px 10px; "><p>First argument is an integer array A<br>
Second argument is an integer B.</p></div><br><br><strong>Output Format</strong><br><div id="output_format_markdown_content_value" style="background-color: #f9f9f9; padding: 5px 10px; "><p>Return an integer array.</p></div><br><br><strong>Example Input</strong><br><div id="example_input_markdown_content_value" style="background-color: #f9f9f9; padding: 5px 10px; "><p>Input 1:</p><p></p><p></p><p></p>
<pre> A = [1, 2, 1, 3, 4, 3]
 B = 3</pre>
<p>Input 2:</p>
<pre> A = [1, 1, 2, 2]
 B = 1</pre>
<p></p>
<p></p>
<p></p></div><br><br><strong>Example Output</strong><br><div id="example_output_markdown_content_value" style="background-color: #f9f9f9; padding: 5px 10px; "><p>Output 1:</p><p></p><p></p><p></p>
<pre> [2, 3, 3, 2]</pre>
<p>Output 2:</p>
<pre> [1, 1, 1, 1]</pre>
<p></p>
<p></p>
<p></p></div><br><br><strong>Example Explanation</strong><br><div id="example_explanation_markdown_content_value" style="background-color: #f9f9f9; padding: 5px 10px; "><p>Explanation 1:</p><p></p><p></p><p></p>
<pre> A=[1, 2, 1, 3, 4, 3] and B = 3
 All windows of size B are
 [1, 2, 1]
 [2, 1, 3]
 [1, 3, 4]
 [3, 4, 3]
 So, we return an array [2, 3, 3, 2].</pre>
<p>Explanation 2:</p>
<pre> Window size is 1, so the output array is [1, 1, 1, 1].</pre>
<p></p>
<p></p>
<p></p></div><br><br><p></p>
</div></div>
