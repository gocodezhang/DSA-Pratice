/*
There is an integer array nums sorted in ascending order (with distinct values).
Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is
[nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.



Example 1:
Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4

Example 2:
Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1

Example 3:
Input: nums = [1], target = 0
Output: -1

Constraints:

1 <= nums.length <= 5000
-104 <= nums[i] <= 104
All values of nums are unique.
nums is an ascending array that is possibly rotated.
-104 <= target <= 104
*/

// I: an sorted array of integers that is possibly rorated; target
// O: a number representing the index of target
// E: none
// C: log time complexity

function search(nums, target) {
  // 1. Create left and right pointers
  // left = 0; right = length - 1;
  let left = 0;
  let right = nums.length - 1;
  let middle = Math.ceil((left + right) / 2);
  // 2. Check if left value < right value
  if (nums[left] < nums[right]) {
    // we have a sorted array
    // perform regular b-search while (right - left > 1)
    while (right - left > 1) {
      // check if middle < target
      if (nums[middle] < target) {
        left = middle;
      } else {
        right = middle;
      }
      middle = Math.ceil((left + right) / 2);
    }
  } else {
    // while (right - left > 1)
    while (right - left > 1) {
      // caculate the middle pointer
      // check if left value < middle
      if (nums[left] < nums[middle]) {
          // if yes,
          // check if target is between left middle
          if (nums[left] <= target && target <= nums[middle]) {
            // if yes, right = middle
            right = middle;
          } else {
            // else, left = middle
            left = middle;
          }
      }
      // check if middle < right
      if (nums[middle] < nums[right]) {
        // if yes,
        // check if target is between middle and right
        if (nums[middle] <= target && target <= nums[right]) {
          // if yes, left = middle
          left = middle;
        } else {
          right = middle;
        }
      }
      middle = Math.ceil((left + right) / 2);
    }
  }
  // 4. check left value === target
  if (nums[left] === target) {
    return left
  } else if (nums[right] === target) {
    return right
  } else {
    return -1
  }
}