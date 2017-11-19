package ru.avelikorechin.miner.minerUI;

import ru.avelikorechin.miner.cells.Cell;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;

import java.io.File;
import java.io.IOException;

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
     * Storage of JLabels representing cells.
     */
    private CellModel[][] cellsView;
    /**
     * Constructor of UI class.
     * @param cellWidth width of cell
     * @param cellHeight height of cell
     * @param cells cells array
     */
    public BasicUI(final int cellWidth, final int cellHeight, final Cell[][] cells) {
        this.cellWidth = cellWidth;
        this.cellHeight = cellHeight;
        this.cells = cells;
        this.cellsView = new CellModel[cells.length][cells[0].length];
    }

    /**
     * Method to init user interface.
     */
    public final void initUi() {
        JFrame frame = new JFrame("Minesweeper Game");
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        drawFrame(frame);
        frame.getContentPane().setPreferredSize(
                new Dimension(cellHeight * cells[0].length, cellWidth * cells.length)
        );
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.pack();

    }

    /**
     * Method to draw cells on frame.
     * @param frame frame where to add cells
     */
    private void drawFrame(final JFrame frame) {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                Image image = null;
                try {
                    File url = new File("src\\main\\java\\ru\\avelikorechin\\miner\\minerUI\\resources\\hidden.png");
                    image = ImageIO.read(url);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                CellModel label = new CellModel();
                label.setIcon(new ImageIcon(image));
                label.setRow(i);
                label.setColumn(j);
                label.setBounds(cellWidth * j, cellHeight * i, cellWidth, cellHeight);
                label.setBackground(Color.BLACK);
                label.setVisible(true);
                label.addMouseListener(new ClicksListener(this));
                frame.getContentPane().add(label);
                this.cellsView[i][j] = label;
            }
        }
    }
    /**
     * Method to redraw cell icon.
     * @param state new state of cell
     * @param content content of cell
     * @param cellView view of cell
     */
    public void redrawCellImage(String state, String content, CellModel cellView) {
        Image image = null;
        String imgPath = "src\\main\\java\\ru\\avelikorechin\\miner\\minerUI\\resources\\";
        String fileName = !state.equals("opened") ? state : state + content;
        try {
            File url = new File(imgPath + fileName + ".png");
            image = ImageIO.read(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        cellView.setIcon(new ImageIcon(image));
    }

    /**
     * Getter for JLabels array.
     * @return array of JLabels
     */
    public final CellModel[][] getCellsView() {
        return this.cellsView;
    }
    /**
     * Getter for cells.
     * @return array of cells
     */
    public final Cell[][] getCells() {
        return this.cells;
    }
}
