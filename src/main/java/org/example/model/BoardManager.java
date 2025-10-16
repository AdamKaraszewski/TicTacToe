package org.example.model;

public class BoardManager {

    //return 1 if X win
    //return -1 if O win
    //return 0 - no one win (if draw check checkIfSomeoneWin == 0 && checkIsGameOver)
    private byte checkIfSomeoneWin(Board board) {
        byte[] fields = board.getBoard();
        for (int i = 0; i < Board.ROWS_NUMBER; i++) {
            byte result = checkRowWin(fields, i);
            if (result != 0) return result;
        }

        for (int i = 0; i < Board.COLUMNS_NUMBER; i++) {
            byte result = checkColumnWin(fields, i);
            if (result != 0) return result;
        }
        return checkDiagonalsWin(fields);
    }

    private boolean checkIsGameOver(Board board) {
        byte[] fields = board.getBoard();
        for (int i = 0; i < Board.ROWS_NUMBER * Board.COLUMNS_NUMBER; i++) {
            if (fields[i] == 0) return false;
        }
        return true;
    }


    //return 1 if X win
    //return -1 if O win
    //return 0 - no one win
    private byte checkRowWin(byte[] fields, int rowIndex) {
        byte firstField = fields[rowIndex * Board.COLUMNS_NUMBER];
        byte secondField = fields[rowIndex * Board.COLUMNS_NUMBER + 1];
        byte thirdField = fields[rowIndex * Board.COLUMNS_NUMBER + 2];
        if (firstField !=0 && firstField == secondField && secondField == thirdField) {
            return firstField;
        }
        return 0;
    }

    //return 1 if X win
    //return -1 if O win
    //return 0 - no one win
    private byte checkColumnWin(byte[] fields, int columnIndex) {
        byte firstField = fields[columnIndex];
        byte secondField = fields[Board.ROWS_NUMBER + columnIndex];
        byte thirdField = fields[2 * Board.ROWS_NUMBER + columnIndex];
        if (firstField != 0 && (firstField == secondField && secondField == thirdField)) {
            return  firstField;
        }
        return 0;
    };

    //return 1 if X win
    //return -1 if 0 win
    //return 0 - no one wn
    private byte checkDiagonalsWin(byte[] fields) {
        if (fields[4] != 0 && ((fields[0] == fields[4] && fields[4] == fields[8]) || (fields[2] == fields[4] && fields[4] == fields[6]))) {
            return fields[4];
        }
        return 0;
    }
}
