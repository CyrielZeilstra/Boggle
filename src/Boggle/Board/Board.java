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

    int row = 0;
    int col = 0;

    public void doMoves(String root){
        String prefix = root;

        if (trie.search(root)){
            foundWords.add(root);
        }

        boolean u, d, r, l;
        u = row - 1 >= 0;
        d = row + 1 < 4;
        r = col + 1 < 4;
        l = col - 1 >= 0;

        //up
        if (u) {
            Object move = boggleBoard[row - 1][col];
            if (trie.startsWith(prefix + move)) {
                doMoves(prefix + move);
            }
        }

        //down
        if (d) {
            Object move = boggleBoard[row + 1][col];

            if (trie.startsWith(prefix + move)) {
                doMoves(prefix + move);
            }
        }

        //right
        if (r) {
            Object move = boggleBoard[row][col + 1];

            if (trie.startsWith(prefix + move)) {
                doMoves(prefix + move);
            }
        }
        //left
        if (l) {
            Object move = boggleBoard[row][col - 1];

            if (trie.startsWith(prefix + move)) {
                doMoves(prefix + move);
            }
        }
        //upleft
        if (u && l) {
            Object move = boggleBoard[row - 1][col - 1];

            if (trie.startsWith(prefix + move)) {
                doMoves(prefix + move);
            }
        }
        //upright
        if (u && r) {
            Object move = boggleBoard[row - 1][col + 1];

            if (trie.startsWith(prefix + move)) {
                doMoves(prefix + move);
            }
        }
        //downleft
        if (d && l) {
            Object move = boggleBoard[row + 1][col - 1];

            if (trie.startsWith(prefix + move)) {
                doMoves(prefix + move);
            }
        }
        //down right
        if (d && r) {
            Object move = boggleBoard[row + 1][col + 1];

            if (trie.startsWith(prefix + move)) {
                doMoves(prefix + move);
            }
        }
    }

    public ArrayList<String> searchBoard() {
        System.out.println("Searching the board for words.");
        for (row = 0; row < 4; row++) {
            for (col = 0; col < 4; col++) {
                String root = Character.toString(boggleBoard[row][col]);
                doMoves(root);
            }
        }

        System.out.println("Search completed.");
        return foundWords;
    }


    public static void generateNewBoggleBoard() {
        for (int i = 0; i < 4; i++) {
            for (int b = 0; b < 4; b++) {
                Random r = new Random();
                char c = (char) (r.nextInt(26) + 'a');
                boggleBoard[i][b] = c;
            }
        }
        System.out.println("generated list : " + Arrays.deepToString(boggleBoard));
    }

    public static char[][] getBoggleBoard() {
        return boggleBoard;
    }
}
