package ru.avelikorechin.miner.cellActions;

import ru.avelikorechin.miner.cells.Cell;
import ru.avelikorechin.miner.cells.EmptyCell;

import java.util.List;

public class EmptyActions extends CellActions {

    /**
     * Action performed on right mouse button click.
     *
     * @param cell  cell clicked
     * @param cells array of cells
     */
    @Override
    public void leftClickAction(Cell cell, Cell[][] cells) {
        String cellState = cell.getState();
        if (cellState.equals("hidden")) {
            List<Cell> cellsAround = getHiddenCellsAround(cell, cells);
            for (Cell elem : cellsAround) {
                if (elem instanceof EmptyCell) {
                    leftClickAction(elem, cells);
                } else {
                    elem.setState("opened");
                }
            }
        } else {
            // opened and flagged cell shouldn't react on such action by default
        }
    }

    /**
     * Action performed on both mouse button click.
     *
     * @param cell  cell clicked
     * @param cells array of cells
     */
    @Override
    public void leftRightClickAction(Cell cell, Cell[][] cells) {
        String cellState = cell.getState();
        if (cellState.equals("hidden")) {
            pushCells(getHiddenCellsAround(cell, cells));
        } else {
            // opened and flagged empty cells shouldn't react on such action by default
        }
    }

}
