package ru.avelikorechin.miner.cellActions;

import ru.avelikorechin.miner.cells.Cell;
import ru.avelikorechin.miner.minerUI.BasicUI;

import javax.swing.*;

/**
 * Class for bomb actions.
 * @author Alexander Velikorechin
 * @since 11.11.2017
 */
public class BombActions extends CellActions {
    @Override
    public void leftClickAction(final Cell cell, final BasicUI ui) {
        super.leftClickAction(cell, ui);
        ui.gameOver();
    }
}
