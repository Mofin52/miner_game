package ru.avelikorechin.miner.minerUI;

import ru.avelikorechin.miner.cells.Cell;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.plaf.IconUIResource;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;

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
     */
    public void initUi() {
        JFrame frame = new JFrame("Minesweeper Game");
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        drawFrame(frame);
        frame.getContentPane().setPreferredSize(new Dimension(cellHeight*cells[0].length, cellWidth*cells.length));
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.pack();

    }

    private void drawFrame(JFrame frame){
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                Image image = null;
                try {
                    File url = new File("src\\main\\java\\ru\\avelikorechin\\miner\\minerUI\\resources\\hidden.png");
                    image = ImageIO.read(url);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                JLabel label = new JLabel(new ImageIcon(image));
                label.setBounds(cellWidth*j,cellHeight*i,cellWidth,cellHeight);
                label.setBackground(Color.BLACK);
                label.setVisible(true);
                frame.getContentPane().add(label);
            }
        }
    }
}
