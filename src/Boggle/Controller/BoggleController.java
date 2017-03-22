package Boggle.Controller;

import Boggle.Board.Board;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
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
    private ListView listBox;

    private final Board board = new Board();

    @FXML
    private Button newBoardBtn;

    @FXML
    public void initialize() {

        drawBoardOnInterface();

        newBoardBtn.setOnAction(event -> {
            Board.generateNewBoggleBoard();
            listBox.getItems().clear();
            drawBoardOnInterface();
        });

        startBtn.setOnAction(event -> {
            ObservableList<String> data = FXCollections.observableArrayList();
            for (Object word : board.searchBoard()){
                data.add(word.toString());
            }
            listBox.setItems(data);
        });
    }

    private void drawBoardOnInterface() {
        // draw Generated list on the grid.
        mainGrid.getChildren().clear();
        mainGrid.getColumnConstraints().clear();
        mainGrid.getRowConstraints().clear();
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
