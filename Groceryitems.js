const groceryItems = [
  { type: 'meat', name: 'beef' },
  { type: 'fruit', name: 'watermelon' },
  { type: 'meat', name: 'chicken' },
  { type: 'fruit', name: 'apple' },
  { type: 'fruit', name: 'orange' },
  { type: 'fruit', name: 'pineapple' },
  { type: 'vegetable', name: 'squash' },
  { type: 'vegetable', name: 'lettuce' },
  { type: 'fruit', name: 'strawberry' },
  { type: 'vegetable', name: 'carrots' },
  { type: 'vegetable', name: 'cucumbers' },
];
const packGroceries = (groceryItems, itemsPerBag) => {
  // 1. Create a resultArr to store all bags
  const resultArr = [];
  // 2. Create an object where key represents the cateogy
  // and value represent the bag
  const bags = {}
  // 3. Iterate through the input arr
  for (let i = 0; i < groceryItems.length; i++) {
    // check if category in curr element exist
    if (bags[groceryItems[i].type]) {
      // add item into the corresponding bag
      bags[groceryItems[i].type].push(groceryItems[i]);
      // check if the bag contains k items
      if (bags[groceryItems[i].type].length === itemsPerBag) {
        // if yes, add the bag into resultArr and empty the bag
        resultArr.push(bags[groceryItems[i].type])
        bags[groceryItems[i].type] = [];
      }
    } else {
      // when we have a new category
      // create key using category
      bags[groceryItems[i].type] = [];
      // add curr element as the first element in arr
      bags[groceryItems[i].type].push(groceryItems[i]);
    }

  }
  // 4. iterate through the object
  for (let key in bags) {
    // add every bag contains elements in the resultArr
    if (bags[key].length > 0) {
      resultArr.push(bags[key]);
    }
  }
  // 5. return resultArr
  return resultArr;
}

console.log(packGroceries(groceryItems, 3));