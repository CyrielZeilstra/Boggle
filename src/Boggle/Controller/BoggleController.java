package Boggle.Controller;

import Boggle.Board.Board;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import javax.swing.text.html.ListView;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by Cyriel on 15-3-2017.
 */
public class BoggleController {

    @FXML
    private GridPane mainGrid;

    @FXML
    private Button startBtn;

    @FXML
    public TextArea logBox;

    @FXML
    public ListView listBox;

    private Board board = new Board();

    @FXML
    public void initialize() {

        drawBoardOnInterface();

        startBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                for (String foundword : board.searchBoard()){
                    logBox.appendText(foundword + "\n");
                }
            }
        });
    }

    public void drawBoardOnInterface() {
        // draw Generated list on the grid.
        System.out.println("board is : " + Arrays.deepToString(Board.getBoggleBoard()));
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                StackPane letterSquare = new StackPane();
                Text t = new Text("" + Board.getBoggleBoard()[row][col]);
                t.setFont(new Font(50));
                letterSquare.getChildren().add(t);
                letterSquare.setBorder(new Border(new BorderStroke(Color.BLACK,
                        BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
                mainGrid.add(letterSquare, col, row);
            }
        }

        for (int i = 0; i < 4; i++) {
            mainGrid.getColumnConstraints().add(new ColumnConstraints(5, Control.USE_COMPUTED_SIZE, Double.POSITIVE_INFINITY, Priority.ALWAYS, HPos.CENTER, true));
            mainGrid.getRowConstraints().add(new RowConstraints(5, Control.USE_COMPUTED_SIZE, Double.POSITIVE_INFINITY, Priority.ALWAYS, VPos.CENTER, true));
        }
    }
}
