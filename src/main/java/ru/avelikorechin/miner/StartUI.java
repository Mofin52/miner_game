package ru.avelikorechin.miner;

import ru.avelikorechin.miner.minerUI.UIController;

/**
 * Class responsible for game launch.
 * @author Alexander Velikorechin
 * @since 11.11.2017
 */
public class StartUI {
    /**
     * Const for cell width.
     */
    public static final int CELL_WIDTH = 16;
    /**
     * Const for cell height.
     */
    public static final int CELL_HEIGHT = 16;
    /**
     * Const for num of bombs on board.
     */
    public static final int BOMBS = 5;
    /**
     * Const for num of rows on board.
     */
    public static final int ROWS = 10;
    /**
     * Const for num of columns on board.
     */
    public static final int COLUMNS = 10;
    /**
     * Const for num of cells on board.
     */
    public static final int CELLS_ON_BOARD = ROWS * COLUMNS;
    /**
     * Starting point of app.
     * @param args arguments array
     */
    public static void main(String[] args) {
        Board board = new Board(ROWS, COLUMNS, BOMBS);
        board.fillBoard();
        UIController ui = new UIController(CELL_WIDTH, CELL_HEIGHT, board.getCells());
        ui.initUi();
    }
}
