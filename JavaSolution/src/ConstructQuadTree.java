public class ConstructQuadTree {
    public QuadTreeNode construct(int[][] grid) {
        int n = grid.length;

        // base case
        // all 1s or all 0s
        int firstValue = grid[0][0];

        boolean isLeaf = true;
        for (int i = 0; i < n && isLeaf; i++) {
            for (int j = 0; j < n && isLeaf; j++) {
                if (grid[i][j] != firstValue) {
                    isLeaf = false;
                }
            }
        }
        // create a leaf node
        QuadTreeNode node = new QuadTreeNode(firstValue == 1, isLeaf);
        if (isLeaf) {
            return node;
        }

        // recursive case
        // divide grid into four
        int m = n / 2;
        int[][] topLeft = new int[m][m];
        int[][] topRight = new int[m][m];
        int[][] bottomLeft = new int[m][m];
        int[][] bottomRight = new int[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                topLeft[i][j] = grid[i][j];
                topRight[i][j] = grid[i][j + m];
                bottomLeft[i][j] = grid[i + m][j];
                bottomRight[i][j] = grid[i + m][j + m];
            }
        }
        // assign children
        node.topLeft = construct(topLeft);
        node.topRight = construct(topRight);
        node.bottomLeft = construct(bottomLeft);
        node.bottomRight = construct(bottomRight);

        return node;
    }
    public QuadTreeNode constructOptimal(int[][] grid) {
        return constructHelper(grid, 0, 0, grid.length);
    }
    private QuadTreeNode constructHelper(int[][] grid, int x, int y, int length) {
        if (length == 1) {
            return new QuadTreeNode(grid[x][y] == 1, true);
        }

        QuadTreeNode topLeft = constructHelper(grid, x, y, length / 2);
        QuadTreeNode topRight = constructHelper(grid, x, y + length / 2, length / 2);
        QuadTreeNode bottomLeft = constructHelper(grid, x + length / 2, y, length / 2);
        QuadTreeNode bottomRight = constructHelper(grid, x + length / 2, y + length / 2, length / 2);

        boolean allLeafs = topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf;
        boolean allSameVals = topLeft.val == topRight.val && topRight.val == bottomLeft.val && bottomLeft.val == bottomRight.val;

        if (allLeafs && allSameVals) {
            return new QuadTreeNode(topLeft.val, allLeafs);
        }
        QuadTreeNode node = new QuadTreeNode();
        node.topLeft = topLeft;
        node.topRight = topRight;
        node.bottomLeft = bottomLeft;
        node.bottomRight = bottomRight;

        return node;
    }
}
