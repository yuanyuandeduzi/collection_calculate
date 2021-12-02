package 递归;

/**
*       题目：给定一个m x n 二维字符网格board 和一个字符串单词word 。如果word 存在于网格中，返回 true ；否则，返回 false 。
 *      单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 *      输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 *      输出：true
* */

/*
*       题解：通过深搜实现路径单词的搜索，定义dfs(char[][] board, int[][] book, int y,int x,  int n, int len, String word)方法，
*       由于同一格内的字母不允许被重复使用，所以定义等大book数组用于标记一匹配路径，在回溯时对走过路径进行标记清除。深搜方法中的n为当前匹配位，len
*       为需要匹配的长度，当n==len时，表示word全部匹配，此时将用于标记是否匹配完成的flag修改为true。在中方法中调用dfs方法，随后返回flag。
* */

public class Code_79单词搜索 {
    private int[][] dir = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private boolean flag = false;

    public boolean exist(char[][] board, String word) {
        int[][] book = new int[board.length][board[0].length];
        int n = 0;
        int len = word.length();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(n)) {
                    book[i][j] = 1;
                    dfs(board,book,i,j,n+1,len,word);
                    book[i][j] = 0;
                }
            }
        }
        return flag;
    }

    private void dfs(char[][] board, int[][] book, int y,int x,  int n, int len, String word) {
        if (n == len + 1) {
            flag = true;
            return;
        }
        for (int i = 0; i < 4; i++) {
            int yy = y + dir[i][0];
            int xx = x + dir[i][1];
            if (xx < 0 || xx >= board[0].length || yy < 0 || yy >= board.length) {
                continue;
            }
            if (board[yy][xx] == word.charAt(n) && book[yy][xx] != 1) {
                System.out.println(word.charAt(n));
                book[yy][xx] = 1;
                dfs(board, book, yy, xx, n + 1, len, word);
                book[yy][xx] = 0;
            }
        }
    }
}
