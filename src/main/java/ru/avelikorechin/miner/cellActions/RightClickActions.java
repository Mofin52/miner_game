package ru.avelikorechin.miner.cellActions;

import ru.avelikorechin.miner.cells.Cell;

public class RightClickActions implements CellAction{

    /**
     * Action performed on hidden bomb.
     *
     * @param cell cell clicked
     */
    public void performHiddenBombCellAction(Cell cell, Cell[][] cells) {
        cell.setState("flagged");
    }

    /**
     * Action performed on opened bomb.
     *
     * @param cell cell clicked
     */
    public void performOpenedBombCellAction(Cell cell, Cell[][] cells) {
        //this is impossible according to default game rules
    }

    /**
     * Action performed on empty hidden cell.
     *
     * @param cell cell clicked
     */
    public void performHiddenEmptyCellAction(Cell cell, Cell[][] cells) {
        cell.setState("flagged");
    }

    /**
     * Action performed on empty opened cell.
     *
     * @param cell cell clicked
     */
    public void performOpenedEmptyCellAction(Cell cell, Cell[][] cells) {
        //by default cell shouldn't react on such action
    }

    /**
     * Action performed on numbered hidden cell.
     *
     * @param cell cell clicked
     */
    public void performHiddenNumberCellAction(Cell cell, Cell[][] cells) {
        cell.setState("flagged");
    }

    /**
     * Action performed on numbered opened cell.
     *
     * @param cell cell clicked
     */
    public void performOpenedNumberCellAction(Cell cell, Cell[][] cells) {
        //by default cell shouldn't react on such action
    }
}
