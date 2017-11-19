package ru.avelikorechin.miner;

import ru.avelikorechin.miner.minerUI.BasicUI;

/**
 * Class responsible for game launch.
 * @author Alexander Velikorechin
 * @since 11.11.2017
 */
public class StartUI {
    /**
     * Const for num of rows on board.
     */
    private static final int ROWS = 10;
    /**
     * Const for num of columns on board.
     */
    private static final int COLUMNS = 10;
    /**
     * Const for num of bombs on board.
     */
    private static final int BOMBS = 10;
    /**
     * Const for cell width.
     */
    private static final int CELL_WIDTH = 16;
    /**
     * Const for cell height.
     */
    private static final int CELL_HEIGHT = 16;
    /**
     * Starting point of app.
     * @param args arguments array
     */
    public static void main(String[] args) {
        Board board = new Board(ROWS, COLUMNS, BOMBS);
        board.fillBoard();
        for (int i = 0; i < board.getCells().length; i++) {
            System.out.print(i + ": ");
            for (int j = 0; j < board.getCells()[i].length; j++) {
                String content = board.getCells()[i][j].getContent();
                content = content.equals("") ? " " : content;
                System.out.print(content);
            }
            System.out.println();
        }
        BasicUI ui = new BasicUI(CELL_WIDTH, CELL_HEIGHT, board.getCells());
        ui.initUi();
    }
}
