/*
Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.



Example 1:

Input: temperatures = [73,74,75,71,69,72,76,73]
Output: [1,1,4,2,1,1,0,0]
Example 2:

Input: temperatures = [30,40,50,60]
Output: [1,1,1,0]
Example 3:

Input: temperatures = [30,60,90]
Output: [1,1,0]


Constraints:

1 <= temperatures.length <= 105
30 <= temperatures[i] <= 100
*/

// brute force
var dailyTemperatures = function(temperatures) {
  // resArr that has same length (0)
  const resArr = new Array(temperatures.length).fill(0);
  // Iterate through the array
  for (let i = 0; i < temperatures.length; i++) {
      // curr element (i)
      const currElement = temperatures[i]
      let steps = 0;
      let find = false;
      // steps = 0, find = false;
      // iterate through elements after the curr element
      for (let j = i + 1; j < temperatures.length; j++) {
          // increment steps
          steps += 1;
          // check if the element > curr element
          if (temperatures[j] > currElement) {
              // when true,
              // find = true
              //break the inner loop
              find = true
              break;
          }
      }

      // check if find is true
      if (find) {
          // when true, add steps value in i position
          resArr[i] = steps;
      } else {
          // otherwise, add 0
          resArr[i] = 0;
      }

  }

  // return resArr
  return resArr;
};

// monoStack
var dailyTemperatures = function(temperatures) {
  const resArr = new Array(temperatures.length).fill(0);
  const stack = [];

  for (let i = 0; i < temperatures.length; i++) {
      const currElement = temperatures[i]

      while (stack.length > 0 && stack[stack.length - 1][1] < currElement) {
          const [index, temp] = stack.pop();
          resArr[index] = i - index;
      }
      stack.push([i, currElement]);
  }
  return resArr;
};