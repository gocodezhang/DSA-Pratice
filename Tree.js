

function leveOrderDFS(root) {
  // create resArr
  const resArr = [];
  // create a helper function (node, level) to put all nodes in a level into the correspdoning position in resArr
  function levelTraversalHelper(node, level) {
    // when the node is null, stop by returning
    if (node === null) {
      return;
    }
    // check if length of resArr === level
    if (resArr.length === level) {
      // create a new array in the index level
      resArr.push([]);
    }
    // add the node in the level
    resArr[level].push(node.val)
    // go to the next level
    levelTraversalHelper(node.left, level + 1);
    levelTraversalHelper(node.right, level + 1);
  }
  levelTraversalHelper(root, 0);

  // return resArr
  return resArr;
}

function levelOrderBFS(root) {
  const resArr = [];
  const queue = [];
  queue.push(root);

  while (queue.length !==0) {
    const level = [];
    const counter = queue.length;
    for (let i = 0; i < counter; i++) {
      const node = queue.shift();
      if (node) {
        level.push(node.val);
        queue.push(node.left);
        queue.push(node.right);
      }
    }

    if (level.length) {
      resArr.push(level);
    }
  }

  return resArr;
}

// function buildQueue(root) {
//   const queue = [];
//   queue.push(root);
//   let leftIndex = 0;
//   let rightIndex = 1;

//   while (leftIndex !== rightIndex) {
//     for (let i = leftIndex; i < rightIndex; i++) {
//       if (queue[i].left) {
//         queue.push(queue[i].left)
//       }
//       if (queue[i].right) {
//         queue.push(queue[i].right)
//       }
//     }
//     leftIndex = rightIndex;
//     rightIndex = queue.length;
//   }

//   return queue.map((node) => (node.val));
// }