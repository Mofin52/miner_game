package ru.avelikorechin.miner.minerUI;

import ru.avelikorechin.miner.StartUI;
import ru.avelikorechin.miner.cells.Cell;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;

import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

/**
 * Contoller of interface for miner game.
 * @author Alexander Velikorechin
 * @since 18.11.2017
 */
public class UIController {

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
    private CellView[][] cellsView;
    /**
     * Numbers of flags set correctly.
     */
    private int correctFlags = 0;
    /**
     * Number of cells left.
     */
    private int cellsLeft = StartUI.CELLS_ON_BOARD;
    /**
     * Constructor of UI class.
     * @param cellWidth width of cell
     * @param cellHeight height of cell
     * @param cells cells array
     */
    public UIController(final int cellWidth, final int cellHeight, final Cell[][] cells) {
        this.cellWidth = cellWidth;
        this.cellHeight = cellHeight;
        this.cells = cells;
        this.cellsView = new CellView[cells.length][cells[0].length];
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

                CellView label = new CellView();
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
    public void redrawCellImage(String state, String content, CellView cellView) {
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
     * Method invokes when we player fails to find the bombs.
     * First in opens all the cells
     * Then in removes mouse listener from their graphical model to make them inactive
     * Finally the message "Game over" is shown
     */
    public void gameOver() {
        for (Cell[] cellRow : cells) {
            for (Cell cell : cellRow) {
                discloseCell(cell);
                deactivateCell(cell);
            }
        }
        showGameMessage("GAME OVER");
    }

    /**
     * Method that is called when player wins the game.
     */
    public void gameWon() {
        for (Cell[] cellRow : cells) {
            for (Cell cell: cellRow) {
                deactivateCell(cell);
            }
        }
        showGameMessage("YOU DID IT! WELL DONE, BUDDY!");
    }

    /**
     * Method shows given cells.
     * @param cell cell to open
     */
    private void discloseCell(final Cell cell) {
        redrawCellImage("opened", cell.getContent(), cellsView[cell.getRow()][cell.getColumn()]);
    }

    /**
     * Method removes action listener from given cell.
     * @param cell cell to remove action listener from
     */
    private void deactivateCell(final Cell cell) {
        CellView cellView = cellsView[cell.getRow()][cell.getColumn()];
        MouseListener listener = cellView.getMouseListeners()[0];
        cellView.removeMouseListener(listener);
    }

    /**
     * Method shows message dialog with given message.
     * @param message message to show
     */
    private void showGameMessage(final String message) {
        JOptionPane.showMessageDialog(null, message);
    }
    /**
     * Getter for JLabels array.
     * @return array of JLabels
     */
    public final CellView[][] getCellsView() {
        return this.cellsView;
    }
    /**
     * Getter for cells.
     * @return array of cells
     */
    public final Cell[][] getCells() {
        return this.cells;
    }

    /**
     * Getter for number of correct flags.
     * @return
     */
    public final int getCorrectFlags() {
        return this.correctFlags;
    }

    /**
     * Setter for number of correct flags.
     */
    public final void setCorrectFlags(int newCorrectFlags) {
        this.correctFlags = newCorrectFlags;
    }

    /**
     * Getter for number of cells left on board unopened.
     * @return number of cells left on board
     */
    public final int getCellsLeft() {
        return this.cellsLeft;
    }

    /**
     * Setter for number of cells left on board unopened.
     * @param newCellsLeft new number of cells left on board
     */
    public final void setCellsLeft(int newCellsLeft) {
        this.cellsLeft = newCellsLeft;
    }

}
