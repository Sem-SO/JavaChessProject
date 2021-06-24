package chessProject;

public class Pawn extends ChessPiece{
    public Pawn (String color) {
        super(color);
    }

    public String getColor() {
        return this.color;
    }

    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (checkPos(line) && checkPos(toLine) && checkPos(column) && checkPos(toColumn) && chessBoard.board[line][column] != null) {
            if (column == toColumn) { // check that we don't want to eat
                int dir;
                int start;

                if (color.equals("White")) {  // for white piece
                    dir = 1;
                    start = 1;
                } else { // for black piece
                    dir = -1;
                    start = 6;
                }

                if (line + dir == toLine) {  //check direction
                    return chessBoard.board[toLine][toColumn] == null;
                }

                if (line == start && line + 2 * dir == toLine) {
                    return chessBoard.board[toLine][toColumn] == null && chessBoard.board[line + dir][column] == null; // check that positions is null
                }

            } else { // want to eat piece

                if ((column - toColumn == 1 || column - toColumn == -1) && (line - toLine == 1 || line - toLine == -1) && // check that piece another color
                        chessBoard.board[toLine][toColumn] != null) {
                    return !chessBoard.board[toLine][toColumn].getColor().equals(color);
                } else return false;
            }
        }
        return false;
    }

    public String getSymbol() {
        String symbol = "P";
        return symbol;
    }

    public boolean checkPos(int pos) {
        return pos >= 0 && pos <= 7;
    }

}
