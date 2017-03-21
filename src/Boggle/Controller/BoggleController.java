package Boggle.Controller;

import Boggle.Board.Board;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;


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

    private Board board = new Board();

    @FXML
    public void initialize() {

        drawBoardOnInterface();

        startBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                for (Object word : board.searchBoard()){
                    logBox.appendText(word.toString() + "\n");
                }
            }
        });
    }

    private void drawBoardOnInterface() {
        // draw Generated list on the grid.
        for (int row = 0; row < Board.getBoggleBoard().length; row++) {
            for (int col = 0; col < Board.getBoggleBoard().length; col++) {
                StackPane letterSquare = new StackPane();

                Text t = new Text("" + Board.getBoggleBoard()[row][col]);
                t.setFont(new Font(30));

                letterSquare.getChildren().add(t);
                letterSquare.setBorder(new Border(new BorderStroke(Color.BLACK,
                        BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

                mainGrid.add(letterSquare, col, row);
            }
        }

        for (int i = 0; i < Board.getBoggleBoard().length; i++) {
            mainGrid.getColumnConstraints().add(new ColumnConstraints(USE_COMPUTED_SIZE, USE_COMPUTED_SIZE, Double.POSITIVE_INFINITY, Priority.ALWAYS, HPos.CENTER, true));
            mainGrid.getRowConstraints().add(new RowConstraints(USE_COMPUTED_SIZE, USE_COMPUTED_SIZE, Double.POSITIVE_INFINITY, Priority.ALWAYS, VPos.CENTER, true));
        }


    }
}
