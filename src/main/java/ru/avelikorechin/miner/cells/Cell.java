
package ru.avelikorechin.miner.cells;

import ru.avelikorechin.miner.cellActions.CellActions;

/**
 * Interface to describe all types of cells on board.
 * @author Alexander Velikorechin
 * @since 11.10.2017
 */

public abstract class Cell {

    /**
     * Column of cell on board.
     */
    private int column;
    /**
     * Row of cell on board.
     */
    private int row;
    /**
     * Status of cell. May be hidden, pushed, opened or flagged.
     */
    private String state;
    /**
     * Content of cell.
     */
    private String content;
    /**
     * Cell actions library.
     */
    private CellActions actionLibrary;
    /**
     * Constructor for empty cell.
     * @param column column of cell on board
     * @param row row of cell on board
     */
    public Cell(final int row, final int column) {
        this.column = column;
        this.row = row;
        this.state = "hidden";
    }

    /**
     * Returns cell state - 'opened' or 'hidden' or 'flagged'.
     * @return cell state
     */
    public final String getState() {
        return this.state;
    }

    /**
     * Sets cell state - 'opened' or 'hidden' or 'flagged'.
     * @param newState cell state
     */
    public final void setState(final String newState) {
        this.state = newState;
    }

    /**
     * Returns column of cell on board.
     * @return column of cell
     */
    public final int getColumn() {
        return this.column;
    }

    /**
     * Returns row of cell on board.
     * @return row of cell
     */
    public final int getRow() {
        return this.row;
    }

    /**
     * Returns content of cell.
     * @return content of cell
     */
    public final String getContent() {
        return this.content;
    }

    /**
     * Setter for content.
     * @param newContent content to set
     */
    public final void setContent(final String newContent) {
        this.content = newContent;
    }
    /**
     * Returns current actionLibrary.
     * @return action library
     */
    public final CellActions getActionLibrary() {
        return this.actionLibrary;
    }

    /**
     * Sets new actionLibrary.
     * @param acts action library
     */
    public final void setActionLibrary(final CellActions acts) {
        this.actionLibrary = acts;
    }

}
