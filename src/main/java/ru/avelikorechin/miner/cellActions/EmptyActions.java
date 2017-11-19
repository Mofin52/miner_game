package ru.avelikorechin.miner.cellActions;

import ru.avelikorechin.miner.cells.Cell;
import ru.avelikorechin.miner.cells.EmptyCell;
import ru.avelikorechin.miner.cells.NumberCell;
import ru.avelikorechin.miner.minerUI.BasicUI;

import java.util.List;

/**
 * Class to describe empty cells actions.
 * @author Alexander Velikorechin
 * @since 11.11.2017
 */

public class EmptyActions extends CellActions {

    /**
     * Action performed on right mouse button click.
     *
     * @param cell  cell clicked
     * @param ui ui of app
     */
    @Override
    public final void leftClickAction(final Cell cell, final BasicUI ui) {
        //TODO check method work
        String cellState = cell.getState();
        if (cellState.equals("hidden")) {
            cell.setState("opened");
            ui.redrawCellImage("opened",
                    cell.getContent(),
                    ui.getCellsView()[cell.getRow()][cell.getColumn()]);
            List<Cell> cellsAround = getHiddenCellsAround(cell, ui.getCells());
            for (Cell elem : cellsAround) {
                if (elem instanceof EmptyCell) {
                    leftClickAction(elem, ui);
                } else if (elem instanceof NumberCell) {
                    elem.getActionLibrary().leftClickAction(elem, ui);
                }
            }

        }
    }

}
