package Boggle.Dictionary;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Cyriel on 17-3-2017.
 */
public class Dictionary {
    public static ArrayList<String> words = new ArrayList<>();

    public static void readList() {
        String fileName = "src/Boggle/Dictionary/woordenlijst.txt";
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
}
