package ru.avelikorechin.miner.minerUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Model of Cell based on JLabel.
 * @author Alexander Velikorechin
 * @since 19.11.2017
 */
public class CellModel extends JLabel {
    /**
     * Row needed to detect cell.
     */
    private int row;
    /**
     * Cell needed to detect cell.
     */
    private int column;

    /**
     * Method to redraw cell icon.
     * @param state new state of cell
     */
    public void redrawCellImage(String state, String content) {
        Image image = null;
        String fileName = !state.equals("opened") ? state : state + content;
        try {
            File url = new File("src\\main\\java\\ru\\avelikorechin\\miner\\minerUI\\resources\\" + fileName + ".png");
            image = ImageIO.read(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.setIcon(new ImageIcon(image));
    }
    /**
     * Returns row.
     * @return row
     */
    public int getRow() {
        return this.row;
    }

    /**
     * Returns column.
     * @return column
     */
    public int getColumn() {
        return this.column;
    }

    /**
     * Sets row.
     * @param newRow row to set
     */
    public void setRow(int newRow) {
        this.row = newRow;
    }

    /**
     * Sets column.
     * @param newColumn column to set
     */
    public void setColumn(int newColumn) {
        this.column = newColumn;
    }
}
