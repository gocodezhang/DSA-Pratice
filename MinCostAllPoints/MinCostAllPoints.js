/*
You are given an array points representing integer coordinates of some points on a 2D-plane, where points[i] = [xi, yi].

The cost of connecting two points [xi, yi] and [xj, yj] is the manhattan distance between them: |xi - xj| + |yi - yj|, where |val| denotes the absolute value of val.

Return the minimum cost to make all points connected. All points are connected if there is exactly one simple path between any two points.



Example 1:


Input: points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
Output: 20
Explanation:

We can connect the points as shown above to get the minimum cost of 20.
Notice that there is a unique path between every pair of points.
Example 2:

Input: points = [[3,12],[-2,5],[-4,1]]
Output: 18


Constraints:

1 <= points.length <= 1000
-106 <= xi, yi <= 106
All pairs (xi, yi) are distinct.
*/

var minCostConnectPoints = function(points) {
  // initlaize variables
  const inMST = new Array(points.length).fill(0);
  const heap = new minHeap();
  heap.add([0, 0])
  let edge = 0;
  let cost = 0;

  while (edge < points.length) {
      const [node, distance] = heap.removeSmallest();

      if (inMST[node] === 0) {
          inMST[node] = 1;
          cost = cost + distance;
          edge = edge + 1;

          for (let nextnode = 0; nextnode < points.length; nextnode++) {
              if (inMST[nextnode] === 0) {
                  const updatedDistance = Math.abs(points[node][0] - points[nextnode][0]) + Math.abs(points[node][1] - points[nextnode][1])
                  heap.add([nextnode, updatedDistance])
              }
          }
      }
  }
  return cost;
};

function minHeap() {
this.storage = [0];
}

minHeap.prototype.getSmallest = function() {
return this.storage[1];
}

minHeap.prototype.add = function(num) {
// 1. Put the new element in the back
this.storage.push(num);
// 2. Repeat below steps 1) new element < its parent 2) new element is not at the top
let index = this.storage.length - 1;
let parentIndex = Math.floor(index / 2)
while (index > 1 && this.storage[index][1] < this.storage[parentIndex][1]) {
  //swap the new element with its parent
  const temp = this.storage[index]
  this.storage[index] = this.storage[parentIndex]
  this.storage[parentIndex] = temp;

  index = parentIndex
  parentIndex = Math.floor(index / 2);
}

}

minHeap.prototype.removeSmallest = function() {
if (this.storage.length === 1) {
  return;
} else if (this.storage.length === 2) {
  return this.storage.pop();
} else {
  // 2. add the last element as the first
  const remove = this.storage[1];
  const last = this.storage.pop()
  this.storage[1] = last;
  // 3. Demote to better successor if needed
  let index = 1;
  let childLeft = index * 2 > this.storage.length - 1 ? null : index * 2;
  let childRight = index * 2 + 1 > this.storage.length - 1 ? null : index * 2 + 1;
  let smallestChild;
  if (childLeft === null) {
    smallestChild = null;
  } else if (childRight === null) {
    smallestChild = childLeft;
  } else {
    smallestChild = this.storage[childLeft][1] <= this.storage[childRight][1] ? childLeft : childRight;
  }
  // Repeat below as long as 1) the last > its children 2) its children is not null
  while (childLeft !== null && this.storage[index][1] > this.storage[smallestChild][1]) {
    // swap the smallest child with the last
    const temp = this.storage[index];
    this.storage[index] = this.storage[smallestChild]
    this.storage[smallestChild] = temp;

    index = smallestChild;
    childLeft = index * 2 > this.storage.length - 1 ? null : index * 2;
    childRight = index * 2 + 1 > this.storage.length - 1 ? null : index * 2 + 1;
    if (childLeft === null) {
      smallestChild = null;
    } else if (childRight === null) {
      smallestChild = childLeft;
    } else {
      smallestChild = this.storage[childLeft][1] <= this.storage[childRight][1] ? childLeft : childRight;
    }
  }

  return remove;
}

}