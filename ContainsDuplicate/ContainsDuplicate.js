/*
Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

Example 1:
Input: nums = [1,2,3,1]
Output: true

Example 2:
Input: nums = [1,2,3,4]
Output: false

Example 3:
Input: nums = [1,1,1,3,3,4,3,2,4,2]
Output: true

Constraints:

1 <= nums.length <= 105
-109 <= nums[i] <= 109
*/

// I: an array of integer
// O: a boolean value indicating whether the array contains duplicate or not
// C: none
// E: one potential case - empty array

const RunTimeArray = require('../RunTime-Array');

function containsDuplicate(nums) {
  // Create a for loop to iterate through the array
  for (let i = 0; i < nums.length; i++) {
    for (let j = i + 1; j < nums.length; j++) {
      if (nums[i] === nums[j]) {
        return true;
      }
    }
  }

  // return false
  return false;
}

function containsDuplicateLinear(nums) {
  const set = new Set(nums);
  // // Create an object to store elements in the array as key and number of appearance in the array as value
  // const obj = {};
  // // Create a loop to iterate through the array
  // for (let i = 0; i < nums.length; i++) {
  //   // store the element in the object and count # of appearance
  //   const currentElement = nums[i]
  //   if (!obj[currentElement]) {
  //     obj[currentElement] = 1;
  //   } else {
  //     obj[currentElement] = obj[currentElement] + 1;
  //   }
  // }

  // // iterate through the object
  // for (let key in obj) {
  //   // if any value > 1; return true
  //   if (obj[key] > 1) {
  //     return true;
  //   }
  // }

  // return false
  return set.size !== nums.length;
}

// RunTimeArray([containsDuplicate, containsDuplicateLinear], 100000000);



module.exports = {
  containsDuplicate,
  containsDuplicateLinear,
}
