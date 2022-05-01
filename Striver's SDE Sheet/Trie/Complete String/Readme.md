https://www.codingninjas.com/codestudio/problems/complete-string_2687860?utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_tries_videos&leftPanelTab=0

<div _ngcontent-serverapp-c204="" class="description ng-star-inserted"><h4 id="ninja-developed-a-love-for-arrays-and-strings-so-this-time-his-teacher-gave-him-an-array-of-strings-a-of-size-n-each-element-of-this-array-is-a-string-the-teacher-taught-ninja-about-prefixes-in-the-past-so-he-wants-to-test-his-knowledge">Ninja developed a love for arrays and strings so this time his teacher gave him an array of strings, ‘A’ of size ‘N’. Each element of this array is a string. The teacher taught Ninja about prefixes in the past, so he wants to test his knowledge.</h4>

<h4 id="a-string-is-called-a-complete-string-if-every-prefix-of-this-string-is-also-present-in-the-array-a-ninja-is-challenged-to-find-the-longest-complete-string-in-the-array-a-if-there-are-multiple-strings-with-the-same-length-return-the-lexicographically-smallest-one-and-if-no-string-exists-return-quot-none-quot">A string is called a complete string if every prefix of this string is also present in the array ‘A’. Ninja is challenged to find the longest complete string in the array ‘A’.If there are multiple strings with the same length, return the lexicographically smallest one and if no string exists, return "None".</h4>

<h5 id="note">Note :</h5>

<pre><code>String ‘P’ is lexicographically smaller than string ‘Q’, if : 

1. There exists some index ‘i’ such that for all ‘j’ &lt; ‘i’ , ‘P[j] = Q[j]’ and ‘P[i] &lt; Q[i]’. E.g. “ninja” &lt; “noder”.

2. If ‘P’ is a prefix of string ‘Q’, e.g. “code” &lt; “coder”.
</code></pre>

<h5 id="example">Example :</h5>

<pre><code>N = 4
A = [ “ab” , “abc” , “a” , “bp” ] 

Explanation : 

Only prefix of the string “a” is “a” which is present in array ‘A’. So, it is one of the possible strings.

Prefixes of the string “ab” are “a” and “ab” both of which are present in array ‘A’. So, it is one of the possible strings.

Prefixes of the string “bp” are “b” and “bp”. “b” is not present in array ‘A’. So, it cannot be a valid string.

Prefixes of the string “abc” are “a”,“ab” and “abc” all of which are present in array ‘A’. So, it is one of the possible strings.

We need to find the maximum length string, so “abc” is the required string.
</code></pre>

<h5 id="input-format">Input Format :</h5>

<pre><code>The first line contains an integer 'T' which denotes the number of test cases to be run. Then the test cases follow.

The second line of each test case contains an integer ‘N’ denoting the size of array ‘A’.

The third line of each test case contains ‘N’ space-separated strings denoting the elements of array ‘A’.
</code></pre>

<h5 id="output-format">Output format :</h5>

<pre><code>For each test case, print the longest string in ‘A’, such that every prefix of this string is also present in the array ‘A’. If there are multiple strings with the same length, return the lexicographically smallest one and if no string exists, return "None" as answer.

Print the output of each test case in a new line.
</code></pre>

<h5 id="note">Note :</h5>

<pre><code>You don’t need to print anything. It has already been taken care of. Just implement the given function.
</code></pre>

<h5 id="constraints">Constraints :</h5>

<pre><code>1 &lt;= T &lt;= 10
1 &lt;= N &lt;= 10^5
1 &lt;= A[i].length &lt;= 10^5
A[i] only consists of lowercase english letters.
Sum of A[i].length &lt;= 10^5 over all test cases

Time Limit : 1 sec
</code></pre>
</div>
