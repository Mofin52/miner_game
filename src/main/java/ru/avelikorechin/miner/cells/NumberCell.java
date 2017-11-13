package ru.avelikorechin.miner.cells;

/**
 * Class describing cell with number behaviour.
 * @author Alexander Velikorechin
 * @since 11.11.2017
 */

public class NumberCell extends Cell {

    /**
     * Constructor of cell.
     * @param column column of cell on board
     * @param row row of cell on board
     */
    public NumberCell(int row, int column) {
        super(row, column);
        this.content = "0";
    }

    /**
     * Constructor of cell with content assignment.
     * @param column column of cell on board
     * @param row row of cell on board
     */
    public NumberCell(int row, int column, String content) {
        super(row, column);
        this.content = content;
    }
}