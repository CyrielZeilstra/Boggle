package Boggle.Board;

import Boggle.WordlistTrie.Trie;

import java.util.*;

/**
 * Created by Cyriel on 17-3-2017.
 */
public class Board {
    private static char[][] boggleBoard = new char[10][10];
    private static ArrayList<boardCell> cellsOnBoard = new ArrayList<>();

    private ArrayList<String> foundWords;
    private Trie trie;

    public Board() {
        trie = new Trie();
        trie.readList();
        foundWords = new ArrayList<>();
    }

    private String recursiveSearch(LinkedList<boardCell> usedCells) {
        String prefix = getWord(usedCells);

        // If our prefix is a word add it to the word list
        // if it is not already added.
        if (trie.search(prefix)) {
            if (!foundWords.contains(prefix)) {
                foundWords.add(prefix);
            }
        }

        // If a word starts with the current prefix, grab the moves for the usedCell
        if (trie.startsWith(prefix)) {
            LinkedList<boardCell> moves = getMoves(usedCells);
            for (boardCell a : moves) {
                // Add the current cell to the usedCell list so it wont be used again for this word.
                usedCells.add(a);
                prefix += recursiveSearch(usedCells);
                usedCells.pollLast();
            }
        }
        return prefix;
    }

    private String getWord(List<boardCell> usedCells) {
        StringBuilder sb = new StringBuilder(usedCells.size());
        for (boardCell cell : usedCells) {
            sb.append(getBoardCell(cell.getRow(), cell.getCol()).getCharacterInCellAsString());
        }
        return sb.toString();
    }


    private LinkedList<boardCell> getMoves(LinkedList<boardCell> usedCells) {
        LinkedList<boardCell> PossibleMoves = new LinkedList<>();

        int row = usedCells.peekLast().getRow();
        int col = usedCells.peekLast().getCol();

        boolean u, d, r, l;
        u = row - 1 >= 0;
        d = row + 1 < boggleBoard.length;
        r = col + 1 < boggleBoard.length;
        l = col - 1 >= 0;

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

        PossibleMoves.removeAll(usedCells);
        return PossibleMoves;
    }

    private boardCell getBoardCell(int row, int col) {
        for (boardCell a : cellsOnBoard) {
            if (a.getRow() == row && a.getCol() == col) {
                return a;
            }
        }
        return null;
    }

    public ArrayList<String> searchBoard() {
        System.out.println("Searching the board for words.");
        LinkedList<boardCell> usedCells = new LinkedList<>();
        for (boardCell cell : cellsOnBoard) {
            // We don't want to use the root cell so we add it to the list.
            usedCells.add(cell);
            // Recursively search every cell around the root cell.
            recursiveSearch(usedCells);
            // Remove the last element in the list (the root cell).
            usedCells.pollLast();
        }
        System.out.println("Search completed.");
        return foundWords;
    }


    public static void generateNewBoggleBoard() {
        for (int i = 0; i < boggleBoard.length; i++) {
            for (int b = 0; b < boggleBoard.length; b++) {
                Random r = new Random();
                char c = (char) (r.nextInt(26) + 'a');
                cellsOnBoard.add(new boardCell(i, b, c));
                boggleBoard[i][b] = c;
            }
        }
    }

    public static char[][] getBoggleBoard() {
        return boggleBoard;
    }
}
