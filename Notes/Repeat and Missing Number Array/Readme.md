https://www.interviewbit.com/problems/repeat-and-missing-number-array/

1. Sum till N and Sum of Squares till n (Overflows because of square)

- Calculate sum(nums), sum(square of each num), sum(1...n), sum(1^2...n^2)
- X = sum(nums) - sum(1...n) = A - B
- Y = sum(square of each num) - sum(1^2...n^2) = A^2 - B^2 = (A+B)(A-B) = (A+B)X

A - B = X
XA + XB = Y

A = X + B
X^2 + 2BX = Y
B = (Y - X^2)/2X

- Calculate B using B = (Y - X^2)/2X
- Calulate A using A = X + B

Time - n
Space - 1

2. Using XOR

1. xor = XOR(nums) ^ XOR(1...n) = A ^ B
2. Find two nums in 1...n, such that xor(num1,num2) = A ^ B
3. Group the nums and 1...n in two buckets X and Y such based on ith 
    bit is set or not.(where i is the first set bit of xor)
4. X and Y are the missing and the repeating number.
5. Iterate over the array to check whether X is missing or Y is missing

Time - n + n + n
Space - 1
