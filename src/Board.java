public class Board {
    private static final int SIZE = 8; // Размер доски (8x8)
    private Piece[][] board; // Двумерный массив для хранения фигур

    // Конструктор
    public Board() {
        board = new Piece[SIZE][SIZE]; // Создаем пустую доску
        initializeBoard(); // Инициализируем доску шашками
    }

    // Метод для инициализации доски
    private void initializeBoard() {
        // Заполняем доску шашками
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                // Шашки располагаются только на черных клетках (где сумма row и col нечетная)
                if ((row + col) % 2 == 1) {
                    // Белые шашки на первых трех рядах
                    if (row < 3) {
                        board[row][col] = new Piece(PieceType.WHITE, row, col);
                    }
                    // Черные шашки на последних трех рядах
                    else if (row > 4) {
                        board[row][col] = new Piece(PieceType.BLACK, row, col);
                    }
                }
            }
        }
    }

    // Метод для получения фигуры по координатам
    public Piece getPiece(int row, int col) {
        return board[row][col];
    }

    // Метод для установки фигуры на доску
    public void setPiece(int row, int col, Piece piece) {
        board[row][col] = piece;
    }

    // Метод для отображения доски
    public void display() {
        // Вывод номеров столбцов (0-7)
        System.out.print("  ");
        for (int col = 0; col < SIZE; col++) {
            System.out.print(col + " ");
        }
        System.out.println();

        // Вывод доски с номерами строк (0-7)
        for (int row = 0; row < SIZE; row++) {
            // Вывод номера строки
            System.out.print(row + " ");

            // Вывод содержимого каждой клетки
            for (int col = 0; col < SIZE; col++) {
                if (board[row][col] == null) {
                    // Пустая клетка
                    System.out.print(". ");
                } else {
                    // Фигура (W - белая, B - черная)
                    System.out.print(board[row][col].getType().toString().charAt(0) + " ");
                }
            }
            System.out.println(); // Переход на новую строку
        }
    }
}