package ru.avelikorechin.miner.cellActions;

import ru.avelikorechin.miner.cells.Cell;

public interface CellAction {
    /**
     * Action performed on hidden bomb.
     * @param cell cell clicked
     */
    void performHiddenBombCellAction(Cell cell, Cell[][] cells);

    /**
     * Action performed on opened bomb.
     * @param cell cell clicked
     */
    void performOpenedBombCellAction(Cell cell, Cell[][] cells);

    /**
     * Action performed on empty hidden cell.
     * @param cell cell clicked
     */
    void performHiddenEmptyCellAction(Cell cell, Cell[][] cells);

    /**
     * Action performed on empty opened cell.
     * @param cell cell clicked
     */
    void performOpenedEmptyCellAction(Cell cell, Cell[][] cells);

    /**
     * Action performed on numbered hidden cell.
     * @param cell cell clicked
     */
    void performHiddenNumberCellAction(Cell cell, Cell[][] cells);

    /**
     * Action performed on numbered opened cell.
     * @param cell cell clicked
     */
    void performOpenedNumberCellAction(Cell cell, Cell[][] cells);

}
