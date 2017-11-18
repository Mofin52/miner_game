package ru.avelikorechin.miner;

import ru.avelikorechin.miner.cells.BombCell;
import ru.avelikorechin.miner.cells.Cell;
import ru.avelikorechin.miner.cells.EmptyCell;
import ru.avelikorechin.miner.cells.NumberCell;

/**
 * Class describing the board behaviour.
 * @author Alexander Velikorechin
 * @since 11.11.2017
 */

public class Board {
    /**
     * Number of rows.
     */
    private int rows;
    /**
     * Number of columns.
     */
    private int columns;
    /**
     * Bomb quantity.
     */
    private int bombQuantity;
    /**
     * Array representing the board.
     */
    private Cell[][] cells;

    /**
     * Constructor for board class.
     * @param columns number of columns
     * @param rows number of rows
     * @param bombQuantity number of bombs
     */
    public Board(int columns, int rows, int bombQuantity){
        this.rows = rows;
        this.columns = columns;
        this.bombQuantity = bombQuantity;
        this.cells = new Cell[rows][columns];
    }

    /**
     * Method fills board with cells on game startup.
     */
    public void fillBoard(){
        Cell[] bombCoords = new Cell[bombQuantity];
        for (int i = 0; i < bombQuantity; ) {
            int rowNum = (int) Math.round(Math.random()*(rows - 1));
            int colNum = (int) Math.round(Math.random()*(columns - 1));
            if (cells[rowNum][colNum] == null) {
                cells[rowNum][colNum] = new BombCell(rowNum, colNum);
                bombCoords[i] = cells[rowNum][colNum];
                i++;
            }
        }
        fillNumbers(bombCoords);
        fillEmpty();
    }

    /**
     * Method puts numbers describing bomb quantity placed near them.
     */
    public void fillNumbers(Cell[] bombCoords){
        for (Cell bomb : bombCoords){
            for (int i = -1; i <= 1 ; i++){
                for (int j = -1; j <=1; j++){

                    int shiftedRow = bomb.getRow() + i;
                    int shiftedCol = bomb.getColumn() + j;

                    if (shiftedCol >= 0 && shiftedCol < columns
                            && shiftedRow >= 0 && shiftedRow < rows
                            && cells[shiftedRow][shiftedCol] == null) {
                        String counter = countBombsAround(shiftedRow, shiftedCol);
                        cells[shiftedRow][shiftedCol] = new NumberCell(shiftedRow, shiftedCol, counter);
                    }

                }
            }
        }
    }

    /**
     * Method fills all the cells that do not have numbers and bombs with empty cells.
     */
    public void fillEmpty(){
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++) {
                if (cells[i][j] == null) {
                    cells[i][j] = new EmptyCell(i, j);
                }
            }
        }
    }

    /**
     * Method counts bomb around particular cell.
     * @param row row of cell to count around
     * @param col column of cell to count around
     * @return
     */
    private String countBombsAround(int row, int col) {
        int counter = 0;
        for (int i = -1; i <= 1 ; i++){
            for (int j = -1; j <= 1; j++){
                int shiftedRow = row + i;
                int shiftedCol = col + j;
                if (shiftedCol >= 0 && shiftedCol < columns
                        && shiftedRow >= 0 && shiftedRow < rows
                        && cells[shiftedRow][shiftedCol] instanceof BombCell) {
                    ++counter;
                }
            }
        }
        return Integer.toString(counter);
    }


    public Cell[][] getCells(){
        return this.cells;
    }
}
