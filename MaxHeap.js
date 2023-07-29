
function maxHeap() {
  this.storage = [0];
  this.size = 0;
}

maxHeap.prototype.getLargest = function() {
  return this.storage[1];
}

maxHeap.prototype.add = function(num) {
  // 1. Put the new element in the back
  this.storage.push(num);
  this.size = this.size + 1;
  // 2. Repeat below steps 1) new element < its parent 2) new element is not at the top
  let index = this.storage.length - 1;
  let parentIndex = Math.floor(index / 2)
  while (index > 1 && this.storage[index] > this.storage[parentIndex]) {
    //swap the new element with its parent
    const temp = this.storage[index]
    this.storage[index] = this.storage[parentIndex]
    this.storage[parentIndex] = temp;

    index = parentIndex
    parentIndex = Math.floor(index / 2);
  }

}

maxHeap.prototype.removeLargest = function() {
  if (this.storage.length === 1) {
    return;
  } else if (this.storage.length === 2) {
    this.size = this.size - 1;
    return this.storage.pop();
  } else {
    // 2. add the last element as the first
    const remove = this.storage[1];
    const last = this.storage.pop()
    this.size = this.size - 1;
    this.storage[1] = last;
    // 3. Demote to better successor if needed
    let index = 1;
    let childLeft = index * 2 > this.storage.length ? null : index * 2;
    let childRight = index * 2 + 1 > this.storage.length ? null : index * 2 + 1;
    let largestChild;
    if (childLeft === null) {
      largestChild = null;
    } else if (childRight === null) {
      largestChild = this.storage[childLeft];
    } else {
      largestChild = this.storage[childLeft] >= this.storage[childRight] ? childLeft : childRight;
    }
    // Repeat below as long as 1) the last > its children 2) its children is not null
    while (childLeft !== null && this.storage[index] < this.storage[largestChild]) {
      // swap the smallest child with the last
      const temp = this.storage[index];
      this.storage[index] = this.storage[largestChild]
      this.storage[largestChild] = temp;

      index = largestChild;
      childLeft = index * 2 > this.storage.length ? null : index * 2;
      childRight = index * 2 + 1 > this.storage.length ? null : index * 2 + 1;
      if (childLeft === null) {
        largestChild = null;
      } else if (childRight === null) {
        largestChild = this.storage[childLeft];
      } else {
        largestChild = this.storage[childLeft] >= this.storage[childRight] ? childLeft : childRight;
      }
    }

    return remove;
  }

}

module.exports = maxHeap;