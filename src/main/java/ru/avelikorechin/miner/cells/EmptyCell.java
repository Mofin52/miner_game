package ru.avelikorechin.miner.cells;

import ru.avelikorechin.miner.cellActions.EmptyActions;

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
    public EmptyCell(final int row, final int column) {
        super(row, column);
        super.setContent("");
        super.setActionLibrary(new EmptyActions());
    }
}
