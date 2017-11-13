package ru.avelikorechin.miner.cells;

/**
 * Class describing cell with bomb behaviour.
 * @author Alexander Velikorechin
 * @since 11.11.2017
 */

public class BombCell extends Cell {

    /**
     * Constructor of cell.
     * @param column column of cell on board
     * @param row row of cell on board
     */
    public BombCell(int row, int column) {
        super(row, column);
        this.content = "*";
    }

    /**
     * Returns content of cell.
     * @return content of cell
     */
    public String getContent(){
        return content;
    }

    /**
     * Sets content of cell.
     * @param content content of cell
     */
    public void setContent(String content){
        this.content = content;
    }
}
