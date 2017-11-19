package ru.avelikorechin.miner.cellActions;

import ru.avelikorechin.miner.StartUI;
import ru.avelikorechin.miner.cells.Cell;
import ru.avelikorechin.miner.minerUI.UIController;

/**
 * Class for bomb actions.
 * @author Alexander Velikorechin
 * @since 11.11.2017
 */
public class BombActions extends CellActions {
    @Override
    public void leftClickAction(final Cell cell, final UIController ui) {
        super.leftClickAction(cell, ui);
        ui.gameOver();
    }

    /**
     * Marks flags and calls methods that change number of correctly set flags, check if game is won.
     * @param cell cell clicked
     * @param ui ui of application
     */
    @Override
    public void rightClickAction(final Cell cell, final UIController ui) {
        String cellState = cell.getState();
        if (cellState.equals("hidden")) {
            cellState = "flagged";
            cell.setState(cellState);
            changeControlCellsCount(+1, ui);
            ui.redrawCellImage(cellState, cell.getContent(), ui.getCellsView()[cell.getRow()][cell.getColumn()]);
        } else if (cellState.equals("flagged")) {
            cellState = "hidden";
            cell.setState(cellState);
            changeControlCellsCount(-1, ui);
            ui.redrawCellImage(cellState, cell.getContent(), ui.getCellsView()[cell.getRow()][cell.getColumn()]);
        }
        isGameWon(ui);
    }

    /**
     * Method changes ammount of flags set correctly.
      * @param delta +1 or -1
     * @param ui user interface of app
     */
    @Override
    protected void changeControlCellsCount(final int delta, final UIController ui) {
        ui.setCorrectFlags(ui.getCorrectFlags() + delta);
    }

    /**
     * Checks whether game is won or not.
     * @param ui ui of an app
     */
    @Override
    protected void isGameWon(final UIController ui) {
        if (ui.getCorrectFlags() == StartUI.BOMBS) {
            ui.gameWon();
        }
    }
}
