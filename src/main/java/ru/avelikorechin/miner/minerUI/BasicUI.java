package ru.avelikorechin.miner.minerUI;

import ru.avelikorechin.miner.cells.Cell;

import javax.swing.*;
import javax.swing.plaf.IconUIResource;
import java.awt.*;

/**
 * Interface for miner game.
 * @author Alexander Velikorechin
 * @since 18.11.2017
 */
public class BasicUI {

    /**
     * Width of one cell.
     */
    private int cellWidth;
    /**
     * Height of one cell.
     */
    private int cellHeight;
    /**
     * Cells for UI.
     */
    private Cell[][] cells;

    /**
     * Constructor of UI class.
     * @param cellWidth width of cell
     * @param cellHeight height of cell
     */
    public BasicUI(int cellWidth, int cellHeight, Cell[][] cells) {
        this.cellWidth = cellWidth;
        this.cellHeight = cellHeight;
        this.cells = cells;
    }

    /**
     * Method to init user interface.
     * @param columns number of columns required
     * @param rows number of row required
     */
    public void initUi(int columns, int rows) {
        JFrame frame = new JFrame("Minesweeper Game");
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(columns*cellWidth, rows*cellHeight);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void drawFrame(JFrame frame){
        //TODO the method must create needed ammount of elements, set their content, add them to frame

    }
}
