package ru.avelikorechin.miner.minerUI;

import ru.avelikorechin.miner.cells.Cell;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Alex on 11/18/2017.
 */
public class ClicksListener implements MouseListener {
    /**
     * Cells required for click library work.
     */
    private Cell[][] cells;

    /**
     * Constructor for clicksListener.
     * @param cells cells requiref for click library work
     */
    public ClicksListener(Cell[][] cells) {
        this.cells = cells;
    }
    /**
     * Tracks when user clicks mouse.
     * @param mouseEvent event happened
     */
    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        Cell cellClicked = (Cell) mouseEvent.getSource();
        int buttonClicked = mouseEvent.getButton();
        if(buttonClicked == 1) {
            cellClicked.getActionLibrary().leftClickAction(cellClicked, cells);
        } else if (buttonClicked == 3) {
            cellClicked.getActionLibrary().rightClickAction(cellClicked);
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
