package 递归;

/**
*       题目：给你一个大小为 m x n 的整数矩阵 grid ，表示一个网格。另给你三个整数row、col 和 color 。网格中的每个值表示该位置处的网格块的颜色。
 *          两个网格块属于同一 连通分量 需满足下述全部条件。
 *              两个网格块颜色相同
 *              在上、下、左、右任意一个方向上相邻
 *          连通分量的边界 是指连通分量中满足下述条件之一的所有网格块：
 *              在上、下、左、右四个方向上与不属于同一连通分量的网格块相邻
 *              在网格的边界上（第一行/列或最后一行/列）
 *          请你使用指定颜色color 为所有包含网格块grid[row][col] 的 连通分量的边界 进行着色，并返回最终的网格grid 。
 *
 *          输入：grid = [[1,1],[1,2]], row = 0, col = 0, color = 3
 *          输出：[[3,3],[3,2]]
 *          输入：grid = [[1,2,2],[2,3,2]], row = 0, col = 1, color = 3
 *          输出：[[1,3,3],[2,3,3]]
 * */

/*
*       题解：本题为一道搜索题，难点在与读懂题，连通分量指：假如起始起始点是值为 ‘2’ 的点，哪么此点的连通分量与此点上下左右相连的值为 ‘2’
*       的点（类似与岛屿问题的岛与海的关系），连通分量边界为上连通分量中的点，若此点处于二位数组的边界，即题目所说的（第一行/列或最后一行/列）
*       或者是此点上下左右至少存在一个与此点值不一样的点。而本体要求我们将连通分量边界的点的值修改位 color，在读懂题后，我们采用dfs对数组进行
*       搜索，定义book标记走过的点，避免重复搜索.搜索逻辑：若当前点为数组边界则修改其值，然后开始判断其上下左右四个方向是与当前点连通，若连通
*       则标记该点，并进入下层dfs，否则将将当前点的值修改。执行dfs方法，将初始点标记，返回原数组。A
* */


public class Code_1034边界着色 {
    private int[][] dir = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int row1 = grid.length;
        int col1 = grid[0].length;
        int[][] book = new int[row1][col1];
        book[row][col] = 1;
        dfs(grid,row,col,row1,col1,book,grid[row][col],color);
        return grid;
    }

    private void dfs(int[][] grid,int x, int y, int row,int col,int[][] book,int target, int color) {
        if(x == 0 || y == 0 || x == row - 1 || y == col - 1) {
            grid[x][y] = color;
        }
        for(int i = 0; i < 4; i++) {
            int xx = x + dir[i][0];
            int yy = y + dir[i][1];
            if(xx < 0 || yy < 0 || xx >= row || yy >= col || book[xx][yy] == 1) {
                continue;
            }
            if(grid[xx][yy] == target) {
                book[xx][yy] = 1;
                dfs(grid,xx,yy,row,col,book,target,color);
            }else {
                grid[x][y] = color;
            }
        }
    }
}
