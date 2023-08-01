/*
Given an array of meeting time intervals intervals where intervals[i] = [starti, endi], return the minimum number of conference rooms required.



Example 1:

Input: intervals = [[0,30],[5,10],[15,20]]
Output: 2
Example 2:

Input: intervals = [[7,10],[2,4]]
Output: 1


Constraints:

1 <= intervals.length <= 104
0 <= starti < endi <= 106
*/

var minMeetingRooms = function(intervals) {
  const starts = intervals.map((inverval) => (inverval[0]));
  const ends = intervals.map((inverval) => (inverval[1]));

  starts.sort((a, b) => (a - b));
  ends.sort((a, b) => (a - b));

  let overlap = 0;
  let maxOverlap = 0;
  let endPointer = 0;
  for (let startPointer = 0; startPointer < starts.length; startPointer++) {
      if (starts[startPointer] < ends[endPointer]) {
          overlap++
      } else {
          endPointer++
      }

      if (overlap > maxOverlap) {
          maxOverlap = overlap
      }
  }

  return maxOverlap
};