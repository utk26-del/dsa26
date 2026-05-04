// https://leetcode.com/problems/n-queens/description/

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                board[r][c] = '.';
            }
        }
        helper(board, 0, n, result);
        return result;
    }

    private void helper(char[][] board, int r, int n, List<List<String>> result) {
        if (r == n) {
            result.add(constructResult(board));
            return;
        }

        for (int c = 0; c < n; c++) {
            if (isSafe(board, r, c)) {
                board[r][c] = 'Q';
                helper(board, r + 1, n, result);
                board[r][c] = '.';
            }
        }
    }

    private boolean isSafe(char[][] board, int r, int c) {
        return isSafeLeftD(board, r - 1, c - 1) && isSafeTop(board, r - 1, c) && isSafeRightD(board, r - 1, c + 1);
    }

    private boolean isSafeLeftD(char[][] board, int r, int c) {
        while (r >= 0 && c >= 0) {
            char ch = board[r][c];
            if (ch == 'Q')
                return false;

            r--;
            c--;
        }
        return true;
    }

    private boolean isSafeTop(char[][] board, int r, int c) {
        while (r >= 0) {
            char ch = board[r][c];
            if (ch == 'Q')
                return false;

            r--;
        }
        return true;
    }

    private boolean isSafeRightD(char[][] board, int r, int c) {
        int n = board.length;
        while (r >= 0 && c < n) {
            char ch = board[r][c];
            if (ch == 'Q')
                return false;

            r--;
            c++;
        }
        return true;
    }

    private List<String> constructResult(char[][] board) {
        int n = board.length;
        List<String> list = new ArrayList<>();
        for (int r = 0; r < n; r++) {
            StringBuilder sb = new StringBuilder();
            for (int c = 0; c < n; c++) {
                sb.append(board[r][c]);
            }
            list.add(sb.toString());
        }
        return list;
    }
}