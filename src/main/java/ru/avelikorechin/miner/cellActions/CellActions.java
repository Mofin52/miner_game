package ru.avelikorechin.miner.cellActions;

import ru.avelikorechin.miner.cells.Cell;

import java.util.ArrayList;
import java.util.List;

public abstract class CellActions {

    /**
     * Action performed on right mouse button click.
     * @param cell cell clicked
     */
    public void rightClickAction(Cell cell) {
        String cellState = cell.getState();
        if (cellState.equals("hidden")) {
            cell.setState("flagged");
        } else if (cellState.equals("flagged")){
            cell.setState("hidden");
        } else {
            // should do nothing according to default game rules
        }
    }

    /**
     * Action performed on left mouse button click.
     * @param cell cell clicked
     * @param cells array of cells
     */
    public void leftClickAction(Cell cell, Cell[][] cells) {
        String cellState = cell.getState();
        if (cellState.equals("hidden")) {
            cell.setState("opened");
        } else {
            // should do nothing according to default game rules
        }
    }

    /**
     * Method returns an array of cells located around the given cell.
     * @param cell cell around which search is performed
     * @return
     */
    public List<Cell> getCellsAround(Cell cell, Cell[][] cells) {
        int row = cell.getRow();
        int col = cell.getColumn();
        List<Cell> result = new ArrayList<Cell>();

        for (int i = -1; i <= 1 ; i++){
            for (int j = -1; j <= 1; j++){
                int shiftedRow = row + i;
                int shiftedCol = col + j;
                if (shiftedCol >= 0 && shiftedCol < cells[0].length
                        && shiftedRow >= 0 && shiftedRow < cells.length) {
                    result.add(cells[shiftedRow][shiftedCol]);
                }
            }
        }
        return result;
    }

    /**
     * Returns list of hidden cells around given one.
     * @param cell cell to find hidden ones around
     * @param cells all the cells
     * @return
     */
    public List<Cell> getHiddenCellsAround(Cell cell, Cell[][] cells) {
        List<Cell> hiddenCellsAround = getCellsAround(cell, cells);
        hiddenCellsAround.removeIf(c -> !c.getState().equals("hidden"));
        return hiddenCellsAround;
    }

    /**
     * Returns lisf of flagged cells around given one.
     * @param cell
     * @param cells
     * @return
     */
    public List<Cell> getFlaggedCellsAround(Cell cell, Cell[][] cells) {
        List<Cell> flaggedCellsAround = getCellsAround(cell, cells);
        flaggedCellsAround.removeIf(c -> !c.getState().equals("flagged"));
        return flaggedCellsAround;
    }

    /**
     * Method change cells status to pushed.
     * @param cellsToPush list of cells to push down
     */
    public void pushCells(List<Cell> cellsToPush) {
        for (Cell item : cellsToPush) {
            item.setState("pushed");
        }
    }

    /**
     * Method change cells status to hidden.
     * @param cellsToRelease list of cells to release
     */
    public void releaseCells(List<Cell> cellsToRelease) {
        for (Cell item : cellsToRelease) {
            if (item.getState().equals("pushed")) {
                item.setState("hidden");
            }
        }
    }
    /**
     * Action performed on both mouse button click.
     * @param cell cell clicked
     * @param cells array of cells
     */
    abstract void leftRightClickAction(Cell cell, Cell[][] cells);
    
}
