package Boggle.Board;

import Boggle.Controller.BoggleController;
import com.sun.javafx.tk.Toolkit;
import javafx.concurrent.Task;

import javax.swing.tree.TreeNode;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

/**
 * Created by Cyriel on 17-3-2017.
 */
public class Board {
    static char[][] boggleBoard = new char[4][4];
    public static ArrayList<boardCell> cellsOnBoard = new ArrayList<>();

    ArrayList<String> foundWords;
    TrieNode root;
    Trie trie;

    public Board() {
        root = new TrieNode();
        trie = new Trie();
        trie.readList();
        foundWords = new ArrayList<>();
    }

    // http://www.programcreek.com/2014/05/leetcode-implement-trie-prefix-tree-java/
    // https://www.toptal.com/java/the-trie-a-neglected-data-structure

    public String recursiveSearch(boardCell root) {
        StringBuilder prefix = new StringBuilder(root.getCharacterInCellAsString());
        if (trie.search(prefix.toString())) {
            System.out.println("Found word : " + prefix.toString());
            foundWords.add(prefix.toString());
        }

        System.out.println("tested prefix : " + prefix.toString());
        if (trie.startsWith(prefix.toString())) {
            for (boardCell a : getMoves(root)) {
                prefix.append(a.getCharacterInCellAsString());
                System.out.println("there is a word with prefix : " + prefix.toString());
                recursiveSearch(a);

                //      System.out.println("Original cell : " + root.getCharacterInCellAsString() + " , move cell : "+ a.getCharacterInCellAsString());
            }
        }
        return null;
    }


    public ArrayList<boardCell> getMoves(boardCell cell) {
        ArrayList<boardCell> PossibleMoves = new ArrayList<>();

        int row = cell.getRow();
        int col = cell.getCol();
//        if (trie.search(prefix)) {
//            foundWords.add(prefix);
//        }

        boolean u, d, r, l;
        u = cell.getRow() - 1 >= 0;
        d = cell.getRow() + 1 < 4;
        r = cell.getCol() + 1 < 4;
        l = cell.getCol() - 1 >= 0;

        //up
        if (u) {
            PossibleMoves.add(getBoardCell(row - 1, col));
        }

        //down
        if (d) {
            PossibleMoves.add(getBoardCell(row + 1, col));
        }

        //right
        if (r) {
            PossibleMoves.add(getBoardCell(row, col + 1));
        }
        //left
        if (l) {
            PossibleMoves.add(getBoardCell(row, col - 1));
        }
        //upleft
        if (u && l) {
            PossibleMoves.add(getBoardCell(row - 1, col - 1));
        }
        //upright
        if (u && r) {
            PossibleMoves.add(getBoardCell(row - 1, col + 1));
        }
        //downleft
        if (d && l) {
            PossibleMoves.add(getBoardCell(row + 1, col - 1));
        }
        //down right
        if (d && r) {
            PossibleMoves.add(getBoardCell(row + 1, col + 1));
        }
        return PossibleMoves;
    }

    public boardCell getBoardCell(int row, int col) {
        for (boardCell a : cellsOnBoard) {
            if (a.getRow() == row && a.getCol() == col) {
                return a;
            }
        }
        return null;
    }

    public ArrayList<String> searchBoard() {
        System.out.println("Searching the board for words.");
//        for (row = 0; row < 4; row++) {
//            for (col = 0; col < 4; col++) {
        for (boardCell cell : cellsOnBoard) {
            recursiveSearch(cell);
        }

        System.out.println("Search completed.");
        return foundWords;
    }


    public static void generateNewBoggleBoard() {
        for (int i = 0; i < 4; i++) {
            for (int b = 0; b < 4; b++) {
                Random r = new Random();
                char c = (char) (r.nextInt(26) + 'a');
                cellsOnBoard.add(new boardCell(i, b, c));
                boggleBoard[i][b] = c;
            }
        }
        System.out.println("generated list : " + Arrays.deepToString(boggleBoard));
    }

    public static char[][] getBoggleBoard() {
        return boggleBoard;
    }
}
