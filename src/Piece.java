public class Piece {
    private PieceType type;
    private int row;
    private int col;

    public Piece(PieceType type, int row, int col) {
        this.type = type;
        this.row = row;
        this.col = col;
    }

    public PieceType getType() {
        return type;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void move(int newRow, int newCol) {
        this.row = newRow;
        this.col = newCol;
    }
}