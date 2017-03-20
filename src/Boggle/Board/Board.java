package Boggle.Board;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

/**
 * Created by Cyriel on 17-3-2017.
 */
public class Board {
    static char[][] boggleBoard = new char[4][4];

    private TrieNode root;

    public Board(){
        root = new TrieNode();
    }

    // http://www.programcreek.com/2014/05/leetcode-implement-trie-prefix-tree-java/
    // https://www.toptal.com/java/the-trie-a-neglected-data-structure

    public void searchBoard() {
        System.out.println("Searching the board for words.");
        ArrayList<String> combinations = new ArrayList<>();
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                String root = Character.toString(boggleBoard[row][col]);
                String testword = "koek";
                boolean u, d, r, l;
                u = row - 1 >= 0;
                d = row + 1 < 4;
                r = col + 1 < 4;
                l = col - 1 >= 0;

                //up
                if (u) {
                    combinations.add(root + boggleBoard[row - 1][col]);
                }

                if (d) {
                    //down
                    combinations.add(root + boggleBoard[row + 1][col]);
                }
                //right
                if (r) {
                    combinations.add(root + boggleBoard[row][col + 1]);
                }
                //left
                if (l) {
                    combinations.add(root + boggleBoard[row][col - 1]);
                }
                //upleft
                if (u && l) {
                    combinations.add(root + boggleBoard[row - 1][col - 1]);
                }
                //upright
                if (u && r) {
                    combinations.add(root + boggleBoard[row - 1][col + 1]);
                }
                //downleft
                if (d && l) {
                    combinations.add(root + boggleBoard[row + 1][col - 1]);
                }
                //down right
                if (d && r) {
                    combinations.add(root + boggleBoard[row + 1][col + 1]);
                }
            }
        }
        System.out.println(combinations);
        System.out.println("Search completed.");
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
