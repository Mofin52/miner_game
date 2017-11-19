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
     * Constructor of cell.
     * @param column column of cell on board
     * @param row row of cell on board
     */
    public NumberCell(final int row, final int column) {
        super(row, column);
        super.setContent("0");
        super.setActionLibrary(new NumberActions());
    }

    /**
     * Constructor of cell with content assignment.
     * @param column column of cell on board
     * @param row row of cell on board
     * @param content content of cell
     */
    public NumberCell(final int row, final int column, final String content) {
        super(row, column);
        super.setContent(content);
        super.setActionLibrary(new NumberActions());
    }
}
