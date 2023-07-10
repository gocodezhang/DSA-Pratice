/*
Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
You must write an algorithm that runs in O(n) time and without using the division operation.

Example 1:
Input: nums = [1,2,3,4]
Output: [24,12,8,6]

Example 2:
Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]

Constraints:

2 <= nums.length <= 105
-30 <= nums[i] <= 30
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.


Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)
*/

// I: an array of nums
// O: an array of nums; each num will be the product of all element except nums[i]
// E: none
// C: linear time complexity

function productExceptSelf(nums) {
  // 1. create L and R arrays (same length as nums)
  const left = new Array(nums.length).fill(1);
  const right = new Array(nums.length).fill(1);
  // 2. Iterate through the nums
  // left to right
  let leftValue = 1;
  for (let i = 0; i < nums.length; i++) {
    // curr position = i
    // compute L[i] = all products to the left of i
    if (i !== 0) {
      leftValue = leftValue * nums[i - 1];
    }
    left[i] = leftValue;
  }
  // right to left
  let rightValue = 1;
  for (let i = nums.length - 1; i >= 0; i--) {
    // curr position = i
    // compute R[i] = the product of all elements to the right of i
    if (i !== (nums.length - 1)) {
      rightValue = rightValue * nums[i + 1];
    }
    right[i] = rightValue
  }
  // 3. Iterate through L and R arrays
  const resultArr = [];
  for (let i = 0; i < nums.length; i++) {
    // L[i] * R[i] and push that into the resultArr
    resultArr.push(left[i] * right[i])
  }
  // 4. return resultArr
  return resultArr;
}