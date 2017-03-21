package Boggle.Board;

/**
 * Created by Cyriel on 21-3-2017.
 */
public final class boardCell {

    int row;
    int col;
    char characterInCell;

    public boardCell(int row, int col, char characterInCell) {
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

    public char getCharacterInCell() {
        return characterInCell;
    }

    public String getCharacterInCellAsString(){
        return Character.toString(characterInCell);
    }
}
