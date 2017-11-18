package ru.avelikorechin.miner.cells;

import ru.avelikorechin.miner.cellActions.CellActions;
import ru.avelikorechin.miner.cellActions.NumberActions;

/**
 * Class describing cell with number behaviour.
 * @author Alexander Velikorechin
 * @since 11.11.2017
 */

public class NumberCell extends Cell {
    /**
     * Bomb action lib.
     */
    private CellActions cellActions = new NumberActions();
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
