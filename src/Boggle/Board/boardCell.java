package Boggle.Board;

/**
 * Created by Cyriel on 21-3-2017.
 */
final class boardCell {

    private int row;
    private int col;
    private char characterInCell;

    boardCell(int row, int col, char characterInCell) {
        this.row = row;
        this.col = col;
        this.characterInCell = characterInCell;
    }

    int getRow() {
        return row;
    }

    int getCol() {
        return col;
    }

    String getCharacterInCellAsString(){
        return Character.toString(characterInCell);
    }
}
