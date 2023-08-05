/*
Write an algorithm to determine if a number n is happy.

A happy number is a number defined by the following process:

Starting with any positive integer, replace the number by the sum of the squares of its digits.
Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
Those numbers for which this process ends in 1 are happy.
Return true if n is a happy number, and false if not.



Example 1:

Input: n = 19
Output: true
Explanation:
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
Example 2:

Input: n = 2
Output: false


Constraints:

1 <= n <= 231 - 1
*/
var isHappy = function(n) {
  // create a set to store all number seen
  const seen = new Set()
  let currNum = n;
  // while curr num is not in the set
  while (!seen.has(currNum)) {
      seen.add(currNum);
      // sum its digit
      let sum = 0;
      // keep dividing the curr num by 10 while quotient is not equal to 0
      while (currNum !== 0) {
          // accumulate the sqaure of remainder
          const remainder = currNum % 10;
          // reassign the curr num = quotient
          const quotient = Math.floor(currNum / 10)

          sum += remainder * remainder
          currNum = quotient;
      }
      // check if the sum === 1
      if (sum === 1) {
          // return true
          return true;
      }
      currNum = sum;
  }


  // return false
  return false;
};