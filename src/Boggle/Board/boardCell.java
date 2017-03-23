package Boggle.Board;

/**
 * Created by Cyriel on 21-3-2017.
 */
public class boardCell {

    private final int row;
    private final int col;
    private final char characterInCell;

    boardCell(int row, int col, char characterInCell) {
        this.row = row;
        this.col = col;
        this.characterInCell = characterInCell;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    String getCharacterInCellAsString(){
        return Character.toString(characterInCell);
    }
}
