package org.example.model;

import java.util.Arrays;

public class Board {
    public static final int ROWS_NUMBER = 3;
    public static final int COLUMNS_NUMBER = 3;

    private final byte[] fields = new byte[ROWS_NUMBER * COLUMNS_NUMBER];

    public Board() {}

    public void setFieldValue(int fieldIndex, byte value) {
        fields[fieldIndex] = value;
    }

    public byte[] getBoard() {
        return Arrays.copyOf(fields, ROWS_NUMBER * COLUMNS_NUMBER);
    }
}
