package Boggle.Model;

import javafx.scene.layout.Pane;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by Cyriel on 15-3-2017.
 */
public class boggleModel {
    static char[][] boggleList;
    ArrayList<String> words = new ArrayList<>();
    String fileName;

    public boggleModel() {
        fileName = "src/Boggle/woordenlijst.txt";
        boggleList = new char[4][4];
    }

    public void readList() {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                words.add(sCurrentLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(words.toString());
    }

    // Google tri trees ??

    public void searchBoard() {
        System.out.println("Searching the board for words.");
        for (int col = 0; col < 4; col++) {
            for (int row = 0; row < 4; row++) {
                char letter = boggleList[col][row];
                
                try {
                    System.out.println(letter + "" + boggleList[col-1][row -1]);
                    System.out.println(letter + "" +boggleList[col][row-1]);
                    System.out.println(letter + "" +boggleList[col+1][row-1]);

                    System.out.println(letter + "" +boggleList[col -1][row]);
                    System.out.println(letter + "" +boggleList[col +1 ][row]);

                    System.out.println(letter + "" +boggleList[col-1][row+1]);
                    System.out.println(letter + "" +boggleList[col][row+1]);
                    System.out.println(letter + "" +boggleList[col+1][row+1]);

                } catch (IndexOutOfBoundsException e){
                    continue;
                }
                if (isWord(boggleList[col][row])) {
                    System.out.println(boggleList[col][row] + " was in the dict.");
                }
            }
        }
        System.out.println("Search completed.");
    }


    boolean isWord(char str) {
        if (words.contains(Character.toString(str))) {
            return true;
        }
        return false;
    }

    public static void generatecharArrayBoggleList() {
        for (int i = 0; i < 4; i++) {
            for (int b = 0; b < 4; b++) {
                Random r = new Random();
                char c = (char) (r.nextInt(26) + 'a');
                boggleList[i][b] = c;
            }
        }
        System.out.println("generated list : " + Arrays.deepToString(boggleList));
    }

    public static char[][] getBoggleList() {
        return boggleList;
    }
}
