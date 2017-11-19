package ru.avelikorechin.miner.minerUI;

import ru.avelikorechin.miner.cells.Cell;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Class of click listener for board ui.
 * @author Alexander Velikorechin
 * @since 15.11.2017
 */
public class ClicksListener implements MouseListener {

    /**
     * Ui to interact with.
     */
    private UIController ui;
    /**
     * Constant for left mouse button.
     */
    private static final int LMB = 1;
    /**
     * Constant for right mouse button.
     */
    private static final int RMB = 3;
    /**
     * Constructor for clicksListener.
     * @param ui cell views required for click library work
     */
    public ClicksListener(final UIController ui) {
        this.ui = ui;
    }
    /**
     * Tracks when user clicks mouse.
     * @param mouseEvent event happened
     */
    @Override
    public final void mouseClicked(final MouseEvent mouseEvent) {
        CellView objectClicked = (CellView) mouseEvent.getSource();
        Cell cellClicked = ui.getCells()[objectClicked.getRow()][objectClicked.getColumn()];
        int buttonClicked = mouseEvent.getButton();
        if (buttonClicked == LMB) {
            cellClicked.getActionLibrary().leftClickAction(cellClicked, this.ui);
        } else if (buttonClicked == RMB) {
            cellClicked.getActionLibrary().rightClickAction(cellClicked, this.ui);
        }
    }

    /**
     * Tracks when user presses mouse button.
     * @param mouseEvent event happened
     */
    @Override
    public void mousePressed(final MouseEvent mouseEvent) {

    }

    /**
     * Tracks when user releases mouse button.
     * @param mouseEvent event happened
     */
    @Override
    public void mouseReleased(final MouseEvent mouseEvent) {

    }

    /**
     * Tracks when points mouse at element.
     * @param mouseEvent event happened
     */
    @Override
    public void mouseEntered(final MouseEvent mouseEvent) {

    }

    /**
     * Tracks when user moves mouse out of element.
     * @param mouseEvent event happened
     */
    @Override
    public void mouseExited(final MouseEvent mouseEvent) {

    }
}
