package ru.avelikorechin.miner.cells;

import ru.avelikorechin.miner.cellActions.CellActions;
import ru.avelikorechin.miner.cellActions.EmptyActions;

/**
 * Class describing empty cell behaviour.
 * @author Alexander Velikorechin
 * @since 11.11.2017
 */

public class EmptyCell extends Cell {
    /**
     * Bomb action lib.
     */
    private CellActions actionLibrary;
    /**
     * Constructor of cell.
     * @param column column of cell on board
     * @param row row of cell on board
     */
    public EmptyCell(int row, int column) {
        super(row, column);
        this.content = "";
        super.actionLibrary = new EmptyActions();
    }
}
