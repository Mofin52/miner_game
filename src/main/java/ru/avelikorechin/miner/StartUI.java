package ru.avelikorechin.miner;

import ru.avelikorechin.miner.minerUI.BasicUI;

/**
 * Class responsible for game launch.
 * @author Alexander Velikorechin
 * @since 11.11.2017
 */
public class StartUI {
    public static void main(String[] args) {
        Board board = new Board(10, 10, 10);
        board.fillBoard();
        for (int i = 0; i < board.getCells().length; i++) {
            System.out.print(i+": ");
            for (int j = 0; j < board.getCells()[i].length; j++){
                String content = board.getCells()[i][j].getContent();
                content = content.equals("") ? " " : content;
                System.out.print(content);
            }
            System.out.println();
        }
        System.out.println("*****************");
        BasicUI ui = new BasicUI(16, 16, board.getCells());
        ui.initUi();
    }
}
