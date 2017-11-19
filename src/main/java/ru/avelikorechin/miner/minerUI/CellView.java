package ru.avelikorechin.miner.minerUI;

import javax.swing.JLabel;

/**
 * Model of Cell based on JLabel.
 * @author Alexander Velikorechin
 * @since 19.11.2017
 */
public class CellView extends JLabel {
    /**
     * Row needed to detect cell.
     */
    private int row;
    /**
     * Cell needed to detect cell.
     */
    private int column;


    /**
     * Returns row.
     * @return row
     */
    public final int getRow() {
        return this.row;
    }

    /**
     * Returns column.
     * @return column
     */
    public final int getColumn() {
        return this.column;
    }

    /**
     * Sets row.
     * @param newRow row to set
     */
    public final void setRow(final int newRow) {
        this.row = newRow;
    }

    /**
     * Sets column.
     * @param newColumn column to set
     */
    public final void setColumn(final int newColumn) {
        this.column = newColumn;
    }
}
