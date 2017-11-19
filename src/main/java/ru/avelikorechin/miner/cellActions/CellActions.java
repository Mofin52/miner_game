package ru.avelikorechin.miner.cellActions;

import ru.avelikorechin.miner.cells.Cell;
import ru.avelikorechin.miner.minerUI.BasicUI;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to describe different cells actions.
 * @author Alexander Velikorechin
 * @since 11.11.2017
 */
public abstract class CellActions {

    /**
     * Action performed on right mouse button click.
     * @param cell cell clicked
     */
    public void rightClickAction(Cell cell, BasicUI ui) {
        String cellState = cell.getState();
        if (cellState.equals("hidden")) {
            cell.setState("flagged");
            cellState = "flagged";
        } else if (cellState.equals("flagged")){
            cell.setState("hidden");
            cellState = "hidden";
        } else {
            // should do nothing according to default game rules
        }
        ui.getCellsView()[cell.getRow()][cell.getColumn()].redrawCellImage(cellState, cell.getContent());
    }

    /**
     * Action performed on left mouse button click.
     * @param cell cell clicked
     * @param ui app ui
     */
    public void leftClickAction(Cell cell, BasicUI ui) {
        String cellState = cell.getState();
        if (cellState.equals("hidden")) {
            cell.setState("opened");
            cellState = "opened";
        } else {
            // should do nothing according to default game rules
        }
        ui.getCellsView()[cell.getRow()][cell.getColumn()].redrawCellImage(cellState, cell.getContent());
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
                if (i ==0 && j == 0) {
                    continue;
                }
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

}
