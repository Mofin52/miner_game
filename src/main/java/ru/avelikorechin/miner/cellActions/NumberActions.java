package ru.avelikorechin.miner.cellActions;

import ru.avelikorechin.miner.cells.Cell;

import java.util.List;

public class NumberActions extends CellActions {

    /**
     * Action performed on both mouse button click.
     *
     * @param cell  cell clicked
     * @param cells array of cells
     */
    public void leftRightClickAction(Cell cell, Cell[][] cells) {
        String cellState = cell.getState();
        List<Cell> hiddenCellsAround = getHiddenCellsAround(cell, cells);

        if (cellState.equals("hidden")){
            pushCells(hiddenCellsAround);
        } else if (cellState.equals("opened")){

            int flagsCount = getFlaggedCellsAround(cell, cells).size();

            if (Integer.toString(flagsCount).equals(cell.getState())) {
                for (Cell elem : hiddenCellsAround) {
                    elem.setState("opened");
                }
            } else {
                pushCells(hiddenCellsAround);
            }

        }
    }

}
