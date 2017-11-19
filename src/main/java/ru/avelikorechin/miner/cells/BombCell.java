package ru.avelikorechin.miner.cells;

import ru.avelikorechin.miner.cellActions.BombActions;
import ru.avelikorechin.miner.cellActions.CellActions;

/**
 * Class describing cell with bomb behaviour.
 * @author Alexander Velikorechin
 * @since 11.11.2017
 */

public class BombCell extends Cell {
    /**
     * Constructor of cell.
     * @param column column of cell on board
     * @param row row of cell on board
     */
    public BombCell(final int row, final int column) {
        super(row, column);
        super.setContent("B");
        super.setActionLibrary(new BombActions());
    }

}
