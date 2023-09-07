/*
You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
Find two lines that together with the x-axis form a container, such that the container contains the most water.
Return the maximum amount of water a container can store.

Notice that you may not slant the container.

Example 1:
Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.

Example 2:
Input: height = [1,1]
Output: 1

Constraints:

n == height.length
2 <= n <= 105
0 <= height[i] <= 104
*/

// I: an array of integers (integer represent height, index will distance)
// O: a number (represent the max amount of waters)
// E: none
// C: none

function maxArea(height) {
  // 1. Create left = 0, maxAmount = 0;
  let left = 0;
  let right = height.length - 1;
  let maxAmount = 0;

  while (left < right) {
    const shorterHeight = Math.min(height[left], height[right]);
    const length = right - left;
    if (maxAmount < (shorterHeight * length)) {
      maxAmount = shorterHeight * length;
    }
    if (height[left + 1] >= height[right - 1]) {
      left = left + 1;
    } else {
      right = right - 1;
    }
  }
  // 3. return maxAmount
  return maxAmount;
}