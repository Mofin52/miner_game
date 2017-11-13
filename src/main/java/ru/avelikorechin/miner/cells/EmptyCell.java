package ru.avelikorechin.miner.cells;

/**
 * Class describing empty cell behaviour.
 * @author Alexander Velikorechin
 * @since 11.11.2017
 */

public class EmptyCell extends Cell {

    /**
     * Constructor of cell.
     * @param column column of cell on board
     * @param row row of cell on board
     */
    public EmptyCell(int row, int column) {
        super(row, column);
        this.content = " ";
    }
}
