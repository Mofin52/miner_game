package ru.avelikorechin.miner;

import ru.avelikorechin.miner.minerUI.BasicUI;

/**
 * Class responsible for game launch.
 */
public class StartUI {
    public static void main(String[] args) {
        Board board = new Board(10, 10, 5);
        board.fillBoard();
        for (int i = 0; i < board.getCells().length; i++) {
            System.out.print(i+": ");
            for (int j = 0; j < board.getCells()[i].length; j++){
                System.out.print(board.getCells()[i][j].getContent());
            }
            System.out.println();
        }
        System.out.println("*****************");
        BasicUI ui = new BasicUI(16, 16, board.getCells());
        ui.initUi();
    }
}
