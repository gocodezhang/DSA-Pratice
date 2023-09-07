var pacificAtlantic = function(heights) {
    const nRows = heights.length;
    const nCols = heights[0].length;

    const pacific = new Set();
    const atlantic = new Set();

    const options = {
        up: [-1, 0],
        down: [1, 0],
        left: [0, -1],
        right: [0, 1],
    }

    function dfs(currPosition, visit, prevHeight) {
        const [r, c] = currPosition;
        if (r < 0 || r > nRows - 1) {
            return;
        }
        if (c < 0 || c > nCols - 1) {
            return;
        }
        const coord = `${r}-${c}`
        if (visit.has(coord) || heights[r][c] < prevHeight) {
            return;
        }
        visit.add(coord);

        for (let dir in options) {
            const nextPosition = [r + options[dir][0], c + options[dir][1]];
            dfs(nextPosition, visit, heights[r][c]);
        }

    }

    for (let col = 0; col < nCols; col++) {
        dfs([0, col], pacific, heights[0][col]);
        dfs([nRows - 1, col], atlantic, heights[nRows - 1][col]);
    }

    for (let row = 0; row < nRows; row++) {
        dfs([row, 0], pacific, heights[row][0]);
        dfs([row, nCols - 1], atlantic, heights[row][nCols - 1]);
    }

    const resArr = [];
    for (let i = 0; i < nRows; i++) {
        for (let j = 0; j < nCols; j++) {
            const currCoor = `${i}-${j}`;
            if (pacific.has(currCoor) && atlantic.has(currCoor)) {
                resArr.push([i, j]);
            }
        }
    }

    return resArr;
}