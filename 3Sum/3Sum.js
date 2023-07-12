/*
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
Notice that the solution set must not contain duplicate triplets.

Example 1:
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation:
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.

Example 2:
Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.

Example 3:
Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.

Constraints:

3 <= nums.length <= 3000
-105 <= nums[i] <= 105
*/

// I: an array of integers
// O: an array of arrays where each array respresent a triplets
// E: 2) when no solution return [];
// C: none

function threeSum(nums) {
  nums.sort((a, b) => (a - b));
  const resArr = [];
  // 1. Iterate through the input arr
  for (let i = 0; i < nums.length; i++) {
  // 2. at each iteration, it becomes a two sum question
    // two sum = - curr element (target)
    const target = - nums[i];
    // arr = all elements to the right of curr element
    // iterate through the hashset
    const seen = new Set();
    for (let j = i + 1; j < nums.length; j++) {
      // at curr num
      const thirdNum = target - nums[j];
      // check if target - curr num exist in hash set
      if (seen.has(thirdNum)) {
        // if yes, add these three number into the resArr
        resArr.push([nums[i], nums[j], thirdNum])
      }
      seen.add(nums[j]);
    }
    while ((i + 1 < nums.length) && (nums[i] === nums[i + 1])) {
      i++
    }
  }
  // 3. return resArr
  return resArr;

}

function threeSumPointers(nums) {
  const resArr = [];
  // sort the nums array in ascending order
  nums.sort((a, b) => (a - b));
  // Iterate through the nums array
  for (let i = 0; i < nums.length; i++) {
    // create two pointers - left: start at the next position ; right: start at the end of nums
    let left = i + 1;
    let right = nums.length - 1;
    // Repear below steps as long as left < right
    while (left < right) {
      // check if curr num + left + right === 0
      if (nums[i] + nums[left] + nums[right] === 0) {
        // if yes, add the triplet into resArr and move left forward and right backward
        resArr.push([nums[i], nums[left], nums[right]])
        left++;
        right--;
      } else if (nums[i] + nums[left] + nums[right] > 0) {
        // else if check num + left + right > 0
        // if yes, keep left but move right backward
        right--;
      } else {
        // else check num + left + right < 0
        // keep right but move left forward
        left++;
      }
    }
    // skip the next num if it is the same as curr
    if (nums[i] === nums[i + 1]) {
      i++
    }
  }
  // return resArr
  return resArr;
}