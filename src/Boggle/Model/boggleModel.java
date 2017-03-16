package Boggle.Model;

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

    public boggleModel(){
        fileName = "src/woordenlijst.txt";
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

    public void searchBoard(){
        System.out.println("searching for words.");
    }

    public static void generatecharArrayBoggleList(){
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
