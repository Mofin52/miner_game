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
    private BasicUI ui;
    /**
     * Constructor for clicksListener.
     * @param ui cell views required for click library work
     */
    public ClicksListener(BasicUI ui) {
        this.ui = ui;
    }
    /**
     * Tracks when user clicks mouse.
     * @param mouseEvent event happened
     */
    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        CellModel objectClicked = (CellModel) mouseEvent.getSource();
        Cell cellClicked = ui.getCells()[objectClicked.getRow()][objectClicked.getColumn()];
        int buttonClicked = mouseEvent.getButton();
        if(buttonClicked == 1) {
            cellClicked.getActionLibrary().leftClickAction(cellClicked, this.ui);
        } else if (buttonClicked == 3) {
            cellClicked.getActionLibrary().rightClickAction(cellClicked, this.ui);
        }
    }

    /**
     * Tracks when user presses mouse button.
     * @param mouseEvent event happened
     */
    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    /**
     * Tracks when user releases mouse button.
     * @param mouseEvent event happened
     */
    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    /**
     * Tracks when points mouse at element.
     * @param mouseEvent event happened
     */
    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    /**
     * Tracks when user moves mouse out of element.
     * @param mouseEvent event happened
     */
    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }
}
