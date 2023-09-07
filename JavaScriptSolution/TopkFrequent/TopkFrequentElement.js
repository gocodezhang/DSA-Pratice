/*
Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

Example 1:
Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]

Example 2:
Input: nums = [1], k = 1
Output: [1]


Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104
k is in the range [1, the number of unique elements in the array].
It is guaranteed that the answer is unique.


Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
*/

// I: an array and an integer k
// O: an array containing the top k most frequent elements
// C: none
// E: none

function topKFrequent(nums, k) {
  // create a map to store unique elements and # of time elements appear in nums
  const frequencyObj = new Map();
  // iterate through the nums
  for (let i = 0; i < nums.length; i++) {
    const currElement = nums[i]
    // if current element exist as key, increment the value by 1
    if (frequencyObj.get(currElement)) {
      frequencyObj.set(currElement, frequencyObj.get(currElement) + 1)
    } else {
      // if current element does not exist, create the key and assign the value as 1
      frequencyObj.set(currElement, 1)
    }
  }
  // sort the array the contains the # of time
  const frequencyArr = [...frequencyObj.values()].sort((a, b) => {
    if (a > b) {
      return -1
    } else if (a < b) {
      return 1
    } else {
      return 0
    }
  })
  // find the top k frequency
  const topKArr = frequencyArr.slice(0, k);

  // iterate through the map object and find the element that value including in the top k frequency
  const resultArr = [];
  frequencyObj.forEach((value, key) => {
    if (topKArr.includes(value)) {
      resultArr.push(key)
    }
  })

  return resultArr;
}

function topKFrequent(nums, k) {
  const frequencyArr = [];
  let maxFrequency = 0;
  // create a map to store unique elements and # of time elements appear in nums
  const frequencyObj = new Map();
  // iterate through the nums
  for (let i = 0; i < nums.length; i++) {
    const currElement = nums[i]
    let currFrequency = 0;
    // if current element exist as key, increment the value by 1
    if (frequencyObj.get(currElement)) {
      currFrequency = frequencyObj.get(currElement) + 1
      frequencyObj.set(currElement, currFrequency)
    } else {
      // if current element does not exist, create the key and assign the value as 1
      frequencyObj.set(currElement, 1)
      currFrequency = 1;
    }

    if (currFrequency > maxFrequency) {
      maxFrequency = currFrequency;
      frequencyArr.unshift(maxFrequency)
    }
  }

  const topKArr = frequencyArr.slice(0, k);

  const resultArr = [];
  frequencyObj.forEach((value, key) => {
    if (topKArr.includes(value)) {
      resultArr.push(key)
    }
  })

  return resultArr;
}
