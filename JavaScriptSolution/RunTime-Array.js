const { performance } = require('perf_hooks');

function randomNumberGenerator(min, max) {
  return Math.floor(Math.random() * (max - min + 1)) + min;
}

function RunTimeArray(algos ,sizeOfArray) {
  const randomArray = new Array(sizeOfArray).fill(1);
  randomArray.forEach((element, i) => {
    randomArray[i] = randomNumberGenerator(0, 1000000);
  });

  const start1 = performance.now();
  algos[0](randomArray);
  const timeTaken1 = performance.now() - start1
  console.log('Time Taken:', timeTaken1);

  const start2 = performance.now();
  algos[1](randomArray);
  const timeTaken2 = performance.now() - start2
  console.log('Time Taken:', timeTaken2);
  return;
}

module.exports = RunTimeArray;