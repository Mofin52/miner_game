package ru.avelikorechin.miner.cells;

/**
 * Interface to describe all types of cells on board.
 * @author Alexander Velikorechin
 * @since 11.10.2017
 */

public abstract class Cell {

    /**
     * Column of cell on board.
     */
    int column;
    /**
     * Row of cell on board.
     */
    int row;
    /**
     * Status of cell. May be hidden, opened or flagged.
     */
    String state;
    /**
     * Content of cell.
     */
    String content;

    /**
     * Constructor for empty cell.
     * @param column column of cell on board
     * @param row row of cell on board
     */
    public Cell(int row, int column) {
        this.column = column;
        this.row = row;
        this.state = "hidden";
    }

    /**
     * Returns cell state - 'opened' or 'hidden' or 'flagged'.
     * @return cell state
     */
    public String getState() {
        return this.state;
    }

    /**
     * Sets cell state - 'opened' or 'hidden' or 'flagged'.
     * @param newState cell state
     */
    public void setState(String newState) {

    }

    /**
     * Returns column of cell on board.
     * @return column of cell
     */
    public int getColumn() {
        return this.column;
    }

    /**
     * Sets column of cell on board.
     * @param newColumn column of cell
     */
    public void setColumn(int newColumn) {
        this.column = newColumn;
    }

    /**
     * Returns row of cell on board.
     * @return row of cell
     */
    public int getRow() {
        return this.row;
    }

    /**
     * Sets row of cell on board.
     * @param newRow row of cell
     */
    public void setRow(int newRow) {
        this.row = newRow;
    }

    /**
     * Returns content of cell.
     * @return content of cell
     */
    public String getContent(){
        return this.content;
    }

    /**
     * Sets content of cell.
     * @param content content of cell
     */
    public void setContent(String content){
        this.content = content;
    }

    /**
     * Defines how cell reacts to left mouse click.
     */
    public void leftClickAction() {

    }

    /**
     * Defines how cell reacts to right mouse click.
     */
    public void rightClickAction() {

    }

    /**
     * Defines how cell reacts to left and right mouse click.
     */
    public void leftRightClickAction() {

    }
}
