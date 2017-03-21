package Boggle;

import Boggle.Board.Board;
import Boggle.Board.Trie;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Controller/sample.fxml"));
        primaryStage.setTitle("Boggle!");
        primaryStage.setScene(new Scene(root, 380, 600));
        primaryStage.show();
    }

    public static void main(String[] args) {
        // Generate a new board on startup
        Board.generateNewBoggleBoard();

        // Start interface
        launch(args);

    }
}
