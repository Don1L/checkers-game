import java.util.Scanner;

public class Game {
    private Board board;
    private boolean isWhiteTurn;
    private Scanner scanner;

    public Game() {
        board = new Board();
        isWhiteTurn = true;
        scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            board.display();
            System.out.println("Ход " + (isWhiteTurn ? "белых" : "черных"));
            System.out.println("Введите ход в формате 'координата шашки, координаты хода (строка и столбец)' (например, '2 3 3 4'):");
            int fromRow = scanner.nextInt();
            int fromCol = scanner.nextInt();
            int toRow = scanner.nextInt();
            int toCol = scanner.nextInt();

            if (isValidMove(fromRow, fromCol, toRow, toCol)) {
                movePiece(fromRow, fromCol, toRow, toCol);
                isWhiteTurn = !isWhiteTurn;
            } else {
                System.out.println("Неверный ход! Попробуйте снова.");
            }
        }
    }

    private boolean isValidMove(int fromRow, int fromCol, int toRow, int toCol) {
        Piece piece = board.getPiece(fromRow, fromCol);
        if (piece == null || piece.getType() != (isWhiteTurn ? PieceType.WHITE : PieceType.BLACK)) {
            return false;
        }

        // Простая проверка: шашка может ходить только на одну клетку по диагонали
        if (Math.abs(toRow - fromRow) == 1 && Math.abs(toCol - fromCol) == 1) {
            // Проверяем, что целевая клетка пуста
            return board.getPiece(toRow, toCol) == null;
        }

        return false;
    }

    private void movePiece(int fromRow, int fromCol, int toRow, int toCol) {
        Piece piece = board.getPiece(fromRow, fromCol);
        piece.move(toRow, toCol);
        board.setPiece(toRow, toCol, piece);
        board.setPiece(fromRow, fromCol, null);
    }
}