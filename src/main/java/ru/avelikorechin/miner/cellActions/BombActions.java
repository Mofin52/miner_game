package ru.avelikorechin.miner.cellActions;

import ru.avelikorechin.miner.cells.Cell;

public class BombActions extends CellActions {


    /**
     * Action performed on both mouse button click.
     *
     * @param cell  cell clicked
     * @param cells array of cells
     */
    @Override
    public void leftRightClickAction(Cell cell, Cell[][] cells) {
        if (cell.getState().equals("hidden")) {
            pushCells(getHiddenCellsAround(cell, cells));
        } else {
            // such behaviour impossible according to default game rules
        }
    }

}
