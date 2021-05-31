package com.spring.boot.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/*
    Given an m x n grid of characters board and a string word, return true if word exists in the grid.

    The word can be constructed from letters of sequentially adjacent cells,
    where adjacent cells are horizontally or vertically neighboring.
    The same letter cell may not be used more than once.


    Example 1:
    Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
    Output: true

    Example 2:
    Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
    Output: true

    Example 3:
    Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
    Output: false


    Constraints:

    m == board.length
    n = board[i].length
    1 <= m, n <= 6
    1 <= word.length <= 15
    board and word consists of only lowercase and uppercase English letters.
 */
public class WordSearchTest {

    @Test
    public void test() {

        char[][] board1 = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        boolean actual1 = isWordExists(board1, "ABCCED");
        Assertions.assertTrue(actual1);

        char[][] board2 = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        boolean actual2 = isWordExists(board2, "SEE");
        Assertions.assertTrue(actual2);

        char[][] board3 = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        boolean actual3 = isWordExists(board3, "ABCB");
        Assertions.assertFalse(actual3);

        char[][] board4 = {{'C', 'A', 'A'}, {'A', 'A', 'A'}, {'B', 'C', 'D'}};
        boolean actual4 = isWordExists(board4, "AAB");
        Assertions.assertTrue(actual4);

        char[][] board5 = {{'A', 'B', 'C'}, {'D', 'E', 'F'}, {'G', 'H', 'I'}};
        boolean actual5 = isWordExists(board5, "ABA");
        Assertions.assertFalse(actual5);
    }

    private boolean isWordExists(char[][] board, String word) {

        if (board == null || board.length == 0 || board[0].length == 0 || word == null || word.isEmpty()) {
            return false;
        }

        for (int i = 0; i < board.length; i++) {
            char[] row = board[i];
            for (int j = 0; j < row.length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    char[][] path = new char[board.length][board[0].length];
                    if (dfs(board, word, i, j, 0, path)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word, int boardIdx, int rowIdx, int wordIdx, char[][] path) {

        System.out.println("boardIdx: " + boardIdx + ", rowIdx: " + rowIdx + ", wordIdx: " + wordIdx);

        if (wordIdx > word.length() - 1) {
            System.out.println("Completed.");
            return true;
        }

        if (boardIdx < 0 || rowIdx < 0 ||
                boardIdx >= board.length || rowIdx >= board[0].length ||
                word.charAt(wordIdx) != board[boardIdx][rowIdx] || path[boardIdx][rowIdx] != '\u0000') {
            System.out.println("Failed.");
            return false;

        } else {
            path[boardIdx][rowIdx] = board[boardIdx][rowIdx];
        }

        if (dfs(board, word, boardIdx - 1, rowIdx, wordIdx + 1, path) ||
                dfs(board, word, boardIdx, rowIdx + 1, wordIdx + 1, path) ||
                dfs(board, word, boardIdx + 1, rowIdx, wordIdx + 1, path) ||
                dfs(board, word, boardIdx, rowIdx - 1, wordIdx + 1, path)) {

            return true;
        }

        return false;
    }

    private char[][] copyArray(char[][] array) {

        char[][] copiedArray = new char[array.length][array[0].length];

        for (int i = 0; i < array.length; i++) {
            char[] row = array[i];
            for (int j = 0; j < row.length; j++) {
                char ch = array[i][j];
                copiedArray[i][j] = ch;
            }
        }

        return copiedArray;
    }
}
